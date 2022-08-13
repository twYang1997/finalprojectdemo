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
                    <a class="navbar-brand" href="${contextRoot}/zzzupload/fundraiser">捐錢LA 首頁</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                           <li class="nav-item active"><a class="nav-link"
					href="${contextRoot}/zzzupload/zzzabout">關於本機構<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/zzzupload/foundation">基金會<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/zzzupload/order">訂單查詢<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/zzzupload/cart">購買頁面<span class="sr-only">(current)</span></a>
				</li>
                        </ul>
                    </div>
                </div>
            </nav>
	</div>
	<section id="price-section">
    <div class="container">
        <div class="row justify-content-center gapsectionsecond">
            <div class="col-lg-7 text-center">
                <div class="title-big pb-3 mb-3">
                    <h3>論壇logo</h3>
                </div>
                <p class="description-p text-muted pe-0 pe-lg-0">
                   基金會簡介
                </p>
            </div>
        </div>
        <div class="row pt-5">
            <div class="col-lg-4 pb-5 pb-lg-0">
                <div class="wrap-price">
                    <div class="price-innerdetail text-center">
                        <h5>這裡要放基金會名字</h5>
                        <p class="prices">150$</p>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Photoshoot duration </span>
                            <span class="float-right">4 Hours</span>
                        </div>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Number photo</span>
                            <span class="float-right">50 - 200</span>
                        </div>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Consultation</span>
                            <span class="float-right">Style</span>
                        </div>
                        <a href="#" class="btn btn-secondary mt-5">這裡要連結到基金會自介+結帳葉面</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 pb-5 pb-lg-0">
                <div class="wrap-price center-wrap">
                    <div class="price-innerdetail text-center">
                        <h5>這裡要放基金會名字</h5>
                        <p class="prices">350$</p>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Photoshoot duration </span>
                            <span class="float-right">4 Hours</span>
                        </div>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Number photo</span>
                            <span class="float-right">50 - 200</span>
                        </div>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Consultation</span>
                            <span class="float-right">Style</span>
                        </div>
                        <a href="#" class="btn btn-secondary mt-5">這裡要連結到基金會自介+結帳葉面</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 pb-5 pb-lg-0">
                <div class="wrap-price">
                    <div class="price-innerdetail text-center">
                        <h5>這裡要放基金會名字</h5>
                        <p class="prices">250$</p>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Photoshoot duration </span>
                            <span class="float-right">4 Hours</span>
                        </div>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Number photo</span>
                            <span class="float-right">50 - 200</span>
                        </div>
                        <div class="detail-pricing">
                            <span class="float-left"> <i class="bi bi-check2-circle"></i> Consultation</span>
                            <span class="float-right">Style</span>
                        </div>
                        <a href="#" class="btn btn-secondary mt-5">這裡要連結到基金會自介+結帳葉面</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>