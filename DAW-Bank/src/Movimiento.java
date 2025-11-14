public class Movimiento {
    private String Id;
    private String Fecha;
    private String TipoMovimiento;
    private double Cantidad;

    //Constructores

    public Movimiento(String id, String fecha, String tipoMovimiento, double Cantidad) {
        this.Id = id;
        this.Fecha = fecha;
        this.TipoMovimiento = tipoMovimiento;
    }
}
