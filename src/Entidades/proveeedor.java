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
public class proveeedor {
    //llave primaria
    private int cod_proveedor;
    //datos proveedor
    private String nombre_empresa_pv;
    private String representante;
    private String direccion_pv;
    private String ciudad;
    
    //constructores
    /**
     * Constructor vacio
     */
    public proveeedor() {
    }
    
    /**
     * Constructor que inicializa
     * @param cod_proveedor
     * @param nombre_empresa_pv
     * @param representante
     * @param direccion_pv
     * @param ciudad 
     */
    public proveeedor(int cod_proveedor, String nombre_empresa_pv, String representante, String direccion_pv, String ciudad) {
        this.cod_proveedor = cod_proveedor;
        this.nombre_empresa_pv = nombre_empresa_pv;
        this.representante = representante;
        this.direccion_pv = direccion_pv;
        this.ciudad = ciudad;
    }
    
    //metodos get y set

    public int getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(int cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public String getNombre_empresa_pv() {
        return nombre_empresa_pv;
    }

    public void setNombre_empresa_pv(String nombre_empresa_pv) {
        this.nombre_empresa_pv = nombre_empresa_pv;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getDireccion_pv() {
        return direccion_pv;
    }

    public void setDireccion_pv(String direccion_pv) {
        this.direccion_pv = direccion_pv;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
    
}
