import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        
        Map<String, Personas> alumnos = new HashMap<String,Personas>(); //new HashMap<>
        
        Personas a1 = new Personas("1000X","Oscar","Lanza");
        Personas a2 = new Personas("1001X","Aaron","Lanza");
        Personas a3 = new Personas("1002X","Joaquin","Lanza");
        Personas a4 = new Personas("1003X","Mario","Lanza");
        Personas a5 = new Personas("1004X","Diego","Lanza");
        Personas aRepe = new Personas("1000X","No soy Oscar","Lanza");

        alumnos.put(a1.getDni(), a1);
        alumnos.put(a2.getDni(), a2);
        alumnos.put(a3.getDni(), a3);
        alumnos.put(a4.getDni(), a4);
        alumnos.put(a5.getDni(), a5);

        alumnos.put(aRepe.getDni(), aRepe);

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dni del alumno: ");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido del alumno: ");
        String apellido = sc.nextLine();

        alumnos.put(dni, new Personas(dni, nombre, apellido));

        alumnos.containsKey(dni);
        System.out.println("\n");
        for (Map.Entry<String, Personas> entry : alumnos.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }

        System.out.println("\n");
        for(String clave : alumnos.keySet()) {
            System.out.println("Clave: " + clave + "Valor" + alumnos.get(clave).toString());
        }

        System.out.println("\n");
        for(Personas p : alumnos.values()) {
            System.out.println(p.toString());
        }
        
        
    }
}
