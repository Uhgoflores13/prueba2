package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services;

import org.springframework.stereotype.Service;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.HerramientaParametro;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.HerramientaParametroRepository;

import java.util.List;


@Service
public class HerramientaParametroService {

    private final HerramientaParametroRepository repository;

    public HerramientaParametroService(HerramientaParametroRepository repository) {
        this.repository = repository;
    }

    public List<HerramientaParametro> getParametrosByHerramienta(Long herramientaId) {
        return repository.findByHerramientaId(herramientaId);
    }
}
