<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
		*{
			margin: 0px;
			padding: 0px;
		}
			border{
				width:350px;
				height: 374px;
				background-color:white;
			}
			#chat{
				border: 1px solid #1D7DB1;
				width:350px;
				height: 374px;
			}
			#chattop{
				width:353px;
				height:26px;
				background: lightskyblue;
				position: relative;
			}
			#chat #left{
			background-color:white;
			float:left;
			width:350px;
			height: 374px;
			}
			#chat #chattop #guanbi{
				position: absolute;
				right: 0px;
			}
			#chat #chattop #chattoptext{
				width: 50px;
				height: 24px;
				margin-right: 200px;
				
			}
			#chat #chattop #chattoptext span{
				width: 50px;
				height: 24px;
				line-height: 24px;
			}
			#chat #left #chatcontent{
				width: 271px;
				height: 159px;
				margin-bottom: 100px;
			}
			#chat #left #chatcontent iframe{
				width: 350px;
				height: 255px;
				
			}
		</style>
	</head>
	<body>
		<div id="chat">
			<div id="chattop">
				<img style="width:20px;margin-left:5px;height:25px;" src="images/chattop1.png">
				<div style="float:right;" id="chattoptext"><span style="font-weight: bold;">${param.receiver}</span></div>
				<div style="float:right;"><a style="float:right;" id="guanbi" href="javascript:void(0);"><img style="width:20px;height:20px;" src="images/x.png"/></a></div>
			</div>
			<div id="left">
				
			<div id="chatcontent">
			<iframe id="iframe" src="chat/allcontent.do?sender=${sessionScope.member.username}&receiver=${param.receiver}" scrolling="yes"></iframe>	
			</div>
			<p style="width:355px;height:18px;background:lightskyblue;"></p>
			<div id="sendchat">
			<textarea rows="5" cols="48" placeholder="内容放这里"></textarea><p id="sender" style="display:none">${sessionScope.member.username}</p><p id="receiver" style="display:none">${param.receiver}</p>
			<input type="button" style="margin-left:305px;border:1px solid deepskyblue;color:darkblue;background:white;width:50px ;height:20px;" value="发送" onclick="send();" />
			</div>
			<!--商品显示-->
			</div>

		</div>
		<script src="js/jquery-3.0.0.js"></script>
		<script>
			$("#guanbi").bind("click",function(){
				$("#chat").hide();
			})
			function send(){
				var sender=$("#sender").html();
				var receiver=$("#receiver").html();
				var content=$("textarea").val();
				var right="right";
				if(content==null||content==""){}else{
				$.post("chat/chatsend.do?sender="+sender+"&receiver="+receiver+"&content="+content+"",function(){
				});
				//获取body全部内容
				var html=$(document.getElementById("iframe").contentWindow.document.body).html();
				//获取div里全部内容(不成功)
				//var html=$("#content",document.frames("iframe").document);
				  html+="<p class="+right+">"+content+":"+sender+"</p><br/><br/>";
				 $(document.getElementById("iframe").contentWindow.document.body).html(html);
				
				$("textarea").val("");
			}
			}
		</script>
	</body>
</html>
