package vista;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.CitaSpaCaninoControlador;
import entidad.CitaSpaCanino;
import entidad.Mascota;
import entidad.PersonalSpa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CitaSpaCaninoFrm extends javax.swing.JFrame {

    private CitaSpaCaninoControlador controlador;
    public List<Mascota> listaMascotas;
    private int idCspaSeleccionado = -1;
    private List<PersonalSpa> listaGroomers = new ArrayList<>();

    public CitaSpaCaninoFrm() {
        initComponents();
        tableSpa.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tableSpa.getSelectedRow();
                if (fila >= 0) {
                    btnAgregar.setEnabled(false);
                    idCspaSeleccionado = Integer.parseInt(tableSpa.getValueAt(fila, 0).toString());
                    cbxGroomer.setSelectedItem(tableSpa.getValueAt(fila, 1).toString());
                    cbxMascota.setSelectedItem(tableSpa.getValueAt(fila, 2).toString());
                    cbxTamano.setSelectedItem(tableSpa.getValueAt(fila, 3).toString());
                    cbxTipoServicio.setSelectedItem(tableSpa.getValueAt(fila, 4).toString());
                    cbxTipoBano.setSelectedItem(tableSpa.getValueAt(fila, 5).toString());
                    cbxTipoCorte.setSelectedItem(tableSpa.getValueAt(fila, 6).toString());

                    java.util.Date fecha = java.sql.Date.valueOf(tableSpa.getValueAt(fila, 7).toString());
                    fechaSpa.setDate(fecha);

                    txthoraSpa.setText(tableSpa.getValueAt(fila, 8).toString());

                    String estadoTexto = tableSpa.getValueAt(fila, 9).toString();
                    txtestado.setText(estadoTexto.equalsIgnoreCase("Activo") ? "1" : "0");

                    txtprecioSpa.setText(tableSpa.getValueAt(fila, 10).toString());

                    String nombreMascota = tableSpa.getValueAt(fila, 2).toString();

                    cbxMascota.removeAllItems();

                    cbxMascota.addItem(nombreMascota);

                    cbxMascota.setSelectedItem(nombreMascota);

                    cbxMascota.setEnabled(false);
                    
                    cbxGroomer.setEnabled(false);
                    
                    cbxTamano.setEnabled(false);

                }
            }
        });

        listaGroomers.add(new PersonalSpa(0, "Abigail"));
        listaGroomers.add(new PersonalSpa(1, "Caleb"));
        listaGroomers.add(new PersonalSpa(2, "Cristhian"));
        for (PersonalSpa g : listaGroomers) {
            cbxGroomer.addItem(g.getNombre());
        }
        setTitle("Cita Spa Canino");
        setLocationRelativeTo(null);
        setResizable(false);
        controlador = new CitaSpaCaninoControlador(this);
        controlador.listarTabla();
    }

    public void listarMascota(List<Mascota> lista) {
        listaMascotas = lista;
        for (Mascota m : lista) {
            cbxMascota.addItem(m.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSpa = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtestado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxTipoServicio = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxTipoBano = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxTipoCorte = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtprecioSpa = new javax.swing.JTextField();
        cbxTamano = new javax.swing.JComboBox<>();
        cbxGroomer = new javax.swing.JComboBox<>();
        fechaSpa = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txthoraSpa = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dnipropietario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbxMascota = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSpa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cita Spa", "Groomer", " Mascota", "Tamaño", "Tipo de Servicio", "Tipo de Baño", "Tipo de Corte", "Fecha", "Hora", "Estado", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tableSpa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 920, 460));

        jLabel11.setText("Buscar:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 103, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CITA SPA CANINO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Fecha : ");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 20));

        jLabel3.setText("Hora: ");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 20));
        jPanel7.add(txtestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 200, -1));

        jLabel4.setText("Groomer:");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 80, 20));

        jLabel6.setText("Tamaño: ");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 20));

        jLabel7.setText("Tipo de Servicio: ");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 30));

        cbxTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "BAÑO", "CORTE", "BAÑO Y CORTE" }));
        cbxTipoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoServicioActionPerformed(evt);
            }
        });
        jPanel7.add(cbxTipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 200, -1));

        jLabel8.setText("Tipo de Baño: ");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 30));

        cbxTipoBano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "MEDICADO", "ANTIPULGAS", "SIMPLE" }));
        cbxTipoBano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoBanoActionPerformed(evt);
            }
        });
        jPanel7.add(cbxTipoBano, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 200, -1));

        jLabel9.setText("Estado:");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, 30));

        cbxTipoCorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", " SIMPLE", " ESTILADO", " " }));
        jPanel7.add(cbxTipoCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 200, -1));

        jLabel10.setText("Precio              S/.");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 30));

        txtprecioSpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioSpaActionPerformed(evt);
            }
        });
        jPanel7.add(txtprecioSpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 200, -1));

        cbxTamano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "PEQUEÑO", "MEDIANO", "GRANDE" }));
        jPanel7.add(cbxTamano, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, -1));

        cbxGroomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-" }));
        jPanel7.add(cbxGroomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 200, -1));

        fechaSpa.setDateFormatString("yyyy-MM-dd");
        jPanel7.add(fechaSpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 200, -1));

        jLabel13.setText("Tipo de Corte: ");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 30));
        jPanel7.add(txthoraSpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 200, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 380, 380));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "por ID", "por Nombre" }));
        jPanel1.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 122, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(107, 193, 34));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("+Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 90, 30));

        btnEditar.setBackground(new java.awt.Color(254, 183, 7));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 90, 30));

        btnLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 590, 90, 30));

        btnEliminar.setBackground(new java.awt.Color(254, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 90, 30));

        btnregresar.setBackground(new java.awt.Color(0, 145, 145));
        btnregresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnregresar.setForeground(new java.awt.Color(255, 255, 255));
        btnregresar.setText("REGRESAR");
        btnregresar.setBorder(null);
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("CITAS DE SPA CANINO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS MASCOTA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel5.setText("DNI Propietario:");

        jLabel12.setText("Mascota: ");

        cbxMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dnipropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addComponent(cbxMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dnipropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbxMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 400, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtprecioSpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioSpaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioSpaActionPerformed

    private void cbxTipoBanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoBanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoBanoActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            CitaSpaCanino cita = new CitaSpaCanino();

            int indexMascota = cbxMascota.getSelectedIndex();
            if (indexMascota < 0) {
                JOptionPane.showMessageDialog(this, "Seleccione una mascota");
                return;
            }
            Mascota mascota = listaMascotas.get(indexMascota);
            if (mascota.getId_Mascota() <= 0) {
                JOptionPane.showMessageDialog(this, "La mascota no tiene ID válido");
                return;
            }

            cita.setMascota(mascota);

            int indexGroomer = cbxGroomer.getSelectedIndex();
            PersonalSpa groomer = listaGroomers.get(indexGroomer);
            cita.setGroomer(groomer);

            cita.setTamano(cbxTamano.getSelectedItem().toString());
            cita.setTipoServicio(cbxTipoServicio.getSelectedItem().toString());
            cita.setTipoBano(cbxTipoBano.getSelectedItem().toString());
            cita.setTipoCorte(cbxTipoCorte.getSelectedItem().toString());

            java.util.Date fecha = fechaSpa.getDate();
            cita.setFecha(new java.sql.Date(fecha.getTime()));
            cita.setHora(java.time.LocalTime.parse(txthoraSpa.getText()));

            cita.setEstado(Integer.parseInt(txtestado.getText()));

            cita.setPrecio(Double.parseDouble(txtprecioSpa.getText()));

            boolean exito = controlador.registrarCita(cita);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Cita registrada correctamente.");
                controlador.listarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la cita.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "RELLENE TODOS LOS CAMPOS!.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            CitaSpaCanino cita = obtenerCitaDesdeFormulario();

            if (cita.getId_CitaSpa() <= 0) {
                JOptionPane.showMessageDialog(this, "Seleccione una cita válida de la tabla antes de editar.");
                return;
            }

            boolean actualizado = controlador.editarCita(cita);
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Cita editada correctamente.");
                controlador.listarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Error al editar la cita.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    public CitaSpaCanino obtenerCitaDesdeFormulario() {
        CitaSpaCanino cita = new CitaSpaCanino();

        cita.setId_CitaSpa(idCspaSeleccionado);
    
        String nombreSeleccionado = cbxMascota.getSelectedItem().toString();

        Mascota mascotaSeleccionada = new Mascota();
        mascotaSeleccionada.setNombre(nombreSeleccionado);
        mascotaSeleccionada.setId_Mascota(0);
        cita.setMascota(mascotaSeleccionada);

        int indexGroomer = cbxGroomer.getSelectedIndex();
        cita.setGroomer(listaGroomers.get(indexGroomer));

        cita.setTamano(cbxTamano.getSelectedItem().toString());
        cita.setTipoServicio(cbxTipoServicio.getSelectedItem().toString());
        cita.setTipoBano(cbxTipoBano.getSelectedItem().toString());
        cita.setTipoCorte(cbxTipoCorte.getSelectedItem().toString());
        cita.setFecha(new java.sql.Date(fechaSpa.getDate().getTime()));
        cita.setHora(java.time.LocalTime.parse(txthoraSpa.getText()));
        cita.setEstado(Integer.parseInt(txtestado.getText()));
        cita.setPrecio(Double.parseDouble(txtprecioSpa.getText()));

        return cita;
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
            
    }//GEN-LAST:event_btnLimpiarActionPerformed
    public void Limpiar(){
            cbxMascota.setEnabled(true);
            cbxMascota.removeAllItems();
            cbxMascota.addItem("-Seleccione-");
            fechaSpa.setDate(null);
            txthoraSpa.setText("");
            cbxGroomer.setSelectedIndex(0);
            cbxTamano.setSelectedIndex(0);
            cbxTipoServicio.setSelectedIndex(0);
            cbxTipoBano.setSelectedIndex(0);
            cbxTipoCorte.setSelectedIndex(0);
            txtestado.setText("");
            txtprecioSpa.setText("");
            btnAgregar.setEnabled(true);
            cbxGroomer.setEnabled(true);
            cbxTamano.setEnabled(true);
            cbxTipoCorte.setEnabled(true);
            cbxTipoBano.setEnabled(true);
            dnipropietario.setText("");

    }
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int fila = tableSpa.getSelectedRow();
        if (fila >= 0) {
            btnAgregar.setEnabled(false);
            idCspaSeleccionado = Integer.parseInt(tableSpa.getValueAt(fila, 0).toString());
            if (idCspaSeleccionado >= 0) {
                controlador.eliminarCita(idCspaSeleccionado);
                JOptionPane.showMessageDialog(null, "Cita Spa Eliminada Exitosamente!");
                controlador.listarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Cita Spa no se elimino,seleccione una");
            }

        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      String nrodoc=dnipropietario.getText().trim();
      if(nrodoc.isEmpty()){
       JOptionPane.showMessageDialog(null,"INGRESE EL DNI DEL PROPIETARIO!");
       return;
      }
      controlador.listarMascotaporDni(nrodoc);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        dispose();
        new Servicios().setVisible(true);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void cbxTipoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoServicioActionPerformed
        String tipoServ=cbxTipoServicio.getSelectedItem().toString();
        if(tipoServ.equals("BAÑO")){
          cbxTipoCorte.setEnabled(false);
        }
        if(tipoServ.equals("CORTE")){
          cbxTipoCorte.setEnabled(true);
          cbxTipoBano.setEnabled(false);
        }
        if(tipoServ.equals("BAÑO Y CORTE")){
          cbxTipoCorte.setEnabled(true);
          cbxTipoBano.setEnabled(true);
        }
    }//GEN-LAST:event_cbxTipoServicioActionPerformed
  
    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CitaSpaCaninoFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> cbxGroomer;
    private javax.swing.JComboBox<String> cbxMascota;
    private javax.swing.JComboBox<String> cbxTamano;
    private javax.swing.JComboBox<String> cbxTipoBano;
    private javax.swing.JComboBox<String> cbxTipoCorte;
    private javax.swing.JComboBox<String> cbxTipoServicio;
    private javax.swing.JTextField dnipropietario;
    private com.toedter.calendar.JDateChooser fechaSpa;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    public javax.swing.JTable tableSpa;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txthoraSpa;
    private javax.swing.JTextField txtprecioSpa;
    // End of variables declaration//GEN-END:variables
}
