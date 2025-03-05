package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.controllers.dto;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.CommandRecordRepository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories.FixedOptionRepository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.CommandRecord;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.FixedOption;

@RestController
@RequestMapping("/api")
public class CommandController {

     @Autowired
    private FixedOptionRepository fixedOptionRepository;
    
    @Autowired
    private CommandRecordRepository commandRecordRepository;
    
    /**
     * Endpoint para consultar las opciones fijas según la herramienta y nivel.
     * Ejemplo de URL: GET /api/fixedOptions?tool=nikto&optionLevel=1
     */
    @GetMapping("/fixedOptions")
    public ResponseEntity<List<FixedOption>> getFixedOptions(
            @RequestParam String tool,
            @RequestParam Integer optionLevel) {
        List<FixedOption> options = fixedOptionRepository.findByToolAndOptionLevel(tool, optionLevel);
        return ResponseEntity.ok(options);
    }
    
    /**
     * Endpoint para crear un comando.
     * Se espera un JSON similar a:
     * {
     *   "initialCommand": "nikto",
     *   "url": "http://mi-sitio-variable.com",
     *   "firstOptionId": 2,
     *   "secondOptionId": 5,
     *   "thirdOptionId": null
     * }
     */
    @PostMapping("/commands")
    public ResponseEntity<CommandRecord> createCommand(@RequestBody CommandRequestDTO dto) {
        CommandRecord commandRecord = new CommandRecord();
        commandRecord.setInitialCommand(dto.getInitialCommand());
        commandRecord.setUrl(dto.getUrl());
        
        // Recuperar la opción fija para el primer nivel (obligatorio)
        if (dto.getFirstOptionId() != null) {
            Optional<FixedOption> optFirst = fixedOptionRepository.findById(dto.getFirstOptionId());
            if (optFirst.isPresent()) {
                commandRecord.setFirstOption(optFirst.get());
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
        
        // Recuperar la opción fija para el segundo nivel, si se envía
        if (dto.getSecondOptionId() != null) {
            Optional<FixedOption> optSecond = fixedOptionRepository.findById(dto.getSecondOptionId());
            if (optSecond.isPresent()) {
                commandRecord.setSecondOption(optSecond.get());
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
        
        // Recuperar la opción fija para el tercer nivel, si se envía
        if (dto.getThirdOptionId() != null) {
            Optional<FixedOption> optThird = fixedOptionRepository.findById(dto.getThirdOptionId());
            if (optThird.isPresent()) {
                commandRecord.setThirdOption(optThird.get());
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
        
        CommandRecord saved = commandRecordRepository.save(commandRecord);
        return ResponseEntity.ok(saved);
    }
    
    /**
     * Endpoint para obtener el comando armado.
     * Ejemplo: GET /api/commands/1/build
     */
    @GetMapping("/commands/{id}/build")
    public ResponseEntity<String> getBuiltCommand(@PathVariable Long id) {
        Optional<CommandRecord> commandOpt = commandRecordRepository.findById(id);
        if (commandOpt.isPresent()) {
            String builtCommand = commandOpt.get().buildCommand();
            return ResponseEntity.ok(builtCommand);
        }
        return ResponseEntity.notFound().build();
    }
}
    

