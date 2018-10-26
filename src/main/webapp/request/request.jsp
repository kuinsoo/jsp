<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request.jsp</title>
</head>
<body>
	<form action="/requestServLet" method="post">
		<input type="text" name="userId"> <br>
		<input type="text" name="name"> <br>
		<input type="submit" value="전송"> <br>
	</form>
</body>
</html>