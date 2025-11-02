# Gestión de Alumnos - Java

Este proyecto es un programa en **Java** diseñado para la **gestión académica de una clase** mediante una estructura de datos dinámica (Lista), sin imponer un límite máximo en el número de alumnos.

## 🌟 Características Principales

El programa implementa dos clases principales (`Alumno` y `Curso`) y ofrece un menú interactivo por consola para realizar diversas operaciones de gestión.

### 📝 Estructura de Datos

* **Clase `Alumno`**: Almacena la información individual de cada estudiante.
    * `Nombre`
    * `Apellidos`
    * `DNI`
    * `Nota en Número` (tipo `double`)
    * `Nota en Letra` (tipo `String`)

* **Clase `Curso`**: Contiene la lógica de gestión. Su principal atributo es una **Lista (`List<Alumno>`)** que permite almacenar un número variable de objetos `Alumno`.

---

## 🛠️ Requisitos del Sistema

* **Java Development Kit (JDK):** Versión 8 o superior.
* **Entorno de Desarrollo Integrado (IDE):** Recomendado IntelliJ IDEA, Eclipse o VS Code.

---

## 🚀 Uso e Instalación

1.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/SergioLM7/GestionAlumnosJava/
    cd gestionAlumnos
    ```

2.  **Compilar:**
    Navega hasta la carpeta `src` (o la carpeta raíz donde se encuentren tus archivos `.java`) y compila:
    ```bash
    javac -d bin src/*.java
    ```
    *(Ajusta la ruta si tu estructura de carpetas es diferente)*

3.  **Ejecutar:**
    Ejecuta el programa principal desde el directorio bin:
    ```bash
    java -cp bin Main
    ```
    
Una vez ejecutado, el programa mostrará el menú de opciones en la consola.

---

## 📖 Menú de Operaciones

El programa ofrece las siguientes funcionalidades accesibles desde el menú principal por consola:

1.  **Añadir Nuevo Alumno:** Permite ingresar los datos (Nombre, Apellidos, DNI, Nota en número) para crear y añadir un nuevo objeto `Alumno` a la lista.
2.  **Borrar Alumno Existente:** Permite eliminar un alumno de la lista. El borrado se realiza en base al DNI.
3.  **Cambiar Algún Dato de Algún Alumno:** Permite seleccionar un alumno y modificar:
    - Nombre
    - Apellidos
    - Nota numérica
5.  **Mostrar Todos los Datos de Todos los Alumnos:** Itera sobre la lista y muestra la información completa de cada alumno de forma individual.
6.  **Actualizar Notas en Letra:** Recalcula y actualiza el campo `nota_letra` para *todos* los alumnos de la lista basándose en su `nota_numerica`, utilizando la siguiente escala:
    * **No Presentado:** Nota < 0
    * **Suspenso:** Nota < 5.0
    * **Aprobado:** Nota < 7.0
    * **Notable:** Nota < 9.0
    * **Sobresaliente:** Nota < 10.0
    * **Matrícula de Honor:** Nota = 10.0
7.  **Mostrar Estadísticas de Notas:** Calcula y muestra:
    * El **total de alumnos** en cada categoría de nota (Suspenso, Aprobado, etc.).
    * El **porcentaje** que cada categoría supone respecto al **total de alumnos** en la lista (excluyendo la categoría "No Presentado").

---
