import java.time.LocalDateTime;

public class Pelicula extends Articulo {

    public enum Genero { ACCION, COMEDIA, DRAMA, TERROR }

    private Genero genero;
    private LocalDateTime fechaAlquiler;
    private boolean alquilada;

    public Pelicula(String cod, String titulo, Genero genero) {
        super(cod, titulo);
        this.genero = genero;
        this.alquilada = false;
    }

    public void alquilar() {
        alquilada = true;
        fechaAlquiler = LocalDateTime.now();
    }

    public void devolver() {
        alquilada = false;
        fechaAlquiler = null;
    }

    public boolean isAlquilada() {
        return alquilada;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nGenero: " + genero +
                "\nAlquilada: " + alquilada +
                "\nFecha Alquiler: " + fechaAlquiler;
    }
}