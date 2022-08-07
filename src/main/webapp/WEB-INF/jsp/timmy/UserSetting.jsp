<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form class="form" method="post" modelAttribute="newUser" action="${contextRoot}/updateUser.controller">
		<form:input path="nickName"></form:input>
		<form:input path="address"></form:input>
		<form:input path="email"></form:input>
		<form:input path="selfIntroduction"></form:input>
		<form:input path="phone"></form:input>
	</form:form>
</body>
</html>