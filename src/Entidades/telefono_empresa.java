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
public class telefono_empresa {
    //llaves primarias
    private int cod_empresa;
    private String telefono_empresa;
    
    //constructores
    
    /**
     * Constructor vacio
     */
    public telefono_empresa() {
    }
    
    /**
     * Constructor que permite inicializar
     * @param cod_empresa
     * @param telefono_empresa 
     */
    public telefono_empresa(int cod_empresa, String telefono_empresa) {
        this.cod_empresa = cod_empresa;
        this.telefono_empresa = telefono_empresa;
    }
    
    //meotodos get y set

    public int getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(int cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }
    
    
    
    
}
