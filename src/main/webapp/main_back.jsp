<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main_back.jsp</title>
</head>
<body>

	<%UserVo userVo = (UserVo)session.getAttribute("userVo");%>
	main.jsp <%= userVo.getName() + "["+ userVo.getAlias() + "] 님 안녕하세요" %>
	
	userId : <%=request.getParameter("userId") %>
	password : <%= request.getParameter("password") %>
	
	

</body>
</html>