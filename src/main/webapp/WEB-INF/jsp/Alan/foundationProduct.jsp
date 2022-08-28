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
					<!-- 這個form 回傳的Controller -->
					<div class="mb-4"></div>
					<c:forEach items='${foundationList}' var='foundation' end="0">
						<c:forEach items='${foundation.products}' var='product'>
							<div id="accordion" class="accordion-style">
								<div class="card">
									<div class="card-header" id="headingOne">
										<h5 class="mb-0">
											<!--  勾選需要商品進購物車 -->
											<input  type="checkbox" name="checkbox"
												value="${product.productId}"
												onclick="oncheck(${product.productId})" />
											<!-- 利用script 功能 oncheck 使用函式 把 商品與數量的值一起傳入後端 -->

											<button class="btn btn-link collapsed"
												data-bs-toggle="collapse" data-bs-target="#collapseOne"
												aria-expanded="false" aria-controls="collapseOne">${product.productName}</button>

											請選擇數量<select name="quantity"
												id="quantity${product.productId}">
												<!-- quantity回傳後端/Alan/insertShoppingCar的名字 -->
												<option >0</option>
												<option >1</option>
												<!-- 數字或英文的話可以不用給value 做回傳  會自動回傳值 -->
												<option >2</option>
												<option >3</option>
												<option >4</option>
												<option >5</option>
												<option >6</option>
												<option >7</option>
												<option >8</option>
												<option >9</option>
												<option >10</option>
											</select>

			
											<div>單價${product.productPrice}</div>
											
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
	<script>    <!-- 上方oncheck用的函式 -->

	 <!-- function oncheck(id){
	 var selected = document.getElementById("quantity"+id).value;
	  
		alert(selected); 
	 } -->

</script>

</body>

</html>