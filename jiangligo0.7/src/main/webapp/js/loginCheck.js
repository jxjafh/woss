function loginCheck(){
	
	   var username = $("#loginName").val();  
         var pwd= $("#password").val(); 
        var prt=document.getElementById("warning");
        
        if(username==""||username==null){  
        	prt.style.color="red";  
        	prt.innerHTML = "×账号不能为空";  
        	
        	return false;
        } 
        if(pwd==""||pwd==null){  
        	prt.style.color="red";  
        	prt.innerHTML = "×密码不能为空";
        	
            return false;  
        }
       
	
	
}
