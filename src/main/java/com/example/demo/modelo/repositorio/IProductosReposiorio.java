package com.example.demo.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelo.entidades.Producto;

@Repository
public interface IProductosReposiorio extends CrudRepository<Producto, Integer>{

    
} 
