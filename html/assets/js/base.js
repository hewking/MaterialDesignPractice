$(function() {
	var M= {};
	M.VerifyCountdown = function (obj) {

	    (function() {

	        var time = 120;

	        obj.attr("disabled","true");
	        obj.addClass("active").text(time + "S");

	        var timerID = setInterval(function () {

	            obj.text(--time +"S");

	            if (time <= 0) {

	                clearInterval(timerID);
	                obj.removeClass("active").text("获取验证码");
	                obj.removeAttr("disabled");

	            }

	        }, 1000);

	    })();

	};
	M.layer = function (msg,time){
		var tpl = "";
		tpl = '<div class="layer-box">\
				<div class="layer-main">\
					<div class="layui-m-layersection">\
						<div class="layer">'+msg+'</div>\
					</div>\
				</div>\
			</div>';
			$("body").append($(tpl));
		setTimeout(function(){
			$(".layer-box").remove();
		},time);
	};
	M.getimg = function(){
		var time =  Date.parse(new Date());
		$("#timecode").val(time);
		$(".imgcode img").attr("src","restful/imageCode?pageId=userlogin&timecode="+time);
	};
	M.simpleUpload = function (inputSelector, callback) {

	    var $input = $(inputSelector);
	    var fd = new FormData();
	    
	    $input.change(function () {

	        var file = $input.get(0).files[0];
	        fd.append("file", file);
	        $.ajax({
	            "url": "/restful/fileUpload/singleuFilepload",
	            "type": "post",
	            "data": fd,
	            "dataType": "json",
	            "contentType": false,
	            "processData": false
	        }).done(function (data) {

	            if (data.success && callback instanceof Function)
	                callback(data);

	        });

	    });

	};
	M.GetQueryString = function (name)
	    {
	         var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	         var r = window.location.search.substr(1).match(reg);
	         if(r!=null)return  unescape(r[2]); return null;
	    };
    M.tool = {
        //时间戳（秒）
        'timestamp': function () {
            return Math.floor(new Date() / 1000);
        },
        //时间戳（微秒）
        'micrtimestamp': function () {
            return new Date() - 0;
        },

        'shortTimeStr': function (time) {
            if (time) {
                var timeObj = new Date(time * 1000);
            } else {
                var timeObj = new Date();
            }

            var min = timeObj.getMinutes() < 10 ? "0" + timeObj.getMinutes() : timeObj.getMinutes();
            var hours = timeObj.getHours() < 10 ? "0" + timeObj.getHours() : timeObj.getHours();
            var time = hours + ":" + min;
            return time;
        },
        'shortData': function (explode) {
            var expload = explode || '/';
            var timeObj = new Date();


            var year = timeObj.getFullYear();
            var month = timeObj.getMonth() + 1;
            month = month < 10 ? "0" + month : month;

            var day = timeObj.getDate();
            day = day < 10 ? "0" + day : day;

            var time = year + explode + month + explode + day;
            return time;
        },
        'fullTimeStr': function (time) {
            if (time) {
                var timeObj = new Date(time);
            } else {
                var timeObj = new Date();
            }


            var year = timeObj.getFullYear();
            var month = timeObj.getMonth() + 1;
            month = month < 10 ? "0" + month : month;

            var day = timeObj.getDate();
            day = day < 10 ? "0" + day : day;
            var time = year + "-" + month + "-" + day;
            return time;
        },
        'formatTime': function (time) {
            if (time) {
                var timeObj = new Date(time * 1000);
            } else {
                var timeObj = new Date();
            }
            var year = timeObj.getFullYear();
            var month = timeObj.getMonth();
            var day = timeObj.getDate();
            var min = timeObj.getMinutes() < 10 ? "0" + timeObj.getMinutes() : timeObj.getMinutes();
            var hours = timeObj.getHours() < 10 ? "0" + timeObj.getHours() : timeObj.getHours();
            var second = timeObj.getSeconds() < 10 ? "0" + timeObj.getSeconds() : timeObj.getSeconds();
            var time = year + "/" + month + "/" + day + " " + hours + ":" + min + ":" + second;
            return time;
        },
    }
	
	// 
	window.M = M;
})