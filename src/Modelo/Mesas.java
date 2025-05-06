
package Modelo;

public class Mesas {
    private int codigo_mesa;
    private String mesa;
    private int codigo;
    private String descripcion;
    private int cantidad;
    private String precio;
    private String comentario;
    
    public Mesas(){
        
    }

    public Mesas(int codido_mesa, String mesa, int codigo, String descripcion, int cantidad, String precio, String comentario) {
        this.codigo_mesa = codido_mesa;
        this.mesa = mesa;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.comentario = comentario;
    }

    public int getCodigo_mesa() {
        return codigo_mesa;
    }

    public void setCodigo_mesa(int codido_mesa) {
        this.codigo_mesa = codido_mesa;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
