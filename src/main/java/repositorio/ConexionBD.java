
package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author EMNA
 */
public class ConexionBD{

    private static final String URL = "jdbc:mysql://localhost:3306/bd_veterinaria";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    
    public static Connection conectar(){
        Connection miConexion=null;
        try{        
            miConexion=DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexion exitosa");
        }catch(SQLException e){
            System.out.println("No se pudo conectar pepepe"+e);
        }
        return miConexion;
    }
    
    public static void main(String[] args) {
        ConexionBD c=new ConexionBD();
        c.conectar();
        if(c!=null){
            System.out.println("Se conectó waaa");
        }
        else{
            System.out.println("ONIOOOOO");
        }
    }
}

