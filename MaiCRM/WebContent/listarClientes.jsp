<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Gerenciar Clientes - MyCRM</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
	   <style>
	        body {
	            padding-top: 50px;
	            padding-bottom: 20px;
	        }
	   </style>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.2/css/font-awesome.min.css"> 
</head>
<body>
<c:import url="/inc/header.jsp"/>
<main class="container">
<div><h1 align="center"> Clientes </h1></div>
<br>
<div><h4 align="center"> Preencha o formul�rio a seguir para cadastrar um novo Cliente </h4></div>
<p>
<hr>
<p>
	<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
			<form action="/MaiCRM/gerenciarClientes" method="post">
				<div class="form-group">
					<label for="nome">Nome:</label>
					<input type="text" class="form-control" id="nome" name="nome" maxlength="50" placeholder="Nome do cliente">
				</div>
				<div class="form-group">
					<label for="cpf">CPF:</label>
					<input type="text" class="form-control" id="cpf" name="cpf" maxlength="11" placeholder="Apenas n�meros">
				</div>
				<div align="center" id="actions">
					<button type="reset" class="btn btn-default"> Limpar </button>
					<button type="submit" class="btn btn-success"> Cadastrar </button>
				</div>
			</form>
	</div>
	<div class="col-sm-4"></div>
	</div>
<p>
<hr>
<p>
<div><h4 align="center"> Clientes cadastrados: </h4></div>
<p>
<c:choose>
	<c:when test="${not empty listaclientes}">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Alterar</th>
			</tr>
		</thead>
			<c:forEach var="lista" items="${listaclientes}">
				<tr>
					<td>${lista.id}</td>
					<td>${lista.nome}</td>
					<td>${lista.cpf}</td>
					<td><a href="/MaiCRM/alterarClientes?id=${lista.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	<br>           
   		<div class="alert alert-info">
        N�o h� registros da base de dados.
        </div>
	</c:otherwise>
</c:choose>
</main>
<c:import url="/inc/footer.jsp"/>
</body>
</html>