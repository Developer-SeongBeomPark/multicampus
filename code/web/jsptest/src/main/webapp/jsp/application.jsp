<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String serverInfo = application.getServerInfo();
	String mimeType = application.getMimeType("request.html");
	String realPath = application.getRealPath("/");
	application.log("application 내부 객체 로그 테스트");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Application Example</h1>
	서블릿 컨테이너의 이름과 버전 : <%=serverInfo %><p/>
	request.jsp의 MiMeType : <%=mimeType %><p/>
	로컬 파일 시스템의 경로 : <%=realPath %><p/>
</body>
</html>