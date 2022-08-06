<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
<script src="${contextRoot}/js/timmy_js/uploadimg.js"></script>
</head>
<body>
	<img src="${contextRoot}/${user.photoPath}" width="200"
		id="preview_progressbarTW_img">
	<input type="file" name="testfile" id="testfile" style="display: none;">
	<h1>hello! ${user.nickName}</h1>
	<table>
		<tr>
			<td>follow</td>
			<td>fans</td>
			<td>posts</td>
		</tr>
		<tr>
			<td><a
				href="/user/followersManager.controller?id=${user.userId}">${fn:length(user.follows)}</a>
			</td>
			<td><a href="/user/fansManager.controller?id=${user.userId}">${fn:length(user.fans)}</a></td>
			<td>${fn:length(user.posts)}</td>
		</tr>
	</table>
<%-- 	<c:forEach var="one" items="${user.posts}"> --%>
<%-- 		<div>${one.text}</div> --%>
<%-- 	</c:forEach> --%>
	<ul>
		<li><a href="${contextRoot}/user/postManager.controller"
			class="a_post">貼文管理</a></li>
		<li><a href="${contextRoot}/user/memberDetail.controller"
			class="a_post">個人資料</a></li>
		<li><a href="${contextRoot}/user/petManager.controller"
			class="a_post">寵物管理</a></li>
	</ul>
</body>
<script>
	
</script>

</html>