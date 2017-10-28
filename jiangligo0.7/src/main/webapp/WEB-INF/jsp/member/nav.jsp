<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Title</title>
</head>
<body>
	<h2>商品</h2>
			<ul>
				<li><a href="goods/rel.do">去发布</a></li>
				<li><a href="goods/released.do" >已发布商品</a></li>
			</ul>
			<h2>收藏</h2>
			<ul>
				<li><a href="goods/collection.do">收藏的商品</a></li>
			</ul>
			<h2>足迹</h2>
			<ul>
				<li><a href="goods/footmark.do">浏览过的商品</a></li>
			</ul>
</body>
</html>