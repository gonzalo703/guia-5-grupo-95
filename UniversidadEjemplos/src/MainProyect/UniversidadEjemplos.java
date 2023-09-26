
package MainProyect;

import conexion.AlumnoData;
import Universidad.Entidades.Alumno;
import Universidad.Entidades.Inscripcion;
import Universidad.Entidades.Materia;
import conexion.InscripcionData;
import conexion.MateriaData;


public class UniversidadEjemplos {
    
    
    public static void main(String[] args) {
        AlumnoData alu = new AlumnoData();
        MateriaData mate= new MateriaData();
        InscripcionData isnc = new InscripcionData();
        
        //guardar inscripcion
//        Alumno ricardo=alu.buscarAlumno(32);
//        Materia mat = mate.buscarMateria(4);
//        Inscripcion isncripcion = new Inscripcion(8,ricardo, mat);
//        isnc.guardarinscripcion(isncripcion);
//        isnc.actualizarNota(4, 4, 4);
//        isnc.borrarInscricion(4, 4);
//        for(Inscripcion ins:isnc.obtenerInscripciones()){
//            System.out.println("id" +ins.getId_Inscripcion());
//            System.out.println("materia"+ins.getMateria());
//            System.out.println("nombre"+ins.getAlumno());
//        }
//    for(Inscripcion ins:isnc.obtenerInscripcionesAlumno(32)){
//        System.out.println("nombre"+ins.getMateria());
//        System.out.println("nota"+ins.getNota());
//    }
//    for(Alumno ins:isnc.AlumnosPorMateria(3)){
//        System.out.println("id"+ins.getId_Alumnos());
//        System.out.println("Nombre"+ins.getNombre());
//        System.out.println("Apellido"+ins.getApellido());
//        System.out.println("DNI: " +ins.getDNI());
//    }
//     for(Materia matins:isnc.materiasCursadas(32) ){
//         System.out.println("nombre: " +matins.getNombre());
//         System.out.println("id: "+matins.getId_Materia());
//    }
//    for (Materia matn: isnc.materiasNOCursadas(4)){
//        System.out.println("nombre : " +matn.getNombre());
//        System.out.println("Año : " +matn.getAño());
//    }
//        Materia mat1= new Materia (5, "PEPE", 2, true);
//         mate.modificarMateria(mat1);
  }
    
}
