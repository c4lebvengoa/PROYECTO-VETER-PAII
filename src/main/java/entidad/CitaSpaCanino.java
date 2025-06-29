
package entidad;

import java.sql.Date;
import java.time.LocalTime;

public class CitaSpaCanino{
    private int id_CitaSpa;
    private PersonalSpa groomer;
    private Mascota mascota;
    private String tamano;
    private Date fecha;
    private LocalTime hora;
    private String tipoServicio;
    private String tipoBano;
    private String tipoCorte;
    private double precio;
    private int estado;
    
    public CitaSpaCanino() {
    }

    public int getId_CitaSpa() {
        return id_CitaSpa;
    }

    public void setId_CitaSpa(int id_CitaSpa) {
        this.id_CitaSpa = id_CitaSpa;
    }

    public PersonalSpa getGroomer() {
        return groomer;
    }

    public void setGroomer(PersonalSpa groomer) {
        this.groomer = groomer;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoBano() {
        return tipoBano;
    }

    public void setTipoBano(String tipoBano) {
        this.tipoBano = tipoBano;
    }

    public String getTipoCorte() {
        return tipoCorte;
    }

    public void setTipoCorte(String tipoCorte) {
        this.tipoCorte = tipoCorte;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CitaSpaCanino{" + "id_CitaSpa=" + id_CitaSpa + ", groomer=" + groomer + ", mascota=" + mascota + ", tamano=" + tamano + ", fecha=" + fecha + ", hora=" + hora + ", tipoServicio=" + tipoServicio + ", tipoBano=" + tipoBano + ", tipoCorte=" + tipoCorte + ", precio=" + precio + ", estado=" + estado + '}';
    }

    
    
}
