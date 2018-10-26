package sum;

public class CalculationLogic {
	
	public static void main(String[] args){
		CalculationLogic logic = new CalculationLogic();
		int start = 10;
		int end = 1;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		if(sumResult == 55){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
	}

	public int sumBetweenTwoNumbers(int start, int end) {
		int min = Math.min(start, end);
		int max = Math.max(start, end);
		
		int sum = 0;
		
		for(int i = min ; i <= max; i++ ){
			sum += i;
		}
		
		return sum;
		
	}

}
