package login_board_MVC2;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login_board_MVC2.HkDto;
import login_board_MVC2.HkDao;

@WebServlet("/HkContrlloer.do")
public class HkContrlloer extends HttpServlet {
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
		request. setCharacterEncoding("uft-8");
		response.setCharacterEncoding("text/html;charset=utf-8");

		//session객체 사용하는방법
		//		HttpSession session=request.getSession();
		//session.setAttribute("ldto",dto);
		//session.getAttribute("ldto");
		//LoginDto ldto=	request.getSession().getAttribute("ldto");

		String command=request.getParameter("command");

		HkDao dao= new HkDao();

		if(command.equals("boardlist")) {
		List<HkDto> list= dao.getAllList();
					request.setAttribute("list", list);
			dispatch("boardlist.jsp",request,response);
			//                                  pageContext.forward("boardlist.jsp");
			//dopost()

		}else if(command.contentEquals("lisertboard.jsp")) {
			response.sendRedirect("insertboard.jsp");
			response.sendRedirect("insertboard");
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String title=request.getParameter("title");
			String content=request.getParameter("content");

			if(isS) {
				response.sendRedirect("HkController.do?command=boradlist");
				jsForward("Hkcontroller.do?command=boardlist","글을 성공적으로 등록했습니다", response);

			}else {
				jsForward("insertboard.jsp","글등록에실패하였습니다.",response);
			}
		}else if(command.contentEquals("boarddetail")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			HkDto dto= dao.getBoard(seq);
			request.setAttribute("dto", dto);
			//pageContext.forward("boarddil.jsp")
			dispatch("boarddetail.jsp",request, response);
			dispatch("boarddetail.jsp",request,response);
			
		}
	}



	private void jsForward(String string, String string2, HttpServletResponse response2) {
		// TODO Auto-generated method stub

	}


	private void dispatch(String string, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
