<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "request.*"%>
<%
	PageInfo info = new PageInfo();
	info.setNowPage(1);
	info.setSearchColumn("title");
	info.setSearchWord("JSP");
	
	request.setAttribute("info", info);
	
	//response.sendRedirect("pageinfo2.jsp");
%>
<jsp:forward page = "./pageinfo2.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>