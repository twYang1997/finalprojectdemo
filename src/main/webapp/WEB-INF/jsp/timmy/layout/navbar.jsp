<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- <title>PET.COM</title> -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="${contextRoot}/">Navbar scroll</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarScroll" aria-controls="navbarScroll"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarScroll">
			<ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll"
				style="max-height: 100px;">
				<li class="nav-item active"><a class="nav-link"
					href="${contextRoot}/getMainPagePosts.controller"">Home <span class="sr-only">(current)</span>
				</a></li>
				<c:if test="${user.category == 1}">
					<li class="nav-item"><a class="nav-link"
						href="${contextRoot}/timmy/accountsetting.controller">User <span class="sr-only">(current)</span>
					</a></li>
				</c:if>
<!-- 				小郭 -->
				<c:if test="${user.category == 2}">
					<li class="nav-item"><a class="nav-link"
						href="">User <span class="sr-only">(current)</span>
					</a></li>
				</c:if>
<!-- 				嘉鴻 -->
				<li  class="nav-item"><a class="nav-link"
					href="${contextRoot}/zzzupload/fundraiser">Donate <span class="sr-only">(current)</span>
				</a></li>
<!-- 				亭孝 -->
				<c:if test="${user.category == 3}">
					<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/memberManagement">Manager <span class="sr-only">(current)</span>
				</a></li>
				</c:if>
				
<!-- 				<li class="nav-item"><a class="nav-link" href="#">Link</a></li> -->
<!-- 				<li class="nav-item dropdown"><a -->
<!-- 					class="nav-link dropdown-toggle" href="#" role="button" -->
<!-- 					data-toggle="dropdown" aria-expanded="false"> Link </a> -->
<!-- 					<ul class="dropdown-menu"> -->
<!-- 						<li><a class="dropdown-item" href="#">Action</a></li> -->
<!-- 						<li><a class="dropdown-item" href="#">Another action</a></li> -->
<!-- 						<li><hr class="dropdown-divider"></li> -->
<!-- 						<li><a class="dropdown-item" href="#">Something else here</a></li> -->
<!-- 					</ul></li> -->
				<li class="nav-item"><a class="nav-link disabled">Link</a></li>
			</ul>
			<form class="d-flex">
				<input class="form-control mr-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>

			<c:if test="${empty user}">

				<form:form method="GET" action="${contextRoot}/timmy/">

					<button type="submit" class="btn btn-light">Login</button>
				</form:form>
			</c:if>

			<c:if test="${!empty user}">
				<form method="GET" action="${contextRoot}/timmy/logout">
					<button type="submit" class="btn btn-light">Logout</button>
				</form>
			</c:if>

			<form method="GET" action="${contextRoot}/phoebe/signUp">
				<button type="submit" class="btn btn-info">Sign Up</button>
			</form>

			<c:if test="${!empty user}">
				&emsp;Hi, ${user.getNickName()}
			</c:if>

		</div>
	</nav>
	<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
	<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</body>
</html>