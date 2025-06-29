/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import vista.*;

/**
 *
 * @author EMNA
 */
public class MenuServicio {
    private final MenuPrincipal menuprincipal;
    private final RegistrarCliente registrarcliente;
    private final RegistrarProveedor registrarProveedor;
    private final RegistrarProducto registrarProducto;
    private final Servicios servicios;
    private final GestionUsuarios gestionUsuarios;

    public MenuServicio(MenuPrincipal menuprincipal) {
        this.menuprincipal = menuprincipal;
        this.registrarcliente = new RegistrarCliente();
        this.registrarProveedor=new RegistrarProveedor();
        this.registrarProducto=new RegistrarProducto();
        this.servicios=new Servicios();
        this.gestionUsuarios=new GestionUsuarios();
    }
    
    public void gestionUsuarios(){
        gestionUsuarios.setVisible(true);
        menuprincipal.dispose();
    }
    public void registrarCliente(){
        registrarcliente.setVisible(true);
        menuprincipal.dispose();
    }
    public void registrarProducto(){
        registrarProducto.setVisible(true);
        menuprincipal.dispose();
    }
    public void registrarProveedor(){
        registrarProveedor.setVisible(true);
        menuprincipal.dispose();
    }
    public void servicios(){
        servicios.setVisible(true);
        menuprincipal.dispose();
    }
    
    
    
    
    
}
