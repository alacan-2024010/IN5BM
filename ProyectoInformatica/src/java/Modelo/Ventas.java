
package Modelo;


public class Ventas {
    private int codigoVenta;
    private int cantidad;
    private Double total;
    private int codigoDispositivo;

    public Ventas() {
    }

    public Ventas(int codigoVenta, int cantidad, Double total, int codigoDispositivo) {
        this.codigoVenta = codigoVenta;
        this.cantidad = cantidad;
        this.total = total;
        this.codigoDispositivo = codigoDispositivo;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getCodigoDispositivo() {
        return codigoDispositivo;
    }

    public void setCodigoDispositivo(int codigoDispositivo) {
        this.codigoDispositivo = codigoDispositivo;
    }

    
    
    
}
