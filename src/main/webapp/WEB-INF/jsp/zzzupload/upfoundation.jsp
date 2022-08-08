<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../zzzlayout/navbar.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
    <h1>基金會上傳頁面</h1>

<form action="fileupload" method="post" enctype="multipart/form-data">

name : <input id="nickName" name="nickName">

<br />

   file : <input type="file" name="file">

<br />

<input type="submit" value="送出" />


</form>



</div>



</body>
</html>