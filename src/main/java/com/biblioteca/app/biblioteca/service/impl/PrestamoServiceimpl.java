package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Cliente;
import com.biblioteca.app.biblioteca.model.DTO.PrestamoDto;
import com.biblioteca.app.biblioteca.model.Libro;
import com.biblioteca.app.biblioteca.model.Prestamo;
import com.biblioteca.app.biblioteca.repository.ClienteRepository;
import com.biblioteca.app.biblioteca.repository.LibroRepository;
import com.biblioteca.app.biblioteca.repository.PrestamoRepository;
import com.biblioteca.app.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestamoServiceimpl implements PrestamoService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> todosLosPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo agregarPrestamo(PrestamoDto prestamoDto) {
        Cliente cliente = clienteRepository.findByDni(prestamoDto.getClienteDni());
        Libro libro = libroRepository.findByNombre(prestamoDto.getLibroNombre());
        if(!libro.getPrestado()) {
            Prestamo prestamo = new Prestamo();
            prestamo.setCliente(cliente);
            prestamo.setLibro(libro);
            prestamo.setPrecio(prestamoDto.getPrecio());
            libro.setPrestado(true);
            return prestamoRepository.save(prestamo);
        }else{
            return null;
        }
    }

    @Override
    public List<Prestamo> prestamosPorCliente(Cliente cliente) {
        return prestamoRepository.findAllByCliente(cliente);
    }
}
