import java.util.ArrayList;
import java.util.Scanner;

public class Planeta extends Astro {

    private boolean tieneSatelites;

    public Planeta(String nombre, double masa, double diametro,
                   double periodoRotacion, double periodoTraslacion,
                   double distanciaMedia, boolean tieneSatelites) {

        super(nombre, masa, diametro, periodoRotacion, periodoTraslacion, distanciaMedia);
        this.tieneSatelites = tieneSatelites;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("PLANETA");
        System.out.println("Nombre: " + nombre);
        System.out.println("Masa: " + masa);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Período de rotación: " + periodoRotacion);
        System.out.println("Período de traslación: " + periodoTraslacion);
        System.out.println("Distancia media: " + distanciaMedia);
        System.out.println("Tiene satélites: " + tieneSatelites);
    }

    public static void crearPlaneta(ArrayList<Astro> lista, Scanner sc) {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Masa: ");
        double masa = sc.nextDouble();

        System.out.print("Diámetro: ");
        double diametro = sc.nextDouble();

        System.out.print("Período de rotación: ");
        double rotacion = sc.nextDouble();

        System.out.print("Período de traslación: ");
        double traslacion = sc.nextDouble();

        System.out.print("Distancia media al Sol: ");
        double distancia = sc.nextDouble();

        System.out.print("¿Tiene satélites?");
        boolean tieneSatelites = sc.nextBoolean();

        sc.nextLine();

        lista.add(new Planeta(nombre, masa, diametro,
                rotacion, traslacion, distancia, tieneSatelites));

        System.out.println("Planeta creado correctamente.");
    }
}


