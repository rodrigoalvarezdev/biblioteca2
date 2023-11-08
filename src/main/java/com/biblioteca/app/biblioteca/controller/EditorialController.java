package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Editorial;
import com.biblioteca.app.biblioteca.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/")
    public List<Editorial> mostrarEditoriales(){
        return editorialService.mostrarEditoriales();
    }

    @PostMapping
    public Editorial crearEditorial(@RequestBody Editorial editorial){
        return editorialService.crearEditorial(editorial);
    }
    @GetMapping("editoriales")
    public Editorial buscarEditorialPorNombre(@RequestParam String nombre){
        return editorialService.buscarEditorialPorNombre(nombre);
    }
}
