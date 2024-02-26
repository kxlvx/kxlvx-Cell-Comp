/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.BD_empleado;
import Controlador.BD_producto;
import Entidades.Validaciones;
import Entidades.empleado;
import Entidades.producto;
import Reportes.Global;
import Validaciones.Validar;
import static Vistas.frmSolicitudReparacion.txtCod_Solicitud;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author kalva
 */
public class frmProductos extends javax.swing.JFrame {

    /**
     * Creates new form frmEmpleados
     */
    public frmProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        noMostrarDatosEmplado();
        mostrar("");
        inhabilitar();

    }
    public static int idProveedor = -1;
    public static int idMarca = -1;
    public static int idCategoria = -1;
    Validaciones validaciones = new Validaciones();
    private String accion = "guardar";

    void noMostrarDatosEmplado() {
        lblCodigo.setVisible(false);
        lblTipoUser.setVisible(false);
        lblNombre.setVisible(false);
        lblApellidos.setVisible(false);
    }
    
    void imprimirReporte() {
        try {
            JOptionPane.showMessageDialog(null, "Imprimiendo Reporte");
            //int cod_solicitud = Integer.parseInt(txtCod_Solicitud.getText());
            //String cad="solicitud";
            //agregar parametros al reporte
            Map<String, Object> params = new HashMap<String, Object>();
            //params.put("codigoDeSolicitud", cod_solicitud);
            //params.put("solicitud", cad);
            Global.generarReporte("rptProductos",params);
            inhabilitar();
        } catch (HeadlessException | FileNotFoundException | NumberFormatException | JRException ex) { 
            JOptionPane.showMessageDialog(null, "No se pudo imprimir la solicitud de reparacion");
            inhabilitar();
        }
    }
    

    void regresarMenuAnterior() {
        frmInventario frm = new frmInventario();
        frm.lblCodigo.setText(lblCodigo.getText());
        frm.lblTipoUser.setText(lblTipoUser.getText());
        frm.lblNombre.setText(lblNombre.getText());
        //frm.lblApellidos.setText(lblApellidos.getText());
        frm.lblApellidos.setText(lblApellidos.getText());
        this.dispose();
        frm.setVisible(true);
        frm.toFront();
    }

    void inhabilitar() {
        txtCod_Producto.setEnabled(false);
        txtNombre.setEnabled(false);
        txtModelo.setEnabled(false);
        txtImei.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtPrecioCompra.setEnabled(false);
        txtPrecioVenta.setEnabled(false);
        txtStock.setEnabled(false);
        txtIva.setEnabled(false);
        //botones
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);

        btnMarca.setEnabled(false);
        btnCategoria.setEnabled(false);
        btnProveedor.setEnabled(false);

        txtCod_Producto.setText("");
        txtNombre.setText("");
        txtModelo.setText("");
        txtImei.setText("");
        txtPrecioVenta.setText("");
        txtDescripcion.setText("");
        txtPrecioCompra.setText("");;
        txtStock.setText("");
        txtIva.setText("");
    }

    void habilitar() {
        txtCod_Producto.setEnabled(false);
        txtNombre.setEnabled(true);
        txtModelo.setEnabled(true);
        txtImei.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtPrecioCompra.setEnabled(true);
        txtPrecioVenta.setEnabled(true);
        txtStock.setEnabled(true);
        txtIva.setEnabled(true);
        // btnTelefono.setEnabled(true);// Aunno se abilita por que no se ha guardado
        btnProveedor.setEnabled(true);
        btnMarca.setEnabled(true);
        btnCategoria.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtCod_Producto.setText("");
        txtNombre.setText("");
        txtModelo.setText("");
        txtImei.setText("");
        txtPrecioVenta.setText("");
        txtDescripcion.setText("");
        txtPrecioCompra.setText("");;
        txtIva.setText("");;
        txtStock.setText("");
    }

    void mostrar(String buscar) {
        BD_producto func = new BD_producto();
        DefaultTableModel modelo = func.mostrar(buscar);
        tablalistado.setModel(modelo);
        //lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUser = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtImei = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtCod_Producto = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelAtras = new javax.swing.JPanel();
        lblBack = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        btnCategoria = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btnMarca = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        btnProveedor = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lblCodigo = new javax.swing.JLabel();
        lblTipoUser = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelUser.setBackground(new java.awt.Color(51, 153, 255));
        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Proveedores/icons8_Company_100px_1.png"))); // NOI18N
        panelUser.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 100, 100));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Código :");
        panelUser.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre :");
        panelUser.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Modelo:");
        panelUser.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Imei:");
        panelUser.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 309, 70, 20));
        panelUser.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 180, 10));
        panelUser.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 180, 10));
        panelUser.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 180, 0));
        panelUser.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 392, 180, 10));
        panelUser.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 190, 10));

        txtNombre.setBackground(new java.awt.Color(51, 153, 255));
        txtNombre.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setToolTipText("Ingrese el nombre de la empresa");
        txtNombre.setBorder(null);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelUser.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 180, -1));

        txtModelo.setBackground(new java.awt.Color(51, 153, 255));
        txtModelo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(255, 255, 255));
        txtModelo.setToolTipText("Ingrese el nombre y apellido del representante");
        txtModelo.setBorder(null);
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });
        panelUser.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 180, -1));

        txtImei.setBackground(new java.awt.Color(51, 153, 255));
        txtImei.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtImei.setForeground(new java.awt.Color(255, 255, 255));
        txtImei.setToolTipText("Ingrese Apellidos");
        txtImei.setBorder(null);
        txtImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImeiActionPerformed(evt);
            }
        });
        panelUser.add(txtImei, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 180, -1));

        txtPrecioVenta.setBackground(new java.awt.Color(51, 153, 255));
        txtPrecioVenta.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtPrecioVenta.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioVenta.setToolTipText("Ingrese Dirección");
        txtPrecioVenta.setBorder(null);
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });
        panelUser.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 180, -1));

        txtCod_Producto.setBackground(new java.awt.Color(51, 153, 255));
        txtCod_Producto.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtCod_Producto.setForeground(new java.awt.Color(255, 255, 255));
        txtCod_Producto.setBorder(null);
        txtCod_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_ProductoActionPerformed(evt);
            }
        });
        panelUser.add(txtCod_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 180, -1));

        btnNuevo.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Cliente/icons8_Add_User_Male_16px.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Agregar un nuevo cliente");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelUser.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 90, -1));

        btnGuardar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Cliente/icons8_Save_16px.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar/Editar un cliente");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelUser.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Cliente/icons8_Cancel_16px.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Salir ");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelUser.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 100, -1));

        panelAtras.setBackground(new java.awt.Color(0, 102, 204));
        panelAtras.setToolTipText("Regresar");
        panelAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAtrasMouseClicked(evt);
            }
        });
        panelAtras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelAtrasKeyPressed(evt);
            }
        });

        lblBack.setBackground(new java.awt.Color(255, 51, 51));
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Princpal/icons8_Left_40px.png"))); // NOI18N

        javax.swing.GroupLayout panelAtrasLayout = new javax.swing.GroupLayout(panelAtras);
        panelAtras.setLayout(panelAtrasLayout);
        panelAtrasLayout.setHorizontalGroup(
            panelAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAtrasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBack))
        );
        panelAtrasLayout.setVerticalGroup(
            panelAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAtrasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBack))
        );

        panelUser.add(panelAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Descripción:");
        panelUser.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 100, -1));

        txtDescripcion.setBackground(new java.awt.Color(51, 153, 255));
        txtDescripcion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setToolTipText("Ingrese Dirección");
        txtDescripcion.setBorder(null);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        panelUser.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 180, -1));
        panelUser.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 328, 180, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Stock:");
        panelUser.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 90, 30));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Precio Compra:");
        panelUser.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, 30));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Precio de Venta:");
        panelUser.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 120, 30));

        txtStock.setBackground(new java.awt.Color(51, 153, 255));
        txtStock.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtStock.setForeground(new java.awt.Color(255, 255, 255));
        txtStock.setToolTipText("Ingrese Dirección");
        txtStock.setBorder(null);
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });
        panelUser.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 180, 20));

        txtPrecioCompra.setBackground(new java.awt.Color(51, 153, 255));
        txtPrecioCompra.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtPrecioCompra.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioCompra.setToolTipText("Ingrese Dirección");
        txtPrecioCompra.setBorder(null);
        txtPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCompraActionPerformed(evt);
            }
        });
        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });
        panelUser.add(txtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 369, 180, 20));
        panelUser.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 180, -1));
        panelUser.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 418, 180, -1));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Proveedor");
        panelUser.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 80, -1));

        btnCategoria.setText("...");
        btnCategoria.setToolTipText("Ver telléfonos del proveedor");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        panelUser.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Categoria:");
        panelUser.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 80, -1));

        btnMarca.setText("...");
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });
        panelUser.add(btnMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, 20));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Marca:");
        panelUser.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, 20));

        btnProveedor.setText("...");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        panelUser.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, 20));
        panelUser.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 180, 10));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Iva:");
        panelUser.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 90, 30));

        txtIva.setBackground(new java.awt.Color(51, 153, 255));
        txtIva.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtIva.setForeground(new java.awt.Color(255, 255, 255));
        txtIva.setToolTipText("Ingrese Dirección");
        txtIva.setBorder(null);
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        txtIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIvaKeyTyped(evt);
            }
        });
        panelUser.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 180, 20));
        panelUser.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 180, 10));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setText("Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        lblCerrar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        lblCerrar.setText("x");
        lblCerrar.setToolTipText("Salir");
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Cliente/icons8_Search_24px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 360, 10));

        btnEliminar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Cliente/icons8_Delete_16px.png"))); // NOI18N
        btnEliminar.setText("Eliminar Producto");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        btnReporte.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Cliente/icons8_Report_Card_16px.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setToolTipText("Ver Listado de clientes");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 60, 100, -1));

        txtBuscar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtBuscar.setText("Buscar por codigo o Nombre");
        txtBuscar.setToolTipText("Buscar Clientes por cédula o RUC");
        txtBuscar.setBorder(null);
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 360, -1));

        tablalistado = new javax.swing.JTable(){
            public boolean isCellEditable(int x,int y){
                return false;
            }
        };
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 650, 420));

        lblCodigo.setText("Cod");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        lblTipoUser.setText("Tipo");
        jPanel1.add(lblTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        lblApellidos.setText("Apellidos");
        jPanel1.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
            .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        txtNombre.transferFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
        txtModelo.transferFocus();
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        // TODO add your handling code here:
        // TODO add your handling code here:
        /***
        char c = evt.getKeyChar();
        //no permite ingreso de caracter que no sea un numero
        if (!(c + "").matches("[a-zA-ZáéíóúÁÉÍÓÚÑñ ]")) {
            evt.consume();
        }
        * **/
    }//GEN-LAST:event_txtModeloKeyTyped

    private void txtImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImeiActionPerformed
        // TODO add your handling code here:
        txtImei.transferFocus();
    }//GEN-LAST:event_txtImeiActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
        txtPrecioVenta.transferFocus();
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtCod_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_ProductoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        //Validacion de que se deben llenar los regitros principales

        if (txtNombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor, ingresar el nombre del producto");
            txtNombre.requestFocus();
            return;
        }
        if (txtModelo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor, ingresar el modelo del producto");
            txtModelo.requestFocus();
            return;
        }
        if ((txtImei.getText().length() == 0)) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor, ingresar el imei del producto");
            txtImei.requestFocus();
            return;
        }

        if (txtDescripcion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor, ingresar la descripcion del producto");
            txtDescripcion.requestFocus();
            return;
        }
        if (txtPrecioCompra.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor, ingresar el precio de compra de producto");
            txtPrecioCompra.requestFocus();
            return;
        }
        if (txtPrecioVenta.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor, ingresar el precio de venta del producto");
            txtPrecioVenta.requestFocus();
            return;
        }
        if (txtIva.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor ingrese el Iva ");
            txtIva.requestFocus();
            return;
        }
        if (txtStock.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor ingrese la cantidad de productos");
            txtStock.requestFocus();
            return;
        }
        if (idProveedor == -1) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor escoja un proveedor ");
            btnProveedor.requestFocus();
            return;
        }
        if (idMarca == -1) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor escoja una marca ");
            btnMarca.requestFocus();
            return;
        }
        if (idCategoria == -1) {
            JOptionPane.showConfirmDialog(rootPane, "Por favor escoja una categoria ");
            btnCategoria.requestFocus();
            return;
        }

        //Almacenamiento de los datos
        //se crea un empleado nuevo
        producto pro = new producto();
        //se crea la clase de conexion a la base de datos
        BD_producto bd = new BD_producto();

        pro.setCod_proveedor(idProveedor);
        pro.setMarca_id_marca(idMarca);
        pro.setId_categoria(idCategoria);
        pro.setNombre_prod(txtNombre.getText());
        pro.setModelo_prod(txtModelo.getText());
        pro.setImei_serie_producto(txtImei.getText());
        pro.setDescripcion_prod(txtDescripcion.getText());
        pro.setPrecio_compra_prod(Double.parseDouble(txtPrecioCompra.getText()));
        pro.setPrecio_venta_publico_prod(Double.parseDouble(txtPrecioVenta.getText()));
        pro.setIva_prod(Double.parseDouble(txtIva.getText()));
         pro.setStock_disponible_prod(Integer.parseInt(txtStock.getText()));
        if (accion.equals("guardar")) {
            if (bd.insertar(pro)) {
                JOptionPane.showMessageDialog(rootPane, "El producto fue registrado satisfactoriamente");
                mostrar("");
                inhabilitar();
            }
        } //para editar un cliente existente
        else if (accion.equals("editar")) {
            pro.setCod_producto(Integer.parseInt(txtCod_Producto.getText()));

            if (bd.editar(pro)) {
                JOptionPane.showMessageDialog(rootPane, "El producto fue editado satisfactoriamente");
                mostrar("");
                inhabilitar();
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void panelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAtrasMouseClicked
        // TODO add your handling code here:
        regresarMenuAnterior();
    }//GEN-LAST:event_panelAtrasMouseClicked

    private void panelAtrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelAtrasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelAtrasKeyPressed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        digVistaCategoria dg = new digVistaCategoria(null, false);
        // dg.txtNombre_Empleado.setText(txtModelo.getText());
        // dg.txt_CodEmpleado.setText(txtCod_Producto.getText());
        dg.setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (!txtCod_Producto.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de Eliminar el producto?", "Confirmar", 2);
            if (confirmacion == 0) {
                BD_producto func = new BD_producto();
                producto dts = new producto();
                dts.setCod_producto(Integer.parseInt(txtCod_Producto.getText()));
                func.eliminar(dts.getCod_producto());
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        // TODO add your handling code here:
        txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnGuardar.setText("Editar");
        habilitar();
        btnEliminar.setEnabled(true);
        btnCategoria.setEnabled(true);
        accion = "editar";
        int fila = tablalistado.rowAtPoint(evt.getPoint());
        txtCod_Producto.setText(tablalistado.getValueAt(fila, 0).toString());
        txtNombre.setText(tablalistado.getValueAt(fila, 4).toString());
        txtModelo.setText(tablalistado.getValueAt(fila, 5).toString());
        txtImei.setText(tablalistado.getValueAt(fila, 6).toString());
        txtDescripcion.setText(tablalistado.getValueAt(fila, 7).toString());
        txtPrecioCompra.setText(tablalistado.getValueAt(fila, 8).toString());
        txtPrecioVenta.setText(tablalistado.getValueAt(fila, 9).toString());
        txtIva.setText(tablalistado.getValueAt(fila, 10).toString());
        txtStock.setText(tablalistado.getValueAt(fila, 11).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed

    }//GEN-LAST:event_txtIvaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        digVistaProveedores vista = new digVistaProveedores(null, false);
        vista.setVisible(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        digVistaMarca vista = new digVistaMarca(null, false);
        vista.setVisible(true);
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        Validar.NumerosDecimales(evt, txtPrecioCompra);        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        Validar.NumerosDecimales(evt, txtPrecioVenta);         // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtIvaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIvaKeyTyped
        Validar.NumerosDecimales(evt, txtIva);            // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        Validar.SoloNumeros(evt);
    }//GEN-LAST:event_txtStockKeyTyped

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        imprimirReporte();
    }//GEN-LAST:event_btnReporteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCerrar;
    public javax.swing.JLabel lblCodigo;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblTipoUser;
    private javax.swing.JPanel panelAtras;
    private javax.swing.JPanel panelUser;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtCod_Producto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtImei;
    private javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtModelo;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
