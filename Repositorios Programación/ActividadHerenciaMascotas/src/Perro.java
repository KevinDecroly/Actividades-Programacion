import java.time.LocalDate;

public Perro extends Mascotas{

    private String raza;

    private boolean pulgas;

    public Perro(String nombre, int edad, String estado, LocalDate fecha_nacimiento,
                String raza, boolean pulgas){
        super(nombre, edad, estado, fecha_nacimiento);
        this.raza =raza;
        this.pulgas = pulgas
    }
}
