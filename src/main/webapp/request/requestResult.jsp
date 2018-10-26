<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestResult.jsp</title>
</head>
<body>
 	request/requestResult.jsp
 	
 	<h2>parameter 값 불러오기</h2>
 	userId: <%=request.getParameter("userId") %>
 	name: <%=request.getParameter("name") %> <br>
 	
 	<h2>Attribute 불러오기</h2>
 	
 	<!-- 괄호 안의 이름은 set할떄 입력했던 값을 입력하기  -->
 	<%UserVo userVo =  (UserVo)session.getAttribute("userVo");%> 
 	userId :  <%=userVo.getUserId() %> <br>
 	name :    <%=userVo.getName() %>   <br>
 	alias :   <%=userVo.getAlias() %>  <br>
 	birth :   <%=userVo.getBirth() %>  <br>
 		

</body>
</html>