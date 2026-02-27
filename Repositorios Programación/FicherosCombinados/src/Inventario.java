import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    static ArrayList<Producto> lista = new ArrayList<>();

    public static void main(String[] args) {

        // CARGA AUTOMÁTICA AL INICIAR
        cargarCSV();
        cargarBinario();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {

            System.out.println("\n1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir (inventario.dat).");
            System.out.println("4. Registrar producto en el Inventario.");
            System.out.print("Opcion: ");

            try {

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        mostrar();
                        break;

                    case 2:
                        eliminar(sc);
                        break;

                    case 3:
                        guardar();
                        break;

                    case 4:
                        registrar(sc);
                        break;

                    default:
                        throw new Exception("Opcion incorrecta");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcion != 3);

        sc.close();
    }

    // =============================
    // CARGAR CSV (Unicode)
    // =============================
    public static void cargarCSV() {

        try {

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("productos.csv"), "UTF-8"));

            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) continue;

                String[] d = linea.split(",");

                Producto p = new Producto(
                        d[0], d[1], d[2],
                        0,
                        Double.parseDouble(d[3]),
                        Integer.parseInt(d[4]),
                        Integer.parseInt(d[5]),
                        Boolean.parseBoolean(d[6])
                );

                lista.add(p);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =============================
    // CARGAR BINARIO
    // =============================
    public static void cargarBinario() {

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("almacen.dat"));

            while (true) {
                Producto p = (Producto) ois.readObject();
                lista.add(p);
            }

        } catch (EOFException e) {
            // Fin normal del fichero
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =============================
    // MOSTRAR
    // =============================
    public static void mostrar() {

        if (lista.isEmpty()) {
            System.out.println("No hay productos cargados.");
        } else {
            for (Producto p : lista) {
                System.out.println(p);
            }
        }
    }

    // =============================
    // ELIMINAR
    // =============================
    public static void eliminar(Scanner sc) throws Exception {

        System.out.print("Referencia: ");
        String ref = sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getReferencia().equals(ref)) {
                lista.remove(i);
                encontrado = true;
                System.out.println("Producto eliminado.");
                break;
            }
        }

        if (!encontrado)
            throw new Exception("Producto no encontrado");
    }

    // =============================
    // REGISTRAR
    // =============================
    public static void registrar(Scanner sc) throws Exception {

        System.out.print("Referencia: ");
        String ref = sc.nextLine();

        for (Producto p : lista) {
            if (p.getReferencia().equals(ref))
                throw new Exception("Referencia repetida");
        }

        System.out.print("Descripcion: ");
        String desc = sc.nextLine();

        Producto nuevo = new Producto(ref, desc, "General",
                0, 10.0, 0, 21, false);

        lista.add(nuevo);
        System.out.println("Producto registrado.");
    }

    // =============================
    // GUARDAR
    // =============================
    public static void guardar() {

        try {

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("inventario.dat"));

            for (Producto p : lista) {
                oos.writeObject(p);
            }

            oos.close();
            System.out.println("Inventario guardado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}