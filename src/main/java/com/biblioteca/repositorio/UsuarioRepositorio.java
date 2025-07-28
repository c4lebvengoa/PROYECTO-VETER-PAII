package com.biblioteca.repositorio;

import com.biblioteca.entidad.UsuarioBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioBiblioteca, Long> {
    
    Optional<UsuarioBiblioteca> findByCodUsu(String codUsu);
    
    List<UsuarioBiblioteca> findByActivoTrue();
    
    @Query("SELECT u FROM UsuarioBiblioteca u WHERE u.activo = true AND " +
           "(LOWER(u.nombreUsu) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(u.apellPat) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(u.apellMat) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(u.codUsu) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<UsuarioBiblioteca> buscarUsuarios(@Param("search") String search);
    
    boolean existsByCodUsu(String codUsu);
}