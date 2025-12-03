import java.time.LocalDate;
import java.time.LocalDateTime;

public class VideooDaw {

    // Atributos privados
    private String CIF;
    private String direccion;
    private LocalDate fechaAlta;

    private Pelicula[] peliculasRegistradas;
    private int nPeliculasActuales;
    private final int dimensionInicialPeliculas = 50;

    private Cliente[] clientesRegistrados;
    private int nClientesActuales;
    private final int dimensionInicialClientes = 50;

    // Constructor
    public VideooDaw(String CIF, String direccion) {
        if (!validarCIF(CIF)) {
            System.out.println("CIF incorrecto.");
            this.CIF = null;
        } else {
            this.CIF = CIF;
        }

        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();

        this.peliculasRegistradas = new Pelicula[dimensionInicialPeliculas];
        this.clientesRegistrados = new Cliente[dimensionInicialClientes];
        this.nPeliculasActuales = 0;
        this.nClientesActuales = 0;
    }

    // Getters y Setters
    public String getCIF() { return CIF; }
    public String getDireccion() { return direccion; }
    public LocalDate getFechaAlta() { return fechaAlta; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    // Validar CIF
    private boolean validarCIF(String CIF) {
        return CIF != null && CIF.matches("[A-Z]\\d{7}[A-Z]");
    }

    // Registrar película
    public boolean registrarPelicula(Pelicula p) {
        if (p == null) return false;

        // Evitar repetidos
        for (int i = 0; i < nPeliculasActuales; i++) {
            if (peliculasRegistradas[i].getCod().equalsIgnoreCase(p.getCod())) {
                System.out.println("ERROR: Película ya registrada.");
                return false;
            }
        }

        if (nPeliculasActuales >= peliculasRegistradas.length) {
            Pelicula[] aux = new Pelicula[peliculasRegistradas.length + 10];
            System.arraycopy(peliculasRegistradas, 0, aux, 0, peliculasRegistradas.length);
            peliculasRegistradas = aux;
        }

        peliculasRegistradas[nPeliculasActuales++] = p;
        return true;
    }

    // Registrar cliente
    public boolean registrarCliente(Cliente c) {
        if (c == null) return false;

        for (int i = 0; i < nClientesActuales; i++) {
            if (clientesRegistrados[i].getDNI().equalsIgnoreCase(c.getDNI())) {
                System.out.println("ERROR: Cliente ya registrado.");
                return false;
            }
        }

        if (nClientesActuales >= clientesRegistrados.length) {
            Cliente[] aux = new Cliente[clientesRegistrados.length + 10];
            System.arraycopy(clientesRegistrados, 0, aux, 0, clientesRegistrados.length);
            clientesRegistrados = aux;
        }

        clientesRegistrados[nClientesActuales++] = c;
        return true;
    }

    // Buscar película por código
    public Pelicula buscarPelicula(String cod) {
        for (int i = 0; i < nPeliculasActuales; i++) {
            if (peliculasRegistradas[i].getCod().equalsIgnoreCase(cod)) return peliculasRegistradas[i];
        }
        return null;
    }

    // Buscar cliente por DNI
    public Cliente buscarCliente(String dni) {
        for (int i = 0; i < nClientesActuales; i++) {
            if (clientesRegistrados[i].getDNI().equalsIgnoreCase(dni)) return clientesRegistrados[i];
        }
        return null;
    }

    // Alquilar película
    public boolean alquilarPelicula(Pelicula p, Cliente c) {
        if (p == null || c == null) return false;
        if (p.getIsAlquilada()) {
            System.out.println("ERROR: La película ya está alquilada.");
            return false;
        }

        p.setIsAlquilada(true);
        p.setFechaAlquiler(LocalDateTime.now());
        c.insertarPelicula(p);
        return true;
    }

    // Devolver película
    public boolean devolverPelicula(Pelicula p, Cliente c) {
        if (p == null || c == null) return false;
        if (!p.getIsAlquilada()) {
            System.out.println("ERROR: La película no estaba alquilada.");
            return false;
        }

        // Comprobar plazo 48h
        if (p.getFechaAlquiler().plusHours(48).isBefore(LocalDateTime.now())) {
            System.out.println("ADVERTENCIA: Película devuelta fuera de plazo (>48h).");
        }

        p.setIsAlquilada(false);
        p.setFechaAlquiler(null);
        return true;
    }

    // Dar de baja cliente
    public boolean darBajaCliente(Cliente c) {
        if (c == null) return false;
        c.setFechaBaja(LocalDate.now());
        return true;
    }

    // Mostrar información
    public String infoVideoClub() {
        return String.format("VideoDaw:\nCIF: %s\nDirección: %s\nFecha alta: %s\nPelículas registradas: %d\nClientes registrados: %d",
                CIF, direccion, fechaAlta, nPeliculasActuales, nClientesActuales);
    }

    public String infoPeliculasRegistradas() {
        if (nPeliculasActuales == 0) return "No hay películas registradas.";
        StringBuilder sb = new StringBuilder("Películas registradas:\n");
        for (int i = 0; i < nPeliculasActuales; i++) {
            sb.append(peliculasRegistradas[i].infoPelicula()).append("\n");
        }
        return sb.toString();
    }

    public String infoClientesRegistrados() {
        if (nClientesActuales == 0) return "No hay clientes registrados.";
        StringBuilder sb = new StringBuilder("Clientes registrados:\n");
        for (int i = 0; i < nClientesActuales; i++) {
            sb.append(clientesRegistrados[i].infoCliente()).append("\n");
        }
        return sb.toString();
    }
}

