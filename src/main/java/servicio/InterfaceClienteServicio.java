/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import entidad.Cliente;
import java.util.List;
import vista.RegistrarCliente;

/**
 *
 * @author EMNA
 */
public interface InterfaceClienteServicio {
    void listar(RegistrarCliente registrarCliente);
    void crear(RegistrarCliente registrarCliente);
    void ver(RegistrarCliente registrarCliente);
    void buscar(RegistrarCliente registrarCliente);
    void editar(RegistrarCliente registrarCliente);
    void eliminar(RegistrarCliente registrarCliente);
}
