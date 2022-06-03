<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import = "model.*" %>
<%    
	int addressnum = (int)request.getAttribute("addressnum");
    AddrDTO dto = (AddrDTO)request.getAttribute("dto");    
%> 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script>
  	function update(addressnum){
  		//alert(bbsno);
  		let url = "update.do?addressnum=" + addressnum;
  		location.href = url;
  	}
  	function del(addressnum){
  		//alert(bbsno);
  		let url = "delete.do?addressnum=" + addressnum;
  		location.href = url;
  	}
  </script>
</head>
<body> 
<div class="container">
	<h1 class="col-sm-offset-2 col-sm-10">주소 조회</h1>
	
	<div class="panel panel-default">
	<div class="panel-heading">이름</div>
	<div class="panel-body"><%=dto.getName() %></div>
	 
	<div class="panel-heading">전화번호</div>
	<div class="panel-body"><%=dto.getHandphone() %></div>
	 
	<div class="panel-heading">우편번호</div>
	<div class="panel-body" style="height: 200px"><%=dto.getZipcode() %></div>
	 
	<div class="panel-heading">주소</div>
	<div class="panel-body"><%=dto.getAddress() %></div>
	 
	<div class="panel-heading">상세 주소</div>
	<div class="panel-body"><%=dto.getAddress2() %></div>
	</div>
	 
	<div>
	<button type="button" class="btn" onclick="location.href='./create.do'">등록</button>
	<button type="button" class="btn" onclick="update('<%=addressnum%>')">수정</button>
	<button type="button" class="btn" onclick="del('<%=addressnum%>')">삭제</button>
	<button type="button" class="btn" onclick="location.href='./list.do'">목록</button>
	</div>
</div>
</body> 
</html> 