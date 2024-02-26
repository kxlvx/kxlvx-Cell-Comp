/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.BD_Proveedor_Telefonos;
import Controlador.BD_Proveedor_email;
import Controlador.BD_categoria;
import Entidades.Validaciones;
import Entidades.categoria;
import Entidades.email_proveedor;
import Entidades.telefono_proveedor;
import Reportes.Global;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author samux
 */
public class frmProveedorEmail extends javax.swing.JFrame {

    /**
     * Creates new form frmClientes
     */
    public frmProveedorEmail() {
        initComponents();
        jLabel3.setVisible(false);
        txtBuscar.setVisible(false);
        jSeparator10.setVisible(false);
        this.setLocationRelativeTo(null);
        noMostrarDatosEmplado();
        txt_CodProveedor.setText(frmProveedor.txtCod_proveedor.getText());
        txtNombre_Proveedor.setText(frmProveedor.txtNombreEmpresa.getText());
        mostrar(txt_CodProveedor.getText());
        inhabilitar();
    }
    
     void noMostrarDatosEmplado() {
        lblCodigo.setVisible(false);
        lblTipoUser.setVisible(false);
        lblNombre.setVisible(false);
        lblApellidos.setVisible(false);
    }

    Validaciones validaciones = new Validaciones();
    private String accion = "guardar";

    void inhabilitar() {
        txt_CodProveedor.setEnabled(false);
        txt_CodProveedor.setEditable(false);
        txtEmail.setEnabled(false);
        txtId_Email.setEnabled(false);
        txtNombre_Proveedor.setEnabled(false);
       

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txt_CodProveedor.setText("");
        txtEmail.setText("");

    }

    void habilitar() {
        txt_CodProveedor.setEnabled(false);
        txt_CodProveedor.setEditable(false);
        txtEmail.setEnabled(true);
        txtId_Email.setEnabled(false);
        txtNombre_Proveedor.setEnabled(false);
        
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtId_Email.setText("");
        txtEmail.setText("");

    }
    
