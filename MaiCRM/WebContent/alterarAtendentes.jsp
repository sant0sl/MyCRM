<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Atendentes e Supervisores - MyCRM</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<body>
<h1 align="center"> Atendentes e Supervisores </h1>
<br>
<h4 align="center"> Preencha o formulário a seguir para alterar o(a) Atendente ou o(a) Supervisor(a) </h4>
<p>
<hr>
<p>
<form align="center" action="/MaiCRM/alterarAtendentes" method="post">
<fieldset>
<p>
ID: <input type="text" value="${atendenteObjeto.id}" id="id" name="id" readonly="readonly">
<p>
Nome: <input type="text" id="nome" name="nome" maxlength="50" value="${atendenteObjeto.nome}">
<p>
CPF: <input type="text" id="cpf" name="cpf" maxlength="11" value="${atendenteObjeto.cpf}">
<p>
Senha: <input type="text" id="senha" name="senha" maxlength="50" value="${atendenteObjeto.senha}">
<p>
Supervisor:
<select id="supervisor" name="supervisor">
<option value="0">Não</option>
<option value="1">Sim</option>
</select>
</fieldset>
<p>
<button type="reset" class="btn btn-warning"> Limpar </button>
<button type="submit" class="btn btn-success"> Alterar </button>
</form>
</body>
</html>