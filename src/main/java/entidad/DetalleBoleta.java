/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author victo
 */
public class DetalleBoleta {
    
    private int id_DetalleBoleta;
    private Producto producto;
    private Procedimiento procedimiento;
    private CitaMedica citaMedica;
    private CitaSpaCanino citaSpaCanino;
    private int cantidad;
    private double importe;

    public DetalleBoleta() {
    }

    public int getId_DetalleBoleta() {
        return id_DetalleBoleta;
    }

    public void setId_DetalleBoleta(int id_DetalleBoleta) {
        this.id_DetalleBoleta = id_DetalleBoleta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Procedimiento getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
    }

    public CitaMedica getCitaMedica() {
        return citaMedica;
    }

    public void setCitaMedica(CitaMedica citaMedica) {
        this.citaMedica = citaMedica;
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

    public CitaSpaCanino getCitaSpaCanino() {
        return citaSpaCanino;
    }

    public void setCitaSpaCanino(CitaSpaCanino citaSpaCanino) {
        this.citaSpaCanino = citaSpaCanino;
    }

    @Override
    public String toString() {
        return "DetalleBoleta{" + "id_DetalleBoleta=" + id_DetalleBoleta + ", producto=" + producto.getNombre() + ", procedimiento=" + procedimiento.getCodProcedimiento() + ", citaMedica=" + citaMedica.getId_Cita() + ", cantidad=" + cantidad + ", importe=" + importe + '}';
    }

    
   
    
    
}
