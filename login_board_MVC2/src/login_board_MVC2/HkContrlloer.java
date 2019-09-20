package login_board_MVC2;

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
import login_board_MVC2.HkDto;
import login_board_MVC2.HkDao;

@WebServlet("/HkContrlloer.do")
public class HkContrlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html/charset=utf-8");
		String command=request.getParameter("command");
		HkDao dao=new HkDao();

		if(command.equals("boardlist")) {
			List<HkDto> list=dao.getAllList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("boardlist.jsp").forward(request,response);
		}else if(command.equals("insertboard")) {
			response.sendRedirect("insertboard.jsp");
		}else if(command.equals("insert")) {
			//여기서는 전송된4개의 파라미터 id,name,title,content를 받는 코드작성
			String id= request.getParameter("id");
			String name=request.getParameter("name");
			String title=request.getParameter("title");
			String content= request.getParameter("content");
			boolean isS=dao.insertBoard(new HkDto(id,name,title,content));
			if(isS) {

				response.sendRedirect("HkController.do?command=boardlist");
				jsForward("HkContrlloer.do?command=boardlist","글 성공적으로 등록했습니다",response);
			}else {

				jsForward("insertboard.jsp","글등록에실패했습니다",response);

			}

		}else if(command.equals("boarddetail")){
			int seq= Integer.parseInt(request.getParameter("seq"));
			HkDto dto= dao.getBoard(seq);
			request.setAttribute("dto", dto);
			//				pageContext.forward("boarddetail.jsp");
			dispatch("boarddetail.jsp",request,response);
		}else if(command.equals("delboard")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			boolean isS=dao.delBoard(seq);
			if(isS) {
				jsForward("HkContrlloer.do?command=boardlist","해당글을삭제합니다",response);
			}else {
				jsForward("HkContrlloer.do?command=boarddetail&seq"+seq,"해당글삭제실패",response);

			}
		}else if(command.equals("updateform")) {
			int seq= Integer.parseInt(request.getParameter("seq"));
			HkDto dto=dao.getBoard(seq);
			request.setAttribute("dto", dto);
			//   			pageContext.forward("boardupdate.jsp");
			dispatch("boardupate.jsp",request,response);

		}else if(command.equals("boardupdate")) {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int seq=Integer.parseInt(request.getParameter("seq"));

			boolean isS=dao.updateBoard(new HkDto(seq,title,content));
			if(isS) {
				jsForward("HkContrllero.do?command=boarddtail&seq="+seq,"글수정성고오옹!",response);
			}else {
				jsForward("HkContrllero.do?command=boardupdate&seq="+seq,"글수정실패에에",response);
			}
		}else if(command.equals("muldel")) {
			String[]seqs=request.getParameterValues("chk");
			if(seqs==null||seqs.length==0) {
					 jsForward("HkController.do?command=boardlist","최소하나이상체크하세요",response);
			}else {
					boolean isS=dao.muldel(seqs);
					if(isS) {
								jsForward("HkContrllero.do?command=boardlist","여러글을삭제합니다",response);
					}else {
						
								jsForward("HKContrllero.do?command=boardlist","여러글을삭제에실패했습니다",response);
					}
			}
		}
	}//doPost()










	private void dispatch(String url, HttpServletRequest request
		,HttpServletResponse response)throws ServletException,IOException	{
		RequestDispatcher dispatch=request.getRequestDispatcher(url);
		dispatch.forward(request, response);
		

	}





	private void jsForward(String url, String msg, HttpServletResponse response)throws IOException{
		String str="<script type='text/javascript'>"
		   		+"alert('"+msg+"');"
		   		+"location.href='"+url+"';"
		   		+"</script>";
		    	PrintWriter pw=response.getWriter();
		    	pw.print(str);

	}
}//class




































