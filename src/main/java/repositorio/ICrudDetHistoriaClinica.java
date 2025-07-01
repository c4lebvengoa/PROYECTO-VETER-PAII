
package repositorio;

import java.util.List;
import entidad.DetalleHistoriaClinica;



public interface ICrudDetHistoriaClinica {
    List<DetalleHistoriaClinica> listarDetHistoria();
    
   int CrearHistoria(String nombreMascota);

    boolean agregarDetHistoria(DetalleHistoriaClinica det);

    boolean editarDetHistoria(DetalleHistoriaClinica det);
    
    boolean eliminarDetHistoria(int idDetHist);
    
}
