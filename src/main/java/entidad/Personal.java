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
public class Personal {
        
    protected int cod_Personal;
    protected String apellidoPat;
    protected String apellidoMat;
    protected String nombre;
    protected String tipoDoc;
    protected String numDoc;
    protected int celular;
    protected String correo;
    protected String direccion;
    protected Date fechaIngreso;
    protected double sueldo;
    protected String seguroVida;
    protected String cv;
    protected Distrito distrito;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public Personal() {
    }

    public int getCod_Personal() {
        return cod_Personal;
    }

    public void setCod_Personal(int cod_Personal) {
        this.cod_Personal = cod_Personal;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getSeguroVida() {
        return seguroVida;
    }

    public void setSeguroVida(String seguroVida) {
        this.seguroVida = seguroVida;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    
    public double sueldoNeto(){
        return sueldo;
    }
    
    @Override
    public String toString() {
        return "Personal{" + "cod_Personal=" + cod_Personal + ", apellidoPat=" + apellidoPat + ", apellidoMat=" + apellidoMat + ", tipoDoc=" + tipoDoc + ", numDoc=" + numDoc + ", celular=" + celular + ", correo=" + correo + ", direccion=" + direccion + ", fechaIngreso=" + fechaIngreso + ", sueldo=" + sueldo + ", seguroVida=" + seguroVida + ", cv=" + cv + ", distrito=" + distrito.getNombre() + '}';
    }

      
}
