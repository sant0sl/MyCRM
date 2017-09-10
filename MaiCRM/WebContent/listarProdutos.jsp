<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerenciar Produtos - MyCRM</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<h1 align="center"> Produtos </h1>
<br>
<h4 align="center"> Preencha o formulário a seguir para cadastrar um novo Produto </h4>
<p>
<hr>
<p>
<form align="center" action="/MaiCRM/gerenciarProdutos" method="post">
<fieldset>
<p>
Nome: <input type="text" id="nome" name="nome" maxlength="50" placeholder="Nome do produto">
<p>
</fieldset>
<button type="reset" class="btn btn-warning"> Limpar </button>
<button type="submit" class="btn btn-success"> Cadastrar </button>
</form>
<p>
<p>
<hr>
<p>
<h4 align="center"> Produtos cadastrados: </h4>
<p>
<c:choose>
	<c:when test="${not empty listaprodutos}">
		<table align="center">
			<tr>
				<th>| ID</th>
				<th>| Nome</th>
			</tr>
			<c:forEach var="lista" items="${listaprodutos}">
				<tr>
					<td>| ${lista.id}</td>
					<td>| ${lista.nome_produto}</td>
					<td>| <a href="/MaiCRM/alterarProdutos?id=${lista.id}">Editar</a></td>
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