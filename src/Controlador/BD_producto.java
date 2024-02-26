package Controlador;

import Entidades.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kalva
 */
public class BD_producto {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.ObtenerConexion();
    private String sSQL = "";
    private String sSQL2 = "";
    // public Integer totalregistros;
//

    /**
     *
     * @param buscar
     * @return
     */
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Cod. Producto", "Proveedor", "Marca", "Categoria", "Nombre", "Modelo", "Imei", "Descripcion", "Precio Compra", "Precio Venta", "Iva", "Stock"};
        Object[] registro = new Object[12];

        modelo = new DefaultTableModel(null, titulos);
//p producto --pr proveedor // m marca / c categoria 
//        sSQL = "select p.cod_producto,pr.nombre_empresa_pv,m.nombre_marca,c.nombre_categoria ,p.nombre_prod,"
//                + "p.modelo_prod,p.imei_serie_producto,p.descripcion_prod,p.precio_compra_prod,p.precio_venta_publico_prod,"
//                + "p.iva_prod,p.stock_disponible_prod from producto p inner join proveedor pr"
//                + "on p.cod_proveedor=pr.cod_proveedor inner join marca m on p.marca_id_marca=m.marca_id_marca"
//                + " inner join categoria c on p.id_categoria=c.id_categoria"
//                + " where cod_producto like '%"
//                + buscar + "%' or cod_proveedor like'" + buscar + "%' or marca_id_marca like'" + buscar + "%' order by cod_producto desc";
        sSQL = "select * from producto where cod_producto like '" + buscar + "%' or nombre_prod like '" + buscar + "%'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registro[0] = rs.getInt(1);
                registro[1] = rs.getInt(2);
                registro[2] = rs.getInt(3);
                registro[3] = rs.getInt(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
                registro[8] = rs.getDouble(9);
                registro[9] = rs.getDouble(10);
                registro[10] = rs.getDouble(11);
                registro[11] = rs.getInt(12);
                //  totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error durante la conexion con la base de datos:\n" + e.getMessage());

            return null;
        }
    }

    public boolean insertar(producto emp) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Insert into producto(cod_proveedor,marca_id_marca,id_categoria,nombre_prod,modelo_prod,imei_serie_producto,descripcion_prod,precio_compra_prod,precio_venta_publico_prod,iva_prod,stock_disponible_prod) values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, emp.getCod_proveedor());
            pst.setInt(2, emp.getMarca_id_marca());
            pst.setInt(3, emp.getId_categoria());
            pst.setString(4, emp.getNombre_prod());
            pst.setString(5, emp.getModelo_prod());
            pst.setString(6, emp.getImei_serie_producto());
            pst.setString(7, emp.getDescripcion_prod());
            pst.setDouble(8, emp.getPrecio_compra_prod());
            pst.setDouble(9, emp.getPrecio_venta_publico_prod());
            pst.setDouble(10, emp.getIva_prod());
            pst.setInt(11, emp.getStock_disponible_prod());
            int n = pst.executeUpdate();
            if (n != 0) {
                op = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.getMessage();
//            JOptionPane.showMessageDialog(null,"El cliente no se ingreso");
        }
        return op;

    }

    public boolean eliminar(int cod_producto) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Delete from producto where cod_producto=?");
            pst.setInt(1, cod_producto);
            int n = pst.executeUpdate();
            System.out.println(n);
            if (n != 0) {
                op = true;

            }
        } catch (SQLException e) {
            // e.getNextException();
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto ");

        }
        return op;
    }

    public boolean editar(producto emp) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();

        try {
            PreparedStatement pst = reg.prepareStatement("update producto set cod_proveedor=?,marca_id_marca=?,id_categoria=?,nombre_prod=?,modelo_prod=?,imei_serie_producto=?,descripcion_prod=?,precio_compra_prod=?,precio_venta_publico_prod=?,iva_prod=?,stock_disponible_prod=? Where cod_producto= ?");

            pst.setInt(1, emp.getCod_proveedor());
            pst.setInt(2, emp.getMarca_id_marca());
            pst.setInt(3, emp.getId_categoria());
            pst.setString(4, emp.getNombre_prod());
            pst.setString(5, emp.getModelo_prod());
            pst.setString(6, emp.getImei_serie_producto());
            pst.setString(7, emp.getDescripcion_prod());
            pst.setDouble(8, emp.getPrecio_compra_prod());
            pst.setDouble(9, emp.getPrecio_venta_publico_prod());
            pst.setDouble(10, emp.getIva_prod());
            pst.setInt(11, emp.getStock_disponible_prod());
            pst.setInt(12, emp.getCod_producto());
            int n = pst.executeUpdate();
            if (n > 0) {

                modif = true;
            }
        } catch (SQLException ex) {
            System.out.println("Sucedio una excepcion al modificar el producto" + ex.getMessage());
        }
        return modif;
    }

    public boolean editarCantidad(int id, int stock) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();
        stock = mostrarCodigo(id) - stock;
        try {
            PreparedStatement pst = reg.prepareStatement("update producto set stock_disponible_prod=? Where cod_producto= ?");

            pst.setInt(1, stock);
            pst.setInt(2, id);
            int n = pst.executeUpdate();
            if (n > 0) {

                modif = true;
            }
        } catch (SQLException ex) {
            System.out.println("Sucedio una excepcion al modificar el producto" + ex.getMessage());
        }
        return modif;
    }

    public int mostrarCodigo(int buscar) {
        sSQL = "select stock_disponible_prod from producto where cod_producto =" + buscar + ";";
        int codigo = -1;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                codigo = rs.getInt(1);

            }
            return codigo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error durante la conexion con la base de datos:\n" + e.getMessage());
            return -1;
        }
    }

}
