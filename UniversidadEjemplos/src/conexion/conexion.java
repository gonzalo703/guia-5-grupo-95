/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gonza
 */
public class conexion {
    private static String url = "jdbc:mariadb://localhost/unilp";
    private static String usuario = "root";
    private static String password = "";
    
    private static conexion conexion = null;
    
    private conexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error al cargar driver");
        } 
    }
    public static Connection getConexion(){
        Connection con = null;
        
        if (conexion == null){
            conexion = new conexion();
            
        } try {
            con = DriverManager.getConnection(url + "?userLegacyDatatimeCode=false&serverTimezone=UTC" + "&user="+ usuario + "&password="+ password);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return con;
    }
}
