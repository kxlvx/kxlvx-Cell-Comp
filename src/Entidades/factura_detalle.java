package Entidades;

/**
 *
 * @author kalva
 * clase para guardar los detalles al comprar un producto
 */

public class factura_detalle {

    int factura_cod_factura;
    int producto_cod_producto;
    int cantidad_fac_det;
    double iva_fac;
    double importe_fac_det;

    /**
     * Constructor sinb parametros
     */
    public factura_detalle() {
    }

    /**
     * Constructor con parametros
     * @param factura_cod_factura
     * @param producto_cod_producto
     * @param cantidad_fac_det
     * @param iva_fac
     * @param importe_fac_det
     */
    public factura_detalle(int factura_cod_factura, int producto_cod_producto, int cantidad_fac_det, double iva_fac, double importe_fac_det) {
        this.factura_cod_factura = factura_cod_factura;
        this.producto_cod_producto = producto_cod_producto;
        this.cantidad_fac_det = cantidad_fac_det;
        this.iva_fac = iva_fac;
        this.importe_fac_det = importe_fac_det;
    }

    public int getFactura_cod_factura() {
        return factura_cod_factura;
    }

    public void setFactura_cod_factura(int factura_cod_factura) {
        this.factura_cod_factura = factura_cod_factura;
    }

    public int getProducto_cod_producto() {
        return producto_cod_producto;
    }

    public void setProducto_cod_producto(int producto_cod_producto) {
        this.producto_cod_producto = producto_cod_producto;
    }

    public int getCantidad_fac_det() {
        return cantidad_fac_det;
    }

    public void setCantidad_fac_det(int cantidad_fac_det) {
        this.cantidad_fac_det = cantidad_fac_det;
    }

    public double getIva_fac() {
        return iva_fac;
    }

    public void setIva_fac(double iva_fac) {
        this.iva_fac = iva_fac;
    }

    public double getImporte_fac_det() {
        return importe_fac_det;
    }

    public void setImporte_fac_det(double importe_fac_det) {
        this.importe_fac_det = importe_fac_det;
    }

}
