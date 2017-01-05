<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
    </head>
    <body>
        <form>
                    <ul>
                        <a href="nueva_conferencia.jsp">Nueva conferencia</a>
                        <br>
                       <a href="lista_registardos.jsp">Lista de registrados</a>
                        <br>
                        <a href="cancelar.jsp">Cancelar conferencia</a>
                        <br>
                        <a href="registro_publico.jsp">Registrar persona</a>
                        <br>
                        <%
                            Cookie cookie = null;
                            Cookie[] cookies = null;

                            cookies = request.getCookies();
                            if (cookies != null) {
                               for (int i = 0; i < cookies.length; i++) {
                                   cookie = cookies[i];
                                   if(cookie.getName().equals("tipo")) {
                                       if(cookie.getValue().equals("adm")){
                                           out.println("<a href=\"registro_admin.jsp\">Resgistrar administrador/encargado</a><br>");
                                       }
                                   }
                               }
                            }
                        %>
                    </ul> 
                </form>
    </body>
</html>
