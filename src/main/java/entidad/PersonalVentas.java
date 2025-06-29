/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author victo
 */
public class PersonalVentas extends Personal {    
    private double comisionVent;

    public PersonalVentas() {
    }


    public double getComisionVent() {
        return comisionVent;
    }

    public void setComisionVent(double comisionVent) {
        this.comisionVent = comisionVent;
    }

    @Override
    public double sueldoNeto() {
        return sueldo+comisionVent;
    }
   
    
    @Override
    public String toString() {
        return super.toString() + " PersonalVentas{" + "comisionVent=" + comisionVent + '}';
    }
}
