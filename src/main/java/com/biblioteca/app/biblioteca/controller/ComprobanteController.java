package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Comprobante;
import com.biblioteca.app.biblioteca.model.DTO.ComprobanteDto;
import com.biblioteca.app.biblioteca.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {
    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/")
    public List<Comprobante> listaDeComprobantes(){
        return comprobanteService.todosLosComprobantes();
    }

    @PostMapping
    public ResponseEntity<?> crearComprobante(@RequestBody ComprobanteDto comprobanteDto){
        Comprobante comprobante = comprobanteService.crearComprobante(comprobanteDto);
        return new ResponseEntity<>(comprobante, HttpStatus.CREATED);
    }
}
