package com.example.springboot.demo.ejercicio.ejerciciociberseguridad.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.demo.ejercicio.ejerciciociberseguridad.models.entity.ComandoGenerado;


@Repository
public interface ComandoGeneradoRepository extends JpaRepository<ComandoGenerado, Long> {

}
