package com.example.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.Ordenador;
import com.example.demo.repositories.OrdenadorRepository;

@RestController
@RequestMapping("webapi/ordenador")
public class OrdenadorRestControllers {

    @Autowired
    @Qualifier("jdbc")
    private OrdenadorRepository ordenadorRepository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    List<Ordenador> buscarTodos() {
        return ordenadorRepository.buscarTodos();
    }

    @DeleteMapping("/{numeroserie}")
    public void borrar(@PathVariable int numeroserie) {
        ordenadorRepository.borrar(numeroserie);
    }

    @GetMapping("/{numeroserie}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Ordenador buscarUno(@PathVariable int numeroserie) {
        return ordenadorRepository.buscarUno(numeroserie);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public void insertar(@RequestBody Ordenador ordenador) {
        ordenadorRepository.insertar(ordenador);
    }

    @GetMapping("/ordenador")
    public List<Ordenador> seleccionar() {
        return ordenadorRepository.buscarTodos();
    }

    @PostMapping("/borrartodos")
    @CrossOrigin(origins = "http://localhost:8080")
    public void borrarTodos(@RequestParam List<Integer> ordenadorSeleccionado) {
        for (Integer numeroserie : ordenadorSeleccionado) {
            ordenadorRepository.borrar(numeroserie);
        }
        return ResponseEntity.noContent().build(); 
    }
}
