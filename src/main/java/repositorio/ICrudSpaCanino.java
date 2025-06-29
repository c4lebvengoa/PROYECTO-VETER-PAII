
package repositorio;

import entidad.Mascota;
import java.util.List;
import entidad.CitaSpaCanino;


public interface ICrudSpaCanino {
     public List<CitaSpaCanino> listarSpa();
     boolean insertarSpa(CitaSpaCanino cita);
     public List<Mascota> listarMascotaporDni(String numdni);
     void editarSpa();
     
}
