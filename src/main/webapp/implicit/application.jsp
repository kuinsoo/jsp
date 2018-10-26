<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application.jsp</title>
</head>
<body>

	<% //application.setAttribute(name, object); 
	   //application.setAttribute(name);
	   
	   application.getServerInfo();
	   application.getServletContextName();
	   application.getContextPath();
	   application.getMajorVersion();
	   application.getMinorVersion();
	   application.getInitParameter("ADMIN");
	%>
	
	   application.getServerInfo()            :   <%= application.getServerInfo()           %> <br>
	   application.getServletContextName()    :   <%= application.getServletContextName()   %> <br>
	   application.getContextPath()           :   <%= application.getContextPath()          %> <br>
	   application.getMajorVersion()          :   <%= application.getMajorVersion()         %> <br>
	   application.getMinorVersion()          :   <%= application.getMinorVersion()         %> <br>
	   application.getInitParameter("ADMIN")  :   <%= application.getInitParameter("ADMIN") %> <br>

</body>
</html>