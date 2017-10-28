<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
		<script type="text/javascript" src="js/Register.js" ></script>
		<meta charset="UTF-8">
		<title>欢迎进入注册页面</title>
		
	<link rel="stylesheet" href="css/Register.css">	
	</head>
	<body>
		<div class="head">
			<div class="login w990">
				<a href="index.jsp" class="hd f-l">
					<img alt="江鲤购主页" src="images/jiangligo1.jpg">
				</a>
				<span class="bd f-l">欢迎注册</span>
				<span class="ft f-r">
					<label>已有账号？</label>
					<a href="Login.jsp" >立即登录</a>
                
				</span>
			</div>
		</div>
		<div class="w990 box">
		<form  name="form" onsubmit="return registerCheck();" action="registerSuccess.do" method="post" id="jForm" >
			<div class="txt-box txt-box-user">
				<input id="newName" placeholder="会员名" name="username"  type="text" onblur="nameCheck()" class="txt" maxlength="40"  >
				<em class="iconfont">&#xe61a;</em>
				<b id="name_msg" class="msg"></b>
				<span style="display:inline"></span>
				<input id="key1" type="hidden" name="key1" value="0">
			</div>
			<p id="warning"></p>
			<div class="txt-box txt-box-user">
				<input id="email" name="email" placeholder="邮箱" type="text" onblur="emailCheck()" class="txt" maxlength="40"  >
				<em class="iconfont">&#xe61a;</em>
				<b id="email_msg" class="msg"></b>
				<input id="key2" type="hidden" name="key2" value="0">
				
			</div>
			<div class="txt-box txt-box-pw">
				<input id="password" name="password" placeholder="密码由6-20个数字和字母的组合" type="password" onblur="pwdCheck()" class="txt"  >
				<em class="iconfont">&#xe619;</em>
				<b id="pwd_msg" class="msg"></b>
				<input id="key3" type="hidden" name="key3" value="0">
			</div>
			<div class="txt-box txt-box-pw">
				<input id="password2" placeholder="再次输入密码" type="password" onblur="pwd2Check()" class="txt"  >
				<em class="iconfont">&#xe619;</em>
				<b id="pwd2_msg" class="msg"></b>
				<input id="key4" type="hidden" name="key4" value="0">
			</div>
			

			<div class="txt-box txt-box-email-verify clearfix">
				
				<em class="iconfont"></em>
				<input id="verifyCodeEmail" placeholder="邮箱验证码" name="verifyCodeEmail" type="text" class="txt code-text2" maxlength="6">
				<input type="button"  onclick="getCode()" value="获取邮箱验证码" class="btn-code" id="jSendMsgEmail" >
				<b id="code_msg" class="msg"></b>
				
			</div>	

			<input type="submit" class="btn" id="jSubmit" value="注册">
		</form>	
	</div>
			
		</div>
		<div class="footer">
	
	<p class="">赣ICP备170409号-1<span>|</span>Copyright© BUGKILLER  2017，All Rights Reserved</p>
</div>
			
		</div>
		
	</body>
</html>
