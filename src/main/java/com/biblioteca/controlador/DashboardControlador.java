package com.biblioteca.controlador;

import com.biblioteca.repositorio.UsuarioRepositorio;
import com.biblioteca.repositorio.LibroRepositorio;
import com.biblioteca.repositorio.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardControlador {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    @Autowired
    private PrestamoRepositorio prestamoRepositorio;
    
    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Object>> obtenerEstadisticas() {
        try {
            Map<String, Object> estadisticas = new HashMap<>();
            
            // Contar usuarios activos
            Long totalUsuarios = usuarioRepositorio.findByActivoTrue().stream().count();
            estadisticas.put("totalUsuarios", totalUsuarios);
            
            // Contar total de ejemplares de libros
            Long totalEjemplares = libroRepositorio.contarTotalEjemplares();
            estadisticas.put("totalLibros", totalEjemplares != null ? totalEjemplares : 0);
            
            // Contar préstamos activos
            Long prestamosActivos = prestamoRepositorio.contarPrestamosActivos();
            estadisticas.put("totalPrestamos", prestamosActivos != null ? prestamosActivos : 0);
            
            // Contar préstamos vencidos
            Long prestamosVencidos = prestamoRepositorio.contarPrestamosVencidos(LocalDate.now());
            estadisticas.put("totalVencidos", prestamosVencidos != null ? prestamosVencidos : 0);
            
            return ResponseEntity.ok(estadisticas);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}