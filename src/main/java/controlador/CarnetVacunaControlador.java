
package controlador;

import javax.swing.JOptionPane;
import servicio.CarnetVacunaServicio;
import vista.CarnetVacunaFrm;
import vista.DetalleHistoriaClinicaFrm;

public class CarnetVacunaControlador {

    private final CarnetVacunaServicio servicio;
    private final CarnetVacunaFrm vista;
    private final DetalleHistoriaClinicaFrm vistaDet;
    public CarnetVacunaControlador(DetalleHistoriaClinicaFrm vistaDet, CarnetVacunaFrm vista) {
    this.vistaDet = vistaDet;
    this.vista = vista;
    this.servicio = new CarnetVacunaServicio();
}
    public void crearCarnet() {
        String id_hist = vistaDet.txtidhistoria.getText();
        int idCarnet = servicio.registrarCarnetVacuna(Integer.parseInt(id_hist));
        if (idCarnet > 0) {
            vista.setIdCarnetVacuna(idCarnet);
            JOptionPane.showMessageDialog(vista, "Carnet de Vacunación creado con ID: " + idCarnet);
            vista.setVisible(true);
            vista.toFront();

        } else {
            JOptionPane.showMessageDialog(vista, "Error al crear el carnet.");
        }

    }
}

