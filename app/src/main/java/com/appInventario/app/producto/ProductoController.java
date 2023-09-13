package com.appInventario.app.producto;

import com.appInventario.app.categoria.Categoria;
import com.appInventario.app.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping("productos/nuevo")
    public String mostrarFormularioDeNuevoProducto(Model modelo){
        List<Categoria> listaCategorias = categoriaRepository.findAll();

        modelo.addAttribute("producto",new Producto());
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "producto_formulario";


    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto){
        productoRepository.save(producto);
        return "redirect:/";
    }

    @GetMapping("/productos")
    public String listarProductos(Model modelo){
        List<Producto> listaProductos = productoRepository.findAll();
        modelo.addAttribute("listaProductos",listaProductos);

        return "productos";

    }

}
