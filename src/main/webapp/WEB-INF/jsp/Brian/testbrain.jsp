<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input class="form-control mr-2" type="search" placeholder="Search" id=txt
					aria-label="Search" name="search" required>
				<button class="btn btn-outline-success" type="submit" id=sear>Search</button>
				<div id="test"></div>
					<script>
						var contextRoot = "/demo";
						var txt = document.getElementById("txt");
						var sear = document.getElementById("sear");
						function callProduct(email) {
							fetch(contextRoot + "/searchEmail?email=" + email).then(
									function(resp) {
										return resp.json();
									}).then(function(jsonObj) {
										console.log(jsonObj);
										window.location.reload();
								let allData = "";
								for (let i = 0; i < jsonObj.length; i++) {
// 									allData += '<h3 class="h4">' + jsonObj[i].email + "</h3>";
									allData += jsonObj[i].email;
									
								}
								let body = document.querySelectorAll(".h4");
								body[i].innerHTML = allData;
							})
						};
						sear.onclick = function(){
							callProduct(txt.value);
						};
						
					</script>
					
					<c:forEach var="users" items="${userList}" varStatus="vs">
					<c:if test="${users.money==null}">
						
							
										
													<h3 class="h4">${users.email}</h3>
												
											
											</c:if>
											</c:forEach>
</body>
</html>