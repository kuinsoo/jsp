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

	// 2 ����� �Է�
	//private final String USERID = "brown";
	//private final String USERPW = "pass1234";
	
	// service --> request.getMethod() : "POST", "GET" --> doGet , doPost
	// login.jsp���� method�� post�� �Ͽ��� ������ doPost�� �̿�
	// doPost�� ���
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String newParameter = request.getParameter("newParameter");
		
		System.out.println("newParameter : " + newParameter);
		
		//Map<String,String[]> reqMap = request.getParameterMap();
		//reqMap.put("newParameter", new String[]{"newValue"});
		

		// 1. ����� ���̵�� ��й�ȣ�� reqeuest��ü���� �޾ƿ´�.
		// 2. db���� ��ȸ�ؿ� ���̵�, ��й�ȣ�� üũ�Ѵ�.
		// 3_1. ��ġ�Ұ�� main.jsp�� �̵�
		// 3_2. ����ġ�Ұ�� login.jsp�� �̵�
		
		//1 : input�� �ִ� name�� ��ȣ�� �־��ش�
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		// getParameter�� ���ϰ��� ������ String �̴�
		String rememberMe = request.getParameter("remember-me");
		
		// remember-me �Ķ���� �޾Ƽ� sysout���� ��� 
		System.out.println(rememberMe);
		
		// rememberMe == null : ���̵� ��� ������ 
		if(rememberMe == null){
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				
				// cookie �̸��� remember , userId �� ��� maxage�� -1�� �����Ͽ� ��Ű�� ��ȿ���� �ʰ� ����
				if(cookie.getName().equals("remember")||cookie.getName().equals("userId")){
					
					//-1 : ������ ����۽� ��Ű ���� �ݿ� 
					//0: �ٷ� ���� 
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
	
			}
		}
		// remeberMe != null : ���̵� ��� ��� 	
		else{
			// response ��ü�� ��Ű�� ����
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdcookie = new Cookie("userId", userId);	// userId�� �����ؾ� �ϱ� ������ ������ ���� 
			resp.addCookie(cookie); // ������ �����Ѱ� �Է� 
			resp.addCookie(userIdcookie); 
		}
		
		//2 --> db��� ����� ��ü --> db�� ��ü
			// 1.  ����ڰ� ������ userId �Ķ���ͷ� ����� ������ȸ 
			// 2.  db���� ��ȸ�� ����� ��й�ȣ�� �Ķ���ͷ� ���۵� ��й�ȣ�� �������� �� 
			// 3.  session�� ����� �������(as-is : ������ userVo���
			//						to-be : db���� ��ȸ�� userVo)
			// pom.xml ���� oracle dependecy scope����
		
		// ���� ��ü ���� 
		UserServiceInf service = new UserService();
		// 1.  ����ڰ� ������ userId �Ķ���ͷ� ����� ������ȸ 
		UserVo user = service.selectUser(userId);
	
		// 2.  db���� ��ȸ�� ����� ��й�ȣ�� �Ķ���ͷ� ���۵� ��й�ȣ�� �������� �� 
		//3_1 : main.jsp�� �̵�
		
//		String encryptPass = KISA_SHA256.encrypt(password);

		
		if(user != null &&  user.authPass(password)){
		//if(user != null &&  user.getPass().equals(encryptPass)){
			// redirect : 
			//��ȣ���� url�� �Է��ϱ� 
			//resp.sendRedirect("main.jsp?userId="+userId 
			//					+"&password="+ password);
			
			//session�� ����� ���� ���� (db�� ������� �ʰ� �ϵ��ڵ�)
/*			UserVo userVo = new UserVo();
			userVo.setUserId(user.getUserId());
			userVo.setName(user.getName());
			userVo.setAlias(user.getAlias());
			userVo.setBirth(user.getBirth());*/
			
			// session���� ����� 
			// ��� 1.
			// HttpSession session = request.getSession();	// �̷��Ե� ����Ҽ� ����
			// session.setAttribute("�̸�",��);
			
			
			// ���2.
			request.getSession().setAttribute("S_USER", user );
			
			// 2. main.jsp ȭ�鿡 boby ������ �̸�[����]�� �ȳ��ϼ���  �����
		
			
			//dispatch : ��û�� �ѹ� ������ ( �ּ��ٿ� http://localhost:8081/dditLogin)�� �����Եȴ�
			RequestDispatcher rd =  request.getRequestDispatcher("main.jsp");
			// HttpServletRequest request, HttpServletResponse resp ���� �Է��ϱ�
			rd.forward(request, resp);
		}
		
		//3_2 : login.jsp�� �̵�
		else{
			//login���� �ȿ� �ֱ� ������ ������ ���
			resp.sendRedirect("login/login.jsp");
		}
	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// post����϶� ���ڵ� ��� -> post�� �ٸ� �� �Է��ؾ� �ؼ� doGet�� �Է��س����� 
		request.setCharacterEncoding("utf-8");
	
		// ������ Ÿ�� ����
		resp.setContentType("text/html; charset=utf-8");
		
		// �� ȭ�� ���������� PrintWriter���
		PrintWriter pw = resp.getWriter();
		
		
		pw.print("<!DOCTYPE html>");
		pw.print("	<html>");
		pw.print("		<head>");
		pw.print("			<meta charset='UTF-8'>");
		pw.print("			<title>timesTables.html</title>");
	    pw.print("		</head>");
	    pw.print("		<body>");

	    // �ƾƵ� �ΰ��� �����Ǿ� �־� getParameterValues�� �̿�
	    String[] userIds = request.getParameterValues("userId");
	    // �н�����
	    String password = request.getParameter("password");
	 	
		for(String userId: userIds){ 
			pw.print("userId : "+userId +"<br>");
		}
		pw.println("password : "+password);
	 	pw.print("		</body>");
        pw.print("</html>");
		
	}
	

}
