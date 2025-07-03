
package repositorio;

import entidad.CarnetVacunacion;
import entidad.DetalleCarnetVacunacion;
import entidad.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CarnetVacunaRepositorio implements ICrudCarnetVacuna {
    
    
    
    @Override
    public List<DetalleCarnetVacunacion> listarVac() {
        List<DetalleCarnetVacunacion> detalles = new ArrayList<>();
        String sql = "SELECT id_detCarnet,nombre_vacuna,fecha_aplicacion,fecha_prox,tipo_desparasitacion,tratamiento,cod_producto";

        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                 Producto producto = new Producto();
                DetalleCarnetVacunacion detalle = new DetalleCarnetVacunacion();
                detalle.setId_DetalleCarnetVacunacion(rs.getInt("id_detCarnet"));
                detalle.setNombreVacuna(rs.getString("nombre_vacuna"));
                detalle.setFechaApli(rs.getDate("fecha_aplicacion"));
                detalle.setProxApli(rs.getDate("fecha_prox"));
                detalle.setTipoDesparasitacion(rs.getString("tipo_desparasitacion"));
                detalle.setTratamiento(rs.getString("tratamiento"));
                producto.setCod_Producto(rs.getInt("cod_producto"));
                detalle.setProducto(producto);
                detalles.add(detalle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detalles;
    }
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
    public int agregarDetVacuna(DetalleCarnetVacunacion vac) {
    int idGenerado = -1;
    String sql = "INSERT INTO DetalleCarnetVacunacion (id_carnetVacuna, nombre_vacuna,fecha_aplicacion,fecha_prox,tipo_desparasitacion, tratamiento, cod_producto) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try (Connection con = ConexionBD.conectar();
         PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        
        stmt.setInt(1, vac.getId_carnetVacuna());
        stmt.setString(2, vac.getNombreVacuna());
        stmt.setDate(3,(java.sql.Date)vac.getFechaApli());
        stmt.setDate(4, (java.sql.Date)vac.getProxApli());
        stmt.setString(5, vac.getTipoDesparasitacion());
        stmt.setString(6, vac.getTratamiento());
        stmt.setInt(7, vac.getProducto().getCod_Producto());
       
        int filas = stmt.executeUpdate();

        if (filas > 0) {
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1);  
                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return idGenerado;
    }
    public List<DetalleCarnetVacunacion> obtenerDetallesPorIdCarnet(int idCarnet) {
        List<DetalleCarnetVacunacion> lista = new ArrayList<>();
        String sql = "SELECT id_detCarnetVacuna FROM DetalleCarnetVacunacion WHERE id_carnetVacuna = ?";

        try (Connection con = ConexionBD.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idCarnet);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DetalleCarnetVacunacion d = new DetalleCarnetVacunacion();
                d.setId_DetalleCarnetVacunacion(rs.getInt("id_detCarnetVacuna"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     public boolean existeCarnetPorMascota(int idHistoriaCli) {
        String sql = "SELECT COUNT(*) FROM CarnetVacunacion cv "
                + "JOIN HistoriaClinica m ON cv.id_histClinica= m.id_histClinica "
                + "WHERE m.id_histClinica = ?";
        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idHistoriaCli);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editarDetVacCarnet(CarnetVacunacion vac) {
        return false;
    }

    @Override
    public boolean eliminarDetVacCarnet(int idVacuna) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   


  
}
