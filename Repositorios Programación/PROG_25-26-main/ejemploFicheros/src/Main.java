import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String path = "C:\\Windows";
        File carp = new File(path);

        if(carp.exists()){
            System.out.println("¿Tiene permisos de escritura?: " +carp.canWrite());
            String [] contenido = carp.list();

            System.out.println("Contenido: "+contenido.length);

            for(String fichero: contenido){
                File f = new File(path , fichero);
                if(f.isDirectory()){
                    System.out.println("Es una carpeta: "+fichero);
                }
                else{
                    System.out.println("Es un fichero: "+fichero);
                }
            }
        }
        else {
            System.out.println("La Carpeta no existe");
        }
    }
}