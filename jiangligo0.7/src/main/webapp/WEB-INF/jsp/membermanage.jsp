<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'membermanage.jsp' starting page</title>
    
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
    <td>性别</td>
    <td>信誉</td>
    <td>状态</td>
    <td>电话</td>
    <td>邮箱</td>
    <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
    <td>${list.id}</td>
    <td>${list.username}</td>
    <td>${list.gender}</td>
    <td>${list.evaluate}</td>
    <td>${list.state}</td>
    <td>${list.telephone}</td>
    <td>${list.email}</td>
    <td><a class="pass" onclick="pass(this)" href="javascript:void(0);"><p class="pid" style="display:none;">${list.id}</p>通过</a></td>
    </tr>
    </c:forEach>
    </table>
    <p>&nbsp;</p>
        <!-- 分页 -->
    <table>
  <tr><a class="bottoma" href="admin/allmember.do?intal=0">首页</a>&nbsp;
<c:choose>
<%--第三页以前 --%>
<c:when test="${page<3}">  
<c:forEach var="i" begin="0" end="4">
<c:choose>
<c:when test="${i==page&&page<(sum-1)}">
<a style="color:white;background:orangered;" class="bottoma" href="admin/allmember.do?intal=${i*size}">${i+1}</a>&nbsp;
</c:when>
<c:otherwise>
<a class="bottoma" href="admin/allmember.do?intal=${i*size}">${i+1}</a>&nbsp;
</c:otherwise>
</c:choose>
</c:forEach> 
</c:when>
<%--最后第二页--%>
<c:when test="${page==(sum-1)}">
'''
<a class="bottoma" href="admin/allmember.do?intal=${(page-2)*size}">${page-1}</a>&nbsp;
<a class="bottoma" href="admin/allmember.do?intal=${(page-1)*size}">${page}</a>&nbsp;
<a class="bottoma" style="color:white;background:orangered;" href="admin/allmember.do?intal=${(page)*size}">${page+1}</a>&nbsp;
<a class="bottoma" href="admin/allmember.do?intal=${(page+1)*size}">${page+2}</a>&nbsp;
</c:when>
<%--最后第一页 --%>
<c:when test="${page==sum}">
'''
<a class="bottoma" href="admin/allmember.do?intal=${(page-2)*size}">${page-1}</a>&nbsp;
<a class="bottoma" href="admin/allmember.do?intal=${(page-1)*size}">${page}</a>&nbsp;
<a class="bottoma" style="color:white;background:orangered;" href="admin/allmember.do?intal=${(page)*size}">${page+1}</a>&nbsp;
</c:when>
<%--第三到最后第二页 --%>
<c:otherwise>
'''
<a class="bottoma" href="admin/allmember.do?intal=${(page-2)*size}">${page-1}</a>&nbsp;
<a class="bottoma" href="admin/allmember.do?intal=${(page-1)*size}">${page}</a>&nbsp;
<a class="bottoma" style="color:white;background:orangered;" href="admin/allmember.do?intal=${(page)*10}">${page+1}</a>&nbsp;
<a class="bottoma" href="admin/allmember.do?intal=${(page+1)*size}">${page+2}</a>&nbsp;
<a class="bottoma" href="admin/allmember.do?intal=${(page+2)*size}">${page+3}</a>&nbsp;
</c:otherwise>
</c:choose>
'''
<a class="bottoma" href="admin/allmember.do?intal=${sum*size}">末页</a>
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
  $.post("admin/memberchangebyidpiliang.do?id="+id+"",function(data){
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
  if(confirm("确认通过该会员？")){
  var id=$(""+$(obj).html()+">p").html();
  $.post("admin/changebyid.do?id="+id+"",function(data){
  alert(data);
  window.location.reload();
  });
  }
  else{
  return false;
  }
  }

</script>
  </body>
</html>
