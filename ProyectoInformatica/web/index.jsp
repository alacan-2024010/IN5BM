<%-- 
    Document   : admin
    Created on : 19 ago 2025, 10:37:11
    Author     : informatica
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Ventana de Admin</title>
        <link rel="stylesheet" href="Styles/admin.css">
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="Controlador?menu=Dispositivos&accion=Listar" target="contenido">Dispositivos Perifericos</a></li>
                <li><a href="Controlador?menu=Ventas&accion=Listar" target="contenido">Ventas</a></li>
            </ul>
        </nav>

        <div class="contenido">
            <iframe name="contenido"></iframe>
        </div>

    </body>
</html>
