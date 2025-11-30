package com.example.demo.modelo.entidades;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Marca") 
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMarca")
    private Integer idMarca;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Producto> productos;

    public Marca() {}

    public Marca(Integer idMarca, String nombre, List<Producto> productos) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.productos = productos;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


}
