<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerenciar Servi�os - MyCRM</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<h1 align="center"> Servi�os </h1>
<br>
<h4 align="center"> Preencha o formul�rio a seguir para cadastrar um novo Servi�o </h4>
<p>
<hr>
<p>
<form align="center" action="/MaiCRM/gerenciarServicos" method="post">
<fieldset>
<p>
Nome: <input type="text" id="nome" name="nome" maxlength="50" placeholder="Nome do servi�o">
<p>
</fieldset>
<button type="reset" class="btn btn-warning"> Limpar </button>
<button type="submit" class="btn btn-success"> Cadastrar </button>
</form>
<p>
<p>
<hr>
<p>
<h4 align="center"> Servi�os cadastrados: </h4>
<p>
<c:choose>
	<c:when test="${not empty listaservicos}">
		<table align="center">
			<tr>
				<th>| ID</th>
				<th>| Nome</th>
			</tr>
			<c:forEach var="lista" items="${listaservicos}">
				<tr>
					<td>| ${lista.id}</td>
					<td>| ${lista.nome_servico}</td>
					<td>| <a href="/MaiCRM/alterarServicos?id=${lista.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	N�o h� registros da base de dados.
	</c:otherwise>
</c:choose>
</body>
</html>