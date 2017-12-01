$(document).ready(function(){
	$("#mainContent").setTemplate($("#registrationTemplate").val());
	$("#mainContent").processTemplate();

	$("#email").blur(function(){
		var input=[];
		var email = $("#email").val();
		input.push("ACTION=RegistrationAction");
		input.push("OPERATION=CHECK_EMAIL_EXISTS");
		input.push("EMAIL_ID="+email);
		if(email != ""){
			performJSONAjaxRequest(input.join("&"), function(jsonResponse) {
				if(jsonResponse.STATUS == true) {
					$(".emailError").text("email Id exists try with different id");
					$("#email").val("");
				}
				else {
					$(".emailError").text("OK !!");
				}

			});
		}
	});
	
	$("#registerSubmit").click(function(){
		if($("#email").val() == ""){
			alert("email id mandatory");
			return;
		}
		var input=[];
		var email = $("#email").val();
		var firstName = $("#firstName").val();
		var lastName = $("#lastName").val();
		input.push("ACTION=RegistrationAction");
		input.push("OPERATION=REGISTER");
		input.push("EMAIL_ID="+email);
		input.push("FIRST_NAME="+firstName);
		input.push("LAST_NAME="+lastName);
		performJSONAjaxRequest(input.join("&"), function(jsonResponse) {
			if(jsonResponse.STATUS == true) {
				alert("Regstered");
			}
			else {
				alert("Failed");
			}
		});
	});
	
	$("#viewDetails").click(function(){
		var input=[];
		input.push("ACTION=RegistrationAction");
		input.push("OPERATION=VIEW_DETAILS");
		performJSONAjaxRequest(input.join("&"), function(jsonResponse) {
			jsonResponse.employee = eval('('+jsonResponse.employee+')'); 
			if(jsonResponse.employee == ""){
				alert("error");
			} else {
				$("#mainContent").setTemplate($("#viewDetailsTemplate").val());
				$("#mainContent").processTemplate(jsonResponse);
			}
		});
	})
	
});
	

function performJSONAjaxRequest(ajaxrequestdata, callbackfunctionName) {
	$.ajax({
		async: false,
		type: "POST", 
		url: "/JqueryAjaxJson/AjaxServlet", 
		data: ajaxrequestdata + "&reqType=AJAX", 
		success: function(r){
			jsonResponse = eval('('+$.trim(r)+')');
			try {
				callbackfunctionName(jsonResponse);
			} catch (e) {}
		},
		error: function(r){
			alert(r);
			console.log("error");
		}
	});
}
