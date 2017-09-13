<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Início - MyCRM</title>
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
<h3 align="center"> Filtrar Manutenções </h3>
<br>
	<div class="row">
	<div class="col-sm-4">
		<form action="/MaiCRM/filtrarNomeCliente" method="post">
		<div class="form-group">
			<label for="nome_cliente">Nome do Cliente:</label>
			<input type="text" class="form-control" id="nome_cliente" name="nome_cliente" maxlength="50" placeholder="Ex:Leonardo S">
		</div>
		<div align="center" id="actions">
			<button type="submit" class="btn btn-primary">Filtrar</button>
		</div>
	</form>
	</div>
	<div class="col-sm-4">
		<form action="/MaiCRM/filtrarData" method="post">
		<div class="form-group">
			<label>Data:</label>
			<input type="date" class="form-control" id="data_filtro" name="data_filtro" maxlength="10" placeholder="Ex:09/09/2017">
		</div>
		<div align="center" id="actions">
			<button type="submit" class="btn btn-primary">Filtrar</button>
		</div>
	</form>
	</div>
	<div class="col-sm-4">
		<form action="/MaiCRM/filtrarStatus" method="post">
		<div class="form-group">
			<label for="status_filtro">Status:</label>
			<select class="form-control" id="status_filtro" name="status_filtro">
				<option value="0">Agendado</option>
				<option value="1">Realizado</option>
				<option value="2">Cancelado</option>
			</select>
		</div>
		<div align="center" id="actions">
			<button type="submit" class="btn btn-primary">Filtrar</button>
		</div>
	</form>
	</div>
	</div>
<p>
<hr>
<h3 align="center"><a href="/MaiCRM/filtrarManutencoes"> Lista de Manutenções cadastradas </a></h3>
<br>
<p>
<c:choose>
	<c:when test="${not empty listamanutencao}">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Atendente</th>
				<th>Cliente</th>
				<th>Data(ano/mês/dia)</th>
				<th>Produto</th>
				<th>Serviço</th>
				<th>Status</th>
			</tr>
		</thead>
			<c:forEach var="lista" items="${listamanutencao}">
				<tr>
					<td>${lista.id}</td>
					<td>${lista.atendente}</td>
					<td>${lista.cliente}</td>
					<td>${lista.data}</td>
					<td>${lista.produto}</td>
					<td>${lista.servico}</td>
					<td>${lista.status}</td>
					<td><a href="/MaiCRM/alterarManutencao?id=${lista.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	<br>           
   		<div class="alert alert-info">
        Não há registros da base de dados.
        </div>
	</c:otherwise>
</c:choose>
</main>
<c:import url="/inc/footer.jsp"/>
</body>
</html>