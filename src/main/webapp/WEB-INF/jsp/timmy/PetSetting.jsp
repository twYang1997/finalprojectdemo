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

	#myModal2 {
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
				<c:forEach items="${user.pets }" var="p">
					<div class="col">
						<div class="card">
							<img src="${contextRoot}/${p.petPhotoPath}" class="card-img-top">
							<div class="card-body text-center fs-4">${p.petName }</div>
							<div class="card-footer text-end">
								<button class="btn btn-primary add">edit</button>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="col">
					<div class="card">
						<a class="btn btn-outline-secondary icon" role="button" data-toggle="modal"
							data-target="#myModal2" id="viewDetailButton"><img src="${contextRoot}/img/petimg/add.png"
								class="card-img-top"></a>
					</div>
				</div>
				<div class="modal" id="myModal2">
					<div class="modal-dialog">
						<div class="modal-content">
							<!-- 彈出標題 -->
							<div class="modal-header">
								<h4 class="modal-title">New Pet:</h4>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<form class="form" method="post" action="${contextRoot}/pet/insertNewPet.controller" enctype="multipart/form-data">
								<div class="modal-body">
									<label>Name:</label>
									<!-- ------------------ -->
									<input type="file" id="addPetImg" name="file" style="display: none;">
									<!-- ------------------ -->
									<!-- ------------------ -->
									<div>
										<input class="form-control" name="petName" type="text">
									</div>
									<label>Photo:</label>
									<!-- ------------------ -->
									<div>
										<img src="${contextRoot}/img/petimg/pawprint.png" id="showPetImg">
									</div>
									<!-- ------------------ -->
									<br>
									<div class="form-group" style="text-align: left;">
										<label>Breed:&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<input type="radio" name="petType" value="1" >Dog
										&nbsp;&nbsp;
										<input type="radio" name="petType" value="0" >Cat
										&nbsp;&nbsp;
									</div>
									<!-- ------------------ -->
									<div class="form-group" style="text-align: left;">
										<label>Gender:&nbsp;&nbsp;&nbsp;</label>
										<input type="radio" name="petGender" value="1">Male
										&nbsp;&nbsp;
										<input type="radio" name="petGender" value="0">Female
									</div>
									<!-- ------------------ -->
									<div class="form-group" style="text-align: left;">
										<label>Birthday</label>
										<input name="petBirthday" type="date" class="form-control">
									</div>
									<!-- ------------------ -->
									<label>Introduction:</label>
									<div>
										<textarea class="form-control" name="petDescription"></textarea>
									</div>
									<input name="petPhotoPath" style="display:none" value="">
									<!-- ------------------ -->
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary" id="submitPetDetails">Add</button>
									<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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
	$(document).ready(function () {
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
					document.getElementById("showPetImg").setAttribute("src", e.target.result);
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