<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
			<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title></title>
	<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
</head>
<style>
	.card {
		mix-blend-mode: multiply;
	}

	.modal {
		left: 400px;
	}

	#showPetImg {
		width: 200px;
		display: block;
		margin: 10px auto 10px auto;
	}
</style>

<body>
	<div class="container">
		<div class="album py-5">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
				<c:forEach items="${user.pets }" var="p" varStatus="vs">
					<div class="col">
						<div class="card">
							<img src="${contextRoot}${p.petPhotoPath}" class="card-img-top">
							<div class="card-body text-center fs-4">${p.petName }</div>
							<div class="card-footer text-end">
								<a class="rounded-pill btn btn-primary " role="button"
									data-toggle="modal" data-target="#myModal${vs.index}"
									id="viewDetailButton${vs.index}">Edit</a>
							</div>
						</div>
					</div>
					<div class="modal" id="myModal${vs.index}">
						<div class="modal-dialog">
							<div class="modal-content">
								<!-- 彈出標題 -->
								<div class="modal-header">
									<h4 class="modal-title">Edit:</h4>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<!-- 彈出內容 -->
								<div class="modal-body">
									<!-- 修改表單 -->
									<form:form id="form${vs.index}" class="form" method="post" modelAttribute="newPet"
										action="${contextRoot}/timmy/editPet"
										enctype="multipart/form-data">
										<form:input path="petId" type="hidden" value="${p.petId}" id="petId${vs.index}" />
										<!--頭像上傳-->
										<div class="container">
											<img src="${contextRoot}${p.petPhotoPath}"
												id="preview_progressbarTW_img${vs.index}"> <input
												type="file" name="testfile" id="testfile${vs.index}"
												style="display: none;">
										</div>
										<script>
											$(document).ready(function () {
														var contextRoot = "/demo";
														$("#preview_progressbarTW_img${vs.index}").click(function () {
															$("#testfile${vs.index}").click();
														});
														var file = document.getElementById("testfile${vs.index}");
														file.onchange = function () {
															console.log(file.files[0]);
															readURL(this);
															console.log(this.files[0].type);
														};
														function readURL(input) {
															if (input.files && input.files[0]) {
																var reader = new FileReader();
																reader.onload = function (e) {
																	document.getElementById("preview_progressbarTW_img${vs.index}").setAttribute("src", e.target.result);
																}
															}
															reader.readAsDataURL(input.files[0]);
														}
													});
										</script>
										<!--暱稱-->
										<div class="form-group" style="text-align: left;">
											<label>Name:</label>
											<form:input path="petName" type="text"
												class="form-control" value="${p.petName}" id="petName${vs.index}"/>
										</div>
										<!--生日-->
										<div class="form-group" style="text-align: left;">
											<label>Birthday:</label>
											<form:input id="myDate${vs.index}" path="petBirthday"
												type="date" class="form-control" />
											<!--取得生日-->
											<div id="hideDate${vs.index}" hidden="true">
												<fmt:formatDate pattern='yyyy-MM-dd'
													value='${p.petBirthday}' />
											</div>
										</div>
										<script type="text/javascript">
											$("#myDate${vs.index}").val($("#hideDate${vs.index}").html().trim());
										</script>
										<div class="form-group" style="text-align: left;">
											<label>Gender:</label><br>
											<!--選項男-->
											<form:radiobutton id="myRadiobutton1${vs.index}"
												path="petGender" value="1" label="Male" />
											<!--選項女-->
											<form:radiobutton id="myRadiobutton0${vs.index}"
												path="petGender" value="0" label="Female" />
										</div>
										<script type="text/javascript">
											if ("${p.petGender}" == 1) {
												$("#myRadiobutton1${vs.index}")
													.attr("checked", "true");
												
											} else if ("${p.petGender}" == 0) {
												$("#myRadiobutton0${vs.index}")
													.attr("checked", "true");
											}
										</script>
										<!--自介-->
										<div class="form-group" style="text-align: left;">
											<label for="exampleFormControlTextarea1">About:</label>
											<form:textarea id="myTextarea${vs.index}"
												path="petDescription" class="form-control aa"
												rows="3" />
										</div>
										<script type="text/javascript">
											$("#myTextarea${vs.index}").val(
												"${p.petDescription}");
										</script>
										<!-- 按鈕 -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal" id="closeplz${vs.index}">Close</button>
											<button type="button" class="btn btn-primary"
												id="sub${vs.index}">Submit</button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
					<script>
						$(document).ready(function (){
							var contextRoot = "/demo";
							var checkGender = "${p.petGender}";
							$("#myRadiobutton1${vs.index}").click(function(){
								checkGender = 1;
							});
							$("#myRadiobutton0${vs.index}").click(function(){
								checkGender = 0;
							})
							$("#sub${vs.index}").click(function(){
								var petId = $("#petId${vs.index}")[0].value;
								var file = document.getElementById("preview_progressbarTW_img${vs.index}").getAttribute("src");
								var petName = $("#petName${vs.index}")[0].value;
								var petBirthday = $("#myDate${vs.index}")[0].value;
								var petIntroduction = $("#myTextarea${vs.index}")[0].value;
								console.log("id:" + petId);
								console.log("file:" + file);
								console.log("Name:" + petName);
								console.log("birthday:" + petBirthday);
								console.log("Gender:" + checkGender);
								console.log("Introduction:" + petIntroduction);
								var datas = {
									"id":petId,
									"file":file,
									"name":petName,
									"birthday":petBirthday,
									"gender":checkGender,
									"introduction":petIntroduction
								}
								var jsonData = JSON.stringify(datas);
								console.log(jsonData);
								$.ajax({
									url: contextRoot + "/timmy/updatePetDataAjax",
									method: 'post',
									contentType: 'application/json',
									data: jsonData,
									success: function(result){
										console.log(result);
										$("#closeplz${vs.index}").click();
									},
									error: function(error){
										console.log(error);
									}
								})
							})
						});
					</script>
				</c:forEach>


				

				<!-- 			------------------------------------------------ -->
				<div class="col">
					<div class="card">
						<a class="btn btn-outline-secondary icon" role="button" data-toggle="modal"
							data-target="#myModaladd" id="viewDetailButtonAdd"><img
								src="${contextRoot}/img/petimg/add.png" class="card-img-top"></a>
					</div>
				</div>
				<div class="modal" id="myModaladd">
					<div class="modal-dialog">
						<div class="modal-content">
							<!-- 彈出標題 -->
							<div class="modal-header">
								<h4 class="modal-title">New Pet:</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<form class="form" method="post"
								action="${contextRoot}/pet/insertNewPet.controller"
								enctype="multipart/form-data">
								<div class="modal-body">
									<label>Name:</label>
									<!-- ------------------ -->
									<input type="file" id="addPetImg" name="file"
										style="display: none;">
									<!-- ------------------ -->
									<!-- ------------------ -->
									<div>
										<input class="form-control" name="petName" type="text">
									</div>
									<label>Photo:</label>
									<!-- ------------------ -->
									<div>
										<img src="${contextRoot}/img/petimg/pawprint.png"
											id="showPetImg">
									</div>
									<!-- ------------------ -->
									<br>
									<div class="form-group" style="text-align: left;">
										<label>Breed:&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
											type="radio" name="petType" value="1">Dog
										&nbsp;&nbsp; <input type="radio" name="petType"
											value="0">Cat
										&nbsp;&nbsp;
									</div>
									<!-- ------------------ -->
									<div class="form-group" style="text-align: left;">
										<label>Gender:&nbsp;&nbsp;&nbsp;</label> <input type="radio"
											name="petGender" value="1">Male &nbsp;&nbsp; <input
											type="radio" name="petGender" value="0">Female
									</div>
									<!-- ------------------ -->
									<div class="form-group" style="text-align: left;">
										<label>Birthday</label> <input name="petBirthday"
											type="date" class="form-control">
									</div>
									<!-- ------------------ -->
									<label>Introduction:</label>
									<div>
										<textarea class="form-control"
											name="petDescription"></textarea>
									</div>
									<input name="petPhotoPath" style="display: none" value="">
									<!-- ------------------ -->
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary"
										id="submitPetDetails">Add</button>
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(
		function () {
			var contextRoot = "/demo";
			var img64 = "";
			var imgType = "";
			$('#showPetImg').click(function () {
				$('#addPetImg').click();
			});
			var file = document.getElementById("addPetImg");
			file.onchange = function () {
				readFile(this);
			};
			function readFile(input) {
				if (input.files && input.files[0]) {
					var reader = new FileReader();
					reader.onload = function (e) {
						img64 = e.target.result;
						imgType = file.files[0].type;
						document.getElementById("showPetImg").setAttribute(
							"src", e.target.result);
					}
				}
				reader.readAsDataURL(input.files[0]);
			}
			// $("#submitPetDetails").click(function () {
			// 	if (img64.length > 0) {
			// 		var datao = {
			// 			"img64": img64,
			// 			"type": imgType,
			// 			"id": "${fn:length(user.pets)}"
			// 		}
			// 		var datas = JSON.stringify(datao);
			// 		$.ajax({
			// 			url: contextRoot + '/pets/uploadNewPetImgAjax',
			// 			contentType: 'application/json',
			// 			dataType: 'text',
			// 			method: 'post',
			// 			data: datas,
			// 			success: function (result) {
			// 				console.log(result);
			// 			},
			// 			error: function (error) {
			// 				console.log(error);
			// 			}
			// 		})
			// 	}
			// })
		});
</script>

</html>