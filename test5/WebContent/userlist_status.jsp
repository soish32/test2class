
<%
response.setHeader("Pragma", "no-cache");//HTTP 1.0
response.setHeader("Cache-Control","no-cache");//HTTP 1.1
response.setHeader("Cache-Control", "no-store");//HTTP 1.1
response.setDateHeader("Expires", 0L);//Do not cache in proxy server
%>
<%@include file="header.jsp"%>
<%@page import="test5.LoginDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title></title>
</head>
<body>
	<h1>회원정보상태조회</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>탈퇴여부</th>
			<th>회원등급</th>
			<th>가입일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="9">-------가입된회원이 존재하지않습니다.-----</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="{list}" var="dto">
					<tr>
						<td>${dto.seq }</td>
						<td>${dto.id }</td>
						<td>${dto.name }</td>
						<td>${dto.name }</td>
						<td>${dto.address }</td>
						<td>${dto.phone }</td>
						<td>${dto.email }</td>
						<td>${dto.enabled }</td>
						<td>${dto.role }</td>
						<td>${dto.regdate}</td>

					</tr>


				</c:forEach>


			</c:otherwise>
		</c:choose>


	</table>
</body>
</html>