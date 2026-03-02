import java.time.LocalDateTime;

public class Videojuego extends Articulo {

    public enum Genero { RPG, SHOOTER, DEPORTES, AVENTURA }

    private Genero genero;
    private LocalDateTime fechaAlquiler;
    private boolean alquilado;

    public Videojuego(String cod, String titulo, Genero genero) {
        super(cod, titulo);
        this.genero = genero;
        this.alquilado = false;
    }

    public void alquilar() {
        alquilado = true;
        fechaAlquiler = LocalDateTime.now();
    }

    public void devolver() {
        alquilado = false;
        fechaAlquiler = null;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nGenero: " + genero +
                "\nAlquilado: " + alquilado;
    }
}