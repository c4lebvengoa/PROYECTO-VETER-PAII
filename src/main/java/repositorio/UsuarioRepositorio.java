
package repositorio;


public class UsuarioRepositorio {
    private final String usuarioCorrecto = "Abigail";
    private final String passwordCorrecto = "1234567";

    public boolean validarCredenciales(String usuario, String password) {
        return usuarioCorrecto.equals(usuario) && passwordCorrecto.equals(password);
    }
}
