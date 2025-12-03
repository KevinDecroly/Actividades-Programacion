import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

                /*Realiza un programa que dada una cantidad de euros que el usuario introduce por
        teclado (múltiplo de 5 €) mostrará los billetes de cada tipo que serán necesarios para
        alcanzar dicha cantidad (utilizando billetes de 500, 200, 100, 50, 20, 10 y 5). Hay que
        indicar el mínimo de billetes posible. Por ejemplo, si el usuario introduce 145 el
        programa indicará que será necesario 1 billete de 100 €, 2 billetes de 20 € y 1 billete de
        5 € (no será válido por ejemplo 29 billetes de 5, que aunque sume 145 € no es el mínimo
        número de billetes posible).*/
        System.out.println("Ejercicio 1");
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los billetes que sean múltiplo de 5");
        int valor = sc.nextInt();
        if (valor    % 5 != 0) {
            System.out.println("La cantidad no es múltiplo de 5.");
        } else {
            int billetes[] = {5,10,20,50,100,200,500};
            int[] usados = new int[billetes.length];
            int resto = valor;

            for (int i = billetes.length - 1; i >= 0; i--) {
                usados[i] = resto / billetes[i];
                resto = resto % billetes[i];
            }

            System.out.println("Dividirlo en billetes");
            int totalusado = 0;

            for (int i = billetes.length - 1; i >= 0; i--) {
                if (usados[i] != 0) {
                    System.out.print(usados[i] + " billetes de " + billetes[i] +  "\n");
                    totalusado += usados[i];
                }
            }
            System.out.println("Billetes usados "+ totalusado);
        }
        /*Realiza un programa que muestre un menú de opciones como el siguiente:
        1. Sumar
        2. Restar
        3. Multiplicar
        4. Dividir(incluir manejo de division por 0)
        5. Salir*/
        System.out.println("Ejercicio 2");
        sc = new Scanner(System.in);

        double num1 =0.0, num2 =0.0;
        String opcion ="5";

        do{
            System.out.println("Menu de operaciones:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("La suma de los dos numeros es: "+(num1+num2));
                    break;

                case "2":
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("La resta de los dos numeros es: "+(num1-num2));
                    break;
                case "3":
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("La multiplicacion de los dos numeros es: "+(num1*num2));
                    break;
                case "4":
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    if (num2 != 0.0) {
                        System.out.println("La division de los dos mumeros  es: "+(num1/num2));
                    }
                    else  {
                        System.out.println("No se puede dividir entre 0:");
                    }
                    break;
                case "5":
                    System.out.println("Salir del programa");
                default:
                    System.out.println("Por favor escoja entre las opciones indicadas");
            }
        }while(!opcion.equals("5"));


    }
}