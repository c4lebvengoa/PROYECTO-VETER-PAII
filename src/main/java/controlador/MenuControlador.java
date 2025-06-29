/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.*;
import vista.*;
import servicio.*;
public class MenuControlador implements ActionListener,MouseListener{
    private final MenuPrincipal menuPrincipal;
    private final MenuServicio menuServicio;

    public MenuControlador(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        this.menuServicio = new MenuServicio(menuPrincipal);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuServicio.gestionUsuarios();
    }
    
    public void actionPerformedClientes(ActionEvent e) {
        menuServicio.registrarCliente();
    }
    
    public void actionPerformedProductos(ActionEvent e) {
        menuServicio.registrarProducto();
    }
    
    public void actionPerformedServicios(ActionEvent e) {
        menuServicio.servicios();
    }
    
    public void actionPerformedProveedores(ActionEvent e) {
        menuServicio.registrarProveedor();
    }
    
}
