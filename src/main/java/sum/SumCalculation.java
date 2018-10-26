package sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 기존 view요청 get : localhost:8081/sumInput.jsp
		// 변경 view요청 get : localhost:8081/sumCalculation
		// sumInput.jsp forward
		
		RequestDispatcher rd =  request.getRequestDispatcher("jsp/sumInput.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sumInput.jsp에서 값 받아오기 
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		//CalculationLogic.java때문에 입력한것
		CalculationLogic logic = new CalculationLogic();
		int sum = logic.sumBetweenTwoNumbers(start,end);

		// start 파라미터와 end 파라미터 사이의 값을 합으로 계산한후 출력 
		System.out.println(sum);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult",sum);
		
		// dispatch forward
		RequestDispatcher rd = request.getRequestDispatcher("jsp/sumResult.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
	}

}
