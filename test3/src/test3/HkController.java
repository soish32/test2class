package test3;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;












@WebServlet("/HkController.do")
public class HkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String command=request.getParameter("command");
		HkDao dao=new HkDao();
		
		if(command.equals("boardlist")) { //글목록 보여주기
			List<HkDto>list=dao.getAllList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("boardlist.jsp").forward(request, response);
		}else if(command.equals("insert")) {
			//여기서는 전송된 4개의 파라미터 id, name, title, content를 받는 코드 작성
			String id= request.getParameter("id");
			String name=request.getParameter("name");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			//4개의 파라미터를 이용해서 dao에 insert 메서드 실행----> 그래야 디비에 게시글이 저장됨
			boolean isS=dao.insertBoard(new HkDto(id,name,title,content));
			
			//그리고 글목록 페이지로 이동하는 코드 작성
			if(isS) {
				response.sendRedirect("HkController.do?command=boardlist");
			}else {
				response.sendRedirect("insertboard.jsp");
			}
			
		}else if (command.equals("boarddetail")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			HkDto dto=dao.getBoard(seq);
			request.setAttribute("dto", dto);
			//pageContext.forward("boarddetail.jsp");
			dispatch("boarddtail.jsp", request,response);
		}else if(command.equals("delboard")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			boolean isS= dao.delBoard(seq);
			if(isS) {
					  jsForward("HkCotroller.do?command=boardlist","해당글을삭제합니다.",response);
				}else {
						jsForward("HkCotroller.do?command=boarddetail"+seq, "해당글삭제실패",response);
						
				}
		}else if(command.equals("updateform")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			HkDto dto=dao.getBoard(seq);
			request.setAttribute("dto", dto);
//					pageContext.forward("boardupdate.jsp");
			dispatch("boardupdate.jsp",request,response);
		}else if(command.equals("boardupate")) {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int seq=Integer.parseInt(request.getParameter("seq"));
			
			boolean isS=dao.updateBoard(new HkDto(seq,title,content));
			if(isS) {
					  jsForward("HkController.do?command=boarddetail&seq="+seq,"글수정성공",response);
			}else {
					  jsForward("HkController.do?command=boardupdate&seq="+seq,"글수정실패",response);
					  
			}
		}else if(command.contentEquals("muldel")) {
			String[] seqs=request.getParameterValues("chk");
			if(seqs==null||seqs.length==0) {
					 jsForward("HkController.do?command=boardlist","최소하나이상체크하세요",response);
					}else {
							boolean isS=dao.muldel(seqs);
							if(isS) {
									  jsForward("HkController.do?comman=boardList","여러글을 삭제합니다.",response);
									  jsForward("HkCotroller.do?command=boardList","여러글삭제실패.",response);
									  
							}
					}
			
		}
			
}//doPost()끝


	private void jsForward(String url, String msg,  HttpServletResponse response)throws IOException {
		String str="<script type='text/javascript'>"
				+"alert('"+msg+"');"
				+"location.href='"+url+"';"
				+"</script>";
				
	}


	private void dispatch(String url, HttpServletRequest request
			,HttpServletResponse response)throws ServletException,IOException{
		RequestDispatcher dispatch=request.getRequestDispatcher(url);
		dispatch.forward(request, response);
					
		
	}


	
	
	
}//class끝


