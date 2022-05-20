<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.DecimalFormat" %>
<%! public String comma(long val){
		DecimalFormat dt = new DecimalFormat("W ###,###,### 원");
		String str = dt.format(val);
		return str;
}	
	
%>    

<!DOCTYPE html>
<html>
<style>
	div{
		font-size :24px;
		color : #ffffff;
		background-color : #000055;
	}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>6월 급여 명세서</h1>
	<div>
		본봉 : <%=comma(18000000) %><br>
		수당 : <%=comma(200000) %><br>
		<span style = "color : #ff0000">
			세금 : <%=comma(100000) %>
		</span><br>
		실수령액 : <%=comma(1900000) %><br>
	<span style = "color : #00ff00">수고하셨습니다</span>
	</div>
</body>
</html>