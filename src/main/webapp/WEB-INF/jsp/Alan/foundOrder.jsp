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
	<div class="container"></div>
	<div class="text-center mb-5">
		<h3>確認訂單</h3>
	</div>
	<div class="card mb-3"></div>
	<!--  放進購物車內容 -->
	<div class="card-body">
		<form action="${contextRoot}/Alan/Orders" method="post">
			<div>
				<div class="row flex-fill">
					<div class="col-sm-5">


						<div class="card-body">
							<div class="d-flex flex-column flex-lg-row">
								<span class="avatar avatar-text rounded-3 me-4 mb-2">商品</span>
								<div class="row flex-fill">
									<c:forEach items='${shoppingCarList}' var='orders'>
										<input type="hidden" name="Q" value="${orders.quantity}"></input>
										<input type="hidden" name="Id"
											value="${orders.products.productId}"></input>
										<input type="hidden" name="orderSubtotal"
											value="${orders.products.productPrice}"></input>
										<div class="col-sm-5">
											<h4>${orders.products.productName}</h4>
										</div>

										<div class="col-sm-4 py-2">
											<span>購買數量:${orders.quantity}</span> <span>單價:${orders.products.productPrice}</span>
											<div>
												<span>總計:</span>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>

					</div>
					<div class="col-sm-4 py-2"></div>
					<div class="col-sm-3 text-lg-end"></div>

					<!-- 	</div>
					<a href="#" type="button" style="float: right"
						class="btn btn-primary stretched-link">確認購買</a>
				</div> -->
				</div>

			</div>

			<div class="card mb-3">

				<div class="card-body">
					<div class="">


						<div class="row flex-fill">
							<div class="col-sm-5">



								<div>
									姓名: <input type="text" size=6 maxlength=6 id="name" value="">
								</div>
								<p></p>
								<div>
									地址: <input type="text" size=6 maxlength=6 id="address" value="">
								</div>
								<p></p>
								<div>
									電話: <input type="text" size=6 maxlength=6 id="phone" value="">
								</div>
								<p></p>
								<div>
									信箱: <input type="text" size=6 maxlength=6 id="email" value="">
								</div>





								<p>
									<input id="content" type="hidden" />
								</p>
								<input id="touch" type="button" value="一鍵填入" />

							</div>
							<div class="col-sm-4 py-2"></div>
							<div class="col-sm-3 text-lg-end"></div>

						</div>
						<p>
							<span id="change" value="123"></span>
						</p>

						<button  id="ecPay" style="float: right">確認購買</button>
						
					</div>

				</div>

			</div>
	</div>
	</form>


	<script>
		$("#touch").click(
				function() {
					var content = $("#content").val();
					content = "馬嘉鴻";
					content1 = "新北市大安區2-900號";
					content2 = "09123456789";
					content3 = "superpan54321@gmail.com";
					$("#name").replaceWith(
							"<label id='change'>" + content + "</label>");
					$("#address").replaceWith(
							"<label id='change'>" + content1 + "</label>");
					$("#phone").replaceWith(
							"<label id='change'>" + content2 + "</label>");
					$("#email").replaceWith(
							"<label id='change'>" + content3 + "</label>");
				});
		
		
	</script>
</body>
</html>