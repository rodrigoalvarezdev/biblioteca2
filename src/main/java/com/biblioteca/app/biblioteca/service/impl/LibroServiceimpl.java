package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Autor;
import com.biblioteca.app.biblioteca.model.Editorial;
import com.biblioteca.app.biblioteca.model.GeneroLibro;
import com.biblioteca.app.biblioteca.model.Libro;
import com.biblioteca.app.biblioteca.repository.AutoRepository;
import com.biblioteca.app.biblioteca.repository.EditorialRepository;
import com.biblioteca.app.biblioteca.repository.GeneroLibroRepository;
import com.biblioteca.app.biblioteca.repository.LibroRepository;
import com.biblioteca.app.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LibroServiceimpl implements LibroService {
    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private GeneroLibroRepository generoLibroRepository;

    @Override
    public List<Libro> todosLosLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro agregarLibro(Libro libro) {
        List<GeneroLibro> generosExistentes = generoLibroRepository.findAll();
        List<GeneroLibro> generosPost = libro.getGeneros();
        List<GeneroLibro> generosAsignados = new ArrayList<>();

        if (generosExistentes == null || generosExistentes.isEmpty()) {
            generosExistentes = generosPost;
            generoLibroRepository.saveAll(generosExistentes);
        } else {
            for (GeneroLibro generoPost : generosPost) {
                boolean existe = false;
                for (GeneroLibro generoExistente : generosExistentes) {
                    if (generoExistente.getNombre().equals(generoPost.getNombre())) {
                        existe = true;
                        generoPost = generoExistente;
                        break;
                    }
                }
                if (!existe) {
                    generosExistentes.add(generoPost);
                    generoLibroRepository.save(generoPost); // Guarda el género no existente
                }
                generosAsignados.add(generoPost);
            }
        }

        libro.setGeneros(generosAsignados);
        return libroRepository.save(libro);
    }

    @Override
    public void borrarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Libro mostrarLibroPorId(Long id) {
        return libroRepository.getReferenceById(id);
    }

    @Override
    public List<Libro> filtrarPorAutor(String autor) {
        List<Libro> libros = libroRepository.findAll();
        return libros.stream()
                .filter(i -> Objects.equals(i.getAutor().getNombre(), autor))
                .collect(Collectors.toList());
    }

    @Override
    public List<Libro> filtrarPorGenero(String genero) {
        return null;
    }

    @Override
    public Libro buscarPorNombre(String nombre) {
        return libroRepository.findByNombre(nombre);
    }

}
