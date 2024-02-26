/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.telefono_empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samuel Isaias Calderon Aguirre
 */
public class BD_EmpleadoTelefono {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.ObtenerConexion();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    /**
     *
     * @param buscar
     * @param cod_proveedor
     * @return
     */
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id telefono", "Cod. Empleado", "Nombre Empleado", "Teléfono/Celular"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select t.cod_telf_emp,p.cod_empleado,p.nombres_emp,t.telefono_empleado"
                + " from empleado p inner join telefono_empleado t "
                + "on p.cod_empleado=t.cod_empleado  where p.cod_empleado like '%"
                + buscar + "%' order by cod_telf_emp asc";
        //or telefono like'" + buscar + "%' 

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);

                //totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar o al leer la base de datos, el codigo del error es el siguiente:"
                    + "\n" + e.getMessage());
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(telefono_empleado dts) {
        sSQL = "insert into telefono_empleado (cod_empleado,telefono_empleado) values (?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getCod_empleado());
            pst.setString(2, dts.getTelefono_empleado());

            int n = pst.executeUpdate();

            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos, verifique si ingreso bien los datos, el codigo del error es el siguiente:"
                    + "\n" + e.getMessage());
            //JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    /**
     * Metodo para actualizar datos del cliente
     *
     * @param dts
     * @return
     */
    public boolean editar(telefono_empleado dts) {
        sSQL = "update telefono_empleado set cod_empleado=?,telefono_empleado=? where cod_telf_emp=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getCod_empleado());
            pst.setString(2, dts.getTelefono_empleado());
            pst.setInt(3, dts.getCod_telefono_empleado());

            int n = pst.executeUpdate();

            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos, verifique si ingreso bien los datos, el codigo del error es el siguiente:"
                    + "\n" + e.getMessage());
            //JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    /**
     * Metodo para eliminar un cliente
     *
     * @param dts
     * @return
     */
    public boolean eliminar(telefono_empleado dts) {
        sSQL = "delete from telefono_empleado where cod_telf_emp=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getCod_telefono_empleado());

            int n = pst.executeUpdate();

            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar:"
                    + "\n" + e.getMessage());
            //JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
