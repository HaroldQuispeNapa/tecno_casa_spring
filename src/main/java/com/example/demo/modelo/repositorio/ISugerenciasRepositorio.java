package com.example.demo.modelo.repositorio;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.entidades.Sugerencia;

public interface ISugerenciasRepositorio 
    extends CrudRepository<Sugerencia, Integer> {
    // POR IMPLEMENTAR
}
