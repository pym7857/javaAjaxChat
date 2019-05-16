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

@WebServlet("/ChatListServlet")
public class ChatListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * ChatListServlet
	 * : (Ajax����� �̿��ؼ�) �θ��� ����ڰ� �ְ����� ��ȭ�� ��ȯ���ִ� ����
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String fromID = request.getParameter("fromID");
		String toID = request.getParameter("toID");
		String listType = request.getParameter("listType");
		
		if(fromID == null || fromID.equals("") || toID == null || toID.equals("") 
				|| listType == null || listType.equals(""))
			response.getWriter().write("");	// ���� ���ڿ��� Ŭ���̾�Ʈ���� ��ȯ
		else if (listType.equals("ten")) 
			response.getWriter().write(getTen(URLDecoder.decode(fromID, "UTF-8"),URLDecoder.decode(toID, "UTF-8"))); // getTen �Լ�ȣ�� (+���ڵ�)
		else {
			try {
				response.getWriter().write(getID(URLDecoder.decode(fromID, "UTF-8"),URLDecoder.decode(toID, "UTF-8"),listType));	// getID �Լ�ȣ�� (+���ڵ�) 
			} catch (Exception e) {
				response.getWriter().write("");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public String getTen(String fromID, String toID) {		// ��ȭ���� �ֱ�100�� �������� �Լ�
		
		ChatDAO chatDAO = new ChatDAO();
		ArrayList<ChatDTO> chatList = chatDAO.getChatListByRecent(fromID, toID, 100);
		if(chatList.size() == 0) return "";
		
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		for(int i = 0; i < chatList.size() ; i++) {
			JSONArray arr2 = new JSONArray();
			arr2.add(new JSONObject().put("value", chatList.get(i).getFromID()));
			arr2.add(new JSONObject().put("value", chatList.get(i).getToID()));
			arr2.add(new JSONObject().put("value", chatList.get(i).getChatContent()));
			arr2.add(new JSONObject().put("value", chatList.get(i).getChatTime()));
			arr.add(arr2);	
		}
		obj.put("result", arr); 
		obj.put("last", chatList.get(chatList.size() - 1).getChatID()); // ������ ChatID��������
		return obj.toJSONString();
		
		/*
			 StringBuffer result = new StringBuffer(""); 
			 
			 result.append("{\"result\":[");
			 ChatDAO chatDAO = new ChatDAO(); 
			 ArrayList<ChatDTO> chatList = chatDAO.getChatListByRecent(fromID, toID, 10); 
			 if(chatList.size()== 0) return ""; 
			 for(int i=0;i<chatList.size();i++) {
			 	result.append("[{\"value\": \"" + chatList.get(i).getFromID() + "\"},");
			 	result.append("{\"value\": \"" + chatList.get(i).getToID() + "\"},");
			 	result.append("{\"value\": \"" + chatList.get(i).getChatContent() + "\"},");
			 	result.append("{\"value\": \"" + chatList.get(i).getChatTime() + "\"}]");
			 	if(i != chatList.size() -1) result.append(","); 
			 }
			 result.append("], \"last\":\"" + chatList.get(chatList.size() -1).getChatID() + "\"}");
		*/
	}
	
	@SuppressWarnings("unchecked")
	public String getID(String fromID, String toID, String chatID) {	// Ư�����̵�(chatID)�� ���� ���� �������� �Լ�
		
		ChatDAO chatDAO = new ChatDAO();
		ArrayList<ChatDTO> chatList = chatDAO.getChatListByID(fromID, toID, chatID);
		if(chatList.size() == 0) return "";
		
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		
		for(int i = 0; i < chatList.size() ; i++) {
			JSONArray arr2 = new JSONArray();
			JSONObject obj2 = new JSONObject();
			
			obj2.put("value1", chatList.get(i).getFromID());
			obj2.put("value2", chatList.get(i).getToID());
			obj2.put("value3", chatList.get(i).getChatContent());
			obj2.put("value4", chatList.get(i).getChatTime());
			arr2.add(obj2);
			arr.add(arr2); 
		}
		obj.put("result", arr);
		obj.put("last", chatList.get(chatList.size() - 1).getChatID());
		return obj.toJSONString();
		
		
		/*
			StringBuffer result = new StringBuffer("");
			result.append("{\"result\":[");
			ChatDAO chatDAO = new ChatDAO();
			ArrayList<ChatDTO> chatList = chatDAO.getChatListByID(fromID, toID, chatID);
			if(chatList.size() == 0) return "";
			for(int i=0;i<chatList.size();i++) {
				result.append("[{\"value\": \"" + chatList.get(i).getFromID() + "\"},");
				result.append("{\"value\": \"" + chatList.get(i).getToID() + "\"},");
				result.append("{\"value\": \"" + chatList.get(i).getChatContent() + "\"},");
				result.append("{\"value\": \"" + chatList.get(i).getChatTime() + "\"}]");
				if(i != chatList.size() -1) result.append(",");
			}
			result.append("], \"last\":\"" + chatList.get(chatList.size() - 1).getChatID() + "\"}");
			return result.toString();
		*/
	}

}