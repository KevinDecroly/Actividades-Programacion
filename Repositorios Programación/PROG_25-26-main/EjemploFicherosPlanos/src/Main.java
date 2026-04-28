import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final String path = "C:\\FicherosEjemplos\\";
        String fileName = "Peliculas.txt";
        boolean fileMode = true;

        //Abrir el fichero
        FileWriter file = null;
        try{
            file = new FileWriter(path+fileName, fileMode);
        }catch (IOException e){
            System.out.println("Error al abrir el archivo");
            return;
        }

        //Escribir
        BufferedWriter buffer = new BufferedWriter(file);
        try{
            buffer.write("La Comunidad del anillo");
            buffer.newLine();
            buffer.write("Las dos torres");
            buffer.newLine();
            buffer.write("El retorno del rey");
            buffer.newLine();
            buffer.write("El Hobbit: un viaje inesperado");
            buffer.newLine();
        }catch (IOException e){
        System.out.println("Error al escribir el archivo");
        }

        //Cerrar fichero y buffer
        try{
            buffer.close();
            file.close();

            System.out.println("Se ha realizado el proceso correctamente");

        }catch (IOException e){
            System.out.println("Error al cerrar el archivo");
        }
    }
}