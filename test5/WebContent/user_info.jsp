<%@include file="header.jsp" %>
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
		LoginDto dto=(LoginDto)request.getAttribute("dto");
%>
<h1>나의정보</h1>
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
			 <td><%=dto.getAddress()%></td>
			 </tr>
			 <tr>
			 
			  <th>전화번호</th>
			 <td><%=dto.getPhone()%></td>
			 </tr>
			 <tr>
			  	<th>이메일</th>
			 <td><%=dto.getEmail()%></td>
			 </tr>
			 <tr>
			 	 <td colspan="2">
			 	 <button onclick="updateUser(<%=dto.getSeq()%>)">수정</button>
			 	 <button onclick="delUser(<%=dto.getSeq()%>)">탈퇴</button>
			 	 </td>
			 	 </tr>
			</table>
			<script type="text/javascript">
			function updateUser(seq){
				location.href="loginController.jsp?command=updateForm&seq="+seq;
				
			}
			function delUser(seq){
				location.href="loginCotroller.jsp?command=delUser&seq="+seq;
			}
</script>
</body>
</html>