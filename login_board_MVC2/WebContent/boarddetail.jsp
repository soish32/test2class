<%@page import="login_board_MVC2.HkDto" %>
<%@page import="login_board_MVC2.HkDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content= "text/html; charsetUTF-8">

<title>게시글상세보기</title>
</head>
<%
	HkDto dto=(HkDto)request.getAttribute("dto");
%>
<body>
<h1>게시글상세보기</h1>
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
		  		<td><%=dto.getTitle() %></td>
		  		</tr>
		  		<tr>
		  		<th>내용</th>
		  	<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent()%></textarea></td>
		  		</tr>
		  		<tr>
		  			<td colspan="2">
		  			<button onclick="updateBoard(<%=dto.getSeq() %>)">수정</button>
		  			<button onclick="delboard(<%=dto.getSeq()%>)">삭제</button>



</table>

</body>
</html>