package controlador;

import entidad.DetalleHistoriaClinica;
import entidad.Mascota;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servicio.DetalleHistoriaClinicaServicio;
import vista.DetalleHistoriaClinicaFrm;

public class DetalleHistoriaClinicaControlador {

    private final DetalleHistoriaClinicaServicio servicio;
    private final DetalleHistoriaClinicaFrm vista;
    private final Map<Integer, Integer> mapaHistoriaAMascota;


    public DetalleHistoriaClinicaControlador(DetalleHistoriaClinicaFrm vista) {
        this.vista = vista;
        this.servicio = new DetalleHistoriaClinicaServicio();
        this.mapaHistoriaAMascota = new HashMap<>(); 
        this.mapaHistoriaAMascota.putAll(servicio.obtenerMapaHistoriaAMascota());

        vista.tablaDet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = vista.tablaDet.getSelectedRow();
                if (fila >= 0) {
                    int idDetalle = Integer.parseInt(vista.tablaDet.getValueAt(fila, 0).toString());
                    mostrarDetallePorId(idDetalle);
                }
            }
        });
        vista.cbxMascota.addActionListener(e -> {
            String nombreMascota = vista.cbxMascota.getSelectedItem().toString();
            listarDetallePorMascota(nombreMascota);
        });
    }


    public void listarDet() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID_detHist"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<DetalleHistoriaClinica> detalles = servicio.obtenerDetallesHist();
        vista.AreaDet.setText("");

        for (DetalleHistoriaClinica c : detalles) {
            modelo.addRow(new Object[]{c.getId_DetHistoriaClinica()});
            mostrarDetalleEnTexto(c);
        }

        vista.tablaDet.setModel(modelo);
        for (int i = 0; i < vista.tablaDet.getColumnCount(); i++) {
            vista.tablaDet.getColumnModel().getColumn(i).setResizable(false);
        }
    }

    private int obtenerIdMascotaPorNombre(String nombreMascota) {
        for (Mascota m : vista.listaMascotas) {
            if (m.getNombre().equals(nombreMascota)) {
                return m.getId_Mascota();
            }
        }
        return -1;
    }
    public int obtenerIdHistoriaPorMascota(String nombreMascota) {
    return servicio.obtenerIdHistoriaClinicaPorNombreMascota(nombreMascota);
}

    public void listarDetallePorMascota(String nombreMascota) {
        int idMascota = obtenerIdMascotaPorNombre(nombreMascota);
        if (idMascota == -1) return;

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID_detHist"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<DetalleHistoriaClinica> detalles = servicio.obtenerDetallesHist();
     
        vista.AreaDet.setText("");
        String textoTotal = "";

        for (DetalleHistoriaClinica c : detalles) {
            if (mapaHistoriaAMascota.get(c.getIdHistClinica()) != null
                    && mapaHistoriaAMascota.get(c.getIdHistClinica()) == idMascota) {

                modelo.addRow(new Object[]{c.getId_DetHistoriaClinica()});

                textoTotal += "ID: " + c.getId_DetHistoriaClinica() + "\n"
                        + "Peso: " + c.getPeso() + " kg\n"
                        + "Temperatura: " + c.getTemperatura() + " °C\n"
                        + "Anamnesis: " + c.getAnamnesis() + "\n"
                        + "Observaciones: " + c.getObservaciones() + "\n"
                        + "Dx Presuntivo: " + c.getDxPresuntivo() + "\n"
                        + "Dx Definitivo: " + c.getDxDefinitivo() + "\n"
                        + "Tratamiento: " + c.getTratamiento() + "\n"
                        + "--------------------------------------------------\n";
            }
        }
        vista.AreaDet.setText(textoTotal);


        vista.tablaDet.setModel(modelo);
        for (int i = 0; i < vista.tablaDet.getColumnCount(); i++) {
            vista.tablaDet.getColumnModel().getColumn(i).setResizable(false);
        }
    }
    

    public void mostrarDetallePorId(int idDetalle) {
        List<DetalleHistoriaClinica> detalles = servicio.obtenerDetallesHist();
        for (DetalleHistoriaClinica c : detalles) {
            if (c.getId_DetHistoriaClinica() == idDetalle) {
                vista.AreaDet.setText("");
                mostrarDetalleEnTexto(c);
                break;
            }
        }
    }

    private void mostrarDetalleEnTexto(DetalleHistoriaClinica c) {
        vista.AreaDet.append("ID: " + c.getId_DetHistoriaClinica() + "\n");
        vista.AreaDet.append("Peso: " + c.getPeso() + " kg\n");
        vista.AreaDet.append("Temperatura: " + c.getTemperatura() + " °C\n");
        vista.AreaDet.append("Anamnesis: " + c.getAnamnesis() + "\n");
        vista.AreaDet.append("Observaciones: " + c.getObservaciones() + "\n");
        vista.AreaDet.append("Dx Presuntivo: " + c.getDxPresuntivo() + "\n");
        vista.AreaDet.append("Dx Definitivo: " + c.getDxDefinitivo() + "\n");
        vista.AreaDet.append("Tratamiento: " + c.getTratamiento() + "\n");
        vista.AreaDet.append("--------------------------------------------------\n");
    }
    public boolean registrarDet(DetalleHistoriaClinica det){
      return servicio.registrarDet(det);
    }
    public void listarTabla(){
    DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID_detHistoria", "Fecha"}) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<DetalleHistoriaClinica> detalles = servicio.obtenerDetallesHist();

        for (DetalleHistoriaClinica d: detalles) {
            modelo.addRow(new Object[]{
                d.getId_DetHistoriaClinica(),
            });
        }

        vista.tablaDet.setModel(modelo);
        for (int i = 0; i < vista.tablaDet.getColumnCount(); i++) {
            vista.tablaDet.getColumnModel().getColumn(i).setResizable(false);
        }
    }

    public void crearHistoriaClinica() {
       String nombreMascota = vista.cbxMascota.getSelectedItem().toString();

    if (nombreMascota == null || nombreMascota.isEmpty()) {
        JOptionPane.showMessageDialog(vista, "Seleccione una mascota válida.");
        return;
    }

    // Validación si ya existe
    if (servicio.historiaClinicaExistePorMascota(nombreMascota)) {
        JOptionPane.showMessageDialog(vista, "La historia clínica para esta mascota ya existe.");
        return;
    }

    int idHistoria = servicio.registrarHistoriaClinica(nombreMascota);
    if (idHistoria > 0) {
        vista.setIdHistoriaClinica(idHistoria);
        JOptionPane.showMessageDialog(vista, "Historia clínica creada con ID: " + idHistoria);
    } else {
        JOptionPane.showMessageDialog(vista, "Error al crear historia clínica.");
    }

    }

}

