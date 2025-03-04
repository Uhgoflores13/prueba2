package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.HerramientaRepository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.Herramienta;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HerramientaService {
    private final HerramientaRepository repository;

    public HerramientaService(HerramientaRepository repository) {
        this.repository = repository;
    }

    public List<Herramienta> getAllHerramientas(){
        return repository.findAll();
    }
}
