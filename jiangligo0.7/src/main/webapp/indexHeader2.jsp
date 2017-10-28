<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<meta name="keywords" content="江理购，二手货交易，江理"/>
		<title>江理购首页</title>
		<link rel="stylesheet" href="css/Reset.css" />
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
		<div class="container">
	<!--头部导航-->
	<header>
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
				<li><a onclick="return judge()" href="javascript:void(0)">全部订单</a><li>
			</ul>
			</li>
			<li class="li5"><a onclick="openchatmianban(this)" href="javascript:void(0)"><p>客服</p></a>
			<ul class="ul2">
			<li><li>
			</ul>
			</li>
		</ul>
	</header>
	
	<!--第二部分导航栏-->
	<div class="section">
		<img class="logo" src="images/jiangligo.png"/>
		<a class="a4" href="mainpage.do">首页</a>
		<a class="a5" href="goods/listByNameLikeLimit.do?key=手机&page=1">手机二手</a>
		<a class="a6" href="goods/rel.do">我要发布</a>
		<ul class="ul3">
			<li>
				我发布的商品
				<ul class="ul4">
					<li><a href="javascript:void(0)">出售中：<span>0</span></a></li>
					<li><a href="javascript:void(0)">交易中：<span>0</span></a></li>
					<li><a href="javascript:void(0)">新留言：<span>0</span></a></li>
					<li class="chatLi"><a href="javascript:void(0)">新会话：<span>0</span></a></li>
				</ul>
			</li>
		</ul>
		<div class="search">
			<form class="formSearch" action="goods/listByNameLikeLimit.do" method="post">
				<input id="ipt_search" name="key" type="search" placeholder="搜索" value="${key }"/>
				<input name="page" value="1" type="hiden" style="display: none"	>
				<input id="sub_search" onclick="return validate();" type="submit" value=""/>
				<script type="text/javascript">
					function validate(){
						if($('#ipt_search').val()==''){
							alert('搜索值不能为空');
							return false;
						}
					}
				</script>
			</form>
		</div>
	</div>
		<p class="sessionname" style="display:none;">${sessionScope.member.username}</p>
	<div style="z-index:10000;" id="chatList1" class="chatList1">
	<iframe class="frame1" src="lianxiren.do?receiver=${sessionScope.member.username}">
		
	</iframe>
	</div>
		<div style="z-index:1000;display:none;width:height:;position:absolute;top:150px;left:630px;width:375px;
				height: 410px;" class="chatmianban">
	<iframe style="				width:375px;
				height: 410px;" class="chatiframe" src="chat.jsp?receiver=樊昊"></iframe>
	</div>
	<script type="text/javascript" src="js/jquery-3.0.0.min.js" ></script>
	<script type="text/javascript" src="js/indexHeader2.js" ></script>
	<script type="text/javascript" src="js/index.js" ></script>
		<script type="text/javascript">
	function openchatmianban(obj){
	var sessionname=$(".sessionname").html();
		if(sessionname==""||sessionname==null){
			alert("请先登录");
			location.href="Login.jsp";
		}else{
	var receiver=$(""+$(obj).html()+">p").html();
	console.log(receiver);
	$(".chatiframe").attr("src","chat.jsp?receiver="+receiver+"");
	$(".chatmianban").css("diaplay","block");
	$(".chatmianban").show();
}
}
	function judge(){
		var sessionname=$(".sessionname").html();
		if(sessionname==""||sessionname==null){
			alert("请先登录");
			location.href="Login.jsp";
			return false;
		}else{
			location.href="indexHeader.jsp?iframe=manage.jsp";
			//$("").attr("","indexHeader.jsp?iframe=manage.jsp")
			return true;
		}
	}
	function openchatmianban(obj){
	var sessionname=$(".sessionname").html();
		if(sessionname==""||sessionname==null){
			alert("请先登录");
			location.href="Login.jsp";
		}else{
	var receiver=$(""+$(obj).html()+">p").html();
	console.log(receiver);
	$(".chatiframe").attr("src","chat.jsp?receiver="+receiver+"");
	$(".chatmianban").css("diaplay","block");
	$(".chatmianban").show();
}
}
	function judge(){
		var sessionname=$(".sessionname").html();
		if(sessionname==""||sessionname==null){
			alert("请先登录");
			location.href="Login.jsp";
			return false;
		}else{
			location.href="indexHeader.jsp?iframe=manage.jsp";
			//$("").attr("","indexHeader.jsp?iframe=manage.jsp")
			return true;
		}
	}
		$(function(){
			var sessionname=$(".sessionname").html();
			if(sessionname!=""){
				$('a.a1').html("欢迎，"+sessionname).attr('href','javascript:void(0)');
				$('a.a2').html("退出").attr('href','javascript:void(0)');
			}
		});
	</script>
</body>