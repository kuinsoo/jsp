package kr.or.ddit.locales;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.junit.Test;

public class LocalesTest {

	@Test
	public void localestest() {
		/***Given : 주어진 상황 ***/
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		
		for(Locale locale : locales)
			System.out.println(locale);
		
		/***Then : 결과가 어떠해야하는지 정의 ***/

	}

}
