public class Libro {

    //Crear los atributos o campos de la clase (encapsulación)
    private String titulo;
    private String autor;
    private int nPaginas;
    private String ISBN;
    private String editora;
    private String fechaPublicacion;
    private int edicion;

    //Constructor / Constructores
    //Constructor con atributos imprescindibles
    public Libro(String titulo, String autor, String ISBN, String fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = 1;
        this.nPaginas = 1;
        this.editora = "Auto-Publicación";
    }

    //Constructor con todos los atributos
    public Libro(String titulo, String autor, String ISBN,String fechaPublicacion,
                 String editora, int edicion, int nPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = edicion;
        this.nPaginas = nPaginas;
        this.editora = editora;

    }
    /*
    DEFINIMOS LOS GETTER Y LOS SETTER DE LOS ATRIBUTOS
    */

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getfechaPublicacion() {
        return this.fechaPublicacion;
    }

    public int getEdicion() {
        return this.edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getNPaginas() {
        return this.nPaginas;
    }
    public void setNPaginas(int NPaginas) {
        if (NPaginas > 0) {
            this.nPaginas = nPaginas;
        }
    }

    public String getEditora() {
        return this.editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    //Metodos

    /**
     * Metodo: mostrar información del libro
     */
    public String infolibro (){
        String infolibro = "";
        infolibro += "Titulo: " + this.titulo + "\n";
        infolibro += "Autor: " + this.autor + "\n";
        infolibro += "ISBN: " + this.ISBN + "\n";
        infolibro += "Fecha de publicacion: " + this.fechaPublicacion + "\n";
        infolibro += "Editora: " + this.editora + "\n";
        infolibro += "Edicion: " + this.edicion + "\n";
        infolibro += "NPaginas: " + this.nPaginas + "\n";

        String info = String.format("Libro - Titulo: %s, Autor: %s, ISBN: %s, Fecha de publicacion: %s, Editora: %s, Ediciom: %s, NPaginas: %s")

        return infolibro;
    }
}
