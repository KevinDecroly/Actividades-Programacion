public class Producto {

    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    // Para guardar en fichero
    public String toLineaFichero() {
        return codigo + ";" + nombre + ";" + cantidad + ";" + precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Nombre: " + nombre +
                ", Cantidad: " + cantidad +
                ", Precio: " + precio;
    }
}

