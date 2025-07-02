
package repositorio;

import entidad.CarnetVacunacion;


public interface ICrudCarnetVacuna {
    int CrearCarnet(int idHistoriaClinica);

    int agregarVacuna(CarnetVacunacion vac);

    boolean editarVacCarnet(CarnetVacunacion vac);
    
    boolean eliminarVacCarnet(int idVacuna);
}
