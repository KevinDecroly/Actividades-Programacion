import java.time.LocalDate;

public class Cliente {

    // Atributos privados
    private String DNI;
    private String nombre;
    private String numSocio;       // Código único S-0001
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;

    private Pelicula[] peliculasAlquiladas;
    private int nPeliculasActuales;
    private final int dimensionInicial = 10;

    // Constructor
    public Cliente(String DNI, String nombre, String numSocio, String direccion, LocalDate fechaNacimiento) {

        if (!validarDNI(DNI)) {
            System.out.println("DNI incorrecto. Se asignará null.");
            this.DNI = null;
        } else {
            this.DNI = DNI;
        }

        if (!esMayorEdad(fechaNacimiento)) {
            System.out.println("Cliente menor de edad. No permitido.");
            this.fechaNacimiento = null;
        } else {
            this.fechaNacimiento = fechaNacimiento;
        }

        this.nombre = nombre;
        this.numSocio = numSocio;
        this.direccion = direccion;
        this.fechaBaja = null;

        this.peliculasAlquiladas = new Pelicula[this.dimensionInicial];
        this.nPeliculasActuales = 0;
    }

    // Getters y Setters
    public String getDNI() { return this.DNI; }
    public String getNombre() { return this.nombre; }
    public String getNumSocio() { return this.numSocio; }
    public String getDireccion() { return this.direccion; }
    public LocalDate getFechaNacimiento() { return this.fechaNacimiento; }
    public LocalDate getFechaBaja() { return this.fechaBaja; }

    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setFechaBaja(LocalDate fechaBaja) { this.fechaBaja = fechaBaja; }

    // Métodos auxiliares
    private boolean validarDNI(String dni) {
        return dni != null && dni.matches("\\d{8}[A-Z]");
    }

    private boolean esMayorEdad(LocalDate fecha) {
        if (fecha == null) return false;
        return fecha.plusYears(18).isBefore(LocalDate.now());
    }

    // Insertar película alquilada
    public boolean insertarPelicula(Pelicula p) {
        if (p == null) return false;

        // Si no hay espacio, ampliamos el array
        if (nPeliculasActuales >= peliculasAlquiladas.length) {
            ampliarDimensionPeliculas();
        }

        peliculasAlquiladas[nPeliculasActuales++] = p;
        return true;
    }

    private void ampliarDimensionPeliculas() {
        Pelicula[] aux = new Pelicula[peliculasAlquiladas.length + 5];
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            aux[i] = peliculasAlquiladas[i];
        }
        peliculasAlquiladas = aux;
    }

    // Mostrar información del cliente
    public String infoCliente() {
        StringBuilder sb = new StringBuilder("Cliente:\n");
        sb.append("DNI: ").append(DNI).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Número de socio: ").append(numSocio).append("\n");
        sb.append("Dirección: ").append(direccion).append("\n");
        sb.append("Fecha nacimiento: ").append(fechaNacimiento).append("\n");
        sb.append("Fecha baja: ").append(fechaBaja != null ? fechaBaja : "No dado de baja").append("\n");
        return sb.toString();
    }

    // Mostrar películas alquiladas
    public String infoPeliculasAlquiladas() {
        if (nPeliculasActuales == 0) return "El cliente no tiene películas alquiladas.";

        StringBuilder sb = new StringBuilder("Películas alquiladas:\n");
        for (int i = 0; i < nPeliculasActuales; i++) {
            sb.append(peliculasAlquiladas[i].infoPelicula()).append("\n");
        }
        return sb.toString();
    }
}