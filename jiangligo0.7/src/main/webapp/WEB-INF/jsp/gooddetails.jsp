<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gooddetails.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/gooddetails.css" />
<script src="js/jquery1.js"></script>
	      <script src="js/setup.js"></script>
	<script type="text/javascript" src="js/xzoom.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/xzoom.css" media="all" /> 

	</head>
	<body>
<div class="contents" style="padding: 0;transform-origin: 0px 50% 0px; transition: all 0.5s ease;">
			<jsp:include page="/indexHeader2.jsp"></jsp:include>
	<span id="memberid" style="display:none;">${sessionScope.member.id}</span>
        <div id="top">
		<div id="left">
		<div class="container">
		    <section id="default" class="padding-top0">
		    <div class="row">
		      <div class="large-5 column">
		        <div class="xzoom-container">
		          <img class="xzoom" id="xzoom-default" width="430px" src="${goods.pic.split(":")[0] }" />
		          <div class="xzoom-thumbs">
		        <c:forTokens var="pname" items="${goods.pic }" delims=":">
		            <%-- <a href="images/1_a.jpg"><img class="xzoom-gallery" width="60" src="images/1.jpg"  xpreview="images/1_a.jpg" title="${goods.info}"></a>
		            <a href="images/1_a.jpg"><img class="xzoom-gallery" width="60" src="images/1.jpg" title="${goods.info}"></a>
		            <a href="images/1_a.jpg"><img class="xzoom-gallery" width="60" src="images/1.jpg" title="${goods.info}"></a> --%>
		            <a href="${pname }"><img class="xzoom-gallery" width="60" src="${pname }" title="${goods.info}"></a>
	            </c:forTokens>
		          </div>
		        </div>        
		      </div>
		    </section>
  
	</div><a href="javascript:void(0);" id="shoucang"><img src="images/shouchang.png"/>收藏商品</a><a id="clickchat" href="javascript:void(0);"><img  width="15px" height="20px" src="images/chattop1.png"/>联系店家</a></div>
		
		<div id="right">
		<h2>${goods.name}</h2>
		<div id="price">
			<br />
			&nbsp;价格:&nbsp;&nbsp;¥<span class="originalprice">${goods.originalprice}</span><br /><br />
			&nbsp;促销价:&nbsp;&nbsp;<span class="price">¥${goods.price}</span>
		</div>
		<div id="info">
		<p>${goods.info}</p>
		</div>
		<div id="button">
		<input type="button"  value="立即购买" onclick="shopping()"/>
		</div>
		</div>
        </div>
        		<div id="chat">
			<div id="chattop">
				<img style="width:20px;margin-left:5px;height:25px;" src="images/chattop1.png">
				<div style="float:right;" id="chattoptext"><span style="font-weight: bold;">${membername}</span></div>
				<div style="float:right;"><a style="float:right ;" id="guanbi" href="javascript:void(0);"><img style="width:20px;height: 20px;" src="images/x.png"/></a></div>
			</div>
			<div id="left">
		
			<div id="chatcontent">
			<iframe id="iframe" src="chat/allcontent.do?sender=${sessionScope.member.username}&receiver=${membername}" scrolling="yes"></iframe>	
			</div>
			<p style="width:355px;height:18px;background:lightskyblue;"></p>
			<div id="sendchat">
			<textarea rows="5" cols="48" placeholder="内容放这里"></textarea><p id="sender" style="display:none">${sessionScope.member.username}</p><p id="receiver" style="display:none">${membername}</p>
			<input type="button" style="margin-left:300px;border:1px solid deepskyblue;color:darkblue;background:white;width:50px ;height:20px;" value="发送" onclick="send();" />
			</div>
			<!--商品显示-->
			</div>
			<div id="right">
			<c:forTokens items="${goods.pic}" var="pic" delims=":"><img style="width:100px;height:100px;margin-left:70px;margin-top:20px;" src="${pic}"></c:forTokens>
			<div id="price">
			<span id="goodsid" style="display:none;">${goods.id}</span>
			&nbsp;价格:&nbsp;&nbsp;¥<span class="originalprice">${goods.originalprice}</span><br/><br/>
			&nbsp;促销价:&nbsp;&nbsp;<span class="price">¥${goods.price}</span>
		</div>
		<div id="info">
		<p>${goods.info}</p>
		</div></div>
		
		</div>
		<script src="js/jquery-3.0.0.js"></script>
		<script>
		function shopping(){
			if(confirm("确认购买?")){
			var memberid=$("#memberid").html();
			var goodsid=$("#goodsid").html();
			$.post("insertgoods.do?goodsid="+goodsid+"&memberid="+memberid+"",function(){
			
					});
				alert("购买成功！");
			}
			}
			
			$("#shoucang").bind("click",function(){
			var memberid=$("#memberid").html();
			var goodsid=$("#goodsid").html();
			//alert(memberid);alert(goodsid);
			if(confirm("确认收藏?")){
			$.post("membercg.do?member_id="+memberid+"&goods_id="+goodsid+"",function(){})
			}
			})
		

		
		$("#clickchat").bind("click",function(){
		$("#chat").attr("display","block");
		$("#chat").show();
		})
		
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
