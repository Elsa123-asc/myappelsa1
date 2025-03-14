package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.Ordenador;

@Repository
@Qualifier("jdbc")
public class OrdenadorRepositoryJDBC implements OrdenadorRepository {

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public List<Ordenador> buscarTodos() {
        return plantilla.query("select * from ordenador", new OrdenadorRowMapper());
    }

    @Override
    public void insertar(Ordenador ordenador) {
        plantilla.update("insert into ordenador values (?,?,?,?)",
                ordenador.getModelo(), ordenador.getMarca(), ordenador.getPrecio(), ordenador.getNumeroserie());
    }

    @Override
    public Ordenador buscarUno(int numeroserie) {
        return plantilla.queryForObject("select * from ordenadores where  numeroseries=?", new OrdenadorRowMapper(),
                numeroserie);

    }

    @Override
    public void borrar(int numeroserie) {
        plantilla.update("delete from ordenador where numeroserie=?", numeroserie);
    }

    @Override
    public void borrar(int... numeroserie) {
        plantilla.update("delete from ordenador where numeroserie=?", numeroserie);
    }
      
       
}


