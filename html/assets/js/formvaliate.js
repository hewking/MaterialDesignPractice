$(function() {
	$.validator.setDefaults({
	    submitHandler: function() {
	    }
	});
	// 手机号码验证
	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var length = value.length;
	    var mobile = /^(13[0-9]{9})|(14[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})$/;
	    return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请输入正确的手机号");
	jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
	    var idcard=/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
	    return this.optional(element) || idcard.test(value);     
	}, "请输入身份证号码");
	jQuery.validator.addMethod("isIdCard", function(value, element) { 
	    var idcard=/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
	    return this.optional(element) || idcard.test(value);     
	}, "请输入身份证号码"); 
	jQuery.validator.addMethod("isQQ", function(value, element) { 
	    var idcard=/^\d{5,10}$/;
	    return this.optional(element) || idcard.test(value);     
	}, "请输入正确的QQ号");
	jQuery.validator.addMethod("isBankCard", function(value, element) { 
	    var idcard=/^\d{16}|\d{19}$/;
	    return this.optional(element) || idcard.test(value);     
	}, "请输入正确的储蓄卡账号");
	//绑定手机的验证
	$("#verifyPhone").validate({
		rules:{
			mobilePhone:{
				required:true,
				isMobile:true
			},
			validateCode:{
				required:true,
			},
			piccode:{
				required:true,
			}
		},
		errorPlacement:function(error, element){
			error.appendTo(element.closest("li"));
		},
		messages:{
			mobilePhone:{
				required:"请输入您的手机号",
				isMobile:"请输入正确的手机号"
			},
			validateCode:{
				required:"请输入短信验证码"
			},
			piccode:{
				required:"请输入图形验证码",
			}
		},
		"submitHandler": function(form) {
			$(form).ajaxSubmit({
				"url": "/restful/users",
				"type": "post",
				"dataType": "json",
				"success": function (data) {
		            
		            if(data.success){

		            	var dataMsg = data.data;
		            	for(var i=0;i<dataMsg.length;i++){
		            		var item = dataMsg[i];
		            		var token = item.token;
		            		localStorage.setItem("auth_token", token);
		            		if(item.redirect){
		            			window.location.href = item.redirectUrl;
		            		}else{
		            			var step = item.step;
		            			if (step == "0") {
		            				window.location.href="/steptwo.html";
		            			}else if(step == "1"){
		            				window.location.href="/stepthere.html";
		            			}else if(step == "2"){
		            				window.location.href="/stepfour.html";
		            			}else if(step == "3"){
		            				window.location.href="/stepfive.html";
		            			}else if(step == "4"){
		            				window.location.href="/stepsix.html";
		            			}else if(step == "5"){
		            				window.location.href="/stepseven.html";
		            			}else if(step == "6"){
		            				window.location.href="/myprofile.html";
		            			}
		            			

		            		}
		            	}
		            }else if(data.code == 100005 ){
		            	M.layer("验证码失效,请刷新",1000);
		            }
				},
			});
		}
	});
	//实名认证的验证 
	$("#verifyname").validate({
		rules:{
			real_name:{
				required:true,
			},
			card_number:{
				required:true,
				isIdCardNo:true
			},
		},
		errorPlacement:function(error, element){
			error.appendTo(element.closest("li"));
		},
		messages:{
			real_name:{
				required:"请输入姓名",
			},
			card_number:{
				required:"请输入身份证号码",
				isIdCardNo:"请输入正确的身份证号码"
			},
		},
		"submitHandler": function(form) {
			$(form).ajaxSubmit({
				"url": "/restful/customerIdentity",
				"type": "put",
				"dataType": "json",
				"headers": { "authorization": localStorage.getItem("auth_token") },
				"success": function (data) {
					if(data.success){
						window.location.href="/stepthere.html";
					}
				},
			});
		}
	});
	// 还款银行卡的验证
	$("#verifycard").validate({
		rules:{
			bank_name:{
				required:true,
			},
			bank_card:{
				required:true,
				isBankCard:true
			},
			agree:{
				required:true,
			} 
		},
		errorPlacement:function(error, element){
			error.appendTo(element.closest("li"));
		},
		messages:{
			bank_name:{
				required:"请输入您的发卡银行",
			},
			bank_card:{
				required:"请输入您的储蓄卡号",
				isBankCard:"请输入正确的储蓄卡账号"
			},
			agree: "请接受我们的声明",
		},
		"submitHandler": function(form) {
			$(form).ajaxSubmit({
				"url": "/restful/banks",
				"type": "post",
				"dataType": "json",
				"headers": { "authorization": localStorage.getItem("auth_token") },
				"success": function (data) {
					if(data.success){
						window.location.href="/stepfive.html";
					}else{
						M.layer("请完善银行卡信息",1000);
					}
				},
			});
		}
	});
	// 个人联系方式的验证
	$("#conInfo").validate({
		rules:{
			qq_number:{
				required:true,
				isQQ:true,
			},
			detail:{
				required:true,
			},
			city_info:{
				required:true,
			}
			
		},
		errorPlacement:function(error, element){
			error.appendTo(element.closest("li"));
		},
		messages:{
			qq_number:{
				required:"请输入您的QQ号",
			},
			detail:{
				required:"请输入您的详细地址"
			},
			city_info:{
				required:"请选择你的省市区"
			}
			
		},
		"submitHandler": function(form) {
			var detailAddress = $("#city").val()+","+$("#detail").val();
			$("#address").val(detailAddress);
			$(form).ajaxSubmit({
				"url": "/restful/contactWay",
				"type": "put",
				"dataType": "json",
				"headers": { "authorization": localStorage.getItem("auth_token") },
				"success": function (data) {
		            if(data.success){
		            	window.location.href="/stepsix.html";
		            }else{
		            	M.layer("请完善你的个人联系方式",1000);
		            }
				},
				error:function(){
					M.layer("请完善你的个人联系方式",1000);
				}
			});
		}
	});
	// 紧急联系人的验证
	$("#shipInfo").validate({
		ignore: [],
		debug:true,
		rules:{
			shipOne:{
				required:true,
			},
			shipTwo:{
				required:true,
			},
			shipThere:{
				required:true,
			},
			parentname:{
				required:true,
			},
			parenttwo:{
				required:true
			},
			parentthere:{
				required:true
			},
			phone:{
				required:true,
				isMobile:true,
			},
			phonetwo:{
				required:true,
				isMobile:true,
			},
			phonethere:{
				required:true,
				isMobile:true,
			},
			test1:{
				required:true
			}

		},
		errorPlacement:function(error, element){
			error.appendTo(element.closest("li"));
		},
		messages:{
			shipOne:{
				required:"请输入您父亲或母亲的姓名",
			},
			shipTwo:{
				required:"请选择与本人的关系",
			},
			shipThere:{
				required:"请选择与本人的关系",
			},
			parentname:{
				required:"请输入紧急联系人姓名1",
			},
			parenttwo:{
				required:"请输入紧急联系人姓名2",
			},
			parentthere:{
				required:"请输入紧急联系人姓名3",
			},
			phone:{
				required:"请输入父亲或者母亲的电话"
			},
			phonetwo:{
				required:"请输入联系人的电话"
			},
			phonethere:{
				required:"请输入联系人的电话"
			},
			test1:{
				required:"我只是测试"
			}
			
		},
		"submitHandler": function(form) {
			console.log("lll");
			var info = $(".show-list");
			var proarr = [];
			for(var i=0;i<info.length;i++){
				proarr.push({
					"relation":$(info[i]).find("p").data("ship"),
					"name":$(info[i]).find(".data2").val(),
					"mobilePhone":$(info[i]).find(".data3").val(),
				});
			}
			var person = JSON.stringify(proarr);  
			$.ajax({
				"url": "/restful/contactPersons",
				"type": "post",
				"dataType": "json",
				data:person,
				"headers": { "authorization": localStorage.getItem("auth_token") },
				contentType: "application/json",
				"success": function (data) {
		            if(data.success){
		            	window.location.href="/stepseven.html";
		            }else{
		            	M.layer("请完善紧急联系人方式",1000);
		            }
				},
				error:function(){
					console.log(this.data);
					console.log("this.data",proarr);
				}
			});
		}
	});
	// 教育程度
	$("#eduInfo").validate({
		ignore: [],
		debug:true,
		rules:{
			educational:{
				required:true,
			},
			method:{
				required:true,
			},
			school:{
				required:true,
			},
			specialty:{
				required:true,
			},
			admissionTime:{
				required:true
			},
			graduationTime:{
				required:true
			}
		},
		errorPlacement:function(error, element){
			error.appendTo(element.closest("li"));
		},
		messages:{
			educational:{
				required:"请选择您的教育程度",
			},
			method:{
				required:"请选择您的录取方式",
			},
			school:{
				required:"请输入您的学校名称",
			},
			specialty:{
				required:"请输入您的专业名称",
			},
			admissionTime:{
				required:"请选择入学时间（年 - 月）"
			},
			graduationTime:{
				required:"请选择毕业时间（年 - 月）"
			}
		},
		"submitHandler": function(form) {
			var startime = $("#admissionTime").val().split('-');
			var endtime = $("#graduationTime").val().split('-');
			startime = new Date(startime[0],startime[1]-1,startime[2]);
			endtime = new Date(endtime[0],endtime[1]-1,endtime[2]);
			console.log("startime",startime);
			console.log("endtime",endtime);
			 if(startime>endtime){
			 	M.layer("毕业时间不能在入学时间之前哟",1000);
			 	return;
			 }else{
		 		var proarr = "";
		 		proarr = {
		 			"educational":$("#educational").val(),
		 			"method":$("#method").val(),
		 			"school":$("#school").val(),
		 			"specialty":$("#specialty").val(),
		 			"admissionTime":$("#admissionTime").val(),
		 			"graduationTime":$("#graduationTime").val(),
		 		};
		 		var educational = JSON.stringify(proarr);  
		 		$.ajax({
		 			"url": "/restful/educationalBackground",
		 			"type": "post",
		 			"dataType": "json",
		 			data:educational,
		 			"headers": { "authorization": localStorage.getItem("auth_token") },
		 			contentType: "application/json",
		 			"success": function (data) {
		 	            if(data.success){
		 	            	window.location.href="/myprofile.html";
		 	            }else{
		 	            	M.layer("请完善您的教育信息",1000);
		 	            }
		 			},
		 			error:function(){
		 			}
		 		});
			 }
			
			
		}
	});
	// 上传身份证的验证
	$("#Certificatesform").validate({
		debug:true,
		"submitHandler": function(form) {
			var facade=$("input[name='facade_imange']").val();
			var negative=$("input[name='negative_image']").val();
			var hand=$("input[name='hand_imange']").val();
			console.log("facade",facade);
			console.log("negative",facade);
			console.log("hand",facade);
			if(facade==""&&negative==""&&hand==""){
				M.layer("请完善证件照片",1000);
				return;
				
			}else{
				$(form).ajaxSubmit({
					"url": "/restful/addPapersImage",
					"type": "post",
					"dataType": "json",
					"headers": { "authorization": localStorage.getItem("auth_token") },
					"data":{"facade_imange":facade,"negative_image":negative,"hand_imange":hand},
					"success": function (data) {

						if(!data.success){
							M.layer("请完善证件照片",1000);
						}else{
							window.location.href="/stepfour.html";
						}    
					},
				});
			}
			
		}
	});
	
	
})