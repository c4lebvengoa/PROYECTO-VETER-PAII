
package repositorio;

import entidad.CarnetVacunacion;
import entidad.DetalleCarnetVacunacion;
import java.util.List;


public interface ICrudCarnetVacuna {
    int CrearCarnet(int idHistoriaClinica);
    
    public List<DetalleCarnetVacunacion> listarVac();

    int agregarDetVacuna(DetalleCarnetVacunacion vac);

    boolean editarDetVacCarnet(CarnetVacunacion vac);
    
    boolean eliminarDetVacCarnet(int idVacuna);
}
