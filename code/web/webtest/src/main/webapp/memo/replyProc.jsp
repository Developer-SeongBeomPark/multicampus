<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "memo.*, java.util.*"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id = "dao" class = "memo.MemoDAO"/>
<jsp:useBean id = "dto" class = "memo.MemoDTO"/>
<jsp:setProperty name = "dto" property = "*"/>


<%
	Map map = new HashMap();
	map.put("grpno",dto.getGrpno());
	map.put("ansnum",dto.getAnsnum());
	dao.upAnsnum(map);
	boolean flag = dao.createReply(dto); 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "/menu/top.jsp"></jsp:include>
	<div class = "container">
		<div class = "well well-lg">
			<%
				
				if(flag){
					out.print("답변 성공입니다.");
				}
				else{
					out.print("답변 실패입니디.");
				}
			%>
		</div>
		
		<button class = "btn" onclick = "history.back()">다시 답변 등록</button>
		<button class = "btn" onclick = "location.href = 'list.jsp'">목록</button>
	</div>
	
</body>
</html>