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
	<h3>購買頁面</h3>
	<div>
		<ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll"
			style="max-height:;">
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
			<li class="nav-item"><a class="nav-link"
				href="${contextRoot}/timmy/accountsetting.controller">論壇<span
					class="sr-only">(current)</span></a></li>


		</ul>

	</div>

	<div>
		&nbsp&nbsp <input type="text" name="name" placeholder="請輸入帳號">
		<pre></pre>
	</div>

	<div>
		&nbsp&nbsp <input type="tel" name="tel" placeholder="請輸入電話">
		<pre></pre>
	</div>
	<div>
		&nbsp&nbsp <input type="email" name="email" placeholder="輸入電子信箱">
		<pre></pre>
	</div>
	<div>
		&nbsp&nbsp <select>
			<option>請選擇付款方式</option>
			<option>Line</option>
			<option>visacard</option>
		</select>
	</div>

</body>
</html>