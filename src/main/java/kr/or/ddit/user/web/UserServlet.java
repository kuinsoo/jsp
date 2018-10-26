package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userService.UserService;
import kr.or.ddit.user.userService.UserServiceInf;


@WebServlet(urlPatterns={"/userAllList", "/userPageList","/userDetail"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	// 상태가 변경되는 부분이 아닐경우에는 doGet에 하기 (링크 클릭하는 것도 Get방식) 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 uri로 로직 분기
		String uri = request.getRequestURI();
		
		System.out.println("userServlet doGet" + uri);
		
		// 사용자 전체 조회
		// uri == userAllList
		if(uri.equals("/userAllList"))
			userAllList(request, response);
		
		// 사용자 페이징 조회
		// 그렇지 않고 
		// uri == userPageList
		else if (uri.equals("/userPageList"))
			userPageList(request , response);
		
		// 사용자 상세 조회 화면
		else if(uri.equals("/userDetail"))
			userDetail(request , response);
		
		// 사용자 정보 수정하는 화면 
		else if(uri.equals("/userFormUpdate"))
			userDetail(request , response);
		
	}
	
	
	/**  * Method   : userDetail
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param request
	  * @param response
	  * Method 설명 :  사용자 정보 상세보기 

	*/
	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 사용자 아이디가 파라미터로 넘어옴 
			String userId = request.getParameter("userId");
		// 사용자 아이디에 해당하는 사용자 정보 조회 
			UserServiceInf userService = new UserService();	// 캡슐화 한것 
			
			UserVo userInfo = userService.selectUser(userId);
			
		// jsp로 위임하기 위해 사용자 정보를 request에 저장 
		
			request.setAttribute("userInfo" , userInfo);
			
		// 사용자 상세 화면으로 위임 
			RequestDispatcher rd = request.getRequestDispatcher("/user/userDetail.jsp");
			rd.forward(request, response);
		
	}


	/**  * Method   : userPageList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param request
	  * @param response
	  * Method 설명 : 사용자 페이징 조회
	 * @throws IOException 
	 * @throws ServletException 
	*/
	private void userPageList(HttpServletRequest request ,
			HttpServletResponse response) throws ServletException, IOException{
		System.out.println("userPageList");
		
		// userservice생성
		UserServiceInf userService = new UserService();	// 캡슐화 한것 
		
		// userPageList 호출 : 메소드 인자 - pageVo : page, pageSize
		PageVo pageVo = new PageVo();
		//Integer.parseInt-> 숫자로 변환
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		
		Map<String , Object> resultMap = userService.selectUserPageList(pageVo);
		
		// 페이지 리스트 
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		
		// 페이지 건수 
		int pageCnt = (int) resultMap.get("pageCnt");
		
		// request 객체에 저장 
		request.setAttribute("pageList", userList);
		request.setAttribute("pageCnt", pageCnt);
		
		// forward (userAllList.jsp --> userPagingList.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("/user/userPagingList.jsp");
		rd.forward(request, response);
		
	}


	private void userAllList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 전체 사용자 정보조회
		UserServiceInf userService = new UserService();	// 캡슐화 한것 
		List<UserVo> userList = userService.selectUserAll();
		
		// 조회된 사용자 정보를 userAllList.jsp를 통해 화면처리 
		// userAllList.jsp에서 userList를 참조하려면 > 
		// attribute사용 -> 이부분을 사용하려면 session , application , request
		
		// session에 특징 : 해당 사용자만 접근이 가능(사용자 전용 공간 )  
		// 자주 참조하는 데이터 (어떤 페이지에 가도 사용자의 이름을 이용한다면)
		// 너무 많은 데이터를 저장할 경우 과부하가 걸린다 
		
		// application : 모든 사용자가 접근가능 (서버당 하나만 생성) -> 요청에 대한 부분을 입력하는 건 아니다
		
		// request : 해당 요청의 응답이 끝날떄까지
		
		//서블릿에서 application 사용하는 방법  -> 요청 말고 일반적으로 설정과 관련된 값을 저장한다
		//getServletContext().setAttribute("userList", userList);
		
		// request
		request.setAttribute("userAllList", userList);
		
		// 화면으로 위임 : 2가지 
		// 1. dispatch : 조회만 했을떄 사용   , 보통/ 일반적으로 사용한다 
		// 2. sendRedirect : 서버에 데이터가 변경되었을떄 사용 (요청이 2번간다) 
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
