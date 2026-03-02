import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VideoDaw videoClub = new VideoDaw("A12345678", "Calle Principal");

        int opcion;

        do {
            System.out.println("\n1. Crear y Registrar VideoClub en la franquicia");
            System.out.println("2. Registrar pelicula en VideoClub");
            System.out.println("3. Crear y Registrar cliente en Videoclub");
            System.out.println("4. Alquilar");
            System.out.println("5. Devolver");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja articulo");
            System.out.println("8. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    if (videoClub == null) {
                        try {
                            System.out.println("Introduce CIF:");
                            String cif = sc.nextLine();

                            System.out.println("Introduce direccion:");
                            String direccion = sc.nextLine();

                            videoClub = new VideoDaw(cif, direccion);

                            System.out.println("VideoClub creado correctamente");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("El VideoClub ya está creado.");
                    }
                    break;

                case 2:
                    System.out.println("Codigo:");
                    String cod = sc.nextLine();
                    System.out.println("Titulo:");
                    String titulo = sc.nextLine();
                    Pelicula p = new Pelicula(cod, titulo,
                            Pelicula.Genero.ACCION);
                    videoClub.registrarArticulo(p);
                    break;

                case 3:
                    System.out.println("DNI:");
                    String dni = sc.nextLine();
                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();
                    System.out.println("Direccion:");
                    String dir = sc.nextLine();
                    System.out.println("Año nacimiento:");
                    int año = sc.nextInt();
                    Cliente c = new Cliente(dni, nombre, dir,
                            LocalDate.of(año,1,1), "S-001");
                    try {
                        videoClub.registrarCliente(c);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Codigo articulo:");
                    String ca = sc.nextLine();
                    System.out.println("Numero socio:");
                    String ns = sc.nextLine();
                    videoClub.alquilar(ca, ns);
                    break;

                case 5:
                    try {
                        System.out.println("Codigo articulo:");
                        String cd = sc.nextLine();
                        System.out.println("Numero socio:");
                        String ns2 = sc.nextLine();
                        videoClub.devolver(cd, ns2);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Numero socio:");
                    videoClub.darBajaCliente(sc.nextLine());
                    break;

                case 7:
                    System.out.println("Codigo articulo:");
                    videoClub.darBajaArticulo(sc.nextLine());
                    break;
            }

        } while (opcion != 8);

        sc.close();
    }
}