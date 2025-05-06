/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class konexion {
    Connection con=null;
    public Connection konexion(){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3305/bd-apprestaurantev11movile","root","");
         System.out.println("Conexion aceptada");
     }catch(Exception e){
         System.out.println("Error"+e);
         JOptionPane.showMessageDialog(null, "no se pudo conectar");
     }   
     return con;
    }
    public Connection getConnection(){
       return con;
    }
    
}
