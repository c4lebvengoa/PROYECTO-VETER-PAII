
package repositorio;
import entidad.CitaSpaCanino;
import entidad.Mascota;
import entidad.PersonalSpa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SpaCaninoRepositorio implements ICrudSpaCanino {
    @Override
    public List<CitaSpaCanino> listarSpa() {
      List<CitaSpaCanino> citas=new ArrayList<>();
       String sql="SELECT c.fecha_cspa, c.hora_cspa, c.tamano, c.tipo_servicio, c.tipo_bano, c.tipo_corte, "
               + "c.precio_cspa, c.estado_cspa, "
               + "p.nombres_pspa, m.nombre_mas "
               + "FROM CitaSpaCanino c "
               + "JOIN PersonalSpa p ON c.cod_personalSpa = p.cod_personalSpa "
               + "JOIN Mascota m ON c.id_mascota = m.id_mascota";
        try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            CitaSpaCanino cita = new CitaSpaCanino();

 
            PersonalSpa groomer = new PersonalSpa();
            groomer.setNombre(rs.getString("nombres_pspa"));
            cita.setGroomer(groomer);

          
            Mascota mascota = new Mascota();
            mascota.setNombre(rs.getString("nombre_mas"));
            cita.setMascota(mascota);

       
            cita.setTamano(rs.getString("tamano"));
            cita.setTipoServicio(rs.getString("tipo_servicio"));
            cita.setTipoBano(rs.getString("tipo_bano"));
            cita.setTipoCorte(rs.getString("tipo_corte"));
            cita.setFecha(rs.getDate("fecha_cspa"));
            cita.setHora(rs.getTime("hora_cspa").toLocalTime());
            cita.setEstado(rs.getInt("estado_cspa"));
            cita.setPrecio(rs.getDouble("precio_cspa"));

            citas.add(cita);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return citas;
       
    }
    
    @Override
    public boolean insertarSpa(CitaSpaCanino cita) {
    String sql = "INSERT INTO CitaSpaCanino (cod_personalSpa, id_mascota, tamano, tipo_servicio, tipo_bano, tipo_corte, fecha_cspa, hora_cspa, estado_cspa, precio_cspa) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = ConexionBD.conectar();
         PreparedStatement stmt = con.prepareStatement(sql)) {
  
        stmt.setInt(1, cita.getGroomer().getCod_Personal());
        stmt.setInt(2, cita.getMascota().getId_Mascota());
        stmt.setString(3, cita.getTamano());
        stmt.setString(4, cita.getTipoServicio());
        stmt.setString(5, cita.getTipoBano());
        stmt.setString(6, cita.getTipoCorte());
        stmt.setDate(7, cita.getFecha());
        stmt.setTime(8, java.sql.Time.valueOf(cita.getHora()));
        stmt.setInt(9, cita.getEstado());
        stmt.setDouble(10, cita.getPrecio());
        int filas = stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }

    @Override
    public List<Mascota> listarMascotaporDni(String numdni) {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT m.id_mascota, m.nombre_mas, c.nro_doc_cli "
                + "FROM Cliente c "
                + "JOIN Mascota m ON c.cod_cliente = m.cod_cliente "
                + "WHERE c.nro_doc_cli = ?";

        try (Connection con = ConexionBD.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, numdni);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setId_Mascota(rs.getInt("id_mascota")); 
                mascota.setNombre(rs.getString("nombre_mas"));
                lista.add(mascota);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

   
   

}
