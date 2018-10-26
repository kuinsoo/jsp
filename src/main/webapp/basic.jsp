<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basic.jsp</title>
</head>
	<%UserVo userVo = (UserVo)session.getAttribute("userVo");%>
	main.jsp <%= userVo.getName() + "["+ userVo.getAlias() + "] 님 안녕하세요" %>

<%-- 스크립틀릿 <% %>  : 자바 코드를 작성하는 용도  --%>
<%-- 표현식 <%= %>  : 출력을 표현  --%>
<% 
	String msg = "first jsp";
%>
<body>
	hello, World
	<br> <%=msg %>
</body>
</html>
<!-- http://localhost:8081/basic.jsp -->