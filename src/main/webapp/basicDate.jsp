<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basicDate.jsp</title>
</head>

<%-- 스크립틀릿 <% %>  : 자바 코드를 작성하는 용도  --%>
<%-- 표현식 <%= %>  : 출력을 표현  --%>
<% 
	String str = null;

	SimpleDateFormat test = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	Date date = new Date();
	
	str = test.format(date);
%>
<body>
	hello, World
	<br> <%=str %>
</body>
</html>
<!-- http://localhost:8081/basic.jsp -->