     void regresarMenuAnterior() {
        frmProveedor frm =  new frmProveedor();
        frm.lblCodigo.setText(lblCodigo.getText());
        frm.lblTipoUser.setText(lblTipoUser.getText());
        frm.lblNombre.setText(lblNombre.getText());
        frm.lblApellidos.setText(lblApellidos.getText());
        frm.txtCod_proveedor.setText(txt_CodProveedor.getText());
        this.dispose();
        frm.setVisible(true);
        frm.toFront();
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
            Global.generarReporte("rptEmailProveedores",params);
            inhabilitar();
        } catch (HeadlessException | FileNotFoundException | NumberFormatException | JRException ex) { 
            JOptionPane.showMessageDialog(null, "No se pudo imprimir la solicitud de reparacion");
            inhabilitar();
        }
    }
     
    void validarTelefono() {
        if(!Validaciones.esTelefono(txtEmail)) {
            JOptionPane.showConfirmDialog(rootPane, "El telefono debe contener numeros y debe tener un minimo de 7 a 13 digitos");
            txtEmail.setText("");
            txtEmail.requestFocus();
            return;
        }
    }
    
    void validarEmail() {
        if(!Validaciones.esEmail(txtEmail)) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un correo valido");
            txtEmail.setText("");
            txtEmail.requestFocus();
            return;
        }
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;

            BD_Proveedor_email func = new BD_Proveedor_email();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            //lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al acceder a los datos desde la base de datos");
        }
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        txt_CodProveedor = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNombre_Proveedor = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtId_Email = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        panelAtras = new javax.swing.JPanel();
        lblBack = new javax.swing.JLabel();
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
        panelUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Proveedores telefono/icons8_Office_Phone_100px_1.png"))); // NOI18N
        panelUser.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 100, 100));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cód. Prov:");
        panelUser.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 90, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email:");
        panelUser.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 80, -1));
        panelUser.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 180, 10));
        panelUser.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 180, 10));

        txtEmail.setBackground(new java.awt.Color(51, 153, 255));
        txtEmail.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setToolTipText("Ingrese teléfono");
        txtEmail.setBorder(null);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        panelUser.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 180, -1));

        txt_CodProveedor.setBackground(new java.awt.Color(51, 153, 255));
        txt_CodProveedor.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txt_CodProveedor.setForeground(new java.awt.Color(255, 255, 255));
        txt_CodProveedor.setBorder(null);
        txt_CodProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CodProveedorActionPerformed(evt);
            }
        });
        panelUser.add(txt_CodProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 180, -1));

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
        panelUser.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, -1));

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
        panelUser.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, -1, -1));

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
        panelUser.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 100, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Proveedor:");
        panelUser.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 80, -1));

        txtNombre_Proveedor.setBackground(new java.awt.Color(51, 153, 255));
        txtNombre_Proveedor.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtNombre_Proveedor.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre_Proveedor.setBorder(null);
        txtNombre_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_ProveedorActionPerformed(evt);
            }
        });
        panelUser.add(txtNombre_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 180, -1));
        panelUser.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 180, 10));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID_email:");
        panelUser.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 90, -1));

        txtId_Email.setBackground(new java.awt.Color(51, 153, 255));
        txtId_Email.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtId_Email.setForeground(new java.awt.Color(255, 255, 255));
        txtId_Email.setBorder(null);
        txtId_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_EmailActionPerformed(evt);
            }
        });
        panelUser.add(txtId_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 180, -1));
        panelUser.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 180, 10));

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

        panelUser.add(panelAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setText("Emails de los Proveedores ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 30));

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
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 240, 10));

        btnEliminar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Cliente/icons8_Delete_16px.png"))); // NOI18N
        btnEliminar.setText("Eliminar emails");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

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
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtBuscar.setText("Buscar por número de teléfono o celular");
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
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 240, -1));

        tablalistado = new javax.swing.JTable(){
            public boolean isCellEditable(int x,int y){
                return false;
            }
        };
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablalistado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 650, 290));

        lblCodigo.setText("Cod");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        lblTipoUser.setText("Tipo");
        jPanel1.add(lblTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        lblApellidos.setText("Apellidos");
        jPanel1.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
            .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
        txtEmail.transferFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txt_CodProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CodProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CodProveedorActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        //Validacion de que se deben llenar los regitros principales

        if (txtEmail.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el email");
            txtEmail.requestFocus();
            return;
        }
        
        
        /**
        if(!(txtEmail.getText().equals("") || txtEmail.getText().equals("N/D"))) {
            validarEmail();
        }
        * **/
        //Almacenamiento de los datos 
        //se crea un cliente nuevo
        email_proveedor ca = new email_proveedor();
        ca.setCod_proveedor(Integer.parseInt(txt_CodProveedor.getText()));
        ca.setEmail_proveedor(txtEmail.getText());
        //se crea la clase de conexion a la base de datos
        BD_Proveedor_email bd = new BD_Proveedor_email();

        //Para guardar un nuevo cliente
        if (accion.equals("guardar")) {
            if (bd.insertar(ca)) {
                JOptionPane.showMessageDialog(rootPane, "El email fue registrado satisfactoriamente");
                mostrar(txt_CodProveedor.getText());
                inhabilitar();
            }
        } //para editar un cliente existente
        else if (accion.equals("editar")) {
            ca.setCod_email_prov(Integer.parseInt(txtId_Email.getText()));

            if (bd.editar(ca)) {
                JOptionPane.showMessageDialog(rootPane, "El email fue editado satisfactoriamente");
                mostrar(txt_CodProveedor.getText());
                inhabilitar();
            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnGuardar.setText("Editar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtId_Email.setText(tablalistado.getValueAt(fila, 0).toString());
        txtEmail.setText(tablalistado.getValueAt(fila, 3).toString());

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (!txt_CodProveedor.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de Eliminar el email?", "Confirmar", 2);
            if (confirmacion == 0) {
                BD_Proveedor_email func = new BD_Proveedor_email();
                email_proveedor dts = new email_proveedor();

                dts.setCod_email_prov(Integer.parseInt(txtId_Email.getText()));
                func.eliminar(dts);
                mostrar(txt_CodProveedor.getText());
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        mostrar(txt_CodProveedor.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        // TODO add your handling code here:
        txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtNombre_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_ProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_ProveedorActionPerformed

    private void txtId_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_EmailActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if(!(txtEmail.getText().equals("") || txtEmail.getText().equals("N/D"))) {
            validarEmail();
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
        //char c = evt.getKeyChar();   
        //no permite ingreso de caracter que no sea un numero
	//if(!(c+"").matches("[0-9]")) evt.consume();
    }//GEN-LAST:event_txtEmailKeyTyped

    private void panelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAtrasMouseClicked
        // TODO add your handling code here:
        regresarMenuAnterior();
    }//GEN-LAST:event_panelAtrasMouseClicked

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
            java.util.logging.Logger.getLogger(frmProveedorEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProveedorEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProveedorEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProveedorEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProveedorEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId_Email;
    public javax.swing.JTextField txtNombre_Proveedor;
    public javax.swing.JTextField txt_CodProveedor;
    // End of variables declaration//GEN-END:variables
}
