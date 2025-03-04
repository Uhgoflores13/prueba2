package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.services;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.ComandoGeneradoRepository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.HerramientaParametroRepository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.HerramientaRepository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.ComandoGenerado;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.Herramienta;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.HerramientaParametro;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ComandoGeneradoService {

    private final HerramientaRepository herramientaRepository;
    private final HerramientaParametroRepository herramientaParametroRepository;
    private final ComandoGeneradoRepository comandoGeneradoRepository;

    public ComandoGeneradoService(HerramientaRepository herramientaRepository,
                                  HerramientaParametroRepository herramientaParametroRepository,
                                  ComandoGeneradoRepository comandoGeneradoRepository) {
        this.herramientaRepository = herramientaRepository;
        this.herramientaParametroRepository = herramientaParametroRepository;
        this.comandoGeneradoRepository = comandoGeneradoRepository;
    }

    public String generarComando(Long herramientaId, String url, Map<String, String> parametrosAdicionales) {
        Herramienta herramienta = herramientaRepository.findById(herramientaId)
                .orElseThrow(() -> new IllegalArgumentException("Herramienta no encontrada"));
    
        List<HerramientaParametro> parametrosBD = herramientaParametroRepository.findByHerramientaId(herramientaId);
        Map<String, String> parametros = new LinkedHashMap<>();
    
        // **Evitar duplicación de parámetros predefinidos si el usuario ya los proporciona**
        if (parametrosBD != null && !parametrosBD.isEmpty()) {
            parametrosBD.stream()
                    .sorted(Comparator.comparing(HerramientaParametro::getOrden, Comparator.nullsLast(Integer::compareTo)))
                    .forEach(param -> {
                        // **Verificar que parametrosAdicionales no sea null antes de hacer containsKey**
                        if (parametrosAdicionales == null || !parametrosAdicionales.containsKey(param.getParametro().getNombre())) {
                            parametros.put(param.getParametro().getNombre(), param.getValorDefault());
                        }
                    });
        }
    
        // **Evitar duplicación de la URL (-h o -d)**
        if (url != null && !url.isEmpty()) {
            if (!parametros.containsKey("-h") && !parametros.containsKey("-d")) {
                parametros.put("-h", url); // Nikto usa `-h`, si fuese otra herramienta cambiaríamos a `-d`
            }
        }
    
        // **Agregar parámetros adicionales del usuario (Solo si no es null)**
        if (parametrosAdicionales != null && !parametrosAdicionales.isEmpty()) {
            parametrosAdicionales.forEach((key, value) -> {
                if (value == null || value.trim().isEmpty()) {
                    parametros.put(key, "");
                } else {
                    parametros.put(key, value);
                }
            });
        }
    
        // **Construcción del comando**
        StringBuilder comando = new StringBuilder(herramienta.getNombre());
    
        String parametrosStr = parametros.entrySet().stream()
                .map(entry -> entry.getKey() + (entry.getValue().isEmpty() ? "" : " " + entry.getValue()))
                .collect(Collectors.joining(" "));
    
        comando.append(" ").append(parametrosStr);
        String comandoFinal = comando.toString().trim();
    
        // **Guardar en la BD**
        guardarComando(herramienta, comandoFinal, parametros, url);
    
        return comandoFinal;
    }
    
    

    private void guardarComando(Herramienta herramienta, String comando, Map<String, String> parametros, String url) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String parametrosJson = objectMapper.writeValueAsString(parametros);

            ComandoGenerado nuevoComando = new ComandoGenerado();
            nuevoComando.setHerramienta(herramienta);
            nuevoComando.setComandoGenerado(comando);
            nuevoComando.setParametrosJson(parametrosJson);
            nuevoComando.setUrl(url);

            comandoGeneradoRepository.save(nuevoComando);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error guardando el comando generado.");
        }
    }
}
