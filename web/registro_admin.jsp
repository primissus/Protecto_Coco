<%--
    Document   : registro_admin
    Created on : 4/01/2017, 07:50:33 PM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/form.css"/>
    </head>
    <body>
      <div class="middle">
        <h1>Registro de asistentes</h1>
        <form action="registro_admin" method="post">
          <div id="fancy-inputs">
            <label class="input">
              <input type="text" name="nombre">
              <span><span>Nombre</span></span>
            </label>

            <label class="input">
              <input type="text" name="apellido">
              <span><span>Apellido</span></span>
            </label>

            <label class="input">
              <input type="text" name="user_name">
              <span><span>Nombre usuario</span></span>
            </label>

            <label class="input">
              <input type="text" name="Password">
              <span><span>Contraseña</span></span>
            </label>
          </div>

          <select name="tipo">
             <option value="adm">Administador</option>
             <option value="enc">Encargado</option>
          </select>



        <p><input type="submit" value="Enviar"></p>
    </form>
  </div>

    <a href="administrador_evento.xhtml">Regresar</a>

    </body>
</html>
