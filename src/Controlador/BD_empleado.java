/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.empleado;
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
public class BD_empleado {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.ObtenerConexion();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;
    /**
     * 
     * @param buscar
     * @return 
     */
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Empleado", "Cod. Cargo", "RUC", "Nombres", "Apellidos", "Direccion", "Email", "Usuario", "Contraseña", "Cargo", "Sueldo"};
        String[] registro = new String[11];
        

        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select e.cod_empleado,c.cod_cargo,e.ruc_emp,e.nombres_emp,e.apellidos_emp,"+
                "e.direccion_emp,e.email_emp,e.user_emp,e.contraseña_emp,c.nombre_cargo,c.sueldo from cargo c inner join empleado e "+
                "on c.cod_cargo=e.cod_cargo where ruc_emp like '%" + 
                buscar + "%' or nombres_emp like'" + buscar + "%' or apellidos_emp like'" + buscar + "%' order by cod_empleado desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
                registro[8] = rs.getString(9);
                registro[9] = rs.getString(10);
                registro[10] = rs.getString(11);

                //totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar o al leer la base de datos desde la lista enlazada el codigo del error es el siguiente:"
                    + "\n" + e.getMessage());
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrar1(String buscar) {
        Conexion con = new Conexion();
        Connection connection = con.ObtenerConexion();
        String titulo[] = {"Codigo Empleado", "Codigo Cargo", "Ruc Empresa", "Nombre", "Apellidos", "Direccion", "Email", "User", "Contraseña"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("Select * from empleado where cod_empleado like'" + buscar + "%' or nombres_emp like'" + buscar + "%'");//susceptible de sql injection
            while (resultado.next()) {
                Object tabla1[] = {resultado.getInt(1),
                    resultado.getInt(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5),
                    resultado.getString(6),
                    resultado.getString(7),
                    resultado.getString(8),
                    resultado.getString(9)};
                modelo.addRow(tabla1);
            }
            return modelo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean insertar(empleado emp) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Insert into empleado values(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, emp.getCod_empleado());
            pst.setInt(2, emp.getCod_cargo());
            pst.setString(3, emp.getRuc_emp());
            pst.setString(4, emp.getNombres_emp());
            pst.setString(5, emp.getApellidos_emp());
            pst.setString(6, emp.getDireccion_emp());
            pst.setString(7, emp.getEmail_emp());
            pst.setString(8, emp.getUser_emp());
            pst.setString(9, emp.getContraseña_emp());
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

    public boolean eliminar(int cod_empleado) {
        Conexion con = new Conexion();
        boolean op = false;
        try (Connection connection = con.ObtenerConexion()) {
            PreparedStatement pst = connection.prepareStatement("Delete from empleado where cod_empleado=?");
            pst.setInt(1, cod_empleado);
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

    public boolean editar(empleado emp) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();

        try {
            PreparedStatement pst = reg.prepareStatement("update empleado set cod_cargo=?,ruc_emp=?,nombres_emp=?,apellidos_emp=?,direccion_emp=?,email_emp=?,user_emp=?,contraseña_emp=? Where cod_empleado= ?");

            pst.setInt(1, emp.getCod_cargo());
            pst.setString(2, emp.getRuc_emp());
            pst.setString(3, emp.getNombres_emp());
            pst.setString(4, emp.getApellidos_emp());
            pst.setString(5, emp.getDireccion_emp());
            pst.setString(6, emp.getEmail_emp());
            pst.setString(7, emp.getUser_emp());
            pst.setString(8, emp.getContraseña_emp());
            pst.setInt(9, emp.getCod_empleado());

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "modificado con exito");
                modif = true;
            } else {
                JOptionPane.showMessageDialog(null, "la modificacion no fue exitosa ", "PROYECTO DE PROGRAMACION", JOptionPane.YES_OPTION);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modif;
    }
    
    
    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Empleado", "Cod. Cargo", "Nombres", "Apellidos", "Usuario", "Contraseña", "Cargo"};
        String[] registro = new String[7];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select e.cod_empleado,c.cod_cargo,e.nombres_emp,e.apellidos_emp,"+
                "e.user_emp,e.contraseña_emp,c.nombre_cargo from cargo c inner join empleado e "+
                "on c.cod_cargo=e.cod_cargo where user_emp='" + 
                login + "' and e.contraseña_emp ='" + password + "'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);

                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos, error de inicio de sesion, el codigo del error es el siguiente:"
                    + "\n" + e.getMessage());
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

}
