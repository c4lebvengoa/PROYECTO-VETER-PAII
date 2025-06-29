/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorio;

import vista.RegistrarCliente;
/**
 *
 * @author EMNA
 */
public interface InterfaceCliente {
    void listar(RegistrarCliente registrarCliente);
    void crear(RegistrarCliente registrarCliente);
    void ver(RegistrarCliente registrarCliente);
    void buscar(RegistrarCliente registrarCliente);
    void editar(RegistrarCliente registrarCliente);
    void eliminar(RegistrarCliente registrarCliente);
}
