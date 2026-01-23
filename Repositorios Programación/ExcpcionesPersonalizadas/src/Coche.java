public class Coche {
    private String marca;
    private String modelo;
    private String velocidad;

    public Coche(String marca, String modelo, String velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getColor() {
        return this.modelo;
    }

    public String getVelocidad() {
        return this.velocidad;
    }
}
