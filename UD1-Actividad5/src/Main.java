import java.sql.Struct;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Crea un programa que pida una cadena de texto por teclado
        y luego muestre cada palabra de la cadena en una línea distinta.*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio1");

        System.out.println("Introduce la cadena de texto");
        String texto = sc.nextLine();
        String[] palabra = texto.split("\\s+");

        for (int i = 0; i < palabra.length; i++) {
            System.out.println(palabra[i]);
        }
        /*Crea un programa que pida dos cadenas de texto por teclado y luego
        indique si son iguales, además de si son iguales sin diferenciar entre
        mayúsculas y minúsculas*/
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ejercicio2");

        System.out.println("Introduce la cadena del primer texto");
        String texto2 = sc2.nextLine();

        System.out.println("Introduce la cadena del segundo texto");
        String texto3 = sc2.nextLine();

        if (texto2.equalsIgnoreCase(texto3)) {
            System.out.println("Las cadenas son exactamente iguales");
        }else {
            System.out.println("Las cadenas son diferentes");
        }
        /*Crea un programa que pida por teclado tres cadenas de texto: nombre y dos
        apellidos. Luego mostrará un código de usuario (en mayúsculas) formado por la
        concatenación de las tres primeras letras de cada uno de ellos. Por ejemplo,
        si se introduce “Lionel”,“Tarazón” y “Alcocer” mostrará “LIOTARALC”*/
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Ejercicio3");

        System.out.println("Nombre");
        String nombre = sc3.nextLine();

        System.out.println("Primer Apellido");
        String apellido = sc3.nextLine();

        System.out.println("Segundo Apellido");
        String apellido2 = sc3.nextLine();

        System.out.println((nombre.substring(0,3) + apellido.substring(0,3) + apellido2.substring(0,3)).toUpperCase());

        /*Crea un programa que muestre por pantalla cuantas vocales de cada tipo
        hay (cuantas ‘a’, cuantas ‘e’, etc.) en una frase introducida por teclado.
        No se debe diferenciar entre mayúsculas y minúsculas. Por ejemplo, dada
        la frase “Mi mama me mima” dirá que hay:
        Nº de A's: 3
        Nº de E's: 1
        Nº de I's: 2
        Nº de O's: 0
        Nº de U's: 0*/
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Ejercicio4");

        String nombre4 = sc4.nextLine();
        int a = 0, e = 0, ies = 0, o = 0, u = 0;

        for (int i = 0; i < nombre4.length(); i++) {
            switch (nombre4.toLowerCase().charAt(i)) {
                case 'a': -> a++;
                case 'e': -> e++;
                case 'i' -> ies++;
                case 'o': -> o++;
                case 'u': -> u++;
            }
        }

        System.out.println("El numero de aes es:" +a);
        System.out.println("El numero de es es:" +e);
        System.out.println("El numero de ies es:" +ies);
        System.out.println("El numero de us es:" +u);
        System.out.println("El numero de os es:" +o);

        /*Realiza un programa que lea una frase por teclado e indique si la frase es un palíndromo
        o no (ignorando espacios y sin diferenciar entre mayúsculas y minúsculas).
        Supondremos que el usuario solo introducirá letras y espacios (ni comas, ni puntos, ni
        acentos, etc.). Un palíndromo es un texto que se lee igual de izquierda a derecha que de
        derecha a izquierda.
        Por ejemplo:
        Amigo no gima
        Dabale arroz a la zorra el abad
        Amo la pacífica paloma
        A man a plan a canal Panama*/

        sc = new Scanner(System.in);
        System.out.println("Ejercicio5");

        S


    }
}