package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.CatalogoParametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoParametroRepository extends JpaRepository<CatalogoParametro, Long> {
}
