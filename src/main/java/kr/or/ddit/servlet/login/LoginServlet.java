package kr.or.ddit.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userService.UserService;
import kr.or.ddit.user.userService.UserServiceInf;


public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 2 상수로 입력
	//private final String USERID = "brown";
	//private final String USERPW = "pass1234";
	
	// service --> request.getMethod() : "POST", "GET" --> doGet , doPost
	// login.jsp에서 method를 post로 하였기 때문에 doPost로 이용
	// doPost로 사용
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String newParameter = request.getParameter("newParameter");
		
		System.out.println("newParameter : " + newParameter);
		
		//Map<String,String[]> reqMap = request.getParameterMap();
		//reqMap.put("newParameter", new String[]{"newValue"});
		

		// 1. 사용자 아이디와 비밀번호를 reqeuest객체에서 받아온다.
		// 2. db에서 조회해온 아이디, 비밀번호를 체크한다.
		// 3_1. 일치할경우 main.jsp로 이동
		// 3_2. 불일치할경우 login.jsp로 이동
		
		//1 : input에 있는 name을 괄호에 넣어준다
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		// getParameter는 리턴값이 무조건 String 이다
		String rememberMe = request.getParameter("remember-me");
		
		// remember-me 파라미터 받아서 sysout으로 출력 
		System.out.println(rememberMe);
		
		// rememberMe == null : 아이디 기억 사용안함 
		if(rememberMe == null){
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				
				// cookie 이름이 remember , userId 일 경우 maxage를 -1로 설정하여 쿠키를 유효하지 않게 설정
				if(cookie.getName().equals("remember")||cookie.getName().equals("userId")){
					
					//-1 : 브라우저 재시작시 쿠키 삭제 반영 
					//0: 바로 삭제 
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
	
			}
		}
		// remeberMe != null : 아이디 기억 사용 	
		else{
			// response 객체에 쿠키를 저장
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdcookie = new Cookie("userId", userId);	// userId도 저장해야 하기 때문에 저장해 놓음 
			resp.addCookie(cookie); // 위에서 선언한것 입력 
			resp.addCookie(userIdcookie); 
		}
		
		//2 --> db대신 상수로 대체 --> db로 대체
			// 1.  사용자가 전송한 userId 파라미터로 사용자 정보조회 
			// 2.  db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교 
			// 3.  session에 사용자 정보등록(as-is : 임의의 userVo등록
			//						to-be : db에서 조회한 userVo)
			// pom.xml 에서 oracle dependecy scope삭제
		
		// 서비스 객체 생성 
		UserServiceInf service = new UserService();
		// 1.  사용자가 전송한 userId 파라미터로 사용자 정보조회 
		UserVo user = service.selectUser(userId);
	
		// 2.  db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교 
		//3_1 : main.jsp로 이동
		
		String encryptPass = KISA_SHA256.encrypt(password);

		
		if(user != null &&  user.authPass(encryptPass)){
		//if(user != null &&  user.getPass().equals(encryptPass)){
			// redirect : 
			//괄호에는 url를 입력하기 
			//resp.sendRedirect("main.jsp?userId="+userId 
			//					+"&password="+ password);
			
			//session에 사용자 정보 설정 (db를 사용하지 않고 하드코딩)
/*			UserVo userVo = new UserVo();
			userVo.setUserId(user.getUserId());
			userVo.setName(user.getName());
			userVo.setAlias(user.getAlias());
			userVo.setBirth(user.getBirth());*/
			
			// session으로 만들기 
			// 방법 1.
			// HttpSession session = request.getSession();	// 이렇게도 사용할수 있음
			// session.setAttribute("이름",값);
			
			
			// 방법2.
			request.getSession().setAttribute("S_USER", user );
			
			// 2. main.jsp 화면에 boby 영역에 이름[별명]님 안녕하세요  만들기
		
			
			//dispatch : 요청을 한번 보낸것 ( 주소줄에 http://localhost:8081/dditLogin)로 나오게된다
			RequestDispatcher rd =  request.getRequestDispatcher("main.jsp");
			// HttpServletRequest request, HttpServletResponse resp 변수 입력하기
			rd.forward(request, resp);
		}
		
		//3_2 : login.jsp로 이동
		else{
			//login폴더 안에 있기 때문에 폴더명 명시
			resp.sendRedirect("login/login.jsp");
		}
	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// post방식일때 인코딩 방법 -> post에 다른 걸 입력해야 해서 doGet에 입력해놓은것 
		request.setCharacterEncoding("utf-8");
	
		// 콘텐츠 타입 설정
		resp.setContentType("text/html; charset=utf-8");
		
		// 웹 화면 보여지려고 PrintWriter사용
		PrintWriter pw = resp.getWriter();
		
		
		pw.print("<!DOCTYPE html>");
		pw.print("	<html>");
		pw.print("		<head>");
		pw.print("			<meta charset='UTF-8'>");
		pw.print("			<title>timesTables.html</title>");
	    pw.print("		</head>");
	    pw.print("		<body>");

	    // 아아디가 두개로 설정되어 있어 getParameterValues로 이용
	    String[] userIds = request.getParameterValues("userId");
	    // 패스워드
	    String password = request.getParameter("password");
	 	
		for(String userId: userIds){ 
			pw.print("userId : "+userId +"<br>");
		}
		pw.println("password : "+password);
	 	pw.print("		</body>");
        pw.print("</html>");
		
	}
	

}
