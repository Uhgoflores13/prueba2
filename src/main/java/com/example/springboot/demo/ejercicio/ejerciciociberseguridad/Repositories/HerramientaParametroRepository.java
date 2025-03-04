package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.HerramientaParametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerramientaParametroRepository extends JpaRepository<HerramientaParametro, Long> {
    List<HerramientaParametro> findByHerramientaId(Long herramientaId);
}
