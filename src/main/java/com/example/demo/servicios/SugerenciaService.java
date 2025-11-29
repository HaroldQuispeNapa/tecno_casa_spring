package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.entidades.Sugerencia;
import com.example.demo.modelo.repositorio.ISugerenciasRepositorio;

@Service
public class SugerenciaService {

    @Autowired
    private ISugerenciasRepositorio repo;

    public List<Sugerencia> getListaSugerencia() {
        return (List<Sugerencia>) repo.findAll();
    }

}
