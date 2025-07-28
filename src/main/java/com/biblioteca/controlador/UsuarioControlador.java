package com.biblioteca.controlador;

import com.biblioteca.entidad.UsuarioBiblioteca;
import com.biblioteca.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @GetMapping
    public ResponseEntity<List<UsuarioBiblioteca>> obtenerTodosLosUsuarios() {
        try {
            List<UsuarioBiblioteca> usuarios = usuarioRepositorio.findByActivoTrue();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioBiblioteca> obtenerUsuarioPorId(@PathVariable Long id) {
        try {
            Optional<UsuarioBiblioteca> usuario = usuarioRepositorio.findById(id);
            if (usuario.isPresent() && usuario.get().getActivo()) {
                return ResponseEntity.ok(usuario.get());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioBiblioteca>> buscarUsuarios(@RequestParam String q) {
        try {
            List<UsuarioBiblioteca> usuarios = usuarioRepositorio.buscarUsuarios(q);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping
    public ResponseEntity<UsuarioBiblioteca> crearUsuario(@Valid @RequestBody UsuarioBiblioteca usuario) {
        try {
            // Verificar si el código de usuario ya existe
            if (usuarioRepositorio.existsByCodUsu(usuario.getCodUsu())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
            }
            
            usuario.setActivo(true);
            UsuarioBiblioteca usuarioGuardado = usuarioRepositorio.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioBiblioteca> actualizarUsuario(@PathVariable Long id, 
                                                             @Valid @RequestBody UsuarioBiblioteca usuarioActualizado) {
        try {
            Optional<UsuarioBiblioteca> usuarioExistente = usuarioRepositorio.findById(id);
            if (!usuarioExistente.isPresent() || !usuarioExistente.get().getActivo()) {
                return ResponseEntity.notFound().build();
            }
            
            // Verificar si el nuevo código de usuario ya existe (excepto para el usuario actual)
            if (!usuarioExistente.get().getCodUsu().equals(usuarioActualizado.getCodUsu()) &&
                usuarioRepositorio.existsByCodUsu(usuarioActualizado.getCodUsu())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            
            UsuarioBiblioteca usuario = usuarioExistente.get();
            usuario.setNombreUsu(usuarioActualizado.getNombreUsu());
            usuario.setApellPat(usuarioActualizado.getApellPat());
            usuario.setApellMat(usuarioActualizado.getApellMat());
            usuario.setCodUsu(usuarioActualizado.getCodUsu());
            usuario.setTelf(usuarioActualizado.getTelf());
            
            // Solo actualizar contraseña si se proporciona una nueva
            if (usuarioActualizado.getContrasena() != null && !usuarioActualizado.getContrasena().trim().isEmpty()) {
                usuario.setContrasena(usuarioActualizado.getContrasena());
            }
            
            UsuarioBiblioteca usuarioGuardado = usuarioRepositorio.save(usuario);
            return ResponseEntity.ok(usuarioGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        try {
            Optional<UsuarioBiblioteca> usuario = usuarioRepositorio.findById(id);
            if (!usuario.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            // Soft delete - marcar como inactivo en lugar de eliminar
            usuario.get().setActivo(false);
            usuarioRepositorio.save(usuario.get());
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}