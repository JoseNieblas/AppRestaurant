package Modelo;

public class Detalle {
    private int id;
    private String cod_pro;
    private int Cantidad;
    private double precio;
    private int id_venta;
    
    public Detalle(){
        
    }

    public Detalle(int id, String cod_pro, int Cantidad, double precio, int id_venta) {
        this.id = id;
        this.cod_pro = cod_pro;
        this.Cantidad = Cantidad;
        this.precio = precio;
        this.id_venta = id_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    
}
