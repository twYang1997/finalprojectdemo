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
	<h3>購務車頁面</h3>
	<div>
		 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <a class="navbar-brand" href="${contextRoot}/zzzupload/fundraiser">捐錢LA 首頁</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
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

	<div class="container">
	<form action="${contextRoot}/cartupload" method="post" enctype="multipart/form-data">
		&nbsp&nbsp <input id="name" type="text" name="name" placeholder="請輸入姓名" required />
		<pre></pre>

		&nbsp&nbsp <input type="email" name="email" placeholder="請輸入信箱" required />
		<pre></pre>
	
	
	   	&nbsp&nbsp <select   name="payment" >
			<option>請選擇付款方式</option>
			<option value= 1>Line pay</option>
			<option value= 2>visacard</option>
		</select>    
		<input type="submit" value="送出" />
		</form>
</div>
</body>
</html>