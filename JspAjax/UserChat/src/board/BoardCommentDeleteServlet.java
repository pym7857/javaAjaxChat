package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* JSP �������� ������ �ʰ� ���������� �ٷ� �۾��� �����ϴ� ������ ���, URL�������� �̵��ϴ°��̱� ������ GET �޼��带 ������־�� �Ѵ�.*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost (request, response);
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID"); 	//String userID = request.getParameter("userID");
		
		String commentID = request.getParameter("commentID");
		
		BoardDAO boardDAO = new BoardDAO();
		CommentDTO comment = boardDAO.getComment(commentID);
		
		//System.out.println(userID + " " + comment.getUserID() + " " + commentID);
		
		if(!userID.equals(comment.getUserID())) {
			session.setAttribute("messageType", "���� �޼���");
			session.setAttribute("messageContent", "userID ����");
			response.sendRedirect("index.jsp");
			return;
		}
		
		/* ��� ���ܸ� ����� �Ŀ� */
		int result = boardDAO.deleteComment(commentID); // ����
		if(result == -1) {
			request.getSession().setAttribute("messageType", "���� �޼���");
			request.getSession().setAttribute("messageContent", "������ �� �����ϴ�.");
			response.sendRedirect("index.jsp");
			return;
		}
		else {
			request.getSession().setAttribute("messageType", "���� �޼���");
			request.getSession().setAttribute("messageContent", "������ �����߽��ϴ�.");
			response.sendRedirect("boardView.jsp");
		}
	}

}