package repositorio;

import entidad.DetalleHistoriaClinica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetalleHistoriaClinicaRepositorio implements ICrudDetHistoriaClinica {

    @Override
    public int CrearHistoria(String nombreMascota) {
         int idGenerado = -1;
    String sqlSelect = "SELECT id_mascota FROM Mascota WHERE nombre_mas=?";
    String sqlInsert = "INSERT INTO HistoriaClinica(id_mascota, fecha_registro) VALUES (?, NOW())";

    try (Connection cn = ConexionBD.conectar();
         PreparedStatement psSelect = cn.prepareStatement(sqlSelect)) {

        psSelect.setString(1, nombreMascota);
        ResultSet rs = psSelect.executeQuery();

        if (rs.next()) {
            int idMascota = rs.getInt("id_mascota");

                try (PreparedStatement psInsert = cn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
                    psInsert.setInt(1, idMascota);
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
    public List<DetalleHistoriaClinica> listarDetHistoria() {
        List<DetalleHistoriaClinica> detalles = new ArrayList<>();
        String sql = "SELECT id_detHistClinica, id_histClinica, peso, temperatura, anamnesis, observaciones, dx_presuntivo, dx_definitivo, tratamiento FROM DetalleHistoriaClinica";

        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DetalleHistoriaClinica det = new DetalleHistoriaClinica();
                det.setId_DetHistoriaClinica(rs.getInt("id_detHistClinica"));
                det.setIdHistClinica(rs.getInt("id_histClinica"));
                det.setPeso(rs.getDouble("peso"));
                det.setTemperatura(rs.getDouble("temperatura"));
                det.setAnamnesis(rs.getString("anamnesis"));
                det.setObservaciones(rs.getString("observaciones"));
                det.setDxPresuntivo(rs.getString("dx_presuntivo"));
                det.setDxDefinitivo(rs.getString("dx_definitivo"));
                det.setTratamiento(rs.getString("tratamiento"));

                detalles.add(det);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detalles;
    }

    public Map<Integer, Integer> obtenerMapaHistoriaAMascota() {
        Map<Integer, Integer> mapa = new HashMap<>();
        String sql = "SELECT id_histClinica, id_mascota FROM HistoriaClinica";

        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idHistClinica = rs.getInt("id_histClinica");
                int idMascota = rs.getInt("id_mascota");
                mapa.put(idHistClinica, idMascota);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mapa;
    }

    @Override
    public int agregarDetHistoria(DetalleHistoriaClinica det) {
    int idGenerado = -1;
    String sql = "INSERT INTO DetalleHistoriaClinica (id_histClinica, peso, temperatura, anamnesis, observaciones, dx_presuntivo, dx_definitivo, tratamiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    try (Connection con = ConexionBD.conectar();
         PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        
        stmt.setInt(1, det.getIdHistClinica());
        stmt.setDouble(2, det.getPeso());
        stmt.setDouble(3, det.getTemperatura());
        stmt.setString(4, det.getAnamnesis());
        stmt.setString(5, det.getObservaciones());
        stmt.setString(6, det.getDxPresuntivo());
        stmt.setString(7, det.getDxDefinitivo());
        stmt.setString(8, det.getTratamiento());

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

    public List<DetalleHistoriaClinica> obtenerDetallesPorIdHistClinica(int idHistClinica) {
        List<DetalleHistoriaClinica> lista = new ArrayList<>();
        String sql = "SELECT id_detHistClinica FROM DetalleHistoriaClinica WHERE id_histClinica = ?";

        try (Connection con = ConexionBD.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idHistClinica);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DetalleHistoriaClinica d = new DetalleHistoriaClinica();
                d.setId_DetHistoriaClinica(rs.getInt("id_detHistClinica"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    public int obtenerIdHistoriaPorMascota(String nombreMascota) {
        int idHistoria = 0;
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement("SELECT id_histClinica FROM HistoriaClinica h JOIN Mascota m ON h.id_mascota = m.id_mascota WHERE m.nombre_mas = ?")) {

            ps.setString(1, nombreMascota);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idHistoria = rs.getInt("id_histClinica");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idHistoria;
    }

    public boolean existeHistoriaPorMascota(String nombreMascota) {
        String sql = "SELECT COUNT(*) FROM HistoriaClinica hc "
                + "JOIN Mascota m ON hc.id_mascota = m.id_mascota "
                + "WHERE m.nombre_mas = ?";
        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreMascota);
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
    public boolean editarDetHistoria(DetalleHistoriaClinica det) {
      String sql = "UPDATE DetalleHistoriaClinica SET   peso = ?, temperatura = ?, anamnesis = ?, observaciones = ?, dx_presuntivo = ?, dx_definitivo = ?, tratamiento = ? WHERE id_detHistClinica = ?";

    try (Connection con = ConexionBD.conectar();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setDouble(1, det.getPeso());
        stmt.setDouble(2, det.getTemperatura());
        stmt.setString(3, det.getAnamnesis());
        stmt.setString(4, det.getObservaciones());
        stmt.setString(5, det.getDxPresuntivo());
        stmt.setString(6, det.getDxDefinitivo());
        stmt.setString(7, det.getTratamiento());
        stmt.setInt(8, det.getId_DetHistoriaClinica()); 

        int filas = stmt.executeUpdate();
        return filas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }

    @Override
    public boolean eliminarDetHistoria(int idDetHist) {
        String sql = "DELETE FROM DetalleHistoriaClinica WHERE id_detHistClinica = ?";

        try (Connection con = ConexionBD.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idDetHist);

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
   
    
}
