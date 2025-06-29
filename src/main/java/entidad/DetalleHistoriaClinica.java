/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author victo
 */
public class DetalleHistoriaClinica {
    
    private int id_DetHistoriaClinica;
    private double peso;
    private double temperatura;
    private String anamnesis;
    private Mascota mascota;
    private String observaciones;
    private String dxPresuntivo;
    private String dxDefinitivo;
    private String tratamiento;
    private int idHistClinica;

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public int getIdHistClinica() {
        return idHistClinica;
    }

    public void setIdHistClinica(int idHistClinica) {
        this.idHistClinica = idHistClinica;
    }


    public DetalleHistoriaClinica() {
    }

    public int getId_DetHistoriaClinica() {
        return id_DetHistoriaClinica;
    }

    public void setId_DetHistoriaClinica(int id_DetHistoriaClinica) {
        this.id_DetHistoriaClinica = id_DetHistoriaClinica;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDxPresuntivo() {
        return dxPresuntivo;
    }

    public void setDxPresuntivo(String dxPresuntivo) {
        this.dxPresuntivo = dxPresuntivo;
    }

    public String getDxDefinitivo() {
        return dxDefinitivo;
    }

    public void setDxDefinitivo(String dxDefinitivo) {
        this.dxDefinitivo = dxDefinitivo;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "DetalleHistoriaClinica{" + "id_HistoriaClinica=" + id_DetHistoriaClinica + ", peso=" + peso + ", temperatura=" + temperatura + ", anamnesis=" + anamnesis + ", observaciones=" + observaciones + ", dxPresuntivo=" + dxPresuntivo + ", dxDefinitivo=" + dxDefinitivo + ", tratamiento=" + tratamiento + '}';
    } 
    
}
