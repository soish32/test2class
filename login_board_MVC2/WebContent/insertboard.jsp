<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content= "text/html; charsetUTF-8">

<title>글추가하기폼</title>
</head>
<body>
<h1>글추가하기</h1>
<form action="HkController.do" method="post">
<input type="hidden" name="command" value="insert"/>
		 <table border="1">
		 		  <col width="100px"><col width="300px">
		 		  <tr>
		 		  	
		 		  	<th>아이디</th>
		 		  	<td><input type="text" name="id" required="required"/></td>
		 		  	</tr>
		 		  	<tr>
		 		  		<th>이름</th>
		 		  	<td><input type="text" name="name" required="required"/></td>
		 		  	</tr>
		 		  	<tr>
		 		  	<th>아이디</th>
		 		  	<td><input type="text" name="title" required="required"/></td>
		 		  	</tr>
		 		  	<tr>
		 		  	<th>아이디</th>
		 		  	<td><textarea rows="10" cols="60" name="content"required="required"></textarea></td>
		 		  	</tr>
		 		  	<tr>
		 		  		<td colspan="2"><input type="submit" value="글추가"/></td>
</table>
</form>
</body>
</html>