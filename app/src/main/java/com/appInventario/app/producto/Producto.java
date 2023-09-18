package com.appInventario.app.producto;

import com.appInventario.app.categoria.Categoria;
import jakarta.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 128,nullable = false,unique = true)
    private String nombre;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categorias;

    public Integer getId() {
        return id;
    }

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, float precio, Categoria categoria) {

        this.nombre = nombre;
        this.precio = precio;
        this.categorias = categoria;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categorias;
    }

    public void setCategoria(Categoria categoria) {
        this.categorias = categoria;
    }
}
