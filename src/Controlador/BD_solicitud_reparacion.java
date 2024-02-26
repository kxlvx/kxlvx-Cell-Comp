/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.empleado;
import Entidades.solicitud_reparacion;
import java.sql.Connection;
import java.sql.Date;
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
public class BD_solicitud_reparacion {
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
        
        String[] titulos = {"Cod. Solicitud", "Nro. Solicitud", "Fecha Sol.", "Cod. Cliente", "Cedula/RUC", "Nommbre C.", 
            "Apellido C.", "Direccion", "Telefono", "Email C.", "Marca", "Modelo", "IMEI", "Clave", "Motivo de ingreso", "Estado", "Cod. Emp", "Empleado", "Motv. Rep", 
            "Días rest.", "Costo Rep.", "Abono", "Saldo", "Total", "Fecha est. R.", "Dias de equip."};
        String[] registro = new String[26];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        /**
         * select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie, c.dirección_clie,c.telefono_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol, s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador' from cliente c, solicitud_reparacion s, empleado e where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and (ruc_clie like '%busar%' or nombres_clie like 'buscar%' or apellidos_clie like'busca%') order by s.cod_solicitud desc 
         */
        
        sSQL = "select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie,"+
                "c.dirección_clie,c.telefono_clie,c.email_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol,"
                + "s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador',s.motivo_rep_sol,s.dias_estimados_rep,"
                + "s.costo_rep_est,s.abono_sol,s.saldo_sol,s.total_sol,DATE_FORMAT((s.fecha_solicitud + s.dias_estimados_rep), '%d/%m/%Y') as fecha_estimada_rep,Datediff(now(),s.fecha_solicitud) as dias_equipo "
                + "from cliente c, solicitud_reparacion s, empleado e "+
                //"on s.cod_cliente=c.cod_cliente and c.cod_empleado=e.cod_empleado "
                "where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and  (ruc_clie like '%" + 
                buscar + "%' or nombres_clie like'" + buscar + "%' or apellidos_clie like'" + buscar + "%') order by s.cod_solicitud desc";
        
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
                registro[11] = rs.getString(12);
                registro[12] = rs.getString(13);
                registro[13] = rs.getString(14);
                registro[14] = rs.getString(15);
                registro[15] = rs.getString(16);
                registro[16] = rs.getString(17);
                registro[17] = rs.getString(18);
                registro[18] = rs.getString(19);
                registro[19] = rs.getString(20);
                registro[20] = rs.getString(21);
                registro[21] = rs.getString(22);
                registro[22] = rs.getString(23);
                registro[23] = rs.getString(24);
                registro[24] = rs.getString(25);
                registro[25] = rs.getString(26);

                totalregistros = totalregistros + 1;
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
    
    public DefaultTableModel mostrarTodo(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Solicitud", "Nro. Solicitud", "Fecha Sol.", "Cod. Cliente", "Cedula/RUC", "Nommbre C.", 
            "Apellido C.", "Direccion", "Telefono", "Email C.", "Marca", "Modelo", "IMEI", "Clave", "Motivo de ingreso", "Estado", "Cod. Emp", "Empleado", "Motv. Rep", 
            "Días rest.", "Costo Rep.", "Abono", "Saldo", "Total", "Fecha est. R.", "Dias de equip."};
        String[] registro = new String[26];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        /**
         * select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie, c.dirección_clie,c.telefono_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol, s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador' from cliente c, solicitud_reparacion s, empleado e where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and (ruc_clie like '%busar%' or nombres_clie like 'buscar%' or apellidos_clie like'busca%') order by s.cod_solicitud desc 
         */
        
