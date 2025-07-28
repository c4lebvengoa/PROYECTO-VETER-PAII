package com.biblioteca.repositorio;

import com.biblioteca.entidad.CategoriaBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepositorio extends JpaRepository<CategoriaBiblioteca, Long> {
    
    @Query("SELECT c FROM CategoriaBiblioteca c WHERE " +
           "LOWER(c.nombreCat) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(c.descripcion) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<CategoriaBiblioteca> buscarCategorias(@Param("search") String search);
    
    @Query("SELECT c FROM CategoriaBiblioteca c ORDER BY c.nombreCat")
    List<CategoriaBiblioteca> findAllOrderByNombre();
    
    boolean existsByNombreCat(String nombreCat);
}