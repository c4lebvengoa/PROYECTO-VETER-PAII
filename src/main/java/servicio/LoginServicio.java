
package servicio;
import java.awt.Color;
import repositorio.UsuarioRepositorio;
import vista.Login;
import vista.MenuPrincipal;
import javax.swing.*;

public class LoginServicio {
    private int intentos = 0;
    private final UsuarioRepositorio repositorio;
    private final MenuPrincipal menuPrincipal;
    private final Login login;

    public LoginServicio(Login login) {
        this.login=login;
        this.repositorio = new UsuarioRepositorio();
        this.menuPrincipal=new MenuPrincipal();
    }

    public void intentarLogin(String usuario, String contrasena) {
        if (usuario.isEmpty() || 
            usuario.equals("Ingrese su usuario") || 
            contrasena.isEmpty() 
            || contrasena.equals("***********")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR RELLENE TODOS LOS CAMPOS");
            return;
        }
        if (repositorio.validarCredenciales(usuario, contrasena)) {
            menuPrincipal.setVisible(true);
            menuPrincipal.lblusuario.setText(login.txtuser.getText());
            login.dispose();
        }
        else {
            intentos++;
            JOptionPane.showMessageDialog(null, """
                                                ERROR
                                                USUARIO o CONTRASEÑA INCORRECTOS
                                                INTENTE DE NUEVO""", "ALERTA", JOptionPane.ERROR_MESSAGE);
            login.txtuser.setText("Ingrese su usuario");
            login.txtuser.setForeground(Color.GRAY);
            login.pswuser.setText("***********");
            login.pswuser.setForeground(Color.GRAY);
            
        }
        if (intentos >= 3) {
            JOptionPane.showMessageDialog(null, "CANTIDAD DE INTENTOS AGOTADA\nUSUARIO BLOQUEADO", "CONTACTE A SOPORTE", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
}
