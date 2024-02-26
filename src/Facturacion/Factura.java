package Facturacion;

import Controlador.BD_Factura;
import Controlador.BD_producto;
import Vistas.*;

import Entidades.factura;
import Reportes.Reportes;
import Validaciones.Validar;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Samuel Isaias Calderon Aguirre
 */
public class Factura extends javax.swing.JFrame {
    
    public static DefaultTableModel modelo;
    
    public static void PonerSubtotal() {
        int totalfilas = tabla.getRowCount();
        double subtotal0 = 0;
        for (int i = 0; i < totalfilas; i++) {
            double codigo = Double.parseDouble(tabla.getValueAt(i, 4).toString());
            subtotal0 += codigo;
        }
        txtSubtotal_0.setText(subtotal0 + "");
        
    }
    
    public Factura() {
        
        initComponents();
        btnSeleccionar.setEnabled(false);
        this.setLocationRelativeTo(null);
        noMostrarDatosEmplado();
        inhabilitar();
        txtFecha.setEditable(false);
        noEditable();
        txtFecha.setText("" + new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
        reiniciarTabla();
        tabla.setModel(modelo);
    }
    
    void establecerfechaActual() {
        txtFecha.setText("" + new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
    }
    
    void establecerEmpleadoActual() {
        lblCodigoUser.setText(lblCodigo.getText());
        lblUser.setText(lblNombre.getText() + " " + lblApellidos.getText());
    }
    
    void regresarMenuAnterior() {
        frmInicio frm = new frmInicio();
        frm.lblCodigoEmp.setText(lblCodigo.getText());
        frm.lblCargo.setText(lblTipoUser.getText());
        frm.lblNombres.setText(lblNombre.getText());
        frm.lblApellidos.setText(lblApellidos.getText());
        this.dispose();
        frm.setVisible(true);
        frm.toFront();
    }
    
    void noMostrarDatosEmplado() {
        lblCodigo.setVisible(false);
        lblTipoUser.setVisible(false);
        lblNombre.setVisible(false);
        lblApellidos.setVisible(false);
        lbltotalregistros.setVisible(false);
    }
    
    void inhabilitar() {
        //inhabilitar botones 
        btnReiniciar.setEnabled(false);
        btnBuscarCliente.setEnabled(false);
        btnNuevoCliente.setEnabled(false);
        btnGenerarFactura.setEnabled(false);
        btnImprimirSolicitud.setEnabled(false);

        //inahabilitar cajas de texto
        txtCod_Factura.setEnabled(false);
        txtNum_Factura.setEnabled(false);
        txtFecha.setEditable(false);
        txtCod_cliente.setEnabled(false);
        txtCI.setEnabled(false);
        txtnombresApellidos.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtSubtotal_0.setEnabled(false);
        txt_Iva.setEnabled(false);
        txtSubtotal_1.setEnabled(false);
        txtDescuento.setEnabled(false);
        
        limpiarControles();
    }
    
    void limpiarControles() {
        txtNum_Factura.setText("");
        txtCod_cliente.setText("");
        txtCI.setText("");
        txtnombresApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtSubtotal_0.setText("");
        txt_Iva.setText("");
        txtSubtotal_1.setText("");
        txtDescuento.setText("");
        txtTotal.setText("");
        
    }
    
    void noEditable() {
        txtCod_cliente.setEditable(false);
        txtCI.setEditable(false);
        txtDireccion.setEditable(false);
        txtnombresApellidos.setEditable(false);
        txtTelefono.setEditable(false);
    }
    
    void habilitar() {
        btnBuscarCliente.setEnabled(true);
        btnNuevoCliente.setEnabled(true);
        txtCod_Factura.setEnabled(false);
        txtNum_Factura.setEnabled(true);
        txtFecha.setEditable(false);
        txtCod_cliente.setEnabled(true);
        txtCI.setEnabled(true);
        txtnombresApellidos.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtSubtotal_0.setEnabled(true);
        txt_Iva.setEnabled(true);
        txtSubtotal_1.setEnabled(true);
        txtDescuento.setEnabled(true);
        
        limpiarControles();
    }
    
    void comprobarComprobante() {
        
        JOptionPane.showMessageDialog(null, "No se puede generar la factura/n Asegurece de tener llenos todos los campos");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelAtras = new javax.swing.JPanel();
        lblBack = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblTipoUser = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCod_cliente = new javax.swing.JTextField();
        txtCI = new javax.swing.JTextField();
        txtnombresApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCod_Factura = new javax.swing.JTextField();
        txtNum_Factura = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();
        btnNuevaSolicitud = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCodigoUser = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtSubtotal_0 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSubtotal_1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_Iva = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnGenerarFactura = new javax.swing.JButton();
        btnImprimirSolicitud = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAtras.setBackground(new java.awt.Color(0, 102, 204));
        panelAtras.setToolTipText("Regresar");
        panelAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAtrasMouseClicked(evt);
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

        jPanel1.add(panelAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        lblCodigo.setText("Cod");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        lblTipoUser.setText("Tipo");
        jPanel1.add(lblTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        lblApellidos.setText("Apellidos");
        jPanel1.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        lblCerrar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        lblCerrar.setText("x");
        lblCerrar.setToolTipText("Salir");
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, 20));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Documents_24px_1.png"))); // NOI18N
        jLabel1.setText(" Factura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 11))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel2.setText("Código cliente:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 31, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel3.setText("C.I./RUC:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 61, 86, -1));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel4.setText("Cliente: ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 86, -1));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel5.setText("Dirección:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel6.setText("Teléfono:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 57, -1));

        txtCod_cliente.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtCod_cliente.setText("0000000");
        txtCod_cliente.setToolTipText("");
        txtCod_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_clienteActionPerformed(evt);
            }
        });
        jPanel2.add(txtCod_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 28, 270, -1));

        txtCI.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtCI.setText("99999999999");
        txtCI.setToolTipText("Ingrese el RUC o CI");
        jPanel2.add(txtCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 55, 270, -1));

        txtnombresApellidos.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtnombresApellidos.setText("Nombres y Apellidos");
        jPanel2.add(txtnombresApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 390, -1));

        txtDireccion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtDireccion.setText("N/D");
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 390, -1));

        txtTelefono.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtTelefono.setText("99999999999999");
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 390, -1));

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Search_50px.png"))); // NOI18N
        btnBuscarCliente.setToolTipText("Buscar Cliente y agregar ");
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 50, 50));

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Add_User_Male_50px.png"))); // NOI18N
        btnNuevoCliente.setToolTipText("Nuevo cliente");
        btnNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 60, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 510, 170));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel7.setText("Código Factura:");

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel8.setText("Número de Factura:");

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel9.setText("Fecha de Solicitud:");

        txtCod_Factura.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        txtNum_Factura.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtNum_Factura.setToolTipText("Ingrese numero de Solicitud");
        txtNum_Factura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNum_FacturaKeyTyped(evt);
            }
        });

        txtFecha.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod_Factura, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(txtNum_Factura)
                    .addComponent(txtFecha))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCod_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNum_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 260, 90));

        btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Reset_32px.png"))); // NOI18N
        btnReiniciar.setToolTipText("Reiniciar");
        btnReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 40, 40));

        btnNuevaSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_New_Copy_32px.png"))); // NOI18N
        btnNuevaSolicitud.setToolTipText("Nueva Solicitud de reparación");
        btnNuevaSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevaSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 40, 40));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel10.setText("Código de usuario:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel11.setText("Usuario:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lblCodigoUser.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        lblCodigoUser.setText("00");
        jPanel1.add(lblCodigoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 120, -1));

        lblUser.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        lblUser.setText("Nombres y Apellidos ");
        jPanel1.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 180, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Precio a pagar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 11))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubtotal_0.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtSubtotal_0.setToolTipText("Ingrese la marca del equipo");
        txtSubtotal_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotal_0ActionPerformed(evt);
            }
        });
        txtSubtotal_0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSubtotal_0KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubtotal_0KeyTyped(evt);
            }
        });
        jPanel4.add(txtSubtotal_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel12.setText("Subtotal 1:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        txtSubtotal_1.setEditable(false);
        txtSubtotal_1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtSubtotal_1.setToolTipText("Ingrese el IMEI y Serie del equipo");
        txtSubtotal_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubtotal_1KeyTyped(evt);
            }
        });
        jPanel4.add(txtSubtotal_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 410, -1));

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel13.setText("Subtotal 0 :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel14.setText("Iva %:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        txt_Iva.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_Iva.setToolTipText("Ingrese el modelo del equipo");
        txt_Iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IvaActionPerformed(evt);
            }
        });
        txt_Iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_IvaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IvaKeyTyped(evt);
            }
        });
        jPanel4.add(txt_Iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 200, -1));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel15.setText("Descuento: ");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, -1));

        txtDescuento.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtDescuento.setToolTipText("Clave de usuario del equipo");
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });
        jPanel4.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 410, -1));

        jLabel17.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel17.setText("Total:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 60, -1));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtTotal.setToolTipText("Clave de usuario del equipo");
        jPanel4.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 410, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 520, 150));
        jPanel4.getAccessibleContext().setAccessibleName("Precio ");

        btnGenerarFactura.setText("Generar Factura");
        btnGenerarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 200, -1));

        btnImprimirSolicitud.setText("Imprimir");
        btnImprimirSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimirSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimirSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 580, 90, -1));

        lbltotalregistros.setText("jLabel17");
        jPanel1.add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 520, 90));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAtrasMouseClicked
        // TODO add your handling code here:
        regresarMenuAnterior();
    }//GEN-LAST:event_panelAtrasMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void txtCod_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_clienteActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        limpiarControles();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnNuevaSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaSolicitudActionPerformed
        // TODO add your handling code here:
        btnReiniciar.setEnabled(true);
        btnImprimirSolicitud.setEnabled(false);
        btnGenerarFactura.setEnabled(false);
        establecerEmpleadoActual();
        establecerfechaActual();
        habilitar();
        btnSeleccionar.setEnabled(true);
        int numero = BD_Factura.UltimoRegistro() + 1;
        txtNum_Factura.setText(numero + "");
        //System.out.println(cboEstadoSolicitud.getSelectedItem().toString());
    }//GEN-LAST:event_btnNuevaSolicitudActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        digVistaClientes dig = new digVistaClientes(null, false);
        dig.PadreQueLlamo = "Factura";
        dig.setModal(true);
        dig.setVisible(true);
        

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        if (txtCod_cliente.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes seleccionar un cliente");
            btnBuscarCliente.requestFocus();
            return;
        }
        if (txtSubtotal_0.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar  el subtotal_0");
            txtSubtotal_0.requestFocus();
            return;
        }
        if (txt_Iva.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el Iva");
            txt_Iva.requestFocus();
            return;
        }
        if ((txtDescuento.getText().length() == 0)) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el descuento");
            txtDescuento.requestFocus();
            return;
        }
        if (JOptionPane.showConfirmDialog(null, "Esta seguro que desea generar la factura") == JOptionPane.OK_OPTION) {
            
            Entidades.factura f = new factura();
            f.setCod_cliente(Integer.parseInt(txtCod_cliente.getText()));
            f.setCod_empleado(Integer.parseInt(lblCodigoUser.getText()));
            f.setNum_factura(Integer.parseInt(txtNum_Factura.getText()));
            Date fecha = new Date(2018, 02, 02);
            f.setFecha_emision_fac(fecha);
            f.setSubtotal_0_fac(Double.parseDouble(txtSubtotal_0.getText()));
            f.setIva(Double.parseDouble(txt_Iva.getText()));
            f.setSubtotal_1_fac(Double.parseDouble(txtSubtotal_1.getText()));
            f.setDescuento_fac(Double.parseDouble(txtDescuento.getText()));
            f.setTotal_fac(Double.parseDouble(txtTotal.getText()));
            BD_Factura bd = new BD_Factura();
            if (bd.insertar(f)) {
                JOptionPane.showMessageDialog(null, "La factura se genero con exito");
                BD_producto bdp = new BD_producto();
                
                int totalfilas = tabla.getRowCount();
                for (int i = 0; i < totalfilas; i++) {
                    
                    int codigo = Integer.parseInt(tabla.getValueAt(i, 0).toString());
                    int cantidad = Integer.parseInt(tabla.getValueAt(i, 2).toString());
                    bdp.editarCantidad(codigo, cantidad);
                }
                
                btnGenerarFactura.setEnabled(true);
                btnImprimirSolicitud.setEnabled(true);
                btnSeleccionar.setEnabled(false);
                reiniciarTabla();
              
            }
            
        }
        

    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

    private void txtNum_FacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNum_FacturaKeyTyped

    }//GEN-LAST:event_txtNum_FacturaKeyTyped

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        digClientes dg = new digClientes(null, false);
        dg.setModal(true);
        dg.setVisible(true);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnImprimirSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirSolicitudActionPerformed
        Map params = new HashMap();
        String rutalogo = Reportes.ObtenerRuta() + "Archivos\\Imagenes Menu Princpal\\cellcomp logo.jpg";
        String rutaFactura = Reportes.ObtenerRuta() + "Reportes\\Factura.jasper";
        System.out.println(rutalogo);
        System.out.println(rutaFactura);
        params.put("logo", rutalogo);
        params.put("codigo", Integer.parseInt(txtNum_Factura.getText()));
        try {
            Reportes.generarReporte(rutaFactura, params);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Sucedio una excepcion ha realizar el reporte");
        }
        limpiarControles();
        inhabilitar();
        
    }//GEN-LAST:event_btnImprimirSolicitudActionPerformed
    

    private void txt_IvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IvaActionPerformed

    }//GEN-LAST:event_txt_IvaActionPerformed

    private void txtSubtotal_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotal_0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotal_0ActionPerformed

    private void txtSubtotal_0KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubtotal_0KeyReleased
        if (Validar.esFlotante(txtSubtotal_0) || Validar.esNumero(txtSubtotal_0)) {
            CalcularSubtotal();
        }
    }//GEN-LAST:event_txtSubtotal_0KeyReleased

    private void txt_IvaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IvaKeyReleased
        
        if (Validar.esFlotante(txt_Iva) || Validar.esNumero(txt_Iva)) {
            CalcularSubtotal();
        }
    }//GEN-LAST:event_txt_IvaKeyReleased

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        if (Validar.esFlotante(txtDescuento) || Validar.esNumero(txtDescuento)) {
            CalcularSubtotal();
        }
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void txtSubtotal_0KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubtotal_0KeyTyped
        Validar.NumerosDecimales(evt, txtSubtotal_0);        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotal_0KeyTyped

    private void txt_IvaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IvaKeyTyped
        Validar.NumerosDecimales(evt, txt_Iva);
    }//GEN-LAST:event_txt_IvaKeyTyped

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        Validar.NumerosDecimales(evt, txtDescuento);
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtSubtotal_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubtotal_1KeyTyped

    }//GEN-LAST:event_txtSubtotal_1KeyTyped

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        digVistaProductos vista = new digVistaProductos(this, false);
        vista.setVisible(true);
        vista.show();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnGenerarFactura;
    public static javax.swing.JButton btnImprimirSolicitud;
    private javax.swing.JButton btnNuevaSolicitud;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCerrar;
    public javax.swing.JLabel lblCodigo;
    public static javax.swing.JLabel lblCodigoUser;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblTipoUser;
    public static javax.swing.JLabel lblUser;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JPanel panelAtras;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTextField txtCI;
    public static javax.swing.JTextField txtCod_Factura;
    public static javax.swing.JTextField txtCod_cliente;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtNum_Factura;
    public static javax.swing.JTextField txtSubtotal_0;
    public static javax.swing.JTextField txtSubtotal_1;
    public static javax.swing.JTextField txtTelefono;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txt_Iva;
    public static javax.swing.JTextField txtnombresApellidos;
    // End of variables declaration//GEN-END:variables

    private void CalcularSubtotal() {
        double total = 0;
        if (!txtSubtotal_0.getText().isEmpty() && !txt_Iva.getText().isEmpty()) {
            double subtotal_0 = Double.parseDouble(txtSubtotal_0.getText());
            double iva = Double.parseDouble(txt_Iva.getText()) / 100;
            double subtotal_1 = subtotal_0 + (subtotal_0 * iva);
            subtotal_1 = Math.rint((subtotal_1 * 100)) / 100;
            txtSubtotal_1.setText(subtotal_1 + "");
            if (!txtDescuento.getText().isEmpty()) {
                total = subtotal_1 - Double.parseDouble(txtDescuento.getText());
                total=Math.rint((total * 100)) / 100;
                txtTotal.setText(String.valueOf(total));
            }
            txtTotal.setText(String.valueOf(total));
            if (total != 0) {
                btnGenerarFactura.setEnabled(true);
            }
        } else {
            txtSubtotal_1.setText("0");
            
        }
    }
    
    private void reiniciarTabla() {
        String titulo[] = {"Codigo", "Descripcion", "Cantidad", "Valor Unitario", "Valor Total"};
        modelo = new DefaultTableModel(null, titulo);
        tabla.setModel(modelo);
//        int totalfilas = modelo.getRowCount();
//        for (int i = totalfilas; i > 0; i++) {
//            modelo.removeRow(0);
//        }
        
    }
}
