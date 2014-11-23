<%-- 
    Document   : show
    Created on : 22-nov-2014, 20:01:51
    Author     : Alberto
--%>

<%@page import="servlet.Comentario"%>
<%@page import="java.util.List"%>
<%@page import="servlet.Film"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Film f = (Film) request.getSession().getAttribute("film");
            List<Comentario> comments = (List<Comentario>) request.getSession().getAttribute("comments");
            if (f == null) {
        %>
        No existe informaci&oacute;n sobre la pel&iacute;cula
        <%
        } else {
        %>
        <table>
            <tr>
                <th>T&iacute;tulo</th>
                <th>Descripci&oacute;n</th>
                <th>Clasificaci&oacute;n</th>
                <th>Caracter&iacute;sticas especiales</th>
                <th>Duraci&oacute;n</th>
                <th>A&ntilde;o de lanzamiento</th>
                <th>Duraci&oacute;n del alquiler</th>
                <th>Tasa de alquiler</th>
                <th>Coste de reemplazo</th>
                <th>Idioma</th>
                <th>Idioma original</th>
            </tr>
            <tr>
                <td><%= f.getTitle()%></td>
                <td><%= f.getDescription()%></td>
                <td><%= f.getRating()%></td>
                <td><%= f.getSpecialFeatures()%></td>
                <td><%= f.getLength()%></td>
                <td><%= f.getReleaseYear()%></td>
                <td><%= f.getRentalDuration()%></td>
                <td><%= f.getRentalRate()%></td>
                <td><%= f.getReplacementCost()%></td>
                <td><%= f.getLanguageId() == null ? "No especificado"
                            : f.getLanguageId().getName()%></td>
                <td><%= f.getOriginalLanguageId() == null ? "No especificado"
                            : f.getOriginalLanguageId().getName()%></td>
            </tr>
        </table>
        Comentarios:<br/>
        <form action="submitComment" method="POST">
            <input type="text" name="nicknameTextbox" />
            <input type="text" name="commentaryTextbox"/>
            <input type="submit" value="Enviar"/>
            <input type="hidden" name="id" value="<%= f.getFilmId()%>"/>
        </form><br/>
        <table>
            <%
                for (Comentario c : comments) {
            %>
            <tr>
                <td><%= c.getComentarioAutor()%></td>
                <td><%= c.getComentarioText()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }
        %>
    </body>
</html>
