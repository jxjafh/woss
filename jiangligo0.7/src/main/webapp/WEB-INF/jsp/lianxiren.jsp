<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lianxiren.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
	<script type="text/javascript" src="js/index.js" ></script>
	<link rel="stylesheet" href="css/Reset.css" />
		<link rel="stylesheet" href="css/index.css" />
		<style type="text/css">
		body{
			width:200px;
	height:450px;
		}
		</style>
  </head>
  
  <body>
  
  <div class="chatList">
    <div class="close">
			<span class="lxr">联系人列表</span>
			<input onclick="window.parent.chatList1.style.display='none';" class="button1" type="button" value=""/>
	</div>
		<ul>
		<c:forEach items="${listlianxiren}" var="lianxiren">
			<li><a onclick="openchatmianban(this)" href="javascript:void:(0)"><p>${lianxiren.sender}</p></a><span></span></li>
		</c:forEach>
		</ul>
	</div>
	<p class="sessionname" style="display:none">${sessionScope.member.username}</p>
  </body>
  <script type="text/javascript">
  	function openchatmianban(obj){
	var sessionname=$(".sessionname").html();
		if(sessionname==""||sessionname==null){
			alert("请先登录");
			location.href="Login.jsp";
		}else{
	var receiver=$(""+$(obj).html()+">p").html();
	console.log(receiver);
	//parent.document.getElementsByClassName(".chatmianban").display = "block";
	//parent.document.getElementsByClassName(".chatiframe").src = "chat.jsp?receiver="+receiver+"";
	//$(".chatiframe").attr("src","chat.jsp?receiver="+receiver+"");
	//$(".chatmianban").css("diaplay","block");
	//$(".chatmianban").show();
	window.parent.openchatmianban(obj);
}
}
  </script>
</html>
