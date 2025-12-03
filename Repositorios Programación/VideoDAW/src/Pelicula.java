import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {

    // ENUM para el género de las peliculas
    public enum Genero {
        ACCION, COMEDIA, DRAMA, TERROR, ANIMACION, SCIFI, ROMANCE
    }

    // Atributos encapsulados
    private String cod;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    // Constructor
    public Pelicula(String cod, String titulo, Genero genero) {
        this.cod = cod;
        this.titulo = titulo;
        this.genero = genero;

        this.fechaRegistro = LocalDate.now();
        this.fechaBaja = null;
        this.fechaAlquiler = null;
        this.isAlquilada = false;
    }

    // Getters
    public String getCod() {
        return this.cod;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return this.fechaBaja;
    }

    public LocalDateTime getFechaAlquiler() {
        return this.fechaAlquiler;
    }

    public boolean getIsAlquilada() {
        return this.isAlquilada;
    }

    // Setters
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setIsAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    // MÉTODO infopeliula
    public String infoPelicula() {

        StringBuilder sb = new StringBuilder("Película:\n");
        sb.append("Código: " + this.cod + "\n");
        sb.append("Título: " + this.titulo + "\n");
        sb.append("Género: " + this.genero + "\n");
        sb.append("Fecha de registro: " + this.fechaRegistro + "\n");

        if (this.fechaBaja != null)
            sb.append("Fecha de baja: " + this.fechaBaja + "\n");
        else
            sb.append("Fecha de baja: No dada de baja\n");

        sb.append("¿Está alquilada?: " + (this.isAlquilada ? "Sí" : "No") + "\n");

        if (this.fechaAlquiler != null)
            sb.append("Fecha de alquiler: " + this.fechaAlquiler + "\n");
        else
            sb.append("Fecha de alquiler: No alquilada\n");

        return sb.toString();
    }
}

