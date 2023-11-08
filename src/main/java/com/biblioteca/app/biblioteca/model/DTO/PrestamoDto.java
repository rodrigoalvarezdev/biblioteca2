package com.biblioteca.app.biblioteca.model.DTO;

public class PrestamoDto {
    private Long clienteDni;
    private String libroNombre;
    private Double precio;

    public Long getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(Long clienteDni) {
        this.clienteDni = clienteDni;
    }

    public String getLibroNombre() {
        return libroNombre;
    }

    public void setLibroNombre(String libroNombre) {
        this.libroNombre = libroNombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
