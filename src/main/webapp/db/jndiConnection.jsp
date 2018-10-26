<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jndiConnection.jsp</title>
</head>
<body>

	<%
		//jndi Connection
		Context initialContext = new InitialContext();
	
		// 자원에 대해서 리턴해주는 부분 
	    DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/oracleDB");	// 괄호안에 부분은 정해져 있음(java:comp/env)  / 리소스 이름은 web.xml에서  
																							// <res-ref-name>jdbc/oracleDB</res-ref-name>이다
	
		Connection conn = null; 
																							
		long startTime = System.currentTimeMillis();
	 	for(int i = 0; i < 30; i++){
		 	conn = ds.getConnection();
			 out.println("scheme :" + conn.getSchema()+ "<br/>");
			 conn.close();
	 	}
	 
		long endTime = System.currentTimeMillis();
		out.println("endTime-startTime : " + (endTime - startTime)+"ms");
		
																					
																							
																							
	%>

</body>
</html>