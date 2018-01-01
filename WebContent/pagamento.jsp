<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamento</title>
<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="C:\Users\Alana\Desktop\Infnet\Projetos Eclipse\AssessmentBloco\logo_casadasartes.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
    Casa Das Artes
  </a>
  <div class="form-inline">
  <a class="btn btn-primary my-2 my-sm-0" href="ExibicaoController">Home</a>
  <a class="btn btn-primary my-2 my-sm-0" href="PerfilController">Meu Perfil</a>
  	<a class="btn btn-danger my-2 my-sm-0" href="LoginController">Sair</a>
  </div>
</nav>

	<c:forEach items="${pecas}" var="peca">
	
	<div class="card" style="width: 20rem;">
  <div class="card-body">
    <h4 class="card-title">${peca.getTitulo()}</h4>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">${peca.getData()}</li>
    <li class="list-group-item">${peca.getHorario()}</li>
    </c:forEach>
    
    <li class="list-group-item"><select class="form-control form-control-sm">
  <option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
</select></li>
	<li class="list-group-item">Atualiza Total</li>
  </ul>  
</div>

	<form action="PagamentoController" method="post">
	<div class="form-group">
    <label for="inputAddress2">Nome no Cartão</label>
    <input type="text" class="form-control" id="nomeCartao" name="nomeCartao" required>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="numerocartao">Numero</label>
      <input type="number" class="form-control" id="numero" name="numero" required>
    </div>
    <div class="form-group col-md-4">
      <label for="validade">Validade</label>
      <input type="text" class="form-control" id="validade" name="validade" required>
    </div>
    <div class="form-group col-md-2">
      <label for="cvc">CVC</label>
      <input type="numer" class="form-control" id="cvc" name="cvc" required>
    </div>
  </div>
  <div class="form-group">
    <div class="form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" id="salvarcartao" name="salvarcartao"> Salvar Cartão
      </label>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Confirmar Compra</button>
</form>

</body>
</html>