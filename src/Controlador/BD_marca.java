/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.marca;
import Entidades.telefono_proveedor;
//import conexioncellcomp.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author kalva
 */
public class BD_marca {

    public DefaultTableModel mostrar(String buscar) {
        Conexion con = new Conexion();
        Connection connection = con.ObtenerConexion();
        String titulo[] = {"ID Marca", "Nombre Marca"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("Select * from marca where id_marca like'" + buscar + "%' or nombre_marca like'" + buscar + "%' order by id_marca ");//susceptible de sql injectioninjection
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

    public boolean insertar(marca m) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("insert into marca (nombre_marca)" +
                "values (?)");
            pst.setString(1, m.getNombre_marca());
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
    
    /**
    public boolean insertar(telefono_proveedor dts) {
        sSQL = "insert into telefono_proveedor (cod_proveedor,telefono)" +
                "values (?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getCod_proveedor());
            pst.setString(2, dts.getTelefono());
            
            
            int n = pst.executeUpdate();
            
            return n != 0;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos, verifique si ingreso bien los datos, el codigo del error es el siguiente:"
                    + "\n" + e.getMessage());
            //JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    * **/

    public boolean eliminar(int id_marca) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Delete from marca where id_marca=?");
            pst.setInt(1, id_marca);
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

    public boolean editar(marca car) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();

        try {
            PreparedStatement pst = reg.prepareStatement("update marca set nombre_marca=? Where id_marca= ?");

            pst.setString(1, car.getNombre_marca());
            pst.setInt(2, car.getId_marca());
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
