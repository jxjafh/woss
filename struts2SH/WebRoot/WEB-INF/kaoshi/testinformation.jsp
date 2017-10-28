<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="kaoshi.daoimpl.*" %>
<%@ page import="test.domain.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testinformation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    List listExams=(List)request.getAttribute("listExams");
    int m=0;
    %>
    <form name="form1" action="" method="post">
    <table width="776" border="1">
    <tr>
    <td height="38" colspan="4"><div align="center">消息提示:${msg}</div></td>
    </tr>
    <tr>
    <td height="27">选择</td>
    <td width="320"><div align="center">试卷名</div></td>
    <td width="320"><div align="center">设定该试卷下的试题</div></td>
    <td width="320"><div align="center">进行考试</div></td>
    </tr>
    <% 
    for(int i=0;i<listExams.size();i++){
    Exam exam=(Exam)listExams.get(i);
    m++;
    %>
    <tr>
    <td>
    <input type="checkbox" name="checkbox" value="<%=i%>">
    <input type="hidden" name="examid<%=i%>">
    </td>
    </tr>
    <%} %>
    </table>
    </form>
  </body>
</html>
