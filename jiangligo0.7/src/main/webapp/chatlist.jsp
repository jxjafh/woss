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
			
			#chat{
				border: 1px solid #1D7DB1;
				position: absolute;
				top:50px;
				left:330px;
				width:300px ;
				height:400px ;
			}
			#chattop{
				width:300px;
				height:26px;
				background: lightskyblue;
				position: relative;
			}
			#chat #left{
				width:300px;
				height: 374px;
			}
			#chat #left #list{
			border-top:1px solid lightgray;
			width:300px;
			height:50px;
			}
			#chat #left #list p{
			
			}
		</style>
	</head>
	<body>
		<div id="chat">
			<div id="chattop">
				<img style="width:20px;margin-left:5px;height:25px;" src="images/chattop1.png">
				</div>
			<div id="left">
			<div id="list"><p>李建1</p></div>
			<div id="list"><p>李建2</p></div>
			<div id="list"><p>李建3</p></div>
			</div>
		</div>
		<script src="js/jquery-3.0.0.js"></script>
		<script>
		
		</script>
	</body>
</html>
