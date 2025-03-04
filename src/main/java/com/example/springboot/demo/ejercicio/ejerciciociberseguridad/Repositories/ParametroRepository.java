package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories;

import org.springframework.stereotype.Repository;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.Parametro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Long> {
    List<Parametro> findByHerramientaId(Long herramientaId);

}
