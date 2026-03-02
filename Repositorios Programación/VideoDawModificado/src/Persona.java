import java.time.LocalDate;
import java.time.Period;

public class Persona {

    protected String dni;
    protected String nombre;
    protected String direccion;
    protected LocalDate fechaNacimiento;

    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {

        if (!validarDNI(dni)) {
            throw new IllegalArgumentException("DNI no válido");
        }

        if (!esMayorDeEdad(fechaNacimiento)) {
            throw new IllegalArgumentException("Debe ser mayor de edad");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    private boolean validarDNI(String dni) {
        return dni.matches("\\d{8}[A-Z]");
    }

    private boolean esMayorDeEdad(LocalDate fecha) {
        return Period.between(fecha, LocalDate.now()).getYears() >= 18;
    }

    @Override
    public String toString() {
        return "DNI: " + dni +
                "\nNombre: " + nombre +
                "\nDireccion: " + direccion +
                "\nFecha Nacimiento: " + fechaNacimiento;
    }
}