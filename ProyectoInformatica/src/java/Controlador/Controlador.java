/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.DispositivosPerifericos;
import Modelo.DispositivosPerifericosDAO;
import Modelo.Ventas;
import Modelo.VentasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author informatica
 */
public class Controlador extends HttpServlet {
    DispositivosPerifericosDAO dispositivoDAO = new DispositivosPerifericosDAO();
    DispositivosPerifericos dispositivo = new DispositivosPerifericos();
    Ventas ventas = new Ventas();
    VentasDAO ventasDAO = new VentasDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
            
            if (menu.equals("Principal")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            if(menu!=null){
                switch (menu) {
                    case "Dispositivos":
                        switch (accion) {
                            case "Listar":
                                List listaDispositivos = dispositivoDAO.listar();
                                request.setAttribute("dispositivos", listaDispositivos);
                                break;
                            case "Agregar":
                                String nombre = request.getParameter("txtNombre");
                                String tipo = request.getParameter("txtTipo");
                                double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                                dispositivo.setNombre(nombre);
                                dispositivo.setTipo(tipo);
                                dispositivo.setPrecio(precio);
                                dispositivoDAO.agregar(dispositivo);
                                request.getRequestDispatcher("Controlador?menu=Dispositivos&accion=Listar").forward(request,response);
                                break;
                            case "Editar":
                                int codigoD = Integer.parseInt(request.getParameter("codigoDispositivo"));
                                DispositivosPerifericos d = dispositivoDAO.listarCodigoDispositivo(codigoD);
                                request.setAttribute("dispositivo", d);
                                 request.getRequestDispatcher("Controlador?menu=Dispositivos&accion=Listar").forward(request,response);
                                break;
                            case "Actualizar":
                                int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
                                String nombreD = request.getParameter("txtNombre");
                                String tipoD = request.getParameter("txtTipo");
                                double precioD = Double.parseDouble(request.getParameter("txtPrecio"));
                                dispositivo.setCodigoDispositivo(codigo);
                                dispositivo.setNombre(nombreD);
                                dispositivo.setTipo(tipoD);
                                dispositivo.setPrecio(precioD);
                                dispositivoDAO.actualizar(dispositivo);
                                request.getRequestDispatcher("Controlador?menu=Dispositivos&accion=Listar").forward(request,response);                               
                                break;
                            case "Eliminar":
                                codigoD = Integer.parseInt(request.getParameter("codigoDispositivo"));
                                dispositivoDAO.eliminar(codigoD);
                                request.getRequestDispatcher("Controlador?menu=Dispositivos&accion=Listar").forward(request,response);
                                break;
                            case "Buscar":
                                break;
                            default:
                                throw new AssertionError();
                        }
                        request.getRequestDispatcher("Dispositivos.jsp").forward(request, response);
                        break;
                    case "Ventas":
                        switch (accion) {
                            case "Listar":
                                List listaVentas = ventasDAO.listar();
                                request.setAttribute("ventas", listaVentas);
                                break;
                            case "Agregar":
                                int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                                double total = Double.parseDouble(request.getParameter("txtTotal"));
                                int codigoD = Integer.parseInt(request.getParameter("txtCodigoDispositivo"));
                                ventas.setCantidad(cantidad);
                                ventas.setTotal(total);
                                ventas.setCodigoDispositivo(codigoD);
                                ventasDAO.agregar(ventas);
                                request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request,response);
                                break;
                            case "Editar":
                                int codigoV = Integer.parseInt(request.getParameter("codigoVenta"));
                                Ventas v = ventasDAO.listarCodigoPorVenta(codigoV);
                                request.setAttribute("venta", v);
                                request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request,response);
                                break;
                            case "Actualizar":
                                int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
                                int cantidadV = Integer.parseInt(request.getParameter("txtCantidad"));
                                double totalV = Double.parseDouble(request.getParameter("txtTotal"));
                                int codigoDV = Integer.parseInt(request.getParameter("txtCodigoDispositivo"));
                                ventas.setCodigoVenta(codigo);
                                ventas.setCantidad(cantidadV);
                                ventas.setTotal(totalV);
                                ventas.setCodigoDispositivo(codigoDV);
                                ventasDAO.actualizar(ventas);
                                request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request,response);                      
                                break;
                            case "Eliminar":
                                codigoV = Integer.parseInt(request.getParameter("codigoVenta"));
                                ventasDAO.eliminar(codigoV);
                                request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request,response);
                                break;
                            case "Buscar":
                                break;
                            default:
                                throw new AssertionError();
                        }
                        request.getRequestDispatcher("Ventas.jsp").forward(request, response);
                        break;
                }
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
