package vista;


import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import controlador.*;
import java.awt.Image;
import java.awt.Toolkit;

public class MenuPrincipal extends JFrame {
    private final MenuControlador menuControlador;
    private Login login; 
    public MenuPrincipal() {
        initComponents();
        setTitle("Menú Principal - Hora: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        iniciarReloj();
        setLocationRelativeTo(null);
        menuControlador=new MenuControlador(this); 
        Image imagen=Toolkit.getDefaultToolkit().getImage("src\\main\\java\\images\\iconvet.png");
        setIconImage(imagen);
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        panelbg = new javax.swing.JPanel();
        pbarra = new javax.swing.JPanel();
        lblusuario = new javax.swing.JLabel();
        btncerrarsesion = new javax.swing.JPanel();
        lblcerrarsesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblcabecera = new javax.swing.JLabel();
        lblmenuprincipal = new javax.swing.JLabel();
        btnusuarios = new javax.swing.JButton();
        btnproveedores = new javax.swing.JButton();
        btnservicios = new javax.swing.JButton();
        btnproductos = new javax.swing.JButton();
        btnclientes = new javax.swing.JButton();
        btnventas = new javax.swing.JButton();
        btnreportes = new javax.swing.JButton();

        jButton3.setText("Productos");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbg.setBackground(new java.awt.Color(255, 255, 255));
        panelbg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pbarra.setBackground(new java.awt.Color(0, 95, 86));
        pbarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblusuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(255, 255, 255));
        lblusuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblusuario.setText("Nombre de usuario");
        pbarra.add(lblusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 132, 190, -1));

        btncerrarsesion.setBackground(new java.awt.Color(0, 105, 117));
        btncerrarsesion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        lblcerrarsesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcerrarsesion.setForeground(new java.awt.Color(255, 255, 255));
        lblcerrarsesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcerrarsesion.setText("CERRAR SESIÓN");
        lblcerrarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblcerrarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcerrarsesionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btncerrarsesionLayout = new javax.swing.GroupLayout(btncerrarsesion);
        btncerrarsesion.setLayout(btncerrarsesionLayout);
        btncerrarsesionLayout.setHorizontalGroup(
            btncerrarsesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblcerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        btncerrarsesionLayout.setVerticalGroup(
            btncerrarsesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblcerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        pbarra.add(btncerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 382, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cargo");
        pbarra.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 190, -1));

        panelbg.add(pbarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 190, 500));

        lblcabecera.setIcon(new javax.swing.ImageIcon("src\\main\\java\\images\\cabecera.png"));
        panelbg.add(lblcabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 200));

        lblmenuprincipal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblmenuprincipal.setText("MENÚ PRINCIPAL");
        panelbg.add(lblmenuprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, -1));

        btnusuarios.setIcon(new javax.swing.ImageIcon("src\\main\\java\\images\\usuarios.png"));
        btnusuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelbg.add(btnusuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 180, 90));

        btnproveedores.setIcon(new javax.swing.ImageIcon("src\\main\\java\\images\\proveedores.png"));
        btnproveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnproveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproveedoresActionPerformed(evt);
            }
        });
        panelbg.add(btnproveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 180, 90));

        btnservicios.setIcon(new javax.swing.ImageIcon("src\\main\\java\\images\\servicios.png"));
        btnservicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnservicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnserviciosActionPerformed(evt);
            }
        });
        panelbg.add(btnservicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 180, 90));

        btnproductos.setIcon(new javax.swing.ImageIcon("src\\main\\java\\images\\productos.png"));
        btnproductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductosActionPerformed(evt);
            }
        });
        panelbg.add(btnproductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 300, 180, 90));

        btnclientes.setIcon(new javax.swing.ImageIcon("src\\main\\java\\images\\clientes.png"));
        btnclientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });
        panelbg.add(btnclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 180, 90));

        btnventas.setIcon(new javax.swing.ImageIcon("src\\main\\java\\images\\ventas.png"));
        btnventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnventasActionPerformed(evt);
            }
        });
        panelbg.add(btnventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 180, 90));

        btnreportes.setIcon(new javax.swing.ImageIcon("src\\main\\java\\images\\reportes.png"));
        btnreportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelbg.add(btnreportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 180, 90));

        getContentPane().add(panelbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblcerrarsesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcerrarsesionMouseClicked
        int respuesta=JOptionPane.showConfirmDialog(null
                , "¿Está seguro de cerrar sesión?"
                ,"Confirmar cierre de sesión"
                ,JOptionPane.YES_NO_OPTION
                ,JOptionPane.QUESTION_MESSAGE);
        
        if(respuesta==JOptionPane.YES_OPTION){
            setVisible(false);
            login=new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_lblcerrarsesionMouseClicked

    private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
        menuControlador.actionPerformedClientes(evt);
    }//GEN-LAST:event_btnclientesActionPerformed

    private void btnserviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnserviciosActionPerformed
        menuControlador.actionPerformedServicios(evt);
    }//GEN-LAST:event_btnserviciosActionPerformed

    private void btnproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductosActionPerformed
        menuControlador.actionPerformedProductos(evt);
    }//GEN-LAST:event_btnproductosActionPerformed

    private void btnproveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveedoresActionPerformed
        menuControlador.actionPerformedProveedores(evt);
    }//GEN-LAST:event_btnproveedoresActionPerformed

    private void btnventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnventasActionPerformed
        
    }//GEN-LAST:event_btnventasActionPerformed
    private void iniciarReloj() {
        Timer timer = new Timer(1000, e -> {
            String horaActual = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            setTitle("Menú Principal - Hora: " + horaActual);
        });
        timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btncerrarsesion;
    public javax.swing.JButton btnclientes;
    public javax.swing.JButton btnproductos;
    public javax.swing.JButton btnproveedores;
    public javax.swing.JButton btnreportes;
    public javax.swing.JButton btnservicios;
    public javax.swing.JButton btnusuarios;
    public javax.swing.JButton btnventas;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel lblcabecera;
    public javax.swing.JLabel lblcerrarsesion;
    private javax.swing.JLabel lblmenuprincipal;
    public javax.swing.JLabel lblusuario;
    private javax.swing.JPanel panelbg;
    private javax.swing.JPanel pbarra;
    // End of variables declaration//GEN-END:variables
}
