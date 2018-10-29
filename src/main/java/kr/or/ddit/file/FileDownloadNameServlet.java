package kr.or.ddit.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDownloadName")
public class FileDownloadNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파일에 대한 정보 (파일명 등)
		//응답에 대한 정보(html 이 아니라 바이너리 파일) : contentType
		response.setContentType("application/octet-stream"); // 바이너리 타입을 알려주는 문자열
		response.setHeader("Content-Disposition", "attachmen; filename=git.txt"); 
		 
//		
//		String userId = request.getParameter("userId");
//		UserServiceInf userService = new UserService();
//		UserVo userVo = userService.selectUser(userId);
//		
//		
//		File f = new File(userVo.getProfile());
//		
//		FileInputStream fis = new FileInputStream(f);
//		
//		// 파일을 읽을 버퍼 만들기 
//		byte[] buffer = new byte[512];
//		// 길이 계산 
//		int len = 0;
//		ServletOutputStream sos =  response.getOutputStream();
//	
//		// 파일 읽기 
//		// 괄호안에는 버퍼 크기 만큼
//		// -1를 리턴하면 더이상 읽을게 없다는 뜻 
//		while((len = fis.read(buffer)) != -1){
//			// 파일쓰기 
//			sos.write(buffer, 0 , len);
//		}
//		sos.close();
//		fis.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
