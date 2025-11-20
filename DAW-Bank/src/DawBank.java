import java.util.Scanner;

public class DawBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("INFORMACION DAWBANK");

        //Pedir IBAN y titular
        String iban = "";
        String titular = "";

        // Pedir IBAN válido
        while (true) {
            System.out.print("Introduzca el IBAN (2 letras + 22 números): ");
            iban = sc.nextLine().toUpperCase();

            // Validamos CuentaBancaria
            if (iban.matches("^[A-Z]{2}[0-9]{22}$")) {
                break; // IBAN válido
            } else {
                System.out.println("ERROR: IBAN inválido. Debe tener 2 letras y 22 números.");
            }
        }

        // Pedir titular hasta que sea válido
        while (titular.isEmpty()) {
            System.out.print("Introduzca el titular de la cuenta: ");
            titular = sc.nextLine();
            if (titular.isEmpty()) {
                System.out.println("ERROR: El titular no puede estar vacío.");
            }
        }

        // Crear la cuenta
        CuentaBancaria cuenta = new CuentaBancaria(iban, titular);
        System.out.println("Cuenta creada correctamente.");

        //Menú principal
        int opcion = 0;

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Datos de la cuenta");
            System.out.println("2. Mostrar IBAN");
            System.out.println("3. Mostrar titular");
            System.out.println("4. Mostrar saldo");
            System.out.println("5. Ingreso");
            System.out.println("6. Retirada");
            System.out.println("7. Movimientos");
            System.out.println("8. Salir");
            System.out.print("Elige una opcion: ");

            //Validar número
            if (!sc.hasNextInt()) {
                System.out.println("Opcion no valida");
                sc.nextLine();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\n DATOS DE LA CUENTA");
                    System.out.println("IBAN: " + cuenta.getIBAN());
                    System.out.println("Titular: " + cuenta.getTitular());
                    System.out.println("Saldo: " + cuenta.getSaldo() + " €");
                    break;

                case 2:
                    System.out.println("IBAN: " + cuenta.getIBAN());
                    break;

                case 3:
                    System.out.println("Titular: " + cuenta.getTitular());
                    break;

                case 4:
                    System.out.println("Saldo disponible: " + cuenta.getSaldo() + " €");
                    break;

                case 5:
                    System.out.print("Cantidad a ingresar: ");
                    if (sc.hasNextDouble()) {
                        double ingreso = sc.nextDouble();
                        cuenta.ingresar(ingreso);
                    } else {
                        System.out.println("Cantidad no valida");
                        sc.nextLine();
                    }
                    break;

                case 6:
                    System.out.print("Cantidad a retirar: ");
                    if (sc.hasNextDouble()) {
                        double retirada = sc.nextDouble();
                        cuenta.retirar(retirada);
                    } else {
                        System.out.println("Cantidad no valida");
                        sc.nextLine();
                    }
                    break;

                case 7:
                    System.out.println("\n Historial de Movimientos");
                    cuenta.mostrarMovimientos();
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opcion != 8);

        sc.close();
    }
}