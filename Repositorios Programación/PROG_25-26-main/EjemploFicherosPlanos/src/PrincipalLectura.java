import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrincipalLectura {
    public static void main(String[] args) {

        final String path = ".\\src\\resources\\";
        String fileName = "Peliculas.txt";

        try(FileReader file = new FileReader(path+fileName);
        BufferedReader bufferedReader = new BufferedReader(file);){
            String linea = "";
            while(linea != null){
                linea = bufferedReader.readLine();
                if(linea != null){
                    if(!linea.equals("")){
                        System.out.println(linea);
                    }

                }

            }

        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
