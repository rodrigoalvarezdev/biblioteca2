package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Autor;
import com.biblioteca.app.biblioteca.repository.AutoRepository;
import com.biblioteca.app.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService{
    @Autowired
    private AutoRepository autoRepository;

    @Override
    public List<Autor> todosLosAutores() {
        return autoRepository.findAll();
    }

    @Override
    public Autor agregarAutor(Autor autor) {
        return autoRepository.save(autor);
    }

    @Override
    public Autor buscarPorName(String nombre) {
        return autoRepository.findByNombre(nombre);
    }
}
