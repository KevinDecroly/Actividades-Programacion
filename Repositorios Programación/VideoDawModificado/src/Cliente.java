import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona {

    private String numSocio;
    private LocalDate fechaBaja;
    private ArrayList<Articulo> articulosAlquilados;

    public Cliente(String dni, String nombre, String direccion,
                   LocalDate fechaNacimiento, String numSocio) {

        super(dni, nombre, direccion, fechaNacimiento);
        this.numSocio = numSocio;
        this.articulosAlquilados = new ArrayList<>();
    }

    public String getNumSocio() {
        return numSocio;
    }

    public void agregarArticulo(Articulo a) {
        articulosAlquilados.add(a);
    }

    public void eliminarArticulo(Articulo a) {
        articulosAlquilados.remove(a);
    }

    public void mostrarArticulosAlquilados() {
        for (Articulo a : articulosAlquilados) {
            System.out.println(a);
        }
    }

    public void darDeBaja() {
        fechaBaja = LocalDate.now();
    }
}