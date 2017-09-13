<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Alteração de Manutenção - MyCRM</title>
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
<div><h1 align="center"> Serviço de Manutenção </h1></div>
<p>
<div><h3 align="center"> Preencha o formulário para alterar a manutenção </h3></div>
<hr>
<p>
	<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		<form action="/MaiCRM/alterarManutencao" method="post">		
			<div class="form-group">
				<label>ID:</label>
				<input type="text" class="form-control" value="${manutencaoObjeto.id}" id="id" name="id" readonly="readonly">
			</div>
			<div class="form-group">
				<label>Produto:</label>
				<select class="form-control" value="${manutencaoObjeto.produto_id}" id="produto_id" name="produto_id">
				<c:forEach var="prod" items="${produto}">
				<option value="${prod.id}">${prod.nome_produto}</option>
				</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Serviço:</label>
				<select class="form-control" value="${manutencaoObjeto.servico_id}" id="servico_id" name="servico_id">
				<c:forEach var="serv" items="${servico}">
				<option value="${serv.id}">${serv.nome_servico}</option>
				</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Status</label>
				<select class="form-control" value="${manutencaoObjeto.status}" id="status" name="status">
				<option value="0">Agendado</option>
				<option value="1">Realizado</option>
				<option value="2">Cancelado</option>
				</select>
			</div>
				<div class="form-group">
	 			<label>CPF do Atendente:</label>
				<select class="form-control" value="${manutencaoObjeto.atendente_cpf}" id="atendente_cpf" name="atendente_cpf">
				<c:forEach var="aten" items="${atendente}">
				<option value="${aten.cpf}">${aten.nome}</option>
				</c:forEach>
				</select>
	 		</div>
			<div class="form-group">
				<label>CPF do Cliente:</label>
				<select class="form-control" value="${manutencaoObjeto.cliente_cpf}" id="cliente_cpf" name="cliente_cpf">
				<c:forEach var="cli" items="${cliente}">
				<option value="${cli.cpf}">${cli.nome}</option>
				</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="data">Data:</label>
				<input type="date" class="form-control" value="${manutencaoObjeto.data}" id="data" name="data" maxlength="10">
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