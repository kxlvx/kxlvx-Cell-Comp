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
public class telefono_proveedor {
    //llaves primarias
    private int cod_telf_prov;
    private int cod_proveedor;
    private String telefono;
    
    //constructores
    /**
     * Constructor vacio
     */
    public telefono_proveedor() {
    }
    
    /**
     * Constructor que inizializa
     * @param cod_proveedor
     * @param telefono 
     */
    public telefono_proveedor(int cod_proveedor, String telefono) {
        this.cod_proveedor = cod_proveedor;
        this.telefono = telefono;
    }

    public telefono_proveedor(int cod_telf_prov, int cod_proveedor, String telefono) {
        this.cod_telf_prov = cod_telf_prov;
        this.cod_proveedor = cod_proveedor;
        this.telefono = telefono;
    }
    
    
    
    //metodos get y set

    public int getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(int cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCod_telf_prov() {
        return cod_telf_prov;
    }

    public void setCod_telf_prov(int cod_telf_prov) {
        this.cod_telf_prov = cod_telf_prov;
    }
    
    
    
    
    
}
