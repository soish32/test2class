<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title>로그인화면</title>
<script type="text/javascript">
		 function regist(){
			 location.href="loginController.jsp?"command=regist";
			 
		 }
</script>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginController.jsp" method="post">
		<input type="hidden" name="command" value="login" />
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인" /> <input
					type="button" value="회원가입" onclick="regist()" />
			  </td>
			</tr>
		</table>


	</form>
</body>
</html>