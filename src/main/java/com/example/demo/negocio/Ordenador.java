package com.example.demo.negocio;

public class Ordenador {
    private String modelo;
    private String marca;
    private Double precio;
    private int numeroserie;

    public Ordenador () {

    }

    public Ordenador(int numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Ordenador(String modelo, String marca, Double precio, int numeroserie) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.numeroserie = numeroserie;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public int getNumeroserie() {
        return numeroserie;
    }
    public void setNumeroserie(int numeroserie) {
        this.numeroserie = numeroserie;
    }

}
