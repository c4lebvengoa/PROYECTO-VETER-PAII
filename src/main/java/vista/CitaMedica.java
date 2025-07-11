/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;


public class CitaMedica extends javax.swing.JFrame {

    /**
     * Creates new form CitaMedica
     */
    public CitaMedica() {
        initComponents();
        setTitle("Cita Médica");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbl_listacitas = new javax.swing.JLabel();
        btnAgregarSpaCan = new javax.swing.JButton();
        btnEditarSpaCan = new javax.swing.JButton();
        btnLimpiarSpaCan = new javax.swing.JButton();
        btnEliminarSpaCan = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        btnbuscar2 = new javax.swing.JButton();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cita", "Mascota", "Personal Médico", "Nombre: ", "Fecha", "Hora", "Estado de Cita"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 730, 333));

        jLabel11.setText("Buscar");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, 30));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 170, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CITA MÉDICA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Mascota: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 30));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 180, -1));

        jLabel3.setText("Personal Médico: ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, -1));

        jLabel9.setText("Nombre: ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 180, -1));

        jLabel5.setText("Fecha: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        jLabel6.setText("Hora: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel1.setText("Estado de la cita: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "ATENDIDO", "NO ATENDIDO" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 180, -1));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 180, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 180, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 340, 300));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Generar Boleta");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, 30));

        lbl_listacitas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_listacitas.setText("LISTA DE CITAS");
        jPanel1.add(lbl_listacitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        btnAgregarSpaCan.setBackground(new java.awt.Color(107, 193, 34));
        btnAgregarSpaCan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarSpaCan.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarSpaCan.setText("+Agregar");
        btnAgregarSpaCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSpaCanActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarSpaCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 90, 30));

        btnEditarSpaCan.setBackground(new java.awt.Color(254, 183, 7));
        btnEditarSpaCan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditarSpaCan.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarSpaCan.setText("Editar");
        btnEditarSpaCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSpaCanActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarSpaCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 90, 30));

        btnLimpiarSpaCan.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpiarSpaCan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarSpaCan.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarSpaCan.setText("Limpiar");
        btnLimpiarSpaCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSpaCanActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarSpaCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 90, 30));

        btnEliminarSpaCan.setBackground(new java.awt.Color(254, 0, 0));
        btnEliminarSpaCan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarSpaCan.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarSpaCan.setText("Eliminar");
        btnEliminarSpaCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSpaCanActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarSpaCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 90, 30));

        btnregresar.setBackground(new java.awt.Color(0, 145, 145));
        btnregresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnregresar.setForeground(new java.awt.Color(255, 255, 255));
        btnregresar.setText("REGRESAR");
        btnregresar.setBorder(null);
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        btnbuscar2.setBackground(new java.awt.Color(0, 122, 255));
        btnbuscar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbuscar2.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar2.setText("Buscar");
        btnbuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarSpaCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSpaCanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarSpaCanActionPerformed

    private void btnEditarSpaCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSpaCanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarSpaCanActionPerformed

    private void btnLimpiarSpaCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSpaCanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarSpaCanActionPerformed

    private void btnEliminarSpaCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSpaCanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarSpaCanActionPerformed

    private void btnbuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CitaMedica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarSpaCan;
    private javax.swing.JButton btnEditarSpaCan;
    private javax.swing.JButton btnEliminarSpaCan;
    private javax.swing.JButton btnLimpiarSpaCan;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnbuscar1;
    private javax.swing.JButton btnbuscar2;
    private javax.swing.JButton btnregresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private java.awt.Label label1;
    private javax.swing.JLabel lbl_listacitas;
    // End of variables declaration//GEN-END:variables
}
