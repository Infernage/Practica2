<%-- 
    Document   : show
    Created on : 22-nov-2014, 20:01:51
    Author     : Alberto
--%>

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
            List<Film> data = (List<Film>) request.getSession().getAttribute("result");
            if (data == null || data.isEmpty()) {
        %>
        No existen pel&iacute;culas para mostrar
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
            <%
                for(Film f : data){
                    %>
                    <tr>
                        <td><%= f.getTitle()%></td>
                        <td><%= f.getDescription() %></td>
                        <td><%= f.getRating() %></td>
                        <td><%= f.getSpecialFeatures() %></td>
                        <td><%= f.getLength() %></td>
                        <td><%= f.getReleaseYear() %></td>
                        <td><%= f.getRentalDuration() %></td>
                        <td><%= f.getRentalRate() %></td>
                        <td><%= f.getReplacementCost() %></td>
                        <td><%= f.getLanguageId() == null ? "No especificado" : 
                                f.getLanguageId().getName() %></td>
                        <td><%= f.getOriginalLanguageId() == null ? "No especificado" :
                                f.getOriginalLanguageId().getName() %></td>
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
