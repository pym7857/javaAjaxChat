/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.38
 * Generated at: 2019-05-17 02:06:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/custom.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/custom2.css\">\r\n");
      out.write("\t<title>JSP Ajax 실시간 회원제 채팅 서비스</title>\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t/* 이벤트 처리 */\r\n");
      out.write("\t\tfunction registerCheckFunction() {\t\t// Function(): ajax로 모달 띄워주는 역할\r\n");
      out.write("\t\t\tvar userID = $('#userID').val();\t\t// (input 부분의) id:userID\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: 'POST',\r\n");
      out.write("\t\t\t\turl: './UserRegisterCheckServlet',\r\n");
      out.write("\t\t\t\tdata: {userID: userID},\r\n");
      out.write("\t\t\t\tsuccess: function(result) {\t\t// result는... (UserRegisterCheckServlet) response.getWriter.write( userDAO.registerCheck(result) ) 로 부터...\r\n");
      out.write("\t\t\t\t\tif(result == 1) { \r\n");
      out.write("\t\t\t\t\t\t$('#checkMessage').html('사용할 수 있는 아이디입니다.');\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t$('#checkType').attr('class', 'modal-content panel-success');\t// 초록\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$('#checkMessage').html('사용할 수 없는 아이디입니다.');\r\n");
      out.write("\t\t\t\t\t\t$('#checkType').attr('class', 'modal-content panel-warning');\t// 노랑\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t$('#checkModal').modal(\"show\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction passwordCheckFunction() {\r\n");
      out.write("\t\t\tvar userPassword1 = $('#userPassword1').val();\t\t// Line:116\r\n");
      out.write("\t\t\tvar userPassword2 = $('#userPassword2').val();\r\n");
      out.write("\t\t\tif(userPassword1 != userPassword2) {\r\n");
      out.write("\t\t\t\t$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');\t\t// Line 151:  <h5 id:psswordCheckMessage></h5>\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$('#passwordCheckMessage').html('');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		if(userID != null) {
			session.setAttribute("messageType", "오류 메세지");
			session.setAttribute("messageContent", "이미 로그인된 회원입니다.");
			response.sendRedirect("index.jsp");
			return;
		}
	
      out.write("\r\n");
      out.write("\t<nav class=\"navbar navbar-default\">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"main.jsp\">실시간 회원제 채팅 서비스</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li class=\"active\"><a href=\"main.jsp\">메인</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"find.jsp\">친구찾기</a></li>\r\n");
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

				}
			
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<!-- POST방식으로 ./userRegister으로 이동하는 부분 \r\n");
      out.write("\t\t\tweb.xml 에 ./userRegister로 이동할시 userRegisterServlet으로 이동하도록 설정했었다. \r\n");
      out.write("\t\t\t\tuserRegisterServlet에서 각종 로그인관련된 messageContent를 Session에 설정하도록 되어있음 -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<form method=\"post\" action=\"./userRegister\">\r\n");
      out.write("\t\t\t<table class=\"table table-bordered table-hover\" style=\"text-align:center; border:1px solid black\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"3\"><h4>회원 등록 양식</h4></th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:110px;\"><h5>아이디</h5></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"form-control\" type=\"text\" id=\"userID\" name=\"userID\" maxlength=\"20\" placeholder=\"아이디를 입력하세요\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:110px;\"><button class=\"btn btn-warning\" onclick=\"registerCheckFunction();\" type=\"button\">중복체크</button></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:110px;\"><h5>비밀번호</h5></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"><input onkeyup=\"passwordCheckFunction();\" class=\"form-control\" type=\"password\" id=\"userPassword1\" name=\"userPassword1\" maxlength=\"20\" placeholder=\"비밀번호를 입력하세요\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:110px;\"><h5>비밀번호 확인</h5></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"><input onkeyup=\"passwordCheckFunction();\" class=\"form-control\" type=\"password\" id=\"userPassword2\" name=\"userPassword2\" maxlength=\"20\" placeholder=\"비밀번호를 다시 입력하세요\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:110px;\"><h5>이름</h5></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"><input class=\"form-control\" type=\"text\" id=\"userName\" name=\"userName\" maxlength=\"20\" placeholder=\"이름을 입력하세요\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:110px;\"><h5>나이</h5></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"><input class=\"form-control\" type=\"number\" id=\"userAge\" name=\"userAge\" maxlength=\"20\" placeholder=\"나이를 입력하세요\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:110px;\"><h5>성별</h5></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\" style=\"text-align:center; margin:0 auto;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"btn-group\" data-toggle=\"buttons\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"btn btn-primary active\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"userGender\" autocomplete=\"off\" value=\"남자\" checked>남자\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"userGender\" autocomplete=\"off\" value=\"여자\">여자\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:110px;\"><h5>이메일</h5></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"><input class=\"form-control\" type=\"email\" id=\"userEmail\" name=\"userEmail\" maxlength=\"20\" placeholder=\"이메일을 입력하세요\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: left;\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\t<h5 style=\"color: red;\" id=\"passwordCheckMessage\"></h5>\t\t\t\t\t<!--  id: passwordCheckMessage -->\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"btn btn-primary pull-right\" type=\"submit\" value=\"등록\">\t\t<!--  '등록' 버튼 -->\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

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
      out.write("\t<script>\r\n");
      out.write("\t\t$('#messageModal').modal(\"show\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");

		session.removeAttribute("messageContent");
		session.removeAttribute("messageType");
		}
	
      out.write("\r\n");
      out.write("\t<!-- checkModal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"checkModal\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"vertical-alignment-helper\">\r\n");
      out.write("\t\t\t<div class=\"modal-dialog vertical-align-center\">\r\n");
      out.write("\t\t\t\t<div id=\"checkType\" class=\"modal-content panel-info\">\t\t<!-- id: checkType -->\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-header panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n");
      out.write("\t\t\t\t\t\t\t<span aria-hidden=\"true\">&times</span>\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"sr-only\">Close</span>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<h4 class=\"modal-title\">\r\n");
      out.write("\t\t\t\t\t\t\t확인메세지\r\n");
      out.write("\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\" id=\"checkMessage\">\t\t<!-- id: checkMessage -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">확인</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
