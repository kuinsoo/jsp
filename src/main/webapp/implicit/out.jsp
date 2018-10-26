<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out.jsp</title>
</head>
<body>
	<%-- jsp 내장객체 (implict객체):  servlet으로 변환되는 과정에서 생성된 변수 
		request , response ,session,  out
	 --%>
	 
	 <% out.write("아웃 객체에서 출력한 내용 "); %>
	 
	 <%-- localhost : 8081/out.jsp --%>
</body>
</html>