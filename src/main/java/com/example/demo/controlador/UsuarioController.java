/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controlador;

import com.example.demo.modelo.entidades.Usuario;
import com.example.demo.servicios.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author L
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:8080") 
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/clientes")
    public List<Usuario> listarClientes() {
        return usuarioService.obtenerClientes();
    }

    @GetMapping("/administradores")
    public List<Usuario> listarAdministradores() {
        return usuarioService.obtenerAdministradores();
    }
}
