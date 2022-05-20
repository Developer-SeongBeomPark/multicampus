<%@ page contentType="text/html; charset=UTF-8" %> 
 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
1. <%=request.getRequestURL() %><br>
2. <%=request.getRequestURI() %><br>
<!--
	uri : url에서 포트까지를 뺀 나머지 부분.
 -->
3. 사용자로부터 입력을 받는 경우<br>
	급여 : <%=request.getParameter("pay") %><br>
	성명 : <%=request.getParameter("name") %><br>
	
	<%
		int java = Integer.parseInt(request.getParameter("java"));
		int jsp = Integer.parseInt(request.getParameter("jsp"));
		int spring = Integer.parseInt(request.getParameter("spring"));
		int tot = java + jsp + spring;
		int avg = tot / 3;
	%>
	
	Java : <%=java %><br>
	Jsp : <%=jsp %><br>
	Spring : <%=spring %><br>
	총점 : <%=tot %><br>
	평균 : <%=avg %><br>
</div>
</body> 
</html> 