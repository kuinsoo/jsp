<%@page import="java.util.Set"%>
<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.userService.UserService"%>
<%@page import="kr.or.ddit.user.userService.UserServiceInf"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<title>userForm.jsp</title>
<%@ include file="/common/basicLib.jsp"%>

<!--  jquesry ui css -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- 다음주소 Api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- jquery ui Api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>

	$(document).ready(function(){
		
		// 개발과정 사용한 기본 값 설정 
// 		$("#userID").val();
// 		$("#pass").val("pass1234");
// 		$("#name").val("testUserId");
// 		$("#addr1").val("대전 중구 중앙로 76");
// 		$("#addr2").val("영민빌딩 2층 대덕인재개발원");
// 		$("#zipcd").val("34940");
// 		$("#birth").val("2018-08-08");
// 		$("#email").val("newUser@gmail.com");
// 		$("#tel").val("0422228202");
		            
		
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
		            
		            //$("#addr").val(data.roadAddress);
		            
		            // 우편번호 input value 설정 : data.zonecode
		 
		            //$("#zip").val(data.zonecode);
		        }
		    }).open();
			
		});
		
	});
</script>

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

					<form action="/userForm" method="post" class="form-horizontal" role="form" 
							enctype="multipart/form-data">
					
						<% UserVo user = (UserVo)(request.getAttribute("userInfo")); %>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
							<div class="col-sm-10">
			
									<input type="file" name="profile">
						
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">사용자
								아이디</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="userId" name="userId"
										placeholder="아이디">
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="pass" name="pass"
										placeholder="비밀번호">
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">이름</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" name="name"
										placeholder="이름">
							</div>
						</div>
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">주소</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addr1" name="addr1"
										placeholder="주소" readonly="readonly"> 
								<!-- 주소 검색 버튼  -->
								<button id="addrSearchBtn" type="button" class="btn btn-default">주소검색</button>
							</div>
						</div>
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">상세주소</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addr2" name="addr2"
										placeholder="상세주소">
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">우편번호</label>
							<div class="col-sm-10">
								<input  type="text" class="form-control" id="zipcd" name="zipcd"
										placeholder="우편번호" readonly="readonly">
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">생년월일</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="birth" name="birth"
										placeholder="생년월일">
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">이메일</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email" name="email"
										placeholder="이메일">
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">연락처</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="tel" name="tel"
										placeholder="연락처">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">사용자 등록</button>
							</div>
						</div>


					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>