$(function() {
	M.getimg();
	$("#name-code").on("click",function(e){
		e.preventDefault();
		var phone = $("#mobilePhone").val();
		var timecode = $("#timecode").val();
		var piccode = $("#piccode").val();
		if(phone == ""){
			M.layer("请输入手机号",1000);
		}else{
			$.ajax({
				url:"/restful/sms/sendValidateCode",
				dataType:'json',
				type:"post",
				data:{"mobilePhone":phone,"timecode":timecode,"piccode":piccode},
				success:function(data){
					if(data.success){
						M.VerifyCountdown($("#name-code"));
						M.layer("发送成功",1000);

					}else if(data.code== 100005){
						M.layer("验证码错误！",1000);
					}
					else if(data.code== 100006){
						M.layer("验证码20分钟内有效！",1000);
					}
					
					
				}
			})
		}
		
	})
	// 图文验证码
	$('.imgcode').on("click",function(e){
		e.preventDefault();
		M.getimg();
	})
	// 图片上传
	M.simpleUpload("#facade_imange",function(data){
		var picUrl = data.data;
		var tpl = "";
		for(var i=0 ;i<picUrl.length;i++){
			tpl += '<div class="card-img"><img src='+picUrl[i]+'>\
			<em></em><input type="hidden" name="facade_imange" value="'+picUrl[i]+'" /></div>';
		};

		$(".positive").append($(tpl));
	})
	M.simpleUpload("#negative_image",function(data){
		var picUrl = data.data;
		var tpl = "";
		for(var i=0 ;i<picUrl.length;i++){
			tpl += '<div class="card-img"><img src='+picUrl[i]+'><em></em><input type="hidden" name="negative_image" value="'+picUrl[i]+'" /></div>';
		};
		$(".otherPic").append($(tpl));
	})
	M.simpleUpload("#hand_image",function(data){
		var picUrl = data.data;
		var tpl = "";
		for(var i=0 ;i<picUrl.length;i++){
			tpl += '<div class="card-img"><img src='+picUrl[i]+'><em></em><input type="hidden" name="hand_image" value="'+picUrl[i]+'" /></div>';
		};
		$(".handimg").append($(tpl));
	})
	$(document).on("click",".card-img em",function(){
		$(this).parent().remove();
	});
	$("#agree").change(function(){
		if($(this).is(':checked')){
			$(this).siblings().attr("src","assets/images/btn_check_s@2x.png")
		}else{
			$(this).siblings().attr("src","assets/images/btn_check_n@2x.png")
		}
	});
	// 紧急人关系选择
	var ship = {
		"shiplist":[],
		"haschange":"",
		"listNum":"",
		"changeText":"",
		"changeobj":"",
		"parameter":'',
		"labelbox":'',
		init:function(){
			var _this = this;
			$(document).on("click",".ship-change",function(){
				_this.shiplist = [];
				_this.changeobj = $(this).find("p");
				_this.labelbox = $(this).closest("li");
				_this.parameter = $(this).find("input");
				$(".ship-box ul").empty()
				_this.listNum = $(this).data("num");
				_this.changeText = $(this).data("ship");
				if(_this.listNum == "0"){
					_this.shiplist=["父亲","母亲"];
					_this.Each();
				}else if(_this.listNum == "1"){
					_this.shiplist=["父亲","母亲","配偶","亲属","朋友","同学","同事","老乡"];
					_this.Each();
				}else if(_this.listNum == "2"){
					_this.shiplist=["大专以下","大专","本科","硕士研究生","博士研究生"];
					_this.Each();
				}else if(_this.listNum == "3"){
					_this.shiplist=["全日制","自考","成考","远程","函授"];
					_this.Each();
				}
			});
			$(document).on("click",".cancel",function(){
				_this.cancel();
			});
			_this.change();
		},
		Each:function(){
			var ship_change = $(".ship-change");
			var tpl = "";
			var arr=[];
			tpl = '<div class="ship-info"><div class="ship-box"><ul>';
			var haslist = $(".ship-change > p");
			for(var i=0;i<haslist.length;i++){
				arr[i]=$(haslist[i]).text();
			}
			for(var i=0;i<this.shiplist.length;i++){
				if(arr.indexOf(this.shiplist[i]) > -1){
					tpl += '<li class="active">'+this.shiplist[i]+'</li>';
				}else{
					tpl += '<li>'+this.shiplist[i]+'</li>';
				}
				
			};
			tpl += '</ul><div class="cancel">取消</div></div></div>';
			$("body").append($(tpl));
		},
		cancel:function(){
			$(".ship-info").remove();
		},
		change:function(){
			var _this = this;
			$(document).on("click",".ship-box ul li",function(){
				if(!$(this).hasClass("active")){
					_this.labelbox.find("label").remove();
					var changelist = $(this).text();
					_this.changeobj.text(changelist);
					_this.parameter.val(changelist);
					console.log(_this.parameter.val());
					_this.changeobj.attr("data-ship",changelist);
					_this.cancel();
				}else{
					M.layer("父亲,母亲,配偶只能选择一次哟",1000);
					_this.cancel();
				}
				
			})
		}
	};
	ship.init();
	
	var num = 0;
	// var tmp = {
	// 		ignore: [],
	// 		debug:true,
	// 		rules:{

	// 			shipOne:{
	// 				required:true,
	// 			},
	// 			shipTwo:{
	// 				required:true,
	// 			},
	// 			shipThere:{
	// 				required:true,
	// 			},
	// 			parentname:{
	// 				required:true,
	// 			},
	// 			parenttwo:{
	// 				required:true
	// 			},
	// 			parentthere:{
	// 				required:true
	// 			},
	// 			phone:{
	// 				required:true,
	// 				isMobile:true,
	// 			},
	// 			phonetwo:{
	// 				required:true,
	// 				isMobile:true,
	// 			},
	// 			phonethere:{
	// 				required:true,
	// 				isMobile:true,
	// 			},
	// 			test1:{
	// 				required:true
	// 			}

	// 		},
	// 		errorPlacement:function(error, element){
	// 			error.appendTo(element.closest("li"));
	// 		},
	// 		messages:{
	// 			shipOne:{
	// 				required:"请输入您父亲或母亲的姓名",
	// 			},
	// 			shipTwo:{
	// 				required:"请选择与本人的关系",
	// 			},
	// 			shipThere:{
	// 				required:"请选择与本人的关系",
	// 			},
	// 			parentname:{
	// 				required:"请输入紧急联系人姓名8",
	// 			},
	// 			parenttwo:{
	// 				required:"请输入紧急联系人姓名2",
	// 			},
	// 			parentthere:{
	// 				required:"请输入紧急联系人姓名3",
	// 			},
	// 			phone:{
	// 				required:"请输入父亲或者母亲的电话"
	// 			},
	// 			phonetwo:{
	// 				required:"请输入联系人的电话"
	// 			},
	// 			phonethere:{
	// 				required:"请输入联系人的电话"
	// 			},
	// 			test1:{
	// 				required:"我只是测试"
	// 			}
				
	// 		},
	// 		"submitHandler": function(form) {
	// 			$(".verify-user ul li label").css("color","red");
	// 			console.log("kkkk")
	// 			var info = $(".show-list");
	// 			var proarr = [];
	// 			for(var i=0;i<info.length;i++){
	// 				proarr.push({
	// 					"relation":$(info[i]).find(".data1").val(),
	// 					"name":$(info[i]).find(".data2").val(),
	// 					"mobilePhone":$(info[i]).find(".data3").val(),
	// 				});
	// 				console.log(proarr);
	// 			}
	// 			var person = JSON.stringify(proarr);  
	// 			$.ajax({
	// 				"url": "/restful/contactPersons",
	// 				"type": "post",
	// 				"dataType": "json",
	// 				data:person,
	// 				"headers": { "authorization": localStorage.getItem("auth_token") },
	// 				contentType: "application/json",
	// 				"success": function (data) {
	// 		            if(data.success){
	// 		            	window.location.href="/stepseven.html";
	// 		            }else{
	// 		            	M.layer("请完善紧急联系人方式",1000);
	// 		            }
	// 				},
	// 				error:function(){
	// 					console.log(this.data);
	// 					console.log("this.data",proarr);
	// 				}
	// 			});
	// 		}
	// 	};
	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var length = value.length;
	    var mobile = /^(13[0-9]{9})|(14[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})$/;
	    return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请输入正确的手机号");
	$(".add-people").on("click",function(){
		num = num+1;
		var tpl = "";
		tpl = '<ul class="show-list">\
					<li class="clearfix">\
						<div class="clearfix info-block">\
							<dd class="con-title">与本人关系</dd>\
							<dd class="change-btn ship-change" data-num="1" data-ship=""><p>请选择与本人的关系[父亲/母亲]</p>\
							<input type="hidden" class="addship_'+num+' data1" value="" name="addship_'+num+'" id="addship_'+num+'" class="data1"></dd>\
							<dd class="city-r">\
								<img src="assets/images/icon_next@2x.png" alt="">\
							</dd>\
						</div>\
					</li>\
					<li class="clearfix">\
						<div class="clearfix info-block">\
							<dd class="con-title">姓名</dd>\
							<dd class="input-box"><input type="text" placeholder="请输入紧急联系人姓名" class="data2 addnick_'+num+'" name="addnick_'+num+'" id="addnick_'+num+'"></dd>\
						</div>\
					</li>\
					<li class="clearfix">\
						<div class="clearfix info-block">\
							<dd class="con-title">手机</dd>\
							<dd class="input-box"><input type="text" placeholder="请输入紧急联系人联系电话" class="data3 addphone'+num+'" name="addphone'+num+'" id="addphone'+num+'"></dd>\
						</div>\
					</li>\
			</ul>';
		$(".user-info").append($(tpl));
		$(".addship_"+num).each(function () {
		    $(this).rules('add', {
		      required: true,
		       messages:{
		       	required: "请选择与本人的关系"
		       }
		    });
		});
		$(".addnick_"+num).each(function () {
		    $(this).rules('add', {
		      required: true,
		       messages:{
		       	required: "请输入紧急联系人姓名"
		       }
		    });
		});
		$(".addphone"+num).each(function () {
		    $(this).rules('add', {
		      required: true,
		      isMobile:true,
		       messages:{
		       	required: "请输入紧急联系人电话"
		       }
		    });
		});
		// var addship = "addship_"+num;
		// var addnick = "addnick_"+num;
		// var addphone = "addphone_"+num;
		// tmp.rules[addship] = {
		// 	required:true,
		// };
		// tmp.rules[addnick] = {
		// 	required:true,
		// };
		// tmp.rules[addphone] = {
		// 	required:true,
		// };
		// console.log("######",tmp);
		// $(".addship_1").rules("add", {
		// 	required: true
		// })
	});
	 // $("#shipInfo").validate();
	 // $(".data1").each(function () {
		//     $(this).rules('add', {
		//       required: true,
		//        messages:{
		//        	required: "请选择与本人的关系"
		//        }
		//     });
		// });
	// $(".contentAjax").on("click",function(e){
	// 	e.preventDefault();
	// 	$(".data1").each(function () {
	// 	    $(this).rules('add', {
	// 	      required: true,
	// 	       messages:{
	// 	       	required: "请选择与本人的关系"
	// 	       }
	// 	    });
	// 	});
	// })

	

	
	
		
	// $("#shipInfo").validate(tmp);

})

