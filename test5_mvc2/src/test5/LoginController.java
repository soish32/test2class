package test5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;


@WebServlet("/LoginController.do")
public class LoginController<jsForward> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;
	private HttpServletResponse respone;
	private boolean isS;
	private String msg;
	private ServletResponse response;
	private String seq;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청확인 하기위한 파라미터 전달받기
				String command = request.getParameter("command");

				//데이터이스 작업을 위한 Dao객체준비
				LoginDao dao = new LoginDao();
				HttpSession session=request.getSession();
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

					boolean isS = dao.insertUser(new LoginDto(0, id, name, password, address, phone, email, null, null, null));
					if (isS) {
						
							response.sendRedirect("LoginController.do?command=loginController");
						jsForward("LoginController.do?command=loginController","회원가입을환영합니다!!!",response);
						} else {
							jsForward("loginController.jsp","회원가입실패!!.",response);
						}
				} else if (command.equals("login")) {
				
					String id = request.getParameter("id");
					String password = request.getParameter("password");
					
					LoginDto ldto = dao.getLogin(id, password);
				
					if (ldto == null || ldto.getId() == null) {
						request.setAttribute("msg", "아이디나 패스워드를 확인하세요");
						//pageContext.forward("error.jsp");

					} else {
						
						session.setAttribute("ldto", ldto);
						session.setMaxInactiveInterval(10 * 60);
						if(ldto.getRole().toUpperCase().equals("ADMIN")){
								   response.sendRedirect("admin_main.jsp");
							}else if(ldto.getRole().toUpperCase().equals("USER")){
								response.sendRedirect("user_main.jsp");
							}else if(ldto.getRole().toUpperCase().equals("MANAGER")){
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
					//PageContext.forward("idchkform.jsp");
					dispatch("loginController.jsp",request,response);
				}else if(command.equals("alluserstatus")){
					List<LoginDto> list=dao.getAllUserStatus();
					request.setAttribute("list", list);
					//pageContext.forward("userlist_status.jsp");
					dispatch("loginController.jsp",request,response);
				}else if(command.equals("alluserlist")){
					List<LoginDto> list=dao.getAllUserList();
					request.setAttribute("list", list);
					//pageContext.forward("userlist.jsp");
					dispatch("loginController.jsp",request,response);
				}else if(command.equals("roleForm")){
					int seq= Integer.parseInt(request.getParameter("seq"));
					LoginDto dto=dao.getUser(seq);
					request.setAttribute("dto", dto);
					//pageContext.forward("authform.jsp");
					dispatch("loginController.jsp",request,response);
				}else if(command.equals("authchange")){
					int seq=Integer.parseInt(request.getParameter("seq"));
					String role=request.getParameter("role");
					boolean isS=dao.updateUserRole(seq,role);
					if(isS){
						response.sendRedirect("LoginController.do?command=loginController");
						    jsForward("LoginController.do?command=loginController","회원수정합니다!!",response);
					}else{
						      jsForward("loginController.jsp","회원의수정에실패했습니다!!",response);
					}
				}else if(command.equals("userInfo")){
					int seq=Integer.parseInt(request.getParameter("seq"));
					LoginDto dto=dao.getInfo(seq);
					request.setAttribute("dto", dto);
					//pageContext.forward("user_info.jsp");
					dispatch("loginController.jsp",request,response);
				}else if(command.equals("updateForm")){
					int seq=Integer.parseInt(request.getParameter("seq"));
					LoginDto dto=dao.getInfo(seq);
					request.setAttribute("dto", dto);
					//pageContext.forward("userupdate.jsp");
					dispatch("loginController.jsp",request,response);
				}else if(command.equals("updateuser")){
					int seq=Integer.parseInt(request.getParameter("seq"));
					String address=request.getParameter("address");
					String phone=request.getParameter("phone");
					String email=request.getParameter("email");
					boolean isS=dao.updateUser(new LoginDto(seq,address,phone,email));
					if(isS){
							
					   response.sendRedirect("LoginController.do?command=loginController");
					   jsForward("LoginController.do?command=loginController&pnum=1", email, response);
					   jsForward("LoginController.do?command=loginController&pnum=1", email, response);
					}
				}
		}
					   
						
							
		
			
		
			
		
								private void dispatch(String id , HttpServletRequest request, 
										HttpServletResponse response)throws ServletException,IOException {
										RequestDispatcher dispatch=request.getRequestDispatcher(id);
										dispatch.forward(request, response);
		}
								public void jsForward(String id, String password, ServletResponse response) throws IOException {
							String str="<script type='text/javascript'>"
									+"alert('"+password+"');"
									+"location.href='"+id+"';"
									+"</script>";
							PrintWriter pw=response.getWriter();
						}
				}
		
						
					
	
					