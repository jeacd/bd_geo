/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Estado;
import br.com.example.model.Municipio;

// import br.com.example.model.EstadoVO;
import java.util.List;

import org.geolatte.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author caian
 */
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

    @Query(value ="select distance(geography(ea.geometria), geography(eb.geometria)) from Estado ea, Estado eb where ea.nome = :estadoA and eb.nome = :estadoB")
    public Double distanciaEntreEstados (String estadoA, String estadoB);

    @Query(value = "select eb FROM Estado ea, Estado eb where touches(ea.geometria, eb.geometria) and ea.nome = :nome")
    List<Estado> listarEstadosVizinhos(String nome);
}
