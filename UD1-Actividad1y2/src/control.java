import java.util.Scanner;

public class control {
    public static void main(String[] args) {
            /* Escribe un programa que pide la edad por teclado y nos
            muestra el mensaje de “Eres mayor de edad” solo si lo somos.*/
            System.out.println("Ejercicio 01");
            Scanner sc = new Scanner(System.in);

            System.out.print("Introduce tu edad: ");
            int edad = sc.nextInt();

            if (edad >= 18) {
                System.out.println("Eres mayor de edad");
            }

            /*Escribe un programa que pide la edad por teclado y nos muestra
            el mensaje de “eres mayor de edad” o el mensaje de “eres menor de edad”.*/
            System.out.println("Ejercicio2");
            sc = new Scanner(System.in);

            System.out.println("Introduce tu edad: ");
            int edad2 = sc.nextInt();

            if (edad2 >= 18) {
                System.out.println("Eres mayor de edad");
            }
            else if (edad2 < 18 && edad2 >= 0) {
                System.out.println("Eres menor de edad");
            }
            else{
                System.out.println("La edad no tiene sentido");
            }

            /*Realiza un programa que muestre por pantalla los
            20 primeros números naturales (1, 2, 3... 20)*/
            System.out.println("Ejercicio3");
            sc = new Scanner(System.in);

            for (int i = 1; i <=20 ; i++) {
            System.out.println("El numero natural es:"+i);
            }

            /*Realiza un programa que muestre los números pares comprendidos
            entre el 1 y el 200. Para ello utiliza un contador y suma de 2 en 2.*/
            System.out.println("Ejercicio4");
            sc = new Scanner(System.in);

            for (int i=2; i <= 200; i +=2) {
                    System.out.println("El par es:"+i);
                }

            /*Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
            Esta vez utiliza un contador sumando de 1 en 1*/
            System.out.println("Ejercicio5");
            for (int i= 1; i <= 200; i++) {
                if ( i % 2 == 0) {
                    System.out.println("El par es:" + i);
                }
            }
            /*Realiza un programa que muestre los números desde el 1 hasta
            un número N que se introducirá por teclado*/
            System.out.println("Ejercicio6");
            sc = new Scanner(System.in);
            System.out.println("Introduce un numero");
            int numero = sc.nextInt();

            for (int i = 1; i <= numero; i++) {
                System.out.println("El numero natural es:"+i);
            }

            /*Escribe un programa que lea una calificación numérica entre 0 y 10 y la transforma
            en calificación alfabética, escribiendo el resultado.
             de 0 a <3 Muy Deficiente.
            • de 3 a <5 Insuficiente.
            • de 5 a <6 Bien.
            • de 6 a <9 Notable
            • de 9 a 10 Sobresaliente*/
        System.out.println("Ejercicio7");
        sc = new Scanner(System.in);
        System.out.println("Introduce la nota");
        double nota = sc.nextDouble();

        if (nota < 0.0 || nota > 10.0) {
            System.out.println("La nota es incorrecta: "+nota);
        }
        else{

                if (nota < 3.0) {
                    System.out.println("La nota es muy Deficiente: ");
                }

                if (nota >= 3.0 && nota < 5) {
                    System.out.println("La nota es INSUFICIENTE: ");
                }

                if (nota >= 5.0 && nota < 7) {
                    System.out.println("La nota es BIEN: ");
                }

                if (nota >= 7.0 && nota < 9) {
                    System.out.println("La nota es NOTABLE: ");
                }
                if (nota >= 9 && nota <= 10) {
                    System.out.println("La nota es Sobresaliente: ");
                }
            }

        /*Realiza un programa que lea un número positivo N y calcule y
        visualice su factorial N! Siendo el factorial:
        • 0! = 1
        • 1! = 1
        • 2! = 2 * 1
        • 3! = 3 * 2* 1
        • N! = N * (N-1) * (N-2)........* 3*2*1*/
        System.out.println("Ejercicio8");
        sc = new Scanner(System.in);
        int numero2 = sc.nextInt();

        int factorial = 1;
        for (int i = 1; i <= numero2; i++) {
            factorial = factorial * i;
        }
        System.out.println("El factorial es:"+factorial);

        /*Escribe un programa que recibe como datos de entrada una hora expresada en horas,
        minutos y segundos que nos calcula y escribe la hora, minutos y segundos que serán,
        transcurrido un segundo*/
        System.out.println("Ejercicio9");
        sc = new Scanner(System.in);

        System.out.println("0-23");
        int horas = sc.nextInt();

        System.out.println("0-60");
        int minutos = sc.nextInt();

        System.out.println("0-60");
        int segundos = sc.nextInt();

        segundos ++;
        if ( segundos==60) {
            segundos=0;
            minutos ++;
        }
        if ( minutos==60) {
            minutos=0;
            horas ++;
        }
        if ( horas==24) {
            horas=0;
        }
        System.out.println("Dentro de um segundo sera:"+horas + "h" + minutos + "m" + segundos + "s");

        /*Realiza un programa que lea 10 números no nulos y luego muestre un mensaje de si ha
        leído algún número negativo o no.*/
        System.out.println("Ejercicio10");
        sc = new Scanner(System.in);
        int contarnegativo = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Añade un número distinto de cero:");
            int num = sc.nextInt();

            if (num < 0) {
                System.out.println("El número es negativo");
                contarnegativo++;
            } else {
                System.out.println("El número es positivo");
            }
        }

