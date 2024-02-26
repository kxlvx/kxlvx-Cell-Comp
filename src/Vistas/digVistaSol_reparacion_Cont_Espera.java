/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.BD_cliente;
import Controlador.BD_solicitud_reparacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samuel isaias Calderon Aguirre
 */
public class digVistaSol_reparacion_Cont_Espera extends javax.swing.JDialog {

    /**
     * Creates new form digVistaClientes
     */
    public digVistaSol_reparacion_Cont_Espera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Vista Solicitud de Reparación");
        mostrar("");
    }
    
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            BD_solicitud_reparacion func = new BD_solicitud_reparacion();
            modelo = func.mostrarVistaEspera(buscar);

            tablalistado.setModel(modelo);
            //ocultar_columnas();
            //lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
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
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/Imagenes Menu Cliente/icons8_Search_24px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        txtBuscar.setText("Buscar por cédula, RUC, Nombres o Apellidos del cliente");
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
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 1160, -1));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1160, 10));

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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1190, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tablalistadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila= tablalistado.getSelectedRow();
            String codSolicitud;
            String Nro_Solicitud;
            String Fecha_solicitud;
            String cod_cliente;
            String ruc;
            String cliente;
            String dir;
            String telefono;
            String email;
            String marca;
            String Modelo;
            String IMEI;
            String clave;
            String motivo;
            String estado;
            String cod_emp;
            String empleado;
            String motivo_rep;
            String dias_est;
            String costo;
            String abono;
            String saldo;
            String total;
            String diasRestantes;
            String fecha_entrega;
            
            codSolicitud=tablalistado.getValueAt(fila, 0).toString();
            Nro_Solicitud = tablalistado.getValueAt(fila, 1).toString();
            Fecha_solicitud = tablalistado.getValueAt(fila, 2).toString();
            cod_cliente = tablalistado.getValueAt(fila, 3).toString();
            ruc=tablalistado.getValueAt(fila, 4).toString();
            cliente=tablalistado.getValueAt(fila, 5).toString() + " " + tablalistado.getValueAt(fila, 6).toString(); 
            dir=tablalistado.getValueAt(fila, 7).toString();
            telefono=tablalistado.getValueAt(fila, 8).toString();
            email=tablalistado.getValueAt(fila, 9).toString();
            marca = tablalistado.getValueAt(fila, 10).toString();
            Modelo = tablalistado.getValueAt(fila, 11).toString();
            IMEI = tablalistado.getValueAt(fila, 12).toString();
            clave = tablalistado.getValueAt(fila, 13).toString();
            motivo = tablalistado.getValueAt(fila, 14).toString();
            estado = tablalistado.getValueAt(fila, 15).toString();
            cod_emp = tablalistado.getValueAt(fila, 16).toString();
            empleado = tablalistado.getValueAt(fila, 17).toString();
            motivo_rep = tablalistado.getValueAt(fila, 18).toString();
            dias_est = tablalistado.getValueAt(fila, 19).toString();
            costo = tablalistado.getValueAt(fila, 20).toString();
            abono =tablalistado.getValueAt(fila, 21).toString();
            saldo = tablalistado.getValueAt(fila, 22).toString();
            total = tablalistado.getValueAt(fila, 23).toString();
            diasRestantes = tablalistado.getValueAt(fila, 25).toString();
            fecha_entrega = tablalistado.getValueAt(fila, 24).toString();
            
            
            frmControlContratos.txtCod_Solicitud.setText(codSolicitud);
            frmControlContratos.txtNum_Solicitud.setText(Nro_Solicitud);
            frmControlContratos.txtFecha.setText(Fecha_solicitud);
            frmControlContratos.txtCod_cliente.setText(cod_cliente);
            frmControlContratos.txtCI.setText(ruc);
            frmControlContratos.txtnombresApellidos.setText(cliente);
            frmControlContratos.txtDireccion.setText(dir);
            frmControlContratos.txtTelefono.setText(telefono);
            frmControlContratos.txtMarcaEquipo.setText(marca);
            frmControlContratos.txtModeloEquipo.setText(Modelo);
            frmControlContratos.txtIMEI_Equipo.setText(IMEI);
            frmControlContratos.txtClave_Usuario.setText(clave);
            frmControlContratos.txtMotivoIngreso.setText(motivo);
            frmControlContratos.txtMotivoreparacion.setText(motivo_rep);
            if(estado.equals("En espera")) {
                frmControlContratos.cboEstadoSolicitud.setSelectedIndex(0);
            }  
            if(estado.equals("En proceso de revisión")) {
                frmControlContratos.cboEstadoSolicitud.setSelectedIndex(1);
            }
            if(estado.equals("Completada la revisión - Equipo no entregado")) {
                frmControlContratos.cboEstadoSolicitud.setSelectedIndex(2);
            }
            if(estado.equals("Completada la revisión - Equipo  entregado")) {
                frmControlContratos.cboEstadoSolicitud.setSelectedIndex(3);
                frmControlContratos.cboEstadoSolicitud.setEnabled(false);
                frmControlContratos.btnCalcularTotal.setEnabled(false);
                frmControlContratos.btnEditarSolicitud.setEnabled(false);
                //frmControlContratos.btnEnviarCorreoElectronico.
            }
            frmControlContratos.txtEmail.setText(email);
            frmControlContratos.txtDiasaproximado.setText(dias_est);
            frmControlContratos.txtAbono.setText(abono.replace(',', '.'));
            frmControlContratos.txtCosto_rep_estimado.setText(costo.replace(',', '.'));
            frmControlContratos.txtSaldo.setText(saldo.replace(',', '.'));
            frmControlContratos.txtTotal.setText(total.replace(',', '.'));
            frmControlContratos.txtDiasRestantes.setText(diasRestantes + "/90 dias");
            frmControlContratos.txtfechaAproximadaEntrega.setText(fecha_entrega);
            frmControlContratos.lblCodigoUser.setText(cod_emp);
            frmControlContratos.lblUser.setText(empleado);
            frmControlContratos.btnImprimirSolicitud.setEnabled(true);
            frmControlContratos.btnEnviarCorreoElectronico.setEnabled(true);
            
            int dias_restantes_comp = Integer.parseInt(diasRestantes);
            
            if(dias_restantes_comp > 90 && !(estado.equals("Completada la revisión - Equipo  entregado"))) {
                JOptionPane.showMessageDialog(null, "han pasado mas de 90 dias desde que el cliente dejo el equipo");
            }
            //frmreserva.txtidcliente.setText(cod);
            //frmreserva.txtcliente.setText(valor);
            this.dispose();
            
        }
    }//GEN-LAST:event_tablalistadoMousePressed

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
            java.util.logging.Logger.getLogger(digVistaSol_reparacion_Cont_Espera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(digVistaSol_reparacion_Cont_Espera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(digVistaSol_reparacion_Cont_Espera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(digVistaSol_reparacion_Cont_Espera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                digVistaSol_reparacion_Cont_Espera dialog = new digVistaSol_reparacion_Cont_Espera(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}