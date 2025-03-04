package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.HerramientaParametro;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services.HerramientaParametroService;

@RestController
@RequestMapping("/api/herramienta-parametro")
@CrossOrigin("*")
public class HerramientaParametroController {

    private final HerramientaParametroService service;

    public HerramientaParametroController(HerramientaParametroService service) {
        this.service = service;
    }

    @GetMapping("/{herramientaId}")
    public List<HerramientaParametro> getParametrosByHerramienta(@PathVariable Long herramientaId) {
        return service.getParametrosByHerramienta(herramientaId);
    }

}
