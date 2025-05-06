/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Modelo.konexion;
import Vista.Sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class consultas extends javax.swing.JFrame {
    konexion con = new konexion();
    Connection cn = con.konexion();
    PreparedStatement sql;
    ResultSet rs;
    DefaultTableModel Modelo;
    DefaultTableModel Modelo2;

    public consultas() {
        initComponents();
        llenarCombo();
        llenarCombo2();
        this.setLocationRelativeTo(null);
    }
    
    public void llenarCombo() {
       
        String[] grupos = new String[4];
        String texto;

        try {
            sql = cn.prepareStatement("SELECT DATE(fecha) from turnos");
            rs = sql.executeQuery();

            while (rs.next()) {
                grupos[0] = rs.getString(1);
                texto = grupos[0];
                comboTurno.addItem(texto);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void tabla(String fechaSeleccionada){
        Modelo=new DefaultTableModel();
        Modelo.addColumn("Codigo");
        Modelo.addColumn("Venta total");
        Modelo.addColumn("Efectivo");
        Modelo.addColumn("Tarjeta");
        Modelo.addColumn("Transferencia");
        Modelo.addColumn("Cantidad capturada");
        tablaConsultas.setModel(Modelo);
        
        String []datos=new String[6];
        try {
            
             String consultaMesa= "select codigo, venta_total, efectivo, tarjeta, transferencia, cantidad_capturada from turnos where fecha= ?";
             PreparedStatement pstmt = cn.prepareStatement(consultaMesa);
             pstmt.setString(1, fechaSeleccionada); // Usar la opción seleccionada del combo box
             ResultSet rs = pstmt.executeQuery();
             
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                Modelo.addRow(datos);
            }
            tablaConsultas.setModel(Modelo);
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e + "Error en la consulta");
        }
        
    }
     
    public void llenarCombo2() {
       
        String[] grupos = new String[4];
        String texto;

        try {
            sql = cn.prepareStatement("SELECT DISTINCT DATE(fecha) from ventas1");
            rs = sql.executeQuery();

            while (rs.next()) {
                grupos[0] = rs.getString(1);
                texto = grupos[0];
                comboVentas.addItem(texto);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
     
     public void tabla2(String fechaSeleccionada2){
        Modelo2=new DefaultTableModel();
        Modelo2.addColumn("Codigo");
        Modelo2.addColumn("Mesa");
        Modelo2.addColumn("Tarjeta");
        Modelo2.addColumn("Efectivo");
        Modelo2.addColumn("Transferencia");
        Modelo2.addColumn("Total");
        tblVentas.setModel(Modelo2);
        
        String []datos2=new String[6];
        try {
            
             String consultaMesa2= "select codigo, Mesa, tarjeta, efectivo, transferencia, Total from ventas1 where DATE(fecha)= ?";
             PreparedStatement pstmt = cn.prepareStatement(consultaMesa2);
             pstmt.setString(1, fechaSeleccionada2); // Usar la opción seleccionada del combo box
             ResultSet rs = pstmt.executeQuery();
             
            
            while(rs.next()){
                datos2[0]=rs.getString(1);
                datos2[1]=rs.getString(2);
                datos2[2]=rs.getString(3);
                datos2[3]=rs.getString(4);
                datos2[4]=rs.getString(5);
                datos2[5]=rs.getString(6);
                Modelo2.addRow(datos2);
            }
            tblVentas.setModel(Modelo2);
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e + "Error en la consulta");
        }
        
    }
     
     public void Busqueda(String busqueda, String busqueda2){
        Modelo2=new DefaultTableModel();
        Modelo2.addColumn("Codigo");
        Modelo2.addColumn("Mesa");
        Modelo2.addColumn("Tarjeta");
        Modelo2.addColumn("Efectivo");
        Modelo2.addColumn("Transferencia");
        Modelo2.addColumn("Total");
        tblVentas.setModel(Modelo2);
        
        String []datos2=new String[6];
        try {
            
             String consultaFecha= "select codigo, Mesa, tarjeta, efectivo, transferencia, Total from ventas1 where fecha BETWEEN ? AND ?";
             PreparedStatement pstmt = cn.prepareStatement(consultaFecha);
             pstmt.setString(1, busqueda); 
             pstmt.setString(2, busqueda2); 
             ResultSet rs = pstmt.executeQuery();
             
            
            while(rs.next()){
                datos2[0]=rs.getString(1);
                datos2[1]=rs.getString(2);
                datos2[2]=rs.getString(3);
                datos2[3]=rs.getString(4);
                datos2[4]=rs.getString(5);
                datos2[5]=rs.getString(6);
                Modelo2.addRow(datos2);
            }
            tblVentas.setModel(Modelo2);
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e + "Error en la consulta");
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
        comboTurno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultas = new javax.swing.JTable();
        comboVentas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cal1 = new com.toedter.calendar.JCalendar();
        cal2 = new com.toedter.calendar.JCalendar();
        jButton1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtFecha1 = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        comboTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTurnoActionPerformed(evt);
            }
        });

        tablaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "codigo", "venta total", "efectivo", "tarjeta", "transferencia", "cantidad capturada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaConsultas);

        comboVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasActionPerformed(evt);
            }
        });

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Mesa", "Tarjeta", "Efectivo", "Transferencia", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVentas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Turnos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Mesas");

        jLabel3.setText("Busqueda");

        cal1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cal1PropertyChange(evt);
            }
        });

        cal2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cal2PropertyChange(evt);
            }
        });

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtFecha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFecha1ActionPerformed(evt);
            }
        });

        txtFecha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFecha2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(comboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(comboVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cal1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addComponent(cal2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Sistema Sis = new Sistema();
        Sis.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTurnoActionPerformed
        String fechaSeleccionada = (String) comboTurno.getSelectedItem();
        tabla(fechaSeleccionada);
    }//GEN-LAST:event_comboTurnoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Busqueda(txtFecha1.getText(), txtFecha2.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void comboVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasActionPerformed
        String fechaSeleccionada2 = (String) comboVentas.getSelectedItem();
        tabla2(fechaSeleccionada2);
    }//GEN-LAST:event_comboVentasActionPerformed

    private void cal1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cal1PropertyChange
        if(evt.getOldValue() != null){
            SimpleDateFormat fecha1 = new SimpleDateFormat("yyyy/MM/dd");
            txtFecha1.setText(fecha1.format(cal1.getCalendar().getTime()));
        }
    }//GEN-LAST:event_cal1PropertyChange

    private void cal2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cal2PropertyChange
         if(evt.getOldValue() != null){
            SimpleDateFormat fecha2 = new SimpleDateFormat("yyyy/MM/dd");
            txtFecha2.setText(fecha2.format(cal2.getCalendar().getTime()));
        }
    }//GEN-LAST:event_cal2PropertyChange

    private void txtFecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFecha1ActionPerformed
        String busqueda1 = (String) txtFecha1.getText();
        Busqueda(busqueda1, busqueda1);
    }//GEN-LAST:event_txtFecha1ActionPerformed

    private void txtFecha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFecha2ActionPerformed
        String busqueda2 = (String) txtFecha2.getText();
        Busqueda(busqueda2, busqueda2);
    }//GEN-LAST:event_txtFecha2ActionPerformed

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
            java.util.logging.Logger.getLogger(consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private com.toedter.calendar.JCalendar cal1;
    private com.toedter.calendar.JCalendar cal2;
    private javax.swing.JComboBox<String> comboTurno;
    private javax.swing.JComboBox<String> comboVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaConsultas;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    // End of variables declaration//GEN-END:variables
}
