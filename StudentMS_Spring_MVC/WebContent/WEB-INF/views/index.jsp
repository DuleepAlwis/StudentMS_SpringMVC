<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BlackBoard Student Management System</title>
 <!--  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css"/>-->
 <link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet"> 
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet">
</head>
<body>
	
<img src='<c:url value="/resources/images/classroom_bg_2.jpg"/>' width="100%" height="100%"/>
<div class="outer-box">
<div class="inner-box">
	<span class="box-heading">Login</span>
	<form action="loginUser" method="POST">
		 <div class="mb-3 row">
		    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
		    <span class="col-sm-1"></span>
		    <span class="col-sm-9">
		      <input type="email" name="email" required class="form-control" id="staticEmail" value="">
		    </span>
		  </div>
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
		     <span class="col-sm-1"></span>
		    <span class="col-sm-9">
		      <input type="password" name="password" required class="form-control" id="inputPassword">
		    </span>
		  </div>
		  <div class="mb-3 row">
			  <span class="col-md-4"></span>
			<span class="col-md-4"><input type="submit" value="Login"/>
			<input type="reset" value="Cancel"/></span>
			
		  </div>
	</form>
	<a href="password_forgot">Forgot password?</a>
</div>
</div>
</body>
</html>