package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories;

import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {

}
