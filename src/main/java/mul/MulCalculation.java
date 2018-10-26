package mul;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sumInput.jsp에서 값 받아오기 
				int start = Integer.parseInt(request.getParameter("param1"));
				int end = Integer.parseInt(request.getParameter("param2"));
				
				// start값은 end보다 작다 
				int mul = 1;
				
				for(int i = start ; i <= end; i++ ){
					mul *= i;
				}

				// start 파라미터와 end 파라미터 사이의 값을 곱으로 계산한후 출력 
				System.out.println(mul);
				
				HttpSession session = request.getSession();
				session.setAttribute("mulResult",mul);
				
				// dispatch forward
				RequestDispatcher rd = request.getRequestDispatcher("jsp/mulResult.jsp");
				rd.forward(request, response);
				
				
	}

}
