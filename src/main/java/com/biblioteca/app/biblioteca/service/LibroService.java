package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Autor;
import com.biblioteca.app.biblioteca.model.GeneroLibro;
import com.biblioteca.app.biblioteca.model.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> todosLosLibros();
    Libro buscarPorNombre(String nombre);
    Libro agregarLibro(Libro libro);
    void borrarLibro(Long id);
    Libro mostrarLibroPorId(Long id);
    List<Libro> filtrarPorAutor(String autor);
    List<Libro> filtrarPorGenero(String genero);
}
