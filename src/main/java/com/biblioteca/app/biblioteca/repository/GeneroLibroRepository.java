package com.biblioteca.app.biblioteca.repository;

import com.biblioteca.app.biblioteca.model.GeneroLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroLibroRepository extends JpaRepository<GeneroLibro, Long> {
    GeneroLibro findByNombre(String nombre);
}
