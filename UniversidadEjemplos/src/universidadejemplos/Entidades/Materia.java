/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplos.Entidades;

/**
 *
 * @author yo
 */
public class Materia {
   private int id_Materia;
    private String nombre;
    private int Año;
    private boolean Estado;

    public Materia() {
    }

    public Materia(int id_Materia, String nombre, int Año, boolean Estado) {
        this.id_Materia = id_Materia;
        this.nombre = nombre;
        this.Año = Año;
        this.Estado = Estado;
    }

    public Materia(String nombre, int Año, boolean Estado) {
        this.nombre = nombre;
        this.Año = Año;
        this.Estado = Estado;
    }

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "id_Materia=" + id_Materia + ", nombre=" + nombre + ", A\u00f1o=" + Año + '}';
    } 
}