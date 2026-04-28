import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final String path = ".\\src\\resources\\";
        final String filename = "productos.dat";
        final boolean fileMode = false;

        Producto p1 = new Producto("p-0001","Switch 2","Nintendo Switch 2", 499.90, 300);
        Producto p2 = new Producto("p-0002", "PS5", "Playstation 5", 400.0, 25);
        Producto p3 = new Producto("p-0003", "XBOX X", "Xbox Series X", 420.0, 13);


        try(FileOutputStream file =  new FileOutputStream(path + filename, fileMode);
            DataOutputStream writer = new DataOutputStream(file)) {
            writer.writeUTF(p1.getCodigo());
            writer.writeUTF(p1.getNombre());
            writer.writeUTF(p1.getDescripcion());
            writer.writeDouble(p1.getPrecio());
            writer.writeInt(p1.getCantidad());

            writer.writeUTF(p2.getCodigo());
            writer.writeUTF(p2.getNombre());
            writer.writeUTF(p2.getDescripcion());
            writer.writeDouble(p2.getPrecio());
            writer.writeInt(p2.getCantidad());

            writer.writeUTF(p3.getCodigo());
            writer.writeUTF(p3.getNombre());
            writer.writeUTF(p3.getDescripcion());
            writer.writeDouble(p3.getPrecio());
            writer.writeInt(p3.getCantidad());

            System.out.println("Se ha realziado correctamente la escritura");
        } catch (IOException e) {
            System.err.println("Error al manejar el archivo: " + e.getMessage());
        }

    }
}