package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userService.UserService;
import kr.or.ddit.user.userService.UserServiceInf;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize = 1024*1024*5 , maxRequestSize= 1024*1024*5*5)
@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 사용자 등록 화면으로 이동 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get : / userForm --> userForm.jsp
		
		// userForm.jsp로 위임 
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		
		
	}


	// 사용자 등록하는 화면 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨질떄 
		// post 한글 파라미터 인코딩 처리 
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 받아오고 
		// userId , name , pass, addr1, addr2 , birth , zipcd , email , tel 
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String birth = request.getParameter("birth");	// type
		String zipcd = request.getParameter("zipcd");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		// 파일 경로 지정 
		Part profilePart = request.getPart("profile");
		
		// 파일 이름 구하는것 
		String contentDisposition = profilePart.getHeader("Content-disposition");
	

		
		// 괄호 안에 경로 쓰기 
		// 파일 쓰기 
		// 한글이 깨지지 않고  new String(fileName.getBytes() , "utf-8")으로 설정
		
		
		String fileName = StringUtil.getFileNameFormHeader(contentDisposition);
		
		// url정보를 실제 파일경로로 변경
		String path = getServletContext().getRealPath("/profile");
		
		profilePart.write(path + File.separator + fileName );
		profilePart.delete();	// 파일 업로드 과정에서 사용한 디스크 임시 영역을 정리 
		
		// /profile/minji.png
		String profile = "/profile/" + fileName;
		
		// 값을 잘 받아오나 확인하는 부분 
		System.out.println(userId + "/" + name + "/" + pass + "/" + addr1 + "/" + addr2 + "/" + birth + "/"
				+ zipcd + "/" + email + "/" + tel);
		
		// 사용자 등록 서비스 호출 (구현했음) 
		// 파라미터를 userVo로 만들기 
		
		UserVo userVo = new UserVo();
		
		userVo.setUserId(userId);
		userVo.setName(name);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		userVo.setZipcd(zipcd);
		userVo.setPass(pass);
		userVo.setEmail(email);
		userVo.setTel(tel);
		userVo.setProfile(profile);
		
		try {
			// yyyy-MM-dd
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userVo.setBirth(sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		UserServiceInf userService = new UserService();
		int insertCnt = userService.insertUser(userVo);
		

		//	사용자 리스트로 이동해야 한다.(redirect :  서버 상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다 
		//  새로고침을 하여도 사용자가 계속 등록되지 않게 하는 방법 
		//db에 상태 변경이 있을때에는 sendRedirect를 사용해야 된다
		response.sendRedirect("/userPageList?page=1&pageSize=10");
		
	}

}
