<%
response.setHeader("Pragma", "no-cache");//HTTP 1.0
response.setHeader("Cache-Control","no-cache");//HTTP 1.1
response.setHeader("Cache-Control", "no-store");//HTTP 1.1
response.setDateHeader("Expires", 0L);//Do not cache in proxy server
%>
<%@page import="test5.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title>관리자페이지</title>
</head>
<body>
	<%
 LoginDto ldto=(LoginDto)session.getAttribute("ldto");
%>
	<h1>관리자페이지</h1>
	<%
		if(ldto==null){
//	response.sendRedirect("index.jsp");
	pageContext.forward("index.jsp");
		}else{
			%>
	<div><%=ldto.getId() %>님반갑습니다.(등급:<%=ldto.getRole() %>) <a
			href="loginController.jsp?command=logout">로그아웃</a>
	</div>
	<ul>
		<li><a href="loginController.jsp?command=alluserstatus">회원상태정보조회</a>
		<li><a href="loginController.jsp?command=alluserlist">회원정보목록조회</a>
	</ul>
	<%
	
		}
	%>

	 

</body>
</html>