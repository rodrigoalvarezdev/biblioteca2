package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Autor;
import com.biblioteca.app.biblioteca.model.GeneroLibro;
import com.biblioteca.app.biblioteca.model.Libro;
import com.biblioteca.app.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;
    @GetMapping("/")
    public List<Libro> libros(){
        return libroService.todosLosLibros();
    }
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){ return libroService.agregarLibro(libro);}
    @DeleteMapping("/{id}")
    public String borrarLibro(@PathVariable long id){
        libroService.borrarLibro(id);
        return "libro borrado";
    }
    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado){
        Libro libroExistente = libroService.mostrarLibroPorId(id);
        libroExistente.setNombre(libroActualizado.getNombre());
        libroExistente.setAutor(libroActualizado.getAutor());
        libroExistente.setEditorial(libroActualizado.getEditorial());
        return libroService.agregarLibro(libroExistente);
    }
    @GetMapping("/porAutor")
    public List<Libro> porAutor(@RequestParam String autor){
        return libroService.filtrarPorAutor(autor);
    }
    @GetMapping("/porGenero")
    public List<Libro> porGenero(@RequestParam String genero){
        return libroService.filtrarPorGenero(genero);
    }
    @GetMapping("/porNombre")
    public Libro buscarPorNombre(@RequestParam String nombre){
        return libroService.buscarPorNombre(nombre);
    }
}
