import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("REGISTRO DE NUEVO VIDEOCLUB");

        String CIF = "";
        String direccion = "";

        // Pedir CIF válido
        while (true) {
            System.out.print("Introduce el CIF del videoclub: ");
            CIF = sc.nextLine().toUpperCase();
            if (CIF.matches("[A-Z][1-9]{7}[A-Z 0-9]"))
                break;
            System.out.println("ERROR: CIF inválido (Formato: Letra + 7 numeros + número o letra de control).");
        }

        // Pedir dirección no vacía
        while (direccion.isEmpty()) {
            System.out.print("Introduce la dirección del videoclub: ");
            direccion = sc.nextLine();
            if (direccion.isEmpty()) System.out.println("ERROR: La dirección no puede estar vacía.");
        }

        // Crear el videoclub
        VideooDaw video = new VideooDaw(CIF, direccion);
        System.out.println("Videoclub registrado correctamente.\n");

        int opcion = 0;

        do {
            // Mostrar menú principal
            System.out.println("\n MENU PRINCIPAL");
            System.out.println("1. Registrar película");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Alquilar película");
            System.out.println("4. Devolver película");
            System.out.println("5. Dar de baja cliente");
            System.out.println("6. Dar de baja película");
            System.out.println("7. Mostrar información del videoclub");
            System.out.println("8. Salir");
            System.out.print("Elige opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Opción no válida.");
                sc.nextLine();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    // Registrar película
                    System.out.print("Código: ");
                    String cod = sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Género (ACCION, COMEDIA, DRAMA, TERROR, ANIMACION, SCIFI, ROMANCE): ");
                    String generoTxt = sc.nextLine().toUpperCase();
                    try {
                        Pelicula.Genero genero = Pelicula.Genero.valueOf(generoTxt);
                        Pelicula p = new Pelicula(cod, titulo, genero);
                        if (video.registrarPelicula(p)) System.out.println("Película registrada correctamente.");
                        else System.out.println("No se pudo registrar la película.");
                    } catch (Exception e) {
                        System.out.println("Género inválido.");
                    }
                    break;

                case 2:
                    // Registrar cliente
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número de socio: ");
                    String numSocio = sc.nextLine();
                    System.out.print("Dirección: ");
                    String dirCliente = sc.nextLine();
                    System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
                    try {
                        LocalDate fechaNac = LocalDate.parse(sc.nextLine());
                        Cliente c = new Cliente(dni, nombre, numSocio, dirCliente, fechaNac);
                        if (video.registrarCliente(c)) System.out.println("Cliente registrado correctamente.");
                        else System.out.println("No se pudo registrar el cliente.");
                    } catch (Exception e) {
                        System.out.println("Fecha inválida.");
                    }
                    break;

                case 3:
                    // Alquilar película
                    System.out.print("Introduce código de película: ");
                    String codA = sc.nextLine();
                    System.out.print("Introduce DNI cliente: ");
                    String dniA = sc.nextLine();
                    Pelicula pa = video.buscarPelicula(codA);
                    Cliente ca = video.buscarCliente(dniA);
                    if (pa != null && ca != null) {
                        if (video.alquilarPelicula(pa, ca)) System.out.println("Película alquilada correctamente.");
                        else System.out.println("No se pudo alquilar la película.");
                    } else {
                        System.out.println("Película o cliente no encontrados.");
                    }
                    break;

                case 4:
                    // Devolver película
                    System.out.print("Introduce código de película: ");
                    String codD = sc.nextLine();
                    System.out.print("Introduce DNI cliente: ");
                    String dniD = sc.nextLine();
                    Pelicula pd = video.buscarPelicula(codD);
                    Cliente cd = video.buscarCliente(dniD);
                    if (pd != null && cd != null) {
                        if (video.devolverPelicula(pd, cd)) System.out.println("Película devuelta correctamente.");
                        else System.out.println("No se pudo devolver la película.");
                    } else {
                        System.out.println("Película o cliente no encontrados.");
                    }
                    break;

                case 5:
                    // Dar de baja cliente
                    System.out.print("DNI cliente a dar de baja: ");
                    String dniBaja = sc.nextLine();
                    Cliente clienteBaja = video.buscarCliente(dniBaja);
                    if (clienteBaja != null) {
                        video.darBajaCliente(clienteBaja);
                        System.out.println("Cliente dado de baja correctamente.");
                    } else System.out.println("No se encontró el cliente.");
                    break;

                case 6:
                    // Dar de baja película
                    System.out.print("Código película a dar de baja: ");
                    String codBaja = sc.nextLine();
                    Pelicula peliculaBaja = video.buscarPelicula(codBaja);
                    if (peliculaBaja != null) {
                        peliculaBaja.setFechaBaja(LocalDate.now());
                        System.out.println("Película dada de baja correctamente.");
                    } else System.out.println("No se encontró la película.");
                    break;

                case 7:
                    // Mostrar información del videoclub
                    System.out.println(video.infoVideoClub());
                    System.out.println(video.infoPeliculasRegistradas());
                    System.out.println(video.infoClientesRegistrados());
                    break;

                case 8:
                    // Salir del programa
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
