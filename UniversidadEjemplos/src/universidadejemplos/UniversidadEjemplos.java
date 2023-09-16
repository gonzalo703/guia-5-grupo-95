
package universidadejemplos;

import conexion.AlumnoData;
import universidadejemplos.Entidades.Alumno;


public class UniversidadEjemplos {
    
    
    public static void main(String[] args) {
        AlumnoData alu = new AlumnoData();

        
    

    for (Alumno alumno : alu.buscarAlumnoLista()){
        System.out.println("DNI: " +alumno.getDNI());
    }

    }
    
}
