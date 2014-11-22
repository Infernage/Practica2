<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="POST">
            <input type="text" name="data"/>
            <select name="options">
                <option value="title">T&iacute;tulo</option>
                <option value="category">Categor&iacute;a</option>
                <option value="year">A&ntilde;o</option>
                <option value="language">Idioma</option>
                <option value="duration">Duraci&oacute;n del alquiler</option>
                <option value="rate">Tasa de alquiler</option>
                <option value="length">Duraci&oacute;n</option>
                <option value="cost">Coste de reemplazo</option>
                <option value="rating">Clasificaci&oacute;n</option>
                <option value="features">Caracter&iacute;sticas especiales</option>
            </select>
            <input type="submit" value="Aceptar"/>
        </form>
    </body>
</html>
