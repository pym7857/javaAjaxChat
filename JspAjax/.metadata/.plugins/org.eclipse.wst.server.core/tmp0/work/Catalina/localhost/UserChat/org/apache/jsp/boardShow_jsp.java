/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.38
 * Generated at: 2019-07-13 09:04:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.BoardDAO;
import board.BoardDTO;
import user.UserDAO;

public final class boardShow_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("board.BoardDAO");
    _jspx_imports_classes.add("board.BoardDTO");
    _jspx_imports_classes.add("user.UserDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");

	String userID = null;
	if(session.getAttribute("userID") != null){
		userID = (String) session.getAttribute("userID");
	}
	String boardID = null;
	if(request.getParameter("boardID") != null) {
		boardID = (String) request.getParameter("boardID");
	}
	BoardDAO boardDAO = new BoardDAO();
	BoardDTO board = boardDAO.getBoard(boardID); // 하나의 게시물에 대한 정보 가져오기
	boardDAO.hit(boardID); // 게시물 들어올때마다 조회수 +1
	
	String boardUser = board.getUserID();
	String fromProfile = new UserDAO().getProfile(boardUser); // 게시물 작성자의 사진
	
	UserDAO userDAO = new UserDAO();
	String userProfile = userDAO.getProfile(userID); // profile의 경로를 가져오는 메서드
	

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/custom.css?versionewg=2\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/custom2.css?versiontff=2\">\r\n");
      out.write("\t<title>JSP Ajax 실시간 회원제 채팅 서비스</title>\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t/* 상단 내비게이션 메세지함 unread 라벨 표시 */\r\n");
      out.write("\t\tfunction getUnread() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\turl: \"./chatUnread\",\r\n");
      out.write("\t\t\t\tdata: {\r\n");
      out.write("\t\t\t\t\tuserID: encodeURIComponent('");
      out.print( userID );
      out.write("'),\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess: function(result) {\r\n");
      out.write("\t\t\t\t\tif(result >= 1) {\r\n");
      out.write("\t\t\t\t\t\tshowUnread(result);\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tshowUnread('');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction getInfiniteUnread() {\r\n");
      out.write("\t\t\tsetInterval(function() {\r\n");
      out.write("\t\t\t\tgetUnread();\r\n");
      out.write("\t\t\t}, 4000);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction showUnread(result) {\r\n");
      out.write("\t\t\t$('#unread').html(result);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar boardID = '");
      out.print( boardID );
      out.write("';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/* 좋아요 개수 표시 함수 */\r\n");
      out.write("\t\tfunction getLike() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\turl: \"./boardLike\",\r\n");
      out.write("\t\t\t\tdata: {boardID: boardID},\r\n");
      out.write("\t\t\t\tsuccess: function(result) {\r\n");
      out.write("\t\t\t\t\tif(result >= 0) {\r\n");
      out.write("\t\t\t\t\t\tshowLikeNumber(result); // result = 좋아요 개수 \r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\t\tconsole.log(boardID);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction showLikeNumber(result) {\r\n");
      out.write("\t\t\t$('#likeNumber').html(result);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction getInfiniteLike() {\r\n");
      out.write("\t\t\tsetInterval(function() {\r\n");
      out.write("\t\t\t\tgetLike();\r\n");
      out.write("\t\t\t}, 4000);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav class=\"navbar navbar-default\">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"index.jsp\">실시간 채팅 서비스</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li><a href=\"index.jsp\">메인</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"find.jsp\">친구찾기</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"box.jsp\">메세지함<span id=\"unread\" class=\"label label-info\"></span></a></li>\r\n");
      out.write("\t\t\t\t<li class=\"active\"><a href=\"boardView.jsp\">자유게시판</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");

				if(userID == null){ // 로그인이 안된사람들에 한해 보여지는 네비게이션 바
			
      out.write("\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">접속하기<span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"login.jsp\">로그인</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"join.jsp\">회원가입</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\t\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");

				} else {
			
      out.write("\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">회원관리<span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"update.jsp\">회원정보수정</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"profileUpdate.jsp\">프로필 사진 수정</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"logoutAction.jsp\">로그아웃</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\t\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li><a href=\"userStatus.jsp\"><img class=\".media-object img-circle\" style=\"media-object: display:none; margin: 0 auto; max-width: 50px; max-height: 50px;\" src=\"");
      out.print( userProfile );
      out.write("\"></img></a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<table class=\"table table-bordered table-hover\" style=\"text-align: center; border: 1px solid #dddddd\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"4\"><h4>게시물 보기</h4></th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"background-color: #fafafa; color: #000000; width: 80px;\"><h5>제목</h5></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><h5>");
      out.print( board.getBoardTitle() );
      out.write("</h5></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"background-color: #fafafa; color: #000000; width: 80px;\"><h5>작성자</h5></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><h5><img class=\"media-object img-circle\" style=\"margin: 0 auto; max-width: 40px; max-height: 40px;\" src=\"");
      out.print( fromProfile );
      out.write("\"></img>");
      out.print( board.getUserID() );
      out.write("</h5></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"background-color: #fafafa; color: #000000; width: 100px;\"><h5>작성날짜</h5></td>\r\n");
      out.write("\t\t\t\t\t<td><h5>");
      out.print( board.getBoardDate() );
      out.write("</h5></td>\r\n");
      out.write("\t\t\t\t\t<td style=\"background-color: #fafafa; color: #000000; width: 80px;\"><h5>조회수</h5></td>\r\n");
      out.write("\t\t\t\t\t<td><h5>");
      out.print( board.getBoardHit() );
      out.write("</h5></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"vertical-align: middle; min-height: 150px; background-color: #fafafa; color: #000000; width:80px;\"><h5>글 내용</h5></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\" style=\"text-align: left;\"><h5>");
      out.print( board.getBoardContent() );
      out.write("</h5></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"background-color: #fafafa; color: #000000; width: 80px;\"><h5>첨부파일</h5></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><h5><a href=\"boardDownload.jsp?boardID=");
      out.print( board.getBoardID() );
      out.write('"');
      out.write('>');
      out.print( board.getBoardFile() );
      out.write("</a></h5></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"5\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"boardLikeUpdate?boardID=");
      out.print( board.getBoardID() );
      out.write("\" class=\"btn btn-primary\" style=\"background-color:white; color:black;\">좋아요 <span id=\"likeNumber\"></span></a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"5\" style=\"text-align: right;\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"boardView.jsp\" class=\"btn btn-primary\">목록</a>\r\n");
      out.write("\t\t\t\t\t\t");

							if(userID.equals(board.getUserID())) { // 작성자 본인만 볼 수 있는 버튼들 
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"boardUpdate.jsp?boardID=");
      out.print( board.getBoardID() );
      out.write("\" class=\"btn btn-primary\">수정</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"boardDelete?boardID=");
      out.print( board.getBoardID() );
      out.write("\" class=\"btn btn-primary\" onclick=\"return confirm('정말로 삭제하시겠습니까?')\">삭제</a>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

		/*
			UserRegisterServlet.java, UserLoginServlet에서 session.setAttribute로 정의한 
			messageContent,messageType 을 session.getAttribute를 통해 가져와서, 색깔설정 등의 messageModal 설정부분
		*/
		String messageContent = null;
		if (session.getAttribute("messageContent") != null) {
			messageContent = (String) session.getAttribute("messageContent");
		}
		String messageType = null;
		if (session.getAttribute("messageType") != null) {
			messageType = (String) session.getAttribute("messageType");
		}
		if (messageContent != null) {
	
      out.write("\r\n");
      out.write("\t<!--  messageModal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"messageModal\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"vertical-alignment-helper\">\r\n");
      out.write("\t\t\t<div class=\"modal-dialog vertical-align-center\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-content ");
 if(messageType.equals("오류 메세지")) out.println("panel-warning"); else out.println("panel-success");
      out.write(" \">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-header panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n");
      out.write("\t\t\t\t\t\t\t<span aria-hidden=\"true\">&times</span>\t\t<!-- x버튼 -->\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"sr-only\">Close</span>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<h4 class=\"modal-title\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print( messageType );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( messageContent );
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">확인</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

		session.removeAttribute("messageContent");
		session.removeAttribute("messageType");
		}
	
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$('#messageModal').modal(\"show\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");

		if(userID != null) {
	
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t\tgetUnread(); // 4초 안기다리고 바로 볼 수 있게 먼저해놓음 \r\n");
      out.write("\t\t\t\tgetInfiniteUnread();\r\n");
      out.write("\t\t\t\tgetLike();\r\n");
      out.write("\t\t\t\tgetInfiniteLike();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}