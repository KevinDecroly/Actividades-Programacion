import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void insertarProducto(Producto p) throws Exception {

        Connection con = ConexionBBDD.getConnection();

        if (con == null) {
            throw new Exception("Error de conexión");
        }

        // comprobar duplicado
        PreparedStatement check = con.prepareStatement(
                "SELECT * FROM producto WHERE referencia = ?");
        check.setString(1, p.getReferencia());

        ResultSet rs = check.executeQuery();

        if (rs.next()) {
            throw new ExcepcionProducto("La referencia ya existe");
        }

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO producto (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        ps.setString(1, p.getReferencia());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getDescripcion());
        ps.setInt(4, p.getTipo());
        ps.setInt(5, p.getCantidad());
        ps.setDouble(6, p.getPrecio());
        ps.setInt(7, p.getDescuento());
        ps.setInt(8, p.getIva());
        ps.setBoolean(9, p.isAplicarDto());

        ps.executeUpdate();

        con.close();
    }

    public List<Producto> mostrarProductos() throws Exception {

        List<Producto> lista = new ArrayList<>();

        Connection con = ConexionBBDD.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM producto");

        while (rs.next()) {
            Producto p = new Producto(
                    rs.getString("referencia"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("tipo"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio"),
                    rs.getInt("descuento"),
                    rs.getInt("iva"),
                    rs.getBoolean("aplicarDto")
            );
            lista.add(p);
        }

        con.close();
        return lista;
    }

    public Producto buscarPorReferencia(String ref) throws Exception {

        Connection con = ConexionBBDD.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM producto WHERE referencia = ?");
        ps.setString(1, ref);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Producto(
                    rs.getString("referencia"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("tipo"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio"),
                    rs.getInt("descuento"),
                    rs.getInt("iva"),
                    rs.getBoolean("aplicarDto")
            );
        } else {
            throw new ExcepcionProducto("Producto no encontrado");
        }
    }

    public void eliminarProducto(String ref) throws Exception {

        Connection con = ConexionBBDD.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM producto WHERE referencia = ?");
        ps.setString(1, ref);

        int filas = ps.executeUpdate();

        if (filas == 0) {
            throw new ExcepcionProducto("No existe el producto");
        }

        con.close();
    }
}