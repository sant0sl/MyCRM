<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Manutenção - MyCRM</title>
</head>
<body>
<h1 align="center"> Serviço de Manutenção </h1>
<p>
<h3 align="center"> Preencha o formulário para registrar uma manutenção </h3>
<hr>
<p>
<form align="center" action="/MaiCRM/cadastrarManutencao" method="post">
<fieldset>
<legend> Formulário </legend>
<p>
Produto: 
<select id="produto_id" name="produto_id">
<c:forEach var="prod" items="${produto}">
<option value="${prod.id}">${prod.nome_produto}</option>
</c:forEach>
</select>
<p>
Serviço:
<select id="servico_id" name="servico_id">
<c:forEach var="serv" items="${servico}">
<option value="${serv.id}">${serv.nome_servico}</option>
</c:forEach>
</select>
<p>
Status: 
<select id="status" name="status">
<option value="0">Agendado</option>
<option value="1">Realizado</option>
<option value="2">Cancelado</option>
</select>
<p>
CPF do Atendente: <input type="text" id="atendente_cpf" name="atendente_cpf" placeholder="Apenas números">
<p>
CPF do Cliente: <input type="text" id="cliente_cpf" name="cliente_cpf" placeholder="Apenas números">
<p>
Data de Hoje: <input type="text" id="data" name="data" placeholder="Ex:00/00/0000"> 
<br><br>OBS:Preencher incluindo "/"
<p>
</fieldset>
<p>
<button type="reset"> Limpar </button>
<button type="submit"> Salvar </button>
</form>
</body>
</html>