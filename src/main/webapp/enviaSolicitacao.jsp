    
<%-- 
    Document   : enviaSolicitacao
    Created on : 13/10/2018, 12:14:05
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
        <form class="form-horizontal" method="post" role="form" action="FrontController?action=EnviaSolicitacao">
           <fieldset>

            <!-- Form Name -->
            <legend>Formulário de envio de solicitações</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="grupos">Nome do grupo: </label>  
              <div class="col-md-6">
                  <input list="listGrupos" name="grupos" class="form-control input-md">
                    <datalist id="listGrupos">
                        <c:forEach var="grupos" items="${listaGrupos}">
                            <option value=${grupos.getNome()}>
                        </c:forEach>
                    </datalist>
              </div>
            </div>
            
            <div class="form-group">
                <label class="col-md-4 control-label" for="usersInt">Usuário Interno: </label>
                <div class="col-md-6">
                    <input list="listUsuario" name="usersInt" class="form-control input-md">
                    <datalist id="listUsuario">
                        <c:forEach var="usuarios" items="${listaUsuarios}">
                            <option value=${usuarios.getNome()}>
                        </c:forEach>
                    </datalist>
                </div>
             </div>
             
            <div class="form-group">
              <label class="col-md-4 control-label" for="userEx">Usuário Externo : </label>  
              <div class="col-md-6">
                  <input id="txtcodigo_produto_id" name="nomeUserEx" type="mail" placeholder="Nome" class="form-control input-md">
                  <input id="txtcodigo_produto_id" name="emailUserEx" type="mail" placeholder="E-mail" class="form-control input-md">
              </div>
            </div>
            
            <!-- Button (Double) -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="btnEnviar"></label>
              <div class="col-md-8">
                <button type="submit" id="btnsalvar" name="btnEnviar" class="btn btn-primary">Enviar</button>                 
              </div>
            </div>
            </fieldset>
            </form>
            <a href="meusGrupos.jsp"><button id="btncancelar" name="btncancelar" class="btn btn-danger">Cancelar</button></a>
            
    </div>
        <%@include file="jspf/footer.jspf" %>
        


