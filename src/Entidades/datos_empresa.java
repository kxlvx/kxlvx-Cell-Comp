/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Samuel Isaias Calderon Aguirre
 */
public class datos_empresa {
    
    //llave primaria
    private int cod_empresa;
    //datos de la empresa
    private String nombre_empresa;
    private String ruc_empresa;
    private String gerente;
    private String direccion_empresa;
    private String ciudad_empresa;
    private String provincia_empresa;
    
    //constructores
    
    /**
     * Constructor vacio
     */
    public datos_empresa() {
    }
    
    /**
     * Constructor que inicializa
     * @param cod_empresa
     * @param nombre_empresa
     * @param ruc_empresa
     * @param gerente
     * @param direccion_empresa
     * @param ciudad_empresa
     * @param provincia_empresa 
     */
    public datos_empresa(int cod_empresa, String nombre_empresa, String ruc_empresa, String gerente, String direccion_empresa, String ciudad_empresa, String provincia_empresa) {
        this.cod_empresa = cod_empresa;
        this.nombre_empresa = nombre_empresa;
        this.ruc_empresa = ruc_empresa;
        this.gerente = gerente;
        this.direccion_empresa = direccion_empresa;
        this.ciudad_empresa = ciudad_empresa;
        this.provincia_empresa = provincia_empresa;
    }
    
    //metodos get y set

    public int getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(int cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRuc_empresa() {
        return ruc_empresa;
    }

    public void setRuc_empresa(String ruc_empresa) {
        this.ruc_empresa = ruc_empresa;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public String getCiudad_empresa() {
        return ciudad_empresa;
    }

    public void setCiudad_empresa(String ciudad_empresa) {
        this.ciudad_empresa = ciudad_empresa;
    }

    public String getProvincia_empresa() {
        return provincia_empresa;
    }

    public void setProvincia_empresa(String provincia_empresa) {
        this.provincia_empresa = provincia_empresa;
    }
    
    
    
    
    
}
