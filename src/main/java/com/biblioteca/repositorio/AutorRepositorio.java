package com.biblioteca.repositorio;

import com.biblioteca.entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    
    @Query("SELECT a FROM Autor a WHERE " +
           "LOWER(a.nombre) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(a.apellPat) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(a.apellMat) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Autor> buscarAutores(@Param("search") String search);
    
    @Query("SELECT a FROM Autor a ORDER BY a.apellPat, a.apellMat, a.nombre")
    List<Autor> findAllOrderByApellidos();
}