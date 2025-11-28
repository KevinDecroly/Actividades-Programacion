import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== REGISTRO DE NUEVO VIDEOCLUB ===");

        String CIF = "";
        String direccion = "";

        // Pedir CIF válido
        while (true) {
            System.out.print("Introduce el CIF del videoclub: ");
            CIF = sc.nextLine().toUpperCase();

            if (CIF.matches("[A-Z]\\d{7}[A-Z]")) {
                break;
            } else {
                System.out.println("ERROR: CIF inválido (Formato: Letra + 7 dígitos + letra).");
            }
        }

        // Dirección no vacía
        while (direccion.isEmpty()) {
            System.out.print("Introduce la dirección del videoclub: ");
            direccion = sc.nextLine();

            if (direccion.isEmpty()) {
                System.out.println("ERROR: La dirección no puede estar vacía.");
            }
        }

        // Crear videoclub
        VideoDaw video = new VideoDaw(CIF, direccion);
        System.out.println("Videoclub registrado correctamente.\n");

        int opcion = 0;

        do {
            System.out.println("=== MENU PRINCIPAL VIDEO DAW ===");
            System.out.println("1. Registrar película");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Alquilar película");
            System.out.println("4. Devolver película");
            System.out.println("5. Dar de baja cliente");
            System.out.println("6. Dar de baja película");
            System.out.println("7. Mostrar información del videoclub");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            // Validar número
            if (!sc.hasNextInt()) {
                System.out.println("Opción no válida");
                sc.nextLine();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar

            switch (opcion) {

                // ==========================
                // 1. REGISTRAR PELÍCULA
                // ==========================
                case 1:
                    System.out.println("\n=== Registrar Película ===");

                    System.out.print("Código (ej. P-0001): ");
                    String cod = sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.println("Género (ACCION, COMEDIA, DRAMA, TERROR, ANIMACION, SCIFI, ROMANCE): ");
                    String generoTexto = sc.nextLine().toUpperCase();

                    Pelicula.Genero genero;

                    try {
                        genero = Pelicula.Genero.valueOf(generoTexto);
                    } catch (Exception e) {
                        System.out.println("Genero inválido.");
                        break;
                    }

                    Pelicula p = new Pelicula(cod, titulo, genero);

                    if (video.registrarPelicula(p)) {
                        System.out.println("Película registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar la película.");
                    }

                    break;

                // ==========================
                // 2. REGISTRAR CLIENTE
                // ==========================
                case 2:
                    System.out.println("\n=== Registrar Cliente ===");

                    System.out.print("DNI (Ej: 12345678A): ");
                    String dni = sc.nextLine().toUpperCase();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Número de socio (Ej. S-0001): ");
                    String numSocio = sc.nextLine();

                    System.out.print("Dirección: ");
                    String dirCliente = sc.nextLine();

                    System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
                    String fechaTexto = sc.nextLine();

                    LocalDate fechaNac;
                    try {
                        fechaNac = LocalDate.parse(fechaTexto);
                    } catch (Exception e) {
                        System.out.println("Fecha inválida.");
                        break;
                    }

                    Cliente c = new Cliente(dni, nombre, numSocio, dirCliente, fechaNac);

                    if (video.registrarCliente(c)) {
                        System.out.println("Cliente registrado correctamente.");
                    } else {
                        System.out.println("No se pudo registrar el cliente.");
                    }

                    break;

                // ==========================
                // 3. ALQUILAR PELÍCULA
                // ==========================
                case 3:
                    System.out.println("\n=== Alquilar Película ===");

                    System.out.print("Introduce código de película: ");
                    String codigoAlq = sc.nextLine();

                    System.out.print("Introduce DNI cliente: ");
                    String dniAlq = sc.nextLine();

                    Pelicula peliculaAlq = null;
                    Cliente clienteAlq = null;

                    // Buscar película
                    for (int i = 0; i < video.peliculasRegistradas.length; i++) {
                        if (video.peliculasRegistradas[i] != null &&
                                video.peliculasRegistradas[i].getCod().equalsIgnoreCase(codigoAlq)) {
                            peliculaAlq = video.peliculasRegistradas[i];
                        }
                    }

                    // Buscar cliente
                    for (int i = 0; i < video.clientesRegistrados.length; i++) {
                        if (video.clientesRegistrados[i] != null &&
                                video.clientesRegistrados[i].getDNI().equalsIgnoreCase(dniAlq)) {
                            clienteAlq = video.clientesRegistrados[i];
                        }
                    }

                    if (video.alquilarPelicula(peliculaAlq, clienteAlq))
                        System.out.println("Película alquilada correctamente.");

                    break;

                // ==========================
                // 4. DEVOLVER PELÍCULA
                // ==========================
                case 4:
                    System.out.println("\n=== Devolver Película ===");

                    System.out.print("Código película: ");
                    String codDev = sc.nextLine();

                    System.out.print("DNI del cliente: ");
                    String dniDev = sc.nextLine();

                    Pelicula peliculaDev = null;
                    Cliente clienteDev = null;

                    // Buscar película
                    for (int i = 0; i < video.peliculasRegistradas.length; i++) {
                        if (video.peliculasRegistradas[i] != null &&
                                video.peliculasRegistradas[i].getCod().equalsIgnoreCase(codDev)) {
                            peliculaDev = video.peliculasRegistradas[i];
                        }
                    }

                    // Buscar cliente
                    for (int i = 0; i < video.clientesRegistrados.length; i++) {
                        if (video.clientesRegistrados[i] != null &&
                                video.clientesRegistrados[i].getDNI().equalsIgnoreCase(dniDev)) {
                            clienteDev = video.clientesRegistrados[i];
                        }
                    }

                    if (video.devolverPelicula(peliculaDev, clienteDev))
                        System.out.println("Película devuelta correctamente.");

                    break;

                // ==========================
                // 5. DAR DE BAJA CLIENTE
                // ==========================
                case 5:
                    System.out.println("\n=== Dar de baja cliente ===");

                    System.out.print("DNI: ");
                    String dniBaja = sc.nextLine();

                    Cliente clienteBaja = null;

                    for (int i = 0; i < video.clientesRegistrados.length; i++) {
                        if (video.clientesRegistrados[i] != null &&
                                video.clientesRegistrados[i].getDNI().equalsIgnoreCase(dniBaja)) {
                            clienteBaja = video.clientesRegistrados[i];
                        }
                    }

                    if (video.darBajaCliente(clienteBaja))
                        System.out.println("Cliente dado de baja correctamente.");
                    else
                        System.out.println("No se encontró el cliente.");

                    break;

                // ==========================
                // 6. DAR DE BAJA PELÍCULA
                // ==========================
                case 6:
                    System.out.println("\n=== Dar de baja película ===");

                    System.out.print("Código película: ");
                    String codBaja = sc.nextLine();

                    Pelicula peliculaBaja = null;

                    for (int i = 0; i < video.peliculasRegistradas.length; i++) {
                        if (video.peliculasRegistradas[i] != null &&
                                video.peliculasRegistradas[i].getCod().equalsIgnoreCase(codBaja)) {
                            peliculaBaja = video.peliculasRegistradas[i];
                        }
                    }

                    if (peliculaBaja != null) {
                        peliculaBaja.setFechaBaja(LocalDate.now());
                        System.out.println("Película dada de baja.");
                    } else {
                        System.out.println("No se encontró la película.");
                    }

                    break;

                // ==========================
                // 7. MOSTRAR INFO VIDEOCLUB
                // ==========================
                case 7:
                    System.out.println(video.infoVideoClub());
                    System.out.println(video.infoPeliculasRegistradas());
                    System.out.println(video.infoClientesRegistrados());
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 8);

        sc.close();
    }
}
