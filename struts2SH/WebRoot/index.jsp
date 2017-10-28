<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
  
    <s:form action="ad_login" theme="simple">
    
    <s:textfield label="用户名" name="name" /><br>
    <s:fielderror name="name" cssStyle="color:red;list-style-type:none;"></s:fielderror>
    <s:password label="密码" name="password"></s:password>
    <s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
