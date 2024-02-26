/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.BD_solicitud_reparacion;
import Entidades.solicitud_reparacion;
import Reportes.Global;
import Validaciones.Validar;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Samuel Isaias Calderon Aguirre 
 */
public class frmSolicitudReparacion extends javax.swing.JFrame {

    /**
     * Creates new form frmSolicitudReparacion
     */
    
    DecimalFormat formatter = new DecimalFormat( "#0.00" );
    
    public frmSolicitudReparacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        noMostrarDatosEmplado();
        inhabilitar();
        txtFecha.setEditable(false);
        noEditable();
        txtFecha.setText("" + new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
        tablalistado.setVisible(false);
        jScrollPane2.setVisible(false);
        mostrar("");
    }
    
    void establecerfechaActual() {
        txtFecha.setText("" + new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
    }
    
    void establecerEmpleadoActual() {
        lblCodigoUser.setText(lblCodigo.getText());
        lblUser.setText(lblNombre.getText() + " " + lblApellidos.getText());
    }
    
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            BD_solicitud_reparacion func = new BD_solicitud_reparacion();
            modelo = func.mostrar2(buscar);

            tablalistado.setModel(modelo);
            //ocultar_columnas();
            lbltotalregistros.setText("" + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    
    void regresarMenuAnterior() {
        frmContratoRep frm =  new frmContratoRep();
        frm.lblCodigo.setText(lblCodigo.getText());
        frm.lblTipoUser.setText(lblTipoUser.getText());
        frm.lblNombre.setText(lblNombre.getText());
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
        btnEliminarSolicitud.setEnabled(false);
        btnGuardarSolicitud.setEnabled(false);
        btnEditarSolicitud.setEnabled(false);
        btnBuscarCliente.setEnabled(false);
        btnNuevoCliente.setEnabled(false);
        //btnGenerarComprobante.setEnabled(false);
        btnEnviarCorreoElectronico.setEnabled(false);
        btnImprimirSolicitud.setEnabled(false);
        btnCalcularTotal.setEnabled(false);
        
        //inahabilitar cajas de texto
        txtCod_Solicitud.setEnabled(false);
        txtNum_Solicitud.setEnabled(false);
        txtFecha.setEditable(false);
        txtCod_cliente.setEnabled(false);
        txtCI.setEnabled(false);
        txtnombresApellidos.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtMarcaEquipo.setEnabled(false);
        txtModeloEquipo.setEnabled(false);
        txtIMEI_Equipo.setEnabled(false);
        txtClave_Usuario.setEnabled(false);
        txtMotivoIngreso.setEnabled(false);
        txtEmail.setEnabled(false);
        txtDiasaproximado.setEnabled(false);
        txtCosto_rep_estimado.setEnabled(false);
        txtAbono.setEnabled(false);
        txtSaldo.setEnabled(false);
        txtTotal.setEnabled(false);
        txtCambio.setEnabled(false);
        
        //checkbox
        checkNoaudio.setEnabled(false);
        checkNocarga.setEnabled(false);
        checkNodigita.setEnabled(false);
        checkNoenciende.setEnabled(false);
        checkNoimagen.setEnabled(false);
        checkNoleechip.setEnabled(false);
        checkNomicrofono.setEnabled(false);
        checkNosenial.setEnabled(false);
        checkNotimbra.setEnabled(false);
        
        //combobox
        cboEstadoSolicitud.setEnabled(false);
        
        limpiarControles();
    }
    
    void limpiarControles() {
        txtNum_Solicitud.setText("");
        txtCod_cliente.setText("");
        txtCI.setText("");
        txtnombresApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtMarcaEquipo.setText("");
        txtModeloEquipo.setText("");
        txtIMEI_Equipo.setText("");
        txtClave_Usuario.setText("");
        txtMotivoIngreso.setText("");
        txtEmail.setText("");
        txtDiasaproximado.setText("");
        txtCosto_rep_estimado.setText("");
        txtAbono.setText("0");
        txtSaldo.setText("0");
        txtTotal.setText("0");
        txtCambio.setText("0");
        
        
        //limpiar checks
        checkNoaudio.setSelected(false);
        checkNocarga.setSelected(false);
        checkNodigita.setSelected(false);
        checkNoenciende.setSelected(false);
        checkNoimagen.setSelected(false);
        checkNoleechip.setSelected(false);
        checkNomicrofono.setSelected(false);
        checkNosenial.setSelected(false);
        checkNotimbra.setSelected(false);
        
        //limpiar cbos
        cboEstadoSolicitud.setSelectedIndex(0);
    }
    
    void noEditable() {
        txtCod_cliente.setEditable(false);
        txtCI.setEditable(false);
        txtDireccion.setEditable(false);
        txtnombresApellidos.setEditable(false);
        txtTelefono.setEditable(false);
        txtEmail.setEditable(false);
    }
    
    void habilitar() {
        //inhabilitar botones 
        //btnReiniciar.setEnabled(true);
        //btnEliminarSolicitud.setEnabled(true);
        //btnGuardarSolicitud.setEnabled(true);
        //btnEditarSolicitud.setEnabled(true);
        btnBuscarCliente.setEnabled(true);
        btnNuevoCliente.setEnabled(true);
        //btnGenerarComprobante.setEnabled(true);
        //btnImprimirSolicitud.setEnabled(true);
        btnCalcularTotal.setEnabled(true);
        
        //inahabilitar cajas de texto
        txtCod_Solicitud.setEnabled(false);
        txtNum_Solicitud.setEnabled(true);
        txtFecha.setEditable(false);
        txtCod_cliente.setEnabled(true);
        txtCI.setEnabled(true);
        txtnombresApellidos.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtMarcaEquipo.setEnabled(true);
        txtModeloEquipo.setEnabled(true);
        txtIMEI_Equipo.setEnabled(true);
        txtClave_Usuario.setEnabled(true);
        txtMotivoIngreso.setEnabled(true);
        txtEmail.setEnabled(true);
        txtCosto_rep_estimado.setEnabled(true);
        txtDiasaproximado.setEnabled(true);
        txtAbono.setEnabled(true);
        //txtSaldo.setEnabled(true);
        
        //checkbox
        checkNoaudio.setEnabled(true);
        checkNocarga.setEnabled(true);
        checkNodigita.setEnabled(true);
        checkNoenciende.setEnabled(true);
        checkNoimagen.setEnabled(true);
        checkNoleechip.setEnabled(true);
        checkNomicrofono.setEnabled(true);
        checkNosenial.setEnabled(true);
        checkNotimbra.setEnabled(true);
        
        //combobox
        cboEstadoSolicitud.setEnabled(true);
        
        limpiarControles();
    }
    
    void comprobarComprobante() {
        int pos = cboEstadoSolicitud.getSelectedIndex();
            
        if(pos == 1) {
            JOptionPane.showMessageDialog(null, "Generando Comprobante");
            //btnGenerarComprobante.setEnabled(true);
        }
        else {
            //btnGenerarComprobante.setEnabled(false);
            JOptionPane.showMessageDialog(null, "No se puede generar porque tiene que revisar el equipo para generar el comprobante de revisión\n"
                    + "Una vez revisado el equipo, cambie el estado de solicitud del presente formulario y guarde,\n"
                    + "a continuación genere el comprobante de reparacion");
        }
    }
    
    boolean comprobarDatosDelCliente() {
        boolean es = false;
        
        es = txtCod_cliente.getText().length() == 0; //JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los nombres del cliente");
        es = txtCI.getText().length() == 0; //JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los nombres del cliente");
        es = txtnombresApellidos.getText().length() == 0; //JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los nombres del cliente");
        es = txtDireccion.getText().length() == 0; //JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los nombres del cliente");
        es = txtTelefono.getText().length() == 0; //JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los nombres del cliente");
     
        return es;
        
    }
    
    boolean comprobarMotivoDeIngreso() {
        if((txtMotivoIngreso.getText().length() == 0) && !checkNoaudio.isSelected()
                && !checkNocarga.isSelected() && !checkNodigita.isSelected() && !checkNoenciende.isSelected()
                && !checkNoimagen.isSelected() && !checkNoleechip.isSelected() && !checkNomicrofono.isSelected()
                && !checkNosenial.isSelected() && !checkNotimbra.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
    
    void calacularTotal() {
        limpiarCalculo();
        
        try {
            double costo = Double.parseDouble(txtCosto_rep_estimado.getText());
            double abono = Double.parseDouble(txtAbono.getText());
            double total = costo;

            double saldo = costo - abono;

            if (saldo < 0) {
                //JOptionPane.showMessageDialog(null, "El Abono no puede ser mayor que el costo de reparacion");
                double cambio = Math.abs(saldo);
                txtCambio.setText(formatter.format((Number) cambio).replace(',', '.'));
                txtTotal.setText(formatter.format((Number) total).replace(',', '.'));
            } else {
                txtTotal.setText(formatter.format((Number) total).replace(',', '.'));
                txtSaldo.setText(formatter.format((Number) saldo).replace(',', '.'));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar valores en el costo y abono");
            txtCosto_rep_estimado.requestFocus();
        }

        
    }
    
    void limpiarCalculo() {
        txtCambio.setText("0");
        txtSaldo.setText("0");
    }
    
    void imprimirReporte() {
        try {
            JOptionPane.showMessageDialog(null, "Imprimiendo solicitud de reparacion");
            int cod_solicitud = Integer.parseInt(txtCod_Solicitud.getText());
            String cad="solicitud";
            //agregar parametros al reporte
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("codigoDeSolicitud", cod_solicitud);
            params.put("solicitud", cad);
            Global.generarReporte("reportSolicitud",params);
            inhabilitar();
        } catch (HeadlessException | FileNotFoundException | NumberFormatException | JRException ex) { 
            JOptionPane.showMessageDialog(null, "No se pudo imprimir la solicitud de reparacion");
            inhabilitar();
        }
    }
    
    void imprimirReporteEmail() {
        try {
            JOptionPane.showMessageDialog(null, "Imprimiendo solicitud de reparacion");
            int cod_solicitud = Integer.parseInt(txtCod_Solicitud.getText());
            String cad="solicitud";
            //agregar parametros al reporte
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("codigoDeSolicitud", cod_solicitud);
            params.put("solicitud", cad);
            Global.generarReporte("reportSolicitud",params);
            //inhabilitar();
        } catch (HeadlessException | FileNotFoundException | NumberFormatException | JRException ex) { 
            JOptionPane.showMessageDialog(null, "No se pudo imprimir la solicitud de reparacion");
            //inhabilitar();
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
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCod_Solicitud = new javax.swing.JTextField();
        txtNum_Solicitud = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();
        btnBuscarSolicitud = new javax.swing.JButton();
        btnEliminarSolicitud = new javax.swing.JButton();
        btnNuevaSolicitud = new javax.swing.JButton();
        btnEditarSolicitud = new javax.swing.JButton();
        btnGuardarSolicitud = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCodigoUser = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtMarcaEquipo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtIMEI_Equipo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtModeloEquipo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtClave_Usuario = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        checkNoenciende = new javax.swing.JCheckBox();
        checkNocarga = new javax.swing.JCheckBox();
        checkNoimagen = new javax.swing.JCheckBox();
        checkNosenial = new javax.swing.JCheckBox();
        checkNodigita = new javax.swing.JCheckBox();
        checkNoleechip = new javax.swing.JCheckBox();
        checkNotimbra = new javax.swing.JCheckBox();
        checkNomicrofono = new javax.swing.JCheckBox();
        checkNoaudio = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivoIngreso = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        cboEstadoSolicitud = new javax.swing.JComboBox<>();
        btnImprimirSolicitud = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnEnviarCorreoElectronico = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        txtCosto_rep_estimado = new javax.swing.JTextField();
        txtAbono = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtDiasaproximado = new javax.swing.JTextField();
        btnCalcularTotal = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();

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
        jLabel1.setText("  Solicitud de reparación de equipos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 470, 20));

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
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 96, 86, -1));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel5.setText("Dirección:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 123, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel6.setText("Email:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 40, -1));

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
        jPanel2.add(txtnombresApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 390, -1));

        txtDireccion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtDireccion.setText("N/D");
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 123, 390, -1));

        txtTelefono.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtTelefono.setText("99999999999999");
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 150, 390, -1));

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

