package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Comprobante;
import com.biblioteca.app.biblioteca.model.DTO.ComprobanteDto;

import java.util.List;

public interface ComprobanteService {
    Comprobante buscarComprobantePorId(Long id);
    List<Comprobante> todosLosComprobantes();
    Comprobante crearComprobante(ComprobanteDto comprobanteDto);
}
