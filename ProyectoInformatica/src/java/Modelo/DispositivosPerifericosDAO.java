
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DispositivosPerifericosDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

     public List listar() {
        String sql = "call sp_ListarDispositivos()";
        List<DispositivosPerifericos> listaDispositivos = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DispositivosPerifericos d = new DispositivosPerifericos();
                d.setCodigoDispositivo(rs.getInt(1));
                d.setNombre(rs.getString(2));
                d.setTipo(rs.getString(3));
                d.setPrecio(rs.getDouble(4));
                listaDispositivos.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDispositivos;
    }

    public int agregar(DispositivosPerifericos dp) {
        String sql = "call sp_AgregarDispositivos(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, dp.getNombre());
            ps.setString(2, dp.getTipo());
            ps.setDouble(3, dp.getPrecio());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    
    public DispositivosPerifericos listarCodigoDispositivo(int id){
        DispositivosPerifericos dp=new DispositivosPerifericos();
        String sql = "Select * from DispositivosPerifericos where codigoDispositivo ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                dp.setCodigoDispositivo(rs.getInt(1));
                dp.setNombre(rs.getString(2));
                dp.setTipo(rs.getString(3));
                dp.setPrecio(rs.getDouble(4));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dp;
        
    }
    
    public int actualizar(DispositivosPerifericos dp){
       String sql = "call sp_EditarDispositivos(?,?,?,?)" ;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dp.getCodigoDispositivo());
            ps.setString(2,dp.getNombre());
            ps.setString(3, dp.getTipo());
            ps.setDouble(4, dp.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int codigoC){
        String sql="call sp_EliminarDispositivos(?)";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigoC);   
            ps.executeUpdate();      
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