        if (contarnegativo > 0) {
            System.out.println("Se ha introducido al menos un número negativo");
        } else {
            System.out.println("No se ha introducido ningún número negativo");
        }
        /* Realiza un programa que lea 10 números no nulos y luego muestre un mensaje
        indicando cuántos son positivos y cuantos negativos.*/
        System.out.println("Ejercicio11");
        sc= new Scanner(System.in);

        int contarpositivo = 0;
        contarnegativo = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Añade un número:");
            int num = sc.nextInt();

            if (num < 0) {
                System.out.println("El número es negativo");
                contarnegativo++;
            }
            if (num > 0) {
                System.out.println("El numero es positivo");
                contarpositivo++;
            }
        }
        System.out.println("Se ha encontrado negativo"+ contarnegativo);
        System.out.println("Se ha encontrado positivo"+ contarpositivo);

        /*Realiza un programa que lea una secuencia de números no nulos hasta
        que se introduzca un 0, y luego muestre si ha leído algún número negativo,
        cuantos positivos y cuantos negativos.*/
        System.out.println("Ejercicio12");
        sc= new Scanner(System.in);

        numero = 0;
        contarpositivo = 0;
        contarnegativo = 0;
        do{
            System.out.println("Introduce un numero distinto de cero o cero para parar");
            numero = sc.nextInt();
            if (numero < 0) {
                contarnegativo++;
            }
            if (numero > 0){
                contarpositivo++;
            }
        }while(numero != 0);
        System.out.println("Hay" + contarnegativo + "numeros negativos y hay" +  contarpositivo + "numeros positivos");
        /*Realiza un programa que calcule y escriba la suma y el
        producto de los 10 primeros números naturales.*/
        System.out.println("Ejercicio13");
        sc = new Scanner(System.in);

        int suma = 0;
        int multiplica = 1;
        for (int i = 1; i <= 10; i++) {
            suma = suma + i;
            multiplica= multiplica * i;
        }
        System.out.println("La suma de los primeros 10 numeros naturales es:" + suma);
        System.out.println("La multiplicacion de los primeros 10 numeros naturales es:" + multiplica);

        /*Escribe un programa que calcula el salario neto semanal de un trabajador en función del
        número de horas trabajadas y la tasa de impuestos de acuerdo a las siguientes hipótesis:
        Las primeras 35 horas se pagan a tarifa normal
        Las horas que pasen de 35 se pagan a 1,5 veces la tarifa normal
        Las tasas de impuestos son
        Los primeros 500 euros son libres de impuestos
        Los primeros 400 tienen un 25% de impuestos
        Los restantes un 45% de impuestos
        Escribir nombre, salario bruto, tasas y salario neto
         */
        System.out.println("Ejercicio14");
        double tarifaNormal = 25.0;

        System.out.println("Introduce el nombre del trabajador");
        String nombre = sc.nextLine();

        System.out.println("Introduce el numero de horas trabajadas");
        double horasTrabajadas = sc.nextDouble();

        double salarioBruto = 0.0;
        double salarioNeto = 0.0;
        if(horasTrabajadas >= 0 && horasTrabajadas <= 35){
            salarioBruto = tarifaNormal * horasTrabajadas;
        } else if (horasTrabajadas> 35) {
            salarioBruto = 1.5 * tarifaNormal * (horasTrabajadas-35) + 35 * tarifaNormal;

        } else{
            System.out.println("Las horas trabajadas no pueden ser negativas");
        }

        if(salarioBruto <= 500){
            salarioNeto = salarioBruto;
        }
        else if(salarioBruto > 500 && salarioBruto <= 900){
            salarioNeto = 500 +  (salarioBruto - 500) * 0.75;
        }
        else if(salarioBruto > 900 ){
            salarioNeto = 500 +  (salarioBruto - 500) * 0.75 + (salarioBruto - 900) * 0.55;
        }

        System.out.println("El nombre del trabajador es: " + nombre);
        System.out.println("El numero de horas trabajadas es: " + horas);
        System.out.println("La tarifa por hora es: " + tarifaNormal);
        System.out.println("La salario bruto es: " + salarioBruto);
        System.out.println("La salario neto es: " + salarioNeto);
        System.out.println("Las tasas aplicadas son: " + (salarioBruto - salarioNeto));

    }

}
