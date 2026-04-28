import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class PrincipalTienda
{
    public static void main(String[] args) {

        final String path = ".\\src\\resources\\";
        String fileName = "productos.dat";

        LinkedList<Producto> listaProductos = new LinkedList<Producto>();

        try(FileReader file = new FileReader(path+fileName);
            BufferedReader bufferedReader = new BufferedReader(file);){
            String linea = "";
            while(linea != null){
                // tengo leer los productos
                linea = bufferedReader.readLine();
                if(linea != null){
                    if(!linea.equals("")){
                        String[] datosLinea = linea.split(",");
                        String codigo = datosLinea[0].trim();
                        String nombre = datosLinea[1].trim();
                        String descripcion = datosLinea[2].trim();
                        String precio = datosLinea[3].trim();
                        int cantidad = Integer.parseInt(datosLinea[4].trim());

                        Producto p = new Producto(codigo, nombre, descripcion, precio, cantidad);
                        listaProductos.add(p);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }

        for(Producto p : listaProductos){
            System.out.println(p);
        }
    }
}
