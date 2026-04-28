import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PrincipalConBucle
{
    public static void main(String[] args)
    {
        final String path = ".\\src\\resources\\";
        final String filename = "productos.dat";
        final boolean fileMode = false;

        List<Producto> productos = new LinkedList<>();

        Producto p1 = new Producto("p-0001","Switch 2","Nintendo Switch 2", 499.90, 300);
        Producto p2 = new Producto("p-0002", "PS5", "Playstation 5", 400.0, 25);
        Producto p3 = new Producto("p-0003", "XBOX X", "Xbox Series X", 420.0, 13);
        Producto p4 = new Producto("p-0004","Switch 1","Nintendo Switch 1", 299.90, 300);
        Producto p5 = new Producto("p-0005","PS4","PlayStation 4", 499.90, 300);

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

        try(FileOutputStream file =  new FileOutputStream(path + filename, fileMode);
            DataOutputStream writer = new DataOutputStream(file)) {

            for (Producto producto : productos) {
                writer.writeUTF(producto.getCodigo());
                writer.writeUTF(producto.getNombre());
                writer.writeUTF(producto.getDescripcion());
                writer.writeDouble(producto.getPrecio());
                writer.writeInt(producto.getCantidad());
            }

            System.out.println("Se ha realziado correctamente la escritura");
        } catch (IOException e) {
            System.err.println("Error al manejar el archivo: " + e.getMessage());
        }
    }
}
