<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'indexHeader.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/Reset.css" />
		<link rel="stylesheet" href="css/indexHeader.css" />
	</head>
	<body>
	<!--头部导航-->
	<header>
		<input type="hidden" id="username" value="${member.username}"/>
		<a class="a1" href="Login.jsp">请登录</a>
		<a class="a2" href="Register.jsp">免费注册</a>	
		<a class="a3" href="mainpage.do">首页</a>	
		<ul class="ul1">
			<li class="li1">我的江理GO
			<ul class="ul2">
				<li><a href="javascript:void(0)">成功订单</a><li>
				<li><a href="goods/footmark.do">我的足迹</a><li>
					
			</ul>
			</li>
			<li class="li2">收藏夹
				<ul class="ul2">
					<li><a href="goods/collection.do">收藏的宝贝</a><li>
				</ul>
			</li>
			<li class="li3">卖家中心
				<ul class="ul2">
					<li><a href="javascript:void(0)">免费开店</a><li>
				    <li><a href="javascript:void(0)">已卖出的宝贝</a><li>
					<li><a href="javascript:void(0)">出售中的宝贝</a><li>
				</ul>
			</li>
			<li class="li4">订单
			<ul class="ul2">
				<li><a href="getHandorder.do?id=${member.id }">待处理的订单</a><li>
			</ul>
			</li>
			<li class="li5">联系客服
			<ul class="ul2">
			<li><a href="javascript:void(0)">联系客服</a><li>
			</ul>
			</li>
		</ul>
	</header>
	<iframe src="${param.iframe}"></iframe>
	<script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
	<script type="text/javascript" src="js/indexHeader.js" ></script>
		<script type="text/javascript">
		$(function(){
			if($('#username').val()!=''){
				$('a.a1').html("欢迎，"+$('#username').val()).attr('href','javascript:void(0)');
				$('a.a2').html("退出").attr('href','javascript:void(0)');
			}
		});
	</script>
	</body>
</html>
