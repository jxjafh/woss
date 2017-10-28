function nameCheck(){
	var username=$("#newName").val();
	var name_msg=document.getElementById("name_msg");
	if(username==""||username==null){  
		name_msg.innerHTML = "×账号不能为空";  
     }else if(username.length>7){
    	name_msg.innerHTML = "×长度不超过7";
    		 }else{
    				$.post("nameCheck.do?loginName="+username+"",function(data){
    					$("#name_msg").text(data);
    					if(data=="×用户名已存在！"){
    					}else{
    						$("#key1").attr("value",1);
    						key=document.form.key1.value;
    					}
    				})};
    						
}
function emailCheck(){
	function isEmail(str){
	var reg =/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
  	  return reg.test(str);
  	 }
	
	 var email=$("#email").val();
	 var emailMsg=document.getElementById("email_msg");
		 if(email==""||email==null){  
			emailMsg.innerHTML = "×邮箱不能为空";  
	     }else if(!isEmail(email))
	     {
	    	emailMsg.innerHTML = "×邮箱格式不正确";
	    }else{
	    	$.post("emailCheck.do?loginemail="+email+"",function(data){
				$("#email_msg").text(data);
				if (data=="×邮箱已注册！"){
					
				}else{
					$("#key2").attr("value",1);
					key=document.form.key2.value;
				}
	    	});
	    	
	    	}
		 }

function pwdCheck(){
	function isPwd(str){
		var reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
		return reg.test(str);
	}
	
	 var pwd=$("#password").val();
		var pwdMsg=document.getElementById("pwd_msg");
		if(pwd==""||pwd==null){  
			pwdMsg.innerHTML = "×密码不能为空";  
	     }else if(!isPwd(pwd)){
	    	pwdMsg.innerHTML="×密码格式不符合要求";
	    		 }else{
	    			 pwdMsg.innerHTML="√密码合格";
	    			 $("#key3").attr("value",1);
						key=document.form.key3.value;
	    		 }
		
}
function pwd2Check(){
	
var pwd2=$("#password2").val();
	 var pwd=$("#password").val();
	var pwd2Msg=document.getElementById("pwd2_msg");
	if(pwd2!=pwd){
		pwd2Msg.innerHTML="×密码不一致！";
	}else{
		pwd2Msg.innerHTML="√密码一致";
		$("#key4").attr("value",1);
		key=document.form.key4.value; 
	}

}
function getCode(){
	var mail=$("#email").val();
	$.post("getCode.do?mail="+mail+"");
		
}
function registerCheck(){
	var code=$("#verifyCodeEmail").val();
	var codeMsg=document.getElementById("code_msg");
	var flag=false;
	var key1=document.form.key1.value;
	var key2=document.form.key2.value;
	var key3=document.form.key3.value;
	var key4=document.form.key4.value;
			$.ajax({  
		         url: "registerCheck.do",   
		         async: false,  
		         type: "post",  
		         data:  {"code1":code},  
		         success: function(data){
		        	 if(code==null||code==""){
		        		 codeMsg.innerHTML="×请输入验证码"; 
		        	 }
		        	 
		        	 else if(data=="false"){
		 				alert("验证码错误");
		 				alert(key1+key2+key3+key4);
		 				flag=false;
		 				return flag;
		 			}else if(key1==1&&key2==1&&key3==1&&key4==1){
		 				alert(key1+key2+key3+key4);
		 				flag=true;
		 				return flag;
		        	 }else{
		        		 alert(key1+key2+key3+key4);
		        		 flag=false;
			 				return flag;
		 			}
		         }
		     });
			return flag;
}





								
									
			
