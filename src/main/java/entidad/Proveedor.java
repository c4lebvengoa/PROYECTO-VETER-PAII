/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author victo
 */
public class Proveedor {
    
    private int cod_Proveedor;
    private String razonSocial;
    private String ruc;
    private String representante;
    private int celularRepre;
    private String correo;
    private int celular;
    private String direccion;
    private String pais;
    

    public Proveedor() {
    }

    public int getCod_Proveedor() {
        return cod_Proveedor;
    }

    public void setCod_Proveedor(int cod_Proveedor) {
        this.cod_Proveedor = cod_Proveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public int getCelularRepre() {
        return celularRepre;
    }

    public void setCelularRepre(int celularRepre) {
        this.celularRepre = celularRepre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "cod_Proveedor=" + cod_Proveedor + ", razonSocial=" + razonSocial + ", ruc=" + ruc + ", representante=" + representante + ", celularRepre=" + celularRepre + ", correo=" + correo + ", celular=" + celular + ", direccion=" + direccion + ", pais=" + pais + '}';
    }

    
    
    
    
}
