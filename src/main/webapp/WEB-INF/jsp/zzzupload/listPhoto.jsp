<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>


<html>
<head>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    <jsp:include page="../timmy/layout/navbar.jsp" />
<meta charset="UTF-8">
<title>List Photo</title>
</head>
<body>
<div class="container">
<h1>列出所有圖片</h1>

<table id="mytable">

<c:forEach var="onePhoto"  items="${goodPhotoList}">
	<tr>
	   <td>${onePhoto.photoName}</td>
	   <td><img width="100" src="${contextRoot}/downloadImage/${onePhoto.id}"></td>
	</tr>   
</c:forEach>
</table>

</div>
</body>
</html>