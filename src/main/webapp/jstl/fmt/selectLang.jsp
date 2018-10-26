<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/common/basicLib.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selectLang.jsp</title>
</head>

<c:set var = "lang" value="${param.lang==null?'ko':param.lang }"/>

<script type="text/javascript">
   $(document).ready(function(){
      // select box value set
      $("#lang").val("${lang}");
      
      $("#lang").on("change",function(){
         $("#frm").submit();
      });
   });
</script>
<body>
<%-- 

   1. lang 이라고 이름지어진 파라미터로 locale을 설정
   2. 만약 lang 파라미터가 없을 경우 ko를 기본 값으로사용
   3. select box가 변경될때 해당 언어로 페이지 재 요청 
   4. select box는 현재 요청된 lang 파라미터 언어 값이 선택되어져 있어야함.
      (lang 파라미터가 없을경우 기본 값은 ko)
      
   최초 접속  : http://localhost:8081/jstl/fmt/selectLang.jsp
   그 이후    : select box를 변경하여 페이지 재요청 
   안되면 버튼 클릭시 변경되게 해보기 
   
 --%>
   
<%--
      // 1번째 방법      
    <form id = "frm" action="/jstl/fmt/selectLang.jsp">   
       <select name = "lang" >   
          <option value="ko" <%if(lang.equals("ko")){%> selected <% } %>>한국어</option>
          <option value="en" <%if(lang.equals("en")){%> selected <% } %>>ENGLISH</option>
          <option value="ja" <%if(lang.equals("ja")){%> selected <% } %>>日本語</option>
       </select>
       <button type="submit">전송</button>
    </form>
     --%>
     <form id = "frm" action="selectLang.jsp">   
       <select name ="lang" id ="lang">   
          <option value="ko">한국어</option>
          <option value="en">ENGLISH</option>
          <option value="ja">日本語</option>
       </select>
    </form>

   
   <fmt:setLocale value="${lang }"/><br>
   <fmt:bundle basename="kr.or.ddit.resource.msg.msg"><br>
      <fmt:message key="hello"></fmt:message><br>
      <fmt:message key="visitor"><br>
         <fmt:param value="brown"></fmt:param><br>
      </fmt:message><br>
   </fmt:bundle> <br>
</body>
</html>
