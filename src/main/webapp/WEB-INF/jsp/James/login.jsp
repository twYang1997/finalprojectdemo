<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="layout/navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PET.COM / Login</title>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>


	<section class="vh-100" style="background-color: #eee;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Login</p>
									<!-- 									form -->
									<form class="mx-1 mx-md-4"
										action="${contextRoot}/timmy/checkLogin.controller"
										method="post">
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												${errors.email } <input name="email" type="email"
													id="form3Example3c" class="form-control"
													placeholder="Email" required="required" />
											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												${errors.pwd } <input name="password" type="password"
													id="form3Example4c" class="form-control"
													placeholder="Password" required="required" />
											</div>
										</div>
										<div>
											<span>Remember Me </span><input type="checkbox"
												name="rememberMe" value="on">
										</div>
										<div>&emsp;</div>
										<div class="d-flex justify-content-center mx-6 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Login</button>
											<div style="color: red">&emsp;${errors.failed }</div>
											<button type="button" class="btn btn-outline-success btn-lg"
												id="forgetPwdBtn">Forgot password</button>
										</div>
    <div>
        Facebook登入：<input type="button"  value="Facebook登入" onclick="FBLogin();" />
    </div>
        <script type="text/javascript">
        //應用程式編號，進入 https://developers.facebook.com/apps/ 即可看到
        let FB_appID = "3164529347170909";

        //FB Login 官方文件：https://developers.facebook.com/docs/facebook-login/web

        // Load the Facebook Javascript SDK asynchronously
        (function (d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "https://connect.facebook.net/en_US/sdk.js";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));

        window.fbAsyncInit = function () {
            FB.init({
                appId: 3164529347170909,//FB appID
                cookie: true,  // enable cookies to allow the server to access the session
                
                xfbml: true,  // parse social plugins on this page
                version: 'v14.0' // use graph api version
            });

        };

        //使用自己客製化的按鈕來登入
        function FBLogin() {
            
            FB.login(function (response) {
                //debug用
                console.log(response);
                if (response.status === 'connected') {
                    //user已登入FB
                    //抓userID
                    let FB_ID = response["authResponse"]["userID"];
                    console.log("userID:" + FB_ID);

                   
                } else {
                    // user FB取消授權
                    alert("Facebook帳號無法登入");
                }
            }, { scope: 'public_profile,email' });

        }
        
        
        
    </script>
    
  
 

									</form>
	<select id="choose">
    <option value="user">使用者</option>
    <option value="admin">管理員</option>
    </select>
	<button id="fast" onclick="fast()">快速登入</button>
									<%-- 									<c:if test="${!empty verifyingEmail}"> --%>
									<button id="buildNewPwdBtn" style="display: none">buildNewPwdBtn</button>
									<script>
											$(function(){
												$("#buildNewPwdBtn").click(function(){
													var contextRoot = "/demo";
													Swal.fire({
													  title: 'New Password',
													  html:
														    'New Pwd  :<input id="swal-input1" type="password" class="swal2-input">' +
														    'Check Pwd:<input id="swal-input2" type="password" class="swal2-input">',
													  showCancelButton: true,
													  confirmButtonText: 'Submit',
													  showLoaderOnConfirm: true,
													  backdrop: true,
													  preConfirm: () => {
													    	 console.log(document.getElementById('swal-input1').value)
													         console.log(document.getElementById('swal-input2').value)
													         console.log("${verifyingEmail}");
													         let newPwd = document.getElementById('swal-input1').value;
													    	 let checkPwd = document.getElementById('swal-input2').value;
													    	 if (newPwd != checkPwd){
													    		 Swal.showValidationMessage("Please enter the correct password!");
													    	 } else {
													    		 let datas = {
													    				 "postId": aaa,
													    				 "commentText":checkPwd
													    		 };
													    		 let datao = JSON.stringify(datas);
													    		 $.ajax({
													    			 url: contextRoot + "/timmy/updateForgottenPwdAjax",
													    			 method: 'post',
													    			 contentType: "application/json",
																	 dataType: 'text',
																	 data: datao,
																	 success: function(result){
																		 console.log("ajax: " + result);
																	 },
																	 error: function(error){
																		 console.log(result);
																	 }
													    		 })
													    	 }
													  },
													  allowOutsideClick: () => !Swal.isLoading()
													}).then((result) => {
													  if (result.isConfirmed) {
													    Swal.fire({
													      title: 'Updated Success!',
													    })
													  }
													})
												});
// 												$("#buildNewPwdBtn").click();
												
											});
										</script>
									<%-- 									</c:if> --%>
									<script type="text/javascript">
										$(document).ready(function() {
											var contextRoot = "/demo";
											const acco = $('input[name="email"]');
											acco[0].setAttribute("value", "${cookie.userCookie.value}");
											if (acco[0].value != "") {
												$('input[name="rememberMe"]')[0].setAttribute("checked", "")
											}
											$("#forgetPwdBtn").click(function(){
												Swal.fire({
													  title: 'Enter your email',
													  text: 'We will send you an email to verify your account',
													  input: 'text',
													  inputAttributes: {
													    autocapitalize: 'off'
													  },
													  showCancelButton: true,
													  confirmButtonText: 'Submit',
													  showLoaderOnConfirm: true,
													  backdrop: true,
													  preConfirm: (login) => {
													    return $.ajax({
													    	url: contextRoot + "/timmy/checkEmailAjax?email=" + login,
													    	
													    	success: function(result){
													    		if (result == 'emailNotFound'){
													    			Swal.showValidationMessage("Email was not found!");
													    		}
													    		console.log("ajax success:" + result);
													    		aaa = login;
													    	}
													    })
													  },
													  allowOutsideClick: () => !Swal.isLoading()
													}).then((result) => {
													  if (result.isConfirmed) {
														console.log(result.value);
													    Swal.fire({
													    	title: 'Please enter the number which sent to your email',
													    	  html:
													    	    '<input id="swal-input3" class="swal2-input">',
													    	  focusConfirm: false,
													    	  preConfirm: () => {
													    	   let verifyNumber = document.getElementById('swal-input3').value;
													    	   console.log(verifyNumber);
													    	   if (verifyNumber == result.value){
													    		   console.log("success");
													    		   $("#buildNewPwdBtn").click();
													    	   } else {
													    		   Swal.showValidationMessage("error");
													    	   }
													    	  }
													    })
													  }
													})
												
											});
										});
									</script>
								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://images.unsplash.com/photo-1450778869180-41d0601e046e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2896&q=80"
										class="img-fluid" alt="Sample image">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		

		<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
		<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.29/dist/sweetalert2.all.min.js"></script>
			
			
