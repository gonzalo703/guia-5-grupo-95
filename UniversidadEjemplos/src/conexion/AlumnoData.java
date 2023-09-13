/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import entidades.Alumno;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author gonza
 */
public class AlumnoData {
    private Connection con=null;
    
    public AlumnoData(){
        con=conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        
        String sql = "INSERT INTO alumno (DNI, apellido, nombre, fechaNacimiento,Estado)"
                + "VALUES(?,?,?,?,?)";
                
                try{
                    PreparedStatement ps= con.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, alumno.getDNI());
                    ps.setString(2,alumno.getApellido());
                    ps.setString(3, alumno.getNombre());
                    ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                    ps.setBoolean(5,alumno.isEstado());
                    ps.executeUpdate();
                      // obtener clave
                     ResultSet rs=ps.getGeneratedKeys();
                   if(rs.next()){
                       alumno.setId_Alumno(rs.getInt(1));
                       JOptionPane.showMessageDialog(null, "Alumno Guardado");
                   }
                   ps.close();
                    
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
                }
    } 
    public void modificarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET dni = ?,apellido = ?,nombre = ?, fechaNacimiento = ?"
                + "WHERE id:Alumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,alumno.getDNI());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getId_Alumno());
            int exito = ps.executeUpdate();
            
            if(exito == 1 ){
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public void eliminarAlumno(int id){
        String sql = "UPDATE alumno SET estado = 0 WHERE id_Alumnos = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if( exito == 1){
               JOptionPane.showMessageDialog(null, "Alumno Eliminado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    public Alumno buscarAlumno(int id){
        String sql = "SELECT DNI,apellido, nombre, fechaNacimiento FROM alumno WHERE id_Alumnos= ? AND estado = 1 ";
        Alumno alumno = null;
        try {
            PreparedStatement Ps = con.prepareStatement(sql);
            Ps.setInt(1, id);
            ResultSet rs=Ps.executeQuery();
            if (rs.next()){
                alumno = new Alumno();
                alumno.setId_Alumno(id);
                alumno.setDNI(rs.getInt("DNI"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                Ps.close();
            }else {
                JOptionPane.showMessageDialog(null," No existe alumno ");
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return alumno;
     }
     public Alumno buscarAlumnoDni(int dni){
        String sql = "SELECT id_Alumnos, apellido, nombre, fechaNacimiento FROM alumno WHERE DNI= ? AND estado = 1 ";
        Alumno alumno = null;
        try {
            PreparedStatement Ps = con.prepareStatement(sql);
            Ps.setInt(1, dni);
            ResultSet rs=Ps.executeQuery();
            if (rs.next()){
                alumno = new Alumno();
                alumno.setId_Alumno(rs.getInt("id_Alumno"));
                alumno.setDNI(rs.getInt(dni));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                Ps.close();
            }else {
                JOptionPane.showMessageDialog(null," No existe alumno ");
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return alumno;
     }
     
      public List<Alumno> buscarAlumnoLista(){
        String sql = "SELECT id_Alumnos, DNI, apellido, nombre, fechaNacimiento FROM alumno WHERE  estado = 1 ";
        ArrayList<Alumno>alumnos= new ArrayList<>();
      
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            System.out.println("2");
            
            while (rs.next()){
              
                Alumno alumno=new Alumno();    
                alumno.setId_Alumno(rs.getInt("id_Alumno"));
                alumno.setDNI(rs.getInt("DNI"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                //agregar en la lista
                alumnos.add(alumno);   
            }
            ps.close();
                  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno1");
        }
        return alumnos;
    }
}