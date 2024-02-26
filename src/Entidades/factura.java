package Entidades;


import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kalva
 */
public class factura {
    int cod_factura;
    int cod_empleado;
    int cod_cliente;
    int num_factura;
    Date fecha_emision_fac;
    double subtotal_0_fac;
    double iva;
    double subtotal_1_fac;
    double descuento_fac;
    double total_fac;

    public factura() {
    }

    public factura(int cod_factura, int cod_empleado, int cod_cliente, int num_factura, Date fecha_emision_fac, double subtotal_0_fac, double iva, double subtotal_1_fac, double descuento_fac, double total_fac) {
        this.cod_factura = cod_factura;
        this.cod_empleado = cod_empleado;
        this.cod_cliente = cod_cliente;
        this.num_factura = num_factura;
        this.fecha_emision_fac = fecha_emision_fac;
        this.subtotal_0_fac = subtotal_0_fac;
        this.iva = iva;
        this.subtotal_1_fac = subtotal_1_fac;
        this.descuento_fac = descuento_fac;
        this.total_fac = total_fac;
    }

    public int getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public Date getFecha_emision_fac() {
        return fecha_emision_fac;
    }

    public void setFecha_emision_fac(Date fecha_emision_fac) {
        this.fecha_emision_fac = fecha_emision_fac;
    }

    public double getSubtotal_0_fac() {
        return subtotal_0_fac;
    }

    public void setSubtotal_0_fac(double subtotal_0_fac) {
        this.subtotal_0_fac = subtotal_0_fac;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSubtotal_1_fac() {
        return subtotal_1_fac;
    }

    public void setSubtotal_1_fac(double subtotal_1_fac) {
        this.subtotal_1_fac = subtotal_1_fac;
    }

    public double getDescuento_fac() {
        return descuento_fac;
    }

    public void setDescuento_fac(double descuento_fac) {
        this.descuento_fac = descuento_fac;
    }

    public double getTotal_fac() {
        return total_fac;
    }

    public void setTotal_fac(double total_fac) {
        this.total_fac = total_fac;
    }
    
    
    
}
