<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="zzzlayout/zzznavbar.jsp" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h3>捐錢LA</h3>

		<form:form class="form" method="post" modelAttribute="fundraiser"
			action="${contextRoot}/zzzupload/fundraiser">

			<button type="button">button</button>
		</form:form>
		<form class="form" method="GET" enctype="multipart/form-data"
			action="${contextRoot}/findById">
			<div>
				會員ID： <input type="text" name="id">
				<button>show member</button>
			</div>
		</form>

	</div>
</body>
</html>