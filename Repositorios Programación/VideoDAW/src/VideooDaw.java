import java.time.LocalDate;
import java.time.LocalDateTime;

public class VideooDaw {

    // Atributos encapsulados
    private String CIF;
    private String direccion;
    private LocalDate fechaAlta;

    // Arrays de clientes y películas
    private Pelicula[] peliculasRegistradas;
    private int nPeliculasActuales;
    private final int dimensionInicialPeliculas = 50;

    private Cliente[] clientesRegistrados;
    private int nClientesActuales;
    private final int dimensionInicialClientes = 50;

    // Constructor
    public VideooDaw(String CIF, String direccion) {

        if (!validarCIF(CIF)) {
            System.out.println("CIF incorrecto. Se asignará null.");
            this.CIF = null;
        } else {
            this.CIF = CIF;
        }

        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();

        this.peliculasRegistradas = new Pelicula[this.dimensionInicialPeliculas];
        this.nPeliculasActuales = 0;

        this.clientesRegistrados = new Cliente[this.dimensionInicialClientes];
        this.nClientesActuales = 0;
    }

    // Getters
    public String getCIF() { return this.CIF; }
    public String getDireccion() { return this.direccion; }
    public LocalDate getFechaAlta() { return this.fechaAlta; }

    // Setters
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Validar CIF
    private boolean validarCIF(String CIF) {
        // Formato sencillo tipo: letra + 7 dígitos + letra
        return CIF != null && CIF.matches("[A-Z]\\d{7}[A-Z]");
    }

    // ==========================
    // REGISTRAR PELÍCULA
    // ==========================
    public boolean registrarPelicula(Pelicula p) {
        boolean resultado = false;

        if (p != null) {
            // Comprobar que no esté repetida
            for (int i = 0; i < this.nPeliculasActuales; i++) {
                if (this.peliculasRegistradas[i].getCod().equalsIgnoreCase(p.getCod())) {
                    System.out.println("ERROR: La película ya está registrada.");
                    return false;
                }
            }

            if (this.nPeliculasActuales < this.peliculasRegistradas.length) {
                this.peliculasRegistradas[this.nPeliculasActuales] = p;
                resultado = true;
                this.nPeliculasActuales++;
            } else {
                this.ampliarPeliculas();
                this.peliculasRegistradas[this.nPeliculasActuales] = p;
                resultado = true;
                this.nPeliculasActuales++;
            }
        }

        return resultado;
    }

    private void ampliarPeliculas() {
        Pelicula[] aux = new Pelicula[this.peliculasRegistradas.length + 10];

        for (int i = 0; i < this.peliculasRegistradas.length; i++) {
            aux[i] = this.peliculasRegistradas[i];
        }
        this.peliculasRegistradas = aux;
    }

    // ==========================
    // REGISTRAR CLIENTE
    // ==========================
    public boolean registrarCliente(Cliente c) {
        boolean resultado = false;

        if (c != null) {

            // Comprobar que no esté repetido
            for (int i = 0; i < this.nClientesActuales; i++) {
                if (this.clientesRegistrados[i].getDNI().equalsIgnoreCase(c.getDNI())) {
                    System.out.println("ERROR: El cliente ya está registrado.");
                    return false;
                }
            }

            if (this.nClientesActuales < this.clientesRegistrados.length) {
                this.clientesRegistrados[this.nClientesActuales] = c;
                resultado = true;
                this.nClientesActuales++;
            } else {
                this.ampliarClientes();
                this.clientesRegistrados[this.nClientesActuales] = c;
                resultado = true;
                this.nClientesActuales++;
            }
        }

        return resultado;
    }

    private void ampliarClientes() {
        Cliente[] aux = new Cliente[this.clientesRegistrados.length + 10];

        for (int i = 0; i < this.clientesRegistrados.length; i++) {
            aux[i] = this.clientesRegistrados[i];
        }
        this.clientesRegistrados = aux;
    }

    // ==========================
    // ALQUILAR PELÍCULA
    // ==========================
    public boolean alquilarPelicula(Pelicula p, Cliente c) {

        if (p == null || c == null) {
            System.out.println("ERROR: Datos inválidos.");
            return false;
        }

        if (p.getIsAlquilada()) {
            System.out.println("ERROR: La película ya está alquilada.");
            return false;
        }

        // Marcar película alquilada
        p.setIsAlquilada(true);
        p.setFechaAlquiler(LocalDateTime.now());

        // Añadir al cliente
        c.insertarPelicula(p);

        return true;
    }

    // ==========================
    // DEVOLVER PELÍCULA
    // ==========================
    public boolean devolverPelicula(Pelicula p, Cliente c) {

        if (p == null || c == null) return false;

        if (!p.getIsAlquilada()) {
            System.out.println("ERROR: La película no estaba alquilada.");
            return false;
        }

        // Comprobar si han pasado más de 48h
        if (p.getFechaAlquiler().plusHours(48).isBefore(LocalDateTime.now())) {
            System.out.println("ADVERTENCIA: La película se devuelve fuera de plazo (más de 48h).");
        }

        // Devolver
        p.setIsAlquilada(false);
        p.setFechaAlquiler(null);

        return true;
    }

    // ==========================
    // DAR DE BAJA CLIENTE
    // ==========================
    public boolean darBajaCliente(Cliente c) {

        if (c == null) return false;

        c.setFechaBaja(LocalDate.now());
        return true;
    }

    // ==========================
    // INFORMACIÓN
    // ==========================
    public String infoVideoClub() {

        StringBuilder sb = new StringBuilder("VideoDaw:\n");
        sb.append("CIF: " + this.CIF + "\n");
        sb.append("Dirección: " + this.direccion + "\n");
        sb.append("Fecha alta: " + this.fechaAlta + "\n");
        sb.append("Películas registradas: " + this.nPeliculasActuales + "\n");
        sb.append("Clientes registrados: " + this.nClientesActuales + "\n");

        return sb.toString();
    }

    public String infoPeliculasRegistradas() {
        if (this.nPeliculasActuales == 0) return "No hay películas registradas.";

        StringBuilder sb = new StringBuilder("Películas registradas:\n");

        for (int i = 0; i < this.nPeliculasActuales; i++) {
            sb.append(this.peliculasRegistradas[i].infoPelicula()).append("\n");
        }

        return sb.toString();
    }

    public String infoClientesRegistrados() {
        if (this.nClientesActuales == 0) return "No hay clientes registrados.";

        StringBuilder sb = new StringBuilder("Clientes registrados:\n");

        for (int i = 0; i < this.nClientesActuales; i++) {
            sb.append(this.clientesRegistrados[i].infoCliente()).append("\n");
        }

        return sb.toString();
    }
}
