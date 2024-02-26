/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.cargo;

/**
 *
 * @author kalva
 */
public class ProvarCargo {

    public static void main(String[] args) {
        cargo c = new cargo(2, "Administrador", 500.5);
        BD_cargo bd = new BD_cargo();
        if (bd.insertar(c)) {
            System.out.println("creado");
        } else {
            System.out.println("no crwado");
        }
    }

}
