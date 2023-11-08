package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Autor;

import java.util.List;

public interface AutorService {
    List<Autor> todosLosAutores();
    Autor agregarAutor(Autor autor);
    Autor buscarPorName(String nombre);
}
