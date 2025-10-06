import java.util.Scanner;

public class control {
    public static void main(String[] args) {
            /* Escribe un programa que pide la edad por teclado y nos
            muestra el mensaje de “Eres mayor de edad” solo si lo somos.*/
            System.out.println("Ejercicio 01");
            Scanner sc = new Scanner(System.in);
            int edad;

            System.out.print("Introduce tu edad: ");
            edad = sc.nextInt();

            if (edad >= 18) {
                System.out.println("Eres mayor de edad");
            }
            /*Escribe un programa que pide la edad por teclado y nos muestra
            el mensaje de “eres mayor de edad” o el mensaje de “eres menor de edad”.*/
            System.out.println("Ejercicio2");
            sc = new Scanner(System.in);
            int edad2;

            System.out.print("Introduce tu edad: ");
            edad2 = sc.nextInt();

            if (edad2 >= 18) {
                System.out.println("Eres mayor de edad");
            }
            else if (edad2 < 18) {
                System.out.println("Eres menor de edad");
            }
            /*Realiza un programa que muestre por pantalla los
            20 primeros números naturales (1, 2, 3... 20)*/
            System.out.println("Ejercicio3");
            sc = new Scanner(System.in);

            for (int i = 1; i <=20 ; i++) {
            System.out.println(i);
            }
            /*Realiza un programa que muestre los números pares comprendidos
            entre el 1 y el 200. Para ello utiliza un contador y suma de 2 en 2.*/
            System.out.println("Ejercicio4");
            sc = new Scanner(System.in);

            int pares = 0;

            for (int cont=1; cont <= 200; cont++) {
                if (cont % 2 == 0) {
                    System.out.println(cont);
                }
             }

            System.out.println("La suma de todos los pares es " + pares);

    }
}
