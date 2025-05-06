package Ventanas;

import Modelo.Clientes;
import Modelo.ClientesDAO;
import Modelo.Detalle;
import Modelo.Productos;
import Modelo.ProductosDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.Config;
import Modelo.Mesas;
import Modelo.MesasDAO;
import Modelo.konexion;
import Ventanas.VConfiguracion;
import Vista.Sistema;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;

/**
 *
 * @author lupit
 */
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class VComedor extends javax.swing.JFrame {
    Config conf=new Config();
    Productos pro=new Productos();
    ProductosDAO proDAO=new ProductosDAO();
    Clientes cl = new Clientes();
    ClientesDAO clDAO = new ClientesDAO();
    Venta v = new Venta();
    VentaDAO vDAO = new VentaDAO();
    Detalle DV = new Detalle();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    Mesas m=new Mesas();
    //MesasDAO MDAO=new MesasDAO();
    
    
    konexion con = new konexion();
    Connection cn = con.konexion();
    PreparedStatement sql;
    ResultSet rs;
    private String mesaSeleccionada;
    private Timer timer;
    
    int item;
    double Totalpagar=0.00;
    /**
     * Creates new form Productos
     */
    public VComedor() {
        initComponents();
        ListarConfig();
        llenarCombo();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabel2,"src/img/nuevalogo1.jpg");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabel1,"src/img/nuevocomedor.png");
        txtIdComedor.setVisible(false);
        txtIdEmpresa.setVisible(false);
        txtCodigoEmpresa.setVisible(false);
        txtNombreEmpresa.setVisible(false);
        txtTelefonoEmpresa.setVisible(false);
        txtDireccionEmpresa.setVisible(false);
        txtCodigoComedor.setVisible(false);
        BtnRegistrarVenta.setVisible(false);
        txtCodMesa.setVisible(false);
        txtMesa.setVisible(false);
        txtCodigo.setVisible(false);
        txtDescripcion.setVisible(false);
        txtPrecio.setVisible(false);
        txtComentario.setVisible(false);
        //btnEliminarComedor.setVisible(false);
        //txtCodPro.setVisible(false);
        AutoCompleteDecorator.decorate(cbxMesero);
        proDAO.ColsultarMesero(cbxMesero);
        
        
       
        
    }
    
    
    public void llenarCombo() {
        String[] grupos = new String[5];
        String texto;

        try {
            sql = cn.prepareStatement("SELECT DISTINCT mesa from mesas");
            rs = sql.executeQuery();

            while (rs.next()) {
                grupos[0] = rs.getString(1);
                texto = grupos[0];
                comboMesa1.addItem(texto);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void tabla(String mesaSeleccionada){
        modelo=new DefaultTableModel();
        modelo.addColumn("Codigo_pe");
        modelo.addColumn("Mesa");
        modelo.addColumn("Codigo_pro");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Comentario");
        TablaComedor.setModel(modelo);
        
        String []datos=new String[7];
        try {
            
             String consultaMesa= "select  codigo_mesa,mesa,codigo, descripcion, cantidad, precio, Comentario from mesas where Mesa= ?";
             PreparedStatement pstmt = cn.prepareStatement(consultaMesa);
             pstmt.setString(1, mesaSeleccionada); // Usar la opción seleccionada del combo box
             ResultSet rs = pstmt.executeQuery();
             
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                modelo.addRow(datos);
            }
            TablaComedor.setModel(modelo);
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e + "Error en la consulta");
        }
        
    }
    
    private double calcularTotal(String mesaSeleccionada) {
        double total = 0;

        try {
            // Realiza la consulta para obtener el precio y la cantidad
            String consultaMesa = "SELECT precio, cantidad FROM mesas WHERE Mesa = ?";
            PreparedStatement pstmt = cn.prepareStatement(consultaMesa);
            pstmt.setString(1, mesaSeleccionada);
            ResultSet rs = pstmt.executeQuery();

            // Calcula el total sumando el precio unitario por la cantidad
            while (rs.next()) {
                double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                total += precio * cantidad;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Error en la consulta");
        }

        return total;
    }
    
    
    private void actualizarTotal(String mesaSeleccionada) {
        double total = calcularTotal(mesaSeleccionada);
        txtTotal.setText(String.valueOf(total));
        
        
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAtrasComedor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoComedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaComedor = new javax.swing.JTable();
        btnEliminarComedor = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BtnRegistrarVenta = new javax.swing.JButton();
        LabelVendedor = new javax.swing.JLabel();
        txtIdComedor = new javax.swing.JTextField();
        txtIdEmpresa = new javax.swing.JTextField();
        txtCodigoEmpresa = new javax.swing.JTextField();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtTelefonoEmpresa = new javax.swing.JTextField();
        txtDireccionEmpresa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreclienteComedor = new javax.swing.JTextField();
        txtCodigoclienteComedor = new javax.swing.JTextField();
        cbxMesero = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        comboMesa1 = new javax.swing.JComboBox<>();
        btnCerrarTurno = new javax.swing.JButton();
        txtCanPro = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtCodMesa = new javax.swing.JTextField();
        txtMesa = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtComentario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel8.setText("jLabel8");

        jLabel13.setText("jLabel13");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevocomedor.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(640, 160));

        btnAtrasComedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAtrasComedor.setText("Atras");
        btnAtrasComedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasComedorActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevalogo1.jpg"))); // NOI18N

        txtCodigoComedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoComedorActionPerformed(evt);
            }
        });
        txtCodigoComedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoComedorKeyPressed(evt);
            }
        });

        TablaComedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Codigo", "Descripcion", "Cantidad", "Precio", "Comentario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaComedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaComedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaComedor);
        TablaComedor.getTableHeader().setResizingAllowed(false);
        TablaComedor.getTableHeader().setReorderingAllowed(false);
        if (TablaComedor.getColumnModel().getColumnCount() > 0) {
            TablaComedor.getColumnModel().getColumn(0).setResizable(false);
            TablaComedor.getColumnModel().getColumn(1).setResizable(false);
            TablaComedor.getColumnModel().getColumn(2).setResizable(false);
            TablaComedor.getColumnModel().getColumn(2).setPreferredWidth(100);
            TablaComedor.getColumnModel().getColumn(3).setResizable(false);
            TablaComedor.getColumnModel().getColumn(3).setPreferredWidth(50);
            TablaComedor.getColumnModel().getColumn(4).setResizable(false);
            TablaComedor.getColumnModel().getColumn(4).setPreferredWidth(50);
            TablaComedor.getColumnModel().getColumn(5).setResizable(false);
        }

        btnEliminarComedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminarr15px.png"))); // NOI18N
        btnEliminarComedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarComedorActionPerformed(evt);
            }
        });

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Total:");

        BtnRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Impresora15px.png"))); // NOI18N
        BtnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarVentaActionPerformed(evt);
            }
        });

        LabelVendedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelVendedor.setText("AppV11");

        txtIdComedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdComedorActionPerformed(evt);
            }
        });

        txtTelefonoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoEmpresaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Cod. Mesero:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Nombre:");

        txtCodigoclienteComedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoclienteComedorActionPerformed(evt);
            }
        });
        txtCodigoclienteComedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoclienteComedorKeyPressed(evt);
            }
        });

        cbxMesero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMeseroItemStateChanged(evt);
            }
        });
        cbxMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMeseroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMesero, 0, 0, Short.MAX_VALUE)
                            .addComponent(txtCodigoclienteComedor, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(txtNombreclienteComedor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoclienteComedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreclienteComedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 255));
        jLabel14.setText("Mesero");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Abrir Cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesa1ActionPerformed(evt);
            }
        });

        btnCerrarTurno.setText("Cerrar Turno");
        btnCerrarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarTurnoActionPerformed(evt);
            }
        });

        txtCanPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCanProActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });

        txtCodMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodMesaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton1.setText("Pagar Cuenta");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton4.setText("Efectivo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton5.setText("Tranferencia");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton6.setText("Tarjeta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jToggleButton1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAtrasComedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodMesa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDireccionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoComedor, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdComedor, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelVendedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCanPro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(comboMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCerrarTurno)
                                .addGap(53, 53, 53))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminarComedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnRegistrarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                                .addGap(75, 75, 75))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarComedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrarTurno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtrasComedor)
                    .addComponent(LabelVendedor)
                    .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoComedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdComedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCanPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasComedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasComedorActionPerformed
    int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro de salir? ");
        if(pregunta ==0){
            dispose();
            Sistema Sis = new Sistema();
            Sis.setVisible(true);
        } 
    }//GEN-LAST:event_btnAtrasComedorActionPerformed

    private void btnEliminarComedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarComedorActionPerformed
        // TODO add your handling code here:
        if("".equals(txtCodMesa.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if(!"".equals(txtCodMesa.getText())){
                int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar? ");
                if(pregunta ==0){
                    int id= Integer.parseInt(txtCodMesa.getText());
                    proDAO.Eliminarmesa(id);
                    String mesaSeleccionada = (String) comboMesa1.getSelectedItem();

        // Llenar el segundo ComboBox con los productos del grupo seleccionado
        tabla(mesaSeleccionada);
        actualizarTotal(mesaSeleccionada);
                    JOptionPane.showMessageDialog(null,"Producto eliminado ");
                }
            }
        }
        
    }//GEN-LAST:event_btnEliminarComedorActionPerformed

    private void txtCodigoComedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoComedorKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCodigoComedorKeyPressed

    private void txtCodigoclienteComedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoclienteComedorKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(txtCodigoclienteComedor.getText())){
                int codigo=Integer.parseInt(txtCodigoclienteComedor.getText());
                cl=clDAO.BuscarCliente(codigo);
                if(cl.getNombre() !=null){
                    txtNombreclienteComedor.setText(""+cl.getNombre());
                }else{
                    txtCodigoclienteComedor.setText("");
                    JOptionPane.showMessageDialog(null, "No existe Mesero");
                }
            }
        }
    }//GEN-LAST:event_txtCodigoclienteComedorKeyPressed

    private void BtnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarVentaActionPerformed
        // TODO add your handling code here:
        if(TablaComedor.getRowCount()>0){
            if(!"".equals(txtNombreclienteComedor.getText())){
                RegistraVenta();
                RegistrarDetalle();
                ActualizarStock();
                pdf();
                LimpiarTablaComedor();
                txtTotal.setText("");
                LimpiarClienteventa();
            }else{
                JOptionPane.showMessageDialog(null,"Debes buscar cliente");
            }
        }else{
            JOptionPane.showMessageDialog(null,"No hay Productos en la venta");
        }
        
    }//GEN-LAST:event_BtnRegistrarVentaActionPerformed

    private void txtIdComedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdComedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdComedorActionPerformed

    private void txtCodigoComedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoComedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoComedorActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTelefonoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoEmpresaActionPerformed

    private void cbxMeseroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMeseroItemStateChanged
        // TODO add your handling code here:
        String nom=(String)cbxMesero.getSelectedItem();
        txtCodigoclienteComedor.setText(nom);
        txtCodigoclienteComedor.requestFocus();
    }//GEN-LAST:event_cbxMeseroItemStateChanged

    private void cbxMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMeseroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMeseroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        elegirProductos pro= new elegirProductos();
        pro.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesa1ActionPerformed
        // TODO add your handling code here:
        String mesaSeleccionada = (String) comboMesa1.getSelectedItem();

        // Llenar el segundo ComboBox con los productos del grupo seleccionado
        tabla(mesaSeleccionada);
        actualizarTotal(mesaSeleccionada);
    }//GEN-LAST:event_comboMesa1ActionPerformed

    private void TablaComedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaComedorMouseClicked
        // TODO add your handling code here:
        int fila=TablaComedor.rowAtPoint(evt.getPoint());
        txtCodMesa.setText(TablaComedor.getValueAt(fila, 0).toString());
        txtMesa.setText(TablaComedor.getValueAt(fila, 1).toString());
        txtCodigo.setText(TablaComedor.getValueAt(fila,2).toString());
        txtDescripcion.setText(TablaComedor.getValueAt(fila, 3).toString());
        txtCanPro.setText(TablaComedor.getValueAt(fila,4).toString());
        txtPrecio.setText(TablaComedor.getValueAt(fila, 5).toString());
        txtComentario.setText(TablaComedor.getValueAt(fila, 6).toString());
        
    }//GEN-LAST:event_TablaComedorMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        /*String mesaSeleccionada = (String) comboMesa1.getSelectedItem();
        double total = calcularTotal(mesaSeleccionada);
        
        //seleccionarPago p = new seleccionarPago();
        //p.setVisible(true);
        
        pagarCuenta_Transferencia pag= new pagarCuenta_Transferencia(mesaSeleccionada,total);
        pag.setVisible(true);*/
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnCerrarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarTurnoActionPerformed
        // TODO add your handling code here:
        cerrarTurno cerrarTurno = new cerrarTurno();
        cerrarTurno.setVisible(true);
    }//GEN-LAST:event_btnCerrarTurnoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if("".equals(txtCanPro.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if(!"".equals(txtCodMesa.getText())||!"".equals(txtMesa.getText())||!"".equals(txtCodigo.getText())||!"".equals(txtDescripcion.getText())||!"".equals(txtComentario.getText())){
                m.setCodigo_mesa(Integer.parseInt(txtCodMesa.getText()));
                m.setMesa(txtMesa.getText());
                m.setCodigo(Integer.parseInt(txtCodigo.getText()));
                m.setDescripcion(txtDescripcion.getText());
                m.setCantidad(Integer.parseInt(txtCanPro.getText()));
                m.setPrecio(txtPrecio.getText());
                m.setComentario(txtComentario.getText());
                proDAO.ActualizarMesa(m);
                //LimpiarTable();
                //LimpiarProductos();
                //ListarProductos();
                JOptionPane.showMessageDialog(null,"Producto Modificado");
            }
        }
        String mesaSeleccionada = (String) comboMesa1.getSelectedItem();

        // Llenar el segundo ComboBox con los productos del grupo seleccionado
        tabla(mesaSeleccionada);
        actualizarTotal(mesaSeleccionada);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCodMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodMesaActionPerformed

    private void txtCanProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCanProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCanProActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        String mesaSeleccionada = (String) comboMesa1.getSelectedItem();
        double total = calcularTotal(mesaSeleccionada);
        
        pagarCuenta_Transferencia Trans= new pagarCuenta_Transferencia(mesaSeleccionada,total);
        Trans.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        String mesaSeleccionada = (String) comboMesa1.getSelectedItem();
        double total = calcularTotal(mesaSeleccionada);
        
        pagarCuenta_1 Efectivo= new pagarCuenta_1(mesaSeleccionada,total);
        Efectivo.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        String mesaSeleccionada = (String) comboMesa1.getSelectedItem();
        double total = calcularTotal(mesaSeleccionada);
        
        pagarCuenta_Tarjeta Tar= new pagarCuenta_Tarjeta(mesaSeleccionada,total);
        Tar.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3KeyPressed

    private void txtCodigoclienteComedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoclienteComedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoclienteComedorActionPerformed

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
            java.util.logging.Logger.getLogger(VComedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VComedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VComedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VComedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VComedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrarVenta;
    private javax.swing.JLabel LabelVendedor;
    private javax.swing.JTable TablaComedor;
    private javax.swing.JButton btnAtrasComedor;
    private javax.swing.JButton btnCerrarTurno;
    private javax.swing.JButton btnEliminarComedor;
    private javax.swing.JComboBox<String> cbxMesero;
    private javax.swing.JComboBox<String> comboMesa1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtCanPro;
    private javax.swing.JTextField txtCodMesa;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoComedor;
    private javax.swing.JTextField txtCodigoEmpresa;
    private javax.swing.JTextField txtCodigoclienteComedor;
    private javax.swing.JTextField txtComentario;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccionEmpresa;
    private javax.swing.JTextField txtIdComedor;
    private javax.swing.JTextField txtIdEmpresa;
    private javax.swing.JTextField txtMesa;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNombreclienteComedor;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefonoEmpresa;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
    private void LimpiarComedor(){
        txtCodigoComedor.setText("");
        txtIdComedor.setText("");
        
    }
    private void RegistraVenta(){
        String cliente = txtNombreclienteComedor.getText();
        String vendedor = LabelVendedor.getText();
        double monto = Totalpagar;
        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.setTotal(monto);
        vDAO.RegistraVenta(v);
    }
    private void RegistrarDetalle(){
        int id=vDAO.IdVenta();
        for(int i=0;i<TablaComedor.getRowCount();i++){
            String cod=TablaComedor.getValueAt(i, 0).toString();
            int cant=Integer.parseInt(TablaComedor.getValueAt(i, 3).toString());
            double pre=Double.parseDouble(TablaComedor.getValueAt(i, 4).toString());
            DV.setCod_pro(cod);
            DV.setCantidad(cant);
            DV.setPrecio(pre);
            DV.setId_venta(id);
            vDAO.RegistrarDetalle(DV);
        }
    }
    private void ActualizarStock(){
        for(int i=0;i<TablaComedor.getRowCount();i++){
            String cod=TablaComedor.getValueAt(i, 0).toString();
            int cant=Integer.parseInt(TablaComedor.getValueAt(i, 3).toString());
            pro=proDAO.BuscarPro(cod);
            int StockActual=pro.getStock()-cant;
            vDAO.ActualizarStock(StockActual, cod);
        }
    }
    private void LimpiarTablaComedor(){
        tmp = (DefaultTableModel) TablaComedor.getModel();
        int fila=TablaComedor.getRowCount();
        for(int i=0;i<fila;i++){
            tmp.removeRow(0);
        }
    }
    private void LimpiarClienteventa(){
        txtCodigoclienteComedor.setText("");
        txtNombreclienteComedor.setText("");
    }
    
    public void ListarConfig(){
        conf= proDAO.BuscarDatos();
        txtIdEmpresa.setText(""+conf.getId());
        txtCodigoEmpresa.setText(""+conf.getCodigo());
        txtNombreEmpresa.setText(""+conf.getNombre());
        txtTelefonoEmpresa.setText(""+conf.getTelefono());
        txtDireccionEmpresa.setText(""+conf.getDireccion());
    }
    
    
    private void pdf(){
        try{
            int id=vDAO.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/pdf/venta"+id+".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Img/nuevalogo1.jpg");
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            Date date= new Date();
            fecha.add("Factura:"+id+"\n"+"fecha: "+ new SimpleDateFormat("dd-mm-yyyy").format(date)+"\n\n");
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[]ColumnaEncabezado=new float[]{20f,30f,70f,40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            Encabezado.addCell(img);
            
            String cod=txtCodigoEmpresa.getText();
            String nom=txtNombreEmpresa.getText();
            String tel=txtTelefonoEmpresa.getText();
            String dir=txtDireccionEmpresa.getText();
            
            Encabezado.addCell("");
            Encabezado.addCell("Codigo: "+cod+"\nNombre: "+nom+"\nTelefono: "+tel+"\nDireccion: "+dir);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos del Mesero"+"\n\n");
            doc.add(cli);
            
            PdfPTable tablacli=new PdfPTable(2);
            tablacli.setWidthPercentage(100);
            tablacli.getDefaultCell().setBorder(0);
            float[]Columnacli=new float[]{20f,50f};
            tablacli.setWidths(Columnacli);
            tablacli.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cl1=new PdfPCell(new Phrase("Codigo: ",negrita));
            PdfPCell cl2=new PdfPCell(new Phrase("Nombre: ",negrita));
            cl1.setBorder(0);
            cl2.setBorder(0);
            tablacli.addCell(cl1);
            tablacli.addCell(cl2);
            tablacli.addCell(txtCodigoclienteComedor.getText());
            tablacli.addCell(txtNombreclienteComedor.getText());
            
            doc.add(tablacli);
            
            //Productos
            Paragraph pro = new Paragraph();
            pro.add(Chunk.NEWLINE);
            pro.add("Datos de productos"+"\n\n");
            doc.add(pro);
            
            PdfPTable tablapro=new PdfPTable(5);
            tablapro.setWidthPercentage(100);
            tablapro.getDefaultCell().setBorder(0);
            float[]Columnapro=new float[]{20f,30f,20f,30f,30f};
            tablapro.setWidths(Columnapro);
            tablapro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1=new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell pro2=new PdfPCell(new Phrase("Grupo: ",negrita));
            PdfPCell pro3=new PdfPCell(new Phrase("Cantidad: ",negrita));
            PdfPCell pro4=new PdfPCell(new Phrase("Precio Unidad: ",negrita));
            PdfPCell pro5=new PdfPCell(new Phrase("Precio Total: ",negrita));
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            pro5.setBorder(0);
            pro1.setBackgroundColor(BaseColor.GREEN);
            pro2.setBackgroundColor(BaseColor.GREEN);
            pro3.setBackgroundColor(BaseColor.GREEN);
            pro4.setBackgroundColor(BaseColor.GREEN);
            pro5.setBackgroundColor(BaseColor.GREEN);
            tablapro.addCell(pro1);
            tablapro.addCell(pro2);
            tablapro.addCell(pro3);
            tablapro.addCell(pro4);
            tablapro.addCell(pro5);
            for(int i=0;i<TablaComedor.getRowCount();i++){
                String producto=TablaComedor.getValueAt(i, 1).toString();
                String Grupo=TablaComedor.getValueAt(i, 2).toString();
                String Cantidad=TablaComedor.getValueAt(i, 3).toString();                
                String precio=TablaComedor.getValueAt(i, 4).toString();
                String total=TablaComedor.getValueAt(i, 5).toString();
                tablapro.addCell(producto);
                tablapro.addCell(Grupo);
                tablapro.addCell(Cantidad);
                tablapro.addCell(precio);
                tablapro.addCell(total);
            }
            doc.add(tablapro);
            
            Paragraph info=new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: "+ Totalpagar);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph firma=new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y firma\n\n");
            firma.add("----------------------------");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            Paragraph mensaje=new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("Gracias por su compra");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        }catch(DocumentException | IOException e){
            System.out.println(e.toString());
        }
    }
    
    
}
