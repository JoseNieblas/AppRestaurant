package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ProductosDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProductos(Productos pro){
        String sql= "INSERT INTO productos (codigo,nombre,grupo,stock,precio) VALUES (?,?,?,?,?)";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3,pro.getGrupo());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5,pro.getPrecio());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List Listarproductos(){
        List<Productos> Listapro = new ArrayList();
        String sql = "SELECT * FROM productos";
        try{
            con = cn.getConnetion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos pro = new Productos();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNombre(rs.getString("Nombre"));
                pro.setGrupo(rs.getString("Grupo"));
                pro.setStock(rs.getInt("Stock"));
                pro.setPrecio(rs.getDouble("Precio"));
                Listapro.add(pro);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return Listapro;
    } 
    
    public boolean EliminarProductos(int codigo){
        String sql = "DELETE FROM productos where codigo=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean Eliminarmesa(int codigo){
        String sql = "DELETE FROM mesas where codigo_mesa=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean ActualizarProdutos(Productos pro){
        String sql="UPDATE productos SET nombre=?,Grupo=?, stock=?, precio=? where codigo=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getGrupo());
            ps.setInt(3, pro.getStock());
            ps.setDouble(4, pro.getPrecio());
            ps.setInt(5, pro.getCodigo());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ActualizarMesa(Mesas m){
        String sql="UPDATE mesas SET mesa=?,codigo=?,descripcion=?,cantidad=?,precio=? where codigo_mesa=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, m.getMesa());
            ps.setInt(2,m.getCodigo());
            ps.setString(3, m.getDescripcion());
            ps.setInt(4, m.getCantidad());
            ps.setString(5, m.getPrecio());
            ps.setInt(6, m.getCodigo_mesa());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }/*finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }*/
    }

    
    public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql="SELECT * FROM productos where codigo=?";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            ps.setString(1,cod);
            
            rs=ps.executeQuery();
            if(rs.next()){
                producto.setNombre(rs.getString("Nombre"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setStock(rs.getInt("Stock"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return producto;
    }
    
    public Productos BuscarProCo(String grup, String nom){
        Productos producto = new Productos();
        String sql="SELECT * FROM productos where nombre=?";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            ps.setString(1,grup);
            ps.setString(2, nom);
            
            rs=ps.executeQuery();
            if(rs.next()){
                //producto.setCodigo(rs.getString("Codigo"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setStock(rs.getInt("Stock"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return producto;
    }
    
    public Productos BuscarProNombre(String nom){
        Productos producto = new Productos();
        String sql="SELECT * FROM productos where nombre=?";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            
            rs=ps.executeQuery();
            if(rs.next()){
                //producto.setCodigo(rs.getString("Codigo"));
                producto.setCodigo(rs.getInt("Codigo"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setGrupo(rs.getString("Grupo"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setStock(rs.getInt("Stock"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return producto;
    }
    
    public Config BuscarDatos(){
        Config conf = new Config();
        String sql="SELECT * FROM configuracion";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                conf.setId(rs.getInt("id"));
                conf.setCodigo(rs.getString("Codigo"));
                conf.setNombre(rs.getString("Nombre"));
                conf.setTelefono(rs.getString("Telefono"));
                conf.setDireccion(rs.getString("Direccion"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return conf;
    }
    
    public void ColsultarGrupo(JComboBox Grupo){
        String sql="select distinct grupo from productos";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Grupo.addItem(rs.getString("Grupo"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public void ColsultarGrupoN(JComboBox Nombre){
        String sql="select nombre from productos";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Nombre.addItem(rs.getString("Nombre"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public void ColsultarMesero(JComboBox Mesero){
        String sql="select codigo from clientes";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Mesero.addItem(rs.getString("Codigo"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public boolean ActualizarDatos(Config conf){
        String sql="UPDATE configuracion SET codigo=?,nombre=?, telefono=?, direccion=? where id=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,conf.getCodigo());
            ps.setString(2,conf.getNombre());
            ps.setString(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setInt(5, conf.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
}
