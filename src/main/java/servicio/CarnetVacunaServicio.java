
package servicio;

import repositorio.CarnetVacunaRepositorio;

public class CarnetVacunaServicio {
    private final CarnetVacunaRepositorio carnetRepo=new CarnetVacunaRepositorio();
     public int registrarCarnetVacuna(int idHistoriaClinica) {
        return carnetRepo.CrearCarnet(idHistoriaClinica);
    }
}
