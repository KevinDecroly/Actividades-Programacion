import java.util.ArrayList;
import java.util.Scanner;

public class Satelite extends Astro {

    private String planetaAlQuePertenece;

    public Satelite(String nombre, double masa, double diametro,
                    double periodoRotacion, double periodoTraslacion,
                    double distanciaMedia, String planetaAlQuePertenece) {

        super(nombre, masa, diametro, periodoRotacion, periodoTraslacion, distanciaMedia);
        this.planetaAlQuePertenece = planetaAlQuePertenece;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("SATÉLITE");
        System.out.println("Nombre: " + nombre);
        System.out.println("Masa: " + masa);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Período de rotación: " + periodoRotacion);
        System.out.println("Período de traslación: " + periodoTraslacion);
        System.out.println("Distancia media: " + distanciaMedia);
        System.out.println("Planeta al que pertenece: " + planetaAlQuePertenece);
    }

    public static void crearSatelite(ArrayList<Astro> lista, Scanner sc) {

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

        System.out.print("Distancia media al planeta: ");
        double distancia = sc.nextDouble();

        sc.nextLine();

        System.out.print("Planeta al que pertenece: ");
        String planeta = sc.nextLine();

        lista.add(new Satelite(nombre, masa, diametro,
                rotacion, traslacion, distancia, planeta));

        System.out.println("Satélite creado correctamente.");
    }
}

