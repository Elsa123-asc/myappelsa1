package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.Ordenador;

@Repository
@Qualifier("jdbc")
public class OrdenadorRespositoryJDBC implements OrdenadorRespository {

  @Autowired
    private JdbcTemplate plantilla;

    @Override
    public List<Ordenador>buscarTodos() {
        return plantilla.query("select * from ordenador", new OrdenadorRowMapper());
    }
    
    @Override
    public void insertar (Ordenador ordenador) {
    plantilla.update("insert into ordenador values (?,?,?,?)",
    ordenador.getModelo(), ordenador.getMarca(),ordenador.getPrecio(), ordenador.getNumeroserie());
    }

    @Override
    public Ordenador buscarUnOrdenador(String modelo, int numeroserie) {
        return plantilla.queryForObject("select * from ordenadores where modelo=? and numeroseries=?", 
        new OrdenadorRowMapper(),modelo,numeroserie);
    }
   
    @Override
    public Ordenador seleccionarUnOrdenador(String modelo, int numeroserie) {
        return null;
    }

    @Override
    public List<Ordenador> seleccionar(Ordenador ordenador) {
        return plantilla.query("select * from ordenador", new OrdenadorRowMapper(),ordenador);
    }

    @Override
    public void borrar(String modelo, int numeroserie) {
        plantilla.update("delete from ordenadores where modelo=? and numeroserie=?",modelo,numeroserie);
    }

}
