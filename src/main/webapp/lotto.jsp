<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lotto.jsp</title>
</head>
<body>
<canvas id="myCanvas" width="200" height="200"
	style= "border : 1px solid #000000" ></canvas>
	
		<%
		// 작업하기 전에 JDBC드라이버를 Build Path에 추가한다.
		
		// DB작업에 필요한 객체변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	// 쿼리문이 select일
		
		try {
			// 1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 해당 DB에 접속하기 
			//		==> DriverManager.getConnection()을 이용하고
			//		==> 접속이 성공하면 Connection객체가 생성된다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "YMJ";  // 등록된 사용자 ID
			String pass = "java"; // 등록된 패스워드
			
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			
			int random = (int)(Math.random()*19+1);
			
			String sql =  "select * from jsptstudent";
				   sql += " where no =" + random;	//실행할 SQL명령
			rs = stmt.executeQuery(sql);	// sql명령이 select일 경우
			
			String name = "";
			if(rs.next()){
				name = rs.getString("name");
			}
			
		%>
		
		<script type="text/javascript">
			var canvas = document.getElementById("myCanvas");
			var ctx = canvas.getContext("2d");
			//ctx.fillStyle= "#FF0000";
			//ctx.fillRect(0,0,150,75);
			
			ctx.beginPath();
			// 원의 중심 X좌표 , 원의 중심 Y좌표 , 반지름 
			ctx.arc(100,100,100,0,2*Math.PI);
			ctx.stroke();
			
			ctx.font="60px Arial";
			ctx.fillText("<%=name%>" , 10 , 115);

		</script>
		<% 
		} catch (SQLException e) {
			e.printStackTrace(); // 에러가 무엇이 났는지 알려면 해주는 것이 좋다. 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			// 6. 사용했던 자원을 반납한다.( 반납할때에는 맨마지막에 만들어진 순서대로 닫아줘야 한다)
			if(rs != null)try{ rs.close();}catch (Exception e2){}
			if(stmt != null)try{ stmt.close();}catch (Exception e2){}
			if(conn != null)try{ conn.close();}catch (Exception e2){}

		}
		%>
</body>

</html>