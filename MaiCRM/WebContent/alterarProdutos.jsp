<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Alterar Produtos - MyCRM</title>
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
<div><h4 align="center"> Preencha o formulário a seguir para alterar o Produto </h4></div>
<p>
<hr>
<p>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<form action="/MaiCRM/alterarProdutos" method="post">
				<div class="form-group">
					<label>ID:</label>
					<input type="text" class="form-control" value="${produtoObjeto.id}" id="id" name="id" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="nome">Nome:</label>
					<input type="text" class="form-control" id="nome" name="nome" maxlength="50" value="${produtoObjeto.nome_produto}">
				</div>
				<div align="center" id="actions">
					<button type="reset" class="btn btn-default"> Limpar </button>
					<button type="submit" class="btn btn-success"> Alterar </button>					
				</div>
			</form>
		</div>
		<div class="col-sm-4"></div>
	</div>

</main>
<c:import url="/inc/footer.jsp"/>
</body>
</html>