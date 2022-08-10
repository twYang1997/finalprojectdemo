<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js">
	
</script>
<link rel="stylesheet" href="${contextRoot}/css/index.css">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
		<c:forEach var="post" items="${user.posts}">
			<table class="table">
				<tr>
					<td class="postUserName">${user.nickName}</td>
				</tr>
				<tr>
					<td>${post.postVideoSrc}</td>
				</tr>
				<tr>
					<td>${post.postText}</td>
				</tr>
			</table>
		</c:forEach>
<!-- 	<div class="col-lg-12"> -->
<!-- 		<div class="panel"> -->
<!-- 			<br/> -->
<!-- 			<div class="panel-heading"> -->
<!-- 				<h3 class="panel-title">Your Posts</h3> -->
<!-- 								</div> -->
<!-- 				<div class="panel-content panel-activity"> -->
<%-- 					<c:forEach items="${user.posts}" begin="0" end="${fn:length(user.posts)}" step="1" var="p" varStatus="vs"> --%>
<!-- 						<ul class="panel-activity__list"> -->
<!-- 							<li><i class="activity__list__icon fa fa-question-circle-o"></i> -->
<!-- 								<div class="activity__list__header"> -->
<!-- 									<img src="https://bootdey.com/img/Content/avatar/avatar2.png" -->
<%-- 										alt="" /> <a href="#" class="postUserName">${p.postUser.getNickName()}</a> --%>
<!-- 								</div> -->
<!-- 								<div class="activity__list__body entry-content"> -->

<!-- 									post內文 -->
<%-- 									<p>${p.getPostText()}</p> --%>

<!-- 									post圖片 -->
<%-- 									<c:forEach items="${p.getPostImg()}" var="pImg" --%>
<%-- 										varStatus="loop"> --%>
<!-- 										<ul class="gallery"> -->
<!-- 											<li><img -->
<%-- 												src="${contextRoot}/img/postImg/${pImg.getPostImgPath()}"> --%>
<!-- 											</li> -->
<!-- 										</ul> -->
<%-- 									</c:forEach> --%>

<!-- 								</div> -->
<!-- 								<div class="activity__list__footer"> -->
<!-- 									<a href="#"> <i class="fa fa-thumbs-up"></i>123 -->
<!-- 									</a> <a href="#"> <i class="fa fa-comments"></i>23 -->
<!-- 									</a> -->
<%-- 									<c:if test="${p.postUser.getUserId() == user.getUserId()}"> --%>
<!-- 										<a href="#" role="button" data-toggle="modal" -->
<%-- 											data-target="#myModal${vs.index}" --%>
<%-- 											id="viewDetailButton${vs.index}"> <i class="fa fa-pencil"></i>Edit --%>
<!-- 										</a> -->
<!-- 										<a href="#"> <i class="fa fa-trash"></i>Delete -->
<!-- 										</a> -->
<%-- 									</c:if> --%>
<%-- 									<span> <i class="fa fa-clock"></i>${p.getPostTime()} --%>
<!-- 									</span> -->
<!-- 								</div></li> -->
<!-- 						</ul> -->
<!-- 						彈出修改框 -->
<%-- 						<div class="modal fade" id="myModal${vs.index}" role="dialog"> --%>
<!-- 							<div class="modal-dialog"> -->
<!-- 								<div class="modal-content"> -->
<!-- 									head -->
<!-- 									<div class="modal-header"> -->
<!-- 										<h4 class="modal-title">Edit post</h4> -->
<!-- 										<button type="button" class="close" data-dismiss="modal">&times;</button> -->
<!-- 									</div> -->
<!-- 									body -->
<!-- 									<div class="modal-body"> -->
<%-- 										<form --%>
<%-- 											action="${contextRoot}/editPost.controller?postId=${p.getPostId()}" --%>
<%-- 											class="panel-activity__status" method="post" --%>
<%-- 											enctype="multipart/form-data"> --%>
<%-- 											<img src="${contextRoot}/img/phoebeImg/DefaultUserImage.png" --%>
<!-- 												style="width: 40px; height: 40px; border-radius: 50%;"> -->
<%-- 											${user.getNickName()} <select name="whoCanSeeIt"> --%>
<!-- 												<option value="1">Public</option> -->
<!-- 												<option value="2">Follower</option> -->
<!-- 												<option value="3">Only me</option> -->
<!-- 											</select> -->
<!-- 											<textarea name="postText" class="form-control" -->
<%-- 												style="border-style: none; overflow: hidden">${p.getPostText()}</textarea> --%>

<!-- 											<div id="result" name="result"></div> -->

<!-- 											footer -->
<!-- 											<div> -->
<!-- 												<div> -->
<!-- 													<label> <input -->
<!-- 														style="position: absolute; opacity: 0;" type="file" -->
<!-- 														name="postImg" id="file" multiple -->
<!-- 														onchange="readAsDataURL()" -->
<!-- 														accept="image/gif,image/jpeg,image/x-png" /> <i -->
<!-- 														class="fa fa-image"></i> -->
<!-- 													</label> &emsp; <label> <input -->
<!-- 														style="position: absolute; opacity: 0;" type="file" -->
<!-- 														name="postVideo" id="file" accept="video/*" /> <i -->
<!-- 														class="fa fa-video-camera"></i> -->
<!-- 													</label> -->
<!-- 												</div> -->
<!-- 												<button type="submit" -->
<!-- 													class="btn btn-sm btn-rounded btn-info">Save</button> -->
<!-- 											</div> -->
<%-- 										</form> --%>
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<%-- 					</c:forEach> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
</body>
</html>