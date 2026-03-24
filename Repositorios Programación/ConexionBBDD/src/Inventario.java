import java.util.List;
import java.util.Scanner;

public class Inventario {

    static Scanner sc = new Scanner(System.in);
    static ProductoDAO dao = new ProductoDAO();

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {

                    case 1:
                        List<Producto> lista = dao.mostrarProductos();
                        for (Producto p : lista) {
                            System.out.println(p);
                        }
                        break;

                    case 2:
                        System.out.print("Referencia: ");
                        String ref = sc.nextLine();
                        System.out.println(dao.buscarPorReferencia(ref));
                        break;

                    case 5:
                        insertarProducto();
                        break;

                    case 6:
                        System.out.print("Referencia a eliminar: ");
                        String r = sc.nextLine();
                        dao.eliminarProducto(r);
                        System.out.println("Producto eliminado");
                        break;

                    case 9:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida");
                }

            } catch (ExcepcionProducto e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error general: " + e.getMessage());
            }

        } while (opcion != 9);
    }

    public static void mostrarMenu() {
        System.out.println("\n--- INVENTARIO ---");
        System.out.println("1. Mostrar productos");
        System.out.println("2. Buscar por referencia");
        System.out.println("3. Buscar por tipo");
        System.out.println("4. Buscar por cantidad");
        System.out.println("5. Insertar producto");
        System.out.println("6. Eliminar producto");
        System.out.println("7. Actualizar producto");
        System.out.println("8. Insertar tipo");
        System.out.println("9. Salir");
    }

    public static void insertarProducto() throws Exception {

        System.out.print("Referencia: ");
        String ref = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Descripción: ");
        String desc = sc.nextLine();

        System.out.print("Tipo: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        if (cantidad < 0) {
            throw new ExcepcionProducto("Cantidad inválida");
        }

        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.print("Descuento: ");
        int descuento = sc.nextInt();
        sc.nextLine();

        System.out.print("IVA: ");
        int iva = sc.nextInt();
        sc.nextLine();

        System.out.print("Aplicar descuento (true/false): ");
        boolean aplicar = sc.nextBoolean();
        sc.nextLine();

        Producto p = new Producto(ref, nombre, desc, tipo, cantidad,
                precio, descuento, iva, aplicar);

        dao.insertarProducto(p);

        System.out.println("Producto insertado correctamente");
    }
}