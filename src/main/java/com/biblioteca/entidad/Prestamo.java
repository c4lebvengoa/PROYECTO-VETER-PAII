package com.biblioteca.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "prestamos")
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long idPrestamo;
    
    @NotNull(message = "La fecha de préstamo es obligatoria")
    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDate fechaPrestamo;
    
    @NotNull(message = "La fecha de devolución es obligatoria")
    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDate fechaDevolucion;
    
    @Column(name = "fecha_devolucion_real")
    private LocalDate fechaDevolucionReal;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPrestamo estado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UsuarioBiblioteca usuario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "prestamos"})
    private Libro libro;
    
    public enum EstadoPrestamo {
        ACTIVO, DEVUELTO, VENCIDO
    }
    
    // Constructors
    public Prestamo() {}
    
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion, UsuarioBiblioteca usuario, Libro libro) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.usuario = usuario;
        this.libro = libro;
        this.estado = EstadoPrestamo.ACTIVO;
    }
    
    // Getters and Setters
    public Long getIdPrestamo() {
        return idPrestamo;
    }
    
    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }
    
    public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }
    
    public EstadoPrestamo getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }
    
    public UsuarioBiblioteca getUsuario() {
        return usuario;
    }
    
    public void setUsuario(UsuarioBiblioteca usuario) {
        this.usuario = usuario;
    }
    
    public Libro getLibro() {
        return libro;
    }
    
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    public boolean isVencido() {
        return estado == EstadoPrestamo.ACTIVO && LocalDate.now().isAfter(fechaDevolucion);
    }
}