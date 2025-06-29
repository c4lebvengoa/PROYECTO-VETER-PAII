package controlador;

import entidad.Mascota;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import servicio.SpaCaninoServicio;
import vista.CitaSpaCaninoFrm;
import entidad.CitaSpaCanino;
import vista.DetalleHistoriaClinicaFrm;

public class CitaSpaCaninoControlador {

    private final SpaCaninoServicio servicio;
    private CitaSpaCaninoFrm vista;
    private DetalleHistoriaClinicaFrm vistadet;

    public CitaSpaCaninoControlador(CitaSpaCaninoFrm vista) {
        this.servicio = new SpaCaninoServicio();
        this.vista = vista;
    }
      public CitaSpaCaninoControlador(DetalleHistoriaClinicaFrm vistadet) {
        this.servicio = new SpaCaninoServicio();
        this.vistadet = vistadet;
    }

    public void listarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Groomer", "Mascota", "Tamaño", "Tipo de Servicio", "Tipo de Baño",
                    "Tipo de Corte", "Fecha", "Hora", "Estado", "Precio"}) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<CitaSpaCanino> citas = servicio.obtenerCitasSpa();

        for (CitaSpaCanino c : citas) {
            String estadoTexto = (c.getEstado() == 1) ? "Activo" : "Inactivo"; 
            modelo.addRow(new Object[]{
                c.getGroomer().getNombre(),
                c.getMascota().getNombre(),
                c.getTamano(),
                c.getTipoServicio(),
                c.getTipoBano(),
                c.getTipoCorte(),
                c.getFecha(),
                c.getHora(),
                estadoTexto,
                c.getPrecio()
            });
        }

        vista.tableSpa.setModel(modelo);
        for (int i = 0; i < vista.tableSpa.getColumnCount(); i++) {
            vista.tableSpa.getColumnModel().getColumn(i).setResizable(false);
        }
    }

    public boolean registrarCita(CitaSpaCanino cita) {
        return servicio.registrarCita(cita);
    }

    public void listarMascotaporDni(String nrodni) {
        List<Mascota> mascotas = servicio.obtenerNombresMascota(nrodni);

        if (mascotas != null) {
            if(vistadet!=null){
              vistadet.listarMascotaDet(mascotas);
              
            }
            if(vista!=null)
            vista.listarMascota(mascotas);

        }
    }
    public void abrirDetalleHistoriaClinica(String dni) {
        List<Mascota> mascotas = servicio.obtenerNombresMascota(dni); 

        if (mascotas != null && !mascotas.isEmpty()) {
            DetalleHistoriaClinicaFrm detalleFrm = new DetalleHistoriaClinicaFrm();
            detalleFrm.listarMascotaDet(mascotas); 
            detalleFrm.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "No se encontraron mascotas para el DNI ingresado.");
        }
}


}
