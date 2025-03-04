package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.CatalogoParametroRepository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.CatalogoParametro;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CatalogoParametroService {


    private final CatalogoParametroRepository repository;

    public CatalogoParametroService(CatalogoParametroRepository repository) {
        this.repository = repository;
    }

   public List<CatalogoParametro> getAllParametros() {
        return repository.findAll();
    }

}
