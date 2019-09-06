package test3;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;



@WebServlet("/HkController.do")
public class HkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String command=request.getParameter("command");
		HkDao dao=new HkDao();
		
		if(command.equals("boardlist")) {
			List<HkDto>list=dao.getAllList();
			request.setAttribute("list", list);
			
		request.getRequestDispatcher("boardlist.jsp").forward(request, response);
		}else if(command.equals("insert")) {
			//여기서는 전송된 4개의 파라미터 id, name, title, content를 받는 코드 작성
			String id= request.getParameter("id");
			String name=request.getParameter("name");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			boolean isS=insertBoard(new HkDto(id,name,title,content));
			if(isS) {
				
			}
			
			//4개의 파라미터를 이용해서 dao에 insert 메서드 실행----> 그래야 디비에 게시글이 저장됨
			
			//그리고 글목록 페이지로 이동하는 코드 작성
		
		}
	}


		
	


	private boolean insertBoard(HkDto hkDto) {
		// TODO Auto-generated method stub
		return false;
	}

	
	}


