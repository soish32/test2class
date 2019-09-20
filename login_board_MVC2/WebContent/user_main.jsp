
<%@page import="com.hk.dtos.LoginDto"%>
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
%>
<div><%=ldto.getId() %>님반갑습니다.(등급:<%=ldto.getRole().equals("USER")?"일반회원":"정회원"%>)
		<a href="LoginController.do?command=logout">로그아웃</a>

</div>
<ul>
	<li><a href="LoginController.do?command=userInfo&seq=<%=ldto.getSeq() %>">나의정보조회</a></li>
	<li><a href="HkController.do?command=boardlist">게시글보기</a></li>
</ul>
</body>
</html>