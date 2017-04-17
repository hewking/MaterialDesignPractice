<?php
namespace Home\Controller;
use Think\Controller;
class ItemController extends BaseController {
	//项目列表页
    public function index(){
    	$login_user = $this->checkLogin();
    	$items  = D("Item")->where("uid = '$login_user[uid]' or item_id in ( select item_id from item_member where uid = '$login_user[uid]' ) ")->select();

        $this->assign("items" , $items);
    	$this->assign("login_user" , $login_user);
        $this->display();
    }

    //新建项目
    public function add(){
    	$login_user = $this->checkLogin();
        $item_id = I("item_id/d");
		if (!IS_POST) {
          $item = D("Item")->where("item_id = '$item_id' ")->find();
          $this->assign("item" , $item);
		  $this->display ();

		}else{
			$item_name = I("item_name");
            $password = I("password");
			$item_description = I("item_description");
            $domain = I("domain");
            if ($item_id > 0 ) {
                $data = array(
                    "item_name" => $item_name ,
                    "password" => $password ,
                    "item_description" => $item_description ,
                    "domain"    => $domain,
                    );
                $ret = D("Item")->where("item_id = '$item_id' ")->save($data);
            }else{
                $insert = array(
                    "uid" => $login_user['uid'] ,
                    "username" => $login_user['username'] ,
                    "item_name" => $item_name ,
                    "password" => $password ,
                    "item_description" => $item_description ,
                    "addtime" =>time()
                    );
                $ret = D("Item")->add($insert);
            }

			if ($ret) {
				$this->message("操作成功！",U('Home/Item/index'));		        
			}else{
				$this->message("操作失败！",U('Home/Item/index'));
			}
		}
    }

    //展示单个项目
    public function show(){
        $this->checkLogin(false);
        $item_id = I("item_id/d");
        $keyword = I("keyword");
        $login_user = session("login_user");
        $uid = $login_user['uid'] ? $login_user['uid'] : 0 ;

        $this->checkItemVisit($uid , $item_id);


        $item = D("Item")->where("item_id = '$item_id' ")->find();

        //是否有搜索词
        if ($keyword) {
            $keyword = mysql_escape_string($keyword);
            $pages = D("Page")->where("item_id = '$item_id' and ( page_title like '%{$keyword}%' or page_content like '%{$keyword}%' ) ")->order(" `order` asc  ")->select();
        
        }else{
            //获取所有父目录id为0的页面
            $pages = D("Page")->where("cat_id = '0' and item_id = '$item_id' ")->order(" `order` asc  ")->select();
            //获取所有目录
            $where['item_id'] = $item_id;
            $where['pid'] = 0;
            $catalogs = D("Catalog")->where($where)->order(" `order` asc  ")->select();

            if ($catalogs) {
                foreach ($catalogs as $key => &$catalog) {
                    $cata = D("Catalog")->where(array('pid' => $catalog['cat_id']))->order(" `order` asc  ")->select();

                    if($cata){
                        foreach ($cata as $k => &$v){
                            $temp = D("Page")->where(array(cat_id => $v['cat_id']))->order(" `order` asc  ")->select();
                            $v['pages'] = $temp ? $temp: array();
                        }
                    }

                    $temp = D("Page")->where("cat_id = '$catalog[cat_id]' ")->order(" `order` asc  ")->select();
                    $catalog['pages'] = $temp ? $temp: array();

                    $catalogs[$key]['child'] = $cata;
                }
            }
        }


        $share_url = get_domain().__APP__.'/'.$item_id;

        $ItemPermn = $this->checkItemPermn($uid , $item_id) ;

        $ItemCreator = $this->checkItemCreator($uid , $item_id);



        $this->assign("keyword" , $keyword);
        $this->assign("ItemPermn" , $ItemPermn);
        $this->assign("ItemCreator" , $ItemCreator);
        $this->assign("share_url" , $share_url);
        $this->assign("catalogs" , $catalogs);
        $this->assign("pages" , $pages);
        $this->assign("item" , $item);
        $this->assign("login_user" , $login_user);
    	$this->display();
    }

    //删除项目
    public function delete(){
        $item_id =  I("item_id");
        $login_user = $this->checkLogin();
        if (!$this->checkItemCreator($login_user['uid'] , $item_id)) {
            $this->message("你无权限");
            return;
        }
        $this->assign("item_id" , $item_id);
        $this->display(); 
    }

