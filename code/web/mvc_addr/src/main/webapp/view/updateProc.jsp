<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%//1. 폼에서 넘겨준 파라미터를 받는다. 2. 파라키터를 DTO에 저장 3. DTO를 DB에 저장%>
<% 
	boolean flag = (boolean)request.getAttribute("flag");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "container">
		<div class = "well well-lg">
			<%
				if(flag){
					out.print("글 수정 성공입니다.");
				}
				else{
					out.print("글 수정 실패입니디.");
				}
			%>
		</div>
		
		
		<button class = "btn" onclick = "location.href = 'create.do'">다시등록</button>
		<button class = "btn" onclick = "location.href = 'list.do'">목록</button>
	</div>
	
</body>
</html>