
<%@page import="com.hk.dtos.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setContentType("text/html;charset=uTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title></title>
</head>
<body>
	<%
		LoginDto dto = (LoginDto) request.getAttribute("dto");
	%>
	<h1>나의정보수정</h1>
	<form action="LoginController.do" method="post">
		<input type="hidden" name="command" value="updateuser" /> <input
			type="hidden" name="seq" value="<%=dto.getSeq()%>" />
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
				<th>주소</th>
				<td><input type="text" name="address"
					value="<%=dto.getAddress()%>" /></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="phone" value="<%=dto.getPhone()%>" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email"
					value="<%=dto.getEmail()%>" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료">
				
				</td>
			</tr>
			<tr>
		</table>



	</form>
</body>
</html>