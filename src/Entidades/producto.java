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
public class producto {

    private int cod_producto;
    private int cod_proveedor;
    private int marca_id_marca;
    private int id_categoria;
    private String nombre_prod;
    private String modelo_prod;
    private String imei_serie_producto;
    private String descripcion_prod;
    private double precio_compra_prod;
    private double precio_venta_publico_prod;
    private double iva_prod;
    private int stock_disponible_prod;

    public producto() {
    }

    public producto(int cod_producto, int cod_proveedor, int marca_id_marca, int id_categoria, String nombre_prod, String modelo_prod, String imei_serie_producto, String descripcion_prod, double precio_compra_prod, double precio_venta_publico_prod, double iva_prod, int stock_disponible_prod) {
        this.cod_producto = cod_producto;
        this.cod_proveedor = cod_proveedor;
        this.marca_id_marca = marca_id_marca;
        this.id_categoria = id_categoria;
        this.nombre_prod = nombre_prod;
        this.modelo_prod = modelo_prod;
        this.imei_serie_producto = imei_serie_producto;
        this.descripcion_prod = descripcion_prod;
        this.precio_compra_prod = precio_compra_prod;
        this.precio_venta_publico_prod = precio_venta_publico_prod;
        this.iva_prod = iva_prod;
        this.stock_disponible_prod = stock_disponible_prod;
    }

 
    public int getStock_disponible_prod() {
        return stock_disponible_prod;
    }

    public void setStock_disponible_prod(int stock_disponible_prod) {
        this.stock_disponible_prod = stock_disponible_prod;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(int cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public int getMarca_id_marca() {
        return marca_id_marca;
    }

    public void setMarca_id_marca(int marca_id_marca) {
        this.marca_id_marca = marca_id_marca;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getModelo_prod() {
        return modelo_prod;
    }

    public void setModelo_prod(String modelo_prod) {
        this.modelo_prod = modelo_prod;
    }

    public String getImei_serie_producto() {
        return imei_serie_producto;
    }

    public void setImei_serie_producto(String imei_serie_producto) {
        this.imei_serie_producto = imei_serie_producto;
    }

    public String getDescripcion_prod() {
        return descripcion_prod;
    }

    public void setDescripcion_prod(String descripcion_prod) {
        this.descripcion_prod = descripcion_prod;
    }

    public double getPrecio_compra_prod() {
        return precio_compra_prod;
    }

    public void setPrecio_compra_prod(double precio_compra_prod) {
        this.precio_compra_prod = precio_compra_prod;
    }

    public double getPrecio_venta_publico_prod() {
        return precio_venta_publico_prod;
    }

    public void setPrecio_venta_publico_prod(double precio_venta_publico_prod) {
        this.precio_venta_publico_prod = precio_venta_publico_prod;
    }

    public double getIva_prod() {
        return iva_prod;
    }

    public void setIva_prod(double iva_prod) {
        this.iva_prod = iva_prod;
    }

}
