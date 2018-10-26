<%@page import="kr.or.ddit.prod.model.ProdVo"%>
<%@page import="java.util.Set"%>
<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.userService.UserService"%>
<%@page import="kr.or.ddit.user.userService.UserServiceInf"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>prodList.jsp</title>
	<%@ include file="/common/basicLib.jsp" %> 
	
<style type="text/css">
	.userClick{
		cursor : pointer;

	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
		// tr에 select(class="userClick")
		$(".prodClick").on("click",function(){
			var prodId = $(this).children()[1].innerText;
			
			$("#prodId").val(prodId);
			
			//  .summit();
			$("#frm").submit();
		});
		
	});
</script>
</head>
<form id="frm" action="pordDetail" method="get">
	<input type="hidden" id="prodId" name="prodId"/>
</form>
<body>
   <%-- @은 지시자 --%>
   <%-- header --%>
   <%@ include file="/common/header.jsp" %> 
   
   <div class="container-fluid">
      <div class="row">
      
         <%-- left --%>
         <%@ include file="/common/left.jsp" %>
         
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background-color: white;">
            <div class="row" style="background-color: white;">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">제품</h2>
					<div class="table-responsive">
						<table class="table table-striped table-hover" >
							<tr>
								<th>제품아이디</th>
								<th>제품명</th>
								<th>제품그룹명</th>
								<th>제품등록일</th>
							</tr>

							<!-- userList loop 이용하여 출력  -->
							<c:forEach items="${prodPageList }" var="vo"  >
								<tr class="prodClick">
									<td>${vo.prod_id}</td>
									<td>${vo.prod_name}</td>
									<td>${vo.lprod_nm}</td>
									<td><fmt:formatDate value="${vo.prod_insdate}" pattern="yyyy-MM-dd"/>
								</tr>
							</c:forEach>
							
						</table>
					</div>
								
					<div class="text-center">
						<ul class="pagination">

							   <li>
							      <a href="/prodList?page=1&pageSize=10" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>

							<c:set var="pageCnt" value="${pageCnt }"></c:set>
						
							<c:forEach begin="1" end="${pageCnt }" var="page" >
								<tr>
									<li><a href="/prodList?page=${page }&pageSize=10">${page }</a></li>
								</tr>
							</c:forEach>
						
						
						    <li>
						      <a href="/prodList?page=${pageCnt }&pageSize=10" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						    
						</ul>
						
					</div>
				</div>
			</div>
         </div>
      </div>
   </div>
</body>
</html>