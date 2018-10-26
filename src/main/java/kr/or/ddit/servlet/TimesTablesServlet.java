package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet{
	
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
	* 구구단 html 생성하는 서블릿
	* </pre>
	*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 웹 화면 보여지려고 PrintWriter사용
		PrintWriter pw = resp.getWriter();
		
		resp.setContentType("text/html; charset=utf-8");
		
		pw.print("<!DOCTYPE html>");
		pw.print("	<html>");
		pw.print("		<style type='text/css'>");
		pw.print("			td {border : 1px solid blue}");
		pw.print("		</style>");
		pw.print("		<head>");
		pw.print("			<meta charset='UTF-8'>");
		pw.print("			<title>timesTables.html</title>");
	    pw.print("		</head>");
	    pw.print("		<body>");
	    pw.print("			<table>");
	    
	    for(int j= 1; j < 10; j++){
	    	pw.print("	<tr>");
	    	for(int i = 2; i < 10; i ++){
	    		pw.print("		<td>" + i + "*" + j + "=" + i*j +"</td>");
	    	}
	    	pw.print("	</tr>");
	    	
	    }
	    pw.print("			</table>");
        pw.print("		</body>");
        pw.print("</html>");
		
	}
	
	

}
