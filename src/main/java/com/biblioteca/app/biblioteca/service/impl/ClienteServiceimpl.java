package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Cliente;
import com.biblioteca.app.biblioteca.repository.ClienteRepository;
import com.biblioteca.app.biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceimpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> mostrarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente buscarPorDni(Long dni) {
        return clienteRepository.findByDni(dni);
    }
}
