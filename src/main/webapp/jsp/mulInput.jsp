<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mulInput.jsp</title>
</head>
<body>
	<form action="/mulCalculation" method="post">
		start : <input type="number" name="param1" value=""> <br>
		end : <input type="number" name="param2" value=""> <br>
		
		<input type="submit" value="전송"> <br>
	</form>

</body>
</html>