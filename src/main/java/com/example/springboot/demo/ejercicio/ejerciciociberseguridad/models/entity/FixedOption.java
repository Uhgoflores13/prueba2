package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity;

import jakarta.persistence.*;


@Entity
public class FixedOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // La herramienta a la que pertenece esta opción (por ejemplo: "nikto", "wapiti", etc.)
    private String tool;

    // El flag predefinido (por ejemplo: "-h", "-host", "-u", "-sS", etc.)
    private String flag;

    // Nivel de opción, por ejemplo: 1 para la opción que acompaña la URL, 2 para la siguiente, etc.
    private Integer optionLevel;

    // Valor por defecto (opcional) para opciones que tengan un valor fijo (por ejemplo, "443" para -port)
    private String defaultValue;

    // Constructores
    public FixedOption() {}

    public FixedOption(String tool, String flag, Integer optionLevel, String defaultValue) {
        this.tool = tool;
        this.flag = flag;
        this.optionLevel = optionLevel;
        this.defaultValue = defaultValue;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getOptionLevel() {
        return optionLevel;
    }

    public void setOptionLevel(Integer optionLevel) {
        this.optionLevel = optionLevel;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}

