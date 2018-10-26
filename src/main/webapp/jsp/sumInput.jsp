<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumInput.jsp</title>
</head>
<body>
	<form action="/sumCalculation" method="post">
		start : <input type="number" name="start" value=""> <br>
		end : <input type="number" name="end" value=""> <br>
		
		<input type="submit" value="전송"> <br>
	</form>

</body>
</html>