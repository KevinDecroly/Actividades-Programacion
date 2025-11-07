import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Numeros a almacenar");
    int n =sc.nextInt();

    int [] numeros = new int [n];


    String opcion = "";
    int almacenado = 0;

        do{

            sc=new Scanner(System.in);
            System.out.println("\tNumeros que almacenar");
            System.out.println("\tEJ1. Insertar numero");
            System.out.println("\t  1. En la ultima posición");
            System.out.println("\t  2 En una posicion específica");
            System.out.println("\tEJ2. Borrar número");
            System.out.println("\t  3. De la ultima posición ocupada");
            System.out.println("\t  4. De un posiciçon específica");
            System.out.println("\t  5. Modificar numero de una posición esècçifica");
            System.out.println("\tEJ4. Estadísticas de la colección ");
            System.out.println("\t  6. Media de todos los valores no nulos");
            System.out.println("\t  7. Suma de todos los valores");
            System.out.println("\t  8. Máximo de la colección");
            System.out.println("\t  9. Mínimo de la colleción");
            System.out.println("\t  10. Ampliar el valor de la colección");
            System.out.println("\t  11. Salir");
            opcion = sc.nextLine();

            switch(opcion){
                case "0":
                    sc = new Scanner(System.in);
                    for(int i=0 ;i < numeros.length; i++){
                        System.out.println("Numeros para almacenar");
                        if (numeros[i]==0){
                            break;
                        }
                    }
                    break;
                case "1":
                    sc = new Scanner(System.in);



                    break;
                case "2":
                    sc = new Scanner(System.in);





                    break;
                case "3":
                    sc = new Scanner(System.in);
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

                    for(int i = 0; i < numeros.length; i++){
                        if (numeros [i] != 0){
                            almacenado++;
                        }

                        max = Math.max(numeros[i], max);
                        min = Math.min(numeros[i], min);

                    }
                    System.out.println("Cantidad de numeros:" + almacenado);
                    System.out.println("Maximo de numeros:" + max);
                    System.out.println("Minimo de numeros:" + min);





                    break;
                case "4":
                    sc = new Scanner(System.in);





                    break;
                case "5":
                    sc = new Scanner(System.in);



                    break;
                case "6":
                    sc = new Scanner(System.in);





                    break;
                case "7":
                    sc = new Scanner(System.in);





                    break;
                case "8":
                    sc = new Scanner(System.in);




                    break;
                case "9":
                    sc = new Scanner(System.in);





                    break;
                case "10":
                    sc = new Scanner(System.in);





                    break;
                case "11":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Elige una opcion de las dispuestas");
            }
        }while(!opcion.equals("11"));

    }
}