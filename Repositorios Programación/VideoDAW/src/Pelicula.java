import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {

    // ENUM de género
    public enum Genero {
        ACCION, COMEDIA, DRAMA, TERROR, ANIMACION, ROMANCE
    }

    // Atributos privados
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

    // Getters y Setters
    public String getCod() { return cod; }
    public String getTitulo() { return titulo; }
    public Genero getGenero() { return genero; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public LocalDate getFechaBaja() { return fechaBaja; }
    public LocalDateTime getFechaAlquiler() { return fechaAlquiler; }
    public boolean getIsAlquilada() { return isAlquilada; }

    public void setFechaBaja(LocalDate fechaBaja) { this.fechaBaja = fechaBaja; }
    public void setFechaAlquiler(LocalDateTime fechaAlquiler) { this.fechaAlquiler = fechaAlquiler; }
    public void setIsAlquilada(boolean isAlquilada) { this.isAlquilada = isAlquilada; }

    // Mostrar información de la película
    public String infoPelicula() {
        StringBuilder sb = new StringBuilder("Película:\n");
        sb.append("Código: ").append(cod).append("\n");
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Género: ").append(genero).append("\n");
        sb.append("Fecha de registro: ").append(fechaRegistro).append("\n");
        sb.append("Fecha de baja: ").append(fechaBaja != null ? fechaBaja : "No dada de baja").append("\n");
        sb.append("¿Está alquilada?: ").append(isAlquilada ? "Sí" : "No").append("\n");
        sb.append("Fecha de alquiler: ").append(fechaAlquiler != null ? fechaAlquiler : "No alquilada").append("\n");
        return sb.toString();
    }
}


