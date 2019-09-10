
<%
response.setHeader("Pragma", "no-cache");//HTTP 1.0
response.setHeader("Cache-Control","no-cache");//HTTP 1.1
response.setHeader("Cache-Control", "no-store");//HTTP 1.1
response.setDateHeader("Expires", 0L);//Do not cache in proxy server
%>
<%@page import="test5.LoginDto" %>


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
	
	</table>
</body>
</html>