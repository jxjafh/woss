<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chatcontent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
		background:white;
				width: 325px;
				height: 255px;
			margin: 0px;
			padding: 0px;
		}
		p{
		   font-family:"黑体";
		}
		.left{
		border:3px solid hotpink;
				position: absolute;
				left: 0px;
				background:hotpink;
		}
		 .right{
		 border:3px solid lightgray;
		 background:lightgray;
position: absolute;
right: 0px;
		}
	</style>
	</head>
	<body>
	   <p style="display:none;" class="receiver">${param.receiver}</p>
	   <p style="display:none;" class="sender">${sessionScope.member.username}</p>
    <c:forEach items="${list}" var="chat">	
	 <c:choose>
	 <c:when test="${chat.sender==sessionScope.member.username}">
	 <p class="right">${chat.content}:${chat.sender}</p><br/><br/>
	 </c:when>
	 <c:when test="${chat.sender!=sessionScope.member.username}">
	 <p class="left">${chat.sender}:${chat.content}</p><br/><br/>
	 </c:when>
	</c:choose>
	</c:forEach>
	<p id="lasttime" style="display:none">${lasttime}</p>	
		<script src="js/jquery-3.0.0.js"></script>
		<script>
		lasttime=$("#lasttime").html();
		var html=$("body").html();
		var chat="chat";
		var left="left";
		var i=0;
		var receiver=$(".receiver").html();
		var sender=$(".sender").html();
		setInterval(function(){
		//关闭窗口不运行
		//console.log($("#chat", window.parent.document).css("display"));
		var chatstate=$("#chat", window.parent.document).css("display");
				if(chatstate=="block"){
$.post("chat/lasttime.do?lasttime="+lasttime+"&receiver="+sender+"&sender="+receiver+"",function(data){
if(data.length!=0&&data!=null){
	for(;i<data.length;i++){
		html+="<p class="+left+">"+data[i].sender+":"+data[i].content+"</p><br/>";
		$("body").html(html);
	}
	//var receiver2=$(".receiver2").html();
	//receiver=receiver2;
	$("#lasttime").html(data[i].time);
}
/* var list="${"+data+"}";
if(data.size()!=0&&data.length!=0&&data!=null){
html+="<c:forEach items="+list+" var="+chat+"><p class="+left+">${chat.content}:${chat.sender}</p><br/></c:forEach>";
$("body").html(html);
} */
else{}
});
		 }},10000);
		</script>
</html>
