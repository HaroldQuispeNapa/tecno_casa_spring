package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.modelo.entidades.Producto;
import com.example.demo.modelo.repositorio.IProductosReposiorio;

@Service
public class ProductoService {

    @Autowired
    private IProductosReposiorio productoRepositorio;

    public List<Producto> getListarProductos() {
        return (List<Producto>) productoRepositorio.findAll();
    }

    public Optional<Producto> getBuscarProductoById(Integer id) {
        return productoRepositorio.findById(id);
    }

    public List<Producto> getBuscarPorModelo(String termino) {
        return productoRepositorio.findByModeloContainingIgnoreCase(termino);
    }
    

}
