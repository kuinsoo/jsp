<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--post --%>
view.jsp

<form action="/filterServlet" method="post">

	userNm : ${userNm }<br>
	<input type="text" name="userNm" value="브라운" /><br>
	<button type="submit">전송</button>

</form>


</body>
</html>