<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login Casa do Código</title>

	<link rel="stylesheet" href="${contextPath}/casadocodigo/resources/css/bootstrap.min.css"
		integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<script src="${contextPath}/casadocodigo/resources/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
	</script>

    <style>
        body{
            padding-top:70px;
            padding-bottom:15px;
        }
    </style>
</head>

<body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="${s:mvcUrl('HC#index').build()}">Home </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${s:mvcUrl('listar').build()}">Lista Produtos<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="${s:mvcUrl('PC#form').build()}" tabindex="-1">Cria Produto</a>
        </li>
        </ul>
    </div>
    </nav>

    <div class="container">
    <h1>Cadastro de Produto</h1>

	<form:form servletRelativeAction="/login" method="POST">
		<div class="form-group">
			<label>Email</label>
			<input name="username" type="text" class="form-control" />
			<form:errors path="username" />
		</div>
		<div class="form-group">
			<label>Senha</label>
			<input type="password" name="password" class="form-control"/>
			<form:errors path="descricao" />
		</div>

        <button type="submit" class="btn btn-primary">Login</button>
	</form:form>
</body>
</div>

</html>