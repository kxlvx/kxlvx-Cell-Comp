/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Controlador.Conexion;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author kalva
 */
public class Reportes {
        public static String ObtenerRuta() {
        //extraer ruta del proyecto de forma dinámica
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        System.out.println("Path del Proyecto " + path);
        //eliminar los dos caracteres del final del path
        path = path.substring(0, path.length() - 2);
        return path += "\\src\\";
    }
    //carga reporte simple

    public static void generarReporte(String reporte, Map params) throws JRException, FileNotFoundException {
        Connection con = Conexion.ObtenerConexion();

        try {
            ///JasperReport jasperReport = JasperCompileManager.compileReport(reporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, params, con);
            //    JasperExportManager.exportReportToPdfFile(jasperPrint, reportDest);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
}
