/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author victo
 */
public class CitaMedica {
    
    private int id_Cita;
    private PersonalMedico personalMedico;
    private Mascota mascota;
    private Date fechaCita;
    private LocalTime hora;
    private boolean estadoCita;
    private List<DetalleCitaMedica> detCita=new ArrayList<>();

    public CitaMedica() {
    }

    public int getId_Cita() {
        return id_Cita;
    }

    public void setId_Cita(int id_Cita) {
        this.id_Cita = id_Cita;
    }

    public PersonalMedico getPersonalMedico() {
        return personalMedico;
    }

    public void setPersonalMedico(PersonalMedico personalMedico) {
        this.personalMedico = personalMedico;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }


    public boolean isEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(boolean estadoCita) {
        this.estadoCita = estadoCita;
    }

    public List<DetalleCitaMedica> getDetCita() {
        return detCita;
    }

    public void setDetCita(List<DetalleCitaMedica> detCita) {
        this.detCita = detCita;
    }

    @Override
    public String toString() {
        return "CitaMedica{" + "id_Cita=" + id_Cita + ", personalMedico=" + personalMedico.getApellidoPat() + ", mascota=" + mascota.getNombre() + ", fechaCita=" + fechaCita + ", hora=" + hora + ", estadoCita=" + estadoCita + '}';
    }

   
    

    
    
    
    
}
