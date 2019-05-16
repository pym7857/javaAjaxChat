<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<% 
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		String toID = null;
		if(request.getParameter("toID") != null){
			toID = (String) request.getParameter("toID");
		}
		if(userID == null) {
			session.setAttribute("messageType", "오류 메세지");
			session.setAttribute("messageContent", "현재 로그인이 되어 있지 않습니다.");
			response.sendRedirect("index.jsp");
			return;
		}
		if(toID == null) {
			session.setAttribute("messageType", "오류 메세지");
			session.setAttribute("messageContent", "대화 상대가 지정되지 않았습니다.");
			response.sendRedirect("index.jsp");
			return;
		}
	%>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/custom.css?ver=1">
	<link rel="stylesheet" type="text/css" href="css/custom2.css">
	<title>JSP Ajax 실시간 회원제 채팅 서비스</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript">
		function autoClosingAlert(selector, delay) {
			var alert = $(selector).alert();
			alert.show();
			window.setTimeout(function() {
				alert.hide()
				}, delay);
		}
		/* 전송 버튼 눌렀을때 일어나는 이벤트정의함수 */
		function submitFunction() {	
			alert('전송완료!');
			var fromID = '<%= userID %>';
			var toID = '<%= toID %>';
			var chatContent = $('#chatContent').val();
			$.ajax({
					type: "POST",
					url: "./chatSubmitServlet",
					data: {
						fromID: encodeURIComponent(fromID), // encodeURIComponent: 이스케이핑 (혹시 이름에 특수문자 있을수 있으므로 인코딩)
						toID: encodeURIComponent(toID),
						chatContent: encodeURIComponent(chatContent),
					},
					success: function(result) {	// 콜백함수- 서버에서 response했을때 그 response를 어떻게 처리할까?
						if(result == 1) {
							autoClosingAlert('#successMessage', 2000);
						} else if (result == 0) {
							autoClosingAlert('#dangerMessage', 2000); 
						} else {
							autoClosingAlert('#warningMessage', 2000);
						}
					}
			});
			$('#chatContent').val('');	// 비워주기
		}
		
		var lastID = 0; // 대화의 마지막 아이디값 초기화
		/* 대화기록 화면에 뿌려주는 함수 */
		function chatListFunction(type) {	
			var fromID = '<%= userID %>';
			var toID = '<%= toID %>';
			$.ajax({
				type: "POST",
				url: "./chatListServlet",
				data: {
					fromID: encodeURIComponent(fromID),		// encodeURIComponent: 이스케이핑 (혹시 이름에 특수문자 있을수 있으므로 인코딩)
					toID: encodeURIComponent(toID),
					listType: type
				},
				success: function(data) {
					if(data == "") return; 
					// console.log(data);
					var parsed = JSON.parse(data);	// JSON문자열을 JavaScript 객체로 파싱(변환)
					var result = parsed.result;
					for(var i = 0 ; i < result.length ; i++) {
						if(result[i][0].value1 == fromID){
							result[i][0].value1 = '나';
						}
						addChat(result[i][0].value1, result[i][0].value3, result[i][0].value4); //fromID, chatContent, chatTime
					}
					lastID = Number(parsed.last); 
				}
			});
		}
		function addChat(chatName, chatContent, chatTime) { //fromID, chatContent, chatTime
			$('#chatList').append('<div class="row">' +
					'<div class="col-lg-12">' +
					'<div class="media">' +
					'<a class="pull-left" href="#">' +
					'<img class="media-object img-circle" style="width:30px; height:30px;" src="images/icon.png" alt="">' +
					'</a>' +
					'<div class="media-body">' +
					'<h4 class="media-heading">' +
					chatName +
					'<span class="small pull-right">' +
					chatTime +
					'</span>' +
					'</h4>' +
					'<p>' +
					chatContent +
					'</p>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'<hr>');
			$('#chatList').scrollTop($('#chatList')[0].scrollHeight);	// 스크롤 맨 밑부분 유지
		}
		function getInfiniteChat() {	// 3초에 한번씩 대화내용 가져온다 (무한대로 계속)
			setInterval(function() {
				chatListFunction(lastID);
				//console.log(lastID);
			}, 3000);
		}
	</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">실시간 회원제 채팅 서비스</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main.jsp">메인</a></li>
				<li><a href="find.jsp">친구찾기</a></li>
			</ul>
			<%
				if(userID != null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>	
			</ul>
			<%
				}
			%>
		</div>
	</nav>
	<!-- main -->
	<div class="container bootstrap snippet">		<!-- bootstrap snippet: 부트스트랩의 확장 서비스 -->
		<div class="row">
			<div class="col-xs-12">
				<div class="portlet portlet-default">
					<div class="portlet-heading">
						<div class="portlet-title">
							<h4><i class="fa fa-circle text-green"></i>실시간 채팅창</h4>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="chat" class="panel-collapse collapse in">	<!-- chatList -->
						<div id="chatList" class="portlet-body chat-widget" style="overflow-y: auto; width: auto; height:600px;">
						</div>
						<div class="portlet-footer">
							<div class="row">
								<div class="form-group col-xs-10">	<!-- chatContent -->
									<textarea style="height: 80px;" id="chatContent" class="form-control" placeholder="메세지를 입력해주세요" maxlength="100"></textarea>
								</div>
								<div class="form-group col-xs-2">
									<button type="button" class="btn btn-default pull-right" onclick="submitFunction();">전송</button>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 알림창 -->
	<div class="alert alert-success" id="successMessage" style="display:none;">
		<strong>메세지 전송에 성공했습니다.</strong>	
	</div>
	<div class="alert alert-danger" id="dangerMessage" style="display:none;">
		<strong>내용을  입력해주세요.</strong>	
	</div>
	<div class="alert alert-warning" id="warningMessage" style="display:none;">
		<strong>데이터베이스 오류가 발생했습니다.</strong>	
	</div>
	
	<%
		String messageContent = null;
		if (session.getAttribute("messageContent") != null) {
			messageContent = (String) session.getAttribute("messageContent");
		}
		String messageType = null;
		if (session.getAttribute("messageType") != null) {
			messageType = (String) session.getAttribute("messageType");
		}
		if (messageContent != null) {
	%>
	<!--  messageModal -->
	<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="vertical-alignment-helper">
			<div class="modal-dialog vertical-align-center">
				<div class="modal-content <% if(messageType.equals("오류 메세지")) out.println("panel-warning"); else out.println("panel-success");%> ">
					<div class="modal-header panel-heading">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times</span>		<!-- x버튼 -->
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">
							<%= messageType %>
						</h4>
					</div>
					<div class="modal-body">
						<%= messageContent %>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#messageModal').modal("show");
	</script>
	<%
		session.removeAttribute("messageContent");
		session.removeAttribute("messageType");
		}
	%>
	<script type="text/javascript">
		$(document).ready(function() {
			getInfiniteChat();
		});
	</script>
</body>
</html>