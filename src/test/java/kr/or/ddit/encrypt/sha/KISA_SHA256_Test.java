package kr.or.ddit.encrypt.sha;

import static org.junit.Assert.*;

import org.junit.Test;

public class KISA_SHA256_Test {

	/**  * Method   : encrypttest
	  * 작성자 : PC 
	  * 변경이력 :  
	  * Method 설명 :  sha256 encrypt 테스트 
	*/
	@Test
	public void encrypttest() {
		
		/***Given : 주어진 상황 ***/
		String pass = "brownpass";
		String pass1 = "brownpasst";
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		String encrypt = KISA_SHA256.encrypt(pass);
		String encrypt1 = KISA_SHA256.encrypt(pass1);
		System.out.println("encrypt :" + encrypt);
		System.out.println("encrypt1 :" + encrypt1);

		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		
		assertEquals("f01471c38113db263f9a532d8b6c054af31bf653aeea92d1c284cdd022b9", encrypt);
		

		
	}

}
