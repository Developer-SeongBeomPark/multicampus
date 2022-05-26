<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import = "addr.*" %>
<jsp:useBean id="dao" class="addr.AddrDAO" />

<%    
    int addressnum = Integer.parseInt(request.getParameter("addressnum"));
    
    AddrDTO dto = dao.read(addressnum);
%> 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script>
  	function update(addressnum){
  		//alert(addressnum);
  		let url = "updateForm.jsp?addressnum=" + addressnum;
  		location.href = url;
  	}
  	function del(addressnum){
  		//alert(addressnum);
  		let url = "deleteForm.jsp?addressnum=" + addressnum;
  		location.href = url;
  	}
  	function reply(addressnum){
  		//alert(addressnum);
  		let url = "replyForm.jsp?addressnum=" + addressnum;
  		location.href = url;
  	}
  </script>
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
	<h1 class="col-sm-offset-2 col-sm-10">조회</h1>
	
	<div class="panel panel-default">
	<div class="panel-heading">이름</div>
	<div class="panel-body"><%=dto.getName() %></div>
	 
	<div class="panel-heading">전화번호</div>
	<div class="panel-body"><%=dto.getHandphone() %></div>
	 
	<div class="panel-heading">우편번호</div>
	<div class="panel-body" style="height: 200px"><%=dto.getZipcode() %></div>
	 
	<div class="panel-heading">주소</div>
	<div class="panel-body"><%=dto.getAddress() %></div>
	 
	<div class="panel-heading">상세주소</div>
	<div class="panel-body"><%=dto.getAddress2() %></div>
	</div>
	 
	<div>
	<button type="button" class="btn" onclick="location.href='./createForm.jsp'">등록</button>
	<button type="button" class="btn" onclick="update('<%=addressnum %>')">수정</button>
	<button type="button" class="btn" onclick="del('<%=addressnum %>')">삭제</button>
	<button type="button" class="btn" onclick="location.href='./list.jsp'">목록</button>
	</div>
</div>
</body> 
</html> 