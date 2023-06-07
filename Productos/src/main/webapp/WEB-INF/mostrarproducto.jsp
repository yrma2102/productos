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

<a href="/"> Volver </a>
	<h1>${producto.name }</h1>

	<hr>
	<div class="container row">
		<div class="col-6">
			<h2>Categorias</h2>
			<c:forEach items="${producto.categories}" var="categoria">
				<li>${categoria.name }</li>
			</c:forEach>
		</div>
		<div class="col-6">
			<h2>Add Category:</h2>
			<form:form action="/aso/${producto.id }" method="post"
				modelAttribute="asociacion">
				<form:input type="hidden" path="product" value="${producto.id }" />
				<form:select class="form-control" path="category">
					<c:forEach items="${categorias}" var="categoria">
						<form:option value="${categoria.id} "> ${categoria.name}  
									</form:option>
					</c:forEach>
				</form:select>
				<button>Agregar</button>
			</form:form>
</body>
</html>