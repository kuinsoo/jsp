<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>timeTables.jsp</title>

<style type='text/css'>
	td {border : 1px solid blue}
</style>

</head>

<%-- 스크립틀릿 <% %>  : 자바 코드를 작성하는 용도  --%>
<%-- 표현식 <%= %>  : 출력을 표현  --%>

<body>
	<table>
		<c:forEach begin="1" end="9" var="i">
			<tr>
			<c:forEach begin="2" end="${param.number}" var="j">
					<td>${i} * ${j} = ${i*j}</td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>