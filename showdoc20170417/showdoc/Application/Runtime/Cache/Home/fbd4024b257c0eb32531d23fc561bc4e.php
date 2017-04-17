<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>ShowDoc</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="/Public/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    @charset "utf-8";
	body {
		font:14px/1.5 "Microsoft Yahei","微软雅黑",Tahoma,Arial,Helvetica,STHeiti;
	}
    </style>
      <script type="text/javascript">
      var DocConfig = {
          host: window.location.origin,
          app: "<?php echo U('/');?>",
          pubile:"/Public",
      }

      DocConfig.hostUrl = DocConfig.host + "/" + DocConfig.app;
      </script>

  </head>
  <body>
<link rel="stylesheet" href="/Public/css/item/index.css" />
<style type="text/css">
  .container-thumbnails{
    margin-top: 60px;
  }
  .thumbnails li a{
    color: #888;
    font-weight: bold;
  }
  .thumbnails li a:hover,
  .thumbnails li a:focus{
    border-color:#f2f5e9;
    -webkit-box-shadow:none;
    box-shadow:none;
    text-decoration: none;
    background-color: #f2f5e9;
  }
</style>
    <div class="container-narrow">

      <div class="masthead">
        <div class="btn-group pull-right">
        <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
        <?php echo ($login_user["username"]); ?>
        <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
        <!-- dropdown menu links -->
          <li><a href="<?php echo U('Home/User/setting');?>">个人设置</a></li>
          <li><a href="../">网站首页</a></li>
          <li><a href="<?php echo U('Home/User/exist');?>">退出登录</a></li>

        </ul>
        </div>

        </ul>
        <h3 class="muted">ShowDoc</h3>
      </div>

      <hr>

    <div class="container-thumbnails">
      <ul class="thumbnails">

        <?php if(is_array($items)): foreach($items as $key=>$item): ?><li class="span3 text-center">
            <a class="thumbnail" href="show?item_id=<?php echo ($item["item_id"]); ?>" title="<?php echo ($item["item_description"]); ?>">
              <p class="my-item"><?php echo ($item["item_name"]); ?></p>
            </a>
          </li><?php endforeach; endif; ?>

        <li class="span3 text-center">
          <a class="thumbnail" href="<?php echo U('Home/Item/add');?>" title="添加一个新项目">
            <p class="my-item ">新建项目&nbsp;<i class="icon-plus"></i></p>
          </a>
        </li>
      </ul>
    </div>


    </div> <!-- /container -->


    
	<script src="/Public/js/common/jquery.min.js"></script>
    <script src="/Public/bootstrap/js/bootstrap.min.js"></script>
    <script src="/Public/js/common/showdoc.js"></script>
  </body>
</html> 
 <script type="text/javascript">


 </script>