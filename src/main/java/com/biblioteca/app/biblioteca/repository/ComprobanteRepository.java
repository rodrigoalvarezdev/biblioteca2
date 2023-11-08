package com.biblioteca.app.biblioteca.repository;

import com.biblioteca.app.biblioteca.model.Comprobante;
import com.biblioteca.app.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {
}
