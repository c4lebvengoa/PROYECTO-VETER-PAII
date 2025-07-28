package com.biblioteca.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Long idAutor;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 50)
    @Column(name = "apell_pat", nullable = false)
    private String apellPat;
    
    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(max = 50)
    @Column(name = "apell_mat", nullable = false)
    private String apellMat;
    
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros;
    
    // Constructors
    public Autor() {}
    
    public Autor(String nombre, String apellPat, String apellMat) {
        this.nombre = nombre;
        this.apellPat = apellPat;
        this.apellMat = apellMat;
    }
    
    // Getters and Setters
    public Long getIdAutor() {
        return idAutor;
    }
    
    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public List<Libro> getLibros() {
        return libros;
    }
    
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellPat + " " + apellMat;
    }
}