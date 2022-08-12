<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../timmy/layout/navbar.jsp" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>會員頁面施工中</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<style>
img {
	width: 200px;
	height: 150px;
	display: block;
	margin: 20px auto 20px auto;
	border-radius: 40%;
	display: block;
	display: block;
}
</style>
</head>

<body>
	<div class="container">
		<h1>會員頁面</h1>
		<c:forEach var="users" items="${page.content}" varStatus="vs">
			<div class="row justify-content-center">
				<div class="col-8">
					<div class="card">
						<div class="card-body">
							<div>${users.email}
								<div class="text-right">
									<!-- 修改按鈕 -->
									<a class="rounded-pill btn btn-primary " role="button"
										data-toggle="modal" data-target="#myModal${vs.index}"
										id="viewDetailButton${vs.index}">修改</a>
									<!-- 框體調整 -->
									<div class="modal" id="myModal${vs.index}">
										<div class="modal-dialog">
											<div class="modal-content">
												<!-- 彈出標題 -->
												<div class="modal-header">
													<h4 class="modal-title">修改資料</h4>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<!-- 彈出內容 -->
												<div class="modal-body">
													<!-- 修改表單 -->
													<form:form class="form" method="post"
														modelAttribute="users" action="${contextRoot}/editUser" enctype="multipart/form-data">
														<form:input path="userId" type="hidden"
															value="${users.userId}" />
														<!--頭像上傳-->
														<div class="container">
														<img src="${contextRoot}${users.photoPath}"id="preview_progressbarTW_img${vs.index}"> 
														<input type="file"name="testfile" id="testfile${vs.index}"  style="display:none ;">
													</div>
													<script>
														$(document)
														.ready(
															function() {
																var contextRoot = "/demo";
																$("#preview_progressbarTW_img${vs.index}").click(function() {
																	$("#testfile${vs.index}").click();
																});
																var file = document.getElementById("testfile${vs.index}");
																file.onchange = function() {
																	console.log(file.files[0]);
																	readURL(this);
																	console.log(this.files[0].type);
																	
																};
																function readURL(input) {
																	if (input.files && input.files[0]) {
																		var reader = new FileReader();
																		reader.onload = function(e) {
																			document.getElementById(
																				"preview_progressbarTW_img${vs.index}")
																				.setAttribute("src",
																					e.target.result);
// 																			console.log(e.target.result);
// 																			console.log(typeof e.target.result);
// 																			var datao = {
// 																				"img64": e.target.result,
// 																				"type": file.files[0].type,
// 																				"id": "${users.userId}"
// 																			}
// 																			var datas = JSON.stringify(datao);
// 																			$.ajax({
// 																					url: contextRoot + '/Brian/uploadImgAjax',
// 																					contentType: 'application/json',
// 																					dataType: 'text',
// 																					method: 'post',
// 																					data: datas,
// 																					success: function(result) {
// 																						console.log(result);
// 																					},
// 																					error: function(error) {
// 																						console.log(error);
// 																					}
// 																				});
																		}
																	}
																	reader.readAsDataURL(input.files[0]);
																}
															});
														</script>
														<!--email-->
														<div class="form-row" style="text-align: left;">
															<div class="form-group col-md-6">
																<label for="group">Email</label>
																<form:input path="email" type="email"
																	class="form-control" value="${users.email}" />
															</div>
															<!--密碼-->
															<div class="form-group col-md-6"
																style="text-align: left;">
																<label for="inputPassword4">Password</label>
																<form:input path="password" type="text"
																	class="form-control" value="${users.password}" />
															</div>
														</div>
														<!--暱稱-->
														<div class="form-group" style="text-align: left;">
															<label for="inputAddress">Nick name</label>
															<form:input path="nickName" type="text"
																class="form-control" value="${users.nickName}" />
														</div>
														<!--電話-->
														<div class="form-group" style="text-align: left;">
															<label for="inputAddress">phone</label>
															<form:input path="phone" type="text" class="form-control"
																value="${users.phone}" />
														</div>
														<!--地址-->
														<div class="form-group" style="text-align: left;">
															<label for="inputAddress">Address</label>
															<form:input path="address" type="text"
																class="form-control" value="${users.address}" />
														</div>
														<!--生日-->
														<div class="form-group" style="text-align: left;">
															<label for="inputAddress">Birthday</label>
															<form:input id="myDate${vs.index}" path="birthday" type="date"
																class="form-control"/>
														<!--取得生日-->
															<div id="hideDate${vs.index}" hidden="true">
																<fmt:formatDate pattern='yyyy-MM-dd' value='${users.birthday}'/>
															</div>
														</div>
														<script type="text/javascript">
															$("#myDate${vs.index}").val($("#hideDate${vs.index}").html().trim());
														</script>
														<div class="form-group" style="text-align: left;">
															<label for="inputAddress">gender</label><br>
															<!--選項男-->
															<form:radiobutton id="myRadiobutton1${vs.index}"
																path ="gender" value ="1" label ="Male"/>
															<!--選項女-->
                  											<form:radiobutton id="myRadiobutton0${vs.index}"
                  												path ="gender" value ="0" label ="Female"/>
														</div>
														<script type="text/javascript">
														if("${users.gender}" == 1){
															$("#myRadiobutton1${vs.index}").attr("checked", true);
														}else if("${users.gender}" == 0){
															$("#myRadiobutton0${vs.index}").attr("checked", true);
														}
														</script>
														<!--權限-->
														<div class="dropdown" style="text-align: left;">
														<!--下拉式選單-->
															<label for="inputAddress">category</label><br>
											               		<form:select id="myOption${vs.index}" path="category">
											               		<!--選單內容-->
											                        <form:option  value="1" label="一般會員"/>  
											                        <form:option  value="2" label="基金會"/>  
											                    </form:select>
														</div>
														<script type="text/javascript">
															$("#myOption${vs.index}").val("${users.category}");
														</script>
														<br>
														<!--自介-->
														<div class="form-group" style="text-align: left;">
															<label for="exampleFormControlTextarea1">selfIntroduction</label>
															<form:textarea id="myTextarea${vs.index}"
																path="selfIntroduction" class="form-control aa" rows="3" />
														</div>
														<script type="text/javascript">
															$("#myTextarea${vs.index}")	.val("${users.selfIntroduction}");
														</script>
														<!-- 按鈕 -->
														<div class="modal-footer">
															<button type="button" class="btn btn-danger"
																data-dismiss="modal">Close</button>
															<button type="submit" class="btn btn-primary">Submit</button>
														</div>
													</form:form>
												</div>
											</div>
										</div>
									</div>
									<!--停用按鈕 -->
									<c:if test="${users.category != 0 }">
										<a id="mydelete" class="rounded-pill btn btn-danger" 
											href="${contextRoot}/deleteUser?id=${users.userId}" 
											role="button">停用</a>
									</c:if>
									<!--恢復按鈕 -->
									<c:if test="${users.category == 0 }">
										<a id="mydelete" class="rounded-pill btn btn-secondary" 
											href="${contextRoot}/rebirthUser?id=${users.userId}" 
											role="button">恢復</a>
									</c:if>
									<!--貼文記錄按鈕 -->
									<a class="rounded-pill btn btn-info "
										href="${contextRoot}/message/editMessage/${workMessage.id}"
										role="button">貼文記錄</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

		<div class="row justify-content-center">
			<div class="col-8">
				<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
					<c:choose>
						<c:when test="${page.number != pageNumber -1}">
							<a href="${contextRoot}/memberManagement?p=${pageNumber}">
								${pageNumber} </a>
						</c:when>
						<c:otherwise>
							${pageNumber}				
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
	</div>
</body>

</html>