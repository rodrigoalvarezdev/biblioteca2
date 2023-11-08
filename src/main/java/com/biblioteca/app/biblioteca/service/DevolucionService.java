package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.DTO.DevolucionDto;
import com.biblioteca.app.biblioteca.model.Devolucion;

import java.util.List;

public interface DevolucionService {
    List<Devolucion> todasLasDevoluciones();
    Devolucion crearDevolucion(DevolucionDto devolucionDto);
}
