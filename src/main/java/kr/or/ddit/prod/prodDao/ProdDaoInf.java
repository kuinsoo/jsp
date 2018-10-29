package kr.or.ddit.prod.prodDao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.PageVo;


public interface ProdDaoInf {
	
	// prod 테이블 테이터 전체 조회 쿼리 
	public List<ProdVo> selectProdAll();
	
	// 페이징 처리
	public List<ProdVo> selectProdPageList(PageVo pageVo);
	
	/**  * Method   : getUserCnt
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  사용자 전체 건수 조회 
	*/
	int getProdCnt();
	
	// 제품 클릭시 상세정보 나오게 설정
	public ProdVo selectProd(String prodId);

}
