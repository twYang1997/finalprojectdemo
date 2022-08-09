$(document).ready(function() {
		var contextRoot = "/demo";
		$(".userSetting").on("change", function(e) {
			var val = e.target.value;
			var hea = e.target.getAttribute("name")
			var datat = {
				"value" : val,
				"header" : hea
			};
			console.log(datat);
			$.ajax({
				url : contextRoot + '/timmy/updateDataAjax',
				contentType : 'application/json',
				dataType : 'text',
				method : 'post',
				data : JSON.stringify(datat),
				success : function(result) {
					console.log(result);
					if (hea == "nickName") {
						var head = document.getElementById("hello");
						head.innerHTML = "Hello! " + result;
						var puN = document.getElementById("postUserName");
						puN.innerHTML = result;
					}
					if (hea == "email") {
						var err = document.getElementById("emailerror");
						err.innerHTML = result
					}
				},
				error : function(error) {
					console.log(error);
				}
			})
		})

	});