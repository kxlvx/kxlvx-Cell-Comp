/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Samuel Isaias calderon Aguirre
 */
public class categoria {
    //llave primaria
    private int id_categoria;
    private String nombre_categoria;
    
    //constructores
    
    /**
     * Constructor que inicializa
     * @param id_categoria
     * @param nombre_categoria 
     */
    public categoria(int id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }
    
    //metodos get y set

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public categoria() {
    }
    
    
    
    
}
