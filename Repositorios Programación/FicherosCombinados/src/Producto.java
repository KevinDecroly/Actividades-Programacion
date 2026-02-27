import java.io.Serializable;

public class Producto implements Serializable {

    private String referencia;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

    public Producto(String referencia, String descripcion, String tipo,
                    int cantidad, double precio, int descuento,
                    int iva, boolean aplicarDto) {

        this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    // Getters
    public String getReferencia() {
        return referencia; }

    public String getDescripcion() {
        return descripcion; }

    public String getTipo() {
        return tipo; }

    public int getCantidad() {
        return cantidad; }

    public double getPrecio() {
        return precio; }

    public int getDescuento() {
        return descuento; }

    public int getIva() {
        return iva; }

    public boolean isAplicarDto() {
        return aplicarDto; }

    // Setters
    public void setReferencia(String referencia) {
        this.referencia = referencia; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; }

    public void setTipo(String tipo) {
        this.tipo = tipo; }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad; }

    public void setPrecio(double precio) {
        this.precio = precio; }

    public void setDescuento(int descuento) {
        this.descuento = descuento; }

    public void setIva(int iva) {
        this.iva = iva; }

    public void setAplicarDto(boolean aplicarDto) {
        this.aplicarDto = aplicarDto; }

    @Override
    public String toString() {
        return referencia + " | " + descripcion + " | " + tipo +
                " | Cant: " + cantidad + " | Precio: " + precio;
    }
}