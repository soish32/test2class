<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="test5.LoginDto"%>
<%@page import="java.util.List"%>
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
	List<LoginDto>list=(List<LoginDto>)request.getAttribute("list");
%>
	<h1>회원리스트조회</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>등급</th>
			<th>가입일</th>
		</tr>
		<%
		  		for(LoginDto dto:list){
		  		%>
		<tr>
			<td><%=dto.getSeq()%></td>
			<td><%=dto.getId()%></td>
			<td><%=dto.getName()%></td>
			<td>
				<%=dto.getRole()%>
				<button onclick="auth(<%=dto.getSeq()%>)">변경</button>
			</td>
			<td><%=dto.getRegdate()%></td>
		</tr>
		<%
		  		}
		  				
		  				
		  				%>
		  				
</table>
<script type="text/javascript">
		 function auth(seq){
			 //등급변경폼으로이동
			 location.href="loginController.jsp?command=roleForm&seq="+seq;
		 }

</script>

</body>
</html>