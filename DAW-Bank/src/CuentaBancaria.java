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

        this.nMovimientos = 0;
        this.movimientos = new Movimiento[100];

    }

    //Getters
    public String getIBAN() {
        return this.IBAN;
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
        if (cantidad <= 0) return ;
    }


}