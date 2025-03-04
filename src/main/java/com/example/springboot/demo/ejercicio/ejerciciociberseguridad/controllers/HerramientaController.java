package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.Herramienta;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services.HerramientaService;

@RestController
@RequestMapping("/api/herramientas")
@CrossOrigin("*")
public class HerramientaController {

    private final HerramientaService service;


    public HerramientaController(HerramientaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Herramienta> getAllHerramientas(){
        return service.getAllHerramientas();
    }

}
