package com.example.demo.repositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.demo.negocio.Ordenador;
               

public class OrdenadorRowMapper implements RowMapper<Ordenador> {

    @Override
    public Ordenador mapRow (ResultSet resultSet, int rowNum) throws SQLException {
    
        return new Ordenador(
            resultSet.getString("modelo"),
            resultSet.getString("marca"),
            resultSet.getDouble("precio"),
            resultSet.getInt("numeroserie"));
        
    }

}