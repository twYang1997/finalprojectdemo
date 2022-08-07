<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
		<div class="row justify-content-center">
			<div class="col-8">
				<div class="card">
					<div class="card-body">
						<div class="card-header">編輯公開資訊</div>
						<form:form class="form" method="post" modelAttribute="oneMember"
							action="${contextRoot}/editMember">
							
							<form:input type="hidden" path="userId" />
							<br />
							圖片：
							<img src="${contextRoot}/joey/img/1.jpg">
							<form:input type="text" path="photoPath" />
							<br />
							簡介：
							<form:input type="text" path="selfIntroduction" />
<!-- 							<br /> -->
<!-- 							電話： -->
							<form:input type="hidden" path="phone" />
<!-- 							<br /> -->
<!-- 							地址： -->
							<form:input type="hidden" path="address" />
<!-- 							<br /> -->
<!-- 							生日： -->
							<form:input type="hidden" path="birthday" />
<!-- 							<br /> -->
<!-- 							分類： -->
							<form:input type="hidden" path="category" />
<!-- 							<br /> -->
<!-- 							信箱： -->
							<form:input type="hidden" path="email" />
<!-- 							<br /> -->
<!-- 							性別： -->
							<form:input type="hidden" path="gender" />
<!-- 							<br /> -->
<!-- 							密碼： -->
							<form:input type="hidden" path="password" />
							<br />
							<button type="submit" class="btn btn-primary">Submit</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<br />
		<br />
		<div class="row justify-content-center">
			<div class="col-8">
				<div class="card">
					<div class="card-body">
						<div class="card-header">編輯私人資訊</div>
						<form:form class="form" method="post" modelAttribute="oneMember"
							action="${contextRoot}/editMember">

							<form:input type="hidden" path="userId" />
<!-- 							<br /> -->
<!-- 							圖片： -->
							<form:input type="hidden" path="photoPath" />
<!-- 							<br /> -->
<!-- 							簡介： -->
							<form:input type="hidden" path="selfIntroduction" />
<!-- 							<br /> -->
							電話：
							<form:input type="text" path="phone" />
							<br />
							地址：
							<form:input type="text" path="address" />
							<br />
							生日：
							<form:input type="date" path="birthday" />
							<br />
							分類：
							<form:input type="text" path="category" />
							<br />
							信箱：
							<form:input type="text" path="email" />
							<br />
							性別：
							<form:input type="text" path="gender" />
							<br />
							密碼：
							<form:input type="text" path="password" />
							<br />
							<button type="submit" class="btn btn-primary">Submit</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		
		
	</div>

</body>
</html>