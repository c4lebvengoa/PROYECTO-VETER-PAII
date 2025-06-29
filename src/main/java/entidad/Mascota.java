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
public class Mascota {
    
    private int idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private String descripcion;
    private Date fechaNac;
    private int edad;

    public Mascota() {
    }
   
    public int getId_Mascota() {
        return idMascota;
    }

    public void setId_Mascota(int id_Mascota) {
        this.idMascota = id_Mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Mascota{" + "id_Mascota=" + idMascota + ", nombre=" + nombre + ", sexo=" + sexo + ", especie=" + especie + ", raza=" + raza + ", descripcion=" + descripcion + ", fechaNac=" + fechaNac + ", edad=" + edad + '}';
    }
    
    
}
