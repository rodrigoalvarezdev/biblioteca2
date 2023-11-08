package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Cliente;
import com.biblioteca.app.biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/")
    public List<Cliente> todosLosClientes(){
        return clienteService.mostrarClientes();
    }
    @PostMapping
    public Cliente agregarCliente(@RequestBody Cliente cliente){
        return clienteService.agregarCliente(cliente);
    }

    @GetMapping("porNombre")
    public Cliente buscarPorNombre(@RequestParam String nombre){
        return clienteService.buscarClientePorNombre(nombre);
    }
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable long id, @RequestBody Cliente cliente){
        Cliente clienteActualizar = clienteService.findById(id);
        if (clienteActualizar != null) {
            clienteActualizar.setNombre(cliente.getNombre());
            clienteActualizar.setDni(cliente.getDni());
            clienteActualizar.setEdad(cliente.getEdad());
            return clienteService.agregarCliente(clienteActualizar);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String eliminarCliente(@PathVariable Long id){
        clienteService.eliminarClientePorId(id);
        return "se eliminó el cliente: "+id;
    }
}
