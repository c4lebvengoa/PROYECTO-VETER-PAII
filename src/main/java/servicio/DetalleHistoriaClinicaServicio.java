
package servicio;
import entidad.DetalleHistoriaClinica;
import java.util.List;
import java.util.Map;
import repositorio.DetalleHistoriaClinicaRepositorio;
public class DetalleHistoriaClinicaServicio {
    private DetalleHistoriaClinicaRepositorio detRepo=new DetalleHistoriaClinicaRepositorio();
    public List<DetalleHistoriaClinica> obtenerDetallesHist() {
        return detRepo.listarDetHistoria();
    }
    public Map<Integer, Integer> obtenerMapaHistoriaAMascota() {
        return detRepo.obtenerMapaHistoriaAMascota();
    }
    public boolean registrarDet(DetalleHistoriaClinica det){
      return detRepo.agregarDetHistoria(det);
    }
    public int registrarHistoriaClinica(String nombreMascota) {
        return detRepo.CrearHistoria(nombreMascota);
    }

    public int obtenerIdHistoriaClinicaPorNombreMascota(String nombreMascota) {
        return detRepo.obtenerIdHistoriaPorMascota(nombreMascota);
    }


}
