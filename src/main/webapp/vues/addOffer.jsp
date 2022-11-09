<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add offer</title>
  <link href="/css/style.css" rel="stylesheet"  type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" crossorigin="anonymous">
<style>
   .badge-dark {
     padding: 8px;
     border-radius: 10px;
     color: white;
     background-color: #0d6efd;
   }
   body {
     background: #D8DBE2;
   }
 </style>
</head>
<body>
<%@include file="navbar.jsp" %>
<br>
<div class=container>
<div class="card m-5 p-2">
 <div class="card-header"><h2>Add offer</h2></div>
<div class="card-body">
<form action="/dashboard/offers/saveOffer" method=post>

 <div class="mb-3 mt-3">
    <label for="title" class="form-label">Title:</label>
    <input type=text class="form-control" id="title" name="title" value="${offer.title}">
 </div>
 <div class="mb-3">
    <label for="description" class="form-label">description:</label>
    <input type="text" class="form-control" id="description" name="description" value="${offer.description}">
</div>
 <div class="mb-3">
    <label for="nbPost" class="form-label">NbPost:</label>
    <input type=number class="form-control" id="nbPost" name="nbPost" value="${offer.nbPost}">
 </div>
 <div class="mb-3">
    <label for="experience" class="form-label">Experience:</label>
    <input type="text" class="form-control" id="experience" name="experience" value="${offer.experience}">
 </div>
 <div class="mb-3">
    <label for="langue" class="form-label">Langue:</label>
    <input type="text" class="form-control" id="langue" name="langue" value="${offer.langue}">
 </div>
 
   <div class="mb-3">
    <label for="studyLevel" class="form-label">StudyLevel:</label>
    <input type="text" class="form-control" id="studyLevel" name="studyLevel" value="${offer.studyLevel}">
 </div>

 
 
 <div class="mb-3">
    <label for="companys" class="form-label">Company:</label>
    <select name="companys" id="companys" >
    <option selected hidden>Choose here</option>
        <c:forEach items="${companys}" var="cc">
        <option value=${cc.id} >${cc.name} </option>
        </c:forEach>
    </select>
 </div>
 <div class="mb-3">
    <label for="speciality" class="form-label">Speciality:</label>
    <select name="speciality" id="speciality" >
    <option selected hidden>Choose here</option>
        <c:forEach items="${speciality}" var="cc">
        <option value=${cc.id} <c:if test="${offer.speciality.id==cc.id}">selected="true"</c:if> >${cc.name} </option>
        </c:forEach>
    </select>
 </div>
 
 

 
 <button type="submit" class="btn btn-primary" >Add offer</button>
</form></div> </div></div>
</body>
</html>