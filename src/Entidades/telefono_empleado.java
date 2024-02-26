/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author kalva
 */
public class telefono_empleado {

    int cod_empleado;
    int cod_telefono_empleado;
    String telefono_empleado;

    public telefono_empleado(int cod_empleado, int cod_telefono_empleado, String telefono_empleado) {
        this.cod_empleado = cod_empleado;
        this.cod_telefono_empleado = cod_telefono_empleado;
        this.telefono_empleado = telefono_empleado;
    }

    public telefono_empleado() {
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public int getCod_telefono_empleado() {
        return cod_telefono_empleado;
    }

    public void setCod_telefono_empleado(int cod_telefono_empleado) {
        this.cod_telefono_empleado = cod_telefono_empleado;
    }

    public String getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(String telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

}
