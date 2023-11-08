package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Cliente;
import com.biblioteca.app.biblioteca.model.Comprobante;
import com.biblioteca.app.biblioteca.model.DTO.ComprobanteDto;
import com.biblioteca.app.biblioteca.model.Prestamo;
import com.biblioteca.app.biblioteca.repository.ClienteRepository;
import com.biblioteca.app.biblioteca.repository.ComprobanteRepository;
import com.biblioteca.app.biblioteca.repository.PrestamoRepository;
import com.biblioteca.app.biblioteca.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprobanteServiceimpl implements ComprobanteService {
    @Autowired
    private ComprobanteRepository comprobanteRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public Comprobante buscarComprobantePorId(Long id) {
        return comprobanteRepository.getReferenceById(id);
    }

    @Override
    public List<Comprobante> todosLosComprobantes() {
        return comprobanteRepository.findAll();
    }

    @Override
    public Comprobante crearComprobante(ComprobanteDto comprobanteDto) {
        Cliente cliente = clienteRepository.findByDni(comprobanteDto.getClienteDni());
        List<Prestamo> prestamos = prestamoRepository.findAllByCliente(cliente);
        Double precioTotal = prestamos.stream()
                .map(Prestamo::getPrecio)
                .reduce(0.0, Double::sum);

        Comprobante comprobante = new Comprobante();
        comprobante.setCliente(cliente);
        comprobante.setPrestamos(prestamos);
        comprobante.setMontoTotal(precioTotal);
        return comprobanteRepository.save(comprobante);
    }
}
