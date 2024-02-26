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
public class marca {
    //llave primaria
    private int id_marca;
    //datos
    private String nombre_marca;
    
    //constructores
    /**
     * Consructor vacio
     */
    public marca() {
    }
    
    /**
     * Constructor que inicializa
     * @param id_marca
     * @param nombre_marca 
     */
    public marca(int id_marca, String nombre_marca) {
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
    }
    
    //metodos get y set

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }
    
    
    
    
    
}
