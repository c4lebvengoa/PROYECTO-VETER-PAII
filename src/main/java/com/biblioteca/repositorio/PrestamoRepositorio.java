package com.biblioteca.repositorio;

import com.biblioteca.entidad.Prestamo;
import com.biblioteca.entidad.UsuarioBiblioteca;
import com.biblioteca.entidad.Libro;
import com.biblioteca.entidad.Prestamo.EstadoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {
    
    List<Prestamo> findByUsuario(UsuarioBiblioteca usuario);
    
    List<Prestamo> findByLibro(Libro libro);
    
    List<Prestamo> findByEstado(EstadoPrestamo estado);
    
    @Query("SELECT p FROM Prestamo p WHERE p.estado = 'ACTIVO' AND p.fechaDevolucion < :fecha")
    List<Prestamo> findPrestamosVencidos(@Param("fecha") LocalDate fecha);
    
    @Query("SELECT p FROM Prestamo p WHERE p.usuario = :usuario AND p.estado = 'ACTIVO'")
    List<Prestamo> findPrestamosActivosByUsuario(@Param("usuario") UsuarioBiblioteca usuario);
    
    @Query("SELECT p FROM Prestamo p WHERE p.libro = :libro AND p.estado = 'ACTIVO'")
    List<Prestamo> findPrestamosActivosByLibro(@Param("libro") Libro libro);
    
    @Query("SELECT COUNT(p) FROM Prestamo p WHERE p.estado = 'ACTIVO'")
    Long contarPrestamosActivos();
    
    @Query("SELECT COUNT(p) FROM Prestamo p WHERE p.estado = 'ACTIVO' AND p.fechaDevolucion < :fecha")
    Long contarPrestamosVencidos(@Param("fecha") LocalDate fecha);
    
    @Query("SELECT p FROM Prestamo p WHERE " +
           "(:usuario IS NULL OR p.usuario = :usuario) AND " +
           "(:libro IS NULL OR p.libro = :libro) AND " +
           "(:estado IS NULL OR p.estado = :estado) AND " +
           "(:fechaInicio IS NULL OR p.fechaPrestamo >= :fechaInicio) AND " +
           "(:fechaFin IS NULL OR p.fechaPrestamo <= :fechaFin)")
    List<Prestamo> buscarPrestamos(@Param("usuario") UsuarioBiblioteca usuario,
                                 @Param("libro") Libro libro,
                                 @Param("estado") EstadoPrestamo estado,
                                 @Param("fechaInicio") LocalDate fechaInicio,
                                 @Param("fechaFin") LocalDate fechaFin);
}