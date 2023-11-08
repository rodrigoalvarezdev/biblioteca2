package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Comprobante;
import com.biblioteca.app.biblioteca.model.DTO.DevolucionDto;
import com.biblioteca.app.biblioteca.model.Devolucion;
import com.biblioteca.app.biblioteca.model.Prestamo;
import com.biblioteca.app.biblioteca.repository.ComprobanteRepository;
import com.biblioteca.app.biblioteca.repository.DevolucionRepository;
import com.biblioteca.app.biblioteca.repository.PrestamoRepository;
import com.biblioteca.app.biblioteca.service.DevolucionService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DevolucionServiceImpl implements DevolucionService {
    @Autowired
    private DevolucionRepository devolucionRepository;
    @Autowired
    private ComprobanteRepository comprobanteRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Devolucion> todasLasDevoluciones() {
        return devolucionRepository.findAll();
    }

    @Override
    public Devolucion crearDevolucion(DevolucionDto devolucionDto) {
        Comprobante comprobante = comprobanteRepository.getById(devolucionDto.getComprobanteId());
        Devolucion devolucion = new Devolucion();
        devolucion.setComprobante(comprobante);
        devolucion.setMonto_multa(0.0);
        return devolucionRepository.save(devolucion);
    }
}
