<%@page import="test5.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title>idChkform</title>
<script type="text/javascript">
		window.onload=function(){
			var id=opener.document.getElementsByName("id")[0].value;
//현재페이지를 열어준 부모페이지.문서에서 name속성의값이 id인 엘리먼트를구해서. 입력값을얻어옴
			 document.getElementsByName("id")[0].value=id
		
		
		function kk(bool){
			var parentpage=opener.document.getElemenetsByName("id")[0];
			var val=document.getElementsByName("id")[0].value;
			if(bool){
					  opener.document.getElementsByName("name")[0].focus();
					  parentPage.setAttribute("class","y");
			}else{
					parentPage.value="";
					parentPage.focus();
					
			}
			self.close();//현재 창을 닫는다!!
		}
</script>
</head>
<body>
	<%
	LoginDto dto=(LoginDto)request.getAttribute("dto");
	boolean isS=false;
	if(dto==null||dto.getId()==null){
		isS=true;
	}
%>
	<table border="1">
		<tr>
			<%-- 	 <td><input type="text" name="id" value="<%=dto.getId()==null?"":dto.getId()%>"/></td> --%>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td><%=isS?"사용가능합니다.":"중복된아이디입니다." %></td>
		</tr>
		<tr>
			<td><input type="button" value="확인" onclick="kk(<%=isS%>)" /></td>
		</tr>
	</table>
</body>
</html>