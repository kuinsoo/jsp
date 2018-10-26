<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scopeResult.jsp</title>
</head>
<body>
	
	<!-- scopeServlet  값 가지고 오기  -->
	requestScope : <%=request.getAttribute("requestScope") %>
	sessionScope : <%=session.getAttribute("sessionScope") %>
	applicationScope : <%=application.getAttribute("applicationScope") %>
	

</body>
</html>