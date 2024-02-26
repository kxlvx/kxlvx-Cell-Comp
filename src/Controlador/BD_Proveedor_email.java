/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.email_proveedor;
import Entidades.empleado;
import Entidades.telefono_proveedor;
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
public class BD_Proveedor_email {
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
        
        String[] titulos = {"Id Email", "Cod. Proveedor", "Proveedor", "Email"};
        String[] registro = new String[4];
        

        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select t.cod_email_prov,p.cod_proveedor,p.nombre_empresa_pv,t.email_proveedor"+
                " from proveedor p inner join email_proveedor t "+
                "on p.cod_proveedor=t.cod_proveedor  where p.cod_proveedor like '%" + 
                buscar + "%' order by cod_email_prov asc";
        //or telefono like'" + buscar + "%' 
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
               

                //totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar o al leer la base de datos, el codigo del error es el siguiente:"
                    + "\n" + e.getMessage());
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    

    public boolean insertar(email_proveedor dts) {
        sSQL = "insert into email_proveedor (cod_proveedor,email_proveedor)" +
                "values (?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getCod_proveedor());
            pst.setString(2, dts.getEmail_proveedor());
            
            
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
    public boolean editar(email_proveedor dts) {
        sSQL = "update email_proveedor set cod_proveedor=?,email_proveedor=? where cod_email_prov=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getCod_proveedor());
            pst.setString(2, dts.getEmail_proveedor());
            pst.setInt(4, dts.getCod_email_prov());
            
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
    public boolean eliminar(email_proveedor dts) {
        sSQL = "delete from email_proveedor where cod_email_prov=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getCod_email_prov());
            
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
