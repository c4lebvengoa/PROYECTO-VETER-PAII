/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidad.CarnetVacunacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarnetVacunaRepositorio implements ICrudCarnetVacuna {

    @Override
    public int CrearCarnet(int idHistoriaClinica) {
        int idGenerado = -1;
        String sqlSelect = "SELECT id_histClinica FROM HistoriaClinica WHERE id_histClinica = ?";
        String sqlInsert = "INSERT INTO CarnetVacunacion(id_histClinica, fecha_creacion) VALUES (?, NOW())";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement psSelect = cn.prepareStatement(sqlSelect)) {

            psSelect.setInt(1, idHistoriaClinica);
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                int idHistoria = rs.getInt("id_histClinica");

                try (PreparedStatement psInsert = cn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
                    psInsert.setInt(1, idHistoria);
                    int filas = psInsert.executeUpdate();

                    if (filas > 0) {
                        ResultSet generatedKeys = psInsert.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            idGenerado = generatedKeys.getInt(1);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGenerado;
    }


    @Override
    public int agregarVacuna(CarnetVacunacion vac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editarVacCarnet(CarnetVacunacion vac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarVacCarnet(int idVacuna) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
