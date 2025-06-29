/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EMNA
 */
public class DetalleCitaMedica {
    private Procedimiento procedimiento;
    private List<PersonalMedico> detPersonal=new ArrayList<>();
    private List<Producto> detMateriales=new ArrayList<>();

    public DetalleCitaMedica() {
    }

    public Procedimiento getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
    }

    public List<PersonalMedico> getDetPersonal() {
        return detPersonal;
    }

    public void setDetPersonal(List<PersonalMedico> detPersonal) {
        this.detPersonal = detPersonal;
    }

    public List<Producto> getDetMateriales() {
        return detMateriales;
    }

    public void setDetMateriales(List<Producto> detMateriales) {
        this.detMateriales = detMateriales;
    }

    @Override
    public String toString() {
        return "DetalleCitaMedica{" + "procedimiento=" + procedimiento.getNombre() + '}';
    }

    
    
    
}
