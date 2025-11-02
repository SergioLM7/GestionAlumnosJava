package gestion_alumnos;

public interface ICurso {
    boolean isInTheList(String DNI);
    String addAlumno(Alumno alumno);
    String deleteAlumno(String DNI);
    String modifyAlumno(String DNI, int campoToChange, String newValue);
    void showEveryAlumno();
    String changeNota(String DNI, int nota);
    String notaNumericaALetra(int nota);
    String showAlumnosByNota();
}
