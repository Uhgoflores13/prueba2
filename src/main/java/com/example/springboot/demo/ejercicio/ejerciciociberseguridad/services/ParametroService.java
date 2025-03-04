package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.ParametroRepository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.Parametro;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ParametroService {
    private final ParametroRepository repository;

    public ParametroService(ParametroRepository repository) {
        this.repository = repository;
    }

    public List<Parametro> getAllParametros(){
        return repository.findAll();
    }
}
