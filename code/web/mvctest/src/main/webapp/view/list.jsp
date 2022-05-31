<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*"%>
<%
	List<Map> list = (List<Map>)request.getAttribute("team");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "container">
		<table class = "table table-striped-columns">
			<thead>
				<tr>
					<th>이름</th><th>보유기술</th>
				</tr>
			</thead>
			<%
				for(int i = 0; i < list.size(); i ++){
					
			%>
			<tbody>
				<tr>
					<td><%=list.get(i).get("name") %></td><td><%=list.get(i).get("skills") %></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>