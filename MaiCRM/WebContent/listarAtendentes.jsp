<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerenciar Atendentes e Supervisores - MyCRM</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<body>
<h1 align="center"> Atendentes e Supervisores </h1>
<br>
<h4 align="center"> Preencha o formulário a seguir para cadastrar um(a) novo(a) Atendente ou Supervisor(a) </h4>
<p>
<hr>
<p>
<form align="center" action="/MaiCRM/gerenciarAtendentes" method="post">
<fieldset>
<p>
Nome: <input type="text" id="nome" name="nome" maxlength="50" placeholder="Nome do atendente">
<p>
CPF: <input type="text" id="cpf" name="cpf" maxlength="11" placeholder="CPF do atendente">
<p>
Senha: <input type="text" id="senha" name="senha" maxlength="50" placeholder="Senha do atendente">
<p>
Supervisor:
<select id="supervisor" name="supervisor">
<option value="0">Não</option>
<option value="1">Sim</option>
</select>
</fieldset>
<p>
<button type="reset" class="btn btn-warning"> Limpar </button>
<button type="submit" class="btn btn-success"> Cadastrar </button>
</form>
<p>
<p>
<hr>
<p>
<h4 align="center"> Funcionários cadastrados: </h4>
<p>
<c:choose>
	<c:when test="${not empty listaatendentes}">
		<table align="center">
			<tr>
				<th>| ID</th>
				<th>| Nome</th>
				<th>| CPF</th>
				<th>| Senha</th>
				<th>| Supervisor</th>
			</tr>
			<c:forEach var="lista" items="${listaatendentes}">
				<tr>
					<td>| ${lista.id}</td>
					<td>| ${lista.nome}</td>
					<td>| ${lista.cpf}</td>
					<td>| ${lista.senha}</td>
					<td>| ${lista.supervisor}</td>
					<td>| <a href="/MaiCRM/alterarAtendentes?id=${lista.id}">Editar</a></td>
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