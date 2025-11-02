package gestion_alumnos;

public class Alumno {

    String nombre;
    String apellidos;
    String DNI;
    int nota_numerica;
    String nota_letra;

    public Alumno() {
    }

    public Alumno(String nombre, String apellidos, String DNI, int nota_numerica, String nota_letra) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.nota_numerica = nota_numerica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getNota_numerica() {
        return nota_numerica;
    }

    public void setNota_numerica(int nota_numerica) {
        this.nota_numerica = nota_numerica;
    }

    public String getNota_letra() {
        return nota_letra;
    }

    public void setNota_letra(String nota_letra) {
        this.nota_letra = nota_letra;
    }

    @Override
    public String toString() {
        return "Alumno: " + nombre + " " + apellidos + "\n"
                +"DNI: " + DNI + "\n"
                +"Nota numérica: " + nota_numerica + "\n"
                + "Nota en letra: " + nota_letra + "\n" ;
    }
}
