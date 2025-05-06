package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Clientes cl){
        String sql = "INSERT INTO clientes (codigo,nombre) VALUES (?,?)";
        try{
            con = cn.getConnetion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getCodigo());
            ps.setString(2, cl.getNombre());
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
    
    public List ListarCliente(){
        List<Clientes> ListaCl = new ArrayList();
        String sql = "SELECT * FROM clientes";
        try{
            con = cn.getConnetion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Clientes cl = new Clientes();
                cl.setCodigo(rs.getInt("codigo"));
                cl.setNombre(rs.getString("Nombre"));
                ListaCl.add(cl);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaCl;
    }
    
    public boolean EliminarCliente(int codigo){
        String sql = "DELETE FROM clientes where codigo=?";
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
    
    public boolean ActualizarCliente(Clientes cl){
        String sql="UPDATE clientes SET nombre=? where codigo=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setInt(2, cl.getCodigo());
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
    
    public Clientes BuscarCliente(int codigo){
        Clientes cl=new Clientes();
        String sql="Select * from clientes where codigo=?";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs=ps.executeQuery();
            if(rs.next()){
                cl.setNombre(rs.getString("nombre"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return cl;
    }
}
