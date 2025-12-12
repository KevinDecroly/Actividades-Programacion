import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Equipo {

    //Atributos
    private String nombreEquipo;
    private String codEquipo;
    private String fechaCreacion;
    private String Sensei;
    private int maxNinja;

    private Ninja [] ninjas;
    private static int contadorEquipo = 0;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Equipo() {}

    public Equipo(String codEquipo,String nombreEquipo, String Sensei,Rango rango, int maxNinja,) {
        this.maxNinja = contadorEquipo;
        this.fechaCreacion = LocalDate.now().format(dtf);
        this.codEquipo = codEquipo;
        this.nombreEquipo = nombreEquipo;
        this.Sensei = Sensei;

        contadorEquipo++;
    }

    public int getMaxNinja() {
        return this.maxNinja;
    }
    public String getfechaCreacion() {
        return this.fechaCreacion;
    }
    public String codEquipo() {
        return this.codEquipo;
    }
    public String nombreEquipo() {
        return this.nombreEquipo;
    }
    public String Sensei() {
        return this.Sensei;
    }

    public String monstrarInfoEquipo() {
        String infoEquipo = "";

        infoEquipo += "Nombre: " + this.nombreEquipo + "\n";
        infoEquipo += "Cod: " + this.codEquipo + "\n";
        infoEquipo += "Sensei: " + this.Sensei + "\n";
        infoEquipo += "Max Ninja: " + this.maxNinja + "\n";
        return infoEquipo;
    }
}
