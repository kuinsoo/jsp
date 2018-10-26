package kr.or.ddit.prod.prodService;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface ProdServiceInf {
	
	// 제품 전체 목록 가지고 오는 부분
	List<ProdVo> selectProdAll();
	
	/**  * Method   : selectUserPageList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param pageVo
	  * @return
	  * Method 설명 :  사용자 페이징 조회
	*/
	// 페이징 처리하는 방법
	Map<String , Object> selectProdPageList(PageVo pageVo);

	
	// 상품상세정보 나오게 설정
	ProdVo selectProd(String prodId);
}
