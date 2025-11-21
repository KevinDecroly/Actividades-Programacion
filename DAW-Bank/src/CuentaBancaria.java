public class  CuentaBancaria {


    //Atributos encapsulados
    private final String IBAN;
    private final String Titular;
    private double saldo;

    //"Array" de movimientos en la cuenta
    private Movimiento[] movimientos;
    private int nMovimientos;

    //Limites de saldo y movimiento
    public static final double SaldoMinimo = -50;
    public static final double AvisaHacienda = 3000;

    //Constructores
    public CuentaBancaria(String IBAN, String Titular) {

        if (!validarIBAN(IBAN)) {
            throw new IllegalArgumentException("Invalid IBAN");
        }

        this.IBAN = IBAN;
        this.Titular = Titular;
        this.saldo = 0;

        this.movimientos = new Movimiento[100];
        this.nMovimientos = 0;

    }

    //Getters
    public String getIBAN() {
        return this.IBAN.toUpperCase();
    }

    public String getTitular() {
        return this.Titular;
    }
    public double getSaldo() {
        return this.saldo;
    }

    //Validación del IBAN (2 letras + 22 números)
    private boolean validarIBAN(String iban) {
        return iban !=null && iban.matches("^[A-Z]{2}[0-9]{22}$");
    }
    public void ingresar(double cantidad) {
        if (cantidad <= 0) return ; //Si cantidad es menor o igual que 0 termina el metodo
        saldo+=cantidad; //Se suma la cantidad del ingreso al saldo actual de la cuenta

        if (cantidad>AvisaHacienda){
            System.out.println("HACIENDAAAAAAAAA");
        }
        registrarMovimiento("Ingreso",cantidad); //Registrarmovimiento de la cuenta

        if (saldo<0){
            System.out.println("Saldo negativo");
        }
    }

    //Retirar el dinero

    public void retirar(double cantidad) {
        if (cantidad <= 0) return ; //Si la cantidad es igual o menor que 0 no se puede retirar

        if (saldo-cantidad<SaldoMinimo){ //Si el saldo menos la cantidad a retirar es menor que el saldo minimo no permite retirar
            System.out.println("Saldo no disponible a retirar:Supera saldo mínimo");
            return;
        }

        saldo-=cantidad; //Restamos la cantidad retirada al saldo

        registrarMovimiento("Retirada",cantidad);

        if (cantidad>AvisaHacienda){
            System.out.println("HACIENDAAAAAAAAAA");
        }

        if (saldo<0){ //Si al retirar el dinero el saldo queda negativo mandamos un aviso
            System.out.println("Saldo negativo");
        }
    }

    private void registrarMovimiento(String tipo, double cantidad) {
        if (nMovimientos<100){
            movimientos[nMovimientos++]= new Movimiento(tipo,cantidad);
        }
    }

    //Mostrar cada movimiento
    public void mostrarMovimientos(){
     if (nMovimientos == 0){
         System.out.println("No hay movimientos en la cuenta");
         return;
     }
     for (int i = 0; i < nMovimientos; i++){
         System.out.println(movimientos[i].mostrarInfoMovimiento());
     }
    }
    public String mostrarDatos(){
        String datos = "";
        datos += "IBAN: "+this.IBAN+"\n";
        datos += "Titular: "+this.Titular+"\n";
        datos += "Saldo: "+this.saldo+"€\n";
        return datos;
    }
}