    //删除项目
    public function ajaxDelete(){
        $login_user = $this->checkLogin();

        $item_id = I("item_id/d");
        $password = I("password");

        $item  = D("Item")->where("item_id = '$item_id' ")->find();

        if(! D("User")-> checkLogin($item['username'],$password)){
            $return['error_code'] = 10102 ;
            $return['error_message'] = '密码错误' ;
            $this->sendResult($return);
            return ;
        }


        D("Page")->where("item_id = '$item_id' ")->limit(1000)->delete();
        D("Catalog")->where("item_id = '$item_id' ")->limit(100)->delete();
        D("PageHistory")->where("item_id = '$item_id' ")->limit(1000)->delete();
        $return = D("Item")->where("item_id = '$item_id' ")->limit(1)->delete();

        if (!$return) {
            $return['error_code'] = 10103 ;
            $return['error_message'] = 'request  fail' ;
        }

        $this->sendResult($return);
    }

    //输入访问密码
    public function pwd(){
        $item_id = I("item_id/d");
        if (!IS_POST) {
          $this->assign("item_id" , $item_id);
          $this->display ();

        }else{
          $password = I("password");
          $v_code = I("v_code");
          //if ($v_code && $v_code == session('v_code')) {
            $item = D("Item")->where("item_id = '$item_id' ")->find();
            if ($item['password'] == $password) {
                session("visit_item_".$item_id , 1 );
                header("location:".U("Home/item/show").'?item_id='.$item_id);
            }else{
                
                $this->message("访问密码不正确");
            }

          //}else{
          //  $this->message("验证码不正确");
          //}

        }
    }

    //导出word
    public function word(){
        import("Vendor.Parsedown.Parsedown");
        $Parsedown = new \Parsedown();
        $item_id =  I("item_id/d");
        $login_user = $this->checkLogin();
        if (!$this->checkItemPermn($login_user['uid'] , $item_id)) {
            $this->message("你无权限");
            return;
        }

        $item = D("Item")->where("item_id = '$item_id' ")->find();
        //获取所有父目录id为0的页面
        $pages = D("Page")->where("cat_id = '0' and item_id = '$item_id' ")->order(" `order` asc  ")->select();
        //获取所有目录
        $catalogs = D("Catalog")->where("item_id = '$item_id' ")->order(" `order` asc  ")->select();
        if ($catalogs) {
            foreach ($catalogs as $key => &$catalog) {
                $temp = D("Page")->where("cat_id = '$catalog[cat_id]' ")->order(" `order` asc  ")->select();
                $catalog['pages'] = $temp ? $temp: array();
            }
        }

        $data = '';
        $parent = 1;

        if ($pages) {
            foreach ($pages as $key => $value) {
                $data .= "<h1>{$parent}、{$value['page_title']}</h1>";
                $data .= '<div style="margin-left:20px;">';
                    $data .= htmlspecialchars_decode($Parsedown->text($value['page_content']));
                $data .= '</div>';
                $parent ++;
            }
        }
        //var_export($catalogs);
        if ($catalogs) {
            foreach ($catalogs as $key => $value) {
                $data .= "<h1>{$parent}、{$value['cat_name']}</h1>";
                $data .= '<div style="margin-left:20px;">';
                    $child = 1 ;
                    if ($value['pages']) {
                        foreach ($value['pages'] as $page) {
                            $data .= "<h2>{$parent}.{$child}、{$page['page_title']}</h2>";
                            $data .= '<div style="margin-left:20px;">';
                                $data .= htmlspecialchars_decode($Parsedown->text($page['page_content']));
                            $data .= '</div>';
                            $child ++;
                        }
                    }
                $data .= '</div>';
                $parent ++;
            }
        }

        output_word($data,$item['item_name']);
    }

    //添加测试参数
    public function param_add(){
        //print_r($_POST);EXIT;
        $page_id = I('post.page_id',0);
        $param  =  I('post.param','');
        $value  =  I('post.val','');

        if(!empty($page_id)){
            if(!empty($param) && !empty($value)){
                $param = array_filter($param);
                //$value = array_filter($value);
                $param_str = implode(",",$param);
                $value_str = implode(",",$value);

                $data['pageid'] = $page_id;
                $data['param']  = $param_str;
                $data['value']  = $value_str;
                $data['crtime'] = time();
                $pageList = M('page')->field('item_id')->where(array('page_id' => $page_id))->find();
                if($pageList){
                    $paramList = M('page_param')->where(array('pageid' => $page_id))->find();
                    if(empty($paramList)){
                        echo '插入';
                        M('page_param')->data($data)->add();
                    }else{
                        echo '更新';
                        M('page_param')->where(array('id' => $paramList['id']))->save($data);
                    }
                    //$this->success("保存成功",U('Home/item/show').'?page_id='.$page_id.'&item_id='.$pageList['item_id']);
                    //header("location:".U("Home/item/show").'?item_id='.$pageList['item_id']);
                }else{
                    $this->message("接口不存在");
                }
                
            }else{
                $this->message("参数不能为空");
            }
        }else{
            $this->message("pageid错误");
        }
    }

