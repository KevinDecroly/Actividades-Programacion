import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenidos a Naruto");

        String nombre = "";
        String cod = "";

        while (true) {
            System.out.print("Ingresa el codigo de la Aldea: ");
            cod = scanner.nextLine().toUpperCase();
            if (cod.matches("[A-Z]{5}[1-9]{5}"))
                break;
            System.out.print("ERROR: codigo de la Aldea invalido: ");
        }

        //Creamos la aldea
        Aldea aldea = new Aldea(cod, nombre);
        System.out.print("Aldea registrada correctamente.\n");

        int opcion = 0;

        do {
            //Mostrar menu
            System.out.print("\n Menu Principal: ");
            System.out.println("1.Crear Equipo");
            System.out.println("2.Registrar Ninja en el equipo");
            System.out.println("3.Numero el numero de ninjas totales en la Aldea");
            System.out.println("4. Mostrar informacion de un equipos");
            System.out.println("5. Mostrar informacion de todos los equipos");
            System.out.println("6. Mostrar informacion de toda la Aldea");
            System.out.println("7. Calcular estadísticas de toda la Aldea");
            System.out.println("8. Cambiar ninja de un equipo");
            System.out.println("9. Eliminar ninja de la Aldea");
            System.out.println("10. Salir del menu");
            System.out.print("Ingresa una opcion: ");

            if (!scanner.hasNext()) {
                System.out.print("La opcion no es valida");

                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt()
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    //Registramos la aldea
                    System.out.print("Codigo de la Aldea: ");
                    String codAldea = scanner.nextLine();
                    System.out.print("Nombre de la Aldea: ");
                    String nombreAldea = scanner.nextLine();
                    break;
                case 2:
                    //Registramos Ninja
                    System.out.print("Id del Ninja: ");
                    String idNinja = scanner.nextLine();
                    System.out.print("Tecnica secreta: ");
                    String tecnicaSecreta = scanner.nextLine();
                    System.out.print("Fecha de Alta: ");
                    String fechaAlta = scanner.nextLine();
                    System.out.print("Ataque: ");
                    String ataque = scanner.nextLine();
                    System.out.print("Defensa: ");
                    String defensa = scanner.nextLine();
                    System.out.print("Chakra: (TIERRA, FUEGO, AIRE, AGUA, RAYO): ");
                    String chakraTxt = scanner.nextLine().toUpperCase();
                    try {
                        Ninja.Chakra chakra = Ninja.Chakra.;valueOf(chakraTxt);
                        Ninja n = new Ninja(chakra,tecnicaSecreta);
                        if (aldea.generarEquipo(n)) System.out.println("Equipo registrado correctamente.");
                    } catch (Exception e) {
                        System.out.println("ERROR: chakra no valido");
                    }
                    try {
                        Ninja.Rango rango = Ninja.Rango.;valueOf(rango);
                        Ninja a = new Ninja(rango,tecnicaSecreta)
                        if  {aldea.generarEquipo(a) System.out.println("Equipo registrado correctamente.");
                            else  System.out.println("Equipo no registrado correctamente.");
                        } catch (Exception a) {
                            System.out.println("ERROR: rango no valido");
                        }
                    }
                case 3:
                    System.out.print(aldea.infoNinjas());
                    break;
                case 4:
                    System.out.print(aldea.infoEquipos());
                    break;
                case 5:System.out.println(aldea.infoEquipos());
                break;
                case 6:System.out.println(aldea.infoAldea());
                break;
                case 7:System.out.println(aldea.infoAldea());
                break;
                case 8:System.out.println(aldea.infoAldea());
                break;
                case 9:
                    System.out.println("Tecnica Secreta para dar de baja");
                    String tecnicaSecretaSalida = scanner.nextLine();
                    Ninja fechaSalida = aldea.eliminarNinja()
                    if (fechaSalida == null) {
                        aldea.eliminarNinja(fechaSalida);
                        System.out.println("Ninja eliminada correctamente.");
                    } else System.out.println("No se encontro al Ninja.");
                    break;
                case 10:
                    //Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("ERROR: opcion incorrecta");
                    break;
            }
        }while (opcion !=10);

        scanner.close();
    }
}