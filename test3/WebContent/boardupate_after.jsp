<%@page import="test3.HkDto" %>
<%@page import="test3.HkDao" %>
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
	//전달된값 :seq	="4"&title="제목"&content="내용"
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	int seq= Integer.parseInt(request.getParameter("seq"));
	
	HkDao dao=new HkDao();
	boolean isS= dao.updateBoard(new HkDto(seq,title,content)); 
	if(isS){
			%>
			<script type="text/javascript">
					  alert("글수정성공");
					  location.href="boarddetail.jsp?seq=<%=seq%>";
			</script>
			<%
	}else{
		
			%>
			<script type="text/javascript">
					  alert("글수정실패");
					  location.href="boardupdate.jsp?seq=<%=seq%>";
			</script>
			<%
			
			
	}
	%>	
</body>
</html>