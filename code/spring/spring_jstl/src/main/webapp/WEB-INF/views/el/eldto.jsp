<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.study.jstl.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<br> EL 사용한 경우 - name일 경우 getName() 호출<br>
		<br> 영화명: ${requestScope.dto.movie}<br>
		<br> 주 연: ${requestScope.dto.name}<br>
		<br> Type2: 주 연: ${dto.movie} - ${dto.name}<br>
		<br> Type3: 주 연(X): ${requestScope.movie}<br>
		<br> Type4: 주 연(X): ${movie}<br>
		<br>

	</h2>
</body>
</html>
