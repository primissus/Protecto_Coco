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
                javax.persistence.Query,
                java.util.Date,
                java.util.concurrent.TimeUnit" %>
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
                            if(conferencia.getPublico().size() < conferencia.getCapacidad()) {
                                Date hoy = new Date();
                                long diff =  conferencia.getFechaHora().getTime() - hoy.getTime();
                                long horas = diff / 1000 / 60 / 60;
                                if(horas >= 24) {
                                    %> 
                                    <option value=<%= conferencia.getId() %>><%= conferencia.getNombre() %></option>
                                    <%
                                }
                            }
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
