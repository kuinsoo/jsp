<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timeTables.jsp</title>

<style type='text/css'>
	td {border : 1px solid blue}
</style>

</head>

<%-- 스크립틀릿 <% %>  : 자바 코드를 작성하는 용도  --%>
<%-- 표현식 <%= %>  : 출력을 표현  --%>

<body>
	<table>
		<% for(int j = 1; j < 10; j++){ %>
			<tr>
				<% for (int i =2; i < 10; i ++) { %>
					<td> <%= i %> * <%=j %> = <%= i * j%> </td>
				<%} %>
			</tr>
		<%} %>
	</table>
</body>
</html>