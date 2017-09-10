<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Início - MyCRM - Seja bem vindo!!</title>
</head>
<body>
<h1 align="center"> MyCRM </h1>
<h4 align="center"> Atendente: ${atendente.nome} </h4>
<h4 align="center"> CPF: ${atendente.cpf} </h4>
<form action="/MaiCRM/logoutLoginCRM" method="post">
	<center><button type="submit" class="btn btn-primary">Sair</button></center>
</form>
<hr>
<br>
<br>
<center><a align="center" href=#> Cadastrar novo Cliente </a></center>
<p>
<center><a align="center" href=#> Cadastrar novo(a) Atendente </a></center>
<p>
<center><a align="center" href=#> Cadastrar novo Produto </a></center>
<p>
<center><a align="center" href=#> Cadastrar novo Serviço </a></center>
<p>
<center><a align="center" href=#> Cadastrar nova Manutenção </a></center>
<p>
<br>
<hr>
<p>
<h3 align="center"> Lista de Manutenções cadastradas </h3>
<p>
<c:choose>
	<c:when test="${not empty listamanutencao}">
		<table align="center">
			<tr>
				<th>ID</th>
				<th>Atendente</th>
				<th>Cliente</th>
				<th>Data</th>
				<th>Produto</th>
				<th>Serviço</th>
				<th>Status</th>
			</tr>
			<c:forEach var="lista" items="${listamanutencao}">
				<tr>
					<td>${lista.id}</td>
					<td>${lista.atendente}</td>
					<td>${lista.cliente}</td>
					<td>${lista.data}</td>
					<td>${lista.produto}</td>
					<td>${lista.servico}</td>
					<td>${lista.status}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	Não há registros da base de dados.
	</c:otherwise>
</c:choose>
</body>
</html>