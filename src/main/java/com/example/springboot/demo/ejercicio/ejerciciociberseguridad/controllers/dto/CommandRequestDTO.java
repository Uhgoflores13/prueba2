package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers.dto;

public class CommandRequestDTO {
    private String initialCommand;
    private String url;
    private Long firstOptionId;
    private Long secondOptionId;
    private Long thirdOptionId; // Opcional

    // Getters y Setters
    public String getInitialCommand() {
        return initialCommand;
    }

    public void setInitialCommand(String initialCommand) {
        this.initialCommand = initialCommand;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getFirstOptionId() {
        return firstOptionId;
    }

    public void setFirstOptionId(Long firstOptionId) {
        this.firstOptionId = firstOptionId;
    }

    public Long getSecondOptionId() {
        return secondOptionId;
    }

    public void setSecondOptionId(Long secondOptionId) {
        this.secondOptionId = secondOptionId;
    }

    public Long getThirdOptionId() {
        return thirdOptionId;
    }

    public void setThirdOptionId(Long thirdOptionId) {
        this.thirdOptionId = thirdOptionId;
    }
    
}
