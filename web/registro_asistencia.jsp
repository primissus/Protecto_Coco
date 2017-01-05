<%-- 
    Document   : correcto2
    Created on : Jan 5, 2017, 3:20:26 AM
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
        
        <form action="registro_asistencia" method="get">
            Conferencia:
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
                Codigo:
                <input type="text" name="codigo">
                <br/>
                <div>
                 <input type="submit" name="submit" value="Enviar"/>
                </div>
        </form>
        
        
        
        
        
        
    </body>
</html>
