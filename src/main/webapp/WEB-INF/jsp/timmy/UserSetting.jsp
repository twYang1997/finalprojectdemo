<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextRoot}/js/timmy_js/updatedata.js"></script>
</head>
<style>
#emailerror {
	color: red;
}
</style>
<body>
	<label class="form-label">Email:</label>
	<span id="emailerror"></span>
	<div class="row" id="write" style="display:none">
		<div class="col-sm-5"  style="padding-right:0">
			<input class="form-control" name="email" id="num">
		</div>
		<div class="input-group mb-2 col-sm-5" style="padding-right:0">
			<div class="input-group-prepend">
				<div class="input-group-text">@</div>
			</div>
			<input type="text" class="form-control" id="inlineFormInputGroup">
		</div>
		<div class="col-sm-2">
			<button class="btn btn-outline-secondary" id="enter">
				<img src="${contextRoot}/img/userimg/enter.png" class="udateicon"
					width="18">
			</button>
		</div>
	</div>
	<div class="row" id="show">
		<div class="col-sm-10"  style="padding-right:0">
			<input class="form-control" name="email" value="${user.email }" disabled="disabled">
		</div>
		<div class="col-sm-2">
			<button id="pencil" class="btn btn-outline-secondary">
				<img src="${contextRoot}/img/userimg/pencil.png" class="udateicon"
					width="13">
			</button>
		</div>
	</div>
	<div>
		<label class="form-label">Nickname:</label> <input
			class="form-control userSetting" name="nickName"
			value="${user.nickName }">
	</div>
	<div>
		<label class="form-label">Phone:</label> <input
			class="form-control userSetting" name="phone" value="${user.phone }">
	</div>
	<div>
		<label class="form-label">Address:</label> <input
			class="form-control userSetting" name="address"
			value="${user.address }">
	</div>
	<div>
		<label class="form-label">Introduction:</label>
		<textarea class="form-control userSetting" name="selfIntroduction">${user.selfIntroduction }</textarea>
	</div>
</body>
<script>
$(document).ready(function() {
	var emailString = "${user.email}";
	var atpos = emailString.indexOf("@")
	var num = emailString.substring(0, atpos);
	var mail = emailString.substring(atpos + 1);
	var contextRoot = "/demo";
	$("#num")[0].setAttribute("value", num);
	$("#inlineFormInputGroup")[0].setAttribute("value", mail)
	$("#pencil").click(function(){
		$("#show")[0].setAttribute("style", "display:none");
		$("#write")[0].setAttribute("style", "display:");
	});
	$("#enter").click(function(){
		var font = $("#num")[0].getAttribute("value");
		console.log(font);
		var below = $("#inlineFormInputGroup")[0].getAttribute("value");
		console.log(below);
		var datao = { "value": font ,
					  "header": below
					};
		$.ajax({
			url: contextRoot + "/timmy/updateEmailAjax",
			contentType: "application/json",
			dataType: 'text',
			method: 'post',
			data: JSON.stringify(datao),
			success: function(result){
				console.log(result);
			},
			error: function(error) {
				console.log(error);
			}})
		});
	});
</script>

</html>