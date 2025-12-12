import java.time.LocalDate;

public class Aldea {

    //Atributos privados
    private String nombre;
    private String cod;
    private LocalDate fechaCreacion;
    private int kage;
    private int maxEquipos;

    private Equipo[] equiposRegistrados;
    private int nEquiposActuales;

    private int contarEquipos;

    private Ninja[] ninjasRegistrados;
    private int nNinjasActuales;
    private int contarNinjas;

    public Aldea (String nombre, String cod){
    this.nombre = nombre;
    this.cod = cod;
    this.fechaCreacion = fechaCreacion;

    this.equiposRegistrados = new Equipo[3];

    this.contarEquipos = 0;
}

    public String getNombre() {
        return this.nombre;
    }
    public String getCod() {
        return this.cod;
    }
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    public boolean generarEquipo(Equipo e) {
        if (e ==null) return false;

        for (int i = 0; i < this.nEquiposActuales; i++) {
            if (equiposRegistrados[i].getfechaCreacion().equalsIgnoreCase(e.getfechaCreacion())){
                System.out.println("Error: Equipo ya existe");
                return false;
            }
        }
        if (nEquiposActuales >= equiposRegistrados.length) {
            Equipo[] aux = new Equipo[equiposRegistrados.length+1];
            System.arraycopy(equiposRegistrados, 0, aux, 0, equiposRegistrados.length);
            equiposRegistrados = aux;
        }
    }

    public boolean generarNinja(Ninja n) {
        if (n == null) return false;

        for (int i = 0; i < this.nNinjasActuales; i++) {
            if (ninjasRegistrados[i].getTecnicaSecreta().equalsIgnoreCase(n.getTecnicaSecreta())){
                System.out.println("Error: Ninja ya existe");
                return false;
            }
        }

        if (nNinjasActuales >= ninjasRegistrados.length) {
            Ninja[] aux = new Ninja[ninjasRegistrados.length+1];
            System.arraycopy(ninjasRegistrados, 0, aux, 0, ninjasRegistrados.length);
            ninjasRegistrados = aux;
        }
        ninjasRegistrados[nNinjasActuales] = n;
        return false;
    }

    //Generar Ninja
    private boolean registrarNinja(Ninja n) {
        if (n == null) {
            return false;
        }
    }

    //Eliminar Ninja
    public boolean eliminarNinja(Ninja n) {
        if (n == null) return false;
        n.setFechaSalida(LocalDate.now());
        return true;
    }

    //Mostrar Info de los Equipos
    public String infoEquipos(){
        return String.format("Nombre: %s | Cod: %s", this.nombre, this.cod);
    }

    //Mostrar info de los ninjas
    public String infoNinjas(){
        if (nNinjasActuales==0) return "No hay ninjas registrados";
        StringBuilder sb = new  StringBuilder("Ninjas registrados:\n");
        for (int i = 0; i < this.nNinjasActuales; i++) {
            sb.append(ninjasRegistrados[i].infoNinja()).append("\n");
        }
        return sb.toString();
    }

    //Mostrar info aldea
    public String infoAldea(){
        StringBuilder sb = new  StringBuilder("Aldea registrados:\n");
        sb.append("Nombre: ").append(this.nombre).append("\n");
        sb.append("Cod: ").append(this.cod).append("\n");
        sb.append("Fecha creacion: ").append(this.fechaCreacion).append("\n");
        sb.append("Kage: ").append(this.kage).append("\n");
        return sb.toString();

    }



    public int getContarEquipos() {
        return contarEquipos;
    }

    public void setContarEquipos(int contarEquipos) {
        this.contarEquipos = contarEquipos;
    }
}