<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOK API</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<h1>New Product</h1>
	<form:form action="/products/new" method="post" modelAttribute="producto">
			<div class="form-group">
		        <form:label path="name">Name</form:label><br>
				<form:errors class="text-danger" path="name" />
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="description">Description</form:label>
		        <form:input class="form-control" path="description"/>
		    </div>
		    <div class="form-group">
		        <form:label path="price">Price</form:label><br>
		    	<form:errors class="text-danger" path="price" />
		        <form:input type="number" class="form-control" path="price"/>
		    </div>
		    <button>Agregar nuevo producto</button>
		</form:form>
</body>
</html>