<%@page import="test5.LoginDto"%>
<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title></title>
</head>
<body>
	<%
	LoginDto dto=(LoginDto)request.getAttribute("dto");
%>
	<h1>등급변경</h1>
	<form action="loginController.jsp" method="post">
		<input type="hidden" name="command" value="authchange" /> <input
			type="hidden" name="seq" value="<%=dto.getSeq() %>" />
		<table border="1">
			<tr>
				<th>번호</th>
				<td><%=dto.getSeq()%></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><%=dto.getId()%></td>
			</tr>
			<tr>

				<th>이름</th>
				<td><%=dto.getName()%></td>
			</tr>
			<tr>

				<th>등급</th>
				<td><select name="role">
						<option value="ADMIN" <%=dto.getRole().equals("ADMIN")?"selected":""%> >관리자</option>
				<option value="MANAGER" <%=dto.getRole().equals("MANAGER")?"selected":""%> >정회원</option>
				<option value="USER" <%=dto.getRole().equals("USER")?"selected":""%>>일반회원</option>


				</select>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등급변경" /></td>
			</tr>







		</table>

	</form>
</body>
</html>