        sSQL = "select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie,"+
                "c.dirección_clie,c.telefono_clie,c.email_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol,"
                + "s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador',s.motivo_rep_sol,s.dias_estimados_rep,"
                + "s.costo_rep_est,s.abono_sol,s.saldo_sol,s.total_sol,DATE_FORMAT((s.fecha_solicitud + s.dias_estimados_rep), '%d/%m/%Y') as fecha_estimada_rep,Datediff(now(),s.fecha_solicitud) as dias_equipo "
                + "from cliente c, solicitud_reparacion s, empleado e "+
                //"on s.cod_cliente=c.cod_cliente and c.cod_empleado=e.cod_empleado "
                "where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and  (ruc_clie like '%" + 
                buscar + "%' or nombres_clie like'" + buscar + "%' or apellidos_clie like'" + buscar + "%') order by s.cod_solicitud asc";
        
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
                registro[11] = rs.getString(12);
                registro[12] = rs.getString(13);
                registro[13] = rs.getString(14);
                registro[14] = rs.getString(15);
                registro[15] = rs.getString(16);
                registro[16] = rs.getString(17);
                registro[17] = rs.getString(18);
                registro[18] = rs.getString(19);
                registro[19] = rs.getString(20);
                registro[20] = rs.getString(21);
                registro[21] = rs.getString(22);
                registro[22] = rs.getString(23);
                registro[23] = rs.getString(24);
                registro[24] = rs.getString(25);
                registro[25] = rs.getString(26);

                totalregistros = totalregistros + 1;
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
    
    public DefaultTableModel mostrarVistaEspera(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Solicitud", "Nro. Solicitud", "Fecha Sol.", "Cod. Cliente", "Cedula/RUC", "Nommbre C.", 
            "Apellido C.", "Direccion", "Telefono", "Email C.", "Marca", "Modelo", "IMEI", "Clave", "Motivo de ingreso", "Estado", "Cod. Emp", "Empleado", "Motv. Rep", 
            "Días rest.", "Costo Rep.", "Abono", "Saldo", "Total", "Fecha est. R.", "Dias de equip."};
        String[] registro = new String[26];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        /**
         * select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie, c.dirección_clie,c.telefono_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol, s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador' from cliente c, solicitud_reparacion s, empleado e where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and (ruc_clie like '%busar%' or nombres_clie like 'buscar%' or apellidos_clie like'busca%') order by s.cod_solicitud desc 
         */
        
        sSQL = "select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie,"+
                "c.dirección_clie,c.telefono_clie,c.email_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol,"
                + "s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador',s.motivo_rep_sol,s.dias_estimados_rep,"
                + "s.costo_rep_est,s.abono_sol,s.saldo_sol,s.total_sol,DATE_FORMAT((s.fecha_solicitud + s.dias_estimados_rep), '%d/%m/%Y') as fecha_estimada_rep,Datediff(now(),s.fecha_solicitud) as dias_equipo "
                + "from cliente c, solicitud_reparacion s, empleado e "+
                //"on s.cod_cliente=c.cod_cliente and c.cod_empleado=e.cod_empleado "
                "where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and  (ruc_clie like '%" + 
                buscar + "%' or nombres_clie like'" + buscar + "%' or apellidos_clie like'" + buscar + "%') and s.estado_solicitud='En espera' order by s.cod_solicitud asc";
        
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
                registro[11] = rs.getString(12);
                registro[12] = rs.getString(13);
                registro[13] = rs.getString(14);
                registro[14] = rs.getString(15);
                registro[15] = rs.getString(16);
                registro[16] = rs.getString(17);
                registro[17] = rs.getString(18);
                registro[18] = rs.getString(19);
                registro[19] = rs.getString(20);
                registro[20] = rs.getString(21);
                registro[21] = rs.getString(22);
                registro[22] = rs.getString(23);
                registro[23] = rs.getString(24);
                registro[24] = rs.getString(25);
                registro[25] = rs.getString(26);

                totalregistros = totalregistros + 1;
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
    
    public DefaultTableModel mostrarVistaEnProcesoRevision(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Solicitud", "Nro. Solicitud", "Fecha Sol.", "Cod. Cliente", "Cedula/RUC", "Nommbre C.", 
            "Apellido C.", "Direccion", "Telefono", "Email C.", "Marca", "Modelo", "IMEI", "Clave", "Motivo de ingreso", "Estado", "Cod. Emp", "Empleado", "Motv. Rep", 
            "Días rest.", "Costo Rep.", "Abono", "Saldo", "Total", "Fecha est. R.", "Dias de equip."};
        String[] registro = new String[26];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        /**
         * select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie, c.dirección_clie,c.telefono_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol, s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador' from cliente c, solicitud_reparacion s, empleado e where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and (ruc_clie like '%busar%' or nombres_clie like 'buscar%' or apellidos_clie like'busca%') order by s.cod_solicitud desc 
         */
        
