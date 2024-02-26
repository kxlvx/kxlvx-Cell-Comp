/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kalva
 */
public class BD_cargo{
 
    public DefaultTableModel mostrar(String buscar) {
        Conexion con = new Conexion();
        Connection connection = con.ObtenerConexion();
        String titulo[] = {"Codigo Cargo", "Nombre Cargo", "Sueldo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("Select * from cargo where cod_cargo like'" + buscar + "%' or nombre_cargo like'" + buscar + "%'");//susceptible de sql injectioninjection
            while (resultado.next()) {
                Object tabla1[] = {resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3)
                };
                modelo.addRow(tabla1);
            }
            return modelo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean insertar(cargo carg) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Insert into cargo values(?,?,?)");
            pst.setInt(1, carg.getCod_cargo());
            pst.setString(2, carg.getNombre_cargo());
            pst.setDouble(3, carg.getSueldo());
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

    public boolean eliminar(int cod_cargo) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Delete from cargo where cod_cargo=?");
            pst.setInt(1, cod_cargo);
            int n = pst.executeUpdate();
            System.out.println(n);
            if (n != 0) {
                op = true;
                System.out.println("borro");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.getMessage();
        }
        return op;
    }

    public boolean editar(cargo car) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();

        try {
            PreparedStatement pst = reg.prepareStatement("update cargo set nombre_cargo=?,sueldo=? Where cod_cargo= ?");

            pst.setString(1, car.getNombre_cargo());
            pst.setDouble(2, car.getSueldo());
            pst.setInt(3, car.getCod_cargo());
            int n = pst.executeUpdate();
            if (n > 0) {
                //    JOptionPane.showMessageDialog(null, "modificado con exito");
                modif = true;
            } else {
                //   JOptionPane.showMessageDialog(null, "la modificacion no fue exitosa ", "PROYECTO DE PROGRAMACION", JOptionPane.YES_OPTION);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modif;
    }
}
