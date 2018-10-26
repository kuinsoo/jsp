<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loggin.jsp</title>
</head>
<body>

<h2>logging tag</h2>
<tags:loggingTag/>
	<c:forEach begin="1" end="10" step="1" varStatus="i">
		${i.index}<br>
	</c:forEach>
<tags:loggingTag></tags:loggingTag>


<h2>color logging tag</h2>
<tags:colorLogging  color="blue"/>
	<c:forEach begin="1" end="10" step="1" varStatus="i">
		${i.index}<br>
	</c:forEach>
<tags:colorLogging color="red"/>

<tags:commonCode code="P201"/>

<br>
<br>




</body>
</html>