import java.io.*;
import java.util.*;

public class Biblioteca {

    private Map<String, Libro> libros;
    private final String Fichero = "Biblioteca.dat";

    public Biblioteca() {
        libros = cargar();
    }

    public boolean agregarLibro(Libro libro) {
        if (libros.containsKey(libro.getIsbn())) {
            return false; // ISBN ya existe
        }
        libros.put(libro.getIsbn(), libro);
        return true;
    }

    public boolean eliminarLibro(String isbn) {
        return libros.remove(isbn) != null;
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            libros.values().forEach(System.out::println);
        }
    }

    public void guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Fichero))) {
            oos.writeObject(libros);
            System.out.println("Libros guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Libro> cargar() {
        File fichero = new File(Fichero);

        if (!fichero.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            return (Map<String, Libro>) ois.readObject();
        } catch (EOFException e) {
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
            return new HashMap<>();
        }
    }
}