        sSQL = "select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie,"+
                "c.dirección_clie,c.telefono_clie,c.email_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol,"
                + "s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador',s.motivo_rep_sol,s.dias_estimados_rep,"
                + "s.costo_rep_est,s.abono_sol,s.saldo_sol,s.total_sol,DATE_FORMAT((s.fecha_solicitud + s.dias_estimados_rep), '%d/%m/%Y') as fecha_estimada_rep,Datediff(now(),s.fecha_solicitud) as dias_equipo "
                + "from cliente c, solicitud_reparacion s, empleado e "+
                //"on s.cod_cliente=c.cod_cliente and c.cod_empleado=e.cod_empleado "
                "where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and  (ruc_clie like '%" + 
                buscar + "%' or nombres_clie like'" + buscar + "%' or apellidos_clie like'" + buscar + "%') and s.estado_solicitud='En proceso de revisión' order by s.cod_solicitud asc";
        
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
                registro[11] = rs.getString(12);
                registro[12] = rs.getString(13);
                registro[13] = rs.getString(14);
                registro[14] = rs.getString(15);
                registro[15] = rs.getString(16);
                registro[16] = rs.getString(17);
                registro[17] = rs.getString(18);
                registro[18] = rs.getString(19);
                registro[19] = rs.getString(20);
                registro[20] = rs.getString(21);
                registro[21] = rs.getString(22);
                registro[22] = rs.getString(23);
                registro[23] = rs.getString(24);
                registro[24] = rs.getString(25);
                registro[25] = rs.getString(26);

                totalregistros = totalregistros + 1;
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
    
    public DefaultTableModel mostrarVistaEquipoNoentregado(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Solicitud", "Nro. Solicitud", "Fecha Sol.", "Cod. Cliente", "Cedula/RUC", "Nommbre C.", 
            "Apellido C.", "Direccion", "Telefono", "Email C.", "Marca", "Modelo", "IMEI", "Clave", "Motivo de ingreso", "Estado", "Cod. Emp", "Empleado", "Motv. Rep", 
            "Días rest.", "Costo Rep.", "Abono", "Saldo", "Total", "Fecha est. R.", "Dias de equip."};
        String[] registro = new String[26];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        /**
         * select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie, c.dirección_clie,c.telefono_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol, s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador' from cliente c, solicitud_reparacion s, empleado e where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and (ruc_clie like '%busar%' or nombres_clie like 'buscar%' or apellidos_clie like'busca%') order by s.cod_solicitud desc 
         */
        
        sSQL = "select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie,"+
                "c.dirección_clie,c.telefono_clie,c.email_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol,"
                + "s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador',s.motivo_rep_sol,s.dias_estimados_rep,"
                + "s.costo_rep_est,s.abono_sol,s.saldo_sol,s.total_sol,DATE_FORMAT((s.fecha_solicitud + s.dias_estimados_rep), '%d/%m/%Y') as fecha_estimada_rep,Datediff(now(),s.fecha_solicitud) as dias_equipo "
                + "from cliente c, solicitud_reparacion s, empleado e "+
                //"on s.cod_cliente=c.cod_cliente and c.cod_empleado=e.cod_empleado "
                "where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and  (ruc_clie like '%" + 
                buscar + "%' or nombres_clie like'" + buscar + "%' or apellidos_clie like'" + buscar + "%') and s.estado_solicitud='Completada la revisión - Equipo no entregado' order by s.cod_solicitud asc";
        
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
                registro[11] = rs.getString(12);
                registro[12] = rs.getString(13);
                registro[13] = rs.getString(14);
                registro[14] = rs.getString(15);
                registro[15] = rs.getString(16);
                registro[16] = rs.getString(17);
                registro[17] = rs.getString(18);
                registro[18] = rs.getString(19);
                registro[19] = rs.getString(20);
                registro[20] = rs.getString(21);
                registro[21] = rs.getString(22);
                registro[22] = rs.getString(23);
                registro[23] = rs.getString(24);
                registro[24] = rs.getString(25);
                registro[25] = rs.getString(26);

