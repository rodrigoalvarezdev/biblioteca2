package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.DTO.DevolucionDto;
import com.biblioteca.app.biblioteca.model.Devolucion;
import com.biblioteca.app.biblioteca.service.ComprobanteService;
import com.biblioteca.app.biblioteca.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {
    @Autowired
    private DevolucionService devolucionService;
    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/")
    public List<Devolucion> todasLasDevoluciones(){
        return devolucionService.todasLasDevoluciones();
    }

    @PostMapping
    public ResponseEntity<?> crearDevolucion(@RequestBody DevolucionDto devolucionDto){
        return new ResponseEntity<>(devolucionService.crearDevolucion(devolucionDto), HttpStatus.CREATED);
    }
}
