package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity;
import jakarta.persistence.*;

@Entity
public class CommandRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String initialCommand;

   
    private String url;

    @ManyToOne
    @JoinColumn(name = "first_option_id")
    private FixedOption firstOption;

    @ManyToOne
    @JoinColumn(name = "second_option_id")
    private FixedOption secondOption;

    // Referencia a la opción fija para el tercer nivel (si existe)
    @ManyToOne
    @JoinColumn(name = "third_option_id")
    private FixedOption thirdOption;

    // Constructores
    public CommandRecord() {}

    public CommandRecord(String initialCommand, String url) {
        this.initialCommand = initialCommand;
        this.url = url;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

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

    public FixedOption getFirstOption() {
        return firstOption;
    }

    public void setFirstOption(FixedOption firstOption) {
        this.firstOption = firstOption;
    }

    public FixedOption getSecondOption() {
        return secondOption;
    }

    public void setSecondOption(FixedOption secondOption) {
        this.secondOption = secondOption;
    }

    public FixedOption getThirdOption() {
        return thirdOption;
    }

    public void setThirdOption(FixedOption thirdOption) {
        this.thirdOption = thirdOption;
    }

    
    public String buildCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append(initialCommand);
        
        if (firstOption != null) {
            sb.append(" ").append(firstOption.getFlag());
            // La primera opción utiliza la URL variable como valor.
            sb.append(" ").append(url);
        }
        
        if (secondOption != null) {
            sb.append(" ").append(secondOption.getFlag());
            
            if (secondOption.getDefaultValue() != null) {
                sb.append(" ").append(secondOption.getDefaultValue());
            }
        }
        
        if (thirdOption != null) {
            sb.append(" ").append(thirdOption.getFlag());
            if (thirdOption.getDefaultValue() != null) {
                sb.append(" ").append(thirdOption.getDefaultValue());
            }
        }
        
        return sb.toString();
    }
}