/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author victo
 */
public class DetallePedido {
    
    private int cod_DetPedido; 
    private Producto producto;
    private int cantidad;
    private double importe;
    private double precioCompra;

    public DetallePedido() {
    }

    public int getCod_DetPedido() {
        return cod_DetPedido;
    }

    public void setCod_DetPedido(int cod_DetPedido) {
        this.cod_DetPedido = cod_DetPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "cod_DetPedido=" + cod_DetPedido + ", producto=" + producto.getNombre() + ", cantidad=" + cantidad + ", importe=" + importe + ", precioCompra=" + precioCompra + '}';
    }

    

   
    
    
}
