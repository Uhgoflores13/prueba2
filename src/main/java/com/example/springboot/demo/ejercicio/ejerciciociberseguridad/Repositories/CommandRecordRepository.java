package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.CommandRecord;

public interface CommandRecordRepository extends JpaRepository<CommandRecord, Long> {
}