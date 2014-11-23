<%-- 
    Document   : show
    Created on : 22-nov-2014, 20:01:51
    Author     : Alberto
--%>

<%@page import="java.net.URLEncoder"%>
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
            </tr>
            <%
                for (Film f : data) {
            %>
            <tr>
                <td><a href="<%= getServletContext().getContextPath() %>/details?id=<%= f.getFilmId() %>">
                        <%= f.getTitle() %></a></td>
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
