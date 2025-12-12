import java.time.LocalDate;

public class Ninja {
    private Chakra chakra ;
    private Rango rango;
    private String tecnicaSecreta;
    private LocalDate fechaAlta;
    private LocalDate fechaSalida;
    private double ataque;
    private double defensa;

    //Constructor
    public Ninja(Rango chakra, String tecnicaSecreta) {
        this.chakra = chakra;
        this.rango = rango;
        this.tecnicaSecreta = tecnicaSecreta;
        this.fechaAlta = LocalDate.now();
        this.fechaSalida = LocalDate.now();
        this.ataque = 0;
        this.defensa = 0;
    }

    //Getters y Setters
    public String getTecnicaSecreta() {return tecnicaSecreta;}
    public Chakra getChakra() {return chakra;}
    public Rango getRango() {return rango;}
     public LocalDate getFechaAlta() {return fechaAlta;}
    public LocalDate getFechaSalida() {return fechaSalida;}
    public double getAtaque() {return ataque;}
    public double getDefensa() {return defensa;}

    public void setFechaAlta(LocalDate fechaAlta) {this.fechaAlta = fechaAlta;}

    public void setFechaSalida(LocalDate fechaSalida) {this.fechaSalida = fechaSalida;
    }

    public void setRango(Rango rango) {this.rango = rango;}
    public void setAtaque(double ataque) {this.ataque = ataque;}
    public void setDefensa(double defensa) {this.defensa = defensa;}

    //Buscar Ninja
    public Ninja buscarNinja(String tecnicaSecreta) {
        for (int i =0; i < )
    }


    //Mostrar informacion del Ninja

    public String infoNinja() {
        StringBuilder sb = new StringBuilder("Ninja:\n");
        sb.append("Chakra: " + chakra + "\n");
        sb.append("Rango: " + rango + "\n");
        sb.append("Tecnica secreta: " + tecnicaSecreta + "\n");
        sb.append("Fecha alta: " + fechaAlta + "\n");
        sb.append("Fecha salida: " + fechaSalida + "\n");
        sb.append("Ataque: " + ataque + "\n");
        sb.append("Defensa: " + defensa);
        return sb.toString();
    }

    public enum Chakra {
        GENNIN,
        CHUNNIN,
        JONNIN,
        AMBU,
        KAGE
    }

    public enum Rango {
        TIERRA,
        FUEGO,
        AIRE,
        AGUA,
        RAYO
    }
}
