package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comandos_generados")
public class ComandoGenerado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

      @ManyToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private Herramienta herramienta;

      @Column(nullable = false)
    private String url;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String parametrosJson;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String comandoGenerado;

        @Column(nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public ComandoGenerado() {
    }

    public ComandoGenerado(Herramienta herramienta, String url, String parametrosJson, String comandoGenerado) {
        this.herramienta = herramienta;
        this.url = url;
        this.parametrosJson = parametrosJson;
        this.comandoGenerado = comandoGenerado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParametrosJson() {
        return parametrosJson;
    }

    public void setParametrosJson(String parametrosJson) {
        this.parametrosJson = parametrosJson;
    }

    public String getComandoGenerado() {
        return comandoGenerado;
    }

    public void setComandoGenerado(String comandoGenerado) {
        this.comandoGenerado = comandoGenerado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    

}
