import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        final String path = ".\\src\\resources\\";
        final String filename = "productos.dat";

        List<Producto> productos = new LinkedList<>();

        boolean eof = false;

        try(FileInputStream file = new FileInputStream(path + filename);
            DataInputStream lector = new DataInputStream(file);){
                while(!eof){
                    String codido = lector.readUTF();
                    String nombre = lector.readUTF();
                    String descripcion = lector.readUTF();
                    double precio = lector.readDouble();
                    int cantidad = lector.readInt();

                    Producto p = new Producto(codido,nombre,descripcion,precio,cantidad);
                    productos.add(p);

                    //productos.add(new Producto(codido,nombre,descripcion,precio,cantidad));

                }

        } catch (EOFException e1) {
            eof = true;
            System.out.println("Se ha finalizado la lectura del archivo");

        } catch (IOException e2) {
            System.out.println("Error al manejar archivo: " + e2.getMessage());
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }

    }
}
