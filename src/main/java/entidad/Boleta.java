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
public class Boleta {
    
    private int id_Boleta;
    private Date fechaEmision;
    private Cliente cliente;
    private PersonalVentas personalVentas;
    private String formaDePago;
    private double importeTotal;
    private List<DetalleBoleta> detBol=new ArrayList<>();

    public Boleta() {
    }

    public int getId_Boleta() {
        return id_Boleta;
    }

    public void setId_Boleta(int id_Boleta) {
        this.id_Boleta = id_Boleta;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PersonalVentas getPersonalVentas() {
        return personalVentas;
    }

    public void setPersonalVentas(PersonalVentas personalVentas) {
        this.personalVentas = personalVentas;
    }

    public List<DetalleBoleta> getDetBol() {
        return detBol;
    }

    public void setDetBol(List<DetalleBoleta> detBol) {
        this.detBol = detBol;
    }

    @Override
    public String toString() {
        return "Boleta{" + "id_Boleta=" + id_Boleta + ", fechaEmision=" + fechaEmision + ", propietario=" + cliente.getNombre() + ", personalVentas=" + personalVentas.getApellidoPat() + ", formaDePago=" + formaDePago + ", importeTotal=" + importeTotal + '}';
    }

    
}
