<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="zzzlayout/zzznavbar.jsp" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>購買頁面</h3>

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