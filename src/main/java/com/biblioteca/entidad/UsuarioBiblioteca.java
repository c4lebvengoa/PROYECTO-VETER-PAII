package com.biblioteca.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class UsuarioBiblioteca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usu")
    private Long idUsu;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    @Column(name = "nombre_usu", nullable = false)
    private String nombreUsu;
    
    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 50)
    @Column(name = "apell_pat", nullable = false)
    private String apellPat;
    
    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(max = 50)
    @Column(name = "apell_mat", nullable = false)
    private String apellMat;
    
    @NotBlank(message = "El código de usuario es obligatorio")
    @Size(max = 20)
    @Column(name = "cod_usu", nullable = false, unique = true)
    private String codUsu;
    
    @Size(max = 15)
    @Column(name = "telf")
    private String telf;
    
    @Size(max = 255)
    @Column(name = "contrasena")
    private String contrasena;
    
    @Column(name = "activo")
    private Boolean activo = true;
    
    // Constructors
    public UsuarioBiblioteca() {}
    
    public UsuarioBiblioteca(String nombreUsu, String apellPat, String apellMat, String codUsu, String telf) {
        this.nombreUsu = nombreUsu;
        this.apellPat = apellPat;
        this.apellMat = apellMat;
        this.codUsu = codUsu;
        this.telf = telf;
    }
    
    // Getters and Setters
    public Long getIdUsu() {
        return idUsu;
    }
    
    public void setIdUsu(Long idUsu) {
        this.idUsu = idUsu;
    }
    
    public String getNombreUsu() {
        return nombreUsu;
    }
    
    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }
    
    public String getApellPat() {
        return apellPat;
    }
    
    public void setApellPat(String apellPat) {
        this.apellPat = apellPat;
    }
    
    public String getApellMat() {
        return apellMat;
    }
    
    public void setApellMat(String apellMat) {
        this.apellMat = apellMat;
    }
    
    public String getCodUsu() {
        return codUsu;
    }
    
    public void setCodUsu(String codUsu) {
        this.codUsu = codUsu;
    }
    
    public String getTelf() {
        return telf;
    }
    
    public void setTelf(String telf) {
        this.telf = telf;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}