package com.biblioteca.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "libros")
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long idLibro;
    
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 200)
    @Column(name = "titulo", nullable = false)
    private String titulo;
    
    @NotNull(message = "El año de publicación es obligatorio")
    @Column(name = "anio_publi", nullable = false)
    private LocalDate anioPubli;
    
    @NotNull(message = "La cantidad total es obligatoria")
    @Min(value = 1, message = "La cantidad total debe ser mayor a 0")
    @Column(name = "cant_total", nullable = false)
    private Integer cantTotal;
    
    @Column(name = "cant_disponible", nullable = false)
    private Integer cantDisponible;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "libros"})
    private Autor autor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "libros"})
    private CategoriaBiblioteca categoria;
    
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("libro")
    private List<Prestamo> prestamos;
    
    // Constructors
    public Libro() {}
    
    public Libro(String titulo, LocalDate anioPubli, Integer cantTotal, Autor autor, CategoriaBiblioteca categoria) {
        this.titulo = titulo;
        this.anioPubli = anioPubli;
        this.cantTotal = cantTotal;
        this.cantDisponible = cantTotal;
        this.autor = autor;
        this.categoria = categoria;
    }
    
    // Getters and Setters
    public Long getIdLibro() {
        return idLibro;
    }
    
    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public LocalDate getAnioPubli() {
        return anioPubli;
    }
    
    public void setAnioPubli(LocalDate anioPubli) {
        this.anioPubli = anioPubli;
    }
    
    public Integer getCantTotal() {
        return cantTotal;
    }
    
    public void setCantTotal(Integer cantTotal) {
        this.cantTotal = cantTotal;
    }
    
    public Integer getCantDisponible() {
        return cantDisponible;
    }
    
    public void setCantDisponible(Integer cantDisponible) {
        this.cantDisponible = cantDisponible;
    }
    
    public Autor getAutor() {
        return autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public CategoriaBiblioteca getCategoria() {
        return categoria;
    }
    
    public void setCategoria(CategoriaBiblioteca categoria) {
        this.categoria = categoria;
    }
    
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
    public boolean isDisponible() {
        return cantDisponible > 0;
    }
}