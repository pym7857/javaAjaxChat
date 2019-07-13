package board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import user.UserDAO;

public class BoardLikeUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String boardID = request.getParameter("boardID");
		
		/* 예외처리 */
		if(boardID == null || boardID.equals("")) {
			request.getSession().setAttribute("messageType", "오류 메세지");
			request.getSession().setAttribute("messageContent", "boardID 오류");
			response.sendRedirect("index.jsp");
			return;
		}
		
		BoardDAO boardDAO = new BoardDAO();
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID"); 
		
		BoardDTO board = boardDAO.getBoard(boardID);
		
		/* 본인 게시글에는 추천을 할 수 없도록 */
		if(userID.equals(board.getUserID())) {
			request.getSession().setAttribute("messageType", "오류 메세지");
			request.getSession().setAttribute("messageContent", "본인 글에는 추천할 수 없습니다.");
			response.sendRedirect("boardShow.jsp?boardID=" + boardID);
			return;
		}
		
		boardDAO.likeUpdate(boardID);
		request.getSession().setAttribute("messageType", "성공 메세지");
		request.getSession().setAttribute("messageContent", "추천!");
		response.sendRedirect("boardShow.jsp?boardID=" + boardID);
		return;
		
	}

}
