<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Gerenciar Produtos - MyCRM</title>
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
<div><h1 align="center"> Produtos </h1></div>
<br>
<div><h4 align="center"> Preencha o formulário a seguir para cadastrar um novo Produto </h4></div>
<p>
<hr>
<p>
	<form align="center" action="/MaiCRM/gerenciarProdutos" method="post">
		<div class="form-group">
			<label for="nome">Nome:</label>
			<input type="text" class="form-control" id="nome" name="nome" maxlength="50" placeholder="Nome do produto">
		</div>
		<div id="actions">
			<button type="reset" class="btn btn-default"> Limpar </button>
			<button type="submit" class="btn btn-success"> Cadastrar </button>
		</div>
	</form>
<p>
<hr>
<p>
<div><h4 align="center"> Produtos cadastrados: </h4></div>
<p>
<c:choose>
	<c:when test="${not empty listaprodutos}">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Alterar</th>
			</tr>
		</thead>
			<c:forEach var="lista" items="${listaprodutos}">
				<tr>
					<td>${lista.id}</td>
					<td>${lista.nome_produto}</td>
					<td><a href="/MaiCRM/alterarProdutos?id=${lista.id}">Editar</a></td>
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