<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=uTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title></title>
<script type="text/javascript">
//사용한 이벤트: onload,onsubmit
//submit이벤트를 취소하는 방법: return false
//DOM의 개념: 탐색하는 메서드-getElementsByTagName(), querySelectorAll(), parentNode .......
//input 태그의 입력값을 구하는 방법: input.value

//현재 페이지가 로딩되면 함수를 실행한다.
window.onload=function(){
	var form=document.getElementsByTagName("form")[0];//[form]
	//form태그에서 submit이벤트가 발생하면 함수를 실행해라
	form.onsubmit=function(){//패스워드가 정확해게 입력됐는지와 모든 입력값을 넣었는지 확인
		var inputs=document.querySelectorAll("table input");//[input,input....]
		if(inputs[3].value!=inputs[4].value){
			alert("패스워드를 확인하세요!!");
			inputs[3].value="";
			inputs[4].value="";
			inputs[3].focus();
			return false;//유효하지 않은 값이 존재하면 submit전송기능 취소해야 한다.
		}else{
			for (var i = 0; i < inputs.length; i++) {
				if(inputs[i].value==""){
					var tagEleTxt=inputs[i].parentNode.previousElementSibling.textContent;
					//                     .부모태그구함.  앞에오는 형제엘리먼트구함.      내부에 text구함
					alert(tagEleTxt+"를 입력하세요!!");
					inputs[i].focus();
					return false;
				}
			}
		}
	}
}

function idChk(){
	var id=document.getElementsByName("id")[0].value;
	//open("url","title","창의 속성 설정")
	window.open("loginController.jsp?command=idChk&id="+id,"",
					   "width=300px,height=300px");
}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="loginController.jsp" method="post">
		<input type="hidden" name="command" value="insertuser" />
		<table border="1">
			<tr>
				<th>아이디</th>
					<td	>
						<input type="text" name="id" class="n" /> 
						<input type="button" value="중복체크" onclick="idChk()"/>	
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>패스워드</th>

				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<th>패스워드확인</th>
				<td><input type="password" name="password2" /></td>

			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" /></td>

			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="phone" /></td>

			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" /></td>

			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="가입완료" /> 
			
		</td>
			</tr>
		</table>


	</form>
</body>
</html>