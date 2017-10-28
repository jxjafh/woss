<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script language="JavaScript" src="js/jquery-3.2.0.min.js"></script>
		<script type="text/javascript" src="js/loginCheck.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/Login.css">
	</head>
	<body>
		<div class="head">
			<div class="login w990">
				<a href="mainpage.do" class="hd f-l">
					<img alt="江鲤购主页" title="主页" src="images/jiangligo1.jpg">
				</a>
				<span class="bd f-l">欢迎登录</span>
				<span class="ft f-r">
					<label>没有账号？</label>
					<a href="Register.jsp" >立即注册</a>
				</span>
			</div>
		</div>
		<div class="middle" style="background-image: url(images/LoginBackground.png);">
			<div class="w990">
				<div class="login-panel">
					<div class="hd" id="jTitleLogin">
						<i class="iconfont" id="jCoordinate">&#xe614;</i>
						<span class="hover">账号登录</span>
					</div>
					<div class="bd">
						<ul id="jLoginSwitch">
							<li>
								<form method="post" id="jForm" onsubmit="return loginCheck();" action="login.do">
									<div class="txt-box txt-box-margin">

										<input id="loginName" name="loginName" placeholder="邮箱/用户名"  class="txt" tabindex="1">
										<em class="iconfont">&#xe61a;</em>
										
									</div>
									<div class="txt-box">

										<input id="password" name="password" placeholder="登录密码" type="password" class="txt auto-password-check-handle" maxlength="20" tabindex="2" />
										<em class="iconfont">&#xe619;</em>
									
									</div>
									<div class="txt-btn txt-btn-height">
										<input type="hidden" name="returnUrl" value="http://www.aomygod.com/?baiduss-PC&amp;tk=c240miA6g5r">
										<input type="submit" class="btn" id="jSubmit"  value="登录">
										<p3 class="err_msg"></p3>
										<p id="warning"></p>
										<!-- <a class="forget" href="#">忘记密码？</a> -->
                                                                 
									</div>
									</form>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<p class="">赣ICP备170409号-1<span>|</span>Copyright© BUG KILLER 2017-2018，All Rights Reserved</p>
		</div>

	</body>

</html>