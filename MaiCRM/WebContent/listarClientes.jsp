<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerenciar Clientes - MyCRM</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<body>
<h1 align="center"> Clientes </h1>
<br>
<h4 align="center"> Preencha o formulário a seguir para cadastrar um novo Cliente </h4>
<p>
<hr>
<p>
<form align="center" action="/MaiCRM/gerenciarClientes" method="post">
<fieldset>
<p>
Nome: <input type="text" id="nome" name="nome" maxlength="50" placeholder="Nome do cliente">
<p>
CPF: <input type="text" id="cpf" name="cpf" maxlength="11" placeholder="CPF do cliente">
<p>
</fieldset>
<button type="reset" class="btn btn-warning"> Limpar </button>
<button type="submit" class="btn btn-success"> Cadastrar </button>
</form>
<p>
<p>
<hr>
<p>
<h4 align="center"> Clientes cadastrados: </h4>
<p>
<c:choose>
	<c:when test="${not empty listaclientes}">
		<table align="center">
			<tr>
				<th>| ID</th>
				<th>| Nome</th>
				<th>| CPF</th>
			</tr>
			<c:forEach var="lista" items="${listaclientes}">
				<tr>
					<td>| ${lista.id}</td>
					<td>| ${lista.nome}</td>
					<td>| ${lista.cpf}</td>
					<td>| <a href="/MaiCRM/alterarClientes?id=${lista.id}">Editar</a></td>
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