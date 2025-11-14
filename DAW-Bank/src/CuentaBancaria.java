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
        this.IBAN = IBAN;
        this.Titular = Titular;

        this.movimientos = new Movimiento[this.nMovimientos];

        this.nMovimientos = 0;
    }

    public String getIBAN() {
        return this.IBAN;
    }

    public String getTitular() {
        return this.Titular;
    }


}