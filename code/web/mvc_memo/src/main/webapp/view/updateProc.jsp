<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%//1. 폼에서 넘겨준 파라미터를 받는다. 2. 파라키터를 DTO에 저장 3. DTO를 DB에 저장%>
<% 
	boolean pflag = (boolean)request.getAttribute("pflag");
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
				if(!pflag){
					out.print("잘못된 비밀번호입니다.");
				}else if(flag){
					out.print("메모 수정 성공입니다.");
				}
				else{
					out.print("메모 수정 실패입니디.");
				}
			%>
		</div>
		
		<%
			if(!pflag){
		%>
		
			<button class = "btn" onclick = "history.back()">다시시도</button>
		
		<%
			}
		%>
		
		<button class = "btn" onclick = "location.href = 'create.do'">다시등록</button>
		<button class = "btn" onclick = "location.href = 'list.do'">목록</button>
	</div>
	
</body>
</html>