    //api测试工具页面
    public function param_index(){
        $page_id = I('get.pageid',0);
        $where['pageid'] = $page_id;
        $paramList = M('page_param')->where($where)->find();
        if($paramList){
            $param = $paramList['param'];
            $value = $paramList['value'];

            $param_arr = explode(',', $param);
            $value_arr = explode(',', $value);

            foreach ($param_arr as $k => $val) {
                $result[$k]['param'] = $val;
                $result[$k]['value'] = $value_arr[$k];
            }

            $this->assign('list',$result);
        }
        $pageList = M('page')->field('item_id')->where(array('page_id'=>$page_id))->find();
        $itemList = M('item')->field('domain')->where(array('item_id'=>$pageList['item_id']))->find();
        $this->assign('domain',$itemList['domain']);
        $this->display("testapi");
    }

    //获取测试api
    public function curl_content(){
        //$url = "http://192.168.1.45/index.php/api/index/checkAccount";
        $req_type  = I('post.type','');
        $req_url   = I('post.url','');
        $param_arr = I('post.param', '');
        $value_arr = I('post.value', '');

        $result = array();
        if($req_type == 'POST' || $req_type == 'post'){
            $param_arr = array_filter($param_arr);
            //$value_arr = array_filter($value_arr);
            
            for($i=0;$i<count($param_arr);$i++){
                $result[$param_arr[$i]] = $value_arr[$i];  
            }

            
        }
        //print_r($result);exit;
        $json_content = curl_post($req_url,$result);
        
        echo $json_content;
    }
	
	//复制项目
    public function copyItem(){
    	$login_user = $this->checkLogin();
        $item_id = I("item_id");
		if (!IS_POST) {
		  $this->assign("item_id" , $item_id);
		  $this->display ();
		}else{
			$item_name = I("item_name");
            $password = I("password");
			$item_description = I("item_description");
            $domain = I("domain");
            $insert = array(
                "uid" => $login_user['uid'] ,
                "username" => $login_user['username'] ,
                "item_name" => $item_name ,
                "password" => $password ,
                "item_description" => $item_description ,
                "addtime" =>time()
            );
			$ret = D("Item")->add($insert);
            $this->_copyCatalog($item_id,$ret);
			if ($ret) {
				$this->message("操作成功！",U('Home/Item/index'));		        
			}else{
				$this->message("操作失败！",U('Home/Item/index'));
			}
		}
    }
	//复制目录
	private function _copyCatalog($item_id,$copy_item_id){
		$catalog = D("Catalog")->where("item_id = '$item_id'")->order('cat_id')->select();
		$catelog_id_old = array();
		if($catalog){ 
			foreach($catalog as $row){
				$insert = array(
					"cat_name" => $row['cat_name'] ,
					"item_id" => $copy_item_id ,
					"pid" => $row['pid'] == 0 ? 0 : $catelog_id_old[$row['pid']],
					"order" => $row['order'] ,
					"addtime" =>time()
				);
				$new_catelog_id = D("Catalog")->add($insert);
				$catelog_id_old[$row['cat_id']] = $new_catelog_id;
			}
		}
		$this->_copyPage($item_id,$copy_item_id,$catelog_id_old);
		return true;
	}
	//复制页面
	private function _copyPage($item_id, $copy_item_id,$catelog_id_old){
		$login_user = $this->checkLogin();
		$pages = D("Page")->where("item_id = '{$item_id}'" )->select();
		foreach($pages as $page){
			$insert = array(
				"author_uid" => $login_user['uid'] ,
				"author_username" => $login_user['username'] ,
				"item_id" => $copy_item_id,
				"cat_id" => $page['cat_id'] == 0 ? 0 :$catelog_id_old[$page['cat_id']] ,
				"page_title" => $page['page_title'],
				"page_content" => $page['page_content'],
				"order" => $page['order'],
				"addtime" =>time()
			);
			$page_id = D("Page")->add($insert);
		}
		return true;
	}
}