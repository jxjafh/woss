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
    
    <title>My JSP 'mainpage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/Reset.css" />
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
		<div class="container">
	<!--头部导航-->
	<header>
		<script type="text/javascript">


		</script>
		<a class="a1" href="Login.jsp">请登录</a>
		<a class="a2" href="Register.jsp">免费注册</a>	
		<a class="a3" href="mainpage.do">首页</a>	
		<ul class="ul1">
			<li class="li1">我的江理GO
			<ul class="ul2">
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
		<a class="a4" href="javascript:void(0)">首页</a>
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
	
	<!--商品分类导航及热门商品轮播-->
	<div class="nav">
		<!--左部分-->
		<div class="left">
			<ul>
			<c:forEach items="${listsort}" var="sort">
				<li><a href="goods/listBySortLimit.do?sort_id=${sort.id }&page=1">${sort.sortname}</a><span>&gt;</span></li>
			</c:forEach>
			</ul>
		</div>
		<!--轮播区-->
		<div id="banner">
			<!--图片区-->
			<div class="pic">
				<a href="javascript:void(0)"><img src="images/01.jpg"/ style="display: block;"></a>
				<a href="javascript:void(0)"><img src="images/02.jpg"/></a>
				<a href="javascript:void(0)"><img src="images/03.jpg"/></a>
				<a href="javascript:void(0)"><img src="images/04.jpg"/></a>
				<a href="javascript:void(0)"><img src="images/05.jpg"/></a>
			</div>
			<!--选项卡-->
			<div class="tab">
			<ul>
				<li class="on"></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>	
			</div>
		    <div class="btn">
			<!--按钮区-->
			<a href="javascript:void(0)" id="left" style="left: 230px;">&lt;</a>
			<a href="javascript:void(0)" id="right" style="right:0px">&gt;</a>
			</div>
		</div>
	</div>
	
	<!--最新商品区-->
	<div class="newGoods">
		<span class="goodsTitle">最新发布商品</span>
		
		<div class="goodsBlock">
		<c:forEach begin="0"  step="1" end="${listgoods.size()-10}" items="${listgoods}" var="goods">
			<a href="admin/goodsdetails.do?id=${goods.id}">
				<div class="goods"><img src="${goods.pic }"/>
				<div class="price">
					<span class="span1">${goods.name}</span>
					<span class="span2"><span class="span3">&yen;</span>${goods.price}</span>
				</div>
				</div>	
			</a>
</c:forEach>
		<c:forEach begin="1"  step="1" end="${listgoods.size()-6}" items="${listgoods}" var="goods">
			<a href="admin/goodsdetails.do?id=${goods.id}">
				<div class="goods goodMarginLeft"><img src="${goods.pic }"/>
				<div class="price">
					<span class="span1">${goods.name}</span>
					<span class="span2"><span class="span3">&yen;</span>${goods.price}</span>
				</div>
				</div>	
			</a>
</c:forEach>
<c:forEach begin="5"  step="1" end="${listgoods.size()-5}" items="${listgoods}" var="goods">
			<a href="admin/goodsdetails.do?id=${goods.id}">
				<div class="goods marginTop"><img src="${goods.pic }"/>
				<div class="price">
					<span class="span1">${goods.name}</span>
					<span class="span2"><span class="span3">&yen;</span>${goods.price}</span>
				</div>
				</div>	
			</a>
</c:forEach>
<c:forEach begin="6"  step="1" end="${listgoods.size()-1}" items="${listgoods}" var="goods">
			<a href="admin/goodsdetails.do?id=${goods.id}">
				<div class="goods goodMarginLeft marginTop"><img src="${goods.pic }"/>
				<div class="price">
					<span class="span1">${goods.name}</span>
					<span class="span2"><span class="span3">&yen;</span>${goods.price}</span>
				</div>
				</div>	
			</a>
</c:forEach>
		</div>
	</div>
	<!--聊天框  -->
	<p class="sessionname" style="display:none;">${sessionScope.member.username}</p>
	<div style="z-index:10000;" id="chatList1" class="chatList1">
	<iframe style="z-index:10000;" class="frame1" src="lianxiren.do?receiver=${sessionScope.member.username}">
		
	</iframe>
	</div>
	<!-- 隔几秒访问数据库 -->
	<p></p>
	<!--版权所有-->
	<footer>
		<p class="">版权所有：Copyright &nbsp;&nbsp;&nbsp;BUGKILLER  2017，All Rights Reserved</p>
	</footer>
	<div style="z-index:1000;display:none;width:height:;position:absolute;top:150px;left:630px;width:375px;
				height: 410px;" class="chatmianban">
	<iframe style="				width:375px;
				height: 410px;" class="chatiframe" src="chat.jsp?receiver=樊昊"></iframe>
	</div>
	</div>
	<script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
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
		$(function(){
			var sessionname=$(".sessionname").html();
			if(sessionname!=""){
				$('a.a1').html("欢迎，"+sessionname).attr('href','javascript:void(0)');
				
				$('a.a2').html("退出").attr('href','javascript:void(0)');
			}
		});
	</script>
	</body>
</html>
