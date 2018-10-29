package sum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalucalationLogicTest {

	//1~10까지의 합
	@Test
	public void sumBetweenTwoNumbers() {
		CalculationLogic logic = new CalculationLogic();
		int start = 10;
		int end = 1;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(55, sumResult);

	}
	
	// 테스트 한것 
	@Test
	public void sumBetweenTwoNumbers2() {
		CalculationLogic logic = new CalculationLogic();
		
		int start = 12;
		int end = 2;
		
		int sumResult = logic.sumBetweenTwoNumbers(start+2, end+2);
		
		//assertEquals(75, sumResult);
	}

}
