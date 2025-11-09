import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char jugadaUsuario; // Ponemos una variable para que guarde nuestra jugada

        System.out.println("Juego: Piedra (P), Papel (L) o Tijera (T)");
        System.out.println("Escribe S para salir.\n");

        // El bucle se repite mientras no se elija 'S'
        do {
            // Jugada aleatoria del ordenador (0 = P, 1 = L, 2 = T) usando Math.random()
            int aleatorio = (int) (Math.random() * 3); // Genera un  numero aleatorio entre 0 y 2
            char jugadaPC; // Variable para almacenar la jugada de la PC

            if (aleatorio == 0)
                jugadaPC = 'P';
            else if (aleatorio == 1)
                jugadaPC = 'L';
            else
                jugadaPC = 'T';

            // Aqui pediremos elegir entre piedra papel o tijera
            System.out.print("Tu jugada (P/L/T/S): ");
            jugadaUsuario = Character.toUpperCase(sc.next().charAt(0)); //Aqui coventiremos nuestra letra escrita en mayúscula

            if (jugadaUsuario == 'S') { //Esto servira para poder salir del juego
                System.out.println("¡Gracias por jugar!");
            } else {
                // Aqui pondremos que elegio cada uno para diferenciarlo mejor
                System.out.println("Tú elegiste: " + jugadaUsuario);
                System.out.println("El ordenador eligió: " + jugadaPC);

                // Pondremos los resultados
                if (jugadaUsuario == jugadaPC) { // aqui pondremos que si las dos jugadas son iguales saldra empate
                    System.out.println("Empate.\n");
                } else if ((jugadaUsuario == 'P' && jugadaPC == 'T') ||
                        (jugadaUsuario == 'L' && jugadaPC == 'P') ||
                        (jugadaUsuario == 'T' && jugadaPC == 'L')) {
                    System.out.println("¡Ganaste!\n"); //Las 3 lineas anteriores seran las jugadas que tendrian que salir para que el usuario gane
                } else {
                    System.out.println("Perdiste.\n");// Si no sale ninguna de esas jugadas significara que perdimos
                }
            }
        } while (jugadaUsuario != 'S'); // Esto se repetira hasta que salgamos poniendo S

        sc.close();
    }
}