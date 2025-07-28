package com.biblioteca.controlador;

import com.biblioteca.entidad.Libro;
import com.biblioteca.entidad.Autor;
import com.biblioteca.entidad.CategoriaBiblioteca;
import com.biblioteca.repositorio.LibroRepositorio;
import com.biblioteca.repositorio.AutorRepositorio;
import com.biblioteca.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroControlador {
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    
    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodosLosLibros() {
        try {
            List<Libro> libros = libroRepositorio.findAll();
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
        try {
            Optional<Libro> libro = libroRepositorio.findById(id);
            if (libro.isPresent()) {
                return ResponseEntity.ok(libro.get());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> buscarLibros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false) Boolean disponible) {
        try {
            CategoriaBiblioteca categoria = null;
            if (categoriaId != null) {
                Optional<CategoriaBiblioteca> categoriaOpt = categoriaRepositorio.findById(categoriaId);
                if (categoriaOpt.isPresent()) {
                    categoria = categoriaOpt.get();
                }
            }
            
            List<Libro> libros = libroRepositorio.buscarLibros(titulo, categoria, disponible);
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/disponibles")
    public ResponseEntity<List<Libro>> obtenerLibrosDisponibles() {
        try {
            List<Libro> libros = libroRepositorio.findLibrosDisponibles();
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@Valid @RequestBody LibroRequest libroRequest) {
        try {
            // Verificar que el autor existe
            Optional<Autor> autor = autorRepositorio.findById(libroRequest.getAutorId());
            if (!autor.isPresent()) {
                return ResponseEntity.badRequest().build();
            }
            
            // Verificar que la categoría existe
            Optional<CategoriaBiblioteca> categoria = categoriaRepositorio.findById(libroRequest.getCategoriaId());
            if (!categoria.isPresent()) {
                return ResponseEntity.badRequest().build();
            }
            
            Libro libro = new Libro();
            libro.setTitulo(libroRequest.getTitulo());
            libro.setAnioPubli(libroRequest.getAnioPubli());
            libro.setCantTotal(libroRequest.getCantTotal());
            libro.setCantDisponible(libroRequest.getCantTotal()); // Inicialmente igual al total
            libro.setAutor(autor.get());
            libro.setCategoria(categoria.get());
            
            Libro libroGuardado = libroRepositorio.save(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(libroGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, 
                                                @Valid @RequestBody LibroRequest libroRequest) {
        try {
            Optional<Libro> libroExistente = libroRepositorio.findById(id);
            if (!libroExistente.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            // Verificar que el autor existe
            Optional<Autor> autor = autorRepositorio.findById(libroRequest.getAutorId());
            if (!autor.isPresent()) {
                return ResponseEntity.badRequest().build();
            }
            
            // Verificar que la categoría existe
            Optional<CategoriaBiblioteca> categoria = categoriaRepositorio.findById(libroRequest.getCategoriaId());
            if (!categoria.isPresent()) {
                return ResponseEntity.badRequest().build();
            }
            
            Libro libro = libroExistente.get();
            libro.setTitulo(libroRequest.getTitulo());
            libro.setAnioPubli(libroRequest.getAnioPubli());
            
            // Ajustar cantidad disponible si cambió la cantidad total
            if (!libro.getCantTotal().equals(libroRequest.getCantTotal())) {
                int diferencia = libroRequest.getCantTotal() - libro.getCantTotal();
                libro.setCantTotal(libroRequest.getCantTotal());
                libro.setCantDisponible(Math.max(0, libro.getCantDisponible() + diferencia));
            }
            
            libro.setAutor(autor.get());
            libro.setCategoria(categoria.get());
            
            Libro libroGuardado = libroRepositorio.save(libro);
            return ResponseEntity.ok(libroGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        try {
            Optional<Libro> libro = libroRepositorio.findById(id);
            if (!libro.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            libroRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Clase interna para el request
    public static class LibroRequest {
        private String titulo;
        private java.time.LocalDate anioPubli;
        private Integer cantTotal;
        private Long autorId;
        private Long categoriaId;
        
        // Getters y Setters
        public String getTitulo() { return titulo; }
        public void setTitulo(String titulo) { this.titulo = titulo; }
        
        public java.time.LocalDate getAnioPubli() { return anioPubli; }
        public void setAnioPubli(java.time.LocalDate anioPubli) { this.anioPubli = anioPubli; }
        
        public Integer getCantTotal() { return cantTotal; }
        public void setCantTotal(Integer cantTotal) { this.cantTotal = cantTotal; }
        
        public Long getAutorId() { return autorId; }
        public void setAutorId(Long autorId) { this.autorId = autorId; }
        
        public Long getCategoriaId() { return categoriaId; }
        public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
    }
}