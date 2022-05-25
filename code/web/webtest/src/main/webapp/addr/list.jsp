<%@ page contentType="text/html; charset=UTF-8" %> 
 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script>
  	function del(addressnum){
  		if(confirm("정말 삭제사리겠습니까?")){
  			let url = "deleteProc.jsp?addressnum=" + addressnum;
  	  		location.href = url;	
  		}
  	}
  </script>
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">주소록</h1>
	<table class = "table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>삭제]</th>
			</tr>
		</thead>
		<tbody>
		<%
			for(int i = 0; i < 2; i++){
		%>
			<tr>
				<td><%= %></td>
				<td><%= %></td>
				<td><%= %></td>
				<td><%= %></td>
				<td><%= %></td>
			</tr>
		
		<%
			}
		%>
		</tbody>
</div>
</body> 
</html> 