package kr.or.ddit.prod.prodService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.prodDao.ProdDao;
import kr.or.ddit.prod.prodDao.ProdDaoInf;
import kr.or.ddit.user.model.PageVo;

public class ProdService implements ProdServiceInf {
	
	public ProdService() {}
	private static ProdServiceInf service = null;
	
	public static ProdServiceInf getInstance() {
		if(service == null) {
			service = new ProdService();
		}
		return service;
	}

	private ProdDaoInf prod = ProdDao.getInstance();


	@Override
	public List<ProdVo> selectProdAll() {
		return prod.selectProdAll();
	}


	@Override
	public Map<String, Object> selectProdPageList(PageVo pageVo) {
		// 페이지에 해당 하는 유저 리스트(1~10건) 
		List<ProdVo> prodPageList = prod.selectProdPageList(pageVo);
		
		// 페이지 내비게이션을 위한 전체 유저 리스트 조회 
		int totalProdCnt = prod.getProdCnt();
		
		//리턴해야 하는게 두건일경우에는 (Map)
		// 결과를 담는 map
		Map<String , Object> resultMap = new HashMap<String , Object>();
		resultMap.put("prodPageList",prodPageList);
		//Math.ceil가 올림해주는 부분 
		resultMap.put("prodPageCnt",
				(int)Math.ceil((double)totalProdCnt / pageVo.getPageSize()));
		
		return resultMap;
	}


	@Override
	public ProdVo selectProd(String prodId) {
		return prod.selectProd(prodId);
	}

}
