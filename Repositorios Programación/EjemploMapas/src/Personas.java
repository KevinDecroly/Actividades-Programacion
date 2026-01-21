import java.util.Objects;

public class Personas implements Comparable<Personas> {
    private String dni;
    private String nombre;
    private String apellido;

    public Personas(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //GETTER
    public String getDni() {

        return dni;
    }

    public String getNombre() {

        return nombre;
    }

    public String getApellido() {

        return apellido;
    }

    //SETTER
    public void setDni(String dni) {

        this.dni = dni;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Personas{");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Personas personas = (Personas) o;
        return Objects.equals(dni, personas.dni) && Objects.equals(nombre, personas.nombre) && Objects.equals(apellido, personas.apellido);
    }

    @Override
    public int compareTo(Personas otraPersona) {
        return this.nombre.compareToIgnoreCase(otraPersona.nombre);

    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellido);
    }

}