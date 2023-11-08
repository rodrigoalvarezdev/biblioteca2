package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Cliente;
import com.biblioteca.app.biblioteca.model.DTO.PrestamoDto;
import com.biblioteca.app.biblioteca.model.Prestamo;

import java.util.List;

public interface PrestamoService {
    List<Prestamo> todosLosPrestamos();
    Prestamo agregarPrestamo(PrestamoDto prestamoDto);
    List<Prestamo> prestamosPorCliente(Cliente cliente);
}
