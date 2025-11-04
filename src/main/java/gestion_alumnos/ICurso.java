package gestion_alumnos;

import java.util.Scanner;

public interface ICurso {
    boolean isInTheList(String DNI);
    String addAlumnoToList(Alumno alumno);
    String deleteAlumno(String DNI);
    String modifyAlumno(String DNI, int campoToChange, String newValue);
    void showEveryAlumno();
    String changeNota(String DNI, int nota);
    String notaNumericaALetra(int nota);
    String showAlumnosByNota();
    void createAlumno(Scanner sc);
}
