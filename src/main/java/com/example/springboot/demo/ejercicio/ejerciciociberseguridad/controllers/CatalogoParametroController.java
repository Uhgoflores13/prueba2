package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.CatalogoParametro;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services.CatalogoParametroService;

@RequestMapping("/api/catalogo-parametro")
@CrossOrigin("*")
@RestController
public class CatalogoParametroController {

    private final CatalogoParametroService service;

    public CatalogoParametroController(CatalogoParametroService service) {
        this.service = service;
    }

    @GetMapping
    public List<CatalogoParametro> getAllParametros(){
        return service.getAllParametros();
    }

}
