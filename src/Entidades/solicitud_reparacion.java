package Entidades;

import java.sql.Date;

/**
 *
 * @author Samuel Isaias Calderón Aguirre
 */
public class solicitud_reparacion {

    int cod_solicitud;
    String numero_solicitud;
    int cod_cliente;
    int cod_empleado;
    //datos de la solicitud
    Date fecha_solicitud;
    //datos del equipo
    String modelo_equipo_sol;
    String marca_equipo_sol;
    String imei_serie_sol;
    String clave_usuario_sol;
    //motivo de ingreso
    String motivo_ingreso_sol;
    //motivo de la reparacion
    String motivo_rep_sol; 
    //estado de la solicitud
    String estado_solicitud;
    //estimacion de dias de reparacion
    int dias_estimados_rep;
    //costo de la reparacion 
    double costo_rep_est;
    double abono_sol;
    double saldo_sol;
    double total_sol;

    public solicitud_reparacion() {
    }

    public solicitud_reparacion(int cod_solicitud, int cod_cliente, int cod_empleado, Date fecha_solicitud, String modelo_equipo_sol, String marca_equipo_sol, String imei_serie_sol, String clave_usuario_sol, String motivo_ingreso_sol) {
        this.cod_solicitud = cod_solicitud;
        this.cod_cliente = cod_cliente;
        this.cod_empleado = cod_empleado;
        this.fecha_solicitud = fecha_solicitud;
        this.modelo_equipo_sol = modelo_equipo_sol;
        this.marca_equipo_sol = marca_equipo_sol;
        this.imei_serie_sol = imei_serie_sol;
        this.clave_usuario_sol = clave_usuario_sol;
        this.motivo_ingreso_sol = motivo_ingreso_sol;
    }

    public solicitud_reparacion(int cod_solicitud, int cod_cliente, int cod_empleado, Date fecha_solicitud, String modelo_equipo_sol, String marca_equipo_sol, String imei_serie_sol, String clave_usuario_sol, String motivo_ingreso_sol, String estado_solicitud) {
        this.cod_solicitud = cod_solicitud;
        this.cod_cliente = cod_cliente;
        this.cod_empleado = cod_empleado;
        this.fecha_solicitud = fecha_solicitud;
        this.modelo_equipo_sol = modelo_equipo_sol;
        this.marca_equipo_sol = marca_equipo_sol;
        this.imei_serie_sol = imei_serie_sol;
        this.clave_usuario_sol = clave_usuario_sol;
        this.motivo_ingreso_sol = motivo_ingreso_sol;
        this.estado_solicitud = estado_solicitud;
    }

    public solicitud_reparacion(int cod_solicitud, String numero_solicitud, int cod_cliente, int cod_empleado, Date fecha_solicitud, String modelo_equipo_sol, String marca_equipo_sol, String imei_serie_sol, String clave_usuario_sol, String motivo_ingreso_sol, String estado_solicitud) {
        this.cod_solicitud = cod_solicitud;
        this.numero_solicitud = numero_solicitud;
        this.cod_cliente = cod_cliente;
        this.cod_empleado = cod_empleado;
        this.fecha_solicitud = fecha_solicitud;
        this.modelo_equipo_sol = modelo_equipo_sol;
        this.marca_equipo_sol = marca_equipo_sol;
        this.imei_serie_sol = imei_serie_sol;
        this.clave_usuario_sol = clave_usuario_sol;
        this.motivo_ingreso_sol = motivo_ingreso_sol;
        this.estado_solicitud = estado_solicitud;
    }

    public solicitud_reparacion(int cod_solicitud, String numero_solicitud, int cod_cliente, int cod_empleado, Date fecha_solicitud, String modelo_equipo_sol, String marca_equipo_sol, String imei_serie_sol, String clave_usuario_sol, String motivo_ingreso_sol, String motivo_rep_sol, String estado_solicitud, int dias_estimados_rep, double costo_rep_est, double abono_sol, double saldo_sol, double total_sol) {
        this.cod_solicitud = cod_solicitud;
        this.numero_solicitud = numero_solicitud;
        this.cod_cliente = cod_cliente;
        this.cod_empleado = cod_empleado;
        this.fecha_solicitud = fecha_solicitud;
        this.modelo_equipo_sol = modelo_equipo_sol;
        this.marca_equipo_sol = marca_equipo_sol;
        this.imei_serie_sol = imei_serie_sol;
        this.clave_usuario_sol = clave_usuario_sol;
        this.motivo_ingreso_sol = motivo_ingreso_sol;
        this.motivo_rep_sol = motivo_rep_sol;
        this.estado_solicitud = estado_solicitud;
        this.dias_estimados_rep = dias_estimados_rep;
        this.costo_rep_est = costo_rep_est;
        this.abono_sol = abono_sol;
        this.saldo_sol = saldo_sol;
        this.total_sol = total_sol;
    }
    
      
    

    public int getCod_solicitud() {
        return cod_solicitud;
    }

    public void setCod_solicitud(int cod_solicitud) {
        this.cod_solicitud = cod_solicitud;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getModelo_equipo_sol() {
        return modelo_equipo_sol;
    }

    public void setModelo_equipo_sol(String modelo_equipo_sol) {
        this.modelo_equipo_sol = modelo_equipo_sol;
    }

    public String getMarca_equipo_sol() {
        return marca_equipo_sol;
    }

    public void setMarca_equipo_sol(String marca_equipo_sol) {
        this.marca_equipo_sol = marca_equipo_sol;
    }

    public String getImei_serie_sol() {
        return imei_serie_sol;
    }

    public void setImei_serie_sol(String imei_serie_sol) {
        this.imei_serie_sol = imei_serie_sol;
    }

    public String getClave_usuario_sol() {
        return clave_usuario_sol;
    }

    public void setClave_usuario_sol(String clave_usuario_sol) {
        this.clave_usuario_sol = clave_usuario_sol;
    }

    public String getMotivo_ingreso_sol() {
        return motivo_ingreso_sol;
    }

    public void setMotivo_ingreso_sol(String motivo_ingreso_sol) {
        this.motivo_ingreso_sol = motivo_ingreso_sol;
    }

    public String getEstado_solicitud() {
        return estado_solicitud;
    }

    public void setEstado_solicitud(String estado_solicitud) {
        this.estado_solicitud = estado_solicitud;
    }

    public String getNumero_solicitud() {
        return numero_solicitud;
    }

    public void setNumero_solicitud(String numero_solicitud) {
        this.numero_solicitud = numero_solicitud;
    }

    public String getMotivo_rep_sol() {
        return motivo_rep_sol;
    }

    public void setMotivo_rep_sol(String motivo_rep_sol) {
        this.motivo_rep_sol = motivo_rep_sol;
    }

    public int getDias_estimados_rep() {
        return dias_estimados_rep;
    }

    public void setDias_estimados_rep(int dias_estimados_rep) {
        this.dias_estimados_rep = dias_estimados_rep;
    }

    public double getCosto_rep_est() {
        return costo_rep_est;
    }

    public void setCosto_rep_est(double costo_rep_est) {
        this.costo_rep_est = costo_rep_est;
    }

    public double getAbono_sol() {
        return abono_sol;
    }

    public void setAbono_sol(double abono_sol) {
        this.abono_sol = abono_sol;
    }

    public double getSaldo_sol() {
        return saldo_sol;
    }

    public void setSaldo_sol(double saldo_sol) {
        this.saldo_sol = saldo_sol;
    }

    public double getTotal_sol() {
        return total_sol;
    }

    public void setTotal_sol(double total_sol) {
        this.total_sol = total_sol;
    }
    
     

}
