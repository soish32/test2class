<%@page import="test5.LoginDto" %>
<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content= "text/html; charsetUTF-8">

<title></title>
</head>
<body>
<%
	LoginDto dto=(LoginDto)request.getAttribute("dto");
%>
<h1>등급변경</h1>
<form action="loginController.jsp" method="post">


</form>
</body>
</html>