<%@page import="login_board_MVC2.HkDto"%>
<%@page import="login_board_MVC2.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title>게시글수정하기</title>
</head>
<%
	HkDto dto=(HkDto)request.getAttribute("dto");
%>
<body>
	<h1>게시글수정하기</h1>
	<form action="HkContrlloer.do" method="post">
		<input type="hidden" name="command" value="boardupdate" /> <input
			type="hidden" name="seq" value="<%=dto.getSeq() %>" />
		<table border="1">
			<tr>
				<th>번호</th>
				<td><%=dto.getSeq() %></td>
			</tr>
			<tr>

				<th>아이디</th>
				<td><%=dto.getId() %></td>
			</tr>
			<tr>

				<th>이름</th>
				<td><%=dto.getName() %></td>
			</tr>
			<tr>

				<th>작성일</th>
				<td><%=dto.getRegdate() %></td>
			</tr>
			<tr>

				<th>제목</th>
				<td><input type="text" name="title"
					value="<%=dto.getTitle() %>" /></td>
			</tr>
			<tr>

				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정완료" /></td>
			</tr>
		</table>


	</form>

</body>
</html>