/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;


/**
 *
 * @author victo
 */
public class Procedimiento {
    
    private int cod_Procedimiento;
    private String nombre;
    private String tipo;
    private double costo;

    public Procedimiento() {
    }

    public int getCodProcedimiento() {
        return cod_Procedimiento;
    }

    public void setCodProcedimiento(int codProcedimiento) {
        this.cod_Procedimiento = codProcedimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
 

    @Override
    public String toString() {
        return "Procedimiento{" + "codProcedimiento=" + cod_Procedimiento + ", nombre=" + nombre + ", tipo=" + tipo + ", costo=" + costo + '}';
    }
    
    
}
