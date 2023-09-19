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
public class Inscripcion {
   private int id_Inscripcion;
    private double nota;
    private Alumno alumno;
    private Materia materia;

    public Inscripcion() {
    }

    public Inscripcion(double nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getId_Inscripcion() {
        return id_Inscripcion;
    }

    public void setId_Inscripcion(int id_Inscripcion) {
        this.id_Inscripcion = id_Inscripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_Inscripcion=" + id_Inscripcion + ", nota=" + nota + ", alumno=" + alumno + ", materia=" + materia + '}';
        
    }
  }  

