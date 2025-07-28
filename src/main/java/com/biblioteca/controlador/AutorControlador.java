package com.biblioteca.controlador;

import com.biblioteca.entidad.Autor;
import com.biblioteca.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
@CrossOrigin(origins = "*")
public class AutorControlador {
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @GetMapping
    public ResponseEntity<List<Autor>> obtenerTodosLosAutores() {
        try {
            List<Autor> autores = autorRepositorio.findAllOrderByApellidos();
            return ResponseEntity.ok(autores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorPorId(@PathVariable Long id) {
        try {
            Optional<Autor> autor = autorRepositorio.findById(id);
            if (autor.isPresent()) {
                return ResponseEntity.ok(autor.get());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Autor>> buscarAutores(@RequestParam String q) {
        try {
            List<Autor> autores = autorRepositorio.buscarAutores(q);
            return ResponseEntity.ok(autores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Autor> crearAutor(@Valid @RequestBody Autor autor) {
        try {
            Autor autorGuardado = autorRepositorio.save(autor);
            return ResponseEntity.status(HttpStatus.CREATED).body(autorGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id, 
                                                @Valid @RequestBody Autor autorActualizado) {
        try {
            Optional<Autor> autorExistente = autorRepositorio.findById(id);
            if (!autorExistente.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            Autor autor = autorExistente.get();
            autor.setNombre(autorActualizado.getNombre());
            autor.setApellPat(autorActualizado.getApellPat());
            autor.setApellMat(autorActualizado.getApellMat());
            
            Autor autorGuardado = autorRepositorio.save(autor);
            return ResponseEntity.ok(autorGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
        try {
            Optional<Autor> autor = autorRepositorio.findById(id);
            if (!autor.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            autorRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}