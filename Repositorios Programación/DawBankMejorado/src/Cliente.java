import java.util.Date;

public class Cliente extends Persona {
    private String telefono;
    private String email;
    private String direccion;

    public Cliente(String telefono, String email, String direccion, String nombre, String DNI, Date fechaNacimiento) {
        super(telefono, email, direccion, nombre, DNI, fechaNacimiento);
    }
}