        jLabel21.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel21.setText("Teléfono:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 150, 57, -1));

        txtEmail.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtEmail.setText("example@example.com");
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 390, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 510, 210));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel7.setText("Código Solicitud:");

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel8.setText("Número de Solicitud:");

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel9.setText("Fecha de Solicitud:");

        txtCod_Solicitud.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        txtNum_Solicitud.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtNum_Solicitud.setToolTipText("Ingrese numero de Solicitud");
        txtNum_Solicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNum_SolicitudActionPerformed(evt);
            }
        });
        txtNum_Solicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNum_SolicitudKeyTyped(evt);
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
                    .addComponent(txtCod_Solicitud, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(txtNum_Solicitud)
                    .addComponent(txtFecha))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCod_Solicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNum_Solicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 260, 100));

        btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Reset_32px.png"))); // NOI18N
        btnReiniciar.setToolTipText("Reiniciar");
        btnReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 40, 40));

        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Search_32px.png"))); // NOI18N
        btnBuscarSolicitud.setToolTipText("Buscar Solicitud de reparación");
        btnBuscarSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 40, 40));

        btnEliminarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Delete_32px.png"))); // NOI18N
        btnEliminarSolicitud.setToolTipText("Eliminar Solicitud de reparación");
        btnEliminarSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 40, 40));

        btnNuevaSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_New_Copy_32px.png"))); // NOI18N
        btnNuevaSolicitud.setToolTipText("Nueva Solicitud de reparación");
        btnNuevaSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevaSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 40, 40));

        btnEditarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Edit_File_32px.png"))); // NOI18N
        btnEditarSolicitud.setToolTipText("Editar y guardar cambios en la solicitud de reparación ");
        btnEditarSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 40, 40));

        btnGuardarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Solicitud de Reparacion/icons8_Save_32px.png"))); // NOI18N
        btnGuardarSolicitud.setToolTipText("Guardar Solitud de Reparación");
        btnGuardarSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 40, 40));

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
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Equipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 11))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMarcaEquipo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtMarcaEquipo.setToolTipText("Ingrese la marca del equipo");
        txtMarcaEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaEquipoActionPerformed(evt);
            }
        });
        jPanel4.add(txtMarcaEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel12.setText("IMEI o Serie:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        txtIMEI_Equipo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtIMEI_Equipo.setToolTipText("Ingrese el IMEI y Serie del equipo");
        txtIMEI_Equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIMEI_EquipoActionPerformed(evt);
            }
        });
        jPanel4.add(txtIMEI_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 410, -1));

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel13.setText("Marca:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel14.setText("Modelo:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        txtModeloEquipo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtModeloEquipo.setToolTipText("Ingrese el modelo del equipo");
        txtModeloEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloEquipoActionPerformed(evt);
            }
        });
        jPanel4.add(txtModeloEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 200, -1));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel15.setText("Clave:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, -1));

        txtClave_Usuario.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtClave_Usuario.setToolTipText("Clave de usuario del equipo");
        txtClave_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave_UsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(txtClave_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 410, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 510, 130));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Motivo de ingreso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 11))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkNoenciende.setBackground(new java.awt.Color(255, 255, 255));
        checkNoenciende.setText("No enciende");
        checkNoenciende.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNoenciende, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        checkNocarga.setBackground(new java.awt.Color(255, 255, 255));
        checkNocarga.setText("No carga");
        checkNocarga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNocarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        checkNoimagen.setBackground(new java.awt.Color(255, 255, 255));
        checkNoimagen.setText("No imagen");
        checkNoimagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNoimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, 20));

        checkNosenial.setBackground(new java.awt.Color(255, 255, 255));
        checkNosenial.setText("No señal");
        checkNosenial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNosenial, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        checkNodigita.setBackground(new java.awt.Color(255, 255, 255));
        checkNodigita.setText("No digita");
        checkNodigita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNodigita, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        checkNoleechip.setBackground(new java.awt.Color(255, 255, 255));
        checkNoleechip.setText("No lee Chip");
        checkNoleechip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNoleechip, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        checkNotimbra.setBackground(new java.awt.Color(255, 255, 255));
        checkNotimbra.setText("No timbra");
        checkNotimbra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNotimbra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        checkNomicrofono.setBackground(new java.awt.Color(255, 255, 255));
        checkNomicrofono.setText("No micrófono");
        checkNomicrofono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNomicrofono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        checkNoaudio.setBackground(new java.awt.Color(255, 255, 255));
        checkNoaudio.setText("No audio");
        checkNoaudio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(checkNoaudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        txtMotivoIngreso.setColumns(20);
        txtMotivoIngreso.setFont(new java.awt.Font("Tempus Sans ITC", 0, 13)); // NOI18N
        txtMotivoIngreso.setRows(5);
        txtMotivoIngreso.setToolTipText("Motivo de Ingreso");
        jScrollPane1.setViewportView(txtMotivoIngreso);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 77, 478, 36));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 510, 120));

        jLabel16.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel16.setText("Cambio;");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 660, 50, 20));

        cboEstadoSolicitud.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cboEstadoSolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En espera", "En proceso de revisión", "Completada la revisión - Equipo no entregado", "Completada la revisión - Equipo  entregado" }));
        cboEstadoSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboEstadoSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboEstadoSolicitudMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboEstadoSolicitudMouseReleased(evt);
            }
        });
        jPanel1.add(cboEstadoSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 240, -1));

        btnImprimirSolicitud.setText("Imprimir");
        btnImprimirSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimirSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimirSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 180, -1));

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
        jScrollPane2.setViewportView(tablalistado);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 11, 13));

        lbltotalregistros.setText("jLabel17");
        jPanel1.add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel17.setText("Días estimados de reparación");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, 20));

        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel18.setText("Costo estimado:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, -1, 20));

        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel19.setText("Abono:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 640, 50, 20));

        jLabel20.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel20.setText("Saldo:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 640, 40, 20));

        btnEnviarCorreoElectronico.setText("Enviar por correo electrónico");
        btnEnviarCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoElectronicoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviarCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 190, -1));

        txtTotal.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 680, 70, -1));

        txtCosto_rep_estimado.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtCosto_rep_estimado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCosto_rep_estimadoActionPerformed(evt);
            }
        });
        txtCosto_rep_estimado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCosto_rep_estimadoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCosto_rep_estimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 70, -1));

        txtAbono.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtAbono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAbonoMouseClicked(evt);
            }
        });
        txtAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAbonoActionPerformed(evt);
            }
        });
        txtAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtAbono, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, 70, -1));

        txtSaldo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });
        jPanel1.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 640, 70, -1));

        jLabel22.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel22.setText("Estado de solicitud");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, -1, 20));

        txtDiasaproximado.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txtDiasaproximado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiasaproximadoActionPerformed(evt);
            }
        });
        txtDiasaproximado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasaproximadoKeyTyped(evt);
            }
        });
        jPanel1.add(txtDiasaproximado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 80, -1));

        btnCalcularTotal.setText("Calcular Total");
        btnCalcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTotalActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalcularTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 703, 100, 20));

        jLabel23.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jLabel23.setText("Total:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 680, 40, 20));

        txtCambio.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jPanel1.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
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

    private void txtMarcaEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaEquipoActionPerformed
        // TODO add your handling code here:
        txtMarcaEquipo.transferFocus();
    }//GEN-LAST:event_txtMarcaEquipoActionPerformed

    private void txtModeloEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloEquipoActionPerformed
        // TODO add your handling code here:
        txtModeloEquipo.transferFocus();
    }//GEN-LAST:event_txtModeloEquipoActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        limpiarControles();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnNuevaSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaSolicitudActionPerformed
        // TODO add your handling code here:
        btnReiniciar.setEnabled(true);
        btnEliminarSolicitud.setEnabled(false);
        btnGuardarSolicitud.setEnabled(true);
        btnEditarSolicitud.setEnabled(false);
        establecerEmpleadoActual();
        establecerfechaActual();
        habilitar();
        txtNum_Solicitud.requestFocus();
        //System.out.println(cboEstadoSolicitud.getSelectedItem().toString());
    }//GEN-LAST:event_btnNuevaSolicitudActionPerformed

    private void btnBuscarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSolicitudActionPerformed
        // TODO add your handling code here:
        habilitar();
        digVistaSol_reparacion dg = new digVistaSol_reparacion(null, false);
        dg.setModal(true);
        dg.setVisible(true);
        //dg.toFront();
        btnReiniciar.setEnabled(false);
        btnEliminarSolicitud.setEnabled(true);
        btnGuardarSolicitud.setEnabled(false);
        btnEditarSolicitud.setEnabled(true);
        
        //System.out.println(Date.valueOf(txtFecha.getText()));
    }//GEN-LAST:event_btnBuscarSolicitudActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        digVistaClientes dig = new digVistaClientes(null, false);
        dig.setModal(true);
        dig.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void cboEstadoSolicitudMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboEstadoSolicitudMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cboEstadoSolicitudMousePressed

    private void cboEstadoSolicitudMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboEstadoSolicitudMouseReleased
        // TODO add your handling code here:
        /**
        if (evt.getClickCount() == 1) {
            int pos = cboEstadoSolicitud.getSelectedIndex();
            
            if(pos == 1) btnGenerarComprobante.setEnabled(true);
            else btnGenerarComprobante.setEnabled(false);
        }
        * **/
    }//GEN-LAST:event_cboEstadoSolicitudMouseReleased

    private void txtNum_SolicitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNum_SolicitudKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();   
        //no permite ingreso de caracter que no sea un numero
	if(!(c+"").matches("[0-9]")) evt.consume();
    }//GEN-LAST:event_txtNum_SolicitudKeyTyped

    private void btnGuardarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSolicitudActionPerformed
        // TODO add your handling code here:
        
        if(txtNum_Solicitud.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el número de solicitud");
            txtNum_Solicitud.requestFocus();
            return;
        }
        
        if(comprobarDatosDelCliente()) {
            JOptionPane.showConfirmDialog(rootPane, "Debes seleccionar un cliente");
            btnBuscarCliente.requestFocus();
            return;
        }
        
        if(txtMarcaEquipo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los datos del equipo\nDebes ingresar la marca");
            txtMarcaEquipo.requestFocus();
            return;
        }
        
        if(txtModeloEquipo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los datos del equipo\nDebes ingresar el modelo");
            txtModeloEquipo.requestFocus();
            return;
        }
        
        if(txtIMEI_Equipo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los datos del equipo\nDebes ingresar el IMEI o serie del equipo");
            txtIMEI_Equipo.requestFocus();
            return;
        }
        
        if((txtClave_Usuario.getText().length() == 0)) {
            //JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la cedula o RUC");
            txtClave_Usuario.setText("N/D");
            return;
        }
        
        if((comprobarMotivoDeIngreso())) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el motivo de ingreso del equipo");
            checkNoenciende.requestFocus();
            return;
        }
        
        
        if(txtDiasaproximado.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el número de días que debe estar disponible la reparación del equipo");
            txtDiasaproximado.requestFocus();
            return;
        }
        
        if(txtCosto_rep_estimado.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el costo de reparación del equipo");
            txtCosto_rep_estimado.requestFocus();
            return;
        }
        
        /**
        if(txtAbono.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los datos del equipo\nDebes ingresar el IMEI o serie del equipo");
            txtIMEI_Equipo.requestFocus();
            return;
        }
        * **/
        
        
        
        
        
        //almacenamiento de los datos
        //se crea una nueva solicitud
        solicitud_reparacion s = new solicitud_reparacion();
        //conexion con la base de datos
        BD_solicitud_reparacion bd = new BD_solicitud_reparacion();
        
        //llenado de datos
        s.setNumero_solicitud(txtNum_Solicitud.getText());
        s.setCod_cliente(Integer.parseInt(txtCod_cliente.getText()));
        s.setCod_empleado(Integer.parseInt(lblCodigoUser.getText()));
        s.setMarca_equipo_sol(txtMarcaEquipo.getText());
        s.setFecha_solicitud(Date.valueOf(txtFecha.getText()));
        s.setModelo_equipo_sol(txtModeloEquipo.getText());
        s.setImei_serie_sol(txtIMEI_Equipo.getText());
        s.setClave_usuario_sol(txtClave_Usuario.getText());
        s.setEstado_solicitud(cboEstadoSolicitud.getSelectedItem().toString());
        String motivoIngreso = "Motivo de ingreso:";
        if(checkNoaudio.isSelected()) motivoIngreso += " - " + checkNoaudio.getText();
        if(checkNocarga.isSelected()) motivoIngreso += " -  " + checkNocarga.getText();
        //System.out.println(motivoIngreso);
        if(checkNodigita.isSelected()) motivoIngreso += " - " + checkNodigita.getText();
        if(checkNoenciende.isSelected()) motivoIngreso += " - " + checkNoenciende.getText();
        if(checkNoimagen.isSelected()) motivoIngreso += " - " + checkNoimagen.getText();
        if(checkNoleechip.isSelected()) motivoIngreso += " - " + checkNoleechip.getText();
        if(checkNomicrofono.isSelected()) motivoIngreso += " - " + checkNomicrofono.getText();
        if(checkNosenial.isSelected()) motivoIngreso += " - " + checkNosenial.getText();
        if(checkNotimbra.isSelected()) motivoIngreso += " - " + checkNotimbra.getText();
        motivoIngreso += " - \n" + txtMotivoIngreso.getText();
        System.out.println(motivoIngreso);
        s.setMotivo_ingreso_sol(motivoIngreso);
        s.setDias_estimados_rep(Integer.parseInt(txtDiasaproximado.getText()));
        s.setMotivo_rep_sol("En proceso de revisión por parte del personal");
        s.setCosto_rep_est(Double.parseDouble(txtCosto_rep_estimado.getText()));
        s.setAbono_sol(Double.parseDouble(txtAbono.getText()));
        s.setSaldo_sol(Double.parseDouble(txtSaldo.getText()));
        s.setTotal_sol(Double.parseDouble(txtTotal.getText()));
        //guardado en la base de datos
        if (bd.insertar(s)) {
            JOptionPane.showMessageDialog(rootPane, "la solicitud de reparacion fue registrada satisfactoriamente");
            mostrar(s.getNumero_solicitud());
            System.out.println(s.getNumero_solicitud());
            int codigo = Integer.parseInt(tablalistado.getValueAt(0, 0).toString());
            System.out.println(codigo);
            int op = JOptionPane.showConfirmDialog(null, "Desea imprimir la solicitud de reparacion y enviar por correo Electronico", "Imprimir solicitud de reparacion y enviar por correo", 2);
            
            if(op == 0) {
                txtCod_Solicitud.setText(String.valueOf(codigo));
                btnImprimirSolicitud.setEnabled(true);
                btnEnviarCorreoElectronico.setEnabled(true);
                //JOptionPane.showMessageDialog(null, "Imprimiendo solicitud de reparacion");
            } else {
                inhabilitar();
            }
            //mostrar("");
            //inhabilitar();
        }
        
        
        
    }//GEN-LAST:event_btnGuardarSolicitudActionPerformed

    private void btnEditarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSolicitudActionPerformed
        // TODO add your handling code here:
        if(txtNum_Solicitud.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el número de solicitud");
            txtNum_Solicitud.requestFocus();
            return;
        }
        
        if(comprobarDatosDelCliente()) {
            JOptionPane.showConfirmDialog(rootPane, "Debes seleccionar un cliente");
            btnBuscarCliente.requestFocus();
            return;
        }
        
        if(txtMarcaEquipo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los datos del equipo\nDebes ingresar la marca");
            txtMarcaEquipo.requestFocus();
            return;
        }
        
        if(txtModeloEquipo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los datos del equipo\nDebes ingresar el modelo");
            txtModeloEquipo.requestFocus();
            return;
        }
        
        if(txtIMEI_Equipo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los datos del equipo\nDebes ingresar el IMEI o serie del equipo");
            txtIMEI_Equipo.requestFocus();
            return;
        }
        
        if((txtClave_Usuario.getText().length() == 0)) {
            //JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la cedula o RUC");
            txtClave_Usuario.setText("N/D");
            return;
        }
        
        if((comprobarMotivoDeIngreso())) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el motivo de ingreso del equipo");
            checkNoenciende.requestFocus();
            return;
        }
        
        if(txtDiasaproximado.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el número de días que debe estar disponible la reparación del equipo");
            txtDiasaproximado.requestFocus();
            return;
        }
        
        if(txtCosto_rep_estimado.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el costo de reparación del equipo");
            txtCosto_rep_estimado.requestFocus();
            return;
        }
        
        //almacenamiento de los datos
        //se crea una nueva solicitud
        solicitud_reparacion s = new solicitud_reparacion();
        //conexion con la base de datos
        BD_solicitud_reparacion bd = new BD_solicitud_reparacion();
        
        //llenado de datos
        s.setNumero_solicitud(txtNum_Solicitud.getText());
        s.setCod_cliente(Integer.parseInt(txtCod_cliente.getText()));
        s.setCod_empleado(Integer.parseInt(lblCodigoUser.getText()));
        s.setMarca_equipo_sol(txtMarcaEquipo.getText());
        s.setFecha_solicitud(Date.valueOf(txtFecha.getText()));
        s.setModelo_equipo_sol(txtModeloEquipo.getText());
        s.setImei_serie_sol(txtIMEI_Equipo.getText());
        s.setClave_usuario_sol(txtClave_Usuario.getText());
        s.setEstado_solicitud(cboEstadoSolicitud.getSelectedItem().toString());
        String motivoIngreso = "";
        if(checkNoaudio.isSelected()) motivoIngreso += " - " + checkNoaudio.getText();
        if(checkNocarga.isSelected()) motivoIngreso += " -  " + checkNocarga.getText();
        //System.out.println(motivoIngreso);
        if(checkNodigita.isSelected()) motivoIngreso += " - " + checkNodigita.getText();
        if(checkNoenciende.isSelected()) motivoIngreso += " - " + checkNoenciende.getText();
        if(checkNoimagen.isSelected()) motivoIngreso += " - " + checkNoimagen.getText();
        if(checkNoleechip.isSelected()) motivoIngreso += " - " + checkNoleechip.getText();
        if(checkNomicrofono.isSelected()) motivoIngreso += " - " + checkNomicrofono.getText();
        if(checkNosenial.isSelected()) motivoIngreso += " - " + checkNosenial.getText();
        if(checkNotimbra.isSelected()) motivoIngreso += " - " + checkNotimbra.getText();
        motivoIngreso += " - \n" + txtMotivoIngreso.getText();
        System.out.println(motivoIngreso);
        s.setMotivo_ingreso_sol(motivoIngreso);
        s.setCod_solicitud(Integer.parseInt(txtCod_Solicitud.getText()));
        s.setDias_estimados_rep(Integer.parseInt(txtDiasaproximado.getText()));
        s.setMotivo_rep_sol("En proceso de revisión por parte del personal");
        s.setCosto_rep_est(Double.parseDouble(txtCosto_rep_estimado.getText()));
        s.setAbono_sol(Double.parseDouble(txtAbono.getText()));
        s.setSaldo_sol(Double.parseDouble(txtSaldo.getText()));
        s.setTotal_sol(Double.parseDouble(txtTotal.getText()));
        
        if(bd.editar(s)) {
                JOptionPane.showMessageDialog(rootPane, "la solicitud de reparacion fue editada satisfactoriamente");
                //mostrar("");
                inhabilitar();
                establecerfechaActual();
                establecerEmpleadoActual();
            }
    }//GEN-LAST:event_btnEditarSolicitudActionPerformed

    private void btnEliminarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSolicitudActionPerformed
        // TODO add your handling code here:
        if(!txtCod_Solicitud.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de Eliminar la solicitud de reparacion?", "Confirmar", 2);
            if(confirmacion == 0) {
                BD_solicitud_reparacion func = new BD_solicitud_reparacion();
                solicitud_reparacion dts = new solicitud_reparacion();

                dts.setCod_solicitud(Integer.parseInt(txtCod_Solicitud.getText()));
                func.eliminar(dts);
                //mostrar("");
                inhabilitar();
                establecerEmpleadoActual();
                establecerfechaActual();
                txtCod_Solicitud.setText("");
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            }
        }
    }//GEN-LAST:event_btnEliminarSolicitudActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        // TODO add your handling code here:
        digClientes dg = new digClientes(null, false);
        dg.setModal(true);
        dg.setVisible(true);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnImprimirSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirSolicitudActionPerformed
        // TODO add your handling code here:
        imprimirReporte();
        /**
        try {
            JOptionPane.showMessageDialog(null, "Imprimiendo solicitud de reparacion");
            int cod_solicitud = Integer.parseInt(txtCod_Solicitud.getText());
            String cad="solicitud";
            //agregar parametros al reporte
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("codigoDeSolicitud", cod_solicitud);
            params.put("solicitud", cad);
            Global.generarReporte("reportSolicitud",params);
            inhabilitar();
        } catch (HeadlessException | FileNotFoundException | NumberFormatException | JRException ex) { 
            JOptionPane.showMessageDialog(null, "No se pudo imprimir la solicitud de reparacion");
            inhabilitar();
        }**/
    }//GEN-LAST:event_btnImprimirSolicitudActionPerformed

    private void txtCosto_rep_estimadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCosto_rep_estimadoActionPerformed
        // TODO add your handling code here:
        txtAbono.requestFocus();
    }//GEN-LAST:event_txtCosto_rep_estimadoActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void txtCosto_rep_estimadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCosto_rep_estimadoKeyTyped
        // TODO add your handling code here:
        Validar.NumerosDecimales(evt, txtCosto_rep_estimado);
        txtTotal.setText(txtCosto_rep_estimado.getText());
        //calacularTotal();
    }//GEN-LAST:event_txtCosto_rep_estimadoKeyTyped

    private void txtAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyTyped
        // TODO add your handling code here:
        Validar.NumerosDecimales(evt, txtAbono);
    }//GEN-LAST:event_txtAbonoKeyTyped

    private void btnEnviarCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoElectronicoActionPerformed
        // TODO add your handling code here:
        if(txtEmail.getText().equals("N/D")) {
            JOptionPane.showMessageDialog(null, "El cliente seleccionado no tiene correo electrónico por lo tanto no se puede enviar email");
        } else {
            //txtEmail.setEnabled(true);
            //txtEmail.setEditable(true);
            //JOptionPane.showMessageDialog(null, txtEmail.getText());
            JOptionPane.showMessageDialog(null, "Generando reporte para enviar...");
            imprimirReporteEmail();
            
            String email = txtEmail.getText();
            String asunto = "Contrato de reparación de celulares y computadoras - CELLCOMP S.A.";
            String mensaje = "Tenga un cordial saludo estimado cliente, el motivo de este mensaje es de hacerle " + "\n"
                    + "notificar el presente contrato en un archivo pdf ajunto.\n\nAtentamente\n\nPeter Junior Montesdeoca S.";
            String nombreArchivo = "reportSolicitud.pdf";
            String rutaArchivo = Global.getPathReport() + "reportSolicitud.pdf";
            digEnvioCorreo dig = new digEnvioCorreo(null, false);
            digEnvioCorreo.nombreArchivo = nombreArchivo;
            digEnvioCorreo.rutaArchivo = rutaArchivo;
            digEnvioCorreo.destinatario = email;
            digEnvioCorreo.txtAsusnto.setText(asunto);
            digEnvioCorreo.txtDestinatario.setText(email);
            digEnvioCorreo.txtMensaje.setText(mensaje);
            dig.setModal(true);
            dig.setVisible(true);
        }
        
    }//GEN-LAST:event_btnEnviarCorreoElectronicoActionPerformed

    private void txtDiasaproximadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasaproximadoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();   
        //no permite ingreso de caracter que no sea un numero
	if(!(c+"").matches("[0-9]")) evt.consume();
    }//GEN-LAST:event_txtDiasaproximadoKeyTyped

    private void txtNum_SolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNum_SolicitudActionPerformed
        // TODO add your handling code here:
        //btnBuscarCliente;
        btnNuevoCliente.transferFocusBackward();
    }//GEN-LAST:event_txtNum_SolicitudActionPerformed

    private void btnCalcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTotalActionPerformed
        // TODO add your handling code here:
        calacularTotal();
    }//GEN-LAST:event_btnCalcularTotalActionPerformed

    private void txtAbonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAbonoMouseClicked
        // TODO add your handling code here:
        if(txtAbono.getText().equals("0")) txtAbono.setText("");
    }//GEN-LAST:event_txtAbonoMouseClicked

    private void txtIMEI_EquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIMEI_EquipoActionPerformed
        // TODO add your handling code here:
        txtIMEI_Equipo.transferFocus();
    }//GEN-LAST:event_txtIMEI_EquipoActionPerformed

    private void txtClave_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave_UsuarioActionPerformed
        // TODO add your handling code here:
        txtClave_Usuario.transferFocus();
    }//GEN-LAST:event_txtClave_UsuarioActionPerformed

    private void txtDiasaproximadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiasaproximadoActionPerformed
        // TODO add your handling code here:
        txtCosto_rep_estimado.requestFocus();
    }//GEN-LAST:event_txtDiasaproximadoActionPerformed

    private void txtAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAbonoActionPerformed
        // TODO add your handling code here:
        btnCalcularTotal.requestFocus();
    }//GEN-LAST:event_txtAbonoActionPerformed

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
            java.util.logging.Logger.getLogger(frmSolicitudReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSolicitudReparacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarSolicitud;
    private javax.swing.JButton btnCalcularTotal;
    private javax.swing.JButton btnEditarSolicitud;
    private javax.swing.JButton btnEliminarSolicitud;
    public static javax.swing.JButton btnEnviarCorreoElectronico;
    private javax.swing.JButton btnGuardarSolicitud;
    public static javax.swing.JButton btnImprimirSolicitud;
    private javax.swing.JButton btnNuevaSolicitud;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnReiniciar;
    public static javax.swing.JComboBox<String> cboEstadoSolicitud;
    private javax.swing.JCheckBox checkNoaudio;
    private javax.swing.JCheckBox checkNocarga;
    private javax.swing.JCheckBox checkNodigita;
    private javax.swing.JCheckBox checkNoenciende;
    private javax.swing.JCheckBox checkNoimagen;
    private javax.swing.JCheckBox checkNoleechip;
    private javax.swing.JCheckBox checkNomicrofono;
    private javax.swing.JCheckBox checkNosenial;
    private javax.swing.JCheckBox checkNotimbra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTable tablalistado;
    public static javax.swing.JTextField txtAbono;
    public static javax.swing.JTextField txtCI;
    private javax.swing.JTextField txtCambio;
    public static javax.swing.JTextField txtClave_Usuario;
    public static javax.swing.JTextField txtCod_Solicitud;
    public static javax.swing.JTextField txtCod_cliente;
    public static javax.swing.JTextField txtCosto_rep_estimado;
    public static javax.swing.JTextField txtDiasaproximado;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtIMEI_Equipo;
    public static javax.swing.JTextField txtMarcaEquipo;
    public static javax.swing.JTextField txtModeloEquipo;
    public static javax.swing.JTextArea txtMotivoIngreso;
    public static javax.swing.JTextField txtNum_Solicitud;
    public static javax.swing.JTextField txtSaldo;
    public static javax.swing.JTextField txtTelefono;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtnombresApellidos;
    // End of variables declaration//GEN-END:variables
}
