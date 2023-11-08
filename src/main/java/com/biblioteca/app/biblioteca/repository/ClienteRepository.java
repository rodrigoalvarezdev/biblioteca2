package com.biblioteca.app.biblioteca.repository;

import com.biblioteca.app.biblioteca.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByNombre(String nombre);
    Cliente findByDni(Long dni);
}
