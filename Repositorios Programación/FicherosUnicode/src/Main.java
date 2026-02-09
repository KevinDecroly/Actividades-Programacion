import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FICHERO = "Almacen.txt";

    public static void main(String[] args) {

        // Cargar productos al iniciar
        cargarDesdeFichero();

        int opcion;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar productos existentes");
            System.out.println("3. Eliminar producto por código");
            System.out.println("4. Guardar productos en el fichero");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> mostrarProductos();
                case 3 -> eliminarProducto();
                case 4 -> guardarEnFichero();
                case 5 -> {
                    guardarEnFichero();
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 5);
    }

    // 1. Crear producto
    public static void crearProducto() {
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        Producto p = new Producto(codigo, nombre, cantidad, precio);
        listaProductos.add(p);

        System.out.println("Producto creado correctamente.");
    }

    // 2. Mostrar productos
    public static void mostrarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            for (Producto p : listaProductos) {
                System.out.println(p);
            }
        }
    }

    // 3. Eliminar producto
    public static void eliminarProducto() {
        System.out.print("Código del producto a eliminar: ");
        String codigo = sc.nextLine();

        Iterator<Producto> it = listaProductos.iterator();
        boolean eliminado = false;

        while (it.hasNext()) {
            Producto p = it.next();
            if (p.getCodigo().equals(codigo)) {
                it.remove();
                eliminado = true;
                System.out.println("Producto eliminado.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("Producto no encontrado.");
        }
    }

    // 4. Guardar en fichero de texto
    public static void guardarEnFichero() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO))) {

            for (Producto p : listaProductos) {
                pw.println(p.toLineaFichero());
            }

            System.out.println("Productos guardados en el fichero.");

        } catch (IOException e) {
            System.out.println("Error al guardar el fichero.");
        }
    }

    // Cargar desde fichero de texto
    public static void cargarDesdeFichero() {
        File fichero = new File(FICHERO);

        if (!fichero.exists()) {
            System.out.println("No existe el fichero. Almacén vacío.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                String codigo = datos[0];
                String nombre = datos[1];
                int cantidad = Integer.parseInt(datos[2]);
                double precio = Double.parseDouble(datos[3]);

                Producto p = new Producto(codigo, nombre, cantidad, precio);
                listaProductos.add(p);
            }

            System.out.println("Productos cargados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al cargar el fichero.");
        }
    }
}
