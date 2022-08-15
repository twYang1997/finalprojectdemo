<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<jsp:include page="../timmy/layout/navbar.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<html>

<head>


<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container px-5">
				<a class="navbar-brand" href="${contextRoot}/Alan/foundation">
					基金會</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/Alan/order">訂單查詢<span class="sr-only">(current)</span></a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/Alan/cart">購買頁面<span class="sr-only">(current)</span></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 mb-4 mb-lg-0">
				<div class="mx-auto text-center">
					<img src="https://via.placeholder.com/800x540/FF7F50/000000"
						class="rounded" alt="...">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="ps-lg-6 ps-xl-10 w-lg-90">
					<div class="mb-4">
						<div class="main-title title-left">
							Getting a Loan<span class="line-left"></span>
						</div>
						<h2 class="w-90">The greater part of the people trust on us</h2>
					</div>
					<p class="mb-4">There are many variations of passages of Lorem
						Ipsum available, but the majority have suffered alteration in some
						form, by injected humour, or randomised words which don't look
						even slightly believable.</p>



					<div id="accordion" class="accordion-style">
						<div class="card">
							<div class="card-header" id="headingOne">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed"
										data-bs-toggle="collapse" data-bs-target="#collapseOne"
										aria-expanded="false" aria-controls="collapseOne">How
										quick will my credit be subsidized?</button>
								</h5>
							</div>
							<div id="collapseOne" class="collapse"
								aria-labelledby="headingOne" data-bs-parent="#accordion"
								style="">
								<div class="card-body position-relative">There are many
									variations of passages of Lorem Ipsum available, but the
									majority have suffered alteration in some form, by injected
									humour, or randomised words which don't look even slightly
									believable.There are many variations of passages of Lorem Ipsum
									available, but the majority have suffered alteration in some
									form, by injected humour, or randomised.</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingTwo">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed"
										data-bs-toggle="collapse" data-bs-target="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo">What
										is outsourced financial support?</button>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse"
								aria-labelledby="headingTwo" data-bs-parent="#accordion">
								<div class="card-body position-relative">It is a long
									established fact that a reader will be distracted by the
									readable content of a page when looking at its layout. The
									point of using Lorem Ipsum is that it has a more-or-less normal
									distribution of letters, as opposed to using 'Content here,
									content here', making it look like readable English.</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingThree">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed"
										data-bs-toggle="collapse" data-bs-target="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">How
										long is an affirmed financing cost and credit offer
										substantial?</button>
								</h5>
							</div>
							<div id="collapseThree" class="collapse"
								aria-labelledby="headingThree" data-bs-parent="#accordion">
								<div class="card-body position-relative">Many desktop
									publishing packages and web page editors now use Lorem Ipsum as
									their default model text, and a search for 'lorem ipsum' will
									uncover many web sites still in their infancy. Various versions
									have evolved over the years, sometimes by accident, sometimes
									on purpose (injected humour and the like).</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingFour">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed"
										data-bs-toggle="collapse" data-bs-target="#collapseFour"
										aria-expanded="false" aria-controls="collapseFour">What
										sorts of commercial enterprise financing do you offer?</button>
								</h5>
							</div>
							<div id="collapseFour" class="collapse"
								aria-labelledby="headingFour" data-bs-parent="#accordion">
								<div class="card-body position-relative">It was
									popularised in the 1960s with the release of Letraset sheets
									containing Lorem Ipsum passages, and more recently with desktop
									publishing software like Aldus PageMaker including versions of
									Lorem Ipsum.</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingFive">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed"
										data-bs-toggle="collapse" data-bs-target="#collapseFive"
										aria-expanded="false" aria-controls="collapseFive">How
										might I roll out an improvement to my application?</button>
								</h5>
							</div>
							<div id="collapseFive" class="collapse"
								aria-labelledby="headingFive" data-bs-parent="#accordion">
								<div class="card-body position-relative">All the Lorem
									Ipsum generators on the Internet tend to repeat predefined
									chunks as necessary, Making this the first true generator on
									the Internet. It uses a dictionary of over 200 Latin words,
									combined with a handful of model sentence structures, to
									generate Lorem Ipsum which looks reasonable.</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>
	</div>
	</div>
	</div>








</body>
</html>