                totalregistros = totalregistros + 1;
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
    
    
    public DefaultTableModel mostrarVistaEquipoEntregado(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Solicitud", "Nro. Solicitud", "Fecha Sol.", "Cod. Cliente", "Cedula/RUC", "Nommbre C.", 
            "Apellido C.", "Direccion", "Telefono", "Email C.", "Marca", "Modelo", "IMEI", "Clave", "Motivo de ingreso", "Estado", "Cod. Emp", "Empleado", "Motv. Rep", 
            "Días rest.", "Costo Rep.", "Abono", "Saldo", "Total", "Fecha est. R.", "Dias de equip."};
        String[] registro = new String[26];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        /**
         * select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie, c.dirección_clie,c.telefono_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol, s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador' from cliente c, solicitud_reparacion s, empleado e where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and (ruc_clie like '%busar%' or nombres_clie like 'buscar%' or apellidos_clie like'busca%') order by s.cod_solicitud desc 
         */
        
        sSQL = "select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie,"+
                "c.dirección_clie,c.telefono_clie,c.email_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol,"
                + "s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador',s.motivo_rep_sol,s.dias_estimados_rep,"
                + "s.costo_rep_est,s.abono_sol,s.saldo_sol,s.total_sol,DATE_FORMAT((s.fecha_solicitud + s.dias_estimados_rep), '%d/%m/%Y') as fecha_estimada_rep,Datediff(now(),s.fecha_solicitud) as dias_equipo "
                + "from cliente c, solicitud_reparacion s, empleado e "+
                //"on s.cod_cliente=c.cod_cliente and c.cod_empleado=e.cod_empleado "
                "where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and  (ruc_clie like '%" + 
                buscar + "%' or nombres_clie like'" + buscar + "%' or apellidos_clie like'" + buscar + "%') and s.estado_solicitud='Completada la revisión - Equipo  entregado' order by s.cod_solicitud asc";
        
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
                registro[11] = rs.getString(12);
                registro[12] = rs.getString(13);
                registro[13] = rs.getString(14);
                registro[14] = rs.getString(15);
                registro[15] = rs.getString(16);
                registro[16] = rs.getString(17);
                registro[17] = rs.getString(18);
                registro[18] = rs.getString(19);
                registro[19] = rs.getString(20);
                registro[20] = rs.getString(21);
                registro[21] = rs.getString(22);
                registro[22] = rs.getString(23);
                registro[23] = rs.getString(24);
                registro[24] = rs.getString(25);
                registro[25] = rs.getString(26);

                totalregistros = totalregistros + 1;
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
    
    
    
    public DefaultTableModel mostrar2(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Cod. Solicitud", "Nro. Solicitud", "Fecha Sol.", "Cod. Cliente", "Cedula/RUC", "Nommbre C.", 
            "Apellido C.", "Direccion", "Telefono", "Marca", "Modelo", "IMEI", "Clave", "Motivo de ingreso", "Estado", "Cod. Emp", "Empleado"};
        String[] registro = new String[17];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        /**
         * select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie, c.dirección_clie,c.telefono_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol, s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador' from cliente c, solicitud_reparacion s, empleado e where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and (ruc_clie like '%busar%' or nombres_clie like 'buscar%' or apellidos_clie like'busca%') order by s.cod_solicitud desc 
         */
        
        sSQL = "select s.cod_solicitud,s.numero_solicitud,s.fecha_solicitud,c.cod_cliente,c.ruc_clie,c.nombres_clie,c.apellidos_clie,"+
                "c.dirección_clie,c.telefono_clie,s.marca_equipo_sol,s.modelo_equipo_sol,s.imei_serie_sol,s.clave_usuario_sol,s.motivo_ingreso_sol,"
                + "s.estado_solicitud,e.cod_empleado,concat(e.nombres_emp,' ',e.apellidos_emp) as 'trabajador' from cliente c, solicitud_reparacion s, empleado e "+
                //"on s.cod_cliente=c.cod_cliente and c.cod_empleado=e.cod_empleado "
                "where (s.cod_cliente = c.cod_cliente and s.cod_empleado = e.cod_empleado) and  (numero_solicitud ='" + buscar + "') order by s.cod_solicitud desc";
        
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
                registro[11] = rs.getString(12);
                registro[12] = rs.getString(13);
                registro[13] = rs.getString(14);
                registro[14] = rs.getString(15);
                registro[15] = rs.getString(16);
                registro[16] = rs.getString(17);

