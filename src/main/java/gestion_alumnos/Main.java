package gestion_alumnos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select;
        String respuesta;
        CursoImpl curso = new CursoImpl(new ArrayList<>());
        boolean isInTheList;
        String DNI;
        String newValue;
        int campoToChange;

        do {
            MenuGenerator.printMenu();
            select = sc.nextInt();
            sc.nextLine();

            switch(select) {
                case 1 -> {
                    Alumno alumno = new Alumno();
                    System.out.println("Introduce un nombre: ");
                    alumno.setNombre(sc.nextLine());
                    System.out.println("Introduce los apellidos: ");
                    alumno.setApellidos(sc.nextLine());
                    System.out.println("Introduce un DNI: ");
                    alumno.setDNI(sc.nextLine());
                    System.out.println("Introduce un nota númerica: ");
                    alumno.setNota_numerica(sc.nextInt());
                    String respuesta1 = curso.addAlumno(alumno);
                    System.out.println(respuesta1);
                }
                case 2 -> {
                    System.out.println("Introduce el DNI del alumno a borrar: ");
                    respuesta = curso.deleteAlumno(sc.nextLine());
                    System.out.println(respuesta);
                }
                case 3 -> {
                    System.out.println("Introduce el DNI del alumno a modificar: ");
                    DNI = sc.nextLine();
                    isInTheList = curso.isInTheList(DNI);
                    if (isInTheList) {
                        System.out.println("Introduce el número del campo a modificar: " + "\n"
                        + "1.Nombre \n 2.Apellidos \n 3.Nota numérica");
                        try {
                            campoToChange = Integer.parseInt(sc.nextLine());
                            System.out.println("Introduce el nuevo valor del campo elegido: ");
                            newValue = sc.nextLine();
                            respuesta = curso.modifyAlumno(DNI, campoToChange, newValue);
                            System.out.println(respuesta);
                        } catch (Exception e) {
                            System.out.println("El valor introducido no es válido.");
                            select = 7;
                        }
                    } else {
                        System.out.println("El DNI introducido no corresponde con ningún alumno registrado.");
                    }
                }
                case 4 -> curso.showEveryAlumno();
                case 5 -> {
                    System.out.println("Introduce el DNI del alumno a modificar: ");
                    DNI = sc.nextLine();
                    isInTheList = curso.isInTheList(DNI);
                    if (isInTheList) {

                        System.out.println("Introduce la nueva nota del alumno en cifra entera (0-10): ");
                        int nuevaNota = sc.nextInt();
                        while (nuevaNota < 0 || nuevaNota > 10) {
                            System.out.println("Introduce la nueva nota del alumno en cifra entera (0-10): ");
                            nuevaNota = sc.nextInt();
                        }
                        String respuesta3 = curso.changeNota(DNI, nuevaNota);
                        System.out.println(respuesta3);
                    } else {
                        System.out.println("El DNI introducido no corresponde con ningún alumno registrado.");
                    }
                }
                case 6 -> System.out.println(curso.showAlumnosByNota());
                case 7 -> {
                    System.out.println("Gracias por utilizar nuestro gestor de alumnos. Hasta pronto");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Esa opción no existe. Vuelve a intentarlo");
                    MenuGenerator.printMenu();
                }
            }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

        } while (select != 7);
    }
}
