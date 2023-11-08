package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Cliente;
import com.biblioteca.app.biblioteca.model.DTO.PrestamoDto;
import com.biblioteca.app.biblioteca.model.Prestamo;
import com.biblioteca.app.biblioteca.service.ClienteService;
import com.biblioteca.app.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/")
    public List<Prestamo> mostrarPrestamos(){
        return prestamoService.todosLosPrestamos();
    }

    @PostMapping
    public ResponseEntity<?> crearPrestamo(@RequestBody PrestamoDto prestamoDto){
        Prestamo savePrestamo = prestamoService.agregarPrestamo(prestamoDto);
        if(savePrestamo != null) {
            return new ResponseEntity<>(savePrestamo, HttpStatus.CREATED);
        }else{
            return ResponseEntity.ofNullable(savePrestamo);
        }
    }

    @GetMapping("/porCliente")
    public List<Prestamo> filtrarPrestaPorCliente(@RequestParam Long dni){
        Cliente cliente = clienteService.buscarPorDni(dni);
        return prestamoService.prestamosPorCliente(cliente);
    }

}
