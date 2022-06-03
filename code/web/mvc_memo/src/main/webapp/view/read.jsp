<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import = "model.*" %>
<%    
    MemoDTO dto = (MemoDTO)request.getAttribute("dto");
	int memono = dto.getMemono();
    String content = dto.getContent().replaceAll("\r\n", "<br>");    
%> 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script>
  	function update(memono){
  		//alert(memono);
  		let url = "update.do?memono=" + memono;
  		location.href = url;
  	}
  	function del(memono){
  		//alert(memono);
  		let url = "delete.do?memono=" + memono;
  		location.href = url;
  	}
  	function reply(memono){
  		//alert(memono);
  		let url = "reply.do?memono=" + memono;
  		location.href = url;
  	}
  </script>
</head>
<body> 
<div class="container">
	<h1 class="col-sm-offset-2 col-sm-10">메모 조회</h1>
	
	<div class="panel panel-default">
	<div class="panel-heading">작성자</div>
	<div class="panel-body"><%=dto.getWname() %></div>
	 
	<div class="panel-heading">제목</div>
	<div class="panel-body"><%=dto.getTitle() %></div>
	 
	<div class="panel-heading">내용</div>
	<div class="panel-body" style="height: 200px"><%=content %></div>
	 
	<div class="panel-heading">조회수</div>
	<div class="panel-body"><%=dto.getViewcnt() %></div>
	 
	<div class="panel-heading">등록일</div>
	<div class="panel-body"><%=dto.getWdate() %></div>
	</div>
	 
	<div>
	<button type="button" class="btn" onclick="location.href='./create.do'">등록</button>
	<button type="button" class="btn" onclick="update('<%=memono%>')">수정</button>
	<button type="button" class="btn" onclick="del('<%=memono%>')">삭제</button>
	<button type="button" class="btn" onclick="reply('<%=memono%>')">답변</button>
	<button type="button" class="btn" onclick="location.href='./list.do'">목록</button>
	</div>
</div>
</body> 
</html> 