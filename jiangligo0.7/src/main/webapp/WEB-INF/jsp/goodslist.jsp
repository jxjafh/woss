<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>江理淘商品</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/Reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/goodsList.css"/>
<!-- 		<script type="text/javascript">
		$(function (){
			$('#sub_search').click(function(){
				var ipt = $('#ipt_search');
				if(ipt.val()==''){
					//输入框为空无操作
					alert(ipt.val());
					return false;
				}else{ 
					alert(ipt.val());
					return false;
				}
			});
		});
		</script> -->
	</head>
	<body>
		<jsp:include page="/indexHeader2.jsp"></jsp:include>
		<div class="goodsContent">
			<div class="goodsTitle">
			<input id="key" type="hidden">
			<span class="goodsTitle2">${key }</span>
			<span class="goods Title3">排序方式：</span>
		<!-- 模糊查询时 -->
			<c:if test="${sort_id==-1 }">
			<ul>
				<li><a href="goods/listByNameLikeLimit.do?key=${key }&page=1">按时间</a></li>
				<li><a href="javascript:void(0)">按商家信誉</a></li>
				<li><a href="goods/listByNameLikeLimitOrderByPriceDesc.do?key=${key }&page=1">按价格从高到低</a></li>
				<li><a href="goods/listByNameLikeLimitOrderByPrice.do?key=${key }&page=1">按价格从低到高</a></li>
				
			</ul>
			</c:if>
		<!-- 分类查询时 -->
			<c:if test="${sort_id!=-1 }">
			<ul>
				<li><a href="goods/listBySortLimit.do?sort_id=${sort_id }&page=1">按时间</a></li>
				<li><a href="javascript:void(0)">按商家信誉</a></li>
				<li><a href="goods/listBySortLimitOrderByPriceDesc.do?sort_id=${sort_id }&page=1">按价格从高到低</a></li>
				<li><a href="goods/listBySortLimitOrderByPrice.do?sort_id=${sort_id }&page=1">按价格从低到高</a></li>
			</ul>
			</c:if>
			</div>
			<div class="goodsBlock">
			<c:forEach items="${list}" var="it">
				<a href="admin/goodsdetails.do?id=${it.id }">
					<div class="goods"><img src="${it.pic }"/>
					<div class="price">
					<span class="span1">${it.name }</span>
					<span class="span2"><span class="span3">&yen;</span>${it.price }</span>
					</div>
					</div>
			    </a>
		    </c:forEach>
			</div>
			<!-- 分页 
			<div>
				<a class="bottoma" href="admin/audit.do?intal=0">首页</a>&nbsp;
				<c:choose>
				<%--第三页以前 --%>
					<c:when test="${page<3}">
						<c:forEach var="i" begin="1" end="${sum }">
							<c:choose>
								<c:when test="${i==page&&page<(sum-1)}">
									<a style="color:white;background:orangered;" class="bottoma" href="admin/audit.do?intal=${i*size}">${i+1}</a>&nbsp;
								</c:when>
								<c:otherwise>
									<a class="bottoma" href="admin/audit.do?intal=${i*size}">${i}</a>&nbsp;
								</c:otherwise>
							</c:choose>
						</c:forEach> 
					</c:when>
				<%--最后第二页--%>
					<c:when test="${page==(sum-1)}">
						'''
						<a class="bottoma" href="admin/audit.do?intal=${(page-2)*size}">${page-1}</a>&nbsp;
						<a class="bottoma" href="admin/audit.do?intal=${(page-1)*size}">${page}</a>&nbsp;
						<a class="bottoma" style="color:white;background:orangered;" href="admin/audit.do?intal=${(page)*size}">${page+1}</a>&nbsp;
						<a class="bottoma" href="admin/audit.do?intal=${(page+1)*size}">${page+2}</a>&nbsp;
					</c:when>
				<%--最后第一页 --%>
				<c:when test="${page==sum}">
				<%-- goods/listByNameLikeLimit.do?key=${key }&page=1 --%>
					'''
					<a class="bottoma" href="admin/audit.do?intal=${(page-2)*size}">${page-1}</a>&nbsp;
					<a class="bottoma" href="admin/audit.do?intal=${(page-1)*size}">${page}</a>&nbsp;
					<a class="bottoma" style="color:white;background:orangered;" href="admin/audit.do?intal=${(page)*size}">${page+1}</a>&nbsp;
				</c:when>
				<%--第三到最后第二页 --%>
				<c:otherwise>
					'''
					<a class="bottoma" href="admin/audit.do?intal=${(page-2)*size}">${page-1}</a>&nbsp;
					<a class="bottoma" href="admin/audit.do?intal=${(page-1)*size}">${page}</a>&nbsp;
					<a class="bottoma" style="color:white;background:orangered;" href="admin/audit.do?intal=${(page)*10}">${page+1}</a>&nbsp;
					<a class="bottoma" href="admin/audit.do?intal=${(page+1)*size}">${page+2}</a>&nbsp;
					<a class="bottoma" href="admin/audit.do?intal=${(page+2)*size}">${page+3}</a>&nbsp;
				'''
				</c:otherwise>
				
				</c:choose>
				
				<a class="bottoma" href="admin/audit.do?intal=${sum*size}">末页</a>
			</div> -->
		</div>
		
		<!--版权所有-->
    <footer>
		<p class="">版权所有：Copyright: &nbsp;&nbsp;&nbsp;BUGKILLER  2017，All Rights Reserved</p>
	</footer>
		
	</body>
</html>
