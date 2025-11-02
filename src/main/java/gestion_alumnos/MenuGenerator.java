package gestion_alumnos;

public class MenuGenerator {

    private MenuGenerator(){
    }

    public static void printMenu() {
        String menu = """
            Selecciona una de las siguientes opciones (escribe el número)
            1. Añadir nuevo alumno
            2. Borrar alumno
            3. Modificar alumno
            4. Mostrar todos los alumnos
            5. Cambiar nota numérica de un alumno
            6. Mostrar total alumnos según su nota
            7. Salir
            """;
        System.out.println(menu);
    }
}
