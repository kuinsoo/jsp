package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
* BasicServlet.java
*
* @author YMH
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* YMJ 최초 생성
* 
* 현재 시간을 출력하는 html 생성하는 서블릿
* </pre>
*/

public class BasicServlet extends HttpServlet {

	// 요청 http 메소드에 따라 실행되는 메소드가 달라진다.
	// get : doGet
	// post : doPost
	
	// 처음에 나오는 부분 이후에 doGet이 실행된다
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destory");
	}
	
	// doGet 예시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		// HttpServletRequest : 요청에 대한 정보 
		// HttpServletResponse : 응당에 대한 정보 
		
		// 해당 컨텐츠에 대한 정보를 알려준다 
		resp.setContentType("text/html; charset=utf-8");
		
		// 웹 화면 보여지려고 PrintWriter사용
		PrintWriter pw = resp.getWriter();
		
		// date format을 이용하여 
		// 년 - 월 - 일 만 화면에 출력 
		// simpleDateFormat
		Date date = new Date();
		
		// Sttring으로 받아야 한다 
		String str = null;
		SimpleDateFormat test = new SimpleDateFormat("yyyy-MM-dd hh:mm");

		str = test.format(date);
				
		pw.print("<!DOCTYPE html>");
		pw.print("	<html>");
		pw.print("		<head>");
		pw.print("			<meta charset='UTF-8'>");
		pw.print("			<title>Insert title here</title>");
	    pw.print("		</head>");
	    pw.print("		<body>");
	    pw.print("			hello,world");
	    pw.print("			<br>" + str);
        pw.print("		</body>");
        pw.print("</html>");

   
        // stream에 남아 있는 데이터를 강제로 내보내는 역할
        pw.flush();
        pw.close();	// 자동으로 flush(); 를 호출

	}	
}

// 정적 자료 : index.html--> url
// 동적 자료 : servlet --> url mapping 구성 필요 :  web.xml
