/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidad.Distrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vista.RegistrarCliente;


/**
 *
 * @author EMNA
 */
public class DistritoRepositorio implements InterfaceDistrito{

    @Override
    public void listar(RegistrarCliente rc) {
        List<String> distritos=new ArrayList<>();
        try{
            Connection con=ConexionBD.conectar();
            
            String sql="""
                            SELECT nombre_dis
                            FROM Distrito;
                       """;
            PreparedStatement stmt=con.prepareStatement(sql);
            
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                distritos.add(rs.getString("nombre_dis"));
            }
            
            for(String distrito : distritos)
                rc.cbxdistrito.addItem(distrito);
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
}
