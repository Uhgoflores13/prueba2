package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "herramienta_parametros")
public class HerramientaParametro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private Herramienta herramienta;

    @ManyToOne
    @JoinColumn(name = "parametro_id", nullable = false)
    private CatalogoParametro parametro;

      @Column(name = "valor_default")
    private String valorDefault;

    @Column(name = "orden")
    private int orden;

    public HerramientaParametro() {
    }

    public HerramientaParametro(Herramienta herramienta, CatalogoParametro parametro, String valorDefault) {
        this.herramienta = herramienta;
        this.parametro = parametro;
        this.valorDefault = valorDefault;
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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public CatalogoParametro getParametro() {
        return parametro;
    }

    public void setParametro(CatalogoParametro parametro) {
        this.parametro = parametro;
    }

    public String getValorDefault() {
        return valorDefault;
    }

    public void setValorDefault(String valorDefault) {
        this.valorDefault = valorDefault;
    }

    
}
