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
	<%
	int seq=Integer.parseInt(request.getParameter("seq"));
    HkDao dao=new HkDao();
    boolean isS=dao.delBoard(seq);
    if(isS){
    	
    }

%>
	<script type="text/javascript">
     		 alert("해당글을 삭제합니다.");
     		 location.href="boardlist.jsp";
     </script>
	<%
     

     
    
   	 %>
	<script type="text/javascript">
   	 		   alert("해당글 삭제 실패")
   	 		   location.href="boarddetail.jsp?"seq=<%=seq%>";
   	 		  
   	 		   
   	 		   
   	 		  </script>
	<%
   

   	 		  
   	 		  %>

</body>
</html>