<%@page import="java.util.List" %>
<%@page import="test5.LoginDao"%>
<%@page import="test5.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setContentType("text/html;charset=uTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="COntent-Type" content="text/html; charsetUTF-8">

<title>Insert title here</title>
</head>
<body>
	<%
		//요청확인 하기위한 파라미터 전달받기
		String command = request.getParameter("command");

		//데이터이스 작업을 위한 Dao객체준비
		LoginDao dao = new LoginDao();

		//요청에 대한 작업을 분기해서 실행
		if (command.equals("regist")) {
			response.sendRedirect("regist.jsp");

		} else if (command.equals("insertuser")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");

			boolean isS = dao
					.insertUser(new LoginDto(0, id, name, password, address, phone, email, null, null, null));
			if (isS) {
	%>
	<script type="text/javascript">
		alert("회원가입을 축하합니다.");
		location.href = "index.jsp";
	</script>
	<%
		} else {
				request.setAttribute("msg", "회원가입실패");
				pageContext.forward("error.jsp");
			}

		} else if (command.equals("login")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			LoginDto ldto = dao.getLogin(id, password);

			if (ldto == null || ldto.getId() == null) {
				request.setAttribute("msg", "아이디나 패스워드를 확인하세요");
				pageContext.forward("error.jsp");

			} else {

				session.setAttribute("ldto", ldto);
				session.setMaxInactiveInterval(10 * 60);
				if(ldto.getRole().toUpperCase().equals("ADMlN")){
						   response.sendRedirect("admin_main.jsp");
				}else if(ldto.getRole().toUpperCase().equals("USER")){
					response.sendRedirect("user_main.jsp");
					
				}

			}
		}else if(command.equals("logout")){
			session.invalidate();//session정보 삭제
			response.sendRedirect("index.jsp");
		}else if(command.equals("idChk")){
			String id=request.getParameter("id");
			LoginDto dto=dao.idChk(id);
			request.setAttribute("dto", dto);
			pageContext.forward("idchkform.jsp");
			
		}else if(command.equals("alluserstatus")){
			List<LoginDto> list=dao.getAllUserStatus();
			request.setAttribute("list", list);
			pageContext.forward("userlist_staus.jsp");
		}else if(command.equals("roleForm")){
			int seq= Integer.parseInt(request.getParameter("seq"));
			LoginDto dto=dao.getUser(seq);
			request.setAttribute("dto", dto);
			pageContext.forward("authform.jsp");
			
		}else if(command.equals("authchange")){
			int seq=Integer.parseInt(request.getParameter("seq"));
			String role=request.getParameter("role");
			boolean isS=dao.updateUserRole(seq,role);
			if(isS){
				      %>
				      <script type="text/javascript">
				      alert("회원등급을 수정했습니다.");
				      location.href="loginController.jsp?"command=alluserlist";
			}
				</script>
				<%
		}else{
				request.setAttribute("msg", "회원등급변경실패");
				pageContext.forward("error.jsp");
			
			}
		}else if(command.equals("userInfo")){
			int seq=Integer.parseInt(request.getParameter("seq"));
			LoginDto dto=dao.getInfo(seq);
			request.setAttribute("dto", dto);
			pageContext.forward("userupdate.jsp");
			
		}
	
%>
</body>
</html>