<%@page import="test3.HkDao"%>
<%@page import="test3.HkDto"%>
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
	<%//scriptlet(실행부)
//전달된 파라미터 내용: id=hk&name=한경&title=제목&content=내용
//request.getParameter("파라미터이름")
String id=request.getParameter("id");
String name=request.getParameter("name");
String title=request.getParameter("title");
String content=request.getParameter("content");

HkDao dao=new HkDao();
//HkDto dto=new HkDto();
//dto.setId(id);
//dto.setName(name);
//dto.setTitle(title);
//dto.setContent(content);

//insertBoard메서드에서 데이터 추가가 성공되면 truef를반환하고 isS에 저장
boolean isS=dao.insertBoard(new HkDto(id,name,title,content));
 if(isS){
	 	 response.sendRedirect("boardlist.jsp");
	 	 %>
	<script type="text/javascript">
	 	 				  alert("글을 성공적으로 등록했습니다.");
	 	 				  location.href="boardlist.jsp";
	 	 		 </script>
	<%
 }else{
	 	 		 %>
	<script type="text/javascript">
	 	 		 					alert("글을등록에 실패하였습니다.");
	 	 		 					location.href="insertboard.jsp";
	 	 		 		</script>
	<%
 }
 		%>
 	

</body>
</html>