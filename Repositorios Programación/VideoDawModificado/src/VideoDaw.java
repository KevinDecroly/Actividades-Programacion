import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VideoDaw {

    private String cif;
    private String direccion;
    private ArrayList<Articulo> articulos;
    private ArrayList<Cliente> clientes;

    public VideoDaw(String cif, String direccion) {

        if (!cif.matches("[A-Z]\\d{8}")) {
            throw new IllegalArgumentException("CIF no válido");
        }

        this.cif = cif;
        this.direccion = direccion;
        articulos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void registrarArticulo(Articulo a) {
        articulos.add(a);
    }

    public void registrarCliente(Cliente c) throws ExcepcionClienteDuplicado {
        for (Cliente cli : clientes) {
            if (cli.getNumSocio().equals(c.getNumSocio())) {
                throw new ExcepcionClienteDuplicado("Cliente ya registrado");
            }
        }
        clientes.add(c);
    }

    public Articulo buscarArticulo(String cod) {
        for (Articulo a : articulos) {
            if (a.getCod().equals(cod)) {
                return a;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String numSocio) {
        for (Cliente c : clientes) {
            if (c.getNumSocio().equals(numSocio)) {
                return c;
            }
        }
        return null;
    }

    public void alquilar(String codArticulo, String numSocio) {
        Articulo a = buscarArticulo(codArticulo);
        Cliente c = buscarCliente(numSocio);

        if (a instanceof Pelicula) {
            Pelicula p = (Pelicula) a;
            if (!p.isAlquilada()) {
                p.alquilar();
                c.agregarArticulo(p);
            }
        }

        if (a instanceof Videojuego) {
            Videojuego v = (Videojuego) a;
            if (!v.isAlquilado()) {
                v.alquilar();
                c.agregarArticulo(v);
            }
        }
    }

    public void devolver(String codArticulo, String numSocio)
            throws ExcepcionTiempoAlquiler {

        Articulo a = buscarArticulo(codArticulo);
        Cliente c = buscarCliente(numSocio);

        if (a instanceof Pelicula) {
            Pelicula p = (Pelicula) a;
            Duration duracion = Duration.between(
                    p.getFechaAlquiler(), LocalDateTime.now());

            if (duracion.toHours() > 48) {
                throw new ExcepcionTiempoAlquiler("Se ha superado 48 horas");
            }

            p.devolver();
            c.eliminarArticulo(p);
        }
    }

    public void darBajaCliente(String numSocio) {
        Cliente c = buscarCliente(numSocio);
        if (c != null) {
            c.darDeBaja();
        }
    }

    public void darBajaArticulo(String cod) {
        Articulo a = buscarArticulo(cod);
        if (a != null) {
            a.darDeBaja();
        }
    }
}