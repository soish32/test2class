

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test6.testAnsDao;
import test6.testAnsDto;

@WebServlet("/testAnsController.do")
public class testAnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String command=request.getParameter("command");

		testAnsDao dao=new testAnsDao();

		if(command.equals("boardlist"));
		//"readcount"값을 삭제한다.
		request.getSession().removeAttribute("readcount");

		List<testAnsDto> list=dao.getAllList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("boardlist.jsp").forward(request,response);
		dispatch("boardlist.jsp",request,response);
	}


	private void dispatch(String string, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
	





	










