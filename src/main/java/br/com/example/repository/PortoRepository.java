package br.com.example.repository;

import br.com.example.model.Porto;
import br.com.example.model.PortoVO;

import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortoRepository extends JpaRepository<Porto, Integer> {

    @Query("select p from Porto p, Municipio m where within(p.geometria, m.geometria) and m.nome = :municipio")
    public List<Porto> portosNoMunicipio(@Param("municipio") String municipio);

}
