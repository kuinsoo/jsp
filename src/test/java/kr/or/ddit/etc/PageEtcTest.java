package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;


public class PageEtcTest {

	
	/**  * Method   : pageNaviCalTest
	  * 작성자 : PC 
	  * 변경이력 :  
	  * Method 설명 : 페이지 내비게이션 계산 테스트 
	*/
	@Test
	public void pageNaviCalTest() {
		/***Given : 주어진 상황 ***/
		int totalUserCnt = 105;
		int pageSize = 10;
		
		/***When : 어떤 동작 수행(메소드 호출)***/

		int nviSize = (int)Math.ceil((double)totalUserCnt / pageSize);
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(11, nviSize);


	}


}
