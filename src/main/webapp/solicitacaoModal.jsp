<%-- 
    Document   : solicitacaoModal
    Created on : 07/10/2018, 18:24:41
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Convite</title>
    </head>
    <body>
        <div class="row">
        <div class = "col"></div>
        <div class = "col"><center><h1>Team Crowd</h1></center><br/>
            <center><img src="imagens\crowedsource.jpg" id="imagemborda" alt="CrowdSourcing" align=center height="150"/></center></div>
        <div class = "col"></div>
        </div>
        </br>
        <div class="row">
            <div class="col-sm-8">
                <p>Prezado: XXXX. Você foi convidado para participar do grupo de desenvolvimento de aplicativos móveis. Deseja participar? </p>
            </div>
            <div class="col-sm-2">
                <form class="form-horizontal" method="post" role="form" action="FrontController?action=solicitacaoAceita">
                    <fieldset>
                      <div class="form-group">
                           <label class="col-md-4 control-label" for="btnsalvar"></label>
                           <div class="col-md-8">
                             <button type="submit" id="btnsalvar" name="btnsalvar" class="btn btn-success">Sim</button>                 
                           </div>
                     </div>
                     </fieldset>
                </form>
            </div>
            <div class="col-sm-2">
                <form class="form-horizontal" method="post" role="form" action="FrontController?action=solicitacaoNegada">
                    <fieldset>
                      <div class="form-group">
                           <label class="col-md-4 control-label" for="btnsalvar"></label>
                           <div class="col-md-8">
                             <button type="submit" id="btnsalvar" name="btnsalvar" class="btn btn-danger">Não</button>                 
                           </div>
                     </div>
                     </fieldset>
                </form>
            </div>
        </div>
        <h3>Descrição</h3>
        <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing.""Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing."
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing."
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing."
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing."</p>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>
