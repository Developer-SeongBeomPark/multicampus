<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%-- 자바 문에서 List를 쓰기 위한 코드 --%>
<jsp:useBean id = "dao" class = "suggest.SuggestDAO"/>
<%
	request.setCharacterEncoding("utf-8"); //요청지에서 Post방식으로 보낸 한글을 처리하는 코드
	String keyword = request.getParameter("keyword");
	int count = dao.getCount(keyword);
	List<String> list = dao.getSqlquery(keyword);
	
	out.print(count + "|");
	
	for(int i = 0; i < list.size(); i++){
		count = count - 1;
		String key = list.get(i);
		out.print(key);
		if(count > 0){
			out.print(",");
		}
	}
%>