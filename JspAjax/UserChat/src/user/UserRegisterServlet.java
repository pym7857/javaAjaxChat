package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegisterServlet") // ������ ȸ�������� ó�����ִ� ������
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * doPost ��?
	 * : Post������� Ŭ���̾�Ʈ���� ��� ���� �޾�����, ó�����ִ� �Լ�
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userID = request.getParameter("userID");
		String userPassword1 = request.getParameter("userPassword1");
		String userPassword2 = request.getParameter("userPassword2");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String userProfile = request.getParameter("userProfile");
		
		if( userID == null || userID.equals("") || userPassword1 == null || userPassword1.equals("") || userPassword2 == null || userPassword2.equals("") || userName == null || userName.equals("") || userAge == null || userAge.equals("") || userGender == null || userGender.equals("") || userEmail == null || userEmail.equals("") ) {
			request.getSession().setAttribute("messageType", "���� �޼���");
			request.getSession().setAttribute("messageContent", "��� ������ �Է��ϼ���");
			response.sendRedirect("join.jsp");
			return;
		}
		if(!userPassword1.equals(userPassword2)) {
			request.getSession().setAttribute("messageType", "���� �޼���");
			request.getSession().setAttribute("messageContent", "��й�ȣ�� ���� �ٸ��ϴ�");
			response.sendRedirect("join.jsp");
			return;
		}
		// ��� ����ó���� ����� ��
		int result = new UserDAO().register(userID, userPassword1, userName, userAge, userGender, userEmail, userProfile);
		if(result == 1) {
			request.getSession().setAttribute("userID", userID);	// ȸ�������� ����������, �ڵ����� �α����� �ǵ��� session������ userID�� �־��� (�α����� �ϸ� ������ session�� ����� ����)
			request.getSession().setAttribute("messageType", "���� �޼���");
			request.getSession().setAttribute("messageContent", "ȸ�����Կ� �����Ͽ����ϴ�");
			response.sendRedirect("index.jsp");
		}
		else {
			request.getSession().setAttribute("messageType", "���� �޼���");
			request.getSession().setAttribute("messageContent", "�̹� �����ϴ� ȸ���Դϴ�");
			response.sendRedirect("join.jsp");
		}
		
	}

}