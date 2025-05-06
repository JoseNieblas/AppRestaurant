package Modelo;

public class Productos {
    private  int id;
    private int codigo;
    private String Nombre;
    private String Grupo;
    private int Stock;
    private double Precio;
    
    public Productos(){
        
    }

    public Productos(int id, int codigo, String Nombre, String Grupo, int Stock, double Precio) {
        this.id = id;
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Grupo = Grupo;
        this.Stock = Stock;
        this.Precio = Precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    
}
