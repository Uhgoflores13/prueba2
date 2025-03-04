package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers.dto;

import java.util.Map;


public class GenerarComandoRequest {
    private Long herramientaId;
    private String url;
    private Map<String, String> parametros; 

    public GenerarComandoRequest() {}

    public GenerarComandoRequest(Long herramientaId, String url, Map<String, String> parametros) {
        this.herramientaId = herramientaId;
        this.url = url;
        this.parametros = parametros;
    }

    public Long getHerramientaId() {
        return herramientaId;
    }

    public void setHerramientaId(Long herramientaId) {
        this.herramientaId = herramientaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }
}
