/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author EMNA
 */
public class PersonalSpa extends Personal{
    private double bonoDemanda;

    public PersonalSpa() {
    }
    
    public PersonalSpa(int codPersonalSpa, String nombre) {
        this.cod_Personal = codPersonalSpa;
        this.nombre = nombre;
    }


    public double getBonoDemanda() {
        return bonoDemanda;
    }

    public void setBonoDemanda(double bonoDemanda) {
        this.bonoDemanda = bonoDemanda;
    }

    @Override
    public double sueldoNeto() {
        return sueldo+bonoDemanda;
    }

    @Override
    public String toString() {
        return super.toString()+"PersonalSpa{" + "bonoDemanda=" + bonoDemanda + '}';
    }
    
    
    
}
