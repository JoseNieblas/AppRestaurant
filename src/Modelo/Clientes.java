package Modelo;

public class Clientes {
    private int codigo;
    private String Nombre;

    public Clientes() {
    }

    public Clientes(int codigo, String Nombre) {
        this.codigo = codigo;
        this.Nombre = Nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
