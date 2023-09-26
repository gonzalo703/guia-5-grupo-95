/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import Universidad.Entidades.Alumno;
import Universidad.Entidades.Inscripcion;
import Universidad.Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;



import javax.swing.JOptionPane;

public class InscripcionData {
    private Connection con = null;
    private MateriaData mated = new MateriaData();
    private AlumnoData alud = new AlumnoData();
    
    public InscripcionData (){
        this.con=conexion.getConexion();
    }
    
    public void guardarinscripcion(Inscripcion insc){
        String sql = "INSERT INTO inscripcion (nota , id_Alumnos, id_Materia) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getId_Alumnos());
            ps.setInt(3, insc.getMateria().getId_Materia());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()){
                insc.setId_Inscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion agregada");
            }
            ps.addBatch();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la taba inscripcion");    
        }
        
    }
    
    public void actualizarNota (int id_Alumnos,int id_Materia, double nota){
        
        String sql = "UPDATE inscripcion SET nota = ? WHERE id_Alumnos = ? and id_Materia = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, id_Alumnos);
            ps.setInt(3, id_Materia);
            
            int resultado = ps.executeUpdate();
            if (resultado==1){
                JOptionPane.showMessageDialog(null,"Nota actualizada");
            }
            ps.close();
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la taba inscripcion"); 
        }
    }
    
    public void borrarInscricion (int id_Alumnos, int id_Materia){
               String sql = "DELETE FROM inscripcion WHERE id_Alumnos = ? and id_Materia = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_Alumnos);
             ps.setInt(2, id_Materia);
            int exito = ps.executeUpdate();
            if( exito == 1){
               JOptionPane.showMessageDialog(null, "Inscipcion Eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Inscripcion insc = new Inscripcion();
                insc.setId_Inscripcion(rs.getInt("id_Inscripcion"));
                Alumno alu =alud.buscarAlumno(rs.getInt("id_Alumnos"));
                Materia mat = mated.buscarMateria(rs.getInt("id_Materia"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
     return cursadas;

    }
    
    public List<Inscripcion> obtenerInscripcionesAlumno(int id_Alumnos){
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion WHERE id_Alumnos = ?";
        
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_Alumnos);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Inscripcion insc = new Inscripcion();
                insc.setId_Inscripcion(rs.getInt("id_Inscripcion"));
                Alumno alu =alud.buscarAlumno(rs.getInt("id_Alumnos"));
                Materia mat = mated.buscarMateria(rs.getInt("id_Materia"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
     return cursadas;
     }
    
    public  List <Materia> materiasCursadas(int id_Alumnos){
      ArrayList<Materia> materias = new ArrayList<>();
      
      String sql = " SELECT inscripcion.id_Materia, nombre, nota, Año FROM inscripcion, " + " materia WHERE inscripcion.id_Materia = materia.id_Materia "
              +  " AND  inscripcion.id_Alumnos = ? ";
      
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_Alumnos);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Materia materia=new Materia();
               
                materia.setId_Materia(rs.getInt("id_Materia"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("Año"));
                materias.add(materia); 
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return materias;
  }
   public List <Inscripcion> RecuperarNota (int id_Alumnos){
       ArrayList <Inscripcion> inscripcion= new ArrayList<>();
       
       String sql = "SELECT id_Materia, nota FROM inscripcion  WHERE id_Alumnos = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_Alumnos);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Inscripcion inscrip = new Inscripcion();
                inscrip.setNota(rs.getDouble("nota"));
                inscripcion.add(inscrip);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
            }
        return inscripcion;
   }
   
    public List <Materia> materiasNOCursadas(int id_Alumnos){
      ArrayList <Materia> materias = new ArrayList <>();
         String sql = "SELECT * FROM materia WHERE estado = 1 AND id_Materia not in" + 
                        " (SELECT id_Materia From inscripcion WHERE id_Alumnos = ?)";
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_Alumnos);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Materia materia=new Materia();
                materia.setId_Materia(rs.getInt("id_Materia"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("Año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return materias;
         
  }    
    
    public List<Alumno> AlumnosPorMateria(int id_Materia){
        ArrayList<Alumno> aluMaterias = new ArrayList<>();
        String sql = "SELECT a.id_Alumnos, DNI, a.nombre, apellido, fechaNacimiento, estado "+
                "FROM inscripcion i, alumno a WHERE i.id_Alumnos = a.id_Alumnos AND id_Materia = ? AND a.estado = 1 ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_Materia);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Alumno alumno = new Alumno();
                alumno.setId_Alumnos(rs.getInt("id_Alumnos"));
                alumno.setDNI(rs.getInt("DNI"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                aluMaterias.add(alumno);
            }
            ps.close();
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return aluMaterias;
    }
    
    public List<Map<String, Object>> obtenerMateriasConNotas(int id_Alumnos) {
    List<Map<String, Object>> materiasConNotas = new ArrayList<>();

    String sql = "SELECT m.id_Materia, m.nombre, m.Año, i.nota " +
                 "FROM inscripcion i " +
                 "JOIN materia m ON i.id_Materia = m.id_Materia " +
                 "WHERE i.id_Alumnos = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id_Alumnos);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Map<String, Object> materiaConNota = new HashMap<>();
            materiaConNota.put("id_Materia", rs.getInt("id_Materia"));
            materiaConNota.put("nombre", rs.getString("nombre"));
            materiaConNota.put("Año", rs.getInt("Año"));
            materiaConNota.put("nota", rs.getDouble("nota"));

            materiasConNotas.add(materiaConNota);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
    }

    return materiasConNotas;
}
    
    
}