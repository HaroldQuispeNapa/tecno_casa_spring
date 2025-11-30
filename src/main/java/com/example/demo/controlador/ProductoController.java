package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.entidades.Producto;
import com.example.demo.servicios.ProductoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService servicio;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return servicio.getListarProductos();
    }

    @GetMapping("/buscar/{id}") 
    public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id) {
        
        Optional<Producto> producto = servicio.getBuscarProductoById(id);

        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
