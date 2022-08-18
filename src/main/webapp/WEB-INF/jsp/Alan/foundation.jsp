<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<jsp:include page="../timmy/layout/navbar.jsp" />
<jsp:include page="../Alan/layout/navbar.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<html>
<head>
<link href="${contextRoot}/css/shoppingcar.css" rel="stylesheet" />

<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


	<section id="price-section">
		<div class="container">
			<div class="row justify-content-center gapsectionsecond">
				<div class="col-lg-7 text-center">
					<div class="title-big pb-3 mb-3">
						<h3>論壇logo</h3>
					</div>
					<p class="description-p text-muted pe-0 pe-lg-0">整體 基金會簡介</p>
				</div>
			</div>

			<div class="row pt-5">
				<c:forEach items='${usersList}' var='user'>
					<div class="col-lg-4 pb-5 pb-lg-0">
						<div class="wrap-price">
							<div class="price-innerdetail text-center">

								<ul>
									<h5>${user.nickName}</h5>
									<div class="detail-pricing">
										<h4>${user.selfIntroduction}</h4>
										<h4>${user.money}</h4>
										<h4>${user.foundation.foundationId}</h4>

									</div>
									<form action="${contextRoot}/Alan/foundationProduct"
										method="post">
										<input type="hidden" value="${user.foundation.foundationId}"
											name=foundationId />
										<button type="submit" class="btn btn-secondary mt-5">立即幫助 請點我</button>
									</form>
								</ul>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
	</section>
	<style type="text/css">
	
.wrap { /*父元素*/
	width: 100%;
	height: 200px;
	display: flex;
	justify-content: space-between;
}

.left {
	background: red;
	width: 50%;
	height: 200px;
}

.right {
	background: blue;
	width: 50%;
	height: 200px;
}
</style>
	

</body>
</html>