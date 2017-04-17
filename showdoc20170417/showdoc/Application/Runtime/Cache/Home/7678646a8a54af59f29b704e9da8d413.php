<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<!--[if lt IE 9]><html class="ie"><![endif]-->
<html class="expanded" lang="zh">
<head>
<meta charset="UTF-8">
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<![endif]-->
<title>API调试工具_API Store</title>
<meta name="keywords" content="API调试工具，API，调试工具，开发者服务，SDK" />
<meta name="description" content="API调试工具可以帮助开发者快速了解并使用API，大大提高学习效率。" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="baidu-site-verification" content="rUUhM5fu05" />
<meta name="mobile-agent" content="format=xhtml;url=http://m.apistore.baidu.com/" />
<link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.apistore.baidu.com/" >
<!--[if lt IE 10]>
<script type="text/javascript" src="/static/ie/html5shiv.js"></script>
<![endif]-->
<!--[if lt IE 10]>
<script type="text/javascript" src="/static/ie/placeholders.jquery.min.js" defer></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/Public/css/tool/style_css.css"/>
<link rel="stylesheet" type="text/css" href="/Public/css/tool/jquery.autocomplete_ea49a9e.css"/>
<link rel="stylesheet" type="text/css" href="/Public/css/tool/httpproxy_1e0e0d7.css"/>
<link rel="stylesheet" type="text/css" href="/Public/css/tool/codemirror.all_6afa3c4.css"/>
<script type="text/javascript" src="/Public/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function(){
    var length = $(".params-table tr").length;
    console.log(length);
    var  tr = '<tr><td class="col-1">'+
    '<input type="text" name="param" value="<?php echo ($v["param"]); ?>" class="form-input" maxlength="100">'+
    '</td><td class="col-2 clearfix">'+
    '<input type="text" name="value" value="<?php echo ($v["value"]); ?>" class="form-input fl" style="width: 260px;" maxlength="5000">'+
    '<span class="fl ml10 mt5 param-desc"></span></td></tr>';

    for(var i=0;i<9-length;i++){
        $(".params-table tbody").append(tr);
    }

    //获取参数值
    $("#js-req-method").change(function(){
        var req_type = $(this).val();
        $("#js-res-header").text();
        if(req_type == 'POST'){
            $("#js-params-block").css("display","block");
        }else{
            $("#js-params-block").css("display","none");
        }
    })

    /*$("#js-submit-btn").click(function(){
        var req_type = $("#js-req-method").val();
        var req_url = $("#js-req-url").val();
        $.ajax({
            type : 'POST',
            url  : req_url,
            data : '',
            success:function(data){
                $("#js-res-header").text(data);
            }
        })
    }) */
    //发送数据
    $("#js-submit-btn").click(function(){
        var req_type = $("#js-req-method").val();
        var req_url = $("#js-req-url").val();
        //if(req_type == 'POST'){
        var param_arr = new Array();
        var value_arr = new Array();
        $("input[name='param']").each(function(){
            param_arr.push($(this).val());
        })

        $("input[name='value']").each(function(){
            value_arr.push($(this).val());
        })
        
        $.ajax({
            type: 'post',
            url : "<?php echo U('item/curl_content');?>",
            data : {type:req_type,url:req_url,param:param_arr,value:value_arr},
            success:function(data){
                //console.log(data);
                $("#js-res-header").html(data);
            },
        });
        
        //console.log(param_arr);
        //console.log(value_arr);
    }) 
})
</script>
</head>
<body>
<section class="pr" style="z-index: 1;">

<section id="js-tools-block" class="tools-block tools-httpproxy main">
<h1 class="tools-title">
<span class="tools-name">API调试工具</span>
</h1>
<div id="js-form-error" class="form-item form-item-error error mt10"></div>
<div class="form-item mb20 clearfix">该项目测试域名:&nbsp;&nbsp;&nbsp;
<?php if($domain == '' ): ?>该项目暂无测试域名<?php else: echo ($domain); endif; ?></div>
<div class="form-item mb20 clearfix">
<select id="js-req-method" class="form-select fl mr10">
<option value="GET" selected="">GET</option>
<option value="POST">POST</option>
<!--
<option value="PUT">PUT</option>
<option value="PATCH">PATCH</option>
<option value="DELETE">DELETE</option>
<option value="COPY">COPY</option>
<option value="HEAD">HEAD</option>
<option value="OPTIONS">OPTIONS</option>
<option value="LINK">LINK</option>
<option value="UNLINK">UNLINK</option>
<option value="PURGE">PURGE</option>
-->
</select>
<input type="text" id="js-req-url" class="form-input input-long req-url-input fl mr10" placeholder="请输入请求地址" maxlength="500">
<span id="js-submit-btn" class="opt-btn btn-blue fl" >发送</span>

</div>

<div id="js-params-block" class="params-block dn">
<ul class="params-type-list clearfix">
<li class="params-type-item active" data-type>Body Parameter Form<i></i></li>
<!--
<li class="params-type-item" data-type>Body Paramter JSON Object<i></i></li>
<li class="params-type-item" data-type>Body Paramter XML<i></i></li>
-->
</ul>
<section>
<section data-body-param>
<table class="params-table js-params-table">
<thead>
<th class="col-1">Body Parameter Key</th>
<th class="col-2">Value</th>
</thead>
<tbody>
<?php if(is_array($list)): foreach($list as $key=>$v): ?><tr>
<td class="col-1">
<input type="text" name="param" value="<?php echo ($v["param"]); ?>" class="form-input" maxlength="100">
</td>
<td class="col-2 clearfix">
<input type="text" name="value" value="<?php echo ($v["value"]); ?>" class="form-input fl" style="width: 260px;" maxlength="5000">
<!--<span class="btn-del js-del fl ml10">X</span>-->
<span class="fl ml10 mt5 param-desc"></span>
</td>
</tr><?php endforeach; endif; ?>
</tbody>
</table>
<!--<span class="js-add-param opt-btn btn-green mt10 mb20">添加</span>-->
<span class="js-add-param opt-btn btn-green mt10 mb20">返回示例</span>
</section>
<section class="mb20 dn" data-body-param>
<textarea id="body-param" style="width: 1059px;"></textarea>
</section>
</section>
</div>
<table id="js-http-block" class="http-block">
<thead>
<!--<th class="col-1">Response Header</th>-->
<th class="col-2">Response Body</th>
</thead>
<tbody>

<tr>

<td class="col-1">
<pre id="js-res-header"></pre>
</td>
<!--
<td class="col-2">
<div id="js-res-body-block" class="res-body-block dn">
<textarea id="js-res-body" class="form-textarea"></textarea>
</div>
</td>-->
</tr>
</tbody>
</table>
</section>
</section>

</html>