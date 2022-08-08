<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
			<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>Insert title here</title>
				</head>
				<style>
				#emailerror {
					color: red;
				}
				</style>
				<body>
					<div class="container">
						<div>
							<label class="form-label">Email:</label> <span id="emailerror"></span>
							<button><img src="${contextRoot}/img/userimg/pencil.png" class="udateicon" width="10" ></button>
							<input class="form-control userSetting" name="email" value="${user.email }" readonly="readonly">
							
						</div>
						<div>
							<label class="form-label">Nickname:</label>
							<input class="form-control userSetting" name="nickName" value="${user.nickName }">
						</div>
						<div>
							<label class="form-label">Phone:</label>
							<input class="form-control userSetting" name="phone" value="${user.phone }">
						</div>
						<div>
							<label class="form-label">Address:</label>
							<input class="form-control userSetting" name="address" value="${user.address }">
						</div>
						<div>
							<label class="form-label">Introduction:</label>
							<textarea class="form-control userSetting"
								name="selfIntroduction">${user.selfIntroduction }</textarea>
						</div>
					</div>
				</body>
				<script>
					$(document).ready(function () {
						var contextRoot = "/demo";
						$(".userSetting").on("change", function(e) {
							var val = e.target.value;
							var hea = e.target.getAttribute("name")
							var datat = { "value": val,
										  "header": hea
							};
							console.log(datat);
							$.ajax({
								url: contextRoot + '/timmy/updateDataAjax',
								contentType: 'application/json',
								dataType: 'text',
								method: 'post',
								data: JSON.stringify(datat),
								success: function(result){
									console.log(result);
									if (hea == "nickName"){
									var head =	document.getElementById("hello");
									head.innerHTML = "Hello! " + result;
									var puN = document.getElementById("postUserName");
									puN.innerHTML = result;
									}
									if (hea == "email"){
										var err = document.getElementById("emailerror");
										err.innerHTML = result
									}
								},
								error: function(error){
									console.log(error);
								}
							})
						})

					});
				</script>

				</html>