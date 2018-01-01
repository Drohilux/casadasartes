<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu Perfil</title>
<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script></head>
<body>
<nav class="navbar navbar-light bg-light" style"display: block;">
  <a class="navbar-brand" href="#">
    <img src="C:\Users\Alana\Desktop\Infnet\Projetos Eclipse\AssessmentBloco\logo_casadasartes.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
    Casa Das Artes
  </a>
  <div class="form-inline">
  	<a class="btn btn-primary my-2 my-sm-0" href="ExibicaoController">Home</a>
  	<a class="btn btn-primary my-2 my-sm-0" href="EditarController">Editar</a>
    <a class="btn btn-danger my-2 my-sm-0" href="LoginController">Sair</a>
  </div>
   
  	<table class="table">
  <thead>  
    <tr>      
      <th scope="col">Nome</th>
      <th scope="col">Email</th>
      <th scope="col">Login</th>      
    </tr>
  </thead>
  <tbody>
    <tr>
      <td scope="row">${cliente.getNome()}</td>
      <td>${cliente.getEmail()}</td>
      <td>${cliente.getLogin()}</td>
    </tr></tbody>
</body>
</html>