<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<c:forEach var="post" items="${user.posts}">
		<table class="table">
			<tr>
				<td>${user.nickName}</td>
			</tr>
			<tr>
				<td>${post.postVideoSrc}</td>
			</tr>
			<tr>
				<td>${post.postText}</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>