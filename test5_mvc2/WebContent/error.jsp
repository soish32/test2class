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
<% //request스코프에 담는순간 Object타입으로 형변되어 저장
   //--->Objct로 반환되기때문에 Strig<----(String)---Objct
   		 String msg=(String)request.getAttribute("msg");


%>
<h1>시스템오류</h1>
<h2>관리자에게 문의하세요(오류내용:<%=msg %>)</h2>
<%
   LoginDto ldto=(LoginDto)session.getAttribute("ldto");
    if(ldto==null||ldto.getId()==null){
	   %>
	   <a href="index.jsp">메인페이지</a>
	   <%
	   
   }else{
	   		if(ldto.getRole().equals("ADMIN")){
	   			response.sendRedirect("admin_main.jsp");
	   			
	   		}else if(ldto.getRole().equals("USER")){
	   			response.sendRedirect("user_main.jsp");
	   		}
	   
	 	   
	    }
	  
 %>
</body>
</html>