<%
response.setHeader("Pragma", "no-cache");//HTTP 1.0
response.setHeader("Cache-Control","no-cache");//HTTP 1.1
response.setHeader("Cache-Control", "no-store");//HTTP 1.1
response.setDateHeader("Expires", 0L);//Do not cache in proxy server
%>
<%@page import="test5.LoginDto" %>
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
	LoginDto ldto=(LoginDto)session.getAttribute("ldto");
	if(ldto==null||ldto.getId()==null){
			 response.sendRedirect("index.jsp");
			 pageContext.forward("index.jsp");
			 
	}else{
			if(ldto.getRole().equals("ADMIN")){
				out.print("<a href='admin_main.jsp'>메인</a>");
				
			}else if(ldto.getRole().equals("USER")){
				out.print("<a href='user_main.jsp'>메인</a>");
			}
	}
%>
<hr/>
</body>
</html>