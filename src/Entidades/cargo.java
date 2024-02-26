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
public class cargo {
    //llave 
    private int cod_cargo;
    //datos
    private String nombre_cargo;
    private double sueldo;
    
    //constructores

    /**
     * cONSTRUCTOR VACIO
     */
    public cargo() {
    }
    /**
     * Constructor que inicializa
     * @param cod_cargo
     * @param nombre_cargo
     * @param sueldo 
     */
    public cargo(int cod_cargo, String nombre_cargo, double sueldo) {
        this.cod_cargo = cod_cargo;
        this.nombre_cargo = nombre_cargo;
        this.sueldo = sueldo;
    }
    
    //Metodos get y set

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
}
