import java.time.LocalDate;

public class Cliente {

    // Atributos encapsulados
    private String DNI;
    private String nombre;
    private String numSocio;             // Ejemplo: S-0001
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;

    // Array de películas alquiladas
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

    // Getters
    public String getDNI() { return this.DNI; }
    public String getNombre() { return this.nombre; }
    public String getNumSocio() { return this.numSocio; }
    public String getDireccion() { return this.direccion; }
    public LocalDate getFechaNacimiento() { return this.fechaNacimiento; }
    public LocalDate getFechaBaja() { return this.fechaBaja; }

    // Setters
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    // VALIDAR DNI
    private boolean validarDNI(String dni) {
        return dni != null && dni.matches("\\d{8}[A-Z]");
    }

    // MAYOR DE EDAD
    private boolean esMayorEdad(LocalDate fecha) {
        if (fecha == null) return false;
        return fecha.plusYears(18).isBefore(LocalDate.now());
    }

    // Insertar película alquilada
    public boolean insertarPelicula(Pelicula p) {
        boolean resultado = false;

        if (p != null) {
            if (this.nPeliculasActuales < this.peliculasAlquiladas.length) {
                this.peliculasAlquiladas[this.nPeliculasActuales] = p;
                resultado = true;
                this.nPeliculasActuales++;
            } else {
                this.ampliarDimensionPeliculas();
                this.peliculasAlquiladas[this.nPeliculasActuales] = p;
                resultado = true;
                this.nPeliculasActuales++;
            }
        }

        return resultado;
    }

    private void ampliarDimensionPeliculas() {
        Pelicula[] aux = new Pelicula[this.peliculasAlquiladas.length + 5];

        for (int i = 0; i < this.peliculasAlquiladas.length; i++) {
            aux[i] = this.peliculasAlquiladas[i];
        }

        this.peliculasAlquiladas = aux;
    }

    // INFORMACIÓN DEL CLIENTE
    public String infoCliente() {

        StringBuilder sb = new StringBuilder("Cliente:\n");
        sb.append("DNI: " + this.DNI + "\n");
        sb.append("Nombre: " + this.nombre + "\n");
        sb.append("Número de socio: " + this.numSocio + "\n");
        sb.append("Dirección: " + this.direccion + "\n");
        sb.append("Fecha nacimiento: " + this.fechaNacimiento + "\n");

        if (this.fechaBaja != null)
            sb.append("Fecha de baja: " + this.fechaBaja + "\n");
        else
            sb.append("Fecha de baja: No dado de baja\n");

        return sb.toString();
    }

    // INFORMACIÓN DE LAS PELÍCULAS ALQUILADAS
    public String infoPeliculasAlquiladas() {

        if (this.nPeliculasActuales == 0) {
            return "El cliente no tiene películas alquiladas.";
        }

        StringBuilder sb = new StringBuilder("Películas alquiladas:\n");

        for (int i = 0; i < this.nPeliculasActuales; i++) {
            if (this.peliculasAlquiladas[i] != null) {
                sb.append(this.peliculasAlquiladas[i].infoPelicula()).append("\n");
            }
        }

        return sb.toString();
    }
}

