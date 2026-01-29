import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Persona {
    private String nombre;
    private String DNI;
    private String fechaNacimiento;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Persona(String telefono, String email, String direccion , String nombre, String DNI, Date fechaNacimiento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.fechaNacimiento = LocalDateTime.now().format(dtf);
    }
}
