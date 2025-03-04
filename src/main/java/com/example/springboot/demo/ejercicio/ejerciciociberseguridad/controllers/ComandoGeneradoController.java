package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services.ComandoGeneradoService;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers.dto.GenerarComandoRequest;

@RestController
@RequestMapping("/api/comando")
@CrossOrigin("*")
public class ComandoGeneradoController {

    private final ComandoGeneradoService service;

    public ComandoGeneradoController(ComandoGeneradoService service) {
        this.service = service;
    }

    @PostMapping
      public ResponseEntity<String> generarComando(@RequestBody GenerarComandoRequest request) {
        String comando = service.generarComando(request.getHerramientaId(), request.getUrl(), request.getParametros());
        return ResponseEntity.ok(comando);
    }
}
