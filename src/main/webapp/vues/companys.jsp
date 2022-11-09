<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet"  type="text/css">
<meta charset="ISO-8859-1">
<title>Companys </title>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="page-margin">
<div class="container">
<table class="table table-striped">
 <thead>
    <tr>
      <th scope="col">id</th>

      <th scope="col">name</th>
      <th scope="col">description</th>
      <th scope="col">nbEmp</th>
      <th scope="col">workField</th>
      <th scope="col">creation date</th>
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${allCompanys}" var="p" >
    <tr>
      <th scope="row">${p.id}</th>
           <td>${p.name}</td>
           <td>${p.description}</td>
           <td>${p.nbEmp}</td>
           <td>${p.workField}</td>
           <td>${p.creationDate}</td>
 
           <td>
           	<a href="/dashboard/companys/deleteCompany/${p.id}" class="btn btn-danger">
      		<span class="fa fa-trash"></span>
      	</a>
      	<a href="/dashboard/companys/editCompany/${p.id}" class="btn btn-warning">
      		<span class="fa fa-edit"></span>
      	</a></td>
     
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
</div>
</body>
</html>