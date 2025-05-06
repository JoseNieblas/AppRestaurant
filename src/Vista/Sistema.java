package Vista;

import Ventanas.VAyuda;
import Ventanas.VUsuarios;
import Ventanas.VComedor;
import Ventanas.VConfiguracion;
import Ventanas.VProductos;
import Ventanas.consultas;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Sistema extends javax.swing.JFrame {

    public Sistema() {
        initComponents();
        this.setLocationRelativeTo(null);
        //rsscalelabel.RSScaleLabel.setScaleLabel(jLabel1,"src/Img/logo3.png");
        //rsscalelabel.RSScaleLabel.setScaleLabel(jLabel2,"src/Img/logoRes.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonComedor = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jButtonProductos = new javax.swing.JButton();
        jButtonConfiguracion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonSalirSistema = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 153, 0));

        jButtonComedor.setBackground(new java.awt.Color(102, 102, 102));
        jButtonComedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonComedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nueva orden.jpg"))); // NOI18N
        jButtonComedor.setText("Comedor");
        jButtonComedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonComedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonComedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComedorActionPerformed(evt);
            }
        });
        jButtonComedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonComedorKeyPressed(evt);
            }
        });

        jButtonClientes.setBackground(new java.awt.Color(102, 102, 102));
        jButtonClientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nueva cliente.jpg"))); // NOI18N
        jButtonClientes.setText("Usuarios");
        jButtonClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonProductos.setBackground(new java.awt.Color(102, 102, 102));
        jButtonProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nueva pro.jpg"))); // NOI18N
        jButtonProductos.setText("    Productos");
        jButtonProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductosActionPerformed(evt);
            }
        });

        jButtonConfiguracion.setBackground(new java.awt.Color(102, 102, 102));
        jButtonConfiguracion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nueva Confi.jpg"))); // NOI18N
        jButtonConfiguracion.setText("Configuracion");
        jButtonConfiguracion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConfiguracion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracionActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nueva logo.jpg"))); // NOI18N

        jButtonSalirSistema.setBackground(new java.awt.Color(255, 0, 0));
        jButtonSalirSistema.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSalirSistema.setText("Salir");
        jButtonSalirSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirSistemaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Captura de pantalla 2023-11-27 181856.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Ayuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnConsultas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonClientes)
                            .addComponent(jButtonProductos))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnConsultas)))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonComedor)
                            .addComponent(jButtonConfiguracion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jButtonSalirSistema)
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonComedor)
                            .addComponent(jButtonClientes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonConfiguracion)
                            .addComponent(jButtonProductos))
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnConsultas)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalirSistema)
                            .addComponent(jButton1))
                        .addGap(34, 34, 34))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracionActionPerformed
        VConfiguracion cf = new VConfiguracion();
        cf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonConfiguracionActionPerformed

    private void jButtonComedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComedorActionPerformed
        VComedor cm = new VComedor();
        cm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonComedorActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        VUsuarios cl = new VUsuarios();
        cl.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductosActionPerformed
        VProductos ps = new VProductos();
        ps.setVisible (true);
        dispose();
    }//GEN-LAST:event_jButtonProductosActionPerformed

    private void jButtonSalirSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirSistemaActionPerformed
    int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro de salir? ");
        if(pregunta ==0){
            dispose();
        }
    }//GEN-LAST:event_jButtonSalirSistemaActionPerformed

    private void jButtonComedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonComedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonComedorKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        VAyuda ay = new VAyuda();
        ay.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        // TODO add your handling code here:
        consultas consultas= new consultas();
        consultas.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnConsultasActionPerformed

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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonComedor;
    private javax.swing.JButton jButtonConfiguracion;
    private javax.swing.JButton jButtonProductos;
    private javax.swing.JButton jButtonSalirSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
