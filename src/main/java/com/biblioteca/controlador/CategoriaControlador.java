package com.biblioteca.controlador;

import com.biblioteca.entidad.CategoriaBiblioteca;
import com.biblioteca.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaControlador {
    
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    
    @GetMapping
    public ResponseEntity<List<CategoriaBiblioteca>> obtenerTodasLasCategorias() {
        try {
            List<CategoriaBiblioteca> categorias = categoriaRepositorio.findAllOrderByNombre();
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaBiblioteca> obtenerCategoriaPorId(@PathVariable Long id) {
        try {
            Optional<CategoriaBiblioteca> categoria = categoriaRepositorio.findById(id);
            if (categoria.isPresent()) {
                return ResponseEntity.ok(categoria.get());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<CategoriaBiblioteca>> buscarCategorias(@RequestParam String q) {
        try {
            List<CategoriaBiblioteca> categorias = categoriaRepositorio.buscarCategorias(q);
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping
    public ResponseEntity<CategoriaBiblioteca> crearCategoria(@Valid @RequestBody CategoriaBiblioteca categoria) {
        try {
            // Verificar si el nombre de la categoría ya existe
            if (categoriaRepositorio.existsByNombreCat(categoria.getNombreCat())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
            }
            
            CategoriaBiblioteca categoriaGuardada = categoriaRepositorio.save(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaBiblioteca> actualizarCategoria(@PathVariable Long id, 
                                                                 @Valid @RequestBody CategoriaBiblioteca categoriaActualizada) {
        try {
            Optional<CategoriaBiblioteca> categoriaExistente = categoriaRepositorio.findById(id);
            if (!categoriaExistente.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            // Verificar si el nuevo nombre de categoría ya existe (excepto para la categoría actual)
            CategoriaBiblioteca categoria = categoriaExistente.get();
            if (!categoria.getNombreCat().equals(categoriaActualizada.getNombreCat()) &&
                categoriaRepositorio.existsByNombreCat(categoriaActualizada.getNombreCat())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            
            categoria.setNombreCat(categoriaActualizada.getNombreCat());
            categoria.setDescripcion(categoriaActualizada.getDescripcion());
            
            CategoriaBiblioteca categoriaGuardada = categoriaRepositorio.save(categoria);
            return ResponseEntity.ok(categoriaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        try {
            Optional<CategoriaBiblioteca> categoria = categoriaRepositorio.findById(id);
            if (!categoria.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            categoriaRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}