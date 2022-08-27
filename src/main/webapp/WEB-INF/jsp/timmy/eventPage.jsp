<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PEEiT</title>
<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
</style>
<body>
	<jsp:include page="layout/navbar.jsp" />
	<div class="container" style="margin-top:3%" >
		<div class="row">
			<div class="left">
				<div class="col-lg-12">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14460.01880763059!2d121.543412!3d25.0339145!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xedc006d25a9e35df!2z6LOH5bGV5ZyL6Zqb6IKh5Lu95pyJ6ZmQ5YWs5Y-4!5e0!3m2!1szh-TW!2stw!4v1661581304263!5m2!1szh-TW!2stw"
						width="640" height="480" style="border: 0;"></iframe>
					<!-- 				新建一個活動 -->
				</div>
			</div>
			<div class="right">
				<div class="col-lg-6">
					<a class="btn btn-outline-secondary btn-icon-text btn-edit-profile" role="button"
						data-toggle="modal" data-target="#myModaladd"
						id="viewDetailButtonAdd"><img src="${contextRoot}/img/petimg/add.png" width="100px" >
						</a>
					<div class="modal fade petModal" id="myModaladd">
						<div class="modal-dialog">
							<div class="modal-content">
								<!-- 彈出標題 -->
								<div class="modal-header">
									<h4 class="modal-title">New Party:</h4>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
	
								<form class="form" method="post"
									action="${contextRoot}/pet/insertNewPet.controller"
									enctype="multipart/form-data">
									<div class="modal-body">
										<label>Party Name:</label>
										<!-- ------------------ -->
										<div>
											<input class="form-control" name="petName" type="text">
										</div>
										<!-- ------------------ -->
										<br>
										<div class="form-group" style="text-align: left;">
											<label>Breed:&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
												type="radio" name="petType" value="1">Dog
											&nbsp;&nbsp; <input type="radio" name="petType" value="0">Cat
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
											<label>Birthday</label> <input name="petBirthday" type="date"
												class="form-control">
										</div>
										<!-- ------------------ -->
										<label>Introduction:</label>
										<div>
											<textarea class="form-control" name="petDescription"></textarea>
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
	</div>
</body>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.29/dist/sweetalert2.all.min.js"></script>
</html>