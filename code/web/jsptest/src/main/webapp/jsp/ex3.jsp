<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	String declaration = "Declaration";
	public String decMethod(){
		return declaration;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Script Example</h1>
	<%
		String scriptlet = "Scriptlet";
		String comment = "Comment";
		
		out.print("내장객체를 이용한 출력 : " + declaration + "<p/>");
	
	%>
	
	선언문의 출력1 : <%=declaration %><p/>
	선언문의 출력2 : <%=decMethod() %><p/>
	스크립트의 출력 : <%=scriptlet %><p/>
	
	<!-- JSP주석부분 -->
	<!-- JSP 주석1 : <%=comment%> -->
	<p/>
	<%--JSP주석2 : <%=comment%> --%>
	<p/>
	<%
		/*(여러줄 주석)*/
		//한줄 주석
	%>
</body>
</html>