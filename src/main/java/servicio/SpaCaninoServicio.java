
package servicio;
import entidad.CitaSpaCanino;
import entidad.Mascota;
import java.util.List;
import repositorio.SpaCaninoRepositorio;

public class SpaCaninoServicio {

    private SpaCaninoRepositorio spaRepo = new SpaCaninoRepositorio();

    public boolean registrarCita(CitaSpaCanino cita) {
        return spaRepo.insertarSpa(cita);
    }
    public List<Mascota> obtenerNombresMascota(String nrodni){
      return spaRepo.listarMascotaporDni(nrodni);
    }
    public List<CitaSpaCanino> obtenerCitasSpa() {
        return spaRepo.listarSpa();
    }

    public boolean editarCita(CitaSpaCanino cita) {
        return spaRepo.editarSpa(cita);
    }
    public boolean eliminarCita(int idSpa){
      return spaRepo.eliminarSpa(idSpa);
    }

}
