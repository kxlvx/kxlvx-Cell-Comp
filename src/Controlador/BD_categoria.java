/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.categoria;
//import conexioncellcomp.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 * @author kalva
 */
public class BD_categoria {

    public DefaultTableModel mostrar(String buscar) {
        Conexion con = new Conexion();
        Connection connection = con.ObtenerConexion();
        String titulo[] = {"ID Categoria", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("Select * from categoria where id_categoria like'" + buscar + "%' or nombre_categoria like'" + buscar + "%' order by id_categoria asc");//susceptible de sql injectioninjection
            while (resultado.next()) {
                Object tabla1[] = {resultado.getInt(1),
                    resultado.getString(2),};
                modelo.addRow(tabla1);
            }
            return modelo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean insertar(categoria cat) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("insert into categoria (nombre_categoria) values(?)");

            pst.setString(1, cat.getNombre_categoria());
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

    public boolean eliminar(int cod_categoria) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Delete from categoria where id_categoria=?");
            pst.setInt(1, cod_categoria);
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

    public boolean editar(categoria car) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();

        try {
            PreparedStatement pst = reg.prepareStatement("update categoria set nombre_categoria=? Where id_categoria= ?");

            pst.setString(1, car.getNombre_categoria());
            pst.setInt(2, car.getId_categoria());
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
