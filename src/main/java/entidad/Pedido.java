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
public class Pedido {
    
    private int cod_Pedido;
    private Proveedor proveedor;
    private Date fechaSolicitud;
    private Date fechaRecepcion;
    private List<DetallePedido> detPedido=new ArrayList<>();
    private double importeTotal;
    private boolean estado;
    
    public Pedido() {
    }

    public int getCod_Pedido() {
        return cod_Pedido;
    }

    public void setCod_Pedido(int cod_Pedido) {
        this.cod_Pedido = cod_Pedido;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public List<DetallePedido> getDetPedido() {
        return detPedido;
    }

    public void setDetPedido(List<DetallePedido> detPedido) {
        this.detPedido = detPedido;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cod_Pedido=" + cod_Pedido + ", proveedor=" + proveedor.getRazonSocial() + ", fechaSolicitud=" + fechaSolicitud + ", fechaRecepcion=" + fechaRecepcion + ", importeTotal=" + importeTotal + ", estado=" + estado + '}';
    }

   

}
