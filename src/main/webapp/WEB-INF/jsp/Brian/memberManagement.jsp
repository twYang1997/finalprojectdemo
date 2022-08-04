<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="../brianlayout/navbar.jsp" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員頁面施工中</title>
</head>
<body>
	<div class="container">
		<h1>會員頁面</h1>
		<c:forEach var="users" items="${page.content}">
			<div class="row justify-content-center">
				<div class="col-8">
					<div class="card">
						<div class="card-body">
							<div>${users.email}
								<div class="text-right">
									<!-- 編輯按鈕 -->
									<a class="btn btn-primary " href=# role="button" data-toggle="modal" data-target="#myModal">編輯</a>
										<!-- 框體調整 -->
										<div class="modal" id="myModal">
								  		<div class="modal-dialog">
								    	<div class="modal-content">
								      	<!-- 彈出標題 -->
								      	<div class="modal-header">
								        <h4 class="modal-title">Modal Heading</h4>
								        <button type="button" class="close" data-dismiss="modal">&times;</button>
								      	</div>
								      	<!-- 彈出內容 -->
	      
	
									    <!-- 按鈕 -->
									    <div class="modal-footer">
									      <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
									    </div>
									    </div>
									  	</div>
										</div>
									<a class="btn btn-danger " onclick="return confirm('確認刪除?')" href="${contextRoot}/message/deleteMessage/${workMessage.id}" role="button">刪除</a>
									<a class="btn btn-info " href="${contextRoot}/message/editMessage/${workMessage.id}" role="button">貼文記錄</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		
		<div class="row justify-content-center">
			<div class="col-8">
				<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
					<c:choose>
							<c:when  test="${page.number != pageNumber -1}">
								<a href="${contextRoot}/memberManagement?p=${pageNumber}">
									${pageNumber} </a>
							</c:when>
				    	<c:otherwise>
				       		${pageNumber}
				    	</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>