<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="login_board_MVC2.HkDto" %>
<%@page import="java.util.List"%>
<%@page import="login_board_MVC2.HkDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title>Insert title here</title>
<script type="text/javascript">
		function allSel(ele){//ele는 전체 선택 체크박스의 여부(true/false)
//        		 alert(ele);
			//어떻게 하면 다른 체크박스의 체크여부를 전달해줄수 있을까???
			//DOM탐색 메서드의 종류: getElementById(), getElementsByName(), getElementsByTagName()
			//                 getElementsByClass(), querySelector() , querySelectorAll()
			var chks=document.getElementsByName("chk");//chks[chk,chk,chk,chk]
			for(var i=0;i<chks.length;i++){
				chks[i].checked=ele;//각각의체크박스에전달받은 체크여부(true/false)를적용
			}
		}

</script>
</head>
<%
//	object obj=request.getAttribute("list");
	List<HkDto> list=(List<HkDto>)request.getAttribute("list");
%>
<body>
	<h1>게시판글목록 조회</h1>
	<form action="HkContrlloer.do" method="post">
		<input type="hidden" name="command" value="muldel" />
		<table border="1">
			<col width="50px">
			<col width="50px">
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<tr>
				<th><input type="checkbox" onclick="allSel(this.checked)" /></th>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<%
	       	if(list==null||list.size()==0){
	       	  		  %>
			<tr>
				<td colspan="5" style="text-align: center;">----작성된글이없습니다.-----</td>
			</tr>
			<%
	       	} else{
	       			
	       			//list의 길이만큼 반복 시킨다
	       			for(int i=0;i<list.size();i++){
	       					  HkDto dto=list.get(i);//list[dto,dto,dto,dto]
	       				  	%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>" /></td>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getId()%></td>
				<td><a
					href="HkContrlloer.do?command=boarddetail&seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
			<%
	       				  	
	       			}
	       	}
	       %>
			<tr>
				<td colspan="5"><a href="HkContrlloer.do?command=insertboard">글추가</a>
					<input type="submit" value="삭제" />
					</td>
					</tr>
		</table>

	</form>
</body>
</html>