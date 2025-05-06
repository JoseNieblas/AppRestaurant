
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn=new Conexion();
   
    public login log(int codigo, String contraseña){
        login l = new login();
        String sql="SELECT * FROM clientes_programa WHERE codigo = ? AND contraseña = ?";
        try{
            //Conexion con= new Conexion();
            con= cn.getConnetion();
            ps = con.prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.setString(2,contraseña);
            rs= ps.executeQuery();
            if(rs.next()){
                l.setCodigo(rs.getInt("codigo"));
                l.setContraseña(rs.getString("contraseña"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
}
