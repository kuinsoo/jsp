package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.prodService.ProdService;
import kr.or.ddit.prod.prodService.ProdServiceInf;
import kr.or.ddit.user.model.PageVo;

@WebServlet(urlPatterns={"/prodList" ,"/pordDetail"})
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// 요청 uri로 로직 분기
		String uri = request.getRequestURI();
				
		// 상품 전체 조회
		// uri == userAllList
		if(uri.equals("/prodList"))
			prodList(request, response);
		
		// 상품 상세 조회
		// uri == userAllList
		if(uri.equals("/pordDetail"))
			prodDetail(request, response);
					
	}
	

	/**  * Method   : prodList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param request
	  * @param response
	  * Method 설명 :  사용자 정보 상세보기 

	*/
	private void prodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 전체 사용자 정보조회
		ProdServiceInf prodService = new ProdService();	// 캡슐화 한것 
		List<ProdVo> prodList = prodService.selectProdAll();
	
		// 페이징 처리 
		
		// userPageList 호출 : 메소드 인자 - pageVo : page, pageSize
		
		
		PageVo pageVo = new PageVo();
		//Integer.parseInt-> 숫자로 변환
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
	
		
		
		Map<String , Object> resultMap = prodService.selectProdPageList(pageVo);
		
		// 페이지 리스트 
		List<ProdVo> prodPageList = (List<ProdVo>)resultMap.get("prodPageList");

		
		// 페이지 건수 
		int pageCnt = (int) resultMap.get("prodPageCnt");

		// request 객체에 저장 
		request.setAttribute("prodPageList", prodPageList);
		request.setAttribute("pageCnt", pageCnt);

		
		// 화면으로 위임 : 2가지 
		// 1. dispatch : 조회만 했을떄 사용   , 보통/ 일반적으로 사용한다 
		// 2. sendRedirect : 서버에 데이터가 변경되었을떄 사용 (요청이 2번간다) 
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodList.jsp");
		rd.forward(request, response);
		
	}
	
	/**  * Method   : prodDetail
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param request
	  * @param response
	  * Method 설명 :  상품정보 상세보기 

	*/
	private void prodDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 제품 아이디가 파라미터로 넘어옴 
			String prodId = request.getParameter("prodId");
		// 사용자 아이디에 해당하는 사용자 정보 조회 
			ProdServiceInf prodService = new ProdService();	// 캡슐화 한것 
			
			ProdVo prodVo = prodService.selectProd(prodId);
			
		// jsp로 위임하기 위해 사용자 정보를 request에 저장 
		
			request.setAttribute("prodVo" , prodVo);
			
		// 사용자 상세 화면으로 위임 
			RequestDispatcher rd = request.getRequestDispatcher("/prod/prodDetail.jsp");
			rd.forward(request, response);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
