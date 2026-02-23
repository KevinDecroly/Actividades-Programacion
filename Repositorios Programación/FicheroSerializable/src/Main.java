import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        do {
            System.out.println("\nMENÚ BIBLIOTECA");
            System.out.println("1. Crear Libro");
            System.out.println("2. Mostrar Libros");
            System.out.println("3. Eliminar Libro por ISBN");
            System.out.println("4. Guardar Libros");
            System.out.println("5. Guardar y Salir");
            System.out.print("Seleccione opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Fecha publicación (dd/MM/yyyy): ");
                    String fechaStr = sc.nextLine();

                    try {
                        LocalDate fecha = LocalDate.parse(fechaStr,
                                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        Libro libro = new Libro(isbn, titulo, autor, fecha);

                        if (biblioteca.agregarLibro(libro)) {
                            System.out.println("Libro añadido correctamente.");
                        } else {
                            System.out.println("Error: ISBN ya existente.");
                        }

                    } catch (Exception e) {
                        System.out.println("Fecha inválida.");
                    }
                    break;

                case 2:
                    biblioteca.mostrarLibros();
                    break;

                case 3:
                    System.out.print("ISBN a eliminar: ");
                    String isbnEliminar = sc.nextLine();

                    if (biblioteca.eliminarLibro(isbnEliminar)) {
                        System.out.println("Libro eliminado.");
                    } else {
                        System.out.println("No existe ese ISBN.");
                    }
                    break;

                case 4:
                    biblioteca.guardar();
                    break;

                case 5:
                    biblioteca.guardar();
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}