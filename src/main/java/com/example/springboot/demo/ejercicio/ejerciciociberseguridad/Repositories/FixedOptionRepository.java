package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.FixedOption;

public interface FixedOptionRepository extends JpaRepository<FixedOption, Long> {
    List<FixedOption> findByToolAndOptionLevel(String tool, Integer optionLevel);
}