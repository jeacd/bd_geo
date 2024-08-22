package br.com.example.repository;

import br.com.example.model.Aeroporto;
import br.com.example.model.AeroportoVO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer> {
    
    @Query(value = "select distance(geography(a.geometria), geography(b.geometria)) from Aeroporto a, Aeroporto b where a.municipio = :aeroportoA and b.municipio = :aeroportoB")
    public Double distanciaEntreAeroportos(String aeroportoA, String aeroportoB);

    @Query(value = "select a from Aeroporto a, Municipio m where within(a.geometria, m.geometria) and m.nome = :municipio")
    public List<Aeroporto> aeroportosEmMunicipio(String municipio);
}
