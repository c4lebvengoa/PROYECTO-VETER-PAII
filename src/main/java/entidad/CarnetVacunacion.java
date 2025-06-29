/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author victo
 */
public class CarnetVacunacion {
    private int id_Carnet;
    private Date fecha_creacion;
    private List<DetalleCarnetVacunacion> detCarnet=new ArrayList<>();

    public CarnetVacunacion() {
    }

    public int getId_Carnet() {
        return id_Carnet;
    }

    public void setId_Carnet(int id_Carnet) {
        this.id_Carnet = id_Carnet;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public List<DetalleCarnetVacunacion> getDetCarnet() {
        return detCarnet;
    }

    public void setDetCarnet(List<DetalleCarnetVacunacion> detCarnet) {
        this.detCarnet = detCarnet;
    }

    
    @Override
    public String toString() {
        return "CarnetVacunacion{" + "id_Carnet=" + id_Carnet + ", fecha_creacion=" + fecha_creacion + '}';
    }
    
    
}
