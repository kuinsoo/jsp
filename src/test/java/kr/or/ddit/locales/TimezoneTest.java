package kr.or.ddit.locales;


import java.util.TimeZone;

import org.junit.Test;

public class TimezoneTest {

	@Test
	public void timeZonTest() {
		/***Given : 주어진 상황 ***/
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		String[] timezones = TimeZone.getAvailableIDs();
		for(String str : timezones)
			System.out.println(str);
		
		/***Then : 결과가 어떠해야하는지 정의 ***/

	}

}
