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
    <div align="center">
        <form method="post" role="form" action="FrontController?action=AutenticaUsuario">
            <label for="usuario_input">Login</label>
            <input type="text" class="form-control" id="usuario_input" name="usuario"><br>
            <label for="senha_input">Senha</label>                    
            <input type="password" class="form-control input normal" id="senha_input" name="senha">
           <button type="submit" class="btn btn-default">Confirmar</button>     
        </form>
        <div>
            <hr/>
            
            <p>Não é cadastrado?  <a href="cadastro.jsp"><button class="btn btn-default">      Casdastrar</button></a></p>
            
        </div>
        
        <%@include file="jspf/footer.jspf" %>