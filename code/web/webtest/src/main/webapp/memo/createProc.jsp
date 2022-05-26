<%@ page contentType="text/html; charset=UTF-8" %> 
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id = "dao" class = "memo.MemoDAO"/>
<jsp:useBean id = "dto" class = "memo.MemoDTO"/>
<jsp:setProperty name = "dto" property = "*"/>

 <%
 	boolean flag = dao.create(dto);
 %>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>

	
	
	<div class = "container">
		<div class = "well well-lg">
			<%
				if(flag){
					out.print("memo 등록 성공");
				}else{
					out.print("memo 등록 실패");
				}
			%>
		</div>
		
		<button class = "btn" onclick = "location.href = 'createFrom.jsp'">다시 등록</button>
		<button class = "btn" onclick = "location.href = 'list.jsp'">목록</button>
			
	
	</div>
	

</body> 
</html> 