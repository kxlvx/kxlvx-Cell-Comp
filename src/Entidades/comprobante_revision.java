/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 * @author kalva
 */
public class comprobante_revision {

    int cod_comprobante_rep;
    int cod_solicitud;
    int cod_empleado;
    String motivo_reparacion_cr;
    Date fecha_revision_cr;
    String tipo_servicio_cr;
    String estado_revision_cr;
    double abono_cr;
    double saldo_cr;
    double total_revision_cr;

    public int getCod_comprobante_rep() {
        return cod_comprobante_rep;
    }

    public void setCod_comprobante_rep(int cod_comprobante_rep) {
        this.cod_comprobante_rep = cod_comprobante_rep;
    }

    public int getCod_solicitud() {
        return cod_solicitud;
    }

    public void setCod_solicitud(int cod_solicitud) {
        this.cod_solicitud = cod_solicitud;
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getMotivo_reparacion_cr() {
        return motivo_reparacion_cr;
    }

    public void setMotivo_reparacion_cr(String motivo_reparacion_cr) {
        this.motivo_reparacion_cr = motivo_reparacion_cr;
    }

    public Date getFecha_revision_cr() {
        return fecha_revision_cr;
    }

    public void setFecha_revision_cr(Date fecha_revision_cr) {
        this.fecha_revision_cr = fecha_revision_cr;
    }

    public String getTipo_servicio_cr() {
        return tipo_servicio_cr;
    }

    public void setTipo_servicio_cr(String tipo_servicio_cr) {
        this.tipo_servicio_cr = tipo_servicio_cr;
    }

    public String getEstado_revision_cr() {
        return estado_revision_cr;
    }

    public void setEstado_revision_cr(String estado_revision_cr) {
        this.estado_revision_cr = estado_revision_cr;
    }

    public double getAbono_cr() {
        return abono_cr;
    }

    public void setAbono_cr(double abono_cr) {
        this.abono_cr = abono_cr;
    }

    public double getSaldo_cr() {
        return saldo_cr;
    }

    public void setSaldo_cr(double saldo_cr) {
        this.saldo_cr = saldo_cr;
    }

    public double getTotal_revision_cr() {
        return total_revision_cr;
    }

    public void setTotal_revision_cr(double total_revision_cr) {
        this.total_revision_cr = total_revision_cr;
    }

    public comprobante_revision(int cod_comprobante_rep, int cod_solicitud, int cod_empleado, String motivo_reparacion_cr, Date fecha_revision_cr, String tipo_servicio_cr, String estado_revision_cr, double abono_cr, double saldo_cr, double total_revision_cr) {
        this.cod_comprobante_rep = cod_comprobante_rep;
        this.cod_solicitud = cod_solicitud;
        this.cod_empleado = cod_empleado;
        this.motivo_reparacion_cr = motivo_reparacion_cr;
        this.fecha_revision_cr = fecha_revision_cr;
        this.tipo_servicio_cr = tipo_servicio_cr;
        this.estado_revision_cr = estado_revision_cr;
        this.abono_cr = abono_cr;
        this.saldo_cr = saldo_cr;
        this.total_revision_cr = total_revision_cr;
    }

    public comprobante_revision() {
    }

}
