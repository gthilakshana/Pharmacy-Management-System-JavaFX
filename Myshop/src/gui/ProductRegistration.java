/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.userRegistration.path;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class ProductRegistration extends javax.swing.JFrame {

    GRN grn;

    static String path;
    static File destinationfile;

    /**
     * Creates new form ProductRegistration
     */
    public ProductRegistration() {
        initComponents();
        loadBrands();
        loadCategories();
        loadProducts();
    }

    class tableRendere implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            TableColumn tb = jTable1.getColumn("Image");
            tb.setMaxWidth(40);
            jTable1.setRowHeight(40);
            return (Component) value;
        }
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public ProductRegistration(GRN grn) {
        initComponents();
        loadBrands();
        loadCategories();
        loadProducts();
        this.grn = grn;
    }

    public void loadProducts() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `product` INNER JOIN `brand` ON `product`.`brand_id`=`brand`.`id` INNER JOIN `category` ON `product`.`category_id`=`category`.`id` INNER JOIN `image` ON `image`.`id`=`product`.`image_id`");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                jTable1.getColumn("Image").setCellRenderer(new tableRendere());

                String imager = rs.getString("image");

                ImageIcon imageicon = new ImageIcon(imager);

                Image Timage = imageicon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

                JLabel imglabel = new JLabel();

                imglabel.setIcon(new ImageIcon(Timage));
                Vector v = new Vector();

                v.add(imglabel);
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("brand.name"));
                v.add(rs.getString("category.name"));
                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadBrands() {

        try {

            ResultSet rs = MySQL.search("SELECT `name` FROM `brand` ORDER BY `name` ASC");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            jComboBox1.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadCategories() {

        try {

            ResultSet rs = MySQL.search("SELECT `name` FROM `category` ORDER BY `name` ASC");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            jComboBox2.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
            e.printStackTrace();
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

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel7 = new javax.swing.JLabel();
        kButton3 = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Product Registration");
        setPreferredSize(new java.awt.Dimension(896, 711));
        setResizable(false);
        setSize(new java.awt.Dimension(896, 711));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(896, 711));

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(102, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Id", "Product", "Brand", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 20, 250, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Product Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(102, 102, 102));
        jComboBox2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 240, -1));

        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("+");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 69, 40, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Category");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("+");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 109, 40, -1));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(102, 102, 102));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 109, 240, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Brand:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea1.setRows(3);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 156, 280, 116));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Description:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 167, -1, -1));

        kButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kButton2.setForeground(new java.awt.Color(102, 102, 102));
        kButton2.setText("Save");
        kButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        kButton2.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        kButton2.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton2.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverColor(new java.awt.Color(102, 102, 102));
        kButton2.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton2.setkSelectedColor(new java.awt.Color(0, 0, 0));
        kButton2.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 158, 31));

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        kButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kButton1.setForeground(new java.awt.Color(102, 102, 102));
        kButton1.setText("Select Image");
        kButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        kButton1.setkBorderRadius(0);
        kButton1.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton1.setkForeGround(new java.awt.Color(102, 102, 102));
        kButton1.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton1.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton1.setkSelectedColor(new java.awt.Color(255, 255, 255));
        kButton1.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/product_banners_fred_office-768x301_480x122.jpg"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        kButton3.setBorder(null);
        kButton3.setText("Print");
        kButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kButton3.setkBackGroundColor(new java.awt.Color(255, 153, 255));
        kButton3.setkEndColor(new java.awt.Color(255, 153, 255));
        kButton3.setkForeGround(new java.awt.Color(51, 51, 51));
        kButton3.setkHoverEndColor(new java.awt.Color(255, 153, 255));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 153, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(255, 153, 255));
        kButton3.setkSelectedColor(new java.awt.Color(255, 153, 255));
        kButton3.setkStartColor(new java.awt.Color(255, 153, 255));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane2)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Product ");

        jButton5.setBackground(new java.awt.Color(255, 153, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo-removebg-preview_1_240x34.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:

        try {

            InputStream filePath = ProductRegistration.class.getResourceAsStream("/report/Product11.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(filePath);

            HashMap parameters = new HashMap();

            TableModel tm = jTable1.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(tm);

            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, datasource);
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_kButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Home1 h = new Home1();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Company", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {
                String pid = jTable1.getValueAt(r, 1).toString();
                String pname = jTable1.getValueAt(r, 2).toString();
                String brand = jTable1.getValueAt(r, 3).toString();
                String category = jTable1.getValueAt(r, 4).toString();

                grn.jLabel10.setText(pid);
                grn.jLabel12.setText(pname);
                grn.jLabel18.setText(brand);
                grn.jLabel14.setText(category);
                this.dispose();
                grn.jTextField1.grabFocus();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:

        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter Product Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Plese Select Category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Plese Select Brand", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jTextArea1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter Product Description", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (path == null) {
            JOptionPane.showMessageDialog(this, "Please Select Image", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            String name = jTextField1.getText();
            String description = jTextArea1.getText();
            String brand = jComboBox1.getSelectedItem().toString();
            String category = jComboBox2.getSelectedItem().toString();

            //            try {
                //                ResultSet rs = MySQL.search("SELECT * FROM `product` INNER JOIN `brand` ON `product`.`brand_id`=`brand`.`id` INNER JOIN `category` ON `product`.`category_id`=`category`.`id` WHERE `product`.`name` = '" + name + "' AND `brand`.`name` = '" + brand + "' AND `category`.`name`='" + category + "'");
                //
                //                if (rs.next()) {
                    //                    JOptionPane.showMessageDialog(this, "Product already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                    //                } else {
                    //
                    //                    ResultSet rs1 = MySQL.search("SELECT `id` FROM `brand` WHERE `name`='" + brand + "'");
                    //                    rs1.next();
                    //
                    //                    ResultSet rs2 = MySQL.search("SELECT `id` FROM `category` WHERE `name`='" + category + "'");
                    //                    rs2.next();
                    //
                    //                    String brand_id = rs1.getString("id");
                    //                    String category_id = rs2.getString("id");
                    //
                    //                    MySQL.iud("INSERT INTO `product`(`name`,`category_id`,`brand_id`,`description`) VALUES ('" + name + "','" + category_id + "','" + brand_id + "','" + description + "')");
                    //                    loadProducts();
                    //                    jTextField1.setText("");
                    //                    jTextArea1.setText("");
                    //                    jComboBox1.setSelectedIndex(0);
                    //                    jComboBox2.setSelectedIndex(0);
                    //                    loadProducts();
                    //                    JOptionPane.showMessageDialog(this, "New Product Added", "Success", JOptionPane.INFORMATION_MESSAGE);
                    //
                    //                }
                //            } catch (Exception e) {
                //                e.printStackTrace();
                //            }
            try {

                ResultSet rsc = MySQL.search("SELECT * FROM `category` WHERE `name` = '" + category + "'");
                rsc.next();

                String category_id = rsc.getString("id");

                ResultSet rsb = MySQL.search("SELECT * FROM `brand` WHERE `name` = '" + brand + "'");
                rsb.next();

                String brand_id = rsb.getString("id");

                ResultSet r = MySQL.search("SELECT * FROM  `product` WHERE `name` = '" + name + "' AND `category_id` = '" + category_id + "' AND `brand_id` = '" + brand_id + "' ");

                if (r.next()) {
                    JOptionPane.showMessageDialog(this, "Already exsits!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    String newPath = "upload/product_Img";

                    File directory = new File(newPath);

                    if (!directory.exists()) {
                        directory.mkdirs();
                    }

                    File sourceFile = null;

                    String extension = path.substring(path.lastIndexOf("\\") + 1);
                        sourceFile = new File(path);

                        destinationfile = new File(newPath + "/" + extension);

                        Files.copy(sourceFile.toPath(), destinationfile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                        String p = destinationfile.getAbsolutePath();

                        String imagepath = p.replace("\\", "\\\\");

                            MySQL.iud("INSERT INTO `image`(`image`) VALUES('" + imagepath + "')");

                            ResultSet rsi = MySQL.search("SELECT * FROM `image` WHERE `image` = '" + imagepath + "'");
                            rsi.next();

                            String im_id = rsi.getString("id");

                            MySQL.iud("INSERT INTO  `product` (`category_id`,`brand_id`,`name`,`image_id`,`description`) VALUES ('" + category_id + "','" + brand_id + "','" + name + "','" + im_id + "','" + description + "')");

                            jTextField1.setText("");
                            jTextArea1.setText("");
                            jComboBox1.setSelectedIndex(0);
                            jComboBox2.setSelectedIndex(0);
                            jLabel1.setIcon(null);
                            loadProducts();
                            JOptionPane.showMessageDialog(this, "New Product Added", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:

        JFileChooser file = new JFileChooser();
        //   file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png", "jpeg");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            jLabel1.setIcon(ResizeImage(path));

        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CategoryRegistration cr = new CategoryRegistration(this, true);
        cr.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BrandRegistration br = new BrandRegistration(this, true);
        br.setVisible(true);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables

}
