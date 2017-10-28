<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" import="java.util.*,java.util.List" pageEncoding="utf-8"%>
<%@ page import="jxlg.xyh.daoimpl.*" %>
<%@ page import="jxlg.xyh.domain.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'ok.jsp' starting page</title>
    
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
    欢迎<s:property value="name"/><br>
    <%
    //bean
    adDAO addao=(adDAO)WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()).getBean("adDAO");
    int i=1;
    // PageNumber=Integer.parseInt(request.getAttribute("pageSum").toString());
    System.out.println(i+"  "+request.getParameter("pageNumber"));
  %>
  <c:forEach items="${list}" var="list">
 姓名:${list.id}
 编号: ${list.name} 
 <a href="${pageContext.request.contextPath}/ad_delete.action?id=${list.id}">删除数据</a>
 </br>   
  </c:forEach>
   <a href="${pageContext.request.contextPath}/">首页</a>
   <a href="${pageContext.request.contextPath}/ok.jsp.action?pageNumber=<%=(i-1)%>">上页</a> 
          
    <c:forEach begin="1" end="${pageSum}" var="j">
    <a href="${pageContext.request.contextPath}/ad_paging.action?pageNumber=${j}">${j}</a>
    </c:forEach>
    
    <a href="${pageContext.request.contextPath}/ok.jsp.action?pageNumber=<%=(i+1)%>">下页</a>
    <a href="${pageContext.request.contextPath}/ok.jsp.action?pageNumber=${pageSum}">末页</a>
  </body>
</html>
