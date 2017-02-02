<%-- 
    Document   : registro_publico
    Created on : Jan 5, 2017, 3:10:05 AM
    Author     : trafalgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ page import="java.util.List,
                javax.persistence.EntityManagerFactory,
                javax.persistence.EntityManager,
                modelo.Conferencia,
                javax.persistence.Persistence,
                javax.persistence.Query" %>
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
        Nombre de la conferencia:
                <select name="id">
                    <%
                        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
                        EntityManager entitymanager = emfactory.createEntityManager();

                        Query query = entitymanager.createQuery("Select c From Conferencia c ");
                        List<Conferencia> conferencias = query.getResultList();

                        for(Conferencia conferencia : conferencias) {
                    %> 
                    <option value=<%= conferencia.getId() %>><%= conferencia.getNombre() %></option>
                    <%
                        }
                    %>
                </select>        
    <p><input type="submit" value="Enviar"></p>
</form>
        
    <a href="index.xhtml">Regresar</a>    
    </body>
</html>
