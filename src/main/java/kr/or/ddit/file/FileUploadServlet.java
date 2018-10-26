package kr.or.ddit.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024*1024*5 , maxRequestSize= 1024*1024*5*5)
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// fileUpload.jsp전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/fileupload/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 일반 text 파라미터 : request.getParameter("파라미터명");
		// 파일 : request.getPart("파라미터명");
		
		//request.getReader();
		System.out.println(request.getContentType());
		System.out.println("userId : " + request.getParameter("userId"));
		//System.out.println("profile : " + request.getParameter("profile"));
		
		// profile Part
		//여러 파일일경우에는 getParts
		Part profilePart = request.getPart("profile");
		
		// Content-disposition 헤더 정보 
		// 파일과 관련된 부가정보 
		System.out.println("profile part :" + profilePart.getHeader("Content-disposition"));
		
		// 파일 이름 구하는것 
		String contentDisposition = profilePart.getHeader("Content-disposition");
		
		// 초기화 안해서 오류 
		String fileName =" ";
		String[] split = contentDisposition.split(";");
		
		for(String str : split){
			if(str.indexOf("filename=") >= 0){
				//str.lastIndexOf("\"") -> 20글자 나옴 
				fileName = str.substring(11,str.lastIndexOf("\""));
			}
		}
		
		// 괄호 안에 경로 쓰기 
		// 파일 쓰기 
		// 한글이 깨지지 않고  new String(fileName.getBytes() , "utf-8")으로 설정
		profilePart.write("C:\\Users\\PC\\D_Other\\temp\\" 
							+ new String(fileName.getBytes() , "utf-8") );
		profilePart.delete();	// 파일 업로드 과정에서 사용한 디스크 임시 영역을 정리 
		
		
	}

}
