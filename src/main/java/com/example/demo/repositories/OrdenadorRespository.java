package com.example.demo.repositories;

import java.util.List;

import com.example.demo.negocio.Ordenador;

public interface OrdenadorRespository {

    List<Ordenador>buscarTodos();
    Ordenador buscarUnOrdenador (String modelo,int numeroserie);
    List<Ordenador> seleccionar (Ordenador ordenador);
    Ordenador seleccionarUnOrdenador (String modelo,int numeroserie);
    void insertar(Ordenador ordenador);
    void borrar (String modelo, int numeroserie);
}
