package com.biblioteca.app.biblioteca.repository;

import com.biblioteca.app.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Autor, Long> {
    Autor findByNombre(String nombre);
}
