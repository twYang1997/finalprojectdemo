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
			<div>
				<div class="row flex-fill">
					<div class="col-sm-5">

<table class="table table-hover display" id="order_table">
									<thead>
										<tr>
											<th scope="col">訂單日期</th>
											<th scope="col">訂單金額</th>
											<th scope="col">施主大名</th>
											<th scope="col">商品名稱</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="#" var="o" varStatus="vs">
											<tr>
												<td id="aaa" scope="row">#</td>
												<td>#</td>
												<td>#</td>
												<td>
													<c:forEach items="#" var="od">
														
														<br>
													</c:forEach>
												</td>

											</tr>
										</c:forEach>
									</tbody>

								</table>
						
					</div>
					
					
					<div class="col-sm-4 py-2"></div>
					<div class="col-sm-3 text-lg-end"></div>
				</div>

			</div>

	</div>


	<script>
		
	</script>
</body>
</html>