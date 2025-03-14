package com.example.demo.repositories;

import java.util.List;

import com.example.demo.negocio.Ordenador;

public interface OrdenadorRepository {

    List<Ordenador>buscarTodos();
    Ordenador buscarUno (int numeroserie);
    void insertar(Ordenador ordenador);
    void borrar ( int numeroserie);
    void borrar ( int... numeroserie);
}
