public class ExcesoVelocidadException extends RuntimeException {

    private static final long serialVersionUID = 3118700429099283422L;

    private int velocidad;

    public ExcesoVelocidadException(int velocidad, String msg) {
        super("Exceso de velocidad registrado " + velocidad);
        this.velocidad = velocidad;
    }

    @Override public String toString() {
        return "ExcesoVelocidadException [nuevaVelocidad=" + velocidad + "]";
    }
}
