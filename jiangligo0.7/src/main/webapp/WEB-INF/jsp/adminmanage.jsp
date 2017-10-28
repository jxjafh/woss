<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminmanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  <body>
    <table>
    <tr>
    <td>编号</td>
    <td>名字</td>
    <td>原价</td>
    <td>现价</td>
    <td>描述</td>
    <td>时间</td>
    <td>状态</td>
    <td>卖家信息</td>
    <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
    <td>${list.id}</td>
    <td>${list.name}</td>
    <td>${list.originalprice}</td>
    <td>${list.price}</td>
    <td>${list.info}</td>
    <td>${list.releasetime}</td>
    <td>${list.state}</td>
    <td><a class="bt" onclick="aa(this)" href="javascript:void(0);"><p style="display:none;">${list.member.username},${list.member.gender},${list.member.evaluate},${list.member.state},${list.member.telephone}</p>${list.member.username}</a></td>
    <td><a class="a" onclick="pass(this)" href="javascript:void(0);"><p class="pid" style="display:none;">${list.id}</p>通过</a></td>
    </tr>
    </c:forEach>
    </table>
    <p>&nbsp;</p>
    <!-- 分页 -->
    <table>
  <tr><a class="bottoma" href="admin/audit.do?intal=0">首页</a>&nbsp;
<c:choose>
<%--第三页以前 --%>
<c:when test="${page<3}">  
<c:forEach var="i" begin="0" end="4">
<c:choose>
<c:when test="${i==page&&page<(sum-1)}">
<a style="color:white;background:orangered;" class="bottoma" href="admin/audit.do?intal=${i*size}">${i+1}</a>&nbsp;
</c:when>
<c:otherwise>
<a class="bottoma" href="admin/audit.do?intal=${i*size}">${i+1}</a>&nbsp;
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
</c:otherwise>
</c:choose>
'''
<a class="bottoma" href="admin/audit.do?intal=${sum*size}">末页</a>
<input type="button" class="passinput" onclick="pass2()" value="当页全部通过">
</tr>
  </table>
  </body>
  <script type="text/javascript" src="js/jquery-3.0.0.js"></script>
  <script type="text/javascript" src="js/style.js"></script>
  <script type="text/javascript">
  //批量通过审查
function pass2(){
  if(confirm("确认通过该页全部商品？")){
  var id=$(".pid").html();
  $.post("admin/goodschangebyidpiliang.do?id="+id+"",function(data){
  alert(data);
  window.location.reload();
  });
  }
  else{
  return false;
  }
  }  
  //通过审查
function pass(obj){
  if(confirm("确认通过该商品？")){
  var id=$(""+$(obj).html()+">p").html();
  $.post("admin/goodschangebyid.do?id="+id+"",function(data){
  alert(data);
  window.location.reload();
  });
  }
  else{
  return false;
  }
  }
  function aa(member){
  //alert($(""+$(member).html()+">p").html());
  //console.log(member);
	pop({
	    memb:$(""+$(member).html()+">p").html(),
		width:1000,//提示窗口的宽度
		height:200,//提示窗口的高度
		title:'卖家详情',//提示窗口的标题
		content:''//提示窗口的内容
	});
}

function pop(obj){function tanchuang(obj){
    arrayObj=new Array();
        arrayObj=obj.memb.split(",");
       // console.log(arrayObj);                                                                  
	$("body").append("<div id='mry-opo'><div id='mry-opo-title'></div><table><tr><td>姓名</td><td>性别</td><td>评分</td><td>账号状态</td><td>电话</td></tr><tr><td>"+arrayObj[0]+"</td><td>"+arrayObj[1]+"</td><td>"+arrayObj[2]+"</td><td>"+arrayObj[3]+"</td><td>"+arrayObj[4]+"</td></tr></table><div  id='mry-opo-content'></div></div>");
	var div = $('#mry-opo');
	$('#mry-opo-title').text(obj.title);
	$('#mry-opo-content').text(obj.content);
	div.css('width',obj.width+'px');
	div.css('height',obj.height+'px');
	div.css('margin-left',-(parseInt(obj.width)/2)+'px');
	div.css('margin-top',-(parseInt(obj.height)/2)+'px');
	div.css('background',obj.backgorund);$('#mry-mask').css('display','block');
	}function del()
	{
	$('#mry-opo').append('<a href="javascript:void(0)" deletes="mry-opo" style="position:absolute;right:10px;top:6px;color:#fff;font-size:12px;">X</a>');
	$('[deletes=mry-opo]').click(function(){$('#mry-opo,#mry-mask').remove();});}$('body').append('<div id="mry-mask" deletes="mry-opo"></div>');var ject=obj;ject.width = parseInt(obj.width)||300;ject.height = parseInt(obj.height)||300;ject.title=obj.title||'来自提示信息';	ject.content = obj.content||'';ject.backgorund=obj.backgorund||'#fff';tanchuang(ject);del();}
  </script>
</html>
