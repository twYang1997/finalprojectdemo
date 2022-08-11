$(document).ready(function() {
	var contextRoot = "/demo";
	$("#viewDetailButton").click(function() {
		var det = document.getElementById("reset");
		document.getElementById("oldpwderror").innerHTML = "";
		document.getElementById("newpwderror").innerHTML = "";
		$("#oldpwd")[0].disabled = false;
		document.getElementById("updPwd").setAttribute("style", "display:none");
		document.getElementById("pwdenter").setAttribute("style", "display:");
		document.getElementById("checkicon").setAttribute("style", "display:none ");
		document.getElementById("checkpwdicon").setAttribute("style", "display: none");
		det.click();
	});
	$("#checkPassword").click(function() {
		var oldpwd = $("#oldpwd")[0].value;
		//		console.log(oldpwd);
		if (oldpwd.length > 0) {
			$.ajax({
				url: contextRoot + "/timmy/checkPasswordAjax",
				contentType: "application/json",
				dataType: 'text',
				method: "post",
				data: JSON.stringify({
					"value": oldpwd,
					"header": ""
				}),
				success: function(result) {
					console.log("AjaxSuccess: " + result);
					if (result == "correctpassword") {
						document.getElementById("oldpwderror").innerHTML = "";
						$("#oldpwd")[0].disabled = true;
						document.getElementById("updPwd").setAttribute("style", "display: ");
						document.getElementById("pwdenter").setAttribute("style", "display:none");
						document.getElementById("checkicon").setAttribute("style", "display: ");
						document.getElementById("edit").setAttribute("style", "display: ");
					} else {
						document.getElementById("oldpwderror").innerHTML = "password error";
					}
				},
				error: function(error) {
					conesole.log(error);
				}
			})
		}
	})
	console.log($("#newpwd"));
	console.log($("#checkpwd"));
	$("#newpwd").on("change", function(e) {
		console.log("aaa");
		var newPwd = e.target.value;
		console.log(newPwd);
		if (e.target.value != null) {
			$("#checkpwd").on("change", function(e) {
				document.getElementById("newpwderror").innerHTML = "";
				console.log("bbb");
				var checkPwd = e.target.value;
				console.log(checkPwd);
				if (newPwd != checkPwd){
					document.getElementById("checkpwdicon").setAttribute("style", "display: none");
					document.getElementById("newpwderror").innerHTML = "error";
					e.target.value = "";
				} else if (newPwd == checkPwd){
					document.getElementById("checkpwdicon").setAttribute("style", "display: ");
					$("#edit").on("click", function(){
						$.ajax({
							url: contextRoot + "/timmy/updatePasswordAjax",
							contentType: "application/json",
							dataType: 'text',
							method: "post",
							data: JSON.stringify({
								"value": checkPwd,
								"header": ""
							}),
							success: function(result){
								console.log("AjaxPwdsuccess: " + result);
								window.location.reload();
							},
							error: function(error){
								console.log(error)
							}
						})
					});
				}
			})
		}
	})

});