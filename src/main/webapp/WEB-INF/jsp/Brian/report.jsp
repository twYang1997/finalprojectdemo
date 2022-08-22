<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>檢舉頁面</title>
<!-- DataTables  -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
</head>
<body>
	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>Email</th>
				<th>Posts</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="users" items="${posts}" varStatus="vs">
				<c:if test="${users.isReport==1}">
					<tr>
						<td>${users.postUser.email}</td>
						<td><c:forEach items="${posts}" var="p" varStatus="vs">
								<c:if test="${p.isReport==1}">
									<a href="#">${p.postUser.getNickName()}</a>
									<!-- post內文 -->
									<div id="box">
										${p.getPostText()}
									</div>
									<script type="text/javascript">
									function show(){ 
										var box = document.getElementById("box");
										var text = box.innerHTML;               //text是所有的文本
										var newBox = document.createElement("div"); //截取要一开始先显示的一部分放入newBox里面
										var btn = document.createElement("a"); 
										newBox.innerHTML = text.substring(0,20); 
										btn.innerHTML = text.length > 150 ? "...顯示全部" : ""; 
										btn.href = "###"; 
										btn.onclick = function(){ 
										if (btn.innerHTML == "...顯示全部"){ 
										btn.innerHTML = "隱藏部份"; 
										newBox.innerHTML = text; 
										}else{ 
										btn.innerHTML = "...顯示全部"; 
										newBox.innerHTML = text.substring(0,20); 
										} 
										} 
										box.innerHTML = ""; 
										box.appendChild(newBox); 
										box.appendChild(btn); 
										} 


										show(); 
									</script>
									<!-- post圖片 -->
									<c:forEach items="${p.getPostImg()}" var="pImg"
										varStatus="loop">
										<ul class="gallery">
											<li><img src="${contextRoot}/${pImg.getPostImgPath()}">
											</li>
										</ul>
									</c:forEach>
									<span><i class="fa fa-clock">${p.getPostTime()}</i> </span>
								</c:if>
							</c:forEach></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>
</body>
<script
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"></script>
<script
	src="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css"></script>
</html>