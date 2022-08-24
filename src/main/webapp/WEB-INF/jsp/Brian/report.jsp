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
<title>檢舉頁面</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">

<link rel="stylesheet" href="${contextRoot}/css/report_index.css">
<link rel="stylesheet" href="${contextRoot}/css/report_navs.css">
</head>
<body>
	<!-- 頁簽開始 -->
	<span id="tab-1">主頁</span>
	<span id="tab-2">頁面1</span>
	<!--分頁 -->
	<div id="tab">
		<ul>
			<li><a href="#tab-1">被檢舉文章</a></li>
			<li><a href="#tab-2">移除文章</a></li>
		</ul>
		<!-- 		被檢舉文章 -->
		<div class="tab-content-1">
			<br>
			<div
				style="margin-top: 5px; margin-bottom: 20px; margin-left: 10px; margin-right: 10px; background: #f6f2f2; border-radius: 10px;">
				<table id="testTable" class="table">
					<thead>
						<tr>
							<th class="col-md-3" style="font-weight: bold;">Email</th>
							<th class="col-md-6">Posts</th>
							<th class="col-md-3">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="users" items="${posts}" varStatus="vs">
							<c:if test="${users.isReport==1}">
								<tr>
									<td class="col-md-3">${users.postUser.email}</td>
									<td class="col-md-6"><c:forEach items="${posts}" var="p"
											varStatus="vs">
											<c:if test="${p.isReport==1}">
												<a href="#">${p.postUser.getNickName()}</a>
												<span><i class="fa fa-clock">${p.getPostTime()}</i> </span>
												<!-- post內文 -->
												<div id="box">
													${p.getPostText()}
													<!-- post圖片 -->
													<c:forEach items="${p.getPostImg()}" var="pImg"
														varStatus="loop">
														<ul class="gallery" style="list-style: none;">
															<li><img
																src="${contextRoot}/${pImg.getPostImgPath()}"></li>
														</ul>
													</c:forEach>
												</div>
												<script type="text/javascript">
													function show() {
														var box = document
																.getElementById("box");
														var text = box.innerHTML; //text是所有的文本
														var newBox = document
																.createElement("div"); //截取要一开始先显示的一部分放入newBox里面
														var btn = document
																.createElement("a");
														newBox.innerHTML = text
																.substring(0,
																		20);
														btn.innerHTML = text.length > 21 ? "...顯示全部"
																: "";
														btn.href = "###";
														btn.onclick = function() {
															if (btn.innerHTML == "...顯示全部") {
																btn.innerHTML = "隱藏部份";
																newBox.innerHTML = text;
															} else {
																btn.innerHTML = "...顯示全部";
																newBox.innerHTML = text
																		.substring(
																				0,
																				20);
															}
														}
														box.innerHTML = "";
														box.appendChild(newBox);
														box.appendChild(btn);
													}
													show();
												</script>
											</c:if>
										</c:forEach></td>
 									<!--移除 -->
									<td class="col-md-3"><a
										class="rounded-pill btn btn-outline-success font-weight-bold"
										href="${contextRoot}/removePosts?id=${users.postId}"
										role="button">移除</a>
									<!--取消移除 -->
									<a
										class="rounded-pill btn btn-outline-success font-weight-bold"
										href="${contextRoot}/cancelRemovePosts?id=${users.postId}"
										role="button">取消移除</a></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<script>
			$(document)
					.ready(
							function() {
								$('#testTable')
										.DataTable(
												{
													paging : false,
													scrollY : 350,
													"dom" : "<'row'<'col-sm-12 col-md-6'l><'col-sm-12 col-md-6 'f>>"
															+ "<'row'<'col-sm-12'tr>>"
															+ "<'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7'p>>"
												});
							});
		</script>
<!------------------------------------------------------------------------------------------------------------------------------->
		<!-- 		移除文章 -->
		<div class="tab-content-2">
			<br>
			<div
				style="margin-top: 5px; margin-bottom: 20px; margin-left: 10px; margin-right: 10px; background: #f6f2f2; border-radius: 10px;">
				<table id="test2Table" class="table">
					<thead>
						<tr>
							<th class="col-md-3">Email</th>
							<th class="col-md-6">Posts</th>
							<th class="col-md-3">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="users" items="${posts}" varStatus="vs">
							<c:if test="${users.isBanned==1}">
								<tr>
									<td class="col-md-3">${users.postUser.email}</td>
									<td class="col-md-6"><c:forEach items="${posts}" var="p"
											varStatus="vs">
											<c:if test="${p.isBanned==1}">
												<a href="#">${p.postUser.getNickName()}</a>
												<span><i class="fa fa-clock">${p.getPostTime()}</i> </span>
												<!-- post內文 -->
												<div id="box2">
													${p.getPostText()}
													<!-- post圖片 -->
													<c:forEach items="${p.getPostImg()}" var="pImg"
														varStatus="loop">
														<ul class="gallery" style="list-style: none;">
															<li><img
																src="${contextRoot}/${pImg.getPostImgPath()}"></li>
														</ul>
													</c:forEach>
												</div>
												<script type="text/javascript">
													function show() {
														var box = document
																.getElementById("box2");
														var text = box.innerHTML; //text是所有的文本
														var newBox = document
																.createElement("div"); //截取要一开始先显示的一部分放入newBox里面
														var btn = document
																.createElement("a");
														newBox.innerHTML = text
																.substring(0,
																		20);
														btn.innerHTML = text.length > 21 ? "...顯示全部"
																: "";
														btn.href = "###";
														btn.onclick = function() {
															if (btn.innerHTML == "...顯示全部") {
																btn.innerHTML = "隱藏部份";
																newBox.innerHTML = text;
															} else {
																btn.innerHTML = "...顯示全部";
																newBox.innerHTML = text
																		.substring(
																				0,
																				20);
															}
														}
														box.innerHTML = "";
														box.appendChild(newBox);
														box.appendChild(btn);
													}
													show();
												</script>
											</c:if>
										</c:forEach></td>
									<td class="col-md-3"><a
										class="rounded-pill btn btn-outline-success font-weight-bold"
										href="${contextRoot}/removePostsRestoration?id=${users.postId}"
										role="button">回復</a></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<script>
				//DataTable
				$(function() {
					$("#test2Table")
							.DataTable(
									{
										paging : false,
										scrollY : 350,
										"dom" : "<'row'<'col-sm-12 col-md-6'l><'col-sm-12 col-md-6 'f>>"
												+ "<'row'<'col-sm-12'tr>>"
												+ "<'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7'p>>"
									});
				});
			</script>
		</div>
	</div>
</body>
<script
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"></script>
<script
	src="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css"></script>
</html>