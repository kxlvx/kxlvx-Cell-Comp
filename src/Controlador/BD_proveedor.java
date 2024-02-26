/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.proveeedor;
//import conexioncellcomp.Conexion;
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
public class BD_proveedor {

    public DefaultTableModel mostrar(String buscar) {
        Conexion con = new Conexion();
        Connection connection = con.ObtenerConexion();
        String titulo[] = {"Codigo Proveedor", "Nombre Empresa", "Representante", "Direccion", "Ciudad"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("Select * from proveedor where cod_proveedor like'" + buscar + "%' or nombre_empresa_pv like'" + buscar + "%'");//susceptible de sql injection
            while (resultado.next()) {
                Object tabla1[] = {
                    resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5)};
                modelo.addRow(tabla1);
            }
            return modelo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean insertar(proveeedor emp) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Insert into proveedor values(?,?,?,?,?)");
            pst.setInt(1, emp.getCod_proveedor());
            pst.setString(2, emp.getNombre_empresa_pv());
            pst.setString(3, emp.getRepresentante());
            pst.setString(4, emp.getDireccion_pv());
            pst.setString(5, emp.getCiudad());

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

    public boolean eliminar(int cod_proveedor) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Delete from proveedor where cod_proveedor=?");
            pst.setInt(1, cod_proveedor);
            int n = pst.executeUpdate();
            System.out.println(n);
            if (n != 0) {
                op = true;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.getMessage();
        }
        return op;
    }

    public boolean editar(proveeedor pro) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();

        try {
            PreparedStatement pst = reg.prepareStatement("update proveedor set nombre_empresa_pv=?,representante=?,direccion_pv=?,ciudad=? Where cod_proveedor= ?");

            pst.setString(1, pro.getNombre_empresa_pv());
            pst.setString(2, pro.getRepresentante());
            pst.setString(3, pro.getDireccion_pv());
            pst.setString(4, pro.getCiudad());
            pst.setInt(5, pro.getCod_proveedor());
            int n = pst.executeUpdate();
            if (n > 0) {
                //    JOptionPane.showMessageDialog(null, "modificado con exito");
                modif = true;
            } else {
                //     JOptionPane.showMessageDialog(null, "la modificacion no fue exitosa ", "PROYECTO DE PROGRAMACION", JOptionPane.YES_OPTION);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modif;
    }
}
