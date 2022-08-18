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



	<div class="container">
		<c:forEach items='${usersList}' var='user'>
			<div class="row align-items-center">
				<div class="col-lg-6 mb-4 mb-lg-0">
					<div class="mx-auto text-center">
						<p class="w-90">${user.nickName}</p>
						<div class="wrap">
							<div class="left">
								<img src="${contextRoot}${user.photoPath}" class="rounded"
									alt="..." width="200" height="200">
							</div>

						</div>
						<p class="mb-4">${user.selfIntroduction}</p>
					</div>
				</div>
		</c:forEach>
		<div class="col-lg-6">
			<div class="ps-lg-6 ps-xl-10 w-lg-80">
				<form action="${contextRoot}/Alan/insertShoppingCar" method="post">
					<div class="mb-4">
						<p class="w-90">${user.nickName}</p>
					</div>
					<p class="mb-4">${user.selfIntroduction}</p>
					<c:forEach items='${foundationList}' var='foundation' end="0">
						<c:forEach items='${foundation.products}' var='product'>
							<div id="accordion" class="accordion-style">
								<div class="card">
									<div class="card-header" id="headingOne">
										<h5 class="mb-0">
											<input type="checkbox" name="checkbox"
												value="${product.productId}"
												onclick="oncheck(${product.productId}})" />
											<button class="btn btn-link collapsed"
												data-bs-toggle="collapse" data-bs-target="#collapseOne"
												aria-expanded="false" aria-controls="collapseOne">${product.productName}</button>
											<select>
												<option>請選擇數量</option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
												<option>6</option>
											</select>
										</h5>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:forEach>
					<button type="submit" class="btn btn-secondary mt-5">加入購物車</button>
				</form>
			</div>
			
		</div>
	</div>
	<style type="text/css">
.wrap { /*父元素*/
	width: 100%;
	height: 200px;
	display: flex;
	justify-content: space-between;
}

.left {
	background: #FFF2F2;
	width: 50%;
	height: 200px;
}

.right {
	background: #FFF2F2;
	width: 50%;
	height: 200px;
}
</style>
	<script>

</script>
</body>
</html>