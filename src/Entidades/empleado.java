package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kalva
 */
public class empleado {

    int cod_empleado;
    int cod_cargo;
    String ruc_emp;
    String nombres_emp;
    String apellidos_emp;
    String direccion_emp;
    String email_emp;
    String user_emp;
    String contraseña_emp;

    public empleado() {
    }

    public empleado(int cod_empleado, int cod_cargo, String ruc_emp, String nombres_emp, String apellidos_emp, String direccion_emp, String email_emp, String user_emp, String contraseña_emp) {
        this.cod_empleado = cod_empleado;
        this.cod_cargo = cod_cargo;
        this.ruc_emp = ruc_emp;
        this.nombres_emp = nombres_emp;
        this.apellidos_emp = apellidos_emp;
        this.direccion_emp = direccion_emp;
        this.email_emp = email_emp;
        this.user_emp = user_emp;
        this.contraseña_emp = contraseña_emp;
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public String getRuc_emp() {
        return ruc_emp;
    }

    public void setRuc_emp(String ruc_emp) {
        this.ruc_emp = ruc_emp;
    }

    public String getNombres_emp() {
        return nombres_emp;
    }

    public void setNombres_emp(String nombres_emp) {
        this.nombres_emp = nombres_emp;
    }

    public String getApellidos_emp() {
        return apellidos_emp;
    }

    public void setApellidos_emp(String apellidos_emp) {
        this.apellidos_emp = apellidos_emp;
    }

    public String getDireccion_emp() {
        return direccion_emp;
    }

    public void setDireccion_emp(String direccion_emp) {
        this.direccion_emp = direccion_emp;
    }

    public String getEmail_emp() {
        return email_emp;
    }

    public void setEmail_emp(String email_emp) {
        this.email_emp = email_emp;
    }

    public String getUser_emp() {
        return user_emp;
    }

    public void setUser_emp(String user_emp) {
        this.user_emp = user_emp;
    }

    public String getContraseña_emp() {
        return contraseña_emp;
    }

    public void setContraseña_emp(String contraseña_emp) {
        this.contraseña_emp = contraseña_emp;
    }
    
}
