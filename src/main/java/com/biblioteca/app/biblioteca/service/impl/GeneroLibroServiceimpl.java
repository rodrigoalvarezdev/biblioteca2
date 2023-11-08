package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.GeneroLibro;
import com.biblioteca.app.biblioteca.repository.GeneroLibroRepository;
import com.biblioteca.app.biblioteca.service.GeneroLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroLibroServiceimpl implements GeneroLibroService {
    @Autowired
    private GeneroLibroRepository generoLibroRepository;

    @Override
    public List<GeneroLibro> todosLosGeneros() {
        return generoLibroRepository.findAll();
    }

    @Override
    public GeneroLibro crearGenero(GeneroLibro generoLibro) {
        return generoLibroRepository.save(generoLibro);
    }

    @Override
    public GeneroLibro buscarPorNombre(String nombre) {
        return generoLibroRepository.findByNombre(nombre);
    }
}
