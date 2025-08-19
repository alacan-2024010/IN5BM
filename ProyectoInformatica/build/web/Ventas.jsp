<%-- 
    Document   : Ventas
    Created on : 19 ago 2025, 10:04:37
    Author     : informatica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ventana de Ventas</title>
        <link rel="stylesheet" href="Styles/dispositivos.css">
    </head>
    <body>

        <nav>
            
        </nav>

        <div class="fondo"></div>

        <div class="contenedor-principal">
            <div class="panel-formulario">
                <h1>Gestión de Ventas</h1>
                 <form action="Controlador?menu=Ventas" method="POST" class="formulario">
                    <input type="text" autocomplete="off" value="${venta.getCodigoVenta()}" name="txtCodigo" placeholder="Codigo de venta" />
                    <input type="text" autocomplete="off" value="${venta.getCantidad()}" name="txtCantidad" placeholder="Cantidad " required/>
                    <input type="text" autocomplete="off" value="${venta.getTotal()}" name="txtTotal" placeholder="Total"required />
                    <input type="text" autocomplete="off" value="${venta.getCodigoDispositivo()}"name="txtCodigoDispositivo" placeholder="Codigo del Dispositivo"required />
                    <div class="botones">
                        <button type="submit" name="accion" value="Agregar">Agregar</button>
                        <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                    </div>
                    <div class="marca-interna">
                        Essenza & Co.
                    </div>

                </form>
            </div>

            <div class="panel-tabla">
                <div class="tabla-contenedor">
                    <table class="tabla">
                        <thead>
                            <tr>
                                <th>Codigo Venta</th>
                                <th>Cantidad</th>
                                <th>Total</th>
                                <th>Codigo Dispositivo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="venta" items="${ventas}">
                                <tr>
                                        <td>${venta.getCodigoVenta()}</td>
                                        <td>${venta.getCantidad()}</td>
                                        <td>${venta.getTotal()}</td>
                                        <td>${venta.getCodigoDispositivo()}</td>
                                        <td>
                                            <a href="Controlador?menu=Ventas&accion=Editar&codigoVenta=${venta.getCodigoVenta()}" 
                                               class="btn editar">Editar</a>
                                            |
                                            <a href="Controlador?menu=Ventas&accion=Eliminar&codigoVenta=${venta.getCodigoVenta()}" 
                                               class="btn eliminar"
                                               onclick="return confirm('¿Seguro que deseas eliminar la venta?');">
                                                Eliminar
                                            </a>
                                        </td>
                                 </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div> 
            </div> 
        </div>  
    </body>
</html>