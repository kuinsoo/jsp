package kr.or.ddit.encrypt.seed;

import static org.junit.Assert.*;
import org.junit.Test;

public class KISA_SEED_CBC_Test {

	
	// 암호화 테스트 
	/**  * Method   : Encrypttest
	  * 작성자 : PC 
	  * 변경이력 :  
	  * Method 설명 :  seed encrypt 테스트 
	*/
	@Test
	public void Encrypttest() {
		/***Given : 주어진 상황 ***/
		String pass = "brownpass";
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		String encrypt = KISA_SEED_CBC.Encrypt(pass);
		// 복호화
		String decrypt = KISA_SEED_CBC.Decrypt(encrypt);

		/***Then : 결과가 어떠해야하는지 정의 ***/
		
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals(pass, decrypt);

	}

}
