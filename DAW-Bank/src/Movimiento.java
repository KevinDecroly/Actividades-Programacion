public class Movimiento {

    //Atributos o campos de la clase (encapsulación)
    private static int contadorID = 1;

    private int id;
    private String fecha;   //dd/mm/aaaa
    private String tipo;    //"Ingreso" o "Retirada"
    private double cantidad;

    //Constructor/ Constructores
    public Movimiento(String tipo, double cantidad) {

        this.id = contadorID++;

        //Generar fecha
        java.util.Date fechaActual = new java.util.Date();
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
        this.fecha = formato.format(fechaActual);

        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    /*
        GETTERS
    */

    public int getId() {
        return this.id;
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    /*
       METODO: mostrar informacion del movimiento
    */
    public String mostrarInfoMovimiento() {
        String info = "";
        info += "ID: " + this.id + "\n";
        info += "Fecha: " + this.fecha + "\n";
        info += "Tipo: " + this.tipo + "\n";
        info += "Cantidad: " + this.cantidad + " €\n";

        return info;
    }
}
