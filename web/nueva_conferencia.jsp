<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ page import="java.util.List,
                javax.persistence.EntityManagerFactory,
                javax.persistence.EntityManager,
                modelo.Usuario,
                javax.persistence.Persistence,
                javax.persistence.Query" %>
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
            Fecha y hora (dd/mm/aaaa hh:mm):
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
                <select name="encargado_id">
                    <%
                        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
                        EntityManager entitymanager = emfactory.createEntityManager();

                        Query query = entitymanager.createQuery("Select u From Usuario u where u.tipo = 'enc'");
                        List<Usuario> encargados = query.getResultList();

                        for(Usuario encargado : encargados) {
                    %> 
                    <option value=<%= encargado.getId() %>><%= encargado.getNombre() %></option>
                    <%
                        }
                    %>
                </select>
    <p><input type="submit" value="Enviar"></p>
</form>
        <a href="administrador_evento.xhtml">Regresar</a>
        
        
    </body>
</html>
