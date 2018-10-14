    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : enviaSolicitacao
    Created on : 13/10/2018, 12:14:05
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<h2>Text Input</h2>

<form method="post">
  Nome:<br>
  <input type="text" name="firstname">
  <br>
  Usuário Github (Email):<br>
  <input type="email" name="email">
  <br>
  Usuarios:<br>
  <input list="listUsuario" name="listUsuario">
    <datalist id="listUsuario">
        <c:forEach var="usuarios" items="${listaUsuarios}">
            <option value=${usuarios.getNome()}>
        </c:forEach>
    </datalist>
  <br>
  Grupos:<br>
  <input list="browsers" name="browser">
    <datalist id="browsers">
      <option value="Internet Explorer">
      <option value="Firefox">
      <option value="Chrome">
      <option value="Opera">
      <option value="Safari">
    </datalist>
  <br>
  <button type="submit" id="btnsalvar" name="btnsalvar">Enviar</button>
</form>


</body>
</html>
