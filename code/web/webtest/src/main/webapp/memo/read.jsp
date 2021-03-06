<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "memo.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id = "dao" class = "memo.MemoDAO"/>


<%
	int memono = Integer.parseInt(request.getParameter("memono"));
	dao.upViewcnt(memono);
	MemoDTO dto = dao.read(memono);
	
%>
 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
</head>
<script>
	function update(memono){
		let url = "updateForm.jsp?memono=" + memono;
		location.href = url;
	}
	function del(memono){
		let url = "deleteForm.jsp?memono=" + memono;
		location.href = url;
	}
	function reply(memono){
		let url = "replyForm.jsp?memono=" + memono;
		location.href = url;
	}
</script>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
	<h1 class="col-sm-offset-2 col-sm-10">memo 조회</h1>
	
	
	<div class="panel panel-default">
	<div class="panel-heading">작성자</div>
	<div class="panel-body"><%=dto.getWname() %></div>
	 
	<div class="panel-heading">제목</div>
	<div class="panel-body"><%=dto.getTitle() %></div>
	 
	<div class="panel-heading">내용</div>
	<div class="panel-body" style="height: 200px"><%=dto.getContent() %></div>
	 
	<div class="panel-heading">조회수</div>
	<div class="panel-body"><%=dto.getViewcnt() %></div>
	 
	<div class="panel-heading">등록일</div>
	<div class="panel-body"><%=dto.getWdate() %></div>
	</div>
	 
	<div>
	<button type="button" class="btn" onclick="location.href='./createForm.jsp'">등록</button>
	<button type="button" class="btn" onclick="update('<%=memono%>')">수정</button>
	<button type="button" class="btn" onclick="del('<%=memono%>')">삭제</button>
	<button type="button" class="btn" onclick="reply('<%=memono%>')">답변</button>
	<button type="button" class="btn" onclick="location.href='./list.jsp'">목록</button>
	</div>
	
	
</div>
</body> 
</html> 