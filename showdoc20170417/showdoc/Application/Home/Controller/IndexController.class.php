<?php
namespace Home\Controller;
use Think\Controller;
class IndexController extends BaseController {
    public function index(){
    	$this->checkLogin(false);
    	$login_user = session("login_user");

    	$item_list = D('item')->field('item_id,item_name')->select();
    	$this->assign("login_user" ,$login_user);
    	$this->assign("item_list",$item_list);
        $this->display();
        // $this->redirect('/home/item/show?item_id=2');
    }
}