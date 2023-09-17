/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemplos.Entidades.Alumno;
import universidadejemplos.Entidades.Materia;

/**
 *
 * @author Juancho
 */
public class MateriaData {

    private Connection con = null;

    public MateriaData() {
        con = conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materia (nombreN, Año,Estado)"
                + "VALUES(?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId_Materia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia Alistada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
    }

    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombreN = ?, Año = ?, Estado = ? WHERE id:Materia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");
        }
    }

    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET Estado = 0 WHERE id_Materia = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
    }

    public Materia buscarMateria(int id) {
        String sql = "SELECT nombreN, Año FROM materia WHERE id_Materia= ? AND estado = 1 ";
        Materia materia = null;
        try {
            PreparedStatement Ps = con.prepareStatement(sql);
            Ps.setInt(1, id);
            ResultSet rs = Ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setId_Materia(id);
                materia.setNombre(rs.getString("nombreN"));
                materia.setAño(rs.getInt("Año"));
                materia.setEstado(true);
                Ps.close();
            } else {
                JOptionPane.showMessageDialog(null, " No existe la materia ");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

        return materia;

    }

    public Materia buscarMateriaNombre(String nombreN) {
        String sql = "SELECT id_Materia , Año FROM materia WHERE nombreN = ? AND estado = 1 ";
        Materia materia = null;
        try {
            PreparedStatement Ps = con.prepareStatement(sql);
            Ps.setString(1, nombreN);
            ResultSet rs = Ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setId_Materia(rs.getInt("id_Materia"));
                materia.setNombre(nombreN);
                materia.setAño(rs.getInt("Año"));
                materia.setEstado(true);
                Ps.close();
            } else {
                JOptionPane.showMessageDialog(null, " No existe la materia ");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

        return materia;

    }
    
    public List<Materia> buscarAlumnoLista() {
        String sql = "SELECT id_Materia, nombreN,Año , Estado FROM materia WHERE  estado = 1 ";
        ArrayList<Materia> materias = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Materia materia = new Materia();
                materia.setEstado(true);
                materia.setId_Materia(rs.getInt("id_Materia"));
                materia.setAño(rs.getInt("año"));
                materia.setNombre(rs.getString("NombreN"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno1");
        }
        return materias;
    }

}
