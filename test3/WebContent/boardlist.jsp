<%@page import="test3.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="test3.HkDao"%>
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
		 function allSel(ele){// ele는 전체 선택 체크박스의 체크여부(true/false)
		          alert(ele);
		 		  //어떻게하면 다른 체크박스의 체크여부를 전달 해줄수있을까???
		 		  //DOM탐색 메서드의 종류:getElementById(),getElementsByName(),getElementsByTagName()
		 		  // 	 	getElementsByClass(),querySelector(),querySelectorAll()
		 		  var chks=document.getElementsByName("chk");//chks[chk,chk,chk,chk]
		 		  for(var i=0;i<chks.length;i++){
		 			  chks[i].checked=ele;//각각의 체크박스에 전달받은 체크 여부(true/false)를적용
		 		  }
		 }
</script>
</head>

<%
// 		Object obj=request.getAtrribute("list");
		List<HkDto>list=(List<HkDto>)request.getAttribute("list");

%>
<body>
	<h1>게시판글목록조회</h1>
	<form action="muldelboard.jsp" method="post">
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
				<td colspan="4" style="text-align: center;">----작성된글이없습니다,---</td>
			</tr>
			<%
			}else{
				for(int i=0;i<list.size();i++){
								HkDto dto=list.get(i);
							%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>" /></td>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getId()%></td>
				<td><a href="boarddetail.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getRegdate()%></td>
			</tr>
			<%
				}
			}
								
			%>
			<tr>
				<td colspan="5">
					<input type="submit" value="삭제" />
			</td>
			</tr>

		</table>

	</form>

</body>
</html>