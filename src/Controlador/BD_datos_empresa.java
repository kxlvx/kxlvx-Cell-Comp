/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Entidades.datos_empresa;
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
public class BD_datos_empresa {

    public DefaultTableModel mostrar(String buscar) {
        Conexion con = new Conexion();
        Connection connection = con.ObtenerConexion();
        String titulo[] = {"Codigo Empresa", "Nombre ,Ruc", "Gerente", "Direccion", "Ciudad", "Provincia"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("Select * from datos_empresa where cod_empresa like'" + buscar + "%' or nombre_empresa	like'" + buscar + "%'");//susceptible de sql injectioninjection
            while (resultado.next()) {
                Object tabla1[] = {resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5),
                    resultado.getString(6),
                    resultado.getString(7)
                };
                modelo.addRow(tabla1);
            }
            return modelo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean insertar(datos_empresa datos) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Insert into datos_empresa values(?,?,?,?,?,?,?)");
            pst.setInt(1, datos.getCod_empresa());
            pst.setString(2, datos.getNombre_empresa());
            pst.setString(3, datos.getRuc_empresa());
            pst.setString(4, datos.getGerente());
            pst.setString(5, datos.getDireccion_empresa());
            pst.setString(6, datos.getCiudad_empresa());
            pst.setString(7, datos.getProvincia_empresa());
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

    public boolean eliminar(int cod_empresa) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Delete from datos_empresa where cod_empresa=?");
            pst.setInt(1, cod_empresa);
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

    public boolean editar(datos_empresa datos) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();

        try {
            PreparedStatement pst = reg.prepareStatement("update datos_empresa set nombre_empresa=?,ruc_empresa=?,gerente=?,direccion_empresa=?,ciudad_empresa=?,provincia_empresa=? Where cod_empresa= ?");
            pst.setString(1, datos.getNombre_empresa());
            pst.setString(2, datos.getRuc_empresa());
            pst.setString(3, datos.getGerente());
            pst.setString(4, datos.getDireccion_empresa());
            pst.setString(5, datos.getCiudad_empresa());
            pst.setString(6, datos.getProvincia_empresa());
              pst.setInt(7, datos.getCod_empresa());
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
