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
public class email_empresa {
    //llaves primarias
    private int cod_empresa;
    private String email_empresa;
    
    //constructores
    
    /**
     * constructor vacio
     */
    public email_empresa() {
    }
    
    /**
     * Constructor que inicializa
     * @param cod_empresa
     * @param email_empresa 
     */
    public email_empresa(int cod_empresa, String email_empresa) {
        this.cod_empresa = cod_empresa;
        this.email_empresa = email_empresa;
    }
    
    //metodos get  y set

    public int getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(int cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getEmail_empresa() {
        return email_empresa;
    }

    public void setEmail_empresa(String email_empresa) {
        this.email_empresa = email_empresa;
    }
    
    
    
}
