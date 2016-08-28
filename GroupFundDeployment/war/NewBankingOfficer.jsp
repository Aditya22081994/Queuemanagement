<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Edit Employee Details</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
html,body{
	height: 100%;	
}
nav{
	position: fixed;
	width: 100%;
	height: 50px;
	background-color: rgba(0,0,0,.5);
	z-index: 99;
	text-align: center;
}
nav a{
	text-decoration: none;
	color: #fff;
	line-height: 50px;
	margin-left: 40px;
}
.sect{
	height: 100%;
}
.sect h1{
	color: #fff;
	line-height: 100%;
	text-align: center;
	font-size: 55px;
	font-family: verdana;
}
.sect h3{
	color:#fff;
	font-size: 30px;
	font-family: serif;
}
.sectOne{
	/*background-image: url('http://cdn.pcwallart.com/images/empire-state-building-view-at-night-wallpaper-3.jpg'); */
	background-color: black;
	opacity: 0.8;
}
.container-with-centered-content {
  display: flex;
  align-items: center;
  justify-content: center;
}
.transparent{
	opacity: 0.5;
}
.dropdown-menu{
	opacity: 0.7;
}
.space{
	white-space: pre;
}
.btn{
	height:30px;
}
.white{
	color: #fff;
	font-size: 18px;
}
.black{
	color: black;
}
.sect th,tr{
	color: #fff;
	font-weight: bolder;
}
.shade{
	background-color: gray;
}

@CHARSET "ISO-8859-1";
.dropdown {
    position: relative;
    display: inline-block;
}
/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 70px;
      box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

/* Links inside the dropdown */
.dropdown-content a {
    color: #000080;
    padding: 8px 16px;
    height: 30px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	color: white;
    display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
    color: blue;
}
a{
	height:20px;
	position: static;
}
}
</style>
</head>
<body>
<div class="container-fluid sect sectOne">
<form role="form" action="operationalservletbankingofficer" method="post">
<fieldset>
<legend><h3>Add Employees</h3></legend>
<div class="container">

<div class="form-group">
<label for="text">Add Employee Code</label>
<input type="text" class="form-control" name="AddCode" placeholder="Enter Employee Code" required>
</div>
<div class="form-group">
<label for="text">Add Employee Name: </label>
<input type="text" class="form-control" name="AddName" placeholder="Enter Employee Name" required>
</div>
<div class="form-group">
<label for="text">Add Employee Username :  </label>
<input type="text" class="form-control" name="AddUsername" placeholder="Enter Username" required>
</div>
<div class="form-group">
<label for="text">Add Employee Password :  </label>
<input type="text" class="form-control" name="AddPassword" placeholder="Enter Password" required>
</div>

<button type="submit" class="btn btn-success" name="AddButton" value="AddValue">Add</button>

</div>
</fieldset>
</form>



<br><br>
<form role="form" action="operationalservletbankingofficer" method="post">
<fieldset>
<legend><h3>Modify Employees</h3></legend>
<div class="container">

<div class="form-group">
<label for="text"> New Employee Code</label>
<input type="text" class="form-control" name="ModifyCode" placeholder="Enter Employee Code" required>
</div>
<div class="form-group">
<label for="text">New Employee Name: </label>
<input type="text" class="form-control" name="ModifyName" placeholder="Enter Employee Name" required>
</div>
<div class="form-group">
<label for="text">New Employee Password :  </label>
<input type="text" class="form-control" name="ModifyPassword" placeholder="Enter Password" required>
</div>
<button type="submit" class="btn btn-success" name="ModifyButton" value="ModifyValue">Add</button>

</div>
</fieldset>
</form>


<br><br>
<form role="form" action="operationalservletbankingofficer" method="post">
<fieldset>
<legend><h3>Delete Employees</h3></legend>
<div class="container">

<div class="form-group">
<label for="text">Employee Code</label>
<input type="text" class="form-control" name="DeleteCode" placeholder="Enter Employee Code" required">
</div>
<button type="submit" class="btn btn-success" name="DeleteButton" value="DeleteValue">Delete</button>
</div>

</fieldset>
</form>
</div>
</body>
</html>