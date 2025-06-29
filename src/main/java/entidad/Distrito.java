/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author victo
 */
public class Distrito {
    
    private int id_Distrito;
    private String nombre;

    public Distrito() {
    }

    public int getId_Distrito() {
        return id_Distrito;
    }

    public void setId_Distrito(int idDistrito) {
        this.id_Distrito = idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Distrito{" + "id_Distrito=" + id_Distrito + ", nombre=" + nombre + '}';
    }
    
    
}
