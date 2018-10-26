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

<title>prodDetail.jsp</title>
<%@ include file="/common/basicLib.jsp"%>


<style type="text/css">
	#updateForm {
    	padding-left: 200px;
	}
	
</style>

</head>

<body>
	<%-- @은 지시자 --%>
	<%-- header --%>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
				
					<% ProdVo prodVo = (ProdVo)(request.getAttribute("prodVo")); %>

			
					<form id="frm" class="form-horizontal" role="form">
					
		
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">제품
								아이디</label>
							<div class="col-sm-10">
								<input type="hidden" id="userId" name="userId"> 
								<label id="userId2"  class="control-label">${prodVo.prod_id }</label>
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">제품명</label>
							<div class="col-sm-10">
								<label  class="control-label">${prodVo.prod_name }</label>
							</div>
						</div>
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">제품그룹명</label>
							<div class="col-sm-10">
								<label class="control-label">${prodVo.lprod_nm }</label>
							</div>
						</div>
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">바이어이름</label>
							<div class="col-sm-10">
								<label class="control-label">${prodVo.buyer_name }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">바이어 이메일</label>
							<div class="col-sm-10">
								<label class="control-label">${prodVo.buyer_mail }</label>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>