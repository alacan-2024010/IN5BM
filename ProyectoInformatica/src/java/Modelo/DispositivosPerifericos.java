/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class DispositivosPerifericos {
    
   private  int codigoDispositivo;
   private String nombre;
   private  String tipo;
   private Double precio;

    public DispositivosPerifericos() {
    }

    public DispositivosPerifericos(int codigoDispositivo, String nombre, String tipo, Double precio) {
        this.codigoDispositivo = codigoDispositivo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getCodigoDispositivo() {
        return codigoDispositivo;
    }

    public void setCodigoDispositivo(int codigoDispositivo) {
        this.codigoDispositivo = codigoDispositivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
}
