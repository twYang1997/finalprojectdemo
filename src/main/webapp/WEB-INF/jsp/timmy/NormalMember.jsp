<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<img src="${contextRoot}/${user.photoPath}" width="200"
		id="preview_progressbarTW_img">
	<form action="uploadImg.controller" method="post"
		enctype="multipart/form-data">
		<input type="text" name="photoId" value="${user.userId}"
			style="display: none"> 更新大頭貼照：<input type="file"
			name="newPhoto" id="selectPhoto">
		<button>上傳</button>
	</form>
	<input type="file" name="testfile" id="testfile">
	<script>
		var file = document.getElementById("testfile");
		file.onchange = function() {
			console.log(file.files[0]);
			readURL(this);

		}
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					document.getElementById("preview_progressbarTW_img")
							.setAttribute("src", e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>
</body>

</html>