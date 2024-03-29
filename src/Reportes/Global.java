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
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kevin Figueroa
 */
public class Global {
    //public static double iva=0.14;
    //obtiene ruta de la carpeta de reportes
    public static String getPathReport(){
        return getPath()+"Reportes\\";
    }
    //obtiene ruta de la carpeta de vistas
    public static String getPathVistas(){
        return getPath()+"Vistas\\";
    }
    //obtiene ruta de la carpeta imagenes
    public static String getPathImagenes(){
        return getPath()+"Archivos\\Imagenes Menu Princpal\\"; 
    }
    
    //obtiene ruta del código fuente del Proyecto
    public static String getPath(){
        //extraer ruta del proyecto de forma dinámica
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        System.out.println("Path del Proyecto " + path);
        //eliminar los dos caracteres del final del path
        path=path.substring(0,path.length()-2);
        return path+="\\src\\";
    }  
    
    //genera reportes sin parámetros
    public static void generarReporte(String reporte) throws JRException, FileNotFoundException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        generarReporte(reporte,params);
    }  
    
    //carga reporte simple
    public static void generarReporte(String reporte,Map<String, Object> params) throws JRException, FileNotFoundException {     
        //conexión base de datos
        Conexion con= new Conexion();
        Connection connection = con.ObtenerConexion();
        //extraer ruta de la carpeta de reportes     
        String path = Global.getPathReport()+reporte; 
        String pathlogo = Global.getPathImagenes()+"cellcomp logo.jpg"; 
        //reporte fuente
        String reportSource = path+".jrxml";
        //archivo pdf destino
        String reportDest  = path+".pdf";  
        
        System.out.println(reportSource);
        System.out.println(reportDest);
        System.out.println(pathlogo);
        
        //Map<String, Object> params = new HashMap<String, Object>();
        //params.put("Titulo",new String("CellComp"));
        params.put("Logo",new String(pathlogo));
        
        try
        {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);            
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportDest);            
            JasperViewer.viewReport(jasperPrint, false);
        }
        catch (JRException ex)
        {
            ex.printStackTrace();
        }
    }
}
