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
<h1>Productos y Categorias</h1>
	<a href="/products/new"> Agrega un producto </a> |
	<a href="/categories/new"> Agrega una categoria </a>
	<hr>
	<div class="container row">
		<div class="col-6">
			<h2>Tus productos son:</h2>
			<c:forEach items="${productos}" var="producto">
				<li><a href="/products/${producto.id }"> ${producto.name }</a></li>
			</c:forEach>
		</div>
		<div class="col-6">
			<h2>Tus categorias son:</h2>
			<c:forEach items="${categorias}" var="categoria">
				<li><a href="/categories/${categoria.id }"> ${categoria.name }</a></li>
			</c:forEach>
		</div>


	</div>

</body>
</html>