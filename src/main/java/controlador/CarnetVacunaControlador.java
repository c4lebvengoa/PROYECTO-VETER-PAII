
package controlador;

import entidad.DetalleCarnetVacunacion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
     public void listarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID_detCarnet","Tipo de Vacunacion", "Vacuna", "Fecha Apli", "Fecha Prox","Cod_producto"
                              }) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<DetalleCarnetVacunacion> detalles = servicio.obtenerDetallesVac();

        for (DetalleCarnetVacunacion d : detalles) {
            modelo.addRow(new Object[]{
                d.getId_DetalleCarnetVacunacion(),
                d.getNombreVacuna(),
                d.getFechaApli(),
                d.getProxApli(),
                d.getProducto().getCod_Producto()
            });
        }

        vista.tablaVacuna.setModel(modelo);
        for (int i = 0; i < vista.tablaVacuna.getColumnCount(); i++) {
            vista.tablaVacuna.getColumnModel().getColumn(i).setResizable(false);
        }
    }
}

