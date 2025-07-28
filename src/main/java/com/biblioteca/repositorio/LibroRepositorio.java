package com.biblioteca.repositorio;

import com.biblioteca.entidad.Libro;
import com.biblioteca.entidad.CategoriaBiblioteca;
import com.biblioteca.entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    
    @Query("SELECT l FROM Libro l WHERE " +
           "(:titulo IS NULL OR LOWER(l.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))) AND " +
           "(:categoria IS NULL OR l.categoria = :categoria) AND " +
           "(:disponible IS NULL OR " +
           "(:disponible = true AND l.cantDisponible > 0) OR " +
           "(:disponible = false AND l.cantDisponible = 0))")
    List<Libro> buscarLibros(@Param("titulo") String titulo, 
                           @Param("categoria") CategoriaBiblioteca categoria, 
                           @Param("disponible") Boolean disponible);
    
    List<Libro> findByAutor(Autor autor);
    
    List<Libro> findByCategoria(CategoriaBiblioteca categoria);
    
    @Query("SELECT l FROM Libro l WHERE l.cantDisponible > 0")
    List<Libro> findLibrosDisponibles();
    
    @Query("SELECT l FROM Libro l WHERE l.cantDisponible = 0")
    List<Libro> findLibrosNoDisponibles();
    
    @Query("SELECT COUNT(l) FROM Libro l")
    Long contarTotalLibros();
    
    @Query("SELECT SUM(l.cantTotal) FROM Libro l")
    Long contarTotalEjemplares();
    
    @Query("SELECT SUM(l.cantDisponible) FROM Libro l")
    Long contarEjemplaresDisponibles();
}