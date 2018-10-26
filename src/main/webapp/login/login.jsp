<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
<style>
	body {
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #eee;
	}
	
	.form-signin {
	  max-width: 330px;
	  padding: 15px;
	  margin: 0 auto;
	}
	.form-signin .form-signin-heading,
	.form-signin .checkbox {
	  margin-bottom: 10px;
	}
	.form-signin .checkbox {
	  font-weight: normal;
	}
	.form-signin .form-control {
	  position: relative;
	  height: auto;
	  -webkit-box-sizing: border-box;
	     -moz-box-sizing: border-box;
	          box-sizing: border-box;
	  padding: 10px;
	  font-size: 16px;
	}
	.form-signin .form-control:focus {
	  z-index: 2;
	}
	.form-signin input[type="email"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	
		
</style>
</head>
<body>

<%-- 
	브라우저 주소줄에 입력한 경우 : get
	브라우저 주소줄에 나오지 않게 하는 경우 : post
	form태그의 method 속성 : get/ post
 --%>
 
 <%-- 
<form action="/dditLogin" method="post">
	사용자 아이디 : <input type ="text" name="userId" value="brown"> <br>
<!--사용자 아이디 : <input type ="text" name="userId" value="샐리"> <br>  -->	
	사용자 비밀번호 : <input type = "password" name="password" value="pass1234"> <br>
	<input type="submit" value="로그인">
	
--%>


<%--금요일 수업 로그인 폼 꾸미기 --%>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

	<%@include file="/common/basicLib.jsp" %>
	
    <!-- Bootstrap core CSS -->
    <script type="text/javascript">
    $(document).ready(function(){
    	console.log("test");
    	// remember 쿠키값이 Y이면 
    	var cookieValue = getCookie("remember");
 
    	// remember-me 체크박스 체크 
    	if(cookieValue == "Y"){
    		$("#checkbox").attr("checked", true );
	    	// userId input value 를 userId 쿠키 값으로 설정 
	    	var userId = getCookie("userId");
	    	
	    	$("#userId").attr("value" , userId);
    	}
    	
    	
    });
    
    function getCookie(cookieName){
       //cookieString --> document.cookie
       var cookies = document.cookie.split("; ");
       var getCookieValue = "";
       for(var i=0;i<cookies.length;i++){
          var str = cookies[i];
          if(str.startsWith(cookieName +"=")){
             CookieValue = str.substring((cookieName + "=").length);
          }
       }

       return CookieValue;
    }
    
    // getCookie("userId");
    // getCookie("remember");
    
    </script>
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="/dditLogin" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">userId</label>
        <input id="userId" type="text" name="userId" class="form-control" placeholder="userId" required autofocus value="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" class="form-control" placeholder="Password" required value="">
     	<div class="checkbox">
     		<label>
     			<input id="checkbox" type="checkbox" value="Remember me" name="remember-me"/>
     			Remember me
     		</label>
     		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
     	</div>
      </form>

    </div> <!-- /container -->

  </body>
</html>
