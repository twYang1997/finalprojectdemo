<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../brianlayout/navbar.jsp" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>會員頁面施工中</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	
</script>
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
														modelAttribute="users" action="${contextRoot}/postUser">
														<form:input path="userId" type="hidden"
															value="${users.userId}" />
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
															<form:input path="birthday" type="date"
																value="${users.birthday}" class="form-control" />
														</div>
														<!--圖-->
														<div class="form-group" style="text-align: left;">
															<label for="inputAddress">photoPath之後換</label>
															<form:input path="photoPath" type="text"
																class="form-control" value="${users.photoPath}" />
														</div>
														<!--性別-->
														<div class="form-group" style="text-align: left;">
															<label for="inputAddress">gender</label> <br>
															<!--選項男-->
															<div class="form-check form-check-inline">
																<form:radiobutton path="gender" class="form-check-input"
																	value="0" />
																<label class="form-check-label" for="inlineRadio1">男</label>
															</div>
															<!--選項女-->
															<div class="form-check form-check-inline">
																<form:radiobutton path="gender" class="form-check-input"
																	value="1" />
																<label class="form-check-label" for="inlineRadio2">女</label>
															</div>
														</div>
														<!--權限-->
														<div class="form-group" style="text-align: left;">
															<label for="inputAddress">category之後換</label>
															<form:input path="category" type="text"
																class="form-control" value="${users.category}" />

														</div>

														<!--自介-->
														<div class="form-group" style="text-align: left;">
															<label for="exampleFormControlTextarea1">selfIntroduction</label>
															<form:textarea id="Textarea" path="selfIntroduction"
																class="form-control aa" rows="3" />
														</div>

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
									<a class="rounded-pill btn btn-danger "
										onclick="return confirm('確認刪除?')"
										href="${contextRoot}/message/deleteMessage/${workMessage.id}"
										role="button">刪除</a> <a class="rounded-pill btn btn-info "
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
<script>
	var num = "${fn:length(page.content)}";
	var Datas = "${page.content}";
	console.log(Datas);
	for (var i = 0; i < num; i++) {
		var a = Datas.substring(Datas.indexOf("selfIntroduction") + 17, Datas.indexOf(", pets"));
		var b = Datas.substring(Datas.indexOf("selfIntroduction"), Datas.indexOf(", pets"));
		console.log("a: " + a);
		console.log("b: " + b);
		var data = document.querySelectorAll('.aa')[i];
		document.querySelectorAll('.aa')[i].value = a;
		Datas = Datas.replace(b + ", pets", "");
		console.log("after Datas: " + Datas);
		console.log("---------------------------------")
	}
</script>
</html>