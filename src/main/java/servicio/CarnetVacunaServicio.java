
package servicio;

import entidad.DetalleCarnetVacunacion;
import java.util.List;
import repositorio.CarnetVacunaRepositorio;

public class CarnetVacunaServicio {
    private final CarnetVacunaRepositorio carnetRepo=new CarnetVacunaRepositorio();
     public int registrarCarnetVacuna(int idHistoriaClinica) {
        return carnetRepo.CrearCarnet(idHistoriaClinica);
    }
    public int agregardetCarnet(DetalleCarnetVacunacion vac){
        return carnetRepo.agregarDetVacuna(vac);
    }
    public List<DetalleCarnetVacunacion> obtenerDetallesVac() {
        return carnetRepo.listarVac();
    }
}
