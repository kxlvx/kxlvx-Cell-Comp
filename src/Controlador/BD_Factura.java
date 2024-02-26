/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kalva
 */
public class BD_Factura {

    public boolean insertar(Entidades.factura fa) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Insert into factura(cod_empleado,cod_cliente,num_factura,fecha_emision_fac,subtotal_0_fac,iva,subtotal_1_fac,descuento_fac,total_fac) values(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, fa.getCod_empleado());
            pst.setInt(2, fa.getCod_cliente());
            pst.setInt(3, fa.getNum_factura());
            pst.setDate(4, fa.getFecha_emision_fac());
            pst.setDouble(5, fa.getSubtotal_0_fac());
            pst.setDouble(6, fa.getIva());
            pst.setDouble(7, fa.getSubtotal_1_fac());
            pst.setDouble(8, fa.getDescuento_fac());
            pst.setDouble(9, fa.getTotal_fac());
            int n = pst.executeUpdate();
            if (n != 0) {
                op = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(null,"El cliente no se ingreso");
        }
        return op;

    }

    public static int UltimoRegistro() {
        Conexion con = new Conexion();
        Connection connection = con.ObtenerConexion();
        int ultimo = -1;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("select MAX(num_factura) from factura");//susceptible de sql injectioninjection
            while (resultado.next()) {
                ultimo = (int) resultado.getInt(1);
            }
            return ultimo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
