<%-- 
    Document   : criaGrupo
    Created on : 07/10/2018, 19:15:40
    Author     : gabriel
--%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<%@include file="jspf/header.jspf" %>
<style type="text/css">
            .card {
                box-shadow: 0 4px 8px 0 rgba(1,0,0,0.2);
                transition: 0.3s;
                width: 30%;
                border-radius: 10px;
            }

            .card:hover {
                box-shadow: 0 8px 16px 0 rgba(1,0,0,0.2);
            }

            .container {
                padding: 2px 16px;
            }
            
            #imagemborda{
                
                border-radius:100px;
            }   
             
              
            
        </style>
<title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="jspf/nav.jspf" %>
    <div class="row">
        <div class = "col"></div>
        <div class = "col"><center><h1>Team Crowd</h1></center><br/>
            <center><img src="imagens\crowedsource.jpg" id="imagemborda" alt="CrowdSourcing" align=center height="150"/></center></div>
        <div class = "col"></div>
    </div>
    <div>
        <form class="form-horizontal" method="post" role="form" action="FrontController?action=CadastroGrupo">
           <fieldset>

            <!-- Form Name -->
            <legend>Formulário de criação de grupo</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="nomeUsuario">Nome do grupo: </label>  
              <div class="col-md-6">
              <input id="txtcodigo_produto_id" name="nomeUsuario" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>
            
            <div class="form-group">
                <label class="col-md-4 control-label" for="descricao">Contexto do grupo: </label>
                <div class="col-md-6">
                    <input list="contexts" name="browser" class="form-control input-md">
                    <datalist id="contexts">
                        <option value="Desenvolvimento Web Java EE">
                        <option value="Desenvolvimento Web PHP">
                        <option value="Desenvolvimento Mobile Android">
                        <option value="Desenvolvimento Mobile Apple">
                        <option value="Desenvolvimento ASP.NET">
                    </datalist>
                </div>
             </div>
                     
            <div class="form-group">
              <label class="col-md-4 control-label" for="descricao">Descrição : </label>  
              <div class="col-md-6">
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
              </div>
            </div>
            
            <!-- Button (Double) -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="btnsalvar"></label>
              <div class="col-md-8">
                <button type="submit" id="btnsalvar" name="btnsalvar" class="btn btn-primary">Salvar</button>                 
              </div>
            </div>
            </fieldset>
            </form>
            <a href="meusGrupos.jsp"><button id="btncancelar" name="btncancelar" class="btn btn-danger">Cancelar</button></a>
            
    </div>
        <%@include file="jspf/footer.jspf" %>