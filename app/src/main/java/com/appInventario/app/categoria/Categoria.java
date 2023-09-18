package com.appInventario.app.categoria;


import com.appInventario.app.marca.Marca;
import jakarta.persistence.*;



@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45,nullable = false,unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name="marca_id")
    private Marca marca;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria() {
    }

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Categoria(Integer id) {
        this.id = id;

    }

    public Categoria(Integer id, String nombre, Marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Categoria(String nombre, Marca marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    public Categoria(String nombre) {

        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

