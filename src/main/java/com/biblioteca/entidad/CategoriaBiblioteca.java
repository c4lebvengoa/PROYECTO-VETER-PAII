package com.biblioteca.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "categorias")
public class CategoriaBiblioteca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    
    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(max = 100)
    @Column(name = "nombre_cat", nullable = false)
    private String nombreCat;
    
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros;
    
    // Constructors
    public CategoriaBiblioteca() {}
    
    public CategoriaBiblioteca(String nombreCat, String descripcion) {
        this.nombreCat = nombreCat;
        this.descripcion = descripcion;
    }
    
    // Getters and Setters
    public Long getIdCategoria() {
        return idCategoria;
    }
    
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String getNombreCat() {
        return nombreCat;
    }
    
    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Libro> getLibros() {
        return libros;
    }
    
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}