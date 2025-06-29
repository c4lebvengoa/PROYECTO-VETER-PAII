/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;


import repositorio.DistritoRepositorio;
import vista.RegistrarCliente;

/**
 *
 * @author EMNA
 */
public class DistritoServicio implements InterfaceDistritoServicio{
    private final DistritoRepositorio distritoRepositorio;

    public DistritoServicio() {
        distritoRepositorio = new DistritoRepositorio();
    }
    
    @Override
    public void listar(RegistrarCliente rc) throws Exception {
        distritoRepositorio.listar(rc);
    }
    
}
