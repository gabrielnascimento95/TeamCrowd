<%-- 
    Document   : statusSolicitacao
    Created on : 07/10/2018, 13:07:54
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/header.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Solicitações</title>
    </head>
    <body>
        <%@include file="jspf/nav.jspf" %>
        <div class="container">
        <h2>Solicitações</h2>
        <p>Acompanhe o status de solicitações de adesão à grupos de desenvolvimento.</p>
        <div class="panel-group">
          <div class="panel panel-default">
            <div class="panel-heading">Grupo 1</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-6"><h4>Nome: José</h4></div>
                    <div class="col-sm-6">Status: Aguardando</div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><h4>Nome: Maria</h4></div>
                    <div class="col-sm-6">Status: Aguardando</div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><h4>Nome: Max</h4></div>
                    <div class="col-sm-6">Status: Aguardando</div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><h4>Nome: Márcia</h4></div>
                    <div class="col-sm-6">Status: Aguardando</div>
                </div>
           </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Grupo 2</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-6"><h4>Nome: José</h4></div>
                    <div class="col-sm-6">Status: Aguardando</div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><h4>Nome: Maria</h4></div>
                    <div class="col-sm-6">Status: Aguardando</div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><h4>Nome: Max</h4></div>
                    <div class="col-sm-6">Status: Aguardando</div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><h4>Nome: Márcia</h4></div>
                    <div class="col-sm-6">Status: Aguardando</div>
                </div>
           </div>
        </div>    
      </div>
        <%@include file="jspf/footer.jspf" %>
   