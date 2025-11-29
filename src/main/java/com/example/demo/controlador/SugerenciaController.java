package com.example.demo.controlador;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.entidades.Sugerencia;
import com.example.demo.servicios.SugerenciaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/sugerencias")
public class SugerenciaController {

    @Autowired
    private SugerenciaService servicio;

    @GetMapping()
    public List<Sugerencia> listar() {
        return servicio.getListaSugerencia();
    }
    
}