                totalregistros = totalregistros + 1;
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

    

    public boolean insertar(solicitud_reparacion dts) {
        sSQL = "insert into solicitud_reparacion (numero_solicitud,cod_cliente,cod_empleado,fecha_solicitud,modelo_equipo_sol,marca_equipo_sol,imei_serie_sol,"
                + "clave_usuario_sol,motivo_ingreso_sol,motivo_rep_sol,estado_solicitud,dias_estimados_rep,costo_rep_est,abono_sol,saldo_sol,total_sol)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setString(1, dts.getNumero_solicitud());
            pst.setInt(2, dts.getCod_cliente());
            pst.setInt(3, dts.getCod_empleado());
            pst.setDate(4, dts.getFecha_solicitud());
            pst.setString(5, dts.getModelo_equipo_sol());
            pst.setString(6, dts.getMarca_equipo_sol());
            pst.setString(7, dts.getImei_serie_sol());
            pst.setString(8, dts.getClave_usuario_sol());
            pst.setString(9, dts.getMotivo_ingreso_sol());
            pst.setString(10, dts.getMotivo_rep_sol());
            pst.setString(11, dts.getEstado_solicitud());
            pst.setInt(12, dts.getDias_estimados_rep());
            pst.setDouble(13, dts.getCosto_rep_est());
            pst.setDouble(14, dts.getAbono_sol());
            pst.setDouble(15, dts.getSaldo_sol());
            pst.setDouble(16, dts.getTotal_sol());
            
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
    public boolean insertar2(empleado emp) {
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
    * **/

    public boolean eliminar(solicitud_reparacion dts) {
        sSQL = "delete from solicitud_reparacion where cod_solicitud=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getCod_solicitud());
            
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
    
    /**
    public boolean eliminar2(int cod_empleado) {
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
    * **/

    public boolean editar(solicitud_reparacion emp) {
        boolean modif = false;// para ver si el dato se modifico
        Conexion con = new Conexion();
        Connection reg = con.ObtenerConexion();

        try {
            PreparedStatement pst = reg.prepareStatement("update solicitud_reparacion set numero_solicitud=?,cod_cliente=?,cod_empleado=?,fecha_solicitud=?,"
                    + "modelo_equipo_sol=?,marca_equipo_sol=?,imei_serie_sol=?,clave_usuario_sol=?,motivo_ingreso_sol=?,"
                    + "motivo_rep_sol=?,estado_solicitud=?,dias_estimados_rep=?,"
                    + "costo_rep_est=?,abono_sol=?,saldo_sol=?,total_sol=?"
                    + " Where cod_solicitud=?");

            pst.setString(1, emp.getNumero_solicitud());
            pst.setInt(2, emp.getCod_cliente());
            pst.setInt(3, emp.getCod_empleado());
            pst.setDate(4, emp.getFecha_solicitud());
            pst.setString(5, emp.getModelo_equipo_sol());
            pst.setString(6, emp.getMarca_equipo_sol());
            pst.setString(7, emp.getImei_serie_sol());
            pst.setString(8, emp.getClave_usuario_sol());
            pst.setString(9, emp.getMotivo_ingreso_sol());
            pst.setString(10, emp.getMotivo_rep_sol());
            pst.setString(11, emp.getEstado_solicitud());
            pst.setInt(12, emp.getDias_estimados_rep());
            pst.setDouble(13, emp.getCosto_rep_est());
            pst.setDouble(14, emp.getAbono_sol());
            pst.setDouble(15, emp.getSaldo_sol());
            pst.setDouble(16, emp.getTotal_sol());
            pst.setInt(17, emp.getCod_solicitud());

            int n = pst.executeUpdate();
            if (n > 0) {
                //JOptionPane.showMessageDialog(null, "modificado con exito");
                modif = true;
            } else {
                JOptionPane.showMessageDialog(null, "la modificacion no fue exitosa ", "PROYECTO DE PROGRAMACION", JOptionPane.YES_OPTION);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modif;
    }
    
    
}
