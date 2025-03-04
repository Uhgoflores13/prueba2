package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.Parametro;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services.ParametroService;

import java.util.List;

@RestController
@RequestMapping("/api/parametros")
@CrossOrigin("*")
public class ParametroController {

    private final ParametroService service;

    public ParametroController(ParametroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Parametro> getAllParametros(){
        return service.getAllParametros();
    }
}
