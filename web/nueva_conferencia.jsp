<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="registro_conferencia" method="post">
         Nombre Conferencia:
                <input type="text" name="nombre"/>
                <br/>
         Nombre Expositor:
                <input type="text" name="expositor"/>
                <br/>
         Capacidad:
                  <input type="number" name="capacidad"/>
                  <br/>
         Fecha y hora:
                <input type="date" name="fecha_hora"/>
                <br/>
        Descripcion:
                <textarea name="descripcion"></textarea>
                <br/>
         Costo:
                <input type="number" name="costo"/>
                <br/>
          Sala:
                <input type="text" name="sala"/>
                <br/>
         Encargado:
                <input type="text" name="encargado"/>
                <br/>
    <p><input type="submit" value="Enviar"></p>
</form>
        <a href="administrador_evento.jsp">Regresar</a>
        
        
    </body>
</html>
