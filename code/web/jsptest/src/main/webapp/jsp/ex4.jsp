<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String root = request.getContextPath();
	String[] images = {"tu01.jpg", "tu02.jpg", "tu03.jpg", "tu04.jpg", "tu05.jpg", "tu06.jpg", "tu07.jpg", "tu08.jpg",
		    "tu09.jpg", "tu10.jpg"};
	
	
%>
<!DOCTYPE html>
<html>
<style>
	img{
		width : 200px;
		height : 160px;
		border : 0;
	}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>투울립 축제</h1>
	<%
		for(int i = 0; i < images.length; i++){
	%>
		
		<a href = '<%=root%>>/tulip/<%=images[i]%>'>
		<img src='<%=root%>>/tulip/<%=images[i]%>'>
		</a>
		
	<%		
		}
	%>
</body>
</html>