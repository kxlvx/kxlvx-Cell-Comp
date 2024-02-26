/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.cliente;
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
public class BD_cliente {
    //Atributosn que permiten la conexion a la base de dtaos
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.ObtenerConexion();
    private String sSQL = "";
    public Integer totalregistros;
    
    /**
     * Retorna un DefaultTableModel modelo para visualizar el contenido en una tabla
     * @param buscar
     * @return DefaultTableModel modelo
     */
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Cliente", "RUC", "Nombres", "Apellidos", "Direccion", "Empresa", "Lugar de Trabajo", "Telf./Cel.", "Email"};
        String[] registro = new String[9];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        //sSQL = "select * from cliente where ruc_clie like '%" + buscar + "%' order by cod_cliente desc";
        sSQL = "select * from cliente where ruc_clie like '%" + buscar + "%' or nombres_clie like'" + buscar + "%' or apellidos_clie like'" + buscar + "%' order by cod_cliente asc";
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
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion de la base de datos: "
                    + "\n" + e.getMessage());
            //JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    /**
     * Metodo para insertar un cliente en la base de datos
     * @param dts
     * @return 
     */
    public boolean insertar(cliente dts) {
        sSQL = "insert into cliente (ruc_clie,nombres_clie,apellidos_clie,dirección_clie,empresa,lugar_trabajo,telefono_clie,email_clie)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setString(1, dts.getRuc_clie());
            pst.setString(2, dts.getNombres_clie());
            pst.setString(3, dts.getApellidos_clie());
            pst.setString(4, dts.getDireccion_clie());
            pst.setString(5, dts.getEmpresa());
            pst.setString(6, dts.getLugar_trabajo());
            pst.setString(7, dts.getTelefono_clie());
            pst.setString(8, dts.getEmail_clie());
            
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
    
    /**
     * Metodo para actualizar datos del cliente
     * @param dts
     * @return 
     */
    public boolean editar(cliente dts) {
        sSQL = "update cliente  set ruc_clie=?,nombres_clie=?,apellidos_clie=?,dirección_clie=?,empresa=?,lugar_trabajo=?,telefono_clie=?,email_clie=?"+
                " where cod_cliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getRuc_clie());
            pst.setString(2, dts.getNombres_clie());
            pst.setString(3, dts.getApellidos_clie());
            pst.setString(4, dts.getDireccion_clie());
            pst.setString(5, dts.getEmpresa());
            pst.setString(6, dts.getLugar_trabajo());
            pst.setString(7, dts.getTelefono_clie());
            pst.setString(8, dts.getEmail_clie());
            pst.setInt(9, dts.getCod_cliente());
            
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
    
    /**
     * Metodo para eliminar un cliente
     * @param dts
     * @return 
     */
    public boolean eliminar(cliente dts) {
        sSQL = "delete from cliente where cod_cliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getCod_cliente());
            
            int n = pst.executeUpdate();
            
            return n != 0;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar:"
                    + "\n" + e.getMessage());
            //JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
