<%-- 
    Document   : registro_publico
    Created on : Jan 5, 2017, 3:10:05 AM
    Author     : trafalgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
       <form action="registro_publico" method="post">
        Nombre:
                <input type="text" name="nombre">
                <br/>
        Apellido:
                <input type="text" name="apellido">
                <br/>
        Domicilio:
                  <input type="text" name="domicilio">
                  <br/>
        Telefono:
                <input type="text" name="telefono_contacto">
                <br/>
        Correo:
                <input type="text" name="correo">
                <br/>
    <p><input type="submit" value="Enviar"></p>
</form>
        
        
    </body>
</html>
