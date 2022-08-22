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
		<div class="text-center mb-5">
			<h3>購物車</h3>
			<p class="lead">您購買的的東西</p>
		</div>
		<div class="card mb-3">
			<c:forEach items='${ShoppingCarProducts}' var='Products'>
				<div class="card-body">
					<div class="d-flex flex-column flex-lg-row">
						<span class="avatar avatar-text rounded-3 me-4 mb-2">FD</span>
						<div class="row flex-fill">
							<div class="col-sm-5">
								<h4 class="h5">${Products.products.productName}</h4>
							</div>
							<div class="col-sm-4 py-2">
								<!--  	<span class="counter">購買數量${Products.quantity}
								<</span>-->
								<form id='myform' method='POST' action='#'>
									<label for="">數量 </label><input type='button' value='-'
										class='qtyminus' field='quantity' />
									<!-- -->
									<input type='text' name='quantity' value='${Products.quantity}'
										class='qty' />
									<!-- -->
									<input type='button' value='+' class='qtyplus' field='quantity' />
								</form>

								<span class="badge bg-secondary">單價:${Products.unitPrice}</span>
								<span class="badge bg-secondary">總計${Products.totalPrice}</span>

							</div>
							<form method="post"
								action="${contextRoot}/Alan/deleteShoppingCarProduct">

								<button name="deleteShoppingCarProducts" type='submit' 
									value="${Products.shoppingCarId}" class='qtyminus' id=''>刪除</button>

							</form>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<div class="card mb-3">
			<div class="card-body">
				<div class="d-flex flex-column flex-lg-row">
					<div class="row flex-fill">
						<div class="col-sm-5"></div>
						<div class="col-sm-4 py-2"></div>
						<div class="col-sm-3 text-lg-end">
							<a href="#" class="btn btn-primary stretched-link">確認購買</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>