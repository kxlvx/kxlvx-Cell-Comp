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
public class email_proveedor {
    //llaves primarias
    private int cod_email_prov;
    private int cod_proveedor;
    private String email_proveedor;
    
    //constructores
    /**
     * Constructor vacio
     */
    public email_proveedor() {
    }

    /**
     * cONSTRUCTOR que inicializa
     * @param cod_proveedor
     * @param email_proveedor 
     */
    public email_proveedor(int cod_proveedor, String email_proveedor) {
        this.cod_proveedor = cod_proveedor;
        this.email_proveedor = email_proveedor;
    }

    public email_proveedor(int cod_email_prov, int cod_proveedor, String email_proveedor) {
        this.cod_email_prov = cod_email_prov;
        this.cod_proveedor = cod_proveedor;
        this.email_proveedor = email_proveedor;
    }
    
    
    
    //metodos get y set

    public int getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(int cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }

    public int getCod_email_prov() {
        return cod_email_prov;
    }

    public void setCod_email_prov(int cod_email_prov) {
        this.cod_email_prov = cod_email_prov;
    }
    
    
    
    
    
}
