
package universidadejemplos.Entidades;

import java.time.LocalDate;


public class Alumno {
    private int id_Alumnos;
    private int DNI;
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private boolean Estado;  
    
    public Alumno() {
    }

    public Alumno(int id_Alumnos, int DNI, String apellido, String nombre, LocalDate fechaNacimiento, boolean Estado) {
        this.id_Alumnos = id_Alumnos;
        this.DNI = DNI;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.Estado = Estado;
    }

    public Alumno(int DNI, String apellido, String nombre, LocalDate fechaNacimiento, boolean Estado) {
        this.DNI = DNI;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.Estado = Estado;
    }

    public int getId_Alumnos() {
        return id_Alumnos;
    }

    public void setId_Alumnos(int id_Alumno) {
        this.id_Alumnos = id_Alumnos;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "id_Alumnos=" + id_Alumnos + ", DNI=" + DNI + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
  
}
