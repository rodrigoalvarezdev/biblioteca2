package com.biblioteca.app.biblioteca.repository;

import com.biblioteca.app.biblioteca.model.Cliente;
import com.biblioteca.app.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findAllByCliente(Cliente cliente);
}
