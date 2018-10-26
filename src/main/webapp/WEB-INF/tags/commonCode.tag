<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" required="false" type="String"%>

<% 	
	//DB연결할때에는 6가지 해야 한다.(JSP들어가면 출력하기는 없을수 있다.)
	
	Connection conn = null;		//try안에 넣으면 finally에 빨간중이 나서 전역변수로선언 한다.
	Statement  stmt = null;	//try안에 넣으면 finally에 빨간중이 나서 전역변수로선언 한다.
	ResultSet    rs = null;		//try안에 넣으면 finally에 빨간중이 나서 전역변수로선언 한다.
	
	try{
		//1. 드라이버 연결
		Class.forName("oracle.jdbc.driver.OracleDriver"); 	//오류가 나는건 WEB-INF에 오라클 파일이 없는것
		
		//2. 커넥션 얻기
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ymj","java"); //첫번째는 아이피 , 두번째는 계정 , 세번쨰는 비밀번호 
		
		//3. 구문객체(SQL문장 넘겨받기) 얻기
		stmt = conn.createStatement();	// 모든 권한을 받은것 // 접속 설정하는것 
		
		//4. 결과물 얻기
		
		String sql =  " select prod_id , prod_name from prod where prod_lgu = '"+code+"'"; //띄어쓰기 중요 /sql에서는 enter나 space클릭하는 부분이 자바에서 한줄로 만들때 띄어쓰기를 해줘야 한다. // 줄맞춤하기 !
			   rs = stmt.executeQuery(sql);
			   
																	// sql에서 할떄 select문 넣는거와 같음 
																	// executeQuery  질문을 하겠다는 뜻 
																	// rs에는 결과물을 가지고 있는것 	
		
%>
				<select>   
<% 
				while(rs.next()){ // next()은 rs의 모든 행을 가지고 오는 메서드 , 최초 위치는 0에 위치  / 그다음에 위치가 있으면 수행하고 없으면 수행하지 않는다
%>
				          <option><%=rs.getString("prod_name") %></option>
		     		
<%
				}
							
%>
		     		  </select>
	
<%
		}catch(Exception e){
			System.out.println("DBTest.jsp - 오류발생 : " +e); //콘솔에도 오류 발생이라고 찍어라
			out.println("DBTest.jsp - 오류발생 : " +e); //웹에도 오류 발생이라고 찍어라
		}finally{	// 무조건 자원반납을 해야 하기 때문에 finally안에 넣어준다.
			//6. 자원 반납하기 
			//안쪽부터 역순으로 반납하기(객체지향의 해제 순서)
			
			//rs.close();		// 결과물 끊기
			//stmt.close();	// 구문객체 끊기
			//conn.close();	// 커넥션 끊기
			
			//rs , stmt ,conn을 전역변수로 선언을 하면서 try문을 들어가지 않고 오류가 날수 있기 때문에 
			// if문을 만들어줘서 null이 아니라면 해제시키라는 것을 적어줘야 한다.
			if(rs != null)
				rs.close();		// 결과물 끊기
	
			if(stmt != null)
				stmt.close();	// 구문객체 끊기
			
			if(conn != null)
				conn.close();	// 커넥션 끊기
			
		}
%>
