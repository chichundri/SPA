<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jtemplate.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">

<textarea id="registrationTemplate" style="display:none">
	<form class="form-horizontal">
	
	<div class="form-group">
	    <label for="email" class="col-sm-2" >Email:</label>
	    <div class="col-sm-5">
		    <input type="text" class="form-control col-sm-5" id="email">
		</div>
		<div class="col-sm-5 emailError" ></div>
	</div>
	  	
	   <div class="form-group">
	    <label for="firstName" class="col-sm-2" >First Name:</label>
	    <div class="col-sm-5">
		    <input type="text" class="form-control col-sm-5" id="firstName">
		</div>
		<div class="col-sm-5 firstNameError" ></div>
	  </div>
	  
	   <div class="form-group">
	    <label for="lastName" class="col-sm-2" >Last Name:</label>
	    <div class="col-sm-5">
		    <input type="text" class="form-control col-sm-5" id="lastName">
		</div>
		<div class="col-sm-5 lastNameError" ></div>
	  </div>
	  
	  <div class="col-sm-2"></div>
	  <div class="col-sm-5">
		    <button id="registerSubmit" class="btn btn-success">Submit</button>
		</div>
		<div class="col-sm-5" ></div>
	</form>
</textarea>

<textarea id="viewDetailsTemplate" style="display:none">
	<table class="table table-striped table-bordered table-hover table-condensed table-responsive" style='width:70%;margin-left:10%;'>
	<h3><i>Employee Details</i></h3>
		<tr>
			<td>Email  </td>
			<td>{$T.employee.email}</td>
		</tr>
		<tr>
			<td>First Name </td>
			<td>{$T.employee.firstName}</td>
		</tr>
		<tr>
			<td>Last Name  </td>
			<td>{$T.employee.lastName}</td>
		</tr>
	</table>
</textarea>


</head>
<body>
	<a href="#" id="viewDetails">View Details</a>
	<br />
	<br />
	<div id="mainContent"></div>
</body>
</html>
