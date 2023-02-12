<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
</head>
<body>
	<h3 style="margin:auto; margin-top:240px;margin-left:45%;">Login</h3>
	<div class="card d-flex p-2 " style="border:2px solid black; width: 20rem; height:15rem; margin:auto;" >
 		<form action="LoginController" method="post">
 		<span style="color:red">${message}</span>
	       <ul style="list-style-type: none;" >
	            <li >User: </li>
	            <li>
	            	<input type="text" name="username" id="username"/>
	            </li>
	        <li>
	            <li>Password: </li>
	            <li>
	            	<input type="password" name="password" id="password"/>
	           </li>
	      <li >
	      <input type="submit" value="Submit" class="btn btn-info" style="margin-left:50px; margin-top:5px;"/>
	      </ul>
  	  </form> 
	</div>  
 
</body>
</html>