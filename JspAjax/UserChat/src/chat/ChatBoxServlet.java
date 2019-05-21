package chat;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/ChatBoxServlet")
public class ChatBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chatset=UTF-8");
		
		String userID = request.getParameter("userID");
		if(userID == null || userID.equals("")) {
			response.getWriter().write("");
		} else {
			try {
				userID = URLDecoder.decode(userID, "UTF-8");
				response.getWriter().write(getBox(userID)); // getBox()
			} catch (Exception e) {
				response.getWriter().write("");
			}
		}
	}
	
	public String getBox(String userID) {

		ChatDAO chatDAO = new ChatDAO();
		ArrayList<ChatDTO> chatList = chatDAO.getBox(userID); // chatDAO.getBox()
		
		if(chatList.size() == 0) return "";
		
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		
		for(int i = chatList.size() - 1; i>=0 ; i--) { // �������� ����
			String unread = "";
			int getUnread = chatDAO.getUnreadChat(chatList.get(i).getFromID(), userID); // ���о� �޼��� ����
			if(userID.equals(chatList.get(i).getToID())) { // �޼����޴� ����� �ڱ��ڽ��̶�� 
				unread = Integer.toString(getUnread); // unread label �������ֱ����� unread ���� ����
				if(unread.equals("0")) unread = ""; // �������� ������ ����ֱ�
			}
			
			JSONArray arr2 = new JSONArray();
			JSONObject obj2 = new JSONObject();
			
			obj2.put("value1", chatList.get(i).getFromID());
			obj2.put("value2", chatList.get(i).getToID());
			obj2.put("value3", chatList.get(i).getChatContent());
			obj2.put("value4", chatList.get(i).getChatTime());
			obj2.put("value5", unread);
			arr2.add(obj2);
			
			
			/*
			arr2.add(new JSONObject().put("value1", chatList.get(i).getFromID()));
			arr2.add(new JSONObject().put("value2", chatList.get(i).getToID()));
			arr2.add(new JSONObject().put("value3", chatList.get(i).getChatContent()));
			arr2.add(new JSONObject().put("value4", chatList.get(i).getChatTime()));
				�� console ��� : {"result":[[null,null,null,null],[null,null,null,null]],"last":5} 
			*/
			
			arr.add(arr2); 
		}
		obj.put("result", arr);
		obj.put("last", chatList.get(chatList.size() - 1).getChatID());
		return obj.toJSONString();
	}

}