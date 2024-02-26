package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joffre Cartuche C
 */
public class Conexion {

    private static Connection conexion = null;
    private static final String usuario = "root";
    private static final String contrasena = "";// 192.168.7.110     localhost:3306
    private static final String url = "jdbc:mysql://127.0.0.1/cellcomp";

    public Conexion() {
    }

    public static Connection ObtenerConexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No hay Conexión a la base de datos para acceder al Sistema");

        }
        return conexion;

    }

    public static void main(String[] args) {
        ObtenerConexion();
    }
}
