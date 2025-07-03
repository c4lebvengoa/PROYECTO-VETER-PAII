/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.util.Date;

/**
 *
 * @author victo
 */
public class DetalleCarnetVacunacion {
    
    private int id_DetalleCarnetVacunacion;
    private String tratamiento;
    private String nombreVacuna;
    private String tipoDesparasitacion;
    private Producto producto;
    private Date fechaApli;
    private Date proxApli;
    private int id_carnetVacuna;
    public DetalleCarnetVacunacion() {
    }
    public int getId_carnetVacuna() {
        return id_carnetVacuna;
    }

    public void setId_carnetVacuna(int id_carnetVacuna) {
        this.id_carnetVacuna = id_carnetVacuna;
    }
    

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }
    

    public int getId_DetalleCarnetVacunacion() {
        return id_DetalleCarnetVacunacion;
    }

    public void setId_DetalleCarnetVacunacion(int id_DetalleCarnetVacunacion) {
        this.id_DetalleCarnetVacunacion = id_DetalleCarnetVacunacion;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getTipoDesparasitacion() {
        return tipoDesparasitacion;
    }

    public void setTipoDesparasitacion(String tipoDesparasitacion) {
        this.tipoDesparasitacion = tipoDesparasitacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFechaApli() {
        return fechaApli;
    }

    public void setFechaApli(Date fechaApli) {
        this.fechaApli = fechaApli;
    }

    public Date getProxApli() {
        return proxApli;
    }

    public void setProxApli(Date proxApli) {
        this.proxApli = proxApli;
    }

    @Override
    public String toString() {
        return "DetalleCarnetVacunacion{" + "id_DetalleCarnetVacunacion=" + id_DetalleCarnetVacunacion + ", tratamiento=" + tratamiento + ", tipoDesparasitacion=" + tipoDesparasitacion + ", producto=" + producto.getNombre() + ", fechaApli=" + fechaApli + ", proxApli=" + proxApli + '}';
    }

   
    
    
    
}