<!-- 				<div class="text-center m-5"> -->
<!-- 		快速登入: -->
<!-- 		<button class="btn btn-outline-info fastLogin">Amy</button> -->
<!-- 		<button class="btn btn-outline-info fastLogin">Jack</button> -->
<!-- 		<button class="btn btn-outline-info fastLogin">Emma</button> -->
<!-- 		<button class="btn btn-outline-info fastLogin">Jim</button> -->
<!-- 	</div> -->
</body>

<script type="text/javascript">

function fast(){
	let choose=document.getElementById('choose').value;
	
	
	if(choose=='user'){
	let e=document.getElementById('form3Example3c');
	let p=document.getElementById('form3Example4c');
	e.value='user@gmail.com';
	p.value='123456789';}
	
	
	if(choose=='admin'){
		let e=document.getElementById('form3Example3c');
		let p=document.getElementById('form3Example4c');
		e.value='admin@gmail.com';
		p.value='123456789';}
	
}
// 	//快速登入
// 	$(".fastLogin").click(function() {
// 		$("#floatingInput").val(this.innerHTML);
// 		$("#floatingPassword").val(this.innerHTML + "001");
// 	});

// 	//密碼可視切換
// 	$("#checkEye").click(function() {
// 		if ($(this).hasClass('fa-eye')) {
// 			$("#floatingPassword").attr('type', 'password');
// 		} else {
// 			$("#floatingPassword").attr('type', 'text');
// 		}
// 		$(this).toggleClass('fa-eye').toggleClass('fa-eye-slash');
// 	});

// 	//取消按鈕返回上頁
// 	$("#cancel").click(function(event) {
// 		event.preventDefault(); //取消預設行為
// 		window.history.back(); //返回上一頁
// 	})
</script>
</html>