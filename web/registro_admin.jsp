<%-- 
    Document   : registro_admin
    Created on : Jan 5, 2017, 2:29:18 AM
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
        
        
       
        <form action="registro_admin2" method="get">
         Nombre:
                <input type="text" name="nombre">
                <br/>
         Apellido:
                 <input type="text" name="apellido">
         
                 <br/>
                 Username:
                 <input type="text" name="username">
                <br/>
                Password:
                 <input type="password" name="password" value="">
                <br/>
                Tipo:
                <input name="Administrador" type="checkbox" value=""/> Administrador
                <input name="Encargado" type="checkbox" value=""/> Encargado
                <br/>
                
                
    <p><input type="submit" value="Enviar"></p>
</form>
        
        
        
        
        
    </body>
</html>
