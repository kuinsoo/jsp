package kr.or.ddit.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션(session) 무효화
		// 1. session객체를 확호 
		
		
		// 2. session invalidate 메소드를 통해 무효화
		
		
		
		// servlet
		
		// page		: 존재하지 않음
		// request  : 메소드 인자로 제공
		// session	: request객체에서 획득가능
		// application : getServletContext();
		
		// jsp
		
		// page : pageContext (내장객체) 
		// request : request (내장객체) - 많이 이용함 
		// session : session (내장객체) - 많이 이용함 
		// application : application (내장객체)
		
		// 세션 받아오기 
		HttpSession session =  request.getSession();
		
		// 무효화하는것이 invalidate으로 해야 한다 
		session.invalidate();
		
		response.sendRedirect("/");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
