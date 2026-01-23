public class Contacto {
    private String nombre;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    //Getter


    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    //Setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("====================\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Número: ").append(telefono).append("\n");
        sb.append("Email:  ").append(correo).append("\n");
        sb.append("====================");
        return sb.toString();
    }

}
