package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> mostrarClientes();
    Cliente agregarCliente(Cliente cliente);
    Cliente buscarClientePorNombre(String nombre);
    Cliente findById(Long id);

    void eliminarClientePorId(Long id);
    Cliente buscarPorDni(Long dni);
}
