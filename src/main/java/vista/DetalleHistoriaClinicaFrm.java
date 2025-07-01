
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.CitaSpaCaninoControlador;
import controlador.DetalleHistoriaClinicaControlador;
import entidad.DetalleHistoriaClinica;
import entidad.Mascota;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetalleHistoriaClinicaFrm extends javax.swing.JFrame {
    private final CitaSpaCaninoControlador controlador;
    private final DetalleHistoriaClinicaControlador controladol;
    public  List<Mascota> listaMascotas;
    private int idDetSeleccionado=-1;
    public DetalleHistoriaClinicaFrm() {
        initComponents();
        setTitle("Historia Clínica");
        setResizable(false);
        setLocationRelativeTo(null);
        AreaDet.setEditable(false);
        txtidhistoria.setEditable(false);
        controlador=new CitaSpaCaninoControlador(this);
        controladol=new DetalleHistoriaClinicaControlador(this);
        controladol.listarDet();
     
    }
    public void listarMascotaDet(List<Mascota> lista){
        listaMascotas = lista;
        for (Mascota m : lista) {
            cbxMascota.addItem(m.getNombre());
        }
    }
    public void setIdHistoriaClinica(int id) {
    txtidhistoria.setText(String.valueOf(id));
}
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDet = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txttemperatura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Areadxpre = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreaAnam = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtpeso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Areaobs = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Areadxdef = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Areatra = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregarHist = new javax.swing.JButton();
        btnEditarHist = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnregresar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        AreaDet = new javax.swing.JTextArea();
        btnCrearCarnetVacuna = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        dnipropietario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbxMascota = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        txtidhistoria = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnCrearHistoria = new javax.swing.JButton();
        btnLimp = new javax.swing.JButton();
        btnLimpial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID_detHistoria", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tablaDet);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 230, 400));

        jLabel12.setText("Buscar: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Historia Clínica", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(txttemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 200, -1));

        jLabel5.setText("Anamnesis:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel9.setText("Observaciones: ");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel10.setText("Dx Presuntivo:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        Areadxpre.setColumns(20);
        Areadxpre.setRows(5);
        jScrollPane2.setViewportView(Areadxpre);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 290, 50));

        AreaAnam.setColumns(20);
        AreaAnam.setRows(5);
        jScrollPane3.setViewportView(AreaAnam);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 250, 40));

        jLabel6.setText("Peso:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));
        jPanel5.add(txtpeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 200, -1));

        jLabel7.setText("Temperatura:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        Areaobs.setColumns(20);
        Areaobs.setRows(5);
        jScrollPane5.setViewportView(Areaobs);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 290, 40));

        jLabel14.setText("Dx Definitivo");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        Areadxdef.setColumns(20);
        Areadxdef.setRows(5);
        jScrollPane6.setViewportView(Areadxdef);

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 290, 50));

        jLabel15.setText("Tratamiento:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        Areatra.setColumns(20);
        Areatra.setRows(5);
        jScrollPane7.setViewportView(Areatra);

        jPanel5.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 290, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 370, 480));

        jButton1.setBackground(new java.awt.Color(0, 122, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, 30));

        btnEliminar.setBackground(new java.awt.Color(254, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 550, 90, 30));

        btnAgregarHist.setBackground(new java.awt.Color(107, 193, 34));
        btnAgregarHist.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarHist.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarHist.setText("+Agregar");
        btnAgregarHist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHistActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarHist, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 90, 30));

        btnEditarHist.setBackground(new java.awt.Color(254, 183, 7));
        btnEditarHist.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditarHist.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarHist.setText("Editar");
        btnEditarHist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarHistActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarHist, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 550, 90, 30));

        btnLimpiar.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 550, 90, 30));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 180, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("LISTA DETALLE HISTORIA CLÍNICA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, 20));

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
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        AreaDet.setColumns(20);
        AreaDet.setRows(5);
        jScrollPane4.setViewportView(AreaDet);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 500, 400));

        btnCrearCarnetVacuna.setText("Crear Carnet Vacunación");
        btnCrearCarnetVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCarnetVacunaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearCarnetVacuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 170, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS MASCOTA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel11.setText("DNI Propietario:");

        jLabel13.setText("Mascota: ");

        cbxMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-" }));
        cbxMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMascotaActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel16.setText("ID Historia:");

        btnCrearHistoria.setText("Crear Historia");
        btnCrearHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearHistoriaActionPerformed(evt);
            }
        });

        btnLimp.setText("Limpiar");
        btnLimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(324, 324, 324))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dnipropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtidhistoria)
                                    .addComponent(cbxMascota, 0, 200, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnCrearHistoria)
                .addGap(44, 44, 44)
                .addComponent(btnLimp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dnipropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbxMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtidhistoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimp)
                    .addComponent(btnCrearHistoria))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 400, 180));

        btnLimpial.setBackground(new java.awt.Color(153, 153, 153));
        btnLimpial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpial.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpial.setText("Limpiar Detalles");
        btnLimpial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpialActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpial, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       try{
         DetalleHistoriaClinica det = obtenerDetDesdeFormulario();
        int fila = tablaDet.getSelectedRow();
        if (fila >= 0) {
            btnAgregarHist.setEnabled(false);
            idDetSeleccionado = Integer.parseInt(tablaDet.getValueAt(fila, 0).toString());
            if (idDetSeleccionado >= 0) {
                controladol.eliminarDetalle(idDetSeleccionado);
                JOptionPane.showMessageDialog(null, "Detalle Historia Eliminado Exitosamente!");
                controladol.listarDet();
                controladol.listarDetallePorMascota(det.getMascota().getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "Detalle Historia no se elimino,seleccione uno");
            }

        }
       
       }catch(Exception e){
         e.printStackTrace();
       }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarHistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHistActionPerformed
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

    try {
        DetalleHistoriaClinica det = new DetalleHistoriaClinica();

        det.setMascota(mascota);
        det.setIdHistClinica(Integer.parseInt(txtidhistoria.getText()));
        det.setPeso(Double.parseDouble(txtpeso.getText()));
        det.setTemperatura(Double.parseDouble(txttemperatura.getText()));
        det.setAnamnesis(AreaAnam.getText());
        det.setObservaciones(Areaobs.getText());
        det.setDxPresuntivo(Areadxpre.getText());
        det.setDxDefinitivo(Areadxdef.getText());
        det.setTratamiento(Areatra.getText());

        boolean exito = controladol.registrarDet(det);

        if (exito) {
           JOptionPane.showMessageDialog(null,"Detalle Registrado Correctamente!");
           controladol.listarDet();
           controladol.listarDetallePorMascota(mascota.getNombre());
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el detalle.");
        }

    } catch ( IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "RELLENE TODOS LOS CAMPOS CORRECTAMENTE.");
    }
    }//GEN-LAST:event_btnAgregarHistActionPerformed

    private void btnEditarHistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarHistActionPerformed
         try {
            DetalleHistoriaClinica det = obtenerDetDesdeFormulario();

            if (det.getId_DetHistoriaClinica()<= 0) {
                JOptionPane.showMessageDialog(this, "Seleccione una detale válido de la tabla antes de editar.");
                return;
            }

            boolean actualizado = controladol.editarDetalle(det);
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Detalle editado correctamente.");
                controladol.listarTabla();
                controladol.listarDetallePorMascota(det.getMascota().getNombre());
                //limpiarEdit();
            } else {
                JOptionPane.showMessageDialog(this, "Error al editar el detalle.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }       
    }//GEN-LAST:event_btnEditarHistActionPerformed
    public DetalleHistoriaClinica obtenerDetDesdeFormulario() {
        int fila = tablaDet.getSelectedRow();
       int idCspaSeleccionado = Integer.parseInt(tablaDet.getValueAt(fila, 0).toString());
        DetalleHistoriaClinica det = new DetalleHistoriaClinica();

        det.setId_DetHistoriaClinica(idCspaSeleccionado);
    
        String nombreSeleccionado = cbxMascota.getSelectedItem().toString();

        Mascota mascotaSeleccionada = new Mascota();
        mascotaSeleccionada.setNombre(nombreSeleccionado);
        mascotaSeleccionada.setId_Mascota(0);
        det.setMascota(mascotaSeleccionada);

        det.setPeso(Double.parseDouble(txtpeso.getText()));
        det.setTemperatura(Double.parseDouble(txttemperatura.getText()));
        det.setAnamnesis(AreaAnam.getText());
        det.setObservaciones(Areaobs.getText());
        det.setDxPresuntivo(Areadxpre.getText());
        det.setDxDefinitivo(Areadxdef.getText());
        det.setTratamiento(Areatra.getText());
        return det;
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
      Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void btnCrearCarnetVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCarnetVacunaActionPerformed
       dispose();
       new CarnetVacuna().setVisible(true);
    }//GEN-LAST:event_btnCrearCarnetVacunaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nrodoc=dnipropietario.getText().trim();
        if(nrodoc.isEmpty()){
        JOptionPane.showMessageDialog(null,"Ingrese Dni del Propietario.");
         return;
        }
         controlador.listarMascotaporDni(nrodoc);
       
         
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
       dispose();
       new Servicios().setVisible(true);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnCrearHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearHistoriaActionPerformed

        controladol.crearHistoriaClinica();
    }//GEN-LAST:event_btnCrearHistoriaActionPerformed

    private void cbxMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMascotaActionPerformed
      if (cbxMascota.getSelectedIndex() >= 0) {
        String nombreMascota = cbxMascota.getSelectedItem().toString();
        int idHistoria = controladol.obtenerIdHistoriaPorMascota(nombreMascota);
        if (idHistoria > 0) {
            txtidhistoria.setText(String.valueOf(idHistoria));
        } else {
            txtidhistoria.setText("");
        }
    }
    }//GEN-LAST:event_cbxMascotaActionPerformed
    public void Limpiar(){
            btnAgregarHist.setEnabled(true);
            dnipropietario.setText("");
            cbxMascota.removeAllItems();
            cbxMascota.addItem("-Seleccione-");
            txtidhistoria.setText("");
            txtpeso.setText("");
            txttemperatura.setText("");
            AreaAnam.setText("");
            Areaobs.setText("");
            Areadxpre.setText("");
            Areadxdef.setText("");
            Areatra.setText("");
            AreaDet.setText("");
            DefaultTableModel modelo = (DefaultTableModel)tablaDet.getModel();
            modelo.setRowCount(0);
    
    }
    public void limpiarEdit(){
            txtpeso.setText("");
            txttemperatura.setText("");
            AreaAnam.setText("");
            Areaobs.setText("");
            Areadxpre.setText("");
            Areadxdef.setText("");
            Areatra.setText("");

    }
    private void btnLimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpActionPerformed
        dnipropietario.setText("");
        cbxMascota.removeAllItems();
        txtidhistoria.setText("");
    }//GEN-LAST:event_btnLimpActionPerformed

    private void btnLimpialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpialActionPerformed
        btnAgregarHist.setEnabled(true);
        txtpeso.setText("");
        txttemperatura.setText("");
        AreaAnam.setText("");
        Areaobs.setText("");
        Areadxpre.setText("");
        Areadxdef.setText("");
        Areatra.setText("");

    }//GEN-LAST:event_btnLimpialActionPerformed

    public static void main(String args[]) {
       
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleHistoriaClinicaFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea AreaAnam;
    public javax.swing.JTextArea AreaDet;
    public javax.swing.JTextArea Areadxdef;
    public javax.swing.JTextArea Areadxpre;
    public javax.swing.JTextArea Areaobs;
    public javax.swing.JTextArea Areatra;
    public javax.swing.JButton btnAgregarHist;
    public javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearCarnetVacuna;
    private javax.swing.JButton btnCrearHistoria;
    private javax.swing.JButton btnEditarHist;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimp;
    private javax.swing.JButton btnLimpial;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnregresar;
    public javax.swing.JComboBox<String> cbxMascota;
    private javax.swing.JTextField dnipropietario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField4;
    public javax.swing.JTable tablaDet;
    public javax.swing.JTextField txtidhistoria;
    public javax.swing.JTextField txtpeso;
    public javax.swing.JTextField txttemperatura;
    // End of variables declaration//GEN-END:variables
}
