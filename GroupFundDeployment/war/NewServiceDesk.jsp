<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style type="text/css">
  html,body{
	background-color: #696969;
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

.container-with-centered-content {
  display: flex;
  align-items: center;
  justify-content: center;
}

.btn{
	height:30px;
}
.white{
	color: #fff;
	font-size: 18px;
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
<title>Service Desk Details</title>
</head>
<body>
<div class="container-fluid sectOne sect">
<form role="form" action="operationservletservicedesk" method="post">
<fieldset>
<legend><h3>Add ServiceDesk</h3></legend>
<div class="container">

    <div class="form-group">
      <label for="text">Add ServiceDesk Number : </label>
      <input type="text" class="form-control" name="AddScode" placeholder="Enter Branch Code">
    </div>
    <div class="form-group">
      <label for="text">Add Branch Code</label>
      <input type="text" class="form-control" name="AddSbranchCode" placeholder="Enter location">
    </div>
    <div class="form-group">
    <label for="text">Is Active : </label>
    <input type="text" class="form-control" name="AddSstatus" placeholder="Yes or No">
    </div>
        <button type="submit" name="AddSbutton" value="AddSvalue" class="btn btn-success">Submit</button>
</div>
</fieldset>
</form>



<br><br>
<form  role="form" action="operationservletservicedesk" method="post">
<fieldset>
<legend><h3>Modify ServiceDesk</h3></legend>
<div class="container">

    <div class="form-group">
      <label for="text">Add ServiceDesk Number : </label>
      <input type="text" class="form-control" name="ModifyScode" placeholder="Enter Branch Code">
    </div>
    <div class="form-group">
      <label for="text">Add Branch Code</label>
      <input type="text" class="form-control" name="ModifySbranchCode" placeholder="Enter location">
    </div>
    <div class="form-group">
    <label for="text">Is Active : </label>
    <input type="text" class="form-control" name="ModifySstatus" placeholder="Yes or No">
    </div>
        <button type="submit" name="ModifySbutton" value="ModifySvalue" class="btn btn-success">Submit</button>
</div>
</fieldset>
</form>


<br><br>
<form role="form" action="operationservletservicedesk" method="post">
<fieldset>
<legend><h3>Delete ServiceDesk</h3></legend>
<div class="container">
<div class="form-group">
<label for="text">Service Desk Number</label>
<input type="text" class="form-control" name="DeleteScode" placeholder="Enter Service Desk Number">
</div>
<button type="submit" name="DeleteSbutton" value="DeleteSvalue" class="btn btn-success">Submit</button>
</div>
</fieldset>
</form>
</div>
</body>
</html>