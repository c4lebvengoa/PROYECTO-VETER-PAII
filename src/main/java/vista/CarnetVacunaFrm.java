
package vista;

import com.formdev.flatlaf.FlatLightLaf;


public class CarnetVacunaFrm extends javax.swing.JFrame {

  
    public CarnetVacunaFrm() {
        initComponents();
        setTitle("Carnet de Vacunación");
        setLocationRelativeTo(null);
        setResizable(false);
        txtidCarnet.setEditable(false);
    }
    public void setIdCarnetVacuna(int idCarnet) {
    txtidCarnet.setText(String.valueOf(idCarnet));
}
   

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtidCarnet = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxTipoVacuna = new javax.swing.JComboBox<>();
        txtPropietario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txttratamiento = new javax.swing.JTextArea();
        txtMascota = new javax.swing.JTextField();
        txttipoDesp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtidhistoria = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        fechaproxCan = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        fechaproxFel = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        cbxVacunaCan = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cbxEdadCan = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        cbxVacunaFel = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        cbxEdadFel = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        fechaapliCan = new com.toedter.calendar.JDateChooser();
        fechaapliFel = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVacuna = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE LA MASCOTA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID Carnet: ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        txtidCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidCarnetActionPerformed(evt);
            }
        });
        jPanel2.add(txtidCarnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 60, -1));

        jLabel5.setText("Mascota:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel11.setText("Tipo de vacunación:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        jLabel10.setText("Dni Propietario");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        cbxTipoVacuna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "CANINA", "FELINA", " " }));
        cbxTipoVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoVacunaActionPerformed(evt);
            }
        });
        jPanel2.add(cbxTipoVacuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 190, -1));
        jPanel2.add(txtPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 200, -1));

        jLabel2.setText("Tratamiento: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel4.setText("Tipo de Desparasitación:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        txttratamiento.setColumns(20);
        txttratamiento.setRows(5);
        jScrollPane3.setViewportView(txttratamiento);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 300, -1));
        jPanel2.add(txtMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 200, -1));
        jPanel2.add(txttipoDesp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 300, -1));

        jLabel6.setText("ID Historia Clínica: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        txtidhistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhistoriaActionPerformed(evt);
            }
        });
        jPanel2.add(txtidhistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 200, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 340, 440));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CARNET DE VACUNACIÓN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fechaproxCan.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(fechaproxCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 140, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("FECHA PRÓXIMA");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));

        fechaproxFel.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(fechaproxFel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 140, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("FECHA DE APLICACIÓN");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        cbxVacunaCan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "Vacuna Puppy(Distemper- Parvovirus)", "1era Vacuna Parvovirus", "1era Vacuna Triple(Distemper.Hepatitis,Leptospira)", "Vacuna Cuádruple (Parvovirus,Distemper,Hepatitis,Leptospira)", "Vacuna Quíntuple (Parvovirus,Hepatitis,Leptospira,Parainfluencia)", "Vacuna Sextuple/Hexadog (Parvovirus,Distemper,Hepatitis,Parainfluencia,)", "Vacuna Antirrábica", "Vacuna KC", "Vacuna Anual (Parvovirus,Distemper,Hepatitis,Leptospira,Parainfluencia)" }));
        jPanel3.add(cbxVacunaCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 250, -1));

        jLabel48.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel48.setText("VACUNACIÓN CANINA");
        jPanel3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 28, -1, 30));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setText("VACUNA");
        jPanel3.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 60, -1));

        cbxEdadCan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "1 MES", "1.5 MES", "2 MESES", "2 MESES", "3 MESES", "3 MESES", "3.5 MESES", "1 AÑO", "1 AÑO" }));
        jPanel3.add(cbxEdadCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("EDAD");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("FECHA PRÓXIMA");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("FECHA DE APLICACIÓN");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        jLabel47.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel47.setText("VACUNACIÓN FELINA");
        jPanel3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        cbxVacunaFel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "1era Vacuna Triple Felina (Panleucopenia,Calicivirus,Rinotraquelitis)", "Refuerzo Vacuna Triple Felina (Panleucopenia,Celicivirus,Rinotraquelitis)", "Vacuna Antirrábica", "Vacuna Leucimia Felina", "Vacuna Anual (Panleucopenia,Calicivirus,Rinotraquelitis,Rabia)", "Refuerzo Anual (Panleucopenia,Calicivirus,Rinotraquelitis,Rabia)" }));
        cbxVacunaFel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVacunaFelActionPerformed(evt);
            }
        });
        jPanel3.add(cbxVacunaFel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 250, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel52.setText("VACUNA");
        jPanel3.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 60, -1));

        cbxEdadFel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "1.5 MES O 2 MESES", "2.5 MESES O 3 MESES", "2 MESES", "1 AÑO", "1 AÑO", "1 AÑO" }));
        cbxEdadFel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEdadFelActionPerformed(evt);
            }
        });
        jPanel3.add(cbxEdadFel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("EDAD");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        fechaapliCan.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(fechaapliCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 140, -1));

        fechaapliFel.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(fechaapliFel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 140, -1));

        tablaVacuna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° Vacuna", "Tipo de Vacunación", "Vacuna", "Fecha Apli", "Fecha Prox"
            }
        ));
        jScrollPane1.setViewportView(tablaVacuna);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 770, 270));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 830, 530));

        btnAgregar.setBackground(new java.awt.Color(107, 193, 34));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("+Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 90, 30));

        btnEditar.setBackground(new java.awt.Color(254, 183, 7));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 80, 30));

        btnLimpiar.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 80, 30));

        btnEliminar.setBackground(new java.awt.Color(254, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 80, 30));

        btnregresar.setBackground(new java.awt.Color(0, 145, 145));
        btnregresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnregresar.setForeground(new java.awt.Color(255, 255, 255));
        btnregresar.setText("REGRESAR");
        btnregresar.setBorder(null);
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1260, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxEdadFelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEdadFelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEdadFelActionPerformed

    private void cbxVacunaFelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVacunaFelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxVacunaFelActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtidCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidCarnetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidCarnetActionPerformed

    private void cbxTipoVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoVacunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoVacunaActionPerformed

    private void txtidhistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhistoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhistoriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarnetVacunaFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> cbxEdadCan;
    private javax.swing.JComboBox<String> cbxEdadFel;
    private javax.swing.JComboBox<String> cbxTipoVacuna;
    private javax.swing.JComboBox<String> cbxVacunaCan;
    private javax.swing.JComboBox<String> cbxVacunaFel;
    private com.toedter.calendar.JDateChooser fechaapliCan;
    private com.toedter.calendar.JDateChooser fechaapliFel;
    private com.toedter.calendar.JDateChooser fechaproxCan;
    private com.toedter.calendar.JDateChooser fechaproxFel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaVacuna;
    private javax.swing.JTextField txtMascota;
    private javax.swing.JTextField txtPropietario;
    private javax.swing.JTextField txtidCarnet;
    private javax.swing.JTextField txtidhistoria;
    private javax.swing.JTextField txttipoDesp;
    private javax.swing.JTextArea txttratamiento;
    // End of variables declaration//GEN-END:variables
}
