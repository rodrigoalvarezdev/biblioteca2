package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Editorial;
import com.biblioteca.app.biblioteca.repository.EditorialRepository;
import com.biblioteca.app.biblioteca.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EditorialServiceimpl implements EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;
    @Override
    public List<Editorial> mostrarEditoriales() {
        return editorialRepository.findAll();
    }

    @Override
    public Editorial crearEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public Editorial buscarEditorialPorNombre(String nombre) {
        return editorialRepository.findByNombre(nombre);
    }
}
