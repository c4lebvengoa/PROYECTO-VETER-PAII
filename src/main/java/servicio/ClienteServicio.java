/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import repositorio.ClienteRepositorio;
import vista.RegistrarCliente;

/**
 *
 * @author EMNA
 */
public class ClienteServicio implements InterfaceClienteServicio{
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicio(){
        clienteRepositorio=new ClienteRepositorio();
    }
  
    @Override
    public void listar(RegistrarCliente registrarCliente) {
        clienteRepositorio.listar(registrarCliente);
    }

    @Override
    public void crear(RegistrarCliente registrarCliente) {
        clienteRepositorio.crear(registrarCliente);
    }

    @Override
    public void ver(RegistrarCliente registrarCliente) {
        clienteRepositorio.ver(registrarCliente);
    }

    @Override
    public void buscar(RegistrarCliente registrarCliente) {
        clienteRepositorio.buscar(registrarCliente);
    }

    @Override
    public void editar(RegistrarCliente registrarCliente) {
        clienteRepositorio.editar(registrarCliente);
    }

    @Override
    public void eliminar(RegistrarCliente registrarCliente) {
        clienteRepositorio.eliminar(registrarCliente);
    }

}
