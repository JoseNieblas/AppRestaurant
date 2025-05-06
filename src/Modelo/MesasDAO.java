
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class MesasDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    /*public boolean ActualizarMesa(Mesas m){
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
            con.close();
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
    }*/
}
