<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.google.appengine.api.datastore.Query"%>
<%@page import="com.google.appengine.api.datastore.*"%>
<%@page import="com.google.appengine.api.datastore.Query.FilterPredicate"%>
<%@page import="com.google.appengine.api.datastore.Query.Filter"%>
<%@page import="com.google.appengine.api.datastore.Query.SortDirection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Administrator Log In</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
		background-size: cover; 
	background-repeat: no-repeat;
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
	background-image: url('http://cdn.pcwallart.com/images/empire-state-building-view-at-night-wallpaper-3.jpg');
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
</style>
 
</head>
<body>

<nav>
<a href="Homepage.html">HOME</a>

<a href="CustomerProductTable.jsp">PRODUCTS</a>
<a href="CustomerServiceDeskTable.jsp">SERVICEDESK</a>

</nav>

<% 
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("TransactionTable");
       q.addSort("transactionid",SortDirection.ASCENDING);
       PreparedQuery pq = ds.prepare(q);         
 %>

<div class="container-fluid sect sectOne ">
<br><br><br>
  <h3><strong><b>CUSTOMER LOG IN</b></strong></h3>
  <br>
  <form class="form-horizontal" role="form" method="post" action="customerdetails">
    <div class="form-group">
      <label class="control-label col-sm-2 white" for="text">Name </label>
      <div class="col-sm-3">
        <input type="text" class="form-control" name="Cname"  placeholder="Enter Name" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2 white" for="text">Mobile No.</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" name="Cmobile" placeholder="Enter mobile no." required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2 white" for="text">Email Id</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" name="Cemail" placeholder="Enter email Id" required>
      </div>
    </div>
    <div class="dropdown">
     <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Transaction Id</button>
          <ul class="dropdown-menu">
          <% for(Entity result: pq.asIterable()){%>
                <li><%= result.getProperty("transactionid") %></li>       
                <% } %>  
           </ul>
  </div>
</div>
        <input type="text" class="form-control" name="Ctransid" placeholder="Enter Transaction Id" required>
      </div>
       <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success">Submit</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>