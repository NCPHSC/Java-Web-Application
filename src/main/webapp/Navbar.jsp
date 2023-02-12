<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Navbar</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="StudentController?action=student" style="color:white">Student Web</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       
      </ul>
      <div class="m-2"style="color:white">Hello,${username }
       <button class="btn bg-danger" style="color:white" type="submit" onclick="window.location.href='LogoutController?action=logout'">Log Out</button>

      </div>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-info bg-primary" style="color:white" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</body>
</html>