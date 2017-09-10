<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Produtos - MyCRM</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<body>
<h1 align="center"> Produtos </h1>
<br>
<h4 align="center"> Preencha o formulário a seguir para alterar o Produto </h4>
<p>
<hr>
<p>
<form align="center" action="/MaiCRM/alterarProdutos" method="post">
<fieldset>
ID do Produto:
<input type="text" value="${produtoObjeto.id}" id="id" name="id" readonly="readonly">
<p>
<p>
Nome: <input type="text" id="nome" name="nome" maxlength="50" value="${produtoObjeto.nome_produto}">
<p>
</fieldset>
<button type="reset" class="btn btn-warning"> Limpar </button>
<button type="submit" class="btn btn-success"> Alterar </button>
</form>
</body>
</html>