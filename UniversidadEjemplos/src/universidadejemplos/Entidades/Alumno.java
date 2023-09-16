
package universidadejemplos.Entidades;

import java.time.LocalDate;


public class Alumno {
    //chicos la entidad alumno no deveria tener dni ? 
  private int idAlumno;
  private String apellido;
  private String nombre;
  private LocalDate fechaNac;  
  private boolean estado;

    public Alumno() {
    }

    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fechaNac, boolean estado) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.estado = estado;
    }

    public Alumno(String apellido, String nombre, LocalDate fechaNac, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.estado = estado;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }

    public int getDNI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFechaNacimiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_Alumno(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_Alumno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDNI(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFechaNacimiento(LocalDate toLocalDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
