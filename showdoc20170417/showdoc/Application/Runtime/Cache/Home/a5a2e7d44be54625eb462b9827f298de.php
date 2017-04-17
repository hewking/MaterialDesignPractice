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
<link href="/Public/highlight/default.min.css" rel="stylesheet"> 
<script src="/Public/highlight/highlight.min.js"></script> 

<style type="text/css">
body{
	overflow-x:hidden;overflow-y:hidden
}

</style>
<!-- 这里开始是内容 -->

<div class="" style="padding-top:10px;">

<?php echo ($page["page_content"]); ?>

</div>

<div id="someId">
<input type="hidden" id="pageid" value="<?php echo ($pageid); ?>" />
<a href="<?php echo U('item/param_index',array('pageid'=>$pageid));?>" target="_blank">使用网页调试工具调试接口</a><br><br>
</div>
<div id="sometable" style="display: none;">
	<table id="param">
		<thead>
        <tr>
            <th>Param</th>
            <th>Value</th>
        </tr>
        </thead>
        <tbody>
		<?php if(is_array($paramList)): foreach($paramList as $key=>$v): ?><tr>
                <td><input type="text" name="param[]" value="<?php echo ($v["params"]); ?>" /></td>
                <td><input type="text" name="val[]" value="<?php echo ($v["values"]); ?>" /></td>
            </tr><?php endforeach; endif; ?>

		</tbody>
	</table>
</div>


   
	<script src="/Public/js/common/jquery.min.js"></script>
    <script src="/Public/bootstrap/js/bootstrap.min.js"></script>
    <script src="/Public/js/common/showdoc.js"></script>
  </body>
</html> 
<script src="/Public/js/page/index.js"></script>
<script type="text/javascript">
$(function(){
	var length = $("#sometable tr").length;
	//console.log(length);
	var str = '<tr><td><input type="text" name="param[]"  /></td>'+
              '<td><input type="text" name="val[]"  /></td></tr>';
	for(var i= 0;i < (8-length);i++){
		$("#param tbody").append(str);
	}

	var footer = '<tr><td colspan="3" align="center">'+
                 '<input id="pageid" name="page_id" type="hidden" value="<?php echo ($pageid); ?>" />'+
                 '<input id="btnok" type="submit" value="确定" /></td></tr>';
    $("#param tbody").append(footer);         
})
</script>