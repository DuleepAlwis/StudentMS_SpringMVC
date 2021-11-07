<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.stapp.Entity.UserEntity"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Admin work view
<%
UserEntity ue = (UserEntity)request.getAttribute("user"); 
%>
<h3><%=ue.getName()%></h3> 
</body>
</html>