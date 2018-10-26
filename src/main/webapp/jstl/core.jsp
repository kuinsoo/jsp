<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="kr.or.ddit.user.userService.UserService"%>
<%@page import="kr.or.ddit.user.userService.UserServiceInf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core.jsp</title>
</head>
<body>	
    <h2> core set </h2>
    <%-- core tag prefix : c --%>
    <%-- jstl 태그 사용법 : <prefix : 태그명> --%>


    <%-- =같은 상황 = pageContext.setAttribute("attribute", "cSetValue"); --%>
    <c:set var="attribute" value="cSetValue" scope="request"/> <%-- 스코프 영역을 설정해준다.--%>
    el : ${attribute} <br />
    pageContext : <%=pageContext.getAttribute("attribute") %> <br />
    request : <%=request.getAttribute("attribute") %> <br />

    <h2> core remove </h2>
    <c:remove var="attribute" />
    el : ${attribute} <br />
    
    <h2>core if : 단일 비교</h2>
    <%-- if(){
    	}else if(){
    	}--%>
    	
    <c:set var="code" value="01"/>
    
    <%-- code가 "01"이면 if 안쪽 코드가 실행 --%>
    <c:if test="${code =='01'}">
    	if안쪽 
    </c:if>
    
    <h2>core choose : 실질적인 if 구문</h2>
    
    <c:choose>
    	<c:when test="${code == '00' }">공공</c:when>
    	<c:when test="${code == '01' }">공일</c:when>
    	<c:when test="${code == '02' }">공이</c:when>
    	<c:when test="${code == '03' }">공삼</c:when>
    	<c:otherwise>else</c:otherwise>
    </c:choose>
    
    <h2>core foreach : 반복문</h2>
    
    <%-- 사용자 리스트 1페이지 조회 --%>
    
    <% 
    	UserServiceInf userService = new UserService();
  	    PageVo pageVo = new PageVo();
  	  	pageVo.setPage(1);
  	  	pageVo.setPageSize(10);
  	  	
  	  Map<String , Object> resultMap = userService.selectUserPageList(pageVo);
  	    
   		request.setAttribute("userList" ,resultMap.get("userList"));
    
    %>
    <%-- <c:set var="user" value="userLIst의 값" --%>
    <table border="1">
    
    	<tr>
				<th>번호</th>
				<th>사용자 아이디</th>
				<th>사용자 이름</th>
				<th>사용자 생일</th>
		</tr>
	    <c:forEach items="${userList}" var="user" >
	    	<tr class="userClick">
				<td>${user.rnum}</td>
				<td>${user.userId}</td>
				<td>${user.name}</td>
				<td>${user.birth}</td>		
			</tr>
	    </c:forEach>
	</table>
	
	<h2>core foreach index loop</h2>
	<c:forEach begin="0" end="10" var="i" step="3">
		${i }&nbsp;&nbsp;&nbsp;
	</c:forEach>
	
	<h2>core foreach : map</h2>
	<%
		Map<String , String> strMap = new HashMap<String , String>();
	
		strMap.put("ranger1" , "brown");
		strMap.put("ranger2" , "sally");
		strMap.put("ranger3" , "cony");
		strMap.put("ranger4" , "james");
		
		request.setAttribute("strMap", strMap);
	%>
	
	<c:forEach items="${strMap }" var="map">
			${map.key }/${map.value }<br>
	</c:forEach>
	

</body>
</html>