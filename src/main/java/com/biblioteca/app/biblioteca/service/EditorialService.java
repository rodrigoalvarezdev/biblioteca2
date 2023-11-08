package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Editorial;

import java.util.List;

public interface EditorialService {
    List<Editorial> mostrarEditoriales();
    Editorial crearEditorial(Editorial editorial);
    Editorial buscarEditorialPorNombre(String nombre);
}
