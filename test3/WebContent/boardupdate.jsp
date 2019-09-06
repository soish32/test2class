<%@page import="test3.HkDao"%>
<%@page import="test3.HkDto"%>
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

<title>게시글수정하기</title>
</head>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	HkDao dao = new HkDao();
	HkDto dto = dao.getBoard(seq);
%>
<body>
	<h1>게시글수정하기</h1>
	<form action="boardupdate_after.jsp" method="post">
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>" />
		<table border="1">
			<tr>
				<th>번호
				<th>
				<td><%=dto.getSeq()%>
			</tr>
			<tr>
				<th>아이디
				<th>
				<td><%=dto.getId()%>
			</tr>
			<tr>
				<th>이름
				<th>
				<td><%=dto.getName()%>
			</tr>
			<tr>
				<th>번호
				<th>
				<td><%=dto.getSeq()%>
			</tr>
			<tr>
				<th>번호
				<th>
				<td><%=dto.getRegdate()%>
			</tr>
			<tr>
				<th>제목
				<th>
				<td><input type="text" name="tilte" value="<%=dto.getTitle()%>" /></td>
			</tr>
			<tr>
				<th>내용
				<th>
				<td><textarea rows="10" cols="60" name="contnet"><%=dto.getContent()%></textarea></td>

			</tr>
			<tr>
			<td colspan="2">
				<input type="submit" value="수정완료" />
				<button type="button" onclick="location.href='HkController.do?command=boardlist">글목록</button>
				</td>
			</tr>







		</table>

	</form>
</body>
</html>