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
public class cliente {
    //llave primaria 
    private int cod_cliente;
    //datos personales del cliente
    private String ruc_clie;
    private String nombres_clie;
    private String apellidos_clie;
    private String direccion_clie;
    //lugar de trabajo
    private String empresa;
    private String lugar_trabajo;
    //telefono y correo electronico
    private String telefono_clie;
    private String email_clie;
    
    //constructores

    /**
     * Constructor vacio
     */
    public cliente() {
    }
    
    /**
     * Constructor con los datos inicializando
     * @param cod_cliente
     * @param ruc_clie
     * @param nombres_clie
     * @param apellidos_clie
     * @param direccion_clie
     * @param empresa
     * @param lugar_trabajo
     * @param telefono_clie
     * @param email_clie 
     */
    public cliente(int cod_cliente, String ruc_clie, String nombres_clie, String apellidos_clie, String direccion_clie, String empresa, String lugar_trabajo, String telefono_clie, String email_clie) {
        this.cod_cliente = cod_cliente;
        this.ruc_clie = ruc_clie;
        this.nombres_clie = nombres_clie;
        this.apellidos_clie = apellidos_clie;
        this.direccion_clie = direccion_clie;
        this.empresa = empresa;
        this.lugar_trabajo = lugar_trabajo;
        this.telefono_clie = telefono_clie;
        this.email_clie = email_clie;
    }
    
    //Metodos get y set

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getRuc_clie() {
        return ruc_clie;
    }

    public void setRuc_clie(String ruc_clie) {
        this.ruc_clie = ruc_clie;
    }

    public String getNombres_clie() {
        return nombres_clie;
    }

    public void setNombres_clie(String nombres_clie) {
        this.nombres_clie = nombres_clie;
    }

    public String getApellidos_clie() {
        return apellidos_clie;
    }

    public void setApellidos_clie(String apellidos_clie) {
        this.apellidos_clie = apellidos_clie;
    }

    public String getDireccion_clie() {
        return direccion_clie;
    }

    public void setDireccion_clie(String direccion_clie) {
        this.direccion_clie = direccion_clie;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLugar_trabajo() {
        return lugar_trabajo;
    }

    public void setLugar_trabajo(String lugar_trabajo) {
        this.lugar_trabajo = lugar_trabajo;
    }

    public String getTelefono_clie() {
        return telefono_clie;
    }

    public void setTelefono_clie(String telefono_clie) {
        this.telefono_clie = telefono_clie;
    }

    public String getEmail_clie() {
        return email_clie;
    }

    public void setEmail_clie(String email_clie) {
        this.email_clie = email_clie;
    }
    
    
    
    
}
