package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.GeneroLibro;

import java.util.List;

public interface GeneroLibroService {
    List<GeneroLibro> todosLosGeneros();
    GeneroLibro crearGenero(GeneroLibro generoLibro);
    GeneroLibro buscarPorNombre(String nombre);
}
