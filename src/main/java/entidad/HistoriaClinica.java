/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HistoriaClinica {
    
    private int id_HistoriaClinica;
    private Mascota mascota;
    private Date fechaRegistro;
    private CarnetVacunacion carnetVacunacion;
    private List<DetalleHistoriaClinica> detHist=new ArrayList<>();

    public HistoriaClinica() {
    }

    
    public int getId_Historia_Clinica() {
        return id_HistoriaClinica;
    }

    public void setId_Historia_Clinica(int id_HistoriaClinica) {
        this.id_HistoriaClinica = id_HistoriaClinica;
    }

    public int getId_HistoriaClinica() {
        return id_HistoriaClinica;
    }

    public void setId_HistoriaClinica(int id_HistoriaClinica) {
        this.id_HistoriaClinica = id_HistoriaClinica;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public CarnetVacunacion getCarnetVacunacion() {
        return carnetVacunacion;
    }

    public void setCarnetVacunacion(CarnetVacunacion carnetVacunacion) {
        this.carnetVacunacion = carnetVacunacion;
    }

    public List<DetalleHistoriaClinica> getDetHist() {
        return detHist;
    }

    public void setDetHist(List<DetalleHistoriaClinica> detHist) {
        this.detHist = detHist;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "HistoriaClinica{" + "id_HistoriaClinica=" + id_HistoriaClinica + ", mascota=" + mascota.getNombre() + ", fechaRegistro=" + fechaRegistro + ", carnetVacunacion=" + carnetVacunacion + '}';
    }

   

    
    
}
