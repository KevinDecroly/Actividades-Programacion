import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("Ejercicio 1");

        System.out.println("Buenos días futuros programadores\n");

        // Ejercicio 2
        System.out.println("Ejercicio 2");

        double lado = 5;
        double area = lado * lado;
        System.out.println("Lado: " + lado);
        System.out.println("Area: " + area);

        // Ejercicio 3
        System.out.println("\nEjercicio 3");

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el valor del lado del cuadrado");
        double lado2 = sc.nextDouble();

        double area2 = lado2 * lado2;
        System.out.println("Lado: " + lado2);
        System.out.println("Area: " + area2);

        // Ejercicio 4
        System.out.println("\nEjercicio 4");

        Scanner numero1 = new Scanner(System.in);
        System.out.println("Introduce el valor del lado del numero 1");
        double numerouno = numero1.nextDouble();

        Scanner numero2= new Scanner(System.in);
        System.out.println("Introduce el valor del numero 2");
        double numerodos = numero2.nextDouble();

        System.out.println("La suma es igual a: " +( numerouno + numerodos));
        System.out.println("La resta es igual a: " +( numerouno - numerodos));
        System.out.println("La multiplicación es igual a: " +(numerouno * numerodos));
        System.out.println("La division es igual a: " +( numerouno / numerodos));

        // Ejercicio 5
        System.out.println("\nEjercicio 5");

        double radio, circunferencia, volumen ;
        Scanner radio1 = new Scanner(System.in);
        System.out.println("Introduce el valor del radio");
        radio = radio1.nextDouble();

        area = Math.PI * Math.pow(radio, 2);
        circunferencia = 2 * Math.PI * radio;
        volumen = (4.0 /3.0) * Math.PI * Math.pow(radio, 3);

        System.out.println("El area es:" + area);
        System.out.println("La longitud de la circunferencia es:" + circunferencia);
        System.out.println("El volumen de esta esfera es:" + volumen);

        // Ejercicio 6
        System.out.println("\nEjercicio 6");

        Scanner primero = new Scanner(System.in);
        System.out.println("Introduce el valor original");
        double preciooriginal = primero.nextDouble();
        Scanner segundo = new Scanner(System.in);
        System.out.println("Introduce el valor actual");
        double precioactual = segundo.nextDouble();

        double descuento = preciooriginal - precioactual ;
        double procentajedescuento = ((precioactual-descuento) / descuento) * 100;
        System.out.println("El descuento es: " + descuento + "%");

        // Ejercicio 7
        System.out.println("\nEjercicio 7");

        Scanner distancia = new Scanner(System.in);
        System.out.println("La distancia en millas marinas es");
        double millas = distancia.nextDouble();

        double metros = millas * 1852;
        System.out.println("La distancia de millas en metros son: " + metros );

        // Ejercicio 8
        System.out.println("\nEjercicio 8");

        Scanner uno = new Scanner(System.in);
        System.out.println("Primer número:");
        double num1 = uno.nextDouble();

        Scanner dos = new Scanner(System.in);
        System.out.println("Segundo número:");
        double num2 = dos.nextDouble();

        double menor = Math.min(num1, num2);
        double mayor = Math.max(num1, num2);

        System.out.println("Los números en orden ascendente son: " + menor + " , " + mayor);

        //Ejercicio 9
        System.out.println("\nEjercicio 9");

        System.out.println("Intriduce el valor del primer numero");
        double numerado1 = primero.nextDouble();
        System.out.println("Introduce el valor del segundo numero");
        double numerado2 = segundo.nextDouble();

        System.out.println("El numero mayor es: " + Math.max(numerado1, numerado2));
        System.out.println("¿Los numeros son iguales?"+(numerado1==numerado2));

        //Ejercicio 10
        System.out.println("\nEjercicio 10");
        sc = new Scanner(System.in);

        System.out.println("Introduce el valor del primer numero");
        double n1 = sc.nextDouble();
        System.out.println("Introduce el valor del segundo numero");
        double n2 = sc.nextDouble();
        System.out.println("Introduce el valor del tercer numero");
        double n3 = sc.nextDouble();

        double max = Math.max(Math.max(n1, n2), n3);
        System.out.println("El valor maximo es: " + max);

        //Ejercicio 11
        System.out.println("\nEjercicio 11");
        sc = new Scanner(System.in);


        //Ejercicio 12.sad
        System.out.println("\nEjercicio 12");
        sc = new Scanner(System.in);

        System.out.println("Introduce el valor del primer numero");
        double numerado1 = sc.nextDouble();
        System.out.println("Introduce el valor del segundo numero");
        double  numero2 = sc.nextDouble();

        System.out.println("El numero mayor es" + Math.max(numerado1, numerado2));

        //Ejercicio 13
        System.out.println("\nEjercicio 13");
        sc = new Scanner(System.in);

        System.out.println("Introduce el valor del primer numero");
        double nv1 = sc.nextDouble();

        System.out.println("¿El numero es positivo?: " +(nv1 >= 0));

    }
}