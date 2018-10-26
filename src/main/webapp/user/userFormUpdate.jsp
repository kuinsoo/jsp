<%@page import="java.util.Date"%>
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

<title>userFormUpdate.jsp</title>
<%@ include file="/common/basicLib.jsp"%>

<!--  jquesry ui css -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- 다음주소 Api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- jquery ui Api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>

	$(document).ready(function(){
		
		// 생일 input datepicker적용
		// 제이쿼리로 가지고 온 Api 와 css가 datepicker를 가지고 있어서 따로 불러올 필요 없음 
		// yearRange 부분에 보여주고 싶은 년도 입력하면 된다
		$("#birth").datepicker({yearRange : "1992:2018" ,
	   	  changeMonth: true,
	      changeYear: true,
	      dateFormat: "yy-mm-dd" });
		// 주소 검색 버튼 이벤트 핸들러 
		$("#addrSearchBtn").click(function(){
			
			// 주소 검색 버튼 클릭 이벤트가 발생 했을때 실행 
		    new daum.Postcode({
		    	//oncomplete -> 검색결과를 클릭했을떄 
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            console.log(data);
		            // 주소 : roadAddress 
		            // 상세주소 : ""
		            // 우편번호 : zonecode
		            
		            // 주소 input에 value설정 : data.roadAddress
		            
		            $("#addr1").val(data.roadAddress);
		            
		            // 우편번호 input value 설정 : data.zonecode
		 
		            $("#zipcd").val(data.zonecode);
		        }
		    }).open();
			
		});
		
		function readURL(input) {
			 
		    if (input.files && input.files[0]) {
		        var reader = new FileReader();
		 
		        reader.onload = function (e) {
		            $('#image_section').attr('src', e.target.result);
		        }
		 
		        reader.readAsDataURL(input.files[0]);
		    }
		}
		 
		$("#imgInput").change(function(){
		    readURL(this);
		});
	});
	
	
</script>

<style type="text/css">
	#fileForm {
    	padding-left: 200px;
    	padding-top: 15px;
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

					<form action="/userFormUpdate" method="post" class="form-horizontal" role="form" 
							enctype="multipart/form-data">
					
						<% UserVo user = (UserVo)(request.getAttribute("userVo")); %>
						
	
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
<!-- 							<div class="col-sm-10"> -->
<%-- 								<% --%>
<%--// 									String profilePath = user.getProfile();--%>
<%--// 									profilePath = --%>
<%--// 									profilePath == null ? "/profile/noimage.png" : profilePath;--%>
<%-- 								%> --%>
<%-- 									<img id="image_section" src="<%= profilePath%>" alt="your image" /> --%>
<!-- 							</div> -->
							
								<c:choose>
    								<c:when test="${userVo.profile == null}"> 
    									<c:set var="profile" value="profile/noimage.png"></c:set>
    								</c:when>
    								<c:otherwise>
    									<c:set var="profile" value="${userVo.profile }"></c:set>
    								</c:otherwise>
    							</c:choose>
								
									<img src="${profile }" id="image_section" alt="your image">
							
							<div id="fileForm" class="col-sm-10">
									<input type="file" name="profile" id="imgInput" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="userId" name="userId"
										placeholder="아이디"  value="${userVo.userId }" readonly="readonly">
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="pass" name="pass"
										placeholder="비밀번호" value="${userVo.pass }">
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">이름</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" name="name"
										placeholder="이름" value="${userVo.name }">
							</div>
						</div>
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">주소</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addr1" name="addr1"
										placeholder="주소" value="${userVo.addr1 }"> 
								<!-- 주소 검색 버튼  -->
								<button id="addrSearchBtn" type="button" class="btn btn-default">주소검색</button>
							</div>
						</div>
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">상세주소</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addr2" name="addr2"
										placeholder="상세주소" value="${userVo.addr2 }">
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">우편번호</label>
							<div class="col-sm-10">
								<input  type="text" class="form-control" id="zipcd" name="zipcd"
										placeholder="우편번호" value="${userVo.zipcd }">
							</div>
						</div>
						
						<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						%>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">생년월일</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="birth" name="birth"
										placeholder="생년월일" 
										value="<fmt:formatDate value='${userVo.birth }' pattern='yyyy-MM-dd'/>">
			
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">이메일</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email" name="email"
										placeholder="이메일" value="${userVo.email }">
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">연락처</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="tel" name="tel"
										placeholder="연락처" value="${userVo.tel }">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button id="update" type="submit" class="btn btn-default">수정하기</button>
							</div>
						</div>


					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>