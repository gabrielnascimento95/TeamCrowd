<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<%@include file="jspf/header.jspf" %>
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
    <div class="row">
        <div class = "col"></div>
        <div class = "col"><center><h1>Team Crowd</h1></center><br/>
            <center><img src="imagens\crowedsource.jpg" id="imagemborda" alt="CrowdSourcing" align=center height="150"/></center></div>
        <div class = "col"></div>
    </div>
    <div>
        <form class="form-horizontal" method="post" role="form" action="FrontController?action=CadastroUsuario">
           <fieldset>

            <!-- Form Name -->
            <legend>Cadastro</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="nomeUsuario">Nome : </label>  
              <div class="col-md-6">
              <input id="txtcodigo_produto_id" name="nomeUsuario" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="token">Token GitHub : </label>  
              <div class="col-md-6">
              <input id="txtproduto" name="token" type="text" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="estudo">Nível : </label>
              <div class="col-md-4">
                <select id="txtgrupo" name="estudo" class="form-control">
                  <option value="1">Iniciante</option>
                  <option value="2">Junior</option>
                  <option value="3">Pleno</option>
                  <option value="4">Senior</option>
                </select>
              </div>
            </div>
            
            <div class="form-group">
              <label class="col-md-4 control-label" for="profissao">Profissão : </label>
              <div class="col-md-4">
                <select id="txtgrupo" name="profissao" class="form-control">
                  <option value="1">Estudante</option>
                  <option value="2">Professor</option>
                  <option value="3">Desenvolvedor</option>
                  <option value="4">Outros</option>
                </select>
              </div>
            </div>
            
            <div class="form-group">
              <label class="col-md-4 control-label" for="dataNasc">Data Nascimento : </label>  
              <div class="col-md-2">
              <input id="txtestoque_minimo" name="DataNasc" type="text" placeholder="Formato (DD/MM/AAAA)" class="form-control input-md" required="">

              </div>
            </div>
            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="senhaUsuario">Senha : </label>  
              <div class="col-md-2">
              <input id="txtestoque_minimo" name="senhaUsuario" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="emailUsario">Email : </label>  
              <div class="col-md-4">
              <input id="txtestoque_atual" name="emailUsario" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>
            
            <div class="form-group">
              <label class="col-md-4 control-label" for="descricao">Descrição : </label>  
              <div class="col-md-6">
              <input id="txtestoque_atual" name="descrição" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>
            
            <!-- Button (Double) -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="btnsalvar"></label>
              <div class="col-md-8">
                <button type="submit" id="btnsalvar" name="btnsalvar" class="btn btn-primary">Salvar</button>
                <button id="btncancelar" name="btncancelar" class="btn btn-danger">Cancelar</button>
              </div>
            </div>

            </fieldset>
            </form>
            
    </div>
        <%@include file="jspf/footer.jspf" %>