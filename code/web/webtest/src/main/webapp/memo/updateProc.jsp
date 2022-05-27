<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import = "java.util.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id = "dao" class = "memo.MemoDAO"/>
<jsp:useBean id = "dto" class = "memo.MemoDTO"/>
<jsp:setProperty name = "dto" property = "*"/>

 <%
 	Map map = new HashMap();
 	map.put("memono", dto.getMemono());
 	map.put("passwd", dto.getPasswd());
 	
 	boolean flag = false;
 	boolean pflag = dao.passCheck(map);
 	if(pflag){
 		flag = dao.update(dto);
 	}
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
				if(!pflag){
					out.print("잘못된 비밀번호입니다.");
				}else{
					if(flag){
						out.print("memo 등록 성공");
					}else{
						out.print("memo 등록 실패");
					}	
				}
				
			%>
		</div>
		
		<button class = "btn" onclick = "history.back()">다시 수정</button>
		<button class = "btn" onclick = "location.href = 'list.jsp'">목록</button>
			
	
	</div>
	

</body> 
</html> 