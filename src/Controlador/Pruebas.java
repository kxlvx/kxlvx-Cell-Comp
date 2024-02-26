/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.telefono_empleado;

/**
 *
 * @author kalva
 */
public class Pruebas {
    public static void main(String[] args) {
        BD_EmpleadoTelefono n=new BD_EmpleadoTelefono();
        n.insertar(new telefono_empleado(2, 0, "0987654325"));
    }
}
