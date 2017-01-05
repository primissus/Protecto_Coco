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
    </head>
    <body>
        <form action="registro_admin" method="post">
        Nombre:
                <input type="text" name="nombre"/>
                <br/>
          Apellido:
                <input type="text" name="apellido"/>
                <br/>
                User name:
                <input type="text" name="user_name"/>
                <br/>
         Password:
                 <input type="text" name="Password"/>
                <br/>
        Tipo:
                <select name="tipo">
                    <option value="adm">Administador</option>
                    <option value="enc">Encargado</option>
                </select>
                <br/>
    <p><input type="submit" value="Enviar"></p>
</form>
        
        
        
    </body>
</html>
