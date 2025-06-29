
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JFrame;


public class Servicios extends JFrame {

    
    public Servicios() {
        initComponents();
        setTitle("Servicios");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSpaCanino = new javax.swing.JButton();
        btnHistoriaClinica = new javax.swing.JButton();
        btnAgendarCitaProc = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAgendarCitaMed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSpaCanino.setBackground(new java.awt.Color(0, 102, 102));
        btnSpaCanino.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSpaCanino.setForeground(new java.awt.Color(255, 255, 255));
        btnSpaCanino.setText("Spa Canino");
        btnSpaCanino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpaCaninoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSpaCanino, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 130, 49));

        btnHistoriaClinica.setBackground(new java.awt.Color(255, 102, 51));
        btnHistoriaClinica.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHistoriaClinica.setForeground(new java.awt.Color(255, 255, 255));
        btnHistoriaClinica.setText("Historia Clínica");
        btnHistoriaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoriaClinicaActionPerformed(evt);
            }
        });
        jPanel1.add(btnHistoriaClinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 130, 49));

        btnAgendarCitaProc.setBackground(new java.awt.Color(102, 102, 255));
        btnAgendarCitaProc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgendarCitaProc.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCitaProc.setText("Agendar Cita Procedimiento");
        btnAgendarCitaProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarCitaProcActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgendarCitaProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, 49));

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
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Grafoim\\Downloads\\PROJECT-VETER-PAII_V2\\src\\main\\java\\images\\logoservicio.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 300, 270));

        btnAgendarCitaMed.setBackground(new java.awt.Color(102, 102, 255));
        btnAgendarCitaMed.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgendarCitaMed.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCitaMed.setText("Agendar Cita");
        btnAgendarCitaMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarCitaMedActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgendarCitaMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 130, 49));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSpaCaninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpaCaninoActionPerformed
        dispose();
        new CitaSpaCaninoFrm().setVisible(true);
    }//GEN-LAST:event_btnSpaCaninoActionPerformed

    private void btnHistoriaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoriaClinicaActionPerformed
       dispose();
       new DetalleHistoriaClinicaFrm().setVisible(true);
    }//GEN-LAST:event_btnHistoriaClinicaActionPerformed

    private void btnAgendarCitaProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitaProcActionPerformed
               
    }//GEN-LAST:event_btnAgendarCitaProcActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnAgendarCitaMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitaMedActionPerformed
       
    }//GEN-LAST:event_btnAgendarCitaMedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendarCitaMed;
    private javax.swing.JButton btnAgendarCitaProc;
    private javax.swing.JButton btnHistoriaClinica;
    private javax.swing.JButton btnSpaCanino;
    private javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
