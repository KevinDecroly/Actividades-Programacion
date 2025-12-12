public class Sensei {
    private String codSensei;
    private Chakra chakra;
    private Rango rango;
    private double estrategia;
    private double liderazgo;

    //Constructor
    public Sensei(String codSensei, Chakra chakra,Rango rango) {
        this.codSensei = codSensei;
        this.chakra = chakra;
        this.rango = rango;
        this.liderazgo = liderazgo;
        this.estrategia = estrategia;
    }

    //Getters y setters
    public String getCodSensei() {return codSensei;}
    public Chakra getChakra() {return chakra;}
    public Rango getRango() {return rango;}
    public double getEstrategia() {return estrategia;}
    public double getLiderazgo() {return liderazgo;}

    public void setEstrategia(double estrategia) {this.estrategia = estrategia;}
    public void setLiderazgo(double liderazgo) {this.liderazgo = liderazgo;}

    //Mostrar info del sensei
    public String infoSensei() {
        StringBuilder senseii = new StringBuilder("Sensei\n");
        senseii.append("codSensei: " + codSensei + "\n");
        senseii.append("chakra: " + chakra + "\n");
        senseii.append("rango: " + rango + "\n");
        senseii.append("estrategia: " + estrategia + "\n");
        senseii.append("liderazgo: " + liderazgo + "\n");
        return senseii.toString();
    }
}
