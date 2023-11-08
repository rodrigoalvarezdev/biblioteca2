package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Autor;
import com.biblioteca.app.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;
    @GetMapping("/")
    public List<Autor> autores(){
        return autorService.todosLosAutores();
    }
    @PostMapping
    public Autor agregarAutor(@RequestBody Autor autor){ return autorService.agregarAutor(autor);}

    @GetMapping("nombre")
    public Autor buscarAutorPorNombre(@RequestParam String nombre){
        return autorService.buscarPorName(nombre);
    }

}
