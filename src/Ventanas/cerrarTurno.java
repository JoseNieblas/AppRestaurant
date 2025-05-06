/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Modelo.konexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JLabel;
import java.sql.SQLException;
import javax.swing.JTextField;

public class cerrarTurno extends javax.swing.JFrame {
    konexion con = new konexion();
    Connection cn = con.konexion();
    PreparedStatement sql;
    ResultSet rs;

    public cerrarTurno() {
        initComponents();
        obtenerTotales();
        insertarTurno();
    }
    
    public void obtenerTotales() {
        // Suponiendo que ya tienes la conexión
        Connection cn = con.konexion();

        if (cn != null) {
            try {
                // Obtener la fecha actual
                LocalDate fechaActual = LocalDate.now();
                System.out.println("Fecha actual: " + fechaActual);
                // Consulta para obtener los valores de efectivo, tarjeta y transferencia de la tabla 'mesas'
                String sql = "SELECT SUM(efectivo) AS TotalEfectivo, SUM(tarjeta) AS TotalTarjeta, SUM(transferencia) AS TotalTransferencia FROM ventas1 WHERE DATE(fecha) = ?";

                try (PreparedStatement pstmt = cn.prepareStatement(sql)) {
                    pstmt.setDate(1, java.sql.Date.valueOf(fechaActual));
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            // Obtener los totales de cada forma de pago
                            double totalEfectivo = rs.getDouble("TotalEfectivo");
                            double totalTarjeta = rs.getDouble("TotalTarjeta");
                            double totalTransferencia = rs.getDouble("TotalTransferencia");

                            // Mostrar los totales en los JLabel correspondientes
                            lblEfectivo.setText(String.valueOf(totalEfectivo));
                            lblTarjeta.setText(String.valueOf(totalTarjeta));
                            lblTransferencia.setText(String.valueOf(totalTransferencia));

                            // Calcular la suma total
                            double totalGeneral = totalEfectivo + totalTarjeta + totalTransferencia;
                            lblTotal.setText(String.valueOf(totalGeneral));
                            
                            
                        } else {
                            // No se encontraron registros para la fecha actual
                            lblEfectivo.setText("0.0");
                            lblTarjeta.setText("0.0");
                            lblTransferencia.setText("0.0");
                            lblTotal.setText("0.0");
                        }
                    }
                }

            } catch (SQLException e) {
                System.err.println("Error en la operación: " + e.getMessage());
            }
        }
    }
    
    public void insertarTurno() {

        // Suponiendo que ya tienes la conexión
        Connection cn = con.konexion();

        if (cn != null) {
            try {
                double totalVentasEfectivo = Double.parseDouble(lblEfectivo.getText());
                double totalVentasTarjeta = Double.parseDouble(lblTarjeta.getText());
                double totalVentasTransferencia = Double.parseDouble(lblTransferencia.getText());
                double ventaTotal = Double.parseDouble(lblTotal.getText());
                
                String capturaText = txtCaptura.getText();
                double captura = Double.parseDouble(capturaText);

                // Consulta para insertar en la tabla 'turnos'
                String sql = "INSERT INTO turnos (venta_total, efectivo, tarjeta, transferencia, cantidad_capturada) VALUES (?, ?, ?, ?, ?)";

                try (PreparedStatement pstmt = cn.prepareStatement(sql)) {
                    pstmt.setDouble(2, totalVentasEfectivo);
                    pstmt.setDouble(3, totalVentasTarjeta);
                    pstmt.setDouble(4, totalVentasTransferencia);
                    pstmt.setDouble(1, ventaTotal);
                    pstmt.setDouble(5, captura);

                    // Ejecutar la inserción
                    pstmt.executeUpdate();

                    System.out.println("Inserción en la tabla 'turnos' completada con éxito");
                }

            } catch (NumberFormatException e) {
                System.err.println("Error al convertir el valor del JTextField a un número: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error en la operación de inserción en la tabla 'turnos': " + e.getMessage());
            }
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
        jLabel1 = new javax.swing.JLabel();
        lblEfectivo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCerrarT = new javax.swing.JButton();
        txtCaptura = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        lblTransferencia = new javax.swing.JLabel();
        lblTarjeta = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Venta en efectivo");

        lblEfectivo.setText(" ");

        jLabel2.setText("Venta con tarjeta");

        jLabel3.setText("Venta con transferencia");

        jLabel4.setText("Venta total");

        jLabel6.setText("cantidad capturada");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCerrarT.setText("Cerrar turno");
        btnCerrarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarTActionPerformed(evt);
            }
        });

        txtCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapturaActionPerformed(evt);
            }
        });

        lblTotal.setText(" ");

        lblTransferencia.setText(" ");

        lblTarjeta.setText(" ");

        jLabel13.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrarT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblEfectivo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTarjeta))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTransferencia))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTotal))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarT)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapturaActionPerformed

    private void btnCerrarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarTActionPerformed
        insertarTurno();
        this.dispose();
    }//GEN-LAST:event_btnCerrarTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cerrarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cerrarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cerrarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cerrarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cerrarTurno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEfectivo;
    private javax.swing.JLabel lblTarjeta;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTransferencia;
    private javax.swing.JTextField txtCaptura;
    // End of variables declaration//GEN-END:variables
}
