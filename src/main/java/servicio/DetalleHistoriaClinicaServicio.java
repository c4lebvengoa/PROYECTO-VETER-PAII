
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

    public int registrarDet(DetalleHistoriaClinica det) {
        return detRepo.agregarDetHistoria(det);
    }

    public List<DetalleHistoriaClinica> obtenerDetallesPorIdHistClinica(int idHistClinica) {
        return detRepo.obtenerDetallesPorIdHistClinica(idHistClinica);
    }

    public int registrarHistoriaClinica(String nombreMascota) {
        return detRepo.CrearHistoria(nombreMascota);
    }
    public boolean editarDetalle(DetalleHistoriaClinica det){
        return detRepo.editarDetHistoria(det);
    }

    public int obtenerIdHistoriaClinicaPorNombreMascota(String nombreMascota) {
        return detRepo.obtenerIdHistoriaPorMascota(nombreMascota);
    }

    public boolean historiaClinicaExistePorMascota(String nombreMascota) {
        return detRepo.existeHistoriaPorMascota(nombreMascota); 
    }
     public boolean eliminarDetalle(int idDetHist){
      return detRepo.eliminarDetHistoria(idDetHist);
    }



}
