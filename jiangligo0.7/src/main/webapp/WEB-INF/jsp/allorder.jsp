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
    
    <title>My JSP 'allorder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/allorder.css" />
  </head>
  
  <body>
    		<header>
		<div id="header">
		<a id="all" href="getallorder.do?id=${sessionScope.member.id}">全部订单</a><img src="images/QQ图片20170329134954.png"><a id="" href="getHandorder.do?id=${sessionScope.member.id}">待处理</a><img src="images/QQ图片20170329134954.png"> <a id="" href="selectevaluate.do?id=${sessionScope.member.id}">待评价</a> 
        </div>
		</header>
        <div id="order">
        <table>
        	<tr id="tabletitle">
        	<td style="width: 409px;" class="tabletitletd">宝贝</td>
        	<td class="tabletitletd">单价</td>
        	<td class="tabletitletd">数量</td>
        	<td class="tabletitletd">实付款</td>
        	<td class="tabletitletd">商品操作</td>
        	<td class="tabletitletd">交易状态</td>
        	<td class="tabletitletd">交易操作</td>
        	</tr>
        	<tr>
            </tr>
            </table>
           </div>
            <!--
            	作者：offline
            	时间：2017-03-29
            	描述：订单
            -->
            <c:forEach items="${lastlist}" var="order">
            <div id="list">
            <table>
            <tr>
            	<td colspan="7" id="tablegoodstwo">
            		<input type="checkbox" name="" />
            		<span >${order.orderDate}</span>&nbsp;
            	<label>订单号:${order.id}</label>
            	</td>
            </tr>
            <c:forEach items="${order.goods}" var="ordergoods">
        	<tr class="tablegoods">
        		<td class="tablegoodstd"><div class="tablegoodstddiv"><c:forTokens items="${ordergoods.pic}" delims=":" var="pic"><img src="${pic}" style="width: 100px;height: 100px;margin: 0px;padding: 0px;"></c:forTokens><p id="firstp">【${ordergoods.name}】${ordergoods.info}</p></div></td>
        		<td ><div class="tablegoodstdge p"><p>${ordergoods.price}</p></div></td>
        		<td ><div class="tablegoodstdge p"><p>1</p></div></td>
        		<td ><div class="tablegoodstdge p"><p>${ordergoods.price}</p></div></td>
        		<td ><div class="tablegoodstdge p"><p><a href="javascript:void(0)" id="confirmgoods">${order.goodsoperation}</a></p></div></td>      		
        		<td ><div class="tablegoodstdge p"><p>${order.orderstate}</p></div></td>
        		<td ><div class="tablegoodstdge p"><p><input type="button" onclick="qxorder(this)"  name="${ordergoods.id}" value="${order.orderoperation}"/></p></div></td>
        	</tr>
        	</c:forEach>
        	</table>
        </div>
        <p style="display:none;" id="session">${sessionScope.member.id}</p>
</c:forEach>
        <script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
        <script type="text/javascript">
        function qxorder(obj){
        if(confirm("确认该操作?")){
        var session=$("#session").html();
        var orderid=$(obj).attr("name");
        //alert(orderid);
        $.post("delectorder.do?orderid="+orderid+"",function(){
		alert("操作成功！");
				});
        window.location.href="getallorder.do?id="+session+"";
        }
        }
        	$(".a").bind("click",function(){
  confirm("确认通过该商品？");
  
  });
        	$("#confirmgoods").bind("click",function(){
        		  if(confirm("确认收货？请慎重！")){
        			  var session=$("#session").html();
        			  var orderid=$(obj).attr("name");
        			  $.post("changeorder.do?orderid="+orderid+"",function(){});
        		window.location.href="selectevaluate.do?id="+session+"";
        		  }
        		  
        		  });
        </script>
  </body>
</html>
