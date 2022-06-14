<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		request의 name속성(스크립트릿 방식) : <%=request.getAttribute("name") %> <br>
		request의 name속성(EL-requestScope.name) : ${requestScope.name } <br>
		request의 name속성(EL-name) : ${name }<!-- el은 기본적으로 request영역에서 데이터를 찾기 때문에 이렇게 쓸 수도 있다 -->
	</h2>
</body>
</html>