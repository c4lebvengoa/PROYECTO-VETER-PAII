package controlador;

import entidad.Mascota;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import servicio.SpaCaninoServicio;
import vista.CitaSpaCaninoFrm;
import entidad.CitaSpaCanino;
import javax.swing.JOptionPane;
import vista.DetalleHistoriaClinicaFrm;

public class CitaSpaCaninoControlador {

    private final SpaCaninoServicio servicio;
    private CitaSpaCaninoFrm vista;
    private DetalleHistoriaClinicaFrm vistadet;
    private int idCspaSeleccionado = -1;
    public CitaSpaCaninoControlador(CitaSpaCaninoFrm vista) {
        this.servicio = new SpaCaninoServicio();
        this.vista = vista;
         vista.tableSpa.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = vista.tableSpa.getSelectedRow();
                if (fila >= 0) {
                    vista.btnAgregar.setEnabled(false);
                    idCspaSeleccionado = Integer.parseInt(vista.tableSpa.getValueAt(fila, 0).toString());
                    vista.cbxGroomer.setSelectedItem(vista.tableSpa.getValueAt(fila, 1).toString());
                    vista.cbxMascota.setSelectedItem(vista.tableSpa.getValueAt(fila, 2).toString());
                    vista.cbxTamano.setSelectedItem(vista.tableSpa.getValueAt(fila, 3).toString());
                    vista.cbxTipoServicio.setSelectedItem(vista.tableSpa.getValueAt(fila, 4).toString());
                    vista.cbxTipoBano.setSelectedItem(vista.tableSpa.getValueAt(fila, 5).toString());
                    vista.cbxTipoCorte.setSelectedItem(vista.tableSpa.getValueAt(fila, 6).toString());

                    java.util.Date fecha = java.sql.Date.valueOf(vista.tableSpa.getValueAt(fila, 7).toString());
                    vista.fechaSpa.setDate(fecha);

                    vista.txthoraSpa.setText(vista.tableSpa.getValueAt(fila, 8).toString());

                    String estadoTexto = vista.tableSpa.getValueAt(fila, 9).toString();
                    vista.txtestado.setText(estadoTexto.equalsIgnoreCase("Activo") ? "1" : "0");

                    vista.txtprecioSpa.setText(vista.tableSpa.getValueAt(fila, 10).toString());

                    String nombreMascota = vista.tableSpa.getValueAt(fila, 2).toString();

                    vista.cbxMascota.removeAllItems();

                    vista.cbxMascota.addItem(nombreMascota);

                    vista.cbxMascota.setSelectedItem(nombreMascota);

                    vista.cbxMascota.setEnabled(false);
                    
                    vista.cbxGroomer.setEnabled(false);
                    
                    vista.cbxTamano.setEnabled(false);

                }
            }
        });
    }
      public CitaSpaCaninoControlador(DetalleHistoriaClinicaFrm vistadet) {
        this.servicio = new SpaCaninoServicio();
        this.vistadet = vistadet;
    }

    public void listarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Cita Spa","Groomer", "Mascota", "Tamaño", "Tipo de Servicio", "Tipo de Baño",
                    "Tipo de Corte", "Fecha", "Hora", "Estado", "Precio"}) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<CitaSpaCanino> citas = servicio.obtenerCitasSpa();

        for (CitaSpaCanino c : citas) {
            String estadoTexto = (c.getEstado() == 1) ? "Atendido" : "No Atendido"; 
            modelo.addRow(new Object[]{
                c.getId_CitaSpa(),
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

    public boolean editarCita(CitaSpaCanino cita) {
        return servicio.editarCita(cita);
    }
    public boolean eliminarCita(int idSpa){
     return servicio.eliminarCita(idSpa);
    }

    public void listarMascotaporDni(String nrodni) {
        if (!servicio.verificarExistenciaDni(nrodni)) {
            JOptionPane.showMessageDialog(null, "El DNI no existe en la base de datos.");
            return;
        }
        List<Mascota> mascotas = servicio.obtenerNombresMascota(nrodni);

        if (mascotas != null) {
            if(vistadet!=null){
              vistadet.listarMascotaDet(mascotas);   
            }
            if(vista!=null){
             for(Mascota m:mascotas)
              vista.cbxMascota.addItem(m.getNombre());
            }
            
        }
    }
    public List<Mascota> listaMasc(String nrodni){
       return servicio.obtenerNombresMascota(nrodni);
    }
 

}
