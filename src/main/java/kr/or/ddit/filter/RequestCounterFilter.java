package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestCounterFilter implements Filter {
	
	// 계속 이용할것이기 때문에 전역변수로 입력한다 
	//public static Map<String,Integer> rcMap = new HashMap<String , Integer>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//map : key-uri(String) , value -count(Integer)
		
		
		// application객체 확보하기 
		ServletContext application = request.getServletContext();
		
		//application객체에서 requestMap가져오기 
		Map<String , Integer> rcMap = (Map<String ,Integer>)application.getAttribute("rcMap");
		
		//application 객체에  rcMap 객체가 존재하는지 확인
		// 없으면 신규 생성후 저장
		if(rcMap == null){
			rcMap = new HashMap<String , Integer>();
		}
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		Integer count =  rcMap.get(uri);
		
		if(count == null){
			rcMap.put(uri, 1);
		}
		else{
			rcMap.put(uri, ++count);
		}
		
		application.setAttribute("rcMap", rcMap);
		
		// 원래 했던 방법
		//String uri = ((HttpServletRequest)request).getRequestURI();
		//Integer count =  rcMap.get(uri);
		// 최초요청시에는 값이 없는것 
//		if(count == null)
//			rcMap.put(uri,1);
//		// 최초요청이 아닐시
//		else
//			rcMap.put(uri, ++count);

		
		//다른 적용할 필터가 있으면 다른 필터로 요청을 넘기고 
		// 더이상 적용할 필터가 없으면 원 요청에 대한 servlet/ jsp로 요청을 이관
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
