<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "bbs.*"%>
<%// 1. 폼에서 넘겨준 파라미터를 받는다. 2. 파라키터를 DTO에 저장 3. DTO를 DB에 저장%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id = "dao" class = "bbs.BbsDAO"/>
<jsp:useBean id = "dto" class = "bbs.BbsDTO"/>
<jsp:setProperty name = "dto" property = "wname"/>
<jsp:setProperty name = "dto" property = "title"/>
<jsp:setProperty name = "dto" property = "content"/>
<jsp:setProperty name = "dto" property = "passwd"/>

<%/* 위와 같은 setProperty는 아래의 request.getParameter와 dto.setWname 을 한번에 실행하는 코드다.
	또, dto 파일의 필드명과 form의 name속성 값이 같아야 위와 같이 작성할 수 있고
	만약 다르다면 param = "" 속성을 추가해줘야한다.
	모든 파라미터에 대해 setProperty를 적용하려면 다음과 같이 코딩하면 된다.
	<jsp:setProperty name = "dto" property = "*"/>
	*/
%>



<% /*
	request.setCharacterEncoding("utf-8");
	String wname = request.getParameter("wname");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String passwd = request.getParameter("passwd");
	
	BbsDTO dto = new BbsDTO();
	dto.setWname(wname);
	dto.setTitle(title);
	dto.setContent(content);
	dto.setPasswd(passwd);
	
	BbsDAO dao = new BbsDAO();
	*/
	
	boolean flag = dao.create(dto);
	
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
					out.print("글 등록 성공입니다.");
				}
				else{
					out.print("글 등록 실패입니디.");
				}
			%>
		</div>
		
		<button class = "btn" onclick = "location.href = 'createForm.jsp'">다시등록</button>
		<button class = "btn" onclick = "loaction.href = 'list.jsp'">목록</button>
	</div>
	
</body>
</html>