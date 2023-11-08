package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.GeneroLibro;
import com.biblioteca.app.biblioteca.service.GeneroLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroLibroController {
    @Autowired
    private GeneroLibroService generoLibroService;

    @GetMapping("/")
    public List<GeneroLibro> mostrarGeneros(){
        return generoLibroService.todosLosGeneros();
    }

    @PostMapping
    public GeneroLibro crearGenero(@RequestBody GeneroLibro generoLibro){
        return generoLibroService.crearGenero(generoLibro);
    }
    @GetMapping("/generos")
    public GeneroLibro buscarPorNombre(@RequestParam String nombre){
        return generoLibroService.buscarPorNombre(nombre);
    }
}
