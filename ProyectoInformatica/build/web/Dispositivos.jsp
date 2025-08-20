<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ventana de Dispositivos Perifericos</title>
        <link rel="stylesheet" href="Styles/dispositivos.css">
    </head>
    <body>
        <div class="fondo"></div>

        <div class="contenedor-principal">
            <div class="panel-formulario">
                <h1>Gestión de Dispositivos</h1>
                <form action="Controlador?menu=Dispositivos" method="POST" class="formulario">
                    <input type="text" autocomplete="off" value="${dispositivo.getCodigoDispositivo()}" name="txtCodigo" placeholder="Codigo del Dispositivo"/>
                    <input type="text" autocomplete="off" value="${dispositivo.getNombre()}" name="txtNombre" placeholder="Nombre del Dispositivo" required/>
                    <input type="text" autocomplete="off" value="${dispositivo.getTipo()}" name="txtTipo" placeholder="Tipo de Dispositivo" required/>
                    <input type="text" autocomplete="off" value="${dispositivo.getPrecio()}" name="txtPrecio" placeholder="Precio de Dispositivo" required/>
                    <div class="botones">
                        <button type="submit" name="accion" value="Agregar">Agregar</button>
                        <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                    </div>
                    <div class="marca-interna">
                        Dispositivos-Alan
                    </div>
                </form>
            </div>

            <div class="panel-tabla">
                <div class="tabla-contenedor">
                    <table class="tabla">
                        <thead>
                            <tr>
                                <th>Codigo del Dispositivo</th>
                                <th>Nombre</th>
                                <th>Tipo</th>
                                <th>Precio</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dispositivo" items="${dispositivos}">
                                <tr>
                                    <td>${dispositivo.getCodigoDispositivo()}</td>
                                    <td>${dispositivo.getNombre()}</td>
                                    <td>${dispositivo.getTipo()}</td>
                                    <td>${dispositivo.getPrecio()}</td>
                                    <td>
                                        <a href="Controlador?menu=Dispositivos&accion=Editar&codigoDispositivo=${dispositivo.getCodigoDispositivo()}" 
                                           class="btn editar">Editar</a>
                                        |
                                        <a href="Controlador?menu=Dispositivos&accion=Eliminar&codigoDispositivo=${dispositivo.getCodigoDispositivo()}" 
                                           class="btn eliminar"
                                           onclick="return confirm('¿Seguro que deseas eliminar este dispositivo?');">
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