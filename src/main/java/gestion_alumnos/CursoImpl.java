package gestion_alumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoImpl implements ICurso {

    private List<Alumno> listaAlumnos;

    public CursoImpl(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public boolean isInTheList(String dni) {
        boolean isInTheList = false;

        for(Alumno al : listaAlumnos) {
            if(al.DNI.equals(dni)) {
                isInTheList = true;
                break;
            }
        }
        return isInTheList;
    }

    @Override
    public String addAlumno(Alumno alumno) {
        if(!isInTheList(alumno.DNI)) {
            alumno.setNota_letra(notaNumericaALetra(alumno.nota_numerica));
            listaAlumnos.add(alumno);
            return "Alumno añadido con éxito";
        } else {
            return "Este alumno ya está registrado";
        }
    }

    @Override
    public String deleteAlumno(String DNI) {
        if(isInTheList(DNI)) {
            for (Alumno al : listaAlumnos) {
                if (al.DNI.equals(DNI)) {
                    listaAlumnos.remove(al);
                    return "Alumno eliminado con éxito";
                }
            }
        }
        return "El alumno indicado no existe";
    }

    @Override
    public String modifyAlumno (String DNI, int campoToChange, String newValue) {
        Alumno alumnoToChange;
        Optional<Alumno> optionalAlumno = listaAlumnos.stream()
                .filter(al -> al.getDNI().equals(DNI))
                .findFirst();

        if (optionalAlumno.isPresent()) {
            alumnoToChange = optionalAlumno.get();
            switch (campoToChange) {
                case 1 -> {
                    alumnoToChange.setNombre(newValue);
                    return "Alumno " + alumnoToChange.getDNI() + " modificado con éxito";
                }
                case 2 -> {
                    alumnoToChange.setApellidos(newValue);
                    return "Alumno " + alumnoToChange.getDNI() + " modificado con éxito";
                }
                case 3 -> {
                    alumnoToChange.setNota_numerica(Integer.parseInt(newValue));
                    alumnoToChange.setNota_letra(notaNumericaALetra(alumnoToChange.nota_numerica));
                    return "Alumno " + alumnoToChange.getDNI() + " modificado con éxito";
                }
                default -> {
                    return "El valor introducido no es válido.";
                }
            }

        }
        return "El DNI del alumno introducido no existe en nuestros registros.";
    }

    @Override
    public void showEveryAlumno() {
        for(Alumno alumno : listaAlumnos) {
            System.out.println(alumno.toString());
        }
    }

    @Override
    public String changeNota(String DNI, int nota) {
        if(isInTheList(DNI)) {
            for (Alumno al : listaAlumnos) {
                if (al.DNI.equals(DNI)) {
                    al.setNota_numerica(nota);
                    al.setNota_letra(notaNumericaALetra(nota));
                    return "Nota modificada con éxito";
                }
            }
        }
        return "El DNI introducido no existe";
    }

    @Override
    public String notaNumericaALetra(int nota) {
        if(nota == 0) {
            return "NP";
        } else if (nota > 0 && nota < 5) {
            return "SUS";
        } else if (nota >= 5 && nota < 7) {
            return "AP";
        } else if (nota >= 7 && nota < 9) {
            return "NOT";
        } else if (nota == 9) {
            return "SOB";
        } else if (nota == 10) {
            return "MH";
        }

        return "";
    }

    @Override
    public String showAlumnosByNota() {
        List<Alumno> suspensos = new ArrayList<>();
        List<Alumno> aprobados = new ArrayList<>();
        List<Alumno> notables = new ArrayList<>();
        List<Alumno> sobresalientes = new ArrayList<>();
        List<Alumno> matriculas = new ArrayList<>();

        int totalAlumnosPresentados = 0;

        for(Alumno alumno : listaAlumnos) {

            switch(alumno.nota_letra) {
                case "SUS" -> suspensos.add(alumno);
                case "AP" -> aprobados.add(alumno);
                case "NOT" -> notables.add(alumno);
                case "SOB" -> sobresalientes.add(alumno);
                case "MH" -> matriculas.add(alumno);
            }

        }

        totalAlumnosPresentados = suspensos.toArray().length + aprobados.toArray().length + notables.toArray().length + sobresalientes.toArray().length + matriculas.toArray().length ;

        return "Suspensos: " + suspensos.toArray().length + "(" + calcularPorcentaje(totalAlumnosPresentados, suspensos.toArray().length) + "%)" + "\n"
        + "Aprobados: " + aprobados.toArray().length + "(" + calcularPorcentaje(totalAlumnosPresentados, aprobados.toArray().length) + "%)" +  "\n"
        + "Notables: " + notables.toArray().length + "(" + calcularPorcentaje(totalAlumnosPresentados, notables.toArray().length) + "%)" +  "\n"
        + "Sobresalientes: " + sobresalientes.toArray().length + "(" + calcularPorcentaje(totalAlumnosPresentados, sobresalientes.toArray().length) + "%)" +  "\n"
                + "Matrículas de Honor: " + matriculas.toArray().length + "(" + calcularPorcentaje(totalAlumnosPresentados, matriculas.toArray().length) + "%)" +  "\n";

    }

    private int calcularPorcentaje(int total, int parcial) {
        return (parcial * 100) / total;
    }
}
