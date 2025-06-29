/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import servicio.ClienteServicio;
import servicio.DistritoServicio;
import vista.RegistrarCliente;

/**
 *
 * @author EMNA
 */
public class RegistarClienteControlador {
    private RegistrarCliente registrarCliente;
    private ClienteServicio clienteServicio;
    private DistritoServicio distritoServicio;
    
    public RegistarClienteControlador(RegistrarCliente registrarCliente){
        this.registrarCliente=registrarCliente;
        clienteServicio=new ClienteServicio();
        distritoServicio=new DistritoServicio();
    }
    
    public void listar(RegistrarCliente registrarCliente) throws Exception{
        clienteServicio.listar(registrarCliente);
    }
    
    public void ver(RegistrarCliente registrarCliente) throws Exception{
        clienteServicio.ver(registrarCliente);
    }
    
    public void buscar(RegistrarCliente registrarCliente) throws Exception{
        clienteServicio.buscar(registrarCliente);
    }
    
    public void crear(RegistrarCliente registrarCliente) throws Exception{
        clienteServicio.crear(registrarCliente);
    }
    
    public void editar(RegistrarCliente registrarCliente) throws Exception{
        clienteServicio.editar(registrarCliente);
    }
    
    public void eliminar(RegistrarCliente registrarCliente) throws Exception{
        clienteServicio.eliminar(registrarCliente);
    }
    
    public void listarDistritos() throws Exception{
        distritoServicio.listar(registrarCliente);
    }
   

}
