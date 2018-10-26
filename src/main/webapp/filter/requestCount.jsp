<%@page import="kr.or.ddit.filter.RequestCounterFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestCount.jsp</title>
</head>
<body>
	<%-- 이전 방법
	rcMap : <%=RequestCounterFilter.rcMap%>
	 --%>
	 
	 <c:forEach items="${rcMap}" var="uri" >
	 	${uri.key} : ${uri.value } <br>
	 </c:forEach>
	 
	 
	
</body>
</html>