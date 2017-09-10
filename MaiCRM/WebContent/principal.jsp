<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Início - MyCRM</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<h1 align="center"> Bem vindo ao MyCRM </h1>
<h3 align="center"> Customer Relationship Manager </h3>
<form action="/MaiCRM/logoutLoginCRM" method="post" class="form-horizontal">
	<center><button type="submit" class="btn btn-danger">Sair</button></center>
</form>
<hr>
<br>
<center><form action="/MaiCRM/gerenciarAtendentes" method="get">
<button type="submit" class="btn btn-primary"> Gerenciar Atendente e Supervisores </button>
</form></center>
<p>
<center><form action="/MaiCRM/gerenciarClientes" method="get">
<button type="submit" class="btn btn-primary"> Gerenciar Clientes </button>
</form></center>
<p>
<center><form action="/MaiCRM/gerenciarProdutos" method="get">
<button type="submit" class="btn btn-primary"> Gerenciar Produtos </button>
</form></center>
<p>
<center><form action="/MaiCRM/gerenciarServicos" method="get">
<button type="submit" class="btn btn-primary"> Gerenciar Serviços </button>
</form></center>
<p>
<center><form action="/MaiCRM/cadastrarManutencao" method="get">
<button type="submit" class="btn btn-primary"> Cadastrar nova Manutenção </button>
</form></center>
<p>
<br>
<hr>
<p>
<h3 align="center"><a href="/MaiCRM/filtrarManutencoes"> Lista de Manutenções cadastradas </a></h3>
<p>
<form align="center" action="/MaiCRM/filtrarNomeCliente" method="post">
Nome do Cliente: <input type="text" id="nome_cliente" name="nome_cliente" maxlength="50" placeholder="Ex:Leonardo S">
<button type="submit">Filtrar</button>
</form>
<p>
<form align="center" action="/MaiCRM/filtrarData" method="post">
<fieldset>
Data:
<input type="text" id="data_filtro" name="data_filtro" maxlength="10" placeholder="Ex:09/09/2017">
<button type="submit">Filtrar</button> 
<p> OBS:Preencher com "/"
</fieldset>
</form>
<p>
<form align="center" action="/MaiCRM/filtrarStatus" method="post">
<fieldset>
Status:
<select id="status_filtro" name="status_filtro">
<option value="0">Agendado</option>
<option value="1">Realizado</option>
<option value="2">Cancelado</option>
</select>
<button type="submit">Filtrar</button>
</fieldset>
</form>
<p>
<hr>
<p>
<c:choose>
	<c:when test="${not empty listamanutencao}">
		<table align="center">
			<tr>
				<th>| ID</th>
				<th>| Atendente</th>
				<th>| Cliente</th>
				<th>| Data</th>
				<th>| Produto</th>
				<th>| Serviço</th>
				<th>| Status</th>
			</tr>
			<c:forEach var="lista" items="${listamanutencao}">
				<tr>
					<td>| ${lista.id}</td>
					<td>| ${lista.atendente}</td>
					<td>| ${lista.cliente}</td>
					<td>| ${lista.data}</td>
					<td>| ${lista.produto}</td>
					<td>| ${lista.servico}</td>
					<td>| ${lista.status}</td>
					<td>| <a href="/MaiCRM/alterarManutencao?id=${lista.id}">Editar</a></td>
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