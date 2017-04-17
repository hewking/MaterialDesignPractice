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
<style type="text/css">
.single-cat{
  margin: 10px;
}
</style>
 <div id="edit-cat" class="modal hide fade">
  <!-- 编辑框 -->
  <div class="cat-edit">
      <div class="modal-header">
      <h4>转让项目</h4>
      </div>
      <input type="hidden" id="item_id" value="<?php echo ($item_id); ?>">
      <div class="add-cat">
          <form class="form-horizontal">
            <div class="control-group">
              <label class="control-label" for="inputEmail">用户名</label>
              <div class="controls">
                <input type="text" id="username" placeholder="项目接收者用户名" value="">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputEmail">验证身份</label>
              <div class="controls">
                <input type="password" id="password" placeholder="你的登录密码" value="">
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <button type="submit" class="btn" id="save-cat">转让</button>
              </div>
            </div>
          </form>

      </div>
    </div>

    <div class="modal-footer">
      <a href="#" class="btn exist-cat">关闭</a>
    </div>
 </div>

    
	<script src="/Public/js/common/jquery.min.js"></script>
    <script src="/Public/bootstrap/js/bootstrap.min.js"></script>
    <script src="/Public/js/common/showdoc.js"></script>
  </body>
</html> 
 <script src="/Public/js/attorn/index.js"></script>