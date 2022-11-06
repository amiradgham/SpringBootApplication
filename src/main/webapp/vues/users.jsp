<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet"  type="text/css">
<meta charset="ISO-8859-1">
<title>Users </title>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="page-margin">
<div class="container">
<table class="table table-striped">
 <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">picture</th>
      <th scope="col">title</th>
      <th scope="col">description</th>
      <th scope="col">nbPost</th>
      <th scope="col">experience</th>
      <th scope="col">studyLevel</th>
      <th scope="col">company</th>
      <th scope="col">speciality</th>
      <th scope="col">expirationDate</th>
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${allOffers}" var="p" >
    <tr>
      <th scope="row">${p.id}</th>
           <td><img src="http://127.0.0.1:8083/api/offer/getImage/${p.id}" width="40" height="40"></td>
           <td>${p.title}</td>
           <td>${p.description}</td>
           <td>${p.nbPost}</td>
           <td>${p.experience}</td>
           <td>${p.studyLevel}</td>
           <td>${p.company.name}</td>
           <td>${p.speciality.name}</td>
           <td>${p.expirationDate}</td>
 
           <td>
           	<a href="/dashboard/offers/deleteOffer/${p.id}" class="btn btn-danger">
      		<span class="fa fa-trash"></span>
      	</a>
      	<a href="/dashboard/offers/editOffer/${p.id}" class="btn btn-warning">
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