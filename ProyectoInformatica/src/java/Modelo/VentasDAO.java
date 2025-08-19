
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

     public List listar() {
        String sql = "call sp_ListarVentas()";
        List<Ventas> listaVentas = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ventas v = new Ventas();
                v.setCodigoVenta(rs.getInt(1));
                v.setCantidad(rs.getInt(2));
                v.setTotal(rs.getDouble(3));
                v.setCodigoDispositivo(rs.getInt(4));
                listaVentas.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVentas;
    }

    public int agregar(Ventas v) {
        String sql = "call sp_AgregarVentas(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getCantidad());
            ps.setDouble(2, v.getTotal());
            ps.setInt(3, v.getCodigoDispositivo());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    
    public Ventas listarCodigoPorVenta(int id){
        Ventas v=new Ventas();
        String sql = "Select * from Ventas where codigoVenta ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                v.setCodigoVenta(rs.getInt(1));
                v.setCantidad(rs.getInt(2));
                v.setTotal(rs.getDouble(3));
                v.setCodigoDispositivo(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
        
    }
    
    public int actualizar(Ventas v){
       String sql = "call sp_EditarVentas(?,?,?,?)" ;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getCodigoVenta());
            ps.setInt(2,v.getCantidad());
            ps.setDouble(3,v.getTotal());
            ps.setInt(4, v.getCodigoDispositivo());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int codigoV){
        String sql="call sp_EliminarVentas(?)";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigoV);   
            ps.executeUpdate();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
