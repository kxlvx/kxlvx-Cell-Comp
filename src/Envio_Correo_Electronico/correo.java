/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Envio_Correo_Electronico;

/**
 *
 * @author Samuel Isias Calderon Aguirre
 */
public class correo {
    String usuarioCorreo, nombreArchivo, contracena, rutaArchivo, destino, Asunto, mensaje;

    public correo() {
    }

    public correo(String usuarioCorreo, String nombreArchivo, String contracena, String rutaArchivo, String destino, String asunto, String mensaje) {
        this.usuarioCorreo = usuarioCorreo;
        this.nombreArchivo = nombreArchivo;
        this.contracena = contracena;
        this.rutaArchivo = rutaArchivo;
        this.destino = destino;
        this.Asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getContracena() {
        return contracena;
    }

    public void setContracena(String contracena) {
        this.contracena = contracena;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAdjunto() {
        return Asunto;
    }

    public void setAdjunto(String adjunto) {
        this.Asunto = adjunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
