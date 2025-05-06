package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class VentaDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdVenta(){
        int id=0;
        String sql="select MAX(id) from ventas";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    public int RegistraVenta(Venta v){
        String sql="insert into ventas (cliente,vendedor,total) values (?,?,?)";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            ps.setString(1,v.getCliente());
            ps.setString(2,v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public int RegistrarDetalle(Detalle DV){
        String sql="insert into detalle (cod_pro, cantidad, precio, id_venta) values (?,?,?,?)";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            ps.setString(1,DV.getCod_pro());
            ps.setInt(2,DV.getCantidad());
            ps.setDouble(3, DV.getPrecio());
            ps.setInt(4,DV.getId_venta());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public boolean ActualizarStock(int cant, String cod){
        String sql="update productos set stock=? where codigo=?";
        try{
            con=cn.getConnetion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
}
