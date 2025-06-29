/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.RegistrarCliente;


/**
 *
 * @author EMNA
 */
public class ClienteRepositorio implements InterfaceCliente{

    @Override
    public void listar(RegistrarCliente registrarCliente) {
        System.out.println("call listar() ClienteRepositorio");
        
        try{
            DefaultTableModel modelo=new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"COD","Apellido paterno","Apellido materno","Nombres","Tipo doc","Nro doc","Celular","Correo","Direccion","Distrito"}
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            
            
            
            registrarCliente.getTablaclientes().setModel(modelo);
            
            Connection con=ConexionBD.conectar();
            String sql="""
                            SELECT c.cod_cliente,
                                   c.ap_paterno_cli,
                                   c.ap_materno_cli,
                                   c.nombres_cli,
                                   c.tipo_doc_cli,
                                   c.nro_doc_cli,
                                   c.celular_cli,
                                   c.correo_cli,
                                   c.direccion_cli,  
                                   d.nombre_dis
                            FROM Cliente c
                            INNER JOIN Distrito d
                            ON c.cod_distrito=d.cod_distrito;
                       """;

            PreparedStatement stmt=con.prepareStatement(sql);
            
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Object[] fila=new Object[10];
                for (int i = 0; i < 10; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }           
            rs.close();
            stmt.close();
            con.close();
            
        }catch(SQLException e){
            System.err.println(e);
        }
           
    }

    @Override
    public void crear(RegistrarCliente registrarCliente) {
        System.out.println("call crear() ClienteRepositorio");
        try{
            Connection con=ConexionBD.conectar();
            
            String sql="""
                            INSERT INTO Cliente(ap_paterno_cli,
                                                ap_materno_cli,
                                                nombres_cli,
                                                tipo_doc_cli,
                                                nro_doc_cli,
                                                celular_cli,
                                                correo_cli,
                                                direccion_cli,
                                                cod_distrito)
                            VALUES(?,?,?,?,?,?,?,?,?);
                       """;
            PreparedStatement stmt=con.prepareStatement(sql);
            
            stmt.setString(1,registrarCliente.txtappat.getText());
            stmt.setString(2,registrarCliente.txtapmat.getText());
            stmt.setString(3,registrarCliente.txtnom.getText());
            stmt.setString(4,registrarCliente.cbxtipodoc.getSelectedItem().toString());
            stmt.setString(5,registrarCliente.txtnumdoc.getText());
            stmt.setString(6,registrarCliente.txtcel.getText());
            stmt.setString(7,registrarCliente.txtcorreo.getText());
            stmt.setString(8,registrarCliente.txtdireccion.getText());
            stmt.setInt(9,registrarCliente.cbxdistrito.getSelectedIndex());
            
            int resultado=stmt.executeUpdate();
            
            //Parte visual
            
            
            String cod=null;
            
            String nrodoc=registrarCliente.txtnumdoc.getText();
            
            String sql1="SELECT cod_cliente FROM Cliente WHERE nro_doc_cli="+nrodoc;
            
            PreparedStatement stmt1=con.prepareStatement(sql1);
            
            ResultSet rs1=stmt1.executeQuery();
            
            while(rs1.next()){
                cod=rs1.getString("cod_cliente");
            }
            
            DefaultTableModel modelo= (DefaultTableModel)registrarCliente.tablaclientes.getModel();
           
            Object[] fila={
                cod,
                registrarCliente.txtappat.getText(),
                registrarCliente.txtapmat.getText(),
                registrarCliente.txtnom.getText(),
                registrarCliente.cbxtipodoc.getSelectedItem().toString(),
                registrarCliente.txtnumdoc.getText(),
                registrarCliente.txtcel.getText(),
                registrarCliente.txtcorreo.getText(),
                registrarCliente.txtdireccion.getText(),
                registrarCliente.cbxdistrito.getSelectedItem()
            };
            modelo.addRow(fila);

            if(resultado==1){  
                JOptionPane.showMessageDialog(null,"El cliente se ha creado correctamente");
                System.out.println("Se creo el cliente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al crear el cliente","",JOptionPane.WARNING_MESSAGE);
                throw new SQLException("No se pudo crear el cliente");
            }
           stmt.close();
           con.close();
           
          
           
        }catch(SQLException e){
            System.err.println(e);
        }
    }

    @Override
    public void ver(RegistrarCliente registrarCliente) {
        System.out.println("call buscar() ClienteRepositorio");
        
        try{
            Connection con=ConexionBD.conectar();
            
            String sql="""
                             SELECT c.cod_cliente,
                                    c.ap_paterno_cli,
                                    c.ap_materno_cli,
                                    c.nombres_cli,
                                    c.tipo_doc_cli,
                                    c.nro_doc_cli,
                                    c.celular_cli,
                                    c.correo_cli,
                                    c.direccion_cli,  
                                    c.cod_distrito,
                                    d.nombre_dis
                             FROM Cliente c
                             INNER JOIN Distrito d
                             ON c.cod_distrito=d.cod_distrito 
                             WHERE cod_cliente=?;
                       """;
            
            PreparedStatement stmt=con.prepareStatement(sql);
            
            int fila=registrarCliente.getTablaclientes().getSelectedRow();
            
            String cod_cliente=String.valueOf(registrarCliente.getTablaclientes().getValueAt(fila, 0));
            
            System.out.println(cod_cliente);
            stmt.setString(1,cod_cliente); 
            
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                registrarCliente.txtappat.setText(rs.getString("ap_paterno_cli"));
                registrarCliente.txtapmat.setText(rs.getString("ap_materno_cli"));
                registrarCliente.txtnom.setText(rs.getString("nombres_cli"));
                registrarCliente.cbxtipodoc.setSelectedItem(rs.getString("tipo_doc_cli"));
                registrarCliente.txtnumdoc.setText(rs.getString("nro_doc_cli"));
                registrarCliente.txtcel.setText(rs.getString("celular_cli"));
                registrarCliente.txtcorreo.setText(rs.getString("correo_cli"));
                registrarCliente.txtdireccion.setText(rs.getString("direccion_cli"));
                registrarCliente.cbxdistrito.setSelectedItem(rs.getString("nombre_dis"));
            }
          
            rs.close();
            stmt.close();
            con.close();
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }

    @Override
    public void buscar(RegistrarCliente registrarCliente) {
        System.out.println("call buscar() ClienteRepositorio");
        
        try{
            
            
            String nrodoc=registrarCliente.txtbuscar.getText();
            
            Connection con=ConexionBD.conectar();
            
            String sql="""
                             SELECT c.cod_cliente,
                                    c.ap_paterno_cli,
                                    c.ap_materno_cli,
                                    c.nombres_cli,
                                    c.tipo_doc_cli,
                                    c.nro_doc_cli,
                                    c.celular_cli,
                                    c.correo_cli,
                                    c.direccion_cli,  
                                    d.nombre_dis
                             FROM Cliente c
                             INNER JOIN Distrito d
                             ON c.cod_distrito=d.cod_distrito 
                             WHERE nro_doc_cli=?;
                       """;
            
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,nrodoc); 
            
            ResultSet rs=stmt.executeQuery();
            
            DefaultTableModel modelo=(DefaultTableModel)registrarCliente.tablaclientes.getModel();
            modelo.setRowCount(0);
            
            while(rs.next()){
                Object[] fila=new Object[10];
                for (int i = 0; i < 10; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
                  
            rs.close();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Búsqueda exitosa");
            System.out.println("Busqueda exitosa "+nrodoc);
        }catch(SQLException e){
            System.err.println(e);
        }
    }

    @Override
    public void editar(RegistrarCliente registrarCliente) {
        System.out.println("call editar() ClienteRepositorio");
        try {
            Connection con=ConexionBD.conectar();
            String sql="""
                            UPDATE Cliente
                            SET celular_cli=?,
                                correo_cli=?,
                                direccion_cli=?,
                                cod_distrito=?
                            WHERE cod_cliente=?;
                       """;
            PreparedStatement stmt=con.prepareStatement(sql);
            
            int fila=registrarCliente.tablaclientes.getSelectedRow();
            int cod_cliente=(int)registrarCliente.tablaclientes.getValueAt(fila,0);
            
            stmt.setString(1,registrarCliente.txtcel.getText());
            stmt.setString(2,registrarCliente.txtcorreo.getText());
            stmt.setString(3,registrarCliente.txtdireccion.getText());
            stmt.setInt(4,registrarCliente.cbxdistrito.getSelectedIndex());
            stmt.setInt(5,cod_cliente);
            
            int resultado=stmt.executeUpdate();
            
            //Parte visual
            
            DefaultTableModel modelo=(DefaultTableModel)registrarCliente.tablaclientes.getModel();
            
            modelo.setValueAt(registrarCliente.txtcel.getText(), fila, 6);
            modelo.setValueAt(registrarCliente.txtcorreo.getText(), fila, 7);
            modelo.setValueAt(registrarCliente.txtdireccion.getText(), fila, 8);
            modelo.setValueAt(registrarCliente.cbxdistrito.getSelectedItem().toString(), fila, 9);
            
            if(resultado==1){
                JOptionPane.showMessageDialog(null,"El cliente se ha editado correctamente cod="+cod_cliente);
                System.out.println("Se edito el cliente"+cod_cliente);
            }else{
                JOptionPane.showMessageDialog(null, "Error al editar el cliente","",JOptionPane.WARNING_MESSAGE);
                throw new SQLException("No se pudo editar el cliente");
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void eliminar(RegistrarCliente registrarCliente) {
        System.out.println("call eliminar() ClienteRepositorio");
        try{
            Connection con=ConexionBD.conectar();
            
            String sql="""
                            DELETE 
                            FROM Cliente
                            WHERE cod_cliente=?;
                       """;
            
            PreparedStatement stmt=con.prepareStatement(sql);
            
            int fila=registrarCliente.getTablaclientes().getSelectedRow();
            
            String cod_cliente=String.valueOf(registrarCliente.getTablaclientes().getValueAt(fila, 0));
            
            stmt.setString(1,cod_cliente);
            
            int resultado=stmt.executeUpdate();
            
            if(resultado==1){
                System.out.println("Se elimino el cliente con id="+cod_cliente);
                JOptionPane.showMessageDialog(null,"El cliente se ha eliminado correctamente cod="+cod_cliente);
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar el cliente","",JOptionPane.WARNING_MESSAGE);
                throw new Exception("No se pudo eliminar el cliente");
            }
            
            stmt.close();
            con.close();
            
            DefaultTableModel modelo=(DefaultTableModel) registrarCliente.getTablaclientes().getModel();
            modelo.removeRow(fila);
            
        }catch(SQLException e){
            System.err.println(e);
        }catch(Exception e){
            
        }
    }    
}
