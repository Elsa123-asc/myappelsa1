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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.Ordenador;
import com.example.demo.repositories.OrdenadorRespository;

@RestController
@RequestMapping("webapi/ordenador")
public class OrdenadorRestControllers {

    @Autowired
    @Qualifier("jdbc")
    private OrdenadorRespository ordenadorRepository;
    
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
     List<Ordenador>buscarTodos() {
     return ordenadorRepository.buscarTodos();
    }


    @DeleteMapping ("/numeroserie/{numeroserie}/modelo/{modelo}")
    public void borrar (@PathVariable String modelo, @PathVariable int numeroserie){
        ordenadorRepository.borrar(modelo, numeroserie);
    }

    @GetMapping("/numeroserie/{numeroserie}/modelo/{modelo}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Ordenador buscarUnOrdenador (@PathVariable String modelo, @PathVariable int numeroserie){
        return ordenadorRepository.buscarUnOrdenador(modelo,numeroserie);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public void insertar (@RequestBody Ordenador ordenador) {
        ordenadorRepository.insertar(ordenador);
    }
   
    @GetMapping(params = "modelo,numeroserie")
    public Ordenador seleccionarUnOrdenador(@RequestParam String modelo,@RequestParam int numeroserie) {
    return ordenadorRepository.seleccionarUnOrdenador(modelo,numeroserie);
    }

    @GetMapping("/ordenadores")
    public List<Ordenador> seleccionar() {
    return ordenadorRepository.buscarTodos();  
    }
}


   


