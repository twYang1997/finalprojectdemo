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
			<h3>成立訂單</h3>
		</div>
		<div class="card mb-3"></div>
		<!--  放進購物車內容 -->
		<div class="card mb-3">
			<div class="card-body">
				<div class="d-flex flex-column flex-lg-row">
					<div class="row flex-fill">
						<div class="col-sm-5">

							<c:forEach items='#' var='#'>
								<div class="card-body">
									<div class="d-flex flex-column flex-lg-row">
										<span class="avatar avatar-text rounded-3 me-4 mb-2">1</span>
										<div class="row flex-fill">
											<div class="col-sm-5">
												<h4 class="h5">購物車商品</h4>
											</div>
											<div class="col-sm-4 py-2">
												<span class="badge bg-secondary">購買數量</span>
												<span class="badge bg-secondary">單價:</span>
												<span class="badge bg-secondary">總計</span>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="col-sm-4 py-2"></div>
						<div class="col-sm-3 text-lg-end">



							<a href="#" class="btn btn-primary stretched-link">確認購買</a>

						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="card mb-3">
			<div class="card-body">
				<div class="d-flex flex-column flex-lg-row">
					<div class="row flex-fill">
						<div class="col-sm-5">

							<form>

								<li>姓名: <input type="text" size=6 maxlength=6></li>

								<li>地址: <input type="text" size=6 maxlength=6></li>
								<li>電話: <input type="text" size=6 maxlength=6></li>
								<li>信箱: <input type="text" size=6 maxlength=6></li>


							</form>
						</div>
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