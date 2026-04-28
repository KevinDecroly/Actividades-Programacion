import java.io.*;

public class Principal {
    public static void main(String[] args)
    {
        final String path = ".\\src\\resources\\";
        String fileName = "Peliculas.txt";
        boolean fileMode = true;

        //Estructura con try- catch con recursos
        try(FileWriter file = new FileWriter(path+fileName, fileMode);
            BufferedWriter bufferedWriter = new BufferedWriter(file)){
            bufferedWriter.write("La Comunidad del anillo");
            bufferedWriter.newLine();
            bufferedWriter.write("Las dos torres");
            bufferedWriter.newLine();
            bufferedWriter.write("El retorno del rey");
            bufferedWriter.newLine();
            bufferedWriter.write("El Hobbit: un viaje inesperado");
            bufferedWriter.newLine();

            System.out.println("Se ha realizado el proceso correctamente");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
