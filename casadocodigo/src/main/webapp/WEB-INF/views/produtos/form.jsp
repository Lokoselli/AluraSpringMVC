<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Livro de Java, Android, Iphone, Ruby, PHP e muito mais - Casa do Código </title>

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

	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" modelAttribute="produto"
		enctype="multipart/form-data">
		<div class="form-group">
			<label>Titulo</label>
			<form:input path="titulo" cssClass="form-control" />
			<form:errors path="titulo" />
		</div>
		<div class="form-group">
			<label>Descrição</label>
			<form:textarea path="descricao" cols="20" rows="10" cssClass="form-control"/>
			<form:errors path="descricao" />
		</div>
		<div class="form-group">
			<label>Paginas</label>
			<form:input path="paginas" cssClass="form-control"/>
			<form:errors path="paginas" />
		</div>

		<div class="form-group">
			<label>Data de Lancamento</label>
			<form:input path="dataLancamento" cssClass="form-control"/>
			<form:errors path="dataLancamento" />
		</div>

		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div class="form-group">
				<label>${tipoPreco}</label>
				<form:input path="precos[${status.index}].valor" cssClass="form-control"/>
				<form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" />
			</div>
		</c:forEach>

		<div class="form-group">
			<label>Sumário</label>
			<input name="sumario" type="file" class="form-control"/>
        </div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
	</form:form>
</body>
</div>

</html>