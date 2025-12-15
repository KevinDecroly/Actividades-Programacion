import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Astro> listaAstros = new ArrayList<>();
        String opcion;

        do {
            System.out.println("\n--- MENÚ ASTROS ---");
            System.out.println("1. Crear planeta");
            System.out.println("2. Crear satélite");
            System.out.println("3. Mostrar astros");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextLine();

            switch (opcion) {

                case "1":
                    Planeta.crearPlaneta(listaAstros, sc);
                    break;

                case "2":
                    Satelite.crearSatelite(listaAstros, sc);
                    break;

                case "3":
                    for (Astro a : listaAstros) {
                        System.out.println();
                        a.mostrarInformacion();
                    }
                    break;

                case "4":
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (!opcion.equals("4"));

        sc.close();
    }
}
