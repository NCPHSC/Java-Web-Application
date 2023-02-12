<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
</head>
<body>
<h3 style="margin-left:45%;margin-top:100px;">Student Form</h3>

<form action="AddStudentController" method="post"
	class="row g-3 container" style="margin:auto;border:1px solid orange; width:60%">
	<input type="hidden" name="id" value="${student.ID}">
  <div class="col-md-6">
    <label class="form-label">First Name</label>
    <input type="text" name="username" class="form-control" value="${student.name}" id="username">
  </div>
  <div class="col-md-6">
    <label class="form-label">Last Name</label>
    <input type="text" name="lastname" value="${student.lastname}" class="form-control">
  </div>
    <div class="col-md-4">
    <label class="form-label">Date of Birth</label>
    <input type="date" name="dob" value="${student.date_of_birth}" class="form-control">
  </div>  <div class="col-md-4">
    <label for="inputState" class="form-label">Gender</label>
    <select id="inputState" name="gender" class="form-select">
      <option selected>Choose...</option>
      <option value="${student.gender == 'Male'? 'selected' : ''}">Male</option>
      <option value="${student.gender == 'Female'? 'selected' : ''}">Female</option>
      <option value="${student.gender == 'Others'? 'selected' : ''}">Others</option>
      <optgroup label=""></optgroup>
    </select>
  </div>
    <div class="col-md-4">
    <label class="form-label">Phone</label>
    <input type="tel" name="phone"  value="${student.phone}" class="form-control">
  </div>
  <div class="col-md-4">
    <label class="form-label">Email</label>
    <input type="email" name="email"  value="${student.email}" class="form-control">
  </div>
   <div class="col-md-4">
    <label class="form-label">Password</label>
    <input type="password" name="password"  value="${student.password}" class="form-control">
  </div>
  
   <div class="col-md-4">
    <label class="form-label">Confirm Password</label>
    <input type="password" name="cpassword"  value="${student.cpassword}" class="form-control">
  </div>
  
  
  <div class="col-12" style="margin-left:45%;">
    <button type="submit" value="submit" class="btn btn-primary">Save</button>
  </div>
</form>
</body